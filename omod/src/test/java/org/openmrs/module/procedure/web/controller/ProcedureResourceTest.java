package org.openmrs.module.procedure.web.controller;

import org.junit.Before;
import org.openmrs.api.context.Context;
import org.openmrs.module.procedure.Procedure;
import org.openmrs.module.procedure.RestTestConstants;
import org.openmrs.module.procedure.api.ProcedureService;
import org.openmrs.module.webservices.rest.web.resource.impl.BaseDelegatingResourceTest;

public class ProcedureResourceTest extends BaseDelegatingResourceTest<ProcedureResource, Procedure> {
	
	@Before
	public void before() throws Exception {
		executeDataSet(RestTestConstants.PROCEDURE_DATA_XML);
	}
	
	@Override
	public Procedure newObject() {
		return Context.getService(ProcedureService.class).getProcedureByProcedureId(Integer.valueOf(getUuidProperty()));
	}
	
	@Override
	public String getDisplayProperty() {
		return "";
	}
	
	@Override
	public String getUuidProperty() {
		return RestTestConstants.PROCEDURE_UUID;
	}
	
	@Override
	public void validateDefaultRepresentation() throws Exception {
		super.validateDefaultRepresentation();
		assertPropPresent("uuid");
	}
}
