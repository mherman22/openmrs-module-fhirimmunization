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

import io.swagger.models.Model;
import io.swagger.models.ModelImpl;
import io.swagger.models.properties.IntegerProperty;
import io.swagger.models.properties.RefProperty;
import io.swagger.models.properties.StringProperty;
import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.hibernate.metamodel.source.binder.IdentifierSource;
import org.openmrs.api.context.Context;
import org.openmrs.module.procedure.Procedure;
import org.openmrs.module.procedure.api.ProcedureService;
import org.openmrs.module.webservices.rest.web.RequestContext;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.annotation.PropertyGetter;
import org.openmrs.module.webservices.rest.web.annotation.Resource;
import org.openmrs.module.webservices.rest.web.representation.DefaultRepresentation;
import org.openmrs.module.webservices.rest.web.representation.FullRepresentation;
import org.openmrs.module.webservices.rest.web.representation.RefRepresentation;
import org.openmrs.module.webservices.rest.web.representation.Representation;
import org.openmrs.module.webservices.rest.web.resource.api.PageableResult;
import org.openmrs.module.webservices.rest.web.resource.impl.DelegatingResourceDescription;
import org.openmrs.module.webservices.rest.web.resource.impl.EmptySearchResult;
import org.openmrs.module.webservices.rest.web.resource.impl.MetadataDelegatingCrudResource;
import org.openmrs.module.webservices.rest.web.resource.impl.NeedsPaging;
import org.openmrs.module.webservices.rest.web.response.ObjectNotFoundException;
import org.openmrs.module.webservices.rest.web.response.ResourceDoesNotSupportOperationException;
import org.openmrs.module.webservices.rest.web.response.ResponseException;

import java.util.ArrayList;
import java.util.List;

@Resource(name = RestConstants.VERSION_1 + "/procedure" + ProcedureResourceController.PROCEDURE_REST_NAMESPACE, supportedClass = Procedure.class, supportedOpenmrsVersions = {
        "1.9.*", "1.10.*", "1.11.*", "1.12.*", "2.0.*", "2.1.*", "2.2.*", "2.3.*", "2.4.*", "2.5.*" })
public class ProcedureResource extends MetadataDelegatingCrudResource<Procedure> {
	
	@Override
	public Procedure getByUniqueId(String procedureId) {
		Procedure procedure = Context.getService(ProcedureService.class).getProcedureByUuid(procedureId);
		if (procedureId == null || procedure == null) {
			throw new ResourceNotFoundException("uuid is required");
		}
		return procedure;
	}
	
	@Override
	public void delete(Procedure procedure, String reason, RequestContext requestContext) throws ResponseException {
		if (Context.getService(ProcedureService.class).getProcedureByProcedureId(procedure.getProcedureId()) == null) {
			throw new ObjectNotFoundException();
		} else {
			Context.getService(ProcedureService.class).deleteProcedure(procedure.getProcedureId(), reason);
		}
	}
	
	@Override
	public Procedure newDelegate() {
		return new Procedure();
	}
	
	@Override
	public Procedure save(Procedure procedure) {
		Context.getService(ProcedureService.class).saveProcedure(procedure);
		return procedure;
	}
	
	@PropertyGetter("display")
	public String getDisplayString(Procedure delegate) {
		if (delegate.getSubject() == null)
			return "";
		
		return delegate.getSubject().getFamilyName();
	}
	
	@Override
	public void purge(Procedure procedure, RequestContext requestContext) throws ResponseException {
		Context.getService(ProcedureService.class).purgeProcedure(procedure);
	}
	
	@Override
	public DelegatingResourceDescription getRepresentationDescription(Representation representation) {
		DelegatingResourceDescription description = new DelegatingResourceDescription();
		if (representation instanceof DefaultRepresentation || representation instanceof RefRepresentation) {
			description.addProperty("uuid");
			description.addProperty("display");
			description.addProperty("procedureId");
			description.addProperty("status");
			description.addProperty("statusReason");
			description.addProperty("category");
			description.addProperty("procedureCode");
			description.addProperty("performerOfTheProcedure");
			description.addProperty("bodySite");
			description.addProperty("outcome");
			description.addProperty("subject", Representation.DEFAULT);
			description.addSelfLink();
			return description;
		} else if (representation instanceof FullRepresentation) {
			description.addProperty("display");
			description.addProperty("uuid");
			description.addProperty("procedureId");
			description.addProperty("status");
			description.addProperty("statusReason");
			description.addProperty("category");
			description.addProperty("procedureCode");
			description.addProperty("performerOfTheProcedure");
			description.addProperty("bodySite");
			description.addProperty("outcome");
			description.addProperty("subject", Representation.FULL);
			description.addProperty("creator");
			description.addProperty("dateCreated");
			description.addProperty("retired");
			description.addProperty("retireReason");
			description.addSelfLink();
			description.addLink("full", ".?v=" + RestConstants.REPRESENTATION_FULL);
			return description;
		}
		return null;
	}
	
	@Override
	public DelegatingResourceDescription getCreatableProperties() {
		DelegatingResourceDescription desc = super.getCreatableProperties();
		desc.addRequiredProperty("procedureId");
		desc.addRequiredProperty("status");
		desc.addRequiredProperty("statusReason");
		desc.addRequiredProperty("category");
		desc.addRequiredProperty("procedureCode");
		desc.addRequiredProperty("performerOfTheProcedure");
		desc.addRequiredProperty("bodySite");
		desc.addRequiredProperty("outcome");
		desc.addRequiredProperty("subject");
		desc.addRequiredProperty("creator");
		desc.addRequiredProperty("dateCreated");
		desc.addRequiredProperty("retired");
		desc.addRequiredProperty("retireReason");
		return desc;
	}
	
	@Override
	public DelegatingResourceDescription getUpdatableProperties() throws ResourceDoesNotSupportOperationException {
		return getCreatableProperties();
	}
	
	@Override
	public Model getGETModel(Representation rep) {
		ModelImpl model = (ModelImpl) super.getGETModel(rep);
		if (rep instanceof DefaultRepresentation || rep instanceof RefRepresentation) {
			model.property("procedureId", new IntegerProperty()).property("display", new StringProperty())
			        .property("status", new StringProperty()).property("statusReason", new StringProperty())
			        .property("category", new StringProperty()).property("procedureCode", new StringProperty())
			        .property("performerOfTheProcedure", new StringProperty()).property("bodySite", new StringProperty())
			        .property("outcome", new StringProperty())
			        .property("subject", new RefProperty("#/definitions/PatientGetRef"));
		}
		return model;
	}
	
	@Override
	public Model getCREATEModel(Representation rep) {
		return getGETModel(rep);
	}
	
	@Override
	public Model getUPDATEModel(Representation rep) {
		return getCREATEModel(rep);
	}
	
	@Override
	protected PageableResult doGetAll(RequestContext context) throws ResponseException {
		return new NeedsPaging<Procedure>(Context.getService(ProcedureService.class).getAllProcedures(), context);
	}
	
	@Override
	protected PageableResult doSearch(RequestContext context) {
		String uuid = context.getRequest().getParameter("uuid");
		if (StringUtils.isNotEmpty(uuid)) {
			List<Procedure> procedures = new ArrayList<Procedure>();
			procedures.add(Context.getService(ProcedureService.class).getProcedureByUuid(uuid));
			return new NeedsPaging<Procedure>(procedures, context);
		}
		return new EmptySearchResult();
	}
}
