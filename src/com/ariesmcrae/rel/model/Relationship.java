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
package com.ariesmcrae.rel.model;

import java.io.Serializable;


/**
 * @author Aries McRae
 */
public class Relationship implements Serializable {

	private static final long serialVersionUID = 1L;

	private String group;
	private String name;
	private String namespace;

	public Relationship(String newNamespace) {
		namespace = newNamespace;
		extractGroupAndName();
	}
	

	
	private void extractGroupAndName() {
		//namespace may look like this: "http://Lib_AcctionReplica_Static_Relationship/rel/ref/v2/STREET_TYPE_CD";
		//group = Lib_AcctionReplica_Static_Relationship
		//name = STREET_TYPE_CD
		
		//extract group and name from namespace
		int chompPosition = namespace.indexOf("//") + 2;
		String prefix = namespace.substring(chompPosition);

		chompPosition = prefix.indexOf("/");
		group = prefix.substring(0, chompPosition);

		chompPosition = namespace.lastIndexOf("/");
		name = namespace.substring(chompPosition + 1);
	}
	
	
	
	public String getGroup() { return group; }
	public String getName() { return name; }
	public String getNamespace() {return namespace; }
}
