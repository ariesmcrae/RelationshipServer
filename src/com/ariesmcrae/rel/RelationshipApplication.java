/*
 * Copyright 2011 Aries McRae. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ariesmcrae.rel;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

/**
 * @author ariesmcrae.com
 */
public class RelationshipApplication extends Application {
	
    /** Creates a root Restlet that will receive all incoming calls. */
    @Override
    public Restlet createInboundRoot() {
        // Create a router Restlet that routes each call to a new instance of RestResource.
        Router router = new Router(getContext());

        // Defines only one route
        router.attach("", RelationshipResource.class); //corresponds to e.g. http://relationshipserver.appspot.com/relationships. "relationships" is defined in web.xml
        router.attach("/{namespace}", ParticipantResource.class); //corresponds to e.g. http://relationshipserver.appspot.com/relationships/http://Lib_Acction_Extract/rel/ref/v1/REVIEW_RSN_CODE

        return router;
    }
}
