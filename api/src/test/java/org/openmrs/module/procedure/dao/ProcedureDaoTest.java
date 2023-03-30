/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.procedure.dao;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import org.openmrs.module.procedure.Procedure;
import org.openmrs.module.procedure.api.dao.ProcedureDao;
import org.openmrs.test.BaseModuleContextSensitiveTest;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * It is an integration test (extends BaseModuleContextSensitiveTest), which verifies DAO methods
 * against the in-memory H2 database. The database is initially loaded with data from
 * standardTestDataset.xml in openmrs-api. All test methods are executed in transactions, which are
 * rolled back by the end of each test method.
 */
public class ProcedureDaoTest extends BaseModuleContextSensitiveTest {
	
	protected static final String PROCEDURE_XML = "org/openmrs/module/procedure/include/ProcedureTestDataset.xml";
	
	@Autowired
	ProcedureDao dao;
	
	@Before
	public void runBeforeEachTest() {
		executeDataSet(PROCEDURE_XML);
		System.out.println("procedure_xml is done loading");
	}
	
	@Test
	public void saveProcedure_shouldSaveAllPropertiesInDb() {
		//Given
		Patient subject = new Patient(53);
		subject.getFamilyName();
		Procedure procedure = dao.getProcedureByProcedureId(100);
		//When
		dao.saveProcedure(procedure);
		Context.flushSession();
		Context.clearSession();
		
		//Then
		Procedure savedProcedure = dao.getProcedureByUuid("494B45B8-6E4E-4708-AUFD-5CE77BFCC067");
		
		assertThat(savedProcedure, hasProperty("uuid", is(procedure.getUuid())));
		assertThat(savedProcedure, hasProperty("status", is(procedure.getStatus())));
		assertThat(savedProcedure, hasProperty("statusReason", is(procedure.getStatusReason())));
		assertThat(savedProcedure, hasProperty("procedureCode", is(procedure.getProcedureCode())));
	}
}
