(ns switch-database-rest-api.api.authorization
  (:require [switch-database-rest-api.core :refer [call-api check-required-params with-collection-format]])
  (:import (java.io File)))

(defn token-get-with-http-info
  "Generate Access Token
  For generating Access Token, you need API Key and API Secret parameters that are provided from the developer portal. At the request, API Key that will be sent by using header is generated as portal API Key and Signature parameter is generated as md5(APISecret + ExpireTimestamp) format. At Expire parameter, token's expire date and time information must be proper to ISO 8601 standarts and Unix Time format with msec information."
  [api-key signature expire ]
  (call-api "/Token" :get
            {:path-params   {}
             :header-params {"APIKey" api-key "Signature" signature "Expire" expire }
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn token-get
  "Generate Access Token
  For generating Access Token, you need API Key and API Secret parameters that are provided from the developer portal. At the request, API Key that will be sent by using header is generated as portal API Key and Signature parameter is generated as md5(APISecret + ExpireTimestamp) format. At Expire parameter, token's expire date and time information must be proper to ISO 8601 standarts and Unix Time format with msec information."
  [api-key signature expire ]
  (:data (token-get-with-http-info api-key signature expire)))

