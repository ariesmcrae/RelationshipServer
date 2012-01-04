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

import java.net.URLDecoder;
import java.util.List;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import com.ariesmcrae.rel.model.Participant;
import com.ariesmcrae.rel.service.MockRelationshipService;
import com.ariesmcrae.rel.service.RelationshipService;
import com.ariesmcrae.rel.util.RestUtil;


/**
 * @author ariesmcrae.com
 */
public class ParticipantResource extends ServerResource {
	
	private static RelationshipService service = new MockRelationshipService(); //TODO inject.
	private String namespace;
	
	@Get("json")	
	public List<Participant> retrieve() throws Exception {	
		List<Participant> participants = service.retrieveParticipants(namespace);
		
		RestUtil.setResponseHeader(this); //Don't put this in the superclass.  Prefer composition over inheritance.

		return participants;
	}

	
	public void doInit() {
		super.doInit();
		namespace = ((String) getRequestAttributes().get("namespace"));
		
		if (namespace != null && namespace.trim().length() > 0) {
			try {
				namespace = URLDecoder.decode(namespace, "UTF-8");				
			} catch (Exception e) {
				//TODO swallow for now
			}
			//namespace = namespace.replaceAll("%2F", "/");
		}
	}
	
}
