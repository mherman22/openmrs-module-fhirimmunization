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

import org.apache.velocity.exception.ResourceNotFoundException;
import org.openmrs.api.APIException;
import org.openmrs.api.UserService;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.procedure.Procedure;
import org.openmrs.module.procedure.api.ProcedureService;
import org.openmrs.module.procedure.api.dao.ProcedureDao;

import java.util.Date;
import java.util.List;

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
	 * @see ProcedureDao#getProcedureByProcedureId(Integer)
	 */
	@Override
	public Procedure getProcedureByProcedureId(Integer procedureId) throws APIException {
		if (procedureId == null) {
			throw new ResourceNotFoundException("procedure with given id " + procedureId + " not found");
		}
		return dao.getProcedureByProcedureId(procedureId);
	}
	
	@Override
	public Procedure getProcedureByUuid(String uuid) throws APIException {
		if (uuid == null) {
			throw new ResourceNotFoundException("procedure with given uuid " + uuid + " not found");
		}
		return dao.getProcedureByUuid(uuid);
	}
	
	/**
	 * @see ProcedureDao#getAllProcedures()
	 */
	@Override
	public List<Procedure> getAllProcedures() {
		return dao.getAllProcedures();
	}
	
	/**
	 * @see ProcedureDao#saveProcedure(Procedure)
	 */
	@Override
	public Procedure saveProcedure(Procedure procedure) throws APIException {
		return dao.saveProcedure(procedure);
	}
	
	/**
	 * @param procedureId
	 * @param reason
	 */
	@Override
	public void deleteProcedure(Integer procedureId, String reason) {
		Procedure procedure = dao.getProcedureByProcedureId(procedureId);
		if (procedure == null) {
			throw new ResourceNotFoundException("Resource not found");
		}
		procedure.setRetired(true);
		procedure.setDateRetired(new Date());
		procedure.setRetireReason(reason);
		procedure.setRetiredBy(org.openmrs.api.context.Context.getAuthenticatedUser());
		dao.saveProcedure(procedure);
	}
	
	/**
	 * @see ProcedureDao#purgeProcedure(Procedure)
	 */
	@Override
	public void purgeProcedure(Procedure item) {
		dao.purgeProcedure(item);
	}
}
