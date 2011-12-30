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
package com.ariesmcrae.rel.util;

import org.restlet.data.Form;
import org.restlet.resource.ServerResource;

/**
 * @author ariesmcrae.com
 */
public final class RestUtil {

	/**
	 * Don't put this in the superclass of *Resource.  Prefer composition over inheritance. 
	 * @param serverResource
	 */
	public static void setResponseHeader(ServerResource serverResource) {
		final String RESPONSE_HEADERS = "org.restlet.http.headers";
		
	    Form responseHeaders = (Form) serverResource.getResponse().getAttributes().get(RESPONSE_HEADERS);
	    
	    if (responseHeaders == null) {
	        responseHeaders = new Form();
	        serverResource.getResponse().getAttributes().put(RESPONSE_HEADERS, responseHeaders);
	    }
	    
	    responseHeaders.add("Access-Control-Allow-Origin", "*");
	}
	
}
