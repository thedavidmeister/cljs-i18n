(ns i18n.locale)

(defn accept-language
 [request]
 {:body (-> request :headers (get "accept-language"))})
