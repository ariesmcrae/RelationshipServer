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
package com.ariesmcrae.rel.service;

import java.util.ArrayList;
import java.util.List;

import com.ariesmcrae.rel.model.Participant;
import com.ariesmcrae.rel.model.Relationship;


/**
 * @author ariesmcrae.com
 */
public class MockRelationshipService implements RelationshipService {

	
//	private static final Logger log = Logger.getLogger(MockRelationshipService.class.getName());
	
	public List<Relationship> retrieveRelationships() {
		List<Relationship> relationships = new ArrayList<Relationship>();
		
		relationships.add(new Relationship("http://Lib_AcctionReplica_Static_Relationship/rel/ref/v2/STREET_TYPE_CD"));
		relationships.add(new Relationship("http://Lib_Acction_Extract/rel/ref/v1/REVIEW_RSN_CODE"));
		relationships.add(new Relationship("http://Lib_Acction_Extract/rel/ref/v1/ABC_CODE"));
		relationships.add(new Relationship("http://Lib_Acction_Extract/rel/ref/v1/DEF_CODE"));
		relationships.add(new Relationship("http://Lib_Acction_Extract/rel/ref/v1/GHI_CODE"));	
		relationships.add(new Relationship("http://Lib_Acction_Extract/rel/ref/v1/JKL_CODE"));
		relationships.add(new Relationship("http://Lib_Acction_Extract/rel/ref/v1/MNO_CODE"));
		relationships.add(new Relationship("http://Lib_Acction_Extract/rel/ref/v1/PQR_CODE"));	
		relationships.add(new Relationship("http://Lib_Acction_Extract/rel/ref/v1/STU_CODE"));
		relationships.add(new Relationship("http://Lib_Acction_Extract/rel/ref/v1/VWX_CODE"));
		relationships.add(new Relationship("http://Lib_Acction_Extract/rel/ref/v1/YZO_CODE"));		
		
		
		return relationships;
	}

	
	
	
	public List<Participant> retrieveParticipants(String namespace) {
		List<Participant> participants = new ArrayList<Participant>();

		if ("http://Lib_AcctionReplica_Static_Relationship/rel/ref/v2/STREET_TYPE_CD".equals(namespace)) {
			participants.add(new Participant("ST", "Street", "Street"));
			participants.add(new Participant("CR", "Crescent", "Crescent"));
			participants.add(new Participant("WY", "Way", "NoWay"));
			participants.add(new Participant("BLV", "Boulevard", "Street"));
			
		} else if ("http://Lib_Acction_Extract/rel/ref/v1/REVIEW_RSN_CODE".equals(namespace)) {
			participants.add(new Participant("01", "Not Registered", "Not Registered"));
			participants.add(new Participant("02", "Not Allowed", "Not Allowed"));
			participants.add(new Participant("03", "Too Many Penalties", "Too Many Penalties"));			
		}
		
		return participants;
	}
	
}
