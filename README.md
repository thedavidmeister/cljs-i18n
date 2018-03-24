# cljs-i18n

## Install

[![Clojars Project](https://img.shields.io/clojars/v/thedavidmeister/cljs-i18n.svg)](https://clojars.org/thedavidmeister/cljs-i18n)

## Overview

Google Closure `goog.i18n` is a wrapper for the Unicode CLDR data `goog.i18n` that provides localisation logic for:

- Number formatting and parsing
- Datetime/Timezone formatting and parsing
- Collation
- Currency formatting
- Text message translation
- Plurals
- Bidirectional text

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
neccessary to read the code comments and review tests directly to understand how
to use it.

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
- Normalizing locale's format (e.g. `en_US` to `en-US`)
- Extracting a supported locale from `Accept-Language` HTTP headers

### Comparison with other libraries

Here's a comparison of various i18n libraries available in JavaScript, including
Google Closure:

https://github.com/rxaviers/javascript-globalization

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

Supports both `Accept-Language` header and singular locale strings (see below).

Sequences of locales are supported.

Nested structures are NOT supported.

Tries pretty hard to find a match for each candidate locale:

- `nil` falls back to default locale
- Sequences and accept headers are processed in order
- Munged locales are fixed as per `fix-locale` (see above)
- First match against supported locales is returned
- If there are no matches, country codes are stripped for a second pass
- If there are no matches after two passes, falls back to default locale

`i18n.locale/accept-language->locales`

Takes an `Accept-Language` header string and converts to a seq of locales.

Parses the string according to the rules documented at:

https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Accept-Language

The output sequence is ordered by "quality" scores from the header string.

This header contains the most detailed, reliable and relevant user configuration
available in the browser, provided you can actually get at it.

As far as I know, there is no way to get at an `Accept-Language` header with raw
JavaScript. Based on my testing and research both the `XMLHttpRequest()` and
`fetch()` APIs won't make this header available for inspection.

The only way to get at this header is to read a request from the server and
return the header string in the server response.

If you don't have a server, this snippet will return `Accept-Language` strings
from any request to a free tier endpoint from [Webtask IO](https://webtask.io/):

```javascript
/**
* @param context {WebtaskContext}
*/
module.exports = function(context, cb) {
  cb(null, context.headers['accept-language'] || context.headers['Accept-Language']);
};
```

Make sure to save any fetched headers in local/session storage to avoid spamming
round trips to the server for redundant locale information.

`i18n.locale/system-locales`

Attempts to detect the user's preferred locale from the browser or OS.

This is entirely different from and less reliable than `Accept-Language`
discussed above, but has the advantage of being available in the browser without
a server round-trip.

Runs through the various options documented at:

https://zzz.buzz/2016/01/13/detect-browser-language-in-javascript/

Normalizes the return values to a sequence of locales or `nil`.

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

Default `:pattern` is `:decimal`.

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

`:enforce-ascii-digits`

Boolean to enforce only ascii digits in the output.

Default is `false`.

```clojure
(format 1000000 :locale "fa") ; "۱٬۰۰۰٬۰۰۰"
(format 1000000 :locale "fa" :enforce-ascii-digits true) ; "1,000,000"
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

Default is a localised version of `"NaN"`.

```clojure
(format ##NaN) ; "NaN"
(format ##NaN :locale "fa") ; "ناعدد"

(format ##NaN :nan-string "-") ; "-"
(format ##NaN :nan-string "-" :locale "fa") ; "-"
```

## i18n.datetime - Datetime format, parse and timezones

Both formatting and parsing of numbers is supported in `i18n.datetime`.

The public API consists of 3 fns:

- `i18n.datetime/format`
- `i18n.datetime/parse`
- `i18n.datetime/timezone`

Format and parse take a number/string to be formatted/parsed as the first arg
and optional k/v pairs for other options. They intentionally mirror the
signatures of the `i18n.number` format and parse fns.

Uncached versions `i18n.datetime/-format` and `i18n.datetime/-parse` are
available if memory pressure is a concern.

See `i18n.datetime` tests for examples.

### Format/parse shared options

`:locale`

Any supported locale code (see above).

`:pattern`

A CLDR number formatting pattern or one of the preconfigured formats as per
`i18n.datetime/formats` and `i18n.datetime/pattern->common-pattern`.

These wrap and normalise two separate sets of patterns in goog:

- `goog.i18n.DateTimeFormat.Format`
- `goog.i18n.DateTimePatterns`

Currently supported formats:

`:full-date`, `:long-date`, `:medium-date`, `:short-date`, `:full-time`,
`:long-time`, `:medium-time`, `:short-time`, `:full-datetime`, `:long-datetime`,
`:medium-datetime`, `:short-datetime`, `:year-full`, `:year-full-with-era`,
`:year-month-abbr`, `:year-month-full`, `:month-day-abbr`, `:month-day-full`,
`:month-day-short`, `:month-day-medium`, `:month-day-year-medium`,
`:weekday-month-day-medium`, `:weekday-month-day-year-medium`, `:day-abbr`.

Default `:pattern` is `:long-date`.

Official documentation for CLDR patterns:

http://cldr.unicode.org/translation/date-time-patterns

Example patterns:

https://github.com/google/closure-library/blob/master/closure/goog/i18n/datetimepatterns.js

### Formatting

Takes a `js/Date` or a compatible Date object, e.g. `goog.date.DateTime` and
returns a formatted string.

```clojure
(format (js/Date. 106000000000) :locale "en-US" :tz 0) ; "May 11, 1973"
(format (js/Date. 106000000000) :locale "en-AU" :tz 0) ; "11 May 1973"

(format (js/Date. 106000000000) :locale "en-US" :pattern :short-time :tz 0) ; "8:26 PM"
(format (js/Date. 106000000000) :locale "en-AU" :pattern :short-time :tz 0) ; "8:26 pm"

(format (js/Date. 106000000000) :locale "en-US" :pattern :full-datetime :tz 0) ; "Friday, May 11, 1973 at 8:26:40 PM UTC"
(format (js/Date. 106000000000) :locale "en-AU" :pattern :full-datetime :tz 0) ; "Friday, 11 May 1973 at 8:26:40 pm UTC"
```

`i18n.datetime/format` takes an optional `:tz` parameter. The value of
`:tz` will be passed to `i18n.datetime/timezone` before use in the formatter.
The timezone handling in `goog.i18n.TimeZone` works like `js/Date` methods, in
that it is an _offset_, i.e. negative minutes (see below).

The default `:tz` is `:local`, i.e. `(.getTimezoneOffset (js/Date.))`.

```clojure
(format (js/Date. 106000000000) :locale "en-AU" :pattern :full-datetime :tz 0) ; "Friday, 11 May 1973 at 8:26:40 pm UTC"
(format (js/Date. 106000000000) :locale "en-AU" :pattern :full-datetime :tz -600) ; "Saturday, 12 May 1973 at 6:26:40 am UTC+10"
```

### Parsing

Takes a date string and attempts to parse to a `js/Date` instant.

**You MUST provide a pattern AND a locale for date parsing to work.**

If no `:pattern` is provided an error will be thrown, but if a `:pattern` is
provided that does not match the structure of the date string, the parser will
silently fallback to "now" in the returned date.

```clojure
(parse "May 12, 1973" :locale "en-US" :pattern :long-date) ; #inst "1973-05-12T08:00:54.428-00:00" - SUCCESS!
(parse "5/11/73" :locale "en-US" :pattern :long-date) ; #inst "2018-03-24T07:00:54.425-00:00" - FAIL!
```

### Timezones

The `i18n.datetime/timezone` fn is a thin wrapper around Google Closure's own
i18n timezone handling.

Numeric values are treated as a simple offset in negative minutes, e.g. `UTC+10`
hours would be `-600` in goog. This is compatible with the timezone offset API
provided by native JS.

To get the current offset in the browser, pass `:local` to
`i18n.datetime/timezone` or call `(.getTimezoneOffset (js/Date.))`.

Numeric values do not support daylight savings. For DST support a JS object must
be provided outlining all the details of the timezone.

Google strongly recommends serving `timeZoneData` objects from the server as
needed rather than shipping the full set of global timezones to the client. If
only a few timezones are required and can be specified ahead of time, they can
be set statically in client code.

Documentation for `timeZoneData` objects:

https://github.com/google/closure-library/blob/master/closure/goog/i18n/timezone.js#L144

Examples of `timeZoneData` objects:

https://github.com/google/closure-library/blob/master/closure/goog/i18n/timezone_test.js#L29

## Collation

TODO - patches welcome!

## Currency

TODO - patches welcome!

## Text messages

TODO - patches welcome!

## Plurals

TODO - patches welcome!

## BIDI text

TODO - patches welcome!
