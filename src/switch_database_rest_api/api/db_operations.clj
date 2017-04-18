(ns switch-database-rest-api.api.db-operations
  (:require [switch-database-rest-api.core :refer [call-api check-required-params with-collection-format]])
  (:import (java.io File)))

(defn add-post-with-http-info
  "Add is used for adding a data object to the list created at Switch DB.
  You can choose the list that will be added tha data set to with List parameter that will be sent to Header. It's equal to INSERT query at the relational databases model. The data set that will be added to the database is transmited at request body. For versions upper than v1.2.1, if the data sent is an array, all items in the array are added one by one, so they are added as a whole."
  [api-key access-token list body ]
  (call-api "/Add" :post
            {:path-params   {}
             :header-params {"APIKey" api-key "AccessToken" access-token "List" list }
             :query-params  {}
             :form-params   {}
             :body-param    body
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn add-post
  "Add is used for adding a data object to the list created at Switch DB.
  You can choose the list that will be added tha data set to with List parameter that will be sent to Header. It's equal to INSERT query at the relational databases model. The data set that will be added to the database is transmited at request body. For versions upper than v1.2.1, if the data sent is an array, all items in the array are added one by one, so they are added as a whole."
  [api-key access-token list body ]
  (:data (add-post-with-http-info api-key access-token list body)))

(defn list-post-with-http-info
  "It's used for listing a data added before.
  List parameter sent remarks the list that will be do listing work on at Header. It's equal to SELECT query at relational databases."
  [api-key access-token list body ]
  (call-api "/List" :post
            {:path-params   {}
             :header-params {"APIKey" api-key "AccessToken" access-token "List" list }
             :query-params  {}
             :form-params   {}
             :body-param    body
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn list-post
  "It's used for listing a data added before.
  List parameter sent remarks the list that will be do listing work on at Header. It's equal to SELECT query at relational databases."
  [api-key access-token list body ]
  (:data (list-post-with-http-info api-key access-token list body)))

(defn set-delete-with-http-info
  "It's used for deleting a data added before at Switch DB.
  List parameter sent remarks the list that will be deleted data from at Header and ListItemId parameter remarks the ID consisted by Switch DB for the data that will be deleted. It's equal to DELETE query at relational databases."
  [api-key access-token list list-item-id ]
  (call-api "/Set" :delete
            {:path-params   {}
             :header-params {"APIKey" api-key "AccessToken" access-token "List" list "ListItemId" list-item-id }
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn set-delete
  "It's used for deleting a data added before at Switch DB.
  List parameter sent remarks the list that will be deleted data from at Header and ListItemId parameter remarks the ID consisted by Switch DB for the data that will be deleted. It's equal to DELETE query at relational databases."
  [api-key access-token list list-item-id ]
  (:data (set-delete-with-http-info api-key access-token list list-item-id)))

(defn set-post-with-http-info
  "It's used for updating a data object that is already added to Switch DB.
  In order to UPDATE a object, Listname and ListItemId parameters should be sent in the Header of the REQUEST as \"List\", \"ListItemId\", respectively, as shown in the example below. It's equal to UPDATE query at relational databases. The data set that will be edited is transmited to the database at request body."
  [api-key access-token list list-item-id body ]
  (call-api "/Set" :post
            {:path-params   {}
             :header-params {"APIKey" api-key "AccessToken" access-token "List" list "ListItemId" list-item-id }
             :query-params  {}
             :form-params   {}
             :body-param    body
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn set-post
  "It's used for updating a data object that is already added to Switch DB.
  In order to UPDATE a object, Listname and ListItemId parameters should be sent in the Header of the REQUEST as \"List\", \"ListItemId\", respectively, as shown in the example below. It's equal to UPDATE query at relational databases. The data set that will be edited is transmited to the database at request body."
  [api-key access-token list list-item-id body ]
  (:data (set-post-with-http-info api-key access-token list list-item-id body)))

