(ns i18n.data
 (:require
  goog.i18n.NumberFormatSymbols
  goog.i18n.DateTimeSymbols))

(def locales
 (let
  [ls
   ; All english speaking locales considered common for app dev by google.
   {"en" {:number-format-symbols goog.i18n.NumberFormatSymbols_en
          :date-time-symbols goog.i18n.DateTimeSymbols_en}

    ; Australia.
    "en-AU" {:number-format-symbols goog.i18n.NumberFormatSymbols_en_AU
             :date-time-symbols goog.i18n.DateTimeSymbols_en_AU}

    ; Canada.
    "en-CA" {:number-format-symbols goog.i18n.NumberFormatSymbols_en_CA
             :date-time-symbols goog.i18n.DateTimeSymbols_en_CA}

    ; Great Britain.
    "en-GB" {:number-format-symbols goog.i18n.NumberFormatSymbols_en_GB
             :date-time-symbols goog.i18n.DateTimeSymbols_en_GB}

    ; Ireland.
    "en-IE" {:number-format-symbols goog.i18n.NumberFormatSymbols_en_IE
             :date-time-symbols goog.i18n.DateTimeSymbols_en_IE}

    ; India.
    "en-IN" {:number-format-symbols goog.i18n.NumberFormatSymbols_en_IN
             :date-time-symbols goog.i18n.DateTimeSymbols_en_IN}

    ; Singapore.
    "en-SG" {:number-format-symbols goog.i18n.NumberFormatSymbols_en_SG
             :date-time-symbols goog.i18n.DateTimeSymbols_en_SG}

    ; America.
    "en-US" {:number-format-symbols goog.i18n.NumberFormatSymbols_en_US
             :date-time-symbols goog.i18n.DateTimeSymbols_en_US}

    ; South Africa.
    "en-ZA" {:number-format-symbols goog.i18n.NumberFormatSymbols_en_ZA
             :date-time-symbols goog.i18n.DateTimeSymbols_en_ZA}

    ; Galic language not really supported atm, but is included as a helpful
    ; example for testing because it is so obviously different.
    "gl" {:number-format-symbols goog.i18n.NumberFormatSymbols_gl
          :date-time-symbols goog.i18n.DateTimeSymbols_gl}}]
  (merge ls {:default (get ls "en")})))
