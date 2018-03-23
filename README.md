# cljs-i18n

## Install

[![Clojars Project](https://img.shields.io/clojars/v/thedavidmeister/cljs-i18n.svg)](https://clojars.org/thedavidmeister/cljs-i18n)

## Overview

### Public API quick reference

#### i18n.locale

`i18n.locale/valid-locale?`

Takes a string and returns `true` if it looks like a locale we might support.

`i18n.locale/fix-locale`

Takes an invalid locale string and attempts to hammer it into an ISO locale.

`i18n.locale/supported-locale`

Takes a string or seq and returns the best match from supported locales.

`i18n.locale/accept-language->locales`

Takes an `Accept-Language` header string and converts to a seq of locales.

`i18n.locale/browser-locale`

Attempts to detect the user's preferred locale from the browser or OS.

#### i18n.datetime

`i18n.datetime/timezone`

Takes a tz string and returns a `goog.i18n.TimeZone`.

`i18n.datetime/parse`

Takes a string and optional `:locale` and returns a `js/Date`.

`i18n.datetime/format`

Takes a `js/Date`, optional `:locale`, `:pattern` and `:tz`. Returns a string.

### i18n.number

`i18n.number/parse`

Takes a string and optional `:locale` and returns a `number`.

`i18n.number/format`

Takes a `number`, optional `:locale`, `:pattern` and config. Returns a string.

### Explanation

Google Closure `goog.i18n` is a wrapper for the Unicode CLDR data `goog.i18n` that provides localisation logic for:

- Datetime/Timezone formatting and parsing
- Number formatting and parsing
- Collation
- Currency formatting
- Plurals

Which is amazing for several reasons:

- We get it "free" in clojure
- Very few l10n libs out there support both bidirectional formatting _and_ parsing
- CLDR is really the only way to get high quality coverage for every language/locale out there
  - Maintained by Unicode
  - ISO standard templating language for format/parse logic (many libs hand-roll their own and then fail to account for certain nuances)
  - Supports literally thousands of locale/country combinations
  - Is updated as cultures/locales evolve over time
  - Available as open source JSON files

Unfortunately, the interface to `goog.i18n` is about as far from idiomatic
clojure as one could possibly get. Most of the behaviour is determined by
fiddling with mutable properties of _both_ global and local objects that are
deeply complected with each other. E.g. the "current locale" is set globally but
configuration like "formatter pattern" is set as a property on a local
`formatter` object.

The documentation for Google Closure's i18n code is almost nonexistant. It is
neccessary to read the code directly to understand how to use it.

Natively `goog.i18n` does not expose the ability to work with more than one
locale at a time. Internally it has several mostly undocumented global
properties such as `goog.i18n.NumberFormatSymbols` and
`goog.i18n.DateTimeSymbols` that must be set manually on each locale change.

Presumably Google know what they are doing and so all this mutation and limits
placed on dynamic locale support is for performance reasons or something. Based
on that assumption (I haven't done extensive benchmarking/profiling) I've
memoized and implemented automated tests for as much as I can. As localisation
of a string for a given locale/pattern is totally referentially transparent the
default is to cache aggressively using native cljs `memoize`.

Of course, the aggressive memoization could lead to memory issues, depending on
what you are doing in your application. It's great if you have a few strings
that are being re-used across the UI, potentially very bad if you have a lot of
unique strings to process.

Each of the core fns in the public API has an unmemoized version prefixed by `-`
so that `parse` is cached while `-parse` is not.

The end result of this library is the ability to do something like this:

```clojure
(parse "1.000.000.000,00" :locale "gl") ; 1000000000 in Galician
(parse "1,000,000,000.00" :locale "en") ; 1000000000 in English
(parse "1,00,00,00,000.00" :locale "en-IN") ; 1000000000 in Indian English

(format 1000000000 :locale "gl") ; "1.000.000.000" in Galician
(format 1000000000 :locale "en") ; "1,000,000,000" in English
(format 1000000000 :locale "en-IN") ; "1,00,00,00,000" in Indian English
```

Additionally this lib provides several things `goog.i18n` is missing that we
need in order to work with an end-user's locale in the browser:

- Extracting the user's preferred locale based on OS/browser/config settings
- Normalizing langcodes format (e.g. `en_US` to `en-US`)
- Extracting a supported langcode from `Accept-Language` HTTP headers

## Supported locales

Everything from `goog.i18n.NumberFormatSymbols` as at 2018-03-23.

From the Google docs:

> * File generated from CLDR ver. 32
> *
> * To reduce the file size (which may cause issues in some JS
> * developing environments), this file will only contain locales
> * that are frequently used by web applications. This is defined as
> * proto/closure_locales_data.txt and will change (most likely addition)
> * over time.  Rest of the data can be found in another file named
> * "numberformatsymbolsext.js", which will be generated at
> * the same time together with this file.

I don't have a script/build process to track what Google Closure supports under
the primary namespace automatically. Also note that there are literally hundreds
of additional locales available in `goog.i18n.NumberFormatSymbolsExt`.

Adding new locales is a simple matter of adding the relevant k/v pair to
`i18n.data/locales`. If a locale you're looking for is missing please feel free
to put a pull request up for inclusion.

## Accepted locale code formats

Ideally pass in locales to `:locale` params as ISO styles strings.

i.e. `<lowercase language code>-<uppercase country code>`.

So Hong Kong `HK` Chinese `zh` becomes `zh-HK`.

Passing in a valid locale string ensures maximum speed and compatibility.

In the wild, locales are also often represented:

- with `_` rather than `-`, e.g. `en_US`
- with inconsistent casing, e.g. `EN-US`
- as a sequence of options, e.g. `["en-US" "en"]`
- an [`Accept-Language` header](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Accept-Language), e.g. `"fr-CH, fr;q=0.9, en;q=0.8, de;q=0.7, *;q=0.5"`

Any public API function that accepts a locale as an argument will normalize to a
supported locale as per `i18n.locale/supported-locale`. The basic logic is to
select the first supported locale in a sequence/accept string by fixing the
casing and delimiter if possible as per `i18n.locale/fix-locale`.

If a locale is not supported (see above) then:

- The next supported locale in the sequence will be used
- If no locale in a sequence is supported, the default locale will be used
- If the locale is singular then the default locale will be used instead
- If the locale is corrupt and cannot be parsed at all a warning will be logged
  via `taoensso.timbre/warn` and the default locale used instead

The default locale (at the time of writing) is set by Google as `"en"`.

## i18n.locale - Working with locales

`i18n.locale/valid-locale?`

Takes a string and returns `true` if it looks like a locale we might support.

Only singular locale strings are valid, no sequences or headers will validate.

Typically to be valid a string must:

- Have a lowercase langcode
- Have no country code, or an uppercase country code
- Be delimited by `-`

But there are exceptions if the locale string is a key in `i18n.data/locales`.

Notably `"sr-Latn"` and `"es-419"` are considered valid locales.

Keyword locales like `:default` that are found in `i18n.data/locales` are NOT
considered valid.

`i18n.locale/fix-locale`

Takes an invalid locale string and attempts to hammer it into an ISO locale.

Can fix:

- Invalid case
- Delimited by `_`

Is aware of `valid-locale?` edge cases like `"sr-Latn"` (see above).

`i18n.locale/supported-locale`

Takes a string or seq and returns the best match from supported locales.

`i18n.locale/accept-language->locales`

Takes an `Accept-Language` header string and converts to a seq of locales.

`i18n.locale/browser-locale`

Attempts to detect the user's preferred locale from the browser or OS.

## i18n.number - Number format and parse

Both formatting and parsing of numbers is supported in `i18n.number`.

The public API consists of 2 fns:

- `i18n.number/format`
- `i18n.number/parse`

Both take a number/string to be formatted/parsed as the first arg and optional
k/v pairs for other options.

Uncached versions `i18n.number/-format` and `i18n.number/-parse` are available
if memory pressure is a concern.

See `i18n.number` tests for examples of both.

### Shared options

`:locale`

Any supported locale code (see above).

`:pattern`

A CLDR number formatting pattern or one of the preconfigured formats as per
`i18n.number/formats`. Currently supported formats: `:decimal`, `:scientific`,
`:percent`, `:currency`, `:compact-short`, `:compact-long`.

Official documentation for CLDR patterns:

http://cldr.unicode.org/translation/number-patterns

Example patterns:

https://github.com/google/closure-library/blob/master/closure/goog/i18n/numberformatsymbols.js

### Parsing

You should not typically need to set a pattern manually for `parse`, `:locale`
alone should be sufficient.

```clojure
(parse "1,000,000") ; 1000000
(parse "10,00,000") ; 1000000
(parse "1,000,000" :locale "gl") ; 1
```

### Formatting

Format has a few extra options not available to parse.

`:min-fraction-digits`

Integer minimum number of digits to allow for fractions.

Default is `0`, max is `:max-fraction-digits` (see below).

Fills out missing digits with trailing zeros.

```clojure
(format 1) ; "1"
(format 1 :min-fraction-digits 1) ; "1.0"
```

`:max-fraction-digits`

Integer maximum number of digits to allow for fractions.

Default is `3`, max is `308`.

Does NOT fill out missing digits with trailing zeros.

Applies rounding to truncated values.

```clojure
(format (/ 10 3)) ; "3.333"
(format (/ 10 3) :max-fraction-digits 1) ; "3.3"
(format (/ 10 3) :max-fraction-digits 2) ; "3.33"
(format (/ 10 3) :max-fraction-digits 3) ; "3.333"
(format 1 :max-fraction-digits 3) ; "1"
(format 1.5678) ; "1.568"
```

`:significant-digits`

Integer number of significant digits for the formatted number.

Default is `0`, max is `:max-fraction-digits`.

CANNOT be combined with `:min-fraction-digits`.

Applies rounding to truncated values.

```clojure
(format (/ 10 3) :significant-digits 3) ; "3.33"
(format (/ 1 3) :significant-digits 3) ; "0.333"
(format 1.2 :significant-digits 3) ; "1.2"
(format (/ 2 3) :significant-digits 3) ; "0.667"
```

`trailing-zeros?`

Boolean to show trailing zeros if `:significant-digits` is positive.

Has no effect on `:min-fraction-digits` or `:max-fraction-digits`.

```clojure
(format 1.2 :significant-digits 3 :trailing-zeros? true) ; "1.20"
```

`nil-string`

String to return for `nil`.

Default is `""`.

```clojure
(format nil) ; ""
(format nil :nil-string "-") ; "-"
```

`nan-string`

String to return for `##NaN`.

Default is `"NaN"`.

```clojure
(format ##NaN) ; "NaN"
(format ##NaN :nan-string "-") ; "-"
```
