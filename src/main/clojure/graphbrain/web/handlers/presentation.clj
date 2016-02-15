;   Copyright (c) 2016 CNRS - Centre national de la recherche scientifique.
;   All rights reserved.
;
;   Written by Telmo Menezes <telmo@telmomenezes.com>
;
;   This file is part of GraphBrain.
;
;   GraphBrain is free software: you can redistribute it and/or modify
;   it under the terms of the GNU Affero General Public License as published by
;   the Free Software Foundation, either version 3 of the License, or
;   (at your option) any later version.
;
;   GraphBrain is distributed in the hope that it will be useful,
;   but WITHOUT ANY WARRANTY; without even the implied warranty of
;   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
;   GNU Affero General Public License for more details.
;
;   You should have received a copy of the GNU Affero General Public License
;   along with GraphBrain.  If not, see <http://www.gnu.org/licenses/>.

(ns graphbrain.web.handlers.presentation
  (:use (ring.util response)
        (graphbrain.web.views page))
  (:require [graphbrain.web.cssandjs :as css+js]
            [graphbrain.web.views.presentation :as pres]
            [graphbrain.web.common :as common]))

(defn- js
  []
  "var ptype='presentation';")

(defn handle
  [request]
  (common/log request "presentation")
  (page
   :title "Welcome"
   :css-and-js (css+js/css+js)
   :user nil
   :page :presentation
   :body-fun pres/view
   :js (js)))
