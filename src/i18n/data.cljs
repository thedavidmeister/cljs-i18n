(ns i18n.data
 (:require
  goog.i18n.NumberFormatSymbols
  goog.i18n.DateTimeSymbols))

; https://github.com/google/closure-library/blob/master/closure/goog/i18n/numberformatsymbols.js#L2731
(def locales
 {
  ; https://github.com/google/closure-library/blob/master/closure/goog/i18n/numberformatsymbols.js#L2728
  :default {:number-format-symbols goog.i18n.NumberFormatSymbols_en
            :number-format-symbols-latin goog.i18n.NumberFormatSymbols_en
            :date-time-symbols goog.i18n.DateTimeSymbols_en
            :code "en"}

  ; Afrikaans
  "af" {:number-format-symbols goog.i18n.NumberFormatSymbols_af
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_af
        :date-time-symbols goog.i18n.DateTimeSymbols_af
        :code "af"}

  ; Amharic
  "am" {:number-format-symbols goog.i18n.NumberFormatSymbols_am
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_am
        :date-time-symbols goog.i18n.DateTimeSymbols_am
        :code "am"}

  ; Arabic
  "ar" {:number-format-symbols goog.i18n.NumberFormatSymbols_ar
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_ar_u_nu_latn
        :date-time-symbols goog.i18n.DateTimeSymbols_ar
        :code "ar"}

  ; Arabic - Algeria
  "ar-DZ" {:number-format-symbols goog.i18n.NumberFormatSymbols_ar_DZ
           :number-format-symbols-latin goog.i18n.NumberFormatSymbols_ar_DZ
           :date-time-symbols goog.i18n.DateTimeSymbols_ar_DZ
           :code "ar-DZ"}

  ; Azerbaijani
  "az" {:number-format-symbols goog.i18n.NumberFormatSymbols_az
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_az
        :date-time-symbols goog.i18n.DateTimeSymbols_az
        :code "az"}

  ; Belarusian
  "be" {:number-format-symbols goog.i18n.NumberFormatSymbols_be
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_be
        :date-time-symbols goog.i18n.DateTimeSymbols_be
        :code "be"}

  ; Bulgarian
  "bg" {:number-format-symbols goog.i18n.NumberFormatSymbols_bg
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_bg
        :date-time-symbols goog.i18n.DateTimeSymbols_bg
        :code "bg"}

  ; Bengali
  "bn" {:number-format-symbols goog.i18n.NumberFormatSymbols_bn
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_bn_u_nu_latn
        :date-time-symbols goog.i18n.DateTimeSymbols_bn
        :code "bn"}

  ; Breton
  "br" {:number-format-symbols goog.i18n.NumberFormatSymbols_br
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_br
        :date-time-symbols goog.i18n.DateTimeSymbols_br
        :code "br"}

  ; Bosnian
  "bs" {:number-format-symbols goog.i18n.NumberFormatSymbols_bs
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_bs
        :date-time-symbols goog.i18n.DateTimeSymbols_bs
        :code "bs"}

  ; Catalan
  "ca" {:number-format-symbols goog.i18n.NumberFormatSymbols_ca
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_ca
        :date-time-symbols goog.i18n.DateTimeSymbols_ca
        :code "ca"}

  ; Cherokee
  "chr" {:number-format-symbols goog.i18n.NumberFormatSymbols_chr
         :number-format-symbols-latin goog.i18n.NumberFormatSymbols_chr
         :date-time-symbols goog.i18n.DateTimeSymbols_chr
         :code "chr"}

  ; Czech
  "cs" {:number-format-symbols goog.i18n.NumberFormatSymbols_cs
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_cs
        :date-time-symbols goog.i18n.DateTimeSymbols_cs
        :code "cs"}

  ; Welsh
  "cy" {:number-format-symbols goog.i18n.NumberFormatSymbols_cy
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_cy
        :date-time-symbols goog.i18n.DateTimeSymbols_cy
        :code "cy"}

  ; Danish
  "da" {:number-format-symbols goog.i18n.NumberFormatSymbols_da
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_da
        :date-time-symbols goog.i18n.DateTimeSymbols_da
        :code "da"}

  ; German
  "de" {:number-format-symbols goog.i18n.NumberFormatSymbols_de
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_de
        :date-time-symbols goog.i18n.DateTimeSymbols_de
        :code "de"}

  ; German - Austria
  "de-AT" {:number-format-symbols goog.i18n.NumberFormatSymbols_de_AT
           :number-format-symbols-latin goog.i18n.NumberFormatSymbols_de_AT
           :date-time-symbols goog.i18n.DateTimeSymbols_de_AT
           :code "de-AT"}

  ; German - Switzerland
  "de-CH" {:number-format-symbols goog.i18n.NumberFormatSymbols_de_CH
           :number-format-symbols-latin goog.i18n.NumberFormatSymbols_de_CH
           :date-time-symbols goog.i18n.DateTimeSymbols_de_CH
           :code "de-CH"}

  ; Greek, Modern
  "el" {:number-format-symbols goog.i18n.NumberFormatSymbols_el
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_el
        :date-time-symbols goog.i18n.DateTimeSymbols_el
        :code "el"}

  ; English
  "en" {:number-format-symbols goog.i18n.NumberFormatSymbols_en
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_en
        :date-time-symbols goog.i18n.DateTimeSymbols_en
        :code "en"}

  ; English - Australia
  "en-AU" {:number-format-symbols goog.i18n.NumberFormatSymbols_en_AU
           :number-format-symbols-latin goog.i18n.NumberFormatSymbols_en_AU
           :date-time-symbols goog.i18n.DateTimeSymbols_en_AU
           :code "en-AU"}

  ; English - Canada
  "en-CA" {:number-format-symbols goog.i18n.NumberFormatSymbols_en_CA
           :number-format-symbols-latin goog.i18n.NumberFormatSymbols_en_CA
           :date-time-symbols goog.i18n.DateTimeSymbols_en_CA
           :code "en-CA"}

  ; English - Great Britain
  "en-GB" {:number-format-symbols goog.i18n.NumberFormatSymbols_en_GB
           :number-format-symbols-latin goog.i18n.NumberFormatSymbols_en_GB
           :date-time-symbols goog.i18n.DateTimeSymbols_en_GB
           :code "en-GB"}

  ; English - Ireland
  "en-IE" {:number-format-symbols goog.i18n.NumberFormatSymbols_en_IE
           :number-format-symbols-latin goog.i18n.NumberFormatSymbols_en_IE
           :date-time-symbols goog.i18n.DateTimeSymbols_en_IE
           :code "en-IE"}

  ; English - India
  "en-IN" {:number-format-symbols goog.i18n.NumberFormatSymbols_en_IN
           :number-format-symbols-latin goog.i18n.NumberFormatSymbols_en_IN
           :date-time-symbols goog.i18n.DateTimeSymbols_en_IN
           :code "en-IN"}

  ; English - Singapore
  "en-SG" {:number-format-symbols goog.i18n.NumberFormatSymbols_en_SG
           :number-format-symbols-latin goog.i18n.NumberFormatSymbols_en_SG
           :date-time-symbols goog.i18n.DateTimeSymbols_en_SG
           :code "en-SG"}

  ; English - America
  "en-US" {:number-format-symbols goog.i18n.NumberFormatSymbols_en_US
           :number-format-symbols-latin goog.i18n.NumberFormatSymbols_en_US
           :date-time-symbols goog.i18n.DateTimeSymbols_en_US
           :code "en-US"}

  ; English - South Africa
  "en-ZA" {:number-format-symbols goog.i18n.NumberFormatSymbols_en_ZA
           :number-format-symbols-latin goog.i18n.NumberFormatSymbols_en_ZA
           :date-time-symbols goog.i18n.DateTimeSymbols_en_ZA
           :code "en-ZA"}

  ; Spanish
  "es" {:number-format-symbols goog.i18n.NumberFormatSymbols_es
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_es
        :date-time-symbols goog.i18n.DateTimeSymbols_es
        :code "es"}

  ; Spanish - Latin America
  "es-419" {:number-format-symbols goog.i18n.NumberFormatSymbols_es_419
            :number-format-symbols-latin goog.i18n.NumberFormatSymbols_es_419
            :date-time-symbols goog.i18n.DateTimeSymbols_es_419
            :code "es-419"}

  ; Spanish - Spain
  "es-ES" {:number-format-symbols goog.i18n.NumberFormatSymbols_es_ES
           :number-format-symbols-latin goog.i18n.NumberFormatSymbols_es_ES
           :date-time-symbols goog.i18n.DateTimeSymbols_es_ES
           :code "es-ES"}

  ; Spanish - Mexico
  "es-MX" {:number-format-symbols goog.i18n.NumberFormatSymbols_es_MX
           :number-format-symbols-latin goog.i18n.NumberFormatSymbols_es_MX
           :date-time-symbols goog.i18n.DateTimeSymbols_es_MX
           :code "es-MX"}

  ; Spanish - United States
  "es-US" {:number-format-symbols goog.i18n.NumberFormatSymbols_es_US
           :number-format-symbols-latin goog.i18n.NumberFormatSymbols_es_US
           :date-time-symbols goog.i18n.DateTimeSymbols_es_US
           :code "es-US"}

  ; Estonian
  "et" {:number-format-symbols goog.i18n.NumberFormatSymbols_et
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_et
        :date-time-symbols goog.i18n.DateTimeSymbols_et
        :code "et"}

  ; Basque
  "eu" {:number-format-symbols goog.i18n.NumberFormatSymbols_eu
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_eu
        :date-time-symbols goog.i18n.DateTimeSymbols_eu
        :code "eu"}

  ; Persian
  "fa" {:number-format-symbols goog.i18n.NumberFormatSymbols_fa
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_fa_u_nu_latn
        :date-time-symbols goog.i18n.DateTimeSymbols_fa
        :code "fa"}

  ; Finnish
  "fi" {:number-format-symbols goog.i18n.NumberFormatSymbols_fi
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_fi
        :date-time-symbols goog.i18n.DateTimeSymbols_fi
        :code "fi"}

  ; Filipino
  "fil" {:number-format-symbols goog.i18n.NumberFormatSymbols_fil
         :number-format-symbols-latin goog.i18n.NumberFormatSymbols_fil
         :date-time-symbols goog.i18n.DateTimeSymbols_fil
         :code "fil"}

  ; French
  "fr" {:number-format-symbols goog.i18n.NumberFormatSymbols_fr
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_fr
        :date-time-symbols goog.i18n.DateTimeSymbols_fr
        :code "fr"}

  ; French - Canada
  "fr-CA" {:number-format-symbols goog.i18n.NumberFormatSymbols_fr_CA
           :number-format-symbols-latin goog.i18n.NumberFormatSymbols_fr_CA
           :date-time-symbols goog.i18n.DateTimeSymbols_fr_CA
           :code "fr-CA"}

  ; Irish
  "ga" {:number-format-symbols goog.i18n.NumberFormatSymbols_ga
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_ga
        :date-time-symbols goog.i18n.DateTimeSymbols_ga
        :code "ga"}

  ; Galician
  "gl" {:number-format-symbols goog.i18n.NumberFormatSymbols_gl
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_gl
        :date-time-symbols goog.i18n.DateTimeSymbols_gl
        :code "gl"}

  ; Swiss German
  "gsw" {:number-format-symbols goog.i18n.NumberFormatSymbols_gsw
         :number-format-symbols-latin goog.i18n.NumberFormatSymbols_gsw
         :date-time-symbols goog.i18n.DateTimeSymbols_gsw
         :code "gsw"}

  ; Gujarati
  "gu" {:number-format-symbols goog.i18n.NumberFormatSymbols_gu
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_gu
        :date-time-symbols goog.i18n.DateTimeSymbols_gu
        :code "gu"}

  ; Hawaiian
  "haw" {:number-format-symbols goog.i18n.NumberFormatSymbols_haw
         :number-format-symbols-latin goog.i18n.NumberFormatSymbols_haw
         :date-time-symbols goog.i18n.DateTimeSymbols_haw
         :code "haw"}

  ; Hebrew
  "he" {:number-format-symbols goog.i18n.NumberFormatSymbols_he
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_he
        :date-time-symbols goog.i18n.DateTimeSymbols_he
        :code "he"}

  ; Hindi
  "hi" {:number-format-symbols goog.i18n.NumberFormatSymbols_hi
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_hi
        :date-time-symbols goog.i18n.DateTimeSymbols_hi
        :code "hi"}

  ; Croatian
  "hr" {:number-format-symbols goog.i18n.NumberFormatSymbols_hr
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_hr
        :date-time-symbols goog.i18n.DateTimeSymbols_hr
        :code "hr"}

  ; Hungarian
  "hu" {:number-format-symbols goog.i18n.NumberFormatSymbols_hu
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_hu
        :date-time-symbols goog.i18n.DateTimeSymbols_hu
        :code "hu"}

  ; Armenian
  "hy" {:number-format-symbols goog.i18n.NumberFormatSymbols_hy
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_hy
        :date-time-symbols goog.i18n.DateTimeSymbols_hy
        :code "hy"}

  ; Indonesian
  "id" {:number-format-symbols goog.i18n.NumberFormatSymbols_id
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_id
        :date-time-symbols goog.i18n.DateTimeSymbols_id
        :code "id"}

  ; Indonesian - ISO 639:1988
  "in" {:number-format-symbols goog.i18n.NumberFormatSymbols_in
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_in
        :date-time-symbols goog.i18n.DateTimeSymbols_in
        :code "in"}

  ; Icelandic
  "is" {:number-format-symbols goog.i18n.NumberFormatSymbols_is
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_is
        :date-time-symbols goog.i18n.DateTimeSymbols_is
        :code "is"}

  ; Italian
  "it" {:number-format-symbols goog.i18n.NumberFormatSymbols_it
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_it
        :date-time-symbols goog.i18n.DateTimeSymbols_it
        :code "it"}

  ; Hebrew - ISO 639:1988
  "iw" {:number-format-symbols goog.i18n.NumberFormatSymbols_iw
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_iw
        :date-time-symbols goog.i18n.DateTimeSymbols_iw
        :code "iw"}

  ; Japanese
  "ja" {:number-format-symbols goog.i18n.NumberFormatSymbols_ja
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_ja
        :date-time-symbols goog.i18n.DateTimeSymbols_ja
        :code "ja"}

  ; Georgian
  "ka" {:number-format-symbols goog.i18n.NumberFormatSymbols_ka
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_ka
        :date-time-symbols goog.i18n.DateTimeSymbols_ka
        :code "ka"}

  ; Kazakh
  "kk" {:number-format-symbols goog.i18n.NumberFormatSymbols_kk
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_kk
        :date-time-symbols goog.i18n.DateTimeSymbols_kk
        :code "kk"}

  ; Central Khmer
  "km" {:number-format-symbols goog.i18n.NumberFormatSymbols_km
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_km
        :date-time-symbols goog.i18n.DateTimeSymbols_km
        :code "km"}

  ; Kannada
  "kn" {:number-format-symbols goog.i18n.NumberFormatSymbols_kn
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_kn
        :date-time-symbols goog.i18n.DateTimeSymbols_kn
        :code "kn"}

  ; Korean
  "ko" {:number-format-symbols goog.i18n.NumberFormatSymbols_ko
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_ko
        :date-time-symbols goog.i18n.DateTimeSymbols_ko
        :code "ko"}

  ; Kirghiz
  "ky" {:number-format-symbols goog.i18n.NumberFormatSymbols_ky
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_ky
        :date-time-symbols goog.i18n.DateTimeSymbols_ky
        :code "ky"}

  ; Lingala
  "ln" {:number-format-symbols goog.i18n.NumberFormatSymbols_ln
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_ln
        :date-time-symbols goog.i18n.DateTimeSymbols_ln
        :code "ln"}

  ; Lao
  "lo" {:number-format-symbols goog.i18n.NumberFormatSymbols_lo
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_lo
        :date-time-symbols goog.i18n.DateTimeSymbols_lo
        :code "lo"}

  ; Lithuanian
  "lt" {:number-format-symbols goog.i18n.NumberFormatSymbols_lt
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_lt
        :date-time-symbols goog.i18n.DateTimeSymbols_lt
        :code "lt"}

  ; Latvian
  "lv" {:number-format-symbols goog.i18n.NumberFormatSymbols_lv
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_lv
        :date-time-symbols goog.i18n.DateTimeSymbols_lv
        :code "lv"}

  ; Macedonian
  "mk" {:number-format-symbols goog.i18n.NumberFormatSymbols_mk
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_mk
        :date-time-symbols goog.i18n.DateTimeSymbols_mk
        :code "mk"}

  ; Malayalam
  "ml" {:number-format-symbols goog.i18n.NumberFormatSymbols_ml
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_ml
        :date-time-symbols goog.i18n.DateTimeSymbols_ml
        :code "ml"}

  ; Mongolian
  "mn" {:number-format-symbols goog.i18n.NumberFormatSymbols_mn
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_mn
        :date-time-symbols goog.i18n.DateTimeSymbols_mn
        :code "mn"}

  ; Romanian - Deprecated
  "mo" {:number-format-symbols goog.i18n.NumberFormatSymbols_mo
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_mo
        :date-time-symbols goog.i18n.DateTimeSymbols_mo
        :code "mo"}

  ; Marathi
  "mr" {:number-format-symbols goog.i18n.NumberFormatSymbols_mr
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_mr_u_nu_latn
        :date-time-symbols goog.i18n.DateTimeSymbols_mr
        :code "mr"}

  ; Malay
  "ms" {:number-format-symbols goog.i18n.NumberFormatSymbols_ms
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_ms
        :date-time-symbols goog.i18n.DateTimeSymbols_ms
        :code "ms"}

  ; Maltese
  "mt" {:number-format-symbols goog.i18n.NumberFormatSymbols_mt
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_mt
        :date-time-symbols goog.i18n.DateTimeSymbols_mt
        :code "mt"}

  ; Burmese
  "my" {:number-format-symbols goog.i18n.NumberFormatSymbols_my
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_my_u_nu_latn
        :date-time-symbols goog.i18n.DateTimeSymbols_my
        :code "my"}

  ; Norwegian
  "nb" {:number-format-symbols goog.i18n.NumberFormatSymbols_nb
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_nb
        :date-time-symbols goog.i18n.DateTimeSymbols_nb
        :code "nb"}

  ; Nepali
  "ne" {:number-format-symbols goog.i18n.NumberFormatSymbols_ne
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_ne_u_nu_latn
        :date-time-symbols goog.i18n.DateTimeSymbols_ne
        :code "ne"}

  ; Dutch
  "nl" {:number-format-symbols goog.i18n.NumberFormatSymbols_nl
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_nl
        :date-time-symbols goog.i18n.DateTimeSymbols_nl
        :code "nl"}

  ; Norwegian
  "no" {:number-format-symbols goog.i18n.NumberFormatSymbols_no
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_no
        :date-time-symbols goog.i18n.DateTimeSymbols_no
        :code "no"}

  ; Norwegian - Norway
  "no-NO" {:number-format-symbols goog.i18n.NumberFormatSymbols_no_NO
           :number-format-symbols-latin goog.i18n.NumberFormatSymbols_no_NO
           :date-time-symbols goog.i18n.DateTimeSymbols_no_NO
           :code "no-NO"}

  ; Oriya
  "or" {:number-format-symbols goog.i18n.NumberFormatSymbols_or
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_or
        :date-time-symbols goog.i18n.DateTimeSymbols_or
        :code "or"}

  ; Panjabi
  "pa" {:number-format-symbols goog.i18n.NumberFormatSymbols_pa
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_pa
        :date-time-symbols goog.i18n.DateTimeSymbols_pa
        :code "pa"}

  ; Polish
  "pl" {:number-format-symbols goog.i18n.NumberFormatSymbols_pl
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_pl
        :date-time-symbols goog.i18n.DateTimeSymbols_pl
        :code "pl"}

  ; Portuguese
  "pt" {:number-format-symbols goog.i18n.NumberFormatSymbols_pt
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_pt
        :date-time-symbols goog.i18n.DateTimeSymbols_pt
        :code "pt"}

  ; Portuguese - Brazil
  "pt-BR" {:number-format-symbols goog.i18n.NumberFormatSymbols_pt_BR
           :number-format-symbols-latin goog.i18n.NumberFormatSymbols_pt_BR
           :date-time-symbols goog.i18n.DateTimeSymbols_pt_BR
           :code "pt-BR"}

  ; Portuguese - Portugal
  "pt-PT" {:number-format-symbols goog.i18n.NumberFormatSymbols_pt_PT
           :number-format-symbols-latin goog.i18n.NumberFormatSymbols_pt_PT
           :date-time-symbols goog.i18n.DateTimeSymbols_pt_PT
           :code "pt-PT"}

  ; Romanian
  "ro" {:number-format-symbols goog.i18n.NumberFormatSymbols_ro
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_ro
        :date-time-symbols goog.i18n.DateTimeSymbols_ro
        :code "ro"}

  ; Russian
  "ru" {:number-format-symbols goog.i18n.NumberFormatSymbols_ru
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_ru
        :date-time-symbols goog.i18n.DateTimeSymbols_ru
        :code "ru"}

  ; ???
  "sh" {:number-format-symbols goog.i18n.NumberFormatSymbols_sh
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_sh
        :date-time-symbols goog.i18n.DateTimeSymbols_sh
        :code "sh"}

  ; Sinhala
  "si" {:number-format-symbols goog.i18n.NumberFormatSymbols_si
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_si
        :date-time-symbols goog.i18n.DateTimeSymbols_si
        :code "si"}

  ; Slovak
  "sk" {:number-format-symbols goog.i18n.NumberFormatSymbols_sk
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_sk
        :date-time-symbols goog.i18n.DateTimeSymbols_sk
        :code "sk"}

  ; Slovenian
  "sl" {:number-format-symbols goog.i18n.NumberFormatSymbols_sl
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_sl
        :date-time-symbols goog.i18n.DateTimeSymbols_sl
        :code "sl"}

  ; Albanian
  "sq" {:number-format-symbols goog.i18n.NumberFormatSymbols_sq
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_sq
        :date-time-symbols goog.i18n.DateTimeSymbols_sq
        :code "sq"}

  ; Serbian
  "sr" {:number-format-symbols goog.i18n.NumberFormatSymbols_sr
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_sr
        :date-time-symbols goog.i18n.DateTimeSymbols_sr
        :code "sr"}

  ; Serbian - Latin
  "sr-Latn" {:number-format-symbols goog.i18n.NumberFormatSymbols_sr_Latn
             :number-format-symbols-latin goog.i18n.NumberFormatSymbols_sr_Latn
             :date-time-symbols goog.i18n.DateTimeSymbols_sr_Latn
             :code "sr-Latn"}

  ; Swedish
  "sv" {:number-format-symbols goog.i18n.NumberFormatSymbols_sv
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_sv
        :date-time-symbols goog.i18n.DateTimeSymbols_sv
        :code "sv"}

  ; Swahili
  "sw" {:number-format-symbols goog.i18n.NumberFormatSymbols_sw
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_sw
        :date-time-symbols goog.i18n.DateTimeSymbols_sw
        :code "sw"}

  ; Tamil
  "ta" {:number-format-symbols goog.i18n.NumberFormatSymbols_ta
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_ta
        :date-time-symbols goog.i18n.DateTimeSymbols_ta
        :code "ta"}

  ; Telugu
  "te" {:number-format-symbols goog.i18n.NumberFormatSymbols_te
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_te
        :date-time-symbols goog.i18n.DateTimeSymbols_te
        :code "te"}

  ; Thai
  "th" {:number-format-symbols goog.i18n.NumberFormatSymbols_th
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_th
        :date-time-symbols goog.i18n.DateTimeSymbols_th
        :code "th"}

  ; Tagalog
  "tl" {:number-format-symbols goog.i18n.NumberFormatSymbols_tl
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_tl
        :date-time-symbols goog.i18n.DateTimeSymbols_tl
        :code "tl"}

  ; Turkish
  "tr" {:number-format-symbols goog.i18n.NumberFormatSymbols_tr
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_tr
        :date-time-symbols goog.i18n.DateTimeSymbols_tr
        :code "tr"}

  ; Ukrainian
  "uk" {:number-format-symbols goog.i18n.NumberFormatSymbols_uk
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_uk
        :date-time-symbols goog.i18n.DateTimeSymbols_uk
        :code "uk"}

  ; Urdu
  "ur" {:number-format-symbols goog.i18n.NumberFormatSymbols_ur
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_ur
        :date-time-symbols goog.i18n.DateTimeSymbols_ur
        :code "ur"}

  ; Uzbek
  "uz" {:number-format-symbols goog.i18n.NumberFormatSymbols_uz
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_uz
        :date-time-symbols goog.i18n.DateTimeSymbols_uz
        :code "uz"}

  ; Vietnamese
  "vi" {:number-format-symbols goog.i18n.NumberFormatSymbols_vi
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_vi
        :date-time-symbols goog.i18n.DateTimeSymbols_vi
        :code "vi"}

  ; Chinese
  "zh" {:number-format-symbols goog.i18n.NumberFormatSymbols_zh
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_zh
        :date-time-symbols goog.i18n.DateTimeSymbols_zh
        :code "zh"}

  ; Chinese - China
  "zh-CN" {:number-format-symbols goog.i18n.NumberFormatSymbols_zh_CN
           :number-format-symbols-latin goog.i18n.NumberFormatSymbols_zh_CN
           :date-time-symbols goog.i18n.DateTimeSymbols_zh_CN
           :code "zh-CN"}

  ; Chinese - Hong Kong
  "zh-HK" {:number-format-symbols goog.i18n.NumberFormatSymbols_zh_HK
           :number-format-symbols-latin goog.i18n.NumberFormatSymbols_zh_HK
           :date-time-symbols goog.i18n.DateTimeSymbols_zh_HK
           :code "zh-HK"}

  ; Chinese - Taiwan
  "zh-TW" {:number-format-symbols goog.i18n.NumberFormatSymbols_zh_TW
           :number-format-symbols-latin goog.i18n.NumberFormatSymbols_zh_TW
           :date-time-symbols goog.i18n.DateTimeSymbols_zh_TW
           :code "zh-TW"}

  ; Zulu
  "zu" {:number-format-symbols goog.i18n.NumberFormatSymbols_zu
        :number-format-symbols-latin goog.i18n.NumberFormatSymbols_zu
        :date-time-symbols goog.i18n.DateTimeSymbols_zu
        :code "zu"}})

(def default-locale (-> locales :default :code))
