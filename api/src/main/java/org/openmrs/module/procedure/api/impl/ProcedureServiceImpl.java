/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.procedure.api.impl;

import org.openmrs.api.APIException;
import org.openmrs.api.UserService;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.procedure.Procedure;
import org.openmrs.module.procedure.api.ProcedureService;
import org.openmrs.module.procedure.api.dao.ProcedureDao;

public class ProcedureServiceImpl extends BaseOpenmrsService implements ProcedureService {
	
	ProcedureDao dao;
	
	UserService userService;
	
	/**
	 * Injected in moduleApplicationContext.xml
	 */
	public void setDao(ProcedureDao dao) {
		this.dao = dao;
	}
	
	/**
	 * Injected in moduleApplicationContext.xml
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	/**
	 * Returns an item by uuid. It can be called by any authenticated user. It is fetched in read
	 * only transaction.
	 * 
	 * @param uuid
	 * @return
	 * @throws APIException
	 */
	@Override
	public Procedure getItemByUuid(String uuid) throws APIException {
		return null;
	}
	
	/**
	 * Saves an item. Sets the owner to superuser, if it is not set. It can be called by users with
	 * this module's privilege. It is executed in a transaction.
	 * 
	 * @param item
	 * @return
	 * @throws APIException
	 */
	@Override
	public Procedure saveItem(Procedure item) throws APIException {
		return null;
	}
	
	//	@Override
	//	public Procedure getItemByUuid(String uuid) throws APIException {
	//		return dao.getItemByUuid(uuid);
	//	}
	
	//	@Override
	//	public Procedure saveItem(Procedure item) throws APIException {
	//		if (item.getOwner() == null) {
	//			item.setOwner(userService.getUser(1));
	//		}
	//
	//		return dao.saveItem(item);
	//	}
}
