/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.procedure.api;

import org.openmrs.annotation.Authorized;
import org.openmrs.api.APIException;
import org.openmrs.api.OpenmrsService;
import org.openmrs.module.procedure.Procedure;
import org.openmrs.module.procedure.ProcedureConfig;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The main service of this module, which is exposed for other modules. See
 * moduleApplicationContext.xml on how it is wired up.
 */
public interface ProcedureService extends OpenmrsService {
	
	/**
	 * Returns a procedure by uuid. It can be called by any authenticated user. It is fetched in
	 * read only transaction.
	 * 
	 * @param procedureId
	 * @return
	 * @throws APIException
	 */
//	@Authorized()
	@Transactional(readOnly = true)
	Procedure getProcedureByProcedureId(Integer procedureId) throws APIException;
	
	/**
	 * returns all the procedures that have been created.
	 * 
	 * @return
	 */
//	@Authorized()
	@Transactional(readOnly = true)
	List<Procedure> getAllProcedures();
	
	/**
	 * Saves a procedure. Sets the owner to superuser, if it is not set. It can be called by users
	 * with this module's privilege. It is executed in a transaction.
	 * 
	 * @param procedure
	 * @return
	 * @throws APIException
	 */
//	@Authorized(ProcedureConfig.MODULE_PRIVILEGE)
	@Transactional
	Procedure saveProcedure(Procedure procedure) throws APIException;
	
	/**
	 * deletes / purges the specified procedure
	 * 
	 * @param procedure
	 */
	@Authorized(ProcedureConfig.MODULE_PRIVILEGE)
	@Transactional(readOnly = true)
	void purgeProcedure(Procedure procedure);
}
