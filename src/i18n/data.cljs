(ns i18n.data
 (:require
  goog.i18n.NumberFormatSymbols
  goog.i18n.DateTimeSymbols))

; https://github.com/google/closure-library/blob/master/closure/goog/i18n/numberformatsymbols.js#L2731
(def locales
 {
  ; https://github.com/google/closure-library/blob/master/closure/goog/i18n/numberformatsymbols.js#L2728
  :default {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_en
            :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_en
            :i18n/date-time-symbols goog.i18n.DateTimeSymbols_en
            :i18n/code "en"}

  ; Afrikaans
  "af" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_af
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_af
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_af
        :i18n/code "af"}

  ; Amharic
  "am" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_am
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_am
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_am
        :i18n/code "am"}

  ; Arabic
  "ar" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_ar
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_ar_u_nu_latn
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_ar
        :i18n/code "ar"}

  ; Arabic - Algeria
  "ar-DZ" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_ar_DZ
           :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_ar_DZ
           :i18n/date-time-symbols goog.i18n.DateTimeSymbols_ar_DZ
           :i18n/code "ar-DZ"}

  ; Azerbaijani
  "az" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_az
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_az
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_az
        :i18n/code "az"}

  ; Belarusian
  "be" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_be
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_be
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_be
        :i18n/code "be"}

  ; Bulgarian
  "bg" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_bg
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_bg
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_bg
        :i18n/code "bg"}

  ; Bengali
  "bn" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_bn
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_bn_u_nu_latn
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_bn
        :i18n/code "bn"}

  ; Breton
  "br" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_br
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_br
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_br
        :i18n/code "br"}

  ; Bosnian
  "bs" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_bs
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_bs
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_bs
        :i18n/code "bs"}

  ; Catalan
  "ca" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_ca
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_ca
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_ca
        :i18n/code "ca"}

  ; Cherokee
  "chr" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_chr
         :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_chr
         :i18n/date-time-symbols goog.i18n.DateTimeSymbols_chr
         :i18n/code "chr"}

  ; Czech
  "cs" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_cs
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_cs
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_cs
        :i18n/code "cs"}

  ; Welsh
  "cy" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_cy
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_cy
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_cy
        :i18n/code "cy"}

  ; Danish
  "da" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_da
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_da
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_da
        :i18n/code "da"}

  ; German
  "de" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_de
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_de
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_de
        :i18n/code "de"}

  ; German - Austria
  "de-AT" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_de_AT
           :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_de_AT
           :i18n/date-time-symbols goog.i18n.DateTimeSymbols_de_AT
           :i18n/code "de-AT"}

  ; German - Switzerland
  "de-CH" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_de_CH
           :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_de_CH
           :i18n/date-time-symbols goog.i18n.DateTimeSymbols_de_CH
           :i18n/code "de-CH"}

  ; Greek, Modern
  "el" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_el
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_el
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_el
        :i18n/code "el"}

  ; English
  "en" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_en
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_en
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_en
        :i18n/code "en"}

  ; English - Australia
  "en-AU" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_en_AU
           :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_en_AU
           :i18n/date-time-symbols goog.i18n.DateTimeSymbols_en_AU
           :i18n/code "en-AU"}

  ; English - Canada
  "en-CA" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_en_CA
           :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_en_CA
           :i18n/date-time-symbols goog.i18n.DateTimeSymbols_en_CA
           :i18n/code "en-CA"}

  ; English - Great Britain
  "en-GB" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_en_GB
           :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_en_GB
           :i18n/date-time-symbols goog.i18n.DateTimeSymbols_en_GB
           :i18n/code "en-GB"}

  ; English - Ireland
  "en-IE" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_en_IE
           :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_en_IE
           :i18n/date-time-symbols goog.i18n.DateTimeSymbols_en_IE
           :i18n/code "en-IE"}

  ; English - India
  "en-IN" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_en_IN
           :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_en_IN
           :i18n/date-time-symbols goog.i18n.DateTimeSymbols_en_IN
           :i18n/code "en-IN"}

  ; English - Singapore
  "en-SG" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_en_SG
           :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_en_SG
           :i18n/date-time-symbols goog.i18n.DateTimeSymbols_en_SG
           :i18n/code "en-SG"}

  ; English - America
  "en-US" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_en_US
           :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_en_US
           :i18n/date-time-symbols goog.i18n.DateTimeSymbols_en_US
           :i18n/code "en-US"}

  ; English - South Africa
  "en-ZA" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_en_ZA
           :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_en_ZA
           :i18n/date-time-symbols goog.i18n.DateTimeSymbols_en_ZA
           :i18n/code "en-ZA"}

  ; Spanish
  "es" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_es
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_es
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_es
        :i18n/code "es"}

  ; Spanish - Latin America
  "es-419" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_es_419
            :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_es_419
            :i18n/date-time-symbols goog.i18n.DateTimeSymbols_es_419
            :i18n/code "es-419"}

  ; Spanish - Spain
  "es-ES" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_es_ES
           :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_es_ES
           :i18n/date-time-symbols goog.i18n.DateTimeSymbols_es_ES
           :i18n/code "es-ES"}

  ; Spanish - Mexico
  "es-MX" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_es_MX
           :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_es_MX
           :i18n/date-time-symbols goog.i18n.DateTimeSymbols_es_MX
           :i18n/code "es-MX"}

  ; Spanish - United States
  "es-US" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_es_US
           :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_es_US
           :i18n/date-time-symbols goog.i18n.DateTimeSymbols_es_US
           :i18n/code "es-US"}

  ; Estonian
  "et" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_et
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_et
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_et
        :i18n/code "et"}

  ; Basque
  "eu" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_eu
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_eu
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_eu
        :i18n/code "eu"}

  ; Persian
  "fa" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_fa
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_fa_u_nu_latn
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_fa
        :i18n/code "fa"}

  ; Finnish
  "fi" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_fi
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_fi
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_fi
        :i18n/code "fi"}

  ; Filipino
  "fil" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_fil
         :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_fil
         :i18n/date-time-symbols goog.i18n.DateTimeSymbols_fil
         :i18n/code "fil"}

  ; French
  "fr" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_fr
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_fr
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_fr
        :i18n/code "fr"}

  ; French - Canada
  "fr-CA" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_fr_CA
           :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_fr_CA
           :i18n/date-time-symbols goog.i18n.DateTimeSymbols_fr_CA
           :i18n/code "fr-CA"}

  ; Irish
  "ga" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_ga
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_ga
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_ga
        :i18n/code "ga"}

  ; Galician
  "gl" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_gl
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_gl
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_gl
        :i18n/code "gl"}

  ; Swiss German
  "gsw" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_gsw
         :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_gsw
         :i18n/date-time-symbols goog.i18n.DateTimeSymbols_gsw
         :i18n/code "gsw"}

  ; Gujarati
  "gu" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_gu
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_gu
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_gu
        :i18n/code "gu"}

  ; Hawaiian
  "haw" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_haw
         :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_haw
         :i18n/date-time-symbols goog.i18n.DateTimeSymbols_haw
         :i18n/code "haw"}

  ; Hebrew
  "he" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_he
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_he
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_he
        :i18n/code "he"}

  ; Hindi
  "hi" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_hi
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_hi
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_hi
        :i18n/code "hi"}

  ; Croatian
  "hr" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_hr
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_hr
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_hr
        :i18n/code "hr"}

  ; Hungarian
  "hu" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_hu
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_hu
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_hu
        :i18n/code "hu"}

  ; Armenian
  "hy" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_hy
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_hy
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_hy
        :i18n/code "hy"}

  ; Indonesian
  "id" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_id
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_id
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_id
        :i18n/code "id"}

  ; Indonesian - ISO 639:1988
  "in" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_in
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_in
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_in
        :i18n/code "in"}

  ; Icelandic
  "is" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_is
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_is
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_is
        :i18n/code "is"}

  ; Italian
  "it" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_it
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_it
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_it
        :i18n/code "it"}

  ; Hebrew - ISO 639:1988
  "iw" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_iw
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_iw
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_iw
        :i18n/code "iw"}

  ; Japanese
  "ja" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_ja
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_ja
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_ja
        :i18n/code "ja"}

  ; Georgian
  "ka" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_ka
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_ka
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_ka
        :i18n/code "ka"}

  ; Kazakh
  "kk" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_kk
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_kk
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_kk
        :i18n/code "kk"}

  ; Central Khmer
  "km" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_km
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_km
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_km
        :i18n/code "km"}

  ; Kannada
  "kn" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_kn
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_kn
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_kn
        :i18n/code "kn"}

  ; Korean
  "ko" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_ko
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_ko
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_ko
        :i18n/code "ko"}

  ; Kirghiz
  "ky" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_ky
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_ky
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_ky
        :i18n/code "ky"}

  ; Lingala
  "ln" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_ln
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_ln
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_ln
        :i18n/code "ln"}

  ; Lao
  "lo" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_lo
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_lo
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_lo
        :i18n/code "lo"}

  ; Lithuanian
  "lt" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_lt
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_lt
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_lt
        :i18n/code "lt"}

  ; Latvian
  "lv" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_lv
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_lv
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_lv
        :i18n/code "lv"}

  ; Macedonian
  "mk" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_mk
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_mk
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_mk
        :i18n/code "mk"}

  ; Malayalam
  "ml" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_ml
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_ml
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_ml
        :i18n/code "ml"}

  ; Mongolian
  "mn" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_mn
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_mn
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_mn
        :i18n/code "mn"}

  ; Romanian - Deprecated
  "mo" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_mo
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_mo
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_mo
        :i18n/code "mo"}

  ; Marathi
  "mr" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_mr
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_mr_u_nu_latn
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_mr
        :i18n/code "mr"}

  ; Malay
  "ms" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_ms
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_ms
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_ms
        :i18n/code "ms"}

  ; Maltese
  "mt" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_mt
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_mt
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_mt
        :i18n/code "mt"}

  ; Burmese
  "my" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_my
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_my_u_nu_latn
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_my
        :i18n/code "my"}

  ; Norwegian
  "nb" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_nb
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_nb
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_nb
        :i18n/code "nb"}

  ; Nepali
  "ne" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_ne
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_ne_u_nu_latn
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_ne
        :i18n/code "ne"}

  ; Dutch
  "nl" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_nl
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_nl
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_nl
        :i18n/code "nl"}

  ; Norwegian
  "no" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_no
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_no
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_no
        :i18n/code "no"}

  ; Norwegian - Norway
  "no-NO" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_no_NO
           :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_no_NO
           :i18n/date-time-symbols goog.i18n.DateTimeSymbols_no_NO
           :i18n/code "no-NO"}

  ; Oriya
  "or" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_or
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_or
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_or
        :i18n/code "or"}

  ; Panjabi
  "pa" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_pa
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_pa
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_pa
        :i18n/code "pa"}

  ; Polish
  "pl" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_pl
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_pl
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_pl
        :i18n/code "pl"}

  ; Portuguese
  "pt" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_pt
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_pt
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_pt
        :i18n/code "pt"}

  ; Portuguese - Brazil
  "pt-BR" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_pt_BR
           :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_pt_BR
           :i18n/date-time-symbols goog.i18n.DateTimeSymbols_pt_BR
           :i18n/code "pt-BR"}

  ; Portuguese - Portugal
  "pt-PT" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_pt_PT
           :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_pt_PT
           :i18n/date-time-symbols goog.i18n.DateTimeSymbols_pt_PT
           :i18n/code "pt-PT"}

  ; Romanian
  "ro" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_ro
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_ro
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_ro
        :i18n/code "ro"}

  ; Russian
  "ru" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_ru
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_ru
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_ru
        :i18n/code "ru"}

  ; ???
  "sh" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_sh
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_sh
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_sh
        :i18n/code "sh"}

  ; Sinhala
  "si" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_si
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_si
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_si
        :i18n/code "si"}

  ; Slovak
  "sk" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_sk
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_sk
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_sk
        :i18n/code "sk"}

  ; Slovenian
  "sl" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_sl
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_sl
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_sl
        :i18n/code "sl"}

  ; Albanian
  "sq" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_sq
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_sq
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_sq
        :i18n/code "sq"}

  ; Serbian
  "sr" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_sr
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_sr
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_sr
        :i18n/code "sr"}

  ; Serbian - Latin
  "sr-Latn" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_sr_Latn
             :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_sr_Latn
             :i18n/date-time-symbols goog.i18n.DateTimeSymbols_sr_Latn
             :i18n/code "sr-Latn"}

  ; Swedish
  "sv" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_sv
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_sv
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_sv
        :i18n/code "sv"}

  ; Swahili
  "sw" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_sw
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_sw
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_sw
        :i18n/code "sw"}

  ; Tamil
  "ta" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_ta
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_ta
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_ta
        :i18n/code "ta"}

  ; Telugu
  "te" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_te
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_te
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_te
        :i18n/code "te"}

  ; Thai
  "th" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_th
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_th
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_th
        :i18n/code "th"}

  ; Tagalog
  "tl" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_tl
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_tl
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_tl
        :i18n/code "tl"}

  ; Turkish
  "tr" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_tr
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_tr
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_tr
        :i18n/code "tr"}

  ; Ukrainian
  "uk" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_uk
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_uk
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_uk
        :i18n/code "uk"}

  ; Urdu
  "ur" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_ur
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_ur
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_ur
        :i18n/code "ur"}

  ; Uzbek
  "uz" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_uz
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_uz
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_uz
        :i18n/code "uz"}

  ; Vietnamese
  "vi" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_vi
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_vi
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_vi
        :i18n/code "vi"}

  ; Chinese
  "zh" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_zh
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_zh
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_zh
        :i18n/code "zh"}

  ; Chinese - China
  "zh-CN" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_zh_CN
           :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_zh_CN
           :i18n/date-time-symbols goog.i18n.DateTimeSymbols_zh_CN
           :i18n/code "zh-CN"}

  ; Chinese - Hong Kong
  "zh-HK" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_zh_HK
           :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_zh_HK
           :i18n/date-time-symbols goog.i18n.DateTimeSymbols_zh_HK
           :i18n/code "zh-HK"}

  ; Chinese - Taiwan
  "zh-TW" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_zh_TW
           :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_zh_TW
           :i18n/date-time-symbols goog.i18n.DateTimeSymbols_zh_TW
           :i18n/code "zh-TW"}

  ; Zulu
  "zu" {:i18n/number-format-symbols goog.i18n.NumberFormatSymbols_zu
        :i18n/number-format-symbols-latin goog.i18n.NumberFormatSymbols_zu
        :i18n/date-time-symbols goog.i18n.DateTimeSymbols_zu
        :i18n/code "zu"}})

(def default-locale (-> locales :default :i18n/code))
