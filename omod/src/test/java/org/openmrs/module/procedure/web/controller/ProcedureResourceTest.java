package org.openmrs.module.procedure.web.controller;

import org.junit.Before;
import org.openmrs.api.context.Context;
import org.openmrs.module.procedure.Procedure;
import org.openmrs.module.procedure.RestTestConstants;
import org.openmrs.module.procedure.api.ProcedureService;
import org.openmrs.module.webservices.rest.web.resource.impl.BaseDelegatingResourceTest;

public class ProcedureResourceTest extends BaseDelegatingResourceTest<ProcedureResource, Procedure> {
	
	@Before
	public void executeBeforeEachTest() throws Exception {
		executeDataSet(RestTestConstants.PROCEDURE_DATA_XML);
		System.out.println("loading of the dataset is done");
	}
	
	@Override
	public String getUuidProperty() {
		return RestTestConstants.PROCEDURE_UUID;
	}
	
	@Override
	public Procedure newObject() {
		return Context.getService(ProcedureService.class).getProcedureByUuid(getUuidProperty());
	}
	
	@Override
	public String getDisplayProperty() {
		return "maluge";
	}
	
	@Override
	public void validateDefaultRepresentation() throws Exception {
		super.validateDefaultRepresentation();
		assertPropPresent("procedureId");
		assertPropPresent("status");
		assertPropPresent("statusReason");
		assertPropPresent("category");
		assertPropPresent("procedureCode");
		assertPropPresent("performerOfTheProcedure");
		assertPropPresent("bodySite");
		assertPropPresent("outcome");
		assertPropPresent("subject");
	}
	
	@Override
	public void validateFullRepresentation() throws Exception {
		super.validateFullRepresentation();
		assertPropPresent("procedureId");
		assertPropPresent("status");
		assertPropPresent("statusReason");
		assertPropPresent("category");
		assertPropPresent("procedureCode");
		assertPropPresent("performerOfTheProcedure");
		assertPropPresent("bodySite");
		assertPropPresent("outcome");
		assertPropPresent("subject");
		assertPropPresent("creator");
		assertPropPresent("dateCreated");
		assertPropPresent("retired");
		assertPropPresent("retireReason");
	}
}
