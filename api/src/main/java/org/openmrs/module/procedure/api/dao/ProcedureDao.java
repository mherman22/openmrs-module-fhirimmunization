package org.openmrs.module.procedure.api.dao;

import org.openmrs.module.procedure.api.model.Procedure;

import java.util.List;

/**
 * procedure-related database functions
 */
public interface ProcedureDao {
	public Procedure saveProcedure(Procedure procedure);
	
	public Procedure getProcedure(String procedure);
	
	public Procedure getProcedureById(Integer procedureId);
	
	public Procedure getProcedureBySubject(String subject);
	
	public List<Procedure> getAllProcedures(String procedures);

}
