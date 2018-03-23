(ns i18n.data
 (:require
  goog.i18n.NumberFormatSymbols
  goog.i18n.DateTimeSymbols))

; https://github.com/google/closure-library/blob/master/closure/goog/i18n/numberformatsymbols.js#L2731
(def locales
 {
  ; https://github.com/google/closure-library/blob/master/closure/goog/i18n/numberformatsymbols.js#L2728
  :default {:number-format-symbols goog.i18n.NumberFormatSymbols_en
            :date-time-symbols goog.i18n.DateTimeSymbols_en}

  ; Afrikaans
  "af" {:number-format-symbols goog.i18n.NumberFormatSymbols_af
        :date-time-symbols goog.i18n.DateTimeSymbols_af}

  ; Amharic
  "am" {:number-format-symbols goog.i18n.NumberFormatSymbols_am
        :date-time-symbols goog.i18n.DateTimeSymbols_am}

  ; 	Arabic
  "ar" {:number-format-symbols goog.i18n.NumberFormatSymbols_ar
        :date-time-symbols goog.i18n.DateTimeSymbols_ar}

  ; Arabic - Algeria
  "ar-DZ" {:number-format-symbols goog.i18n.NumberFormatSymbols_ar_DZ
           :date-time-symbols goog.i18n.DateTimeSymbols_ar_DZ}

  ; Azerbaijani
  "az" {:number-format-symbols goog.i18n.NumberFormatSymbols_az
        :date-time-symbols goog.i18n.DateTimeSymbols_az}

  ; Belarusian
  "be" {:number-format-symbols goog.i18n.NumberFormatSymbols_be
        :date-time-symbols goog.i18n.DateTimeSymbols_be}

  ; Bulgarian
  "bg" {:number-format-symbols goog.i18n.NumberFormatSymbols_bg
        :date-time-symbols goog.i18n.DateTimeSymbols_bg}

  ; Bengali
  "bn" {:number-format-symbols goog.i18n.NumberFormatSymbols_bn
        :date-time-symbols goog.i18n.DateTimeSymbols_bn}

  ; Breton
  "br" {:number-format-symbols goog.i18n.NumberFormatSymbols_br
        :date-time-symbols goog.i18n.DateTimeSymbols_br}

  ; Bosnian
  "bs" {:number-format-symbols goog.i18n.NumberFormatSymbols_bs
        :date-time-symbols goog.i18n.DateTimeSymbols_bs}

  ; Catalan
  "ca" {:number-format-symbols goog.i18n.NumberFormatSymbols_ca
        :date-time-symbols goog.i18n.DateTimeSymbols_ca}

  ; Cherokee
  "chr" {:number-format-symbols goog.i18n.NumberFormatSymbols_chr
         :date-time-symbols goog.i18n.DateTimeSymbols_chr}

  ; Czech
  "cs" {:number-format-symbols goog.i18n.NumberFormatSymbols_cs
        :date-time-symbols goog.i18n.DateTimeSymbols_cs}

  ; Welsh
  "cy" {:number-format-symbols goog.i18n.NumberFormatSymbols_cy
        :date-time-symbols goog.i18n.DateTimeSymbols_cy}

  ; Danish
  "da" {:number-format-symbols goog.i18n.NumberFormatSymbols_da
        :date-time-symbols goog.i18n.DateTimeSymbols_da}

  ; German
  "de" {:number-format-symbols goog.i18n.NumberFormatSymbols_de
        :date-time-symbols goog.i18n.DateTimeSymbols_de}

  ; German - Austria
  "de-AT" {:number-format-symbols goog.i18n.NumberFormatSymbols_de_AT
           :date-time-symbols goog.i18n.DateTimeSymbols_de_AT}

  ; German - Switzerland
  "de-CH" {:number-format-symbols goog.i18n.NumberFormatSymbols_de_CH
           :date-time-symbols goog.i18n.DateTimeSymbols_de_CH}

  ; Greek, Modern
  "el" {:number-format-symbols goog.i18n.NumberFormatSymbols_el
        :date-time-symbols goog.i18n.DateTimeSymbols_el}

  ; English
  "en" {:number-format-symbols goog.i18n.NumberFormatSymbols_en
        :date-time-symbols goog.i18n.DateTimeSymbols_en}

  ; English - Australia
  "en-AU" {:number-format-symbols goog.i18n.NumberFormatSymbols_en_AU
           :date-time-symbols goog.i18n.DateTimeSymbols_en_AU}

  ; English - Canada
  "en-CA" {:number-format-symbols goog.i18n.NumberFormatSymbols_en_CA
           :date-time-symbols goog.i18n.DateTimeSymbols_en_CA}

  ; English - Great Britain
  "en-GB" {:number-format-symbols goog.i18n.NumberFormatSymbols_en_GB
           :date-time-symbols goog.i18n.DateTimeSymbols_en_GB}

  ; English - Ireland
  "en-IE" {:number-format-symbols goog.i18n.NumberFormatSymbols_en_IE
           :date-time-symbols goog.i18n.DateTimeSymbols_en_IE}

  ; English - India
  "en-IN" {:number-format-symbols goog.i18n.NumberFormatSymbols_en_IN
           :date-time-symbols goog.i18n.DateTimeSymbols_en_IN}

  ; English - Singapore
  "en-SG" {:number-format-symbols goog.i18n.NumberFormatSymbols_en_SG
           :date-time-symbols goog.i18n.DateTimeSymbols_en_SG}

  ; English - America
  "en-US" {:number-format-symbols goog.i18n.NumberFormatSymbols_en_US
           :date-time-symbols goog.i18n.DateTimeSymbols_en_US}

  ; English - South Africa
  "en-ZA" {:number-format-symbols goog.i18n.NumberFormatSymbols_en_ZA
           :date-time-symbols goog.i18n.DateTimeSymbols_en_ZA}

  ; Spanish
  "es" {:number-format-symbols goog.i18n.NumberFormatSymbols_es
        :date-time-symbols goog.i18n.DateTimeSymbols_es}

  ; Spanish - Latin America
  "es-419" {:number-format-symbols goog.i18n.NumberFormatSymbols_es_419
            :date-time-symbols goog.i18n.DateTimeSymbols_es_419}

  ; Spanish - Spain
  "es-ES" {:number-format-symbols goog.i18n.NumberFormatSymbols_es_ES
            :date-time-symbols goog.i18n.DateTimeSymbols_es_ES}

  ; Spanish - Mexico
  "es-MX" {:number-format-symbols goog.i18n.NumberFormatSymbols_es_MX
           :date-time-symbols goog.i18n.DateTimeSymbols_es_MX}

  ; Spanish - United States
  "es-US" {:number-format-symbols goog.i18n.NumberFormatSymbols_es_US
           :date-time-symbols goog.i18n.DateTimeSymbols_es_US}

  ; Estonian
  "et" {:number-format-symbols goog.i18n.NumberFormatSymbols_et
        :date-time-symbols goog.i18n.DateTimeSymbols_et}

  ; Basque
  "eu" {:number-format-symbols goog.i18n.NumberFormatSymbols_eu
        :date-time-symbols goog.i18n.DateTimeSymbols_eu}

  ; Persian
  "fa" {:number-format-symbols goog.i18n.NumberFormatSymbols_fa
        :date-time-symbols goog.i18n.DateTimeSymbols_fa}

  ; Finnish
  "fi" {:number-format-symbols goog.i18n.NumberFormatSymbols_fi
        :date-time-symbols goog.i18n.DateTimeSymbols_fi}

  ; Filipino
  "fil" {:number-format-symbols goog.i18n.NumberFormatSymbols_fil
         :date-time-symbols goog.i18n.DateTimeSymbols_fil}

  ; French
  "fr" {:number-format-symbols goog.i18n.NumberFormatSymbols_fr
        :date-time-symbols goog.i18n.DateTimeSymbols_fr}

  ; French - Canada
  "fr-CA" {:number-format-symbols goog.i18n.NumberFormatSymbols_fr_CA
           :date-time-symbols goog.i18n.DateTimeSymbols_fr_CA}

  ; Irish
  "ga" {:number-format-symbols goog.i18n.NumberFormatSymbols_ga
        :date-time-symbols goog.i18n.DateTimeSymbols_ga}

  ; Galician
  "gl" {:number-format-symbols goog.i18n.NumberFormatSymbols_gl
        :date-time-symbols goog.i18n.DateTimeSymbols_gl}

  ; Swiss German
  "gsw" {:number-format-symbols goog.i18n.NumberFormatSymbols_gsw}
        :date-time-symbols goog.i18n.DateTimeSymbols_gsw

  ; Gujarati
  "gu" {:number-format-symbols goog.i18n.NumberFormatSymbols_gu
        :date-time-symbols goog.i18n.DateTimeSymbols_gu}

  ; Hawaiian
  "haw" {:number-format-symbols goog.i18n.NumberFormatSymbols_haw
         :date-time-symbols goog.i18n.DateTimeSymbols_haw}

  ; Hebrew
  "he" {:number-format-symbols goog.i18n.NumberFormatSymbols_he
        :date-time-symbols goog.i18n.DateTimeSymbols_he}

  ; Hindi
  "hi" {:number-format-symbols goog.i18n.NumberFormatSymbols_hi
        :date-time-symbols goog.i18n.DateTimeSymbols_hi}

  ; Croatian
  "hr" {:number-format-symbols goog.i18n.NumberFormatSymbols_hr
        :date-time-symbols goog.i18n.DateTimeSymbols_hr}

  ; Hungarian
  "hu" {:number-format-symbols goog.i18n.NumberFormatSymbols_hu
        :date-time-symbols goog.i18n.DateTimeSymbols_hu}

  ; Armenian
  "hy" {:number-format-symbols goog.i18n.NumberFormatSymbols_hy
        :date-time-symbols goog.i18n.DateTimeSymbols_hy}

  ; Indonesian
  "id" {:number-format-symbols goog.i18n.NumberFormatSymbols_id
        :date-time-symbols goog.i18n.DateTimeSymbols_id}

  ; Indonesian - ISO 639:1988
  "in" {:number-format-symbols goog.i18n.NumberFormatSymbols_in
        :date-time-symbols goog.i18n.DateTimeSymbols_in}

  ; Icelandic
  "is" {:number-format-symbols goog.i18n.NumberFormatSymbols_is
        :date-time-symbols goog.i18n.DateTimeSymbols_is}

  ; Italian
  "it" {:number-format-symbols goog.i18n.NumberFormatSymbols_it
        :date-time-symbols goog.i18n.DateTimeSymbols_it}

  ; Hebrew - ISO 639:1988
  "iw" {:number-format-symbols goog.i18n.NumberFormatSymbols_iw
        :date-time-symbols goog.i18n.DateTimeSymbols_iw}

  ; Japanese
  "ja" {:number-format-symbols goog.i18n.NumberFormatSymbols_ja
        :date-time-symbols goog.i18n.DateTimeSymbols_ja}

  ; Georgian
  "ka" {:number-format-symbols goog.i18n.NumberFormatSymbols_ka
        :date-time-symbols goog.i18n.DateTimeSymbols_ka}

  ; Kazakh
  "kk" {:number-format-symbols goog.i18n.NumberFormatSymbols_kk
        :date-time-symbols goog.i18n.DateTimeSymbols_kk}

  ; Central Khmer
  "km" {:number-format-symbols goog.i18n.NumberFormatSymbols_km
        :date-time-symbols goog.i18n.DateTimeSymbols_km}

  ; Kannada
  "kn" {:number-format-symbols goog.i18n.NumberFormatSymbols_kn
        :date-time-symbols goog.i18n.DateTimeSymbols_kn}

  ; Korean
  "ko" {:number-format-symbols goog.i18n.NumberFormatSymbols_ko
        :date-time-symbols goog.i18n.DateTimeSymbols_ko}

  ; Kirghiz
  "ky" {:number-format-symbols goog.i18n.NumberFormatSymbols_ky
        :date-time-symbols goog.i18n.DateTimeSymbols_ky}

  ; Lingala
  "ln" {:number-format-symbols goog.i18n.NumberFormatSymbols_ln
        :date-time-symbols goog.i18n.DateTimeSymbols_ln}

  ; Lao
  "lo" {:number-format-symbols goog.i18n.NumberFormatSymbols_lo
        :date-time-symbols goog.i18n.DateTimeSymbols_lo}

  ; Lithuanian
  "lt" {:number-format-symbols goog.i18n.NumberFormatSymbols_lt
        :date-time-symbols goog.i18n.DateTimeSymbols_lt}

  ; Latvian
  "lv" {:number-format-symbols goog.i18n.NumberFormatSymbols_lv
        :date-time-symbols goog.i18n.DateTimeSymbols_lv}

  ; Macedonian
  "mk" {:number-format-symbols goog.i18n.NumberFormatSymbols_mk
        :date-time-symbols goog.i18n.DateTimeSymbols_mk}

  ; Malayalam
  "ml" {:number-format-symbols goog.i18n.NumberFormatSymbols_ml
        :date-time-symbols goog.i18n.DateTimeSymbols_ml}

  ; Mongolian
  "mn" {:number-format-symbols goog.i18n.NumberFormatSymbols_mn
        :date-time-symbols goog.i18n.DateTimeSymbols_mn}

  ; Romanian - Deprecated
  "mo" {:number-format-symbols goog.i18n.NumberFormatSymbols_mo
        :date-time-symbols goog.i18n.DateTimeSymbols_mo}

  ; Marathi
  "mr" {:number-format-symbols goog.i18n.NumberFormatSymbols_mr
        :date-time-symbols goog.i18n.DateTimeSymbols_mr}

  ; Malay
  "ms" {:number-format-symbols goog.i18n.NumberFormatSymbols_ms
        :date-time-symbols goog.i18n.DateTimeSymbols_ms}

  ; Maltese
  "mt" {:number-format-symbols goog.i18n.NumberFormatSymbols_mt
        :date-time-symbols goog.i18n.DateTimeSymbols_mt}

  ; Burmese
  "my" {:number-format-symbols goog.i18n.NumberFormatSymbols_my
        :date-time-symbols goog.i18n.DateTimeSymbols_my}

  ; Norwegian
  "nb" {:number-format-symbols goog.i18n.NumberFormatSymbols_nb
        :date-time-symbols goog.i18n.DateTimeSymbols_nb}

  ; Nepali
  "ne" {:number-format-symbols goog.i18n.NumberFormatSymbols_ne
        :date-time-symbols goog.i18n.DateTimeSymbols_ne}

  ; Dutch
  "nl" {:number-format-symbols goog.i18n.NumberFormatSymbols_nl
        :date-time-symbols goog.i18n.DateTimeSymbols_nl}

  ; Norwegian
  "no" {:number-format-symbols goog.i18n.NumberFormatSymbols_no
        :date-time-symbols goog.i18n.DateTimeSymbols_no}

  ; Norwegian - Norway
  "no-NO" {:number-format-symbols goog.i18n.NumberFormatSymbols_no_NO
           :date-time-symbols goog.i18n.DateTimeSymbols_no_NO}

  ; Oriya
  "or" {:number-format-symbols goog.i18n.NumberFormatSymbols_or
        :date-time-symbols goog.i18n.DateTimeSymbols_or}

  ; Panjabi
  "pa" {:number-format-symbols goog.i18n.NumberFormatSymbols_pa
        :date-time-symbols goog.i18n.DateTimeSymbols_pa}

  ; Polish
  "pl" {:number-format-symbols goog.i18n.NumberFormatSymbols_pl
        :date-time-symbols goog.i18n.DateTimeSymbols_pl}

  ; Portuguese
  "pt" {:number-format-symbols goog.i18n.NumberFormatSymbols_pt
        :date-time-symbols goog.i18n.DateTimeSymbols_pt}

  ; Portuguese - Brazil
  "pt-BR" {:number-format-symbols goog.i18n.NumberFormatSymbols_pt_BR
           :date-time-symbols goog.i18n.DateTimeSymbols_pt_BR}

  ; Portuguese - Portugal
  "pt-PT" {:number-format-symbols goog.i18n.NumberFormatSymbols_pt_PT
           :date-time-symbols goog.i18n.DateTimeSymbols_pt_PT}

  ; Romanian
  "ro" {:number-format-symbols goog.i18n.NumberFormatSymbols_ro
        :date-time-symbols goog.i18n.DateTimeSymbols_ro}

  ; Russian
  "ru" {:number-format-symbols goog.i18n.NumberFormatSymbols_ru
        :date-time-symbols goog.i18n.DateTimeSymbols_ru}

  ; ???
  "sh" {:number-format-symbols goog.i18n.NumberFormatSymbols_sh
        :date-time-symbols goog.i18n.DateTimeSymbols_sh}

  ; Sinhala
  "si" {:number-format-symbols goog.i18n.NumberFormatSymbols_si
        :date-time-symbols goog.i18n.DateTimeSymbols_si}

  ; Slovak
  "sk" {:number-format-symbols goog.i18n.NumberFormatSymbols_sk
        :date-time-symbols goog.i18n.DateTimeSymbols_sk}

  ; Slovenian
  "sl" {:number-format-symbols goog.i18n.NumberFormatSymbols_sl
        :date-time-symbols goog.i18n.DateTimeSymbols_sl}

  ; Albanian
  "sq" {:number-format-symbols goog.i18n.NumberFormatSymbols_sq
        :date-time-symbols goog.i18n.DateTimeSymbols_sq}

  ; Serbian
  "sr" {:number-format-symbols goog.i18n.NumberFormatSymbols_sr
        :date-time-symbols goog.i18n.DateTimeSymbols_sr}

  ; Serbian - Latin
  "sr-Latn" {:number-format-symbols goog.i18n.NumberFormatSymbols_sr_Latn
             :date-time-symbols goog.i18n.DateTimeSymbols_sr_Latn}

  ; Swedish
  "sv" {:number-format-symbols goog.i18n.NumberFormatSymbols_sv
        :date-time-symbols goog.i18n.DateTimeSymbols_sv}

  ; Swahili
  "sw" {:number-format-symbols goog.i18n.NumberFormatSymbols_sw
        :date-time-symbols goog.i18n.DateTimeSymbols_sw}

  ; Tamil
  "ta" {:number-format-symbols goog.i18n.NumberFormatSymbols_ta
        :date-time-symbols goog.i18n.DateTimeSymbols_ta}

  ; Telugu
  "te" {:number-format-symbols goog.i18n.NumberFormatSymbols_te
        :date-time-symbols goog.i18n.DateTimeSymbols_te}

  ; Thai
  "th" {:number-format-symbols goog.i18n.NumberFormatSymbols_th
        :date-time-symbols goog.i18n.DateTimeSymbols_th}

  ; Tagalog
  "tl" {:number-format-symbols goog.i18n.NumberFormatSymbols_tl
        :date-time-symbols goog.i18n.DateTimeSymbols_tl}

  ; Turkish
  "tr" {:number-format-symbols goog.i18n.NumberFormatSymbols_tr
        :date-time-symbols goog.i18n.DateTimeSymbols_tr}

  ; Ukrainian
  "uk" {:number-format-symbols goog.i18n.NumberFormatSymbols_uk
        :date-time-symbols goog.i18n.DateTimeSymbols_uk}

  ; Urdu
  "ur" {:number-format-symbols goog.i18n.NumberFormatSymbols_ur
        :date-time-symbols goog.i18n.DateTimeSymbols_ur}

  ; Uzbek
  "uz" {:number-format-symbols goog.i18n.NumberFormatSymbols_uz
        :date-time-symbols goog.i18n.DateTimeSymbols_uz}

  ; Vietnamese
  "vi" {:number-format-symbols goog.i18n.NumberFormatSymbols_vi
        :date-time-symbols goog.i18n.DateTimeSymbols_vi}

  ; Chinese
  "zh" {:number-format-symbols goog.i18n.NumberFormatSymbols_zh
        :date-time-symbols goog.i18n.DateTimeSymbols_zh}

  ; Chinese - China
  "zh-CN" {:number-format-symbols goog.i18n.NumberFormatSymbols_zh_CN
           :date-time-symbols goog.i18n.DateTimeSymbols_zh_CN}

  ; Chinese - Hong Kong
  "zh-HK" {:number-format-symbols goog.i18n.NumberFormatSymbols_zh_HK
           :date-time-symbols goog.i18n.DateTimeSymbols_zh_HK}

  ; Chinese - Taiwan
  "zh-TW" {:number-format-symbols goog.i18n.NumberFormatSymbols_zh_TW
           :date-time-symbols goog.i18n.DateTimeSymbols_zh_TW}

  ; Zulu
  "zu" {:number-format-symbols goog.i18n.NumberFormatSymbols_zu
        :date-time-symbols goog.i18n.DateTimeSymbols_zu}})
