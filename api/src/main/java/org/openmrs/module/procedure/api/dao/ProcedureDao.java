/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.procedure.api.dao;

import org.hibernate.criterion.Restrictions;
import org.openmrs.api.db.hibernate.DbSession;
import org.openmrs.api.db.hibernate.DbSessionFactory;
import org.openmrs.module.procedure.Procedure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository("procedure.ProcedureDao")
public class ProcedureDao {
	
	@Autowired
	DbSessionFactory sessionFactory;
	
	public Procedure getProcedureByProcedureId(Integer procedureId) {
		return (Procedure) sessionFactory.getCurrentSession().get(Procedure.class, procedureId);
	}
	
	public List<Procedure> getAllProcedures() {
		return sessionFactory.getCurrentSession().createCriteria(Procedure.class).list();
	}
	
	public Procedure saveProcedure(Procedure procedure) {
		sessionFactory.getCurrentSession().saveOrUpdate(procedure);
		return procedure;
	}
	
	public void purgeProcedure(Procedure procedure) {
		sessionFactory.getCurrentSession().delete(procedure);
	}
	
	public Procedure getProcedureByUuid(String uuid) {
		return (Procedure) this.sessionFactory.getCurrentSession().createQuery("from Procedure p where p.uuid = :uuid")
		        .setString("uuid", uuid).uniqueResult();
	}
}
