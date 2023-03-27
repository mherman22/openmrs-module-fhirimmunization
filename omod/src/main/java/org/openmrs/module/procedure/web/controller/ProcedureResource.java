/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.procedure.web.controller;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.openmrs.api.context.Context;
import org.openmrs.module.procedure.Procedure;
import org.openmrs.module.procedure.api.ProcedureService;
import org.openmrs.module.webservices.rest.web.RequestContext;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.annotation.Resource;
import org.openmrs.module.webservices.rest.web.representation.Representation;
import org.openmrs.module.webservices.rest.web.resource.impl.DelegatingCrudResource;
import org.openmrs.module.webservices.rest.web.resource.impl.DelegatingResourceDescription;
import org.openmrs.module.webservices.rest.web.response.ObjectNotFoundException;
import org.openmrs.module.webservices.rest.web.response.ResponseException;

@Resource(name = RestConstants.VERSION_1 + "/procedure", supportedClass = Procedure.class, supportedOpenmrsVersions = {
        "2.4.*", "2.5.*", "2.6.*" })
public class ProcedureResource extends DelegatingCrudResource<Procedure> {
	
	/**
	 * gets procedure by unique identifier
	 * 
	 * @param procedureId
	 * @return
	 */
	@Override
	public Procedure getByUniqueId(String procedureId) {
		Integer procedId = Integer.valueOf(procedureId);
		Procedure procedure = Context.getService(ProcedureService.class).getProcedureByProcedureId(procedId);
		if (procedureId == null || procedure == null) {
			throw new ResourceNotFoundException("procedure id is required");
		}
		return procedure;
	}
	
	/**
	 * @param procedure
	 * @param reason
	 * @param requestContext
	 * @throws ResponseException
	 */
	@Override
	protected void delete(Procedure procedure, String reason, RequestContext requestContext) throws ResponseException {
		if (Context.getService(ProcedureService.class).getProcedureByProcedureId(procedure.getProcedureId()) == null) {
			throw new ObjectNotFoundException();
		} else {
			Context.getService(ProcedureService.class).deleteProcedure(procedure.getProcedureId(), reason);
		}
	}
	
	/**
	 * @return
	 */
	@Override
	public Procedure newDelegate() {
		return new Procedure();
	}
	
	/**
	 * @param procedure
	 * @return
	 */
	@Override
	public Procedure save(Procedure procedure) {
		return Context.getService(ProcedureService.class).saveProcedure(procedure);
	}
	
	/**
	 * @param procedure
	 * @param requestContext
	 * @throws ResponseException
	 */
	@Override
	public void purge(Procedure procedure, RequestContext requestContext) throws ResponseException {
		Context.getService(ProcedureService.class).purgeProcedure(procedure);
	}
	
	/**
	 * @param representation
	 * @return
	 */
	@Override
	public DelegatingResourceDescription getRepresentationDescription(Representation representation) {
		return null;
	}
}
