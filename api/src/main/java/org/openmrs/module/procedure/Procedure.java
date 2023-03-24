/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.procedure;

import org.openmrs.BaseOpenmrsData;
import org.openmrs.Patient;

import java.io.Serializable;

/**
 * This resource is used to record the details of current and historical procedures performed on or for a patient.
 * A procedure is an activity that is performed on, with, or for a patient as part of the provision of care.
 * Examples include surgical procedures, diagnostic procedures, endoscopic procedures, biopsies, counseling, physiotherapy,
 * personal support services, adult day care services, non-emergency transportation, home modification, exercise, etc.
 * Procedures may be performed by a healthcare professional, a service provider, a friend or relative or in some cases by the patient themselves.
 */
public class Procedure extends BaseOpenmrsData implements Serializable {
	
	private Integer procedureId;
	
	/**
	 *
	 * Generally, this will be the in-progress or completed state.
	 * @see <a href="https://www.hl7.org/fhir/procedure-definitions.html#Procedure.status">Procedure.status</a>
	 */
	private String status;
	
	/**
	 * reason for the current status
	 * @see <a href="https://www.hl7.org/fhir/procedure-definitions.html#Procedure.statusReason">Procedure.statusReason</a>
	 */
	private String statusReason;
	
	private String category;
	
	private String procedureCode;
	
	private String performerOfTheProcedure;
	
	private String bodySite;
	
	/**
	 * The outcome of the procedure - did it resolve the reasons for the
	 * procedure being performed?
	 */
	private String outcome;
	
	/**
	 * The person, animal or group on which the procedure was performed.
	 */
	private Patient subject;
	
	public Procedure() {
	}
	
	public Procedure(Integer procedureId, String status, String statusReason, String category, String procedureCode,
	    String performerOfTheProcedure, String bodySite, String outcome, Patient subject) {
		this.procedureId = procedureId;
		this.status = status;
		this.statusReason = statusReason;
		this.category = category;
		this.procedureCode = procedureCode;
		this.performerOfTheProcedure = performerOfTheProcedure;
		this.bodySite = bodySite;
		this.outcome = outcome;
		this.subject = subject;
	}
	
	public Integer getProcedureId() {
		return procedureId;
	}
	
	public void setProcedureId(Integer procedureId) {
		this.procedureId = procedureId;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getStatusReason() {
		return statusReason;
	}
	
	public void setStatusReason(String statusReason) {
		this.statusReason = statusReason;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getProcedureCode() {
		return procedureCode;
	}
	
	public void setProcedureCode(String procedureCode) {
		this.procedureCode = procedureCode;
	}
	
	public String getPerformerOfTheProcedure() {
		return performerOfTheProcedure;
	}
	
	public void setPerformerOfTheProcedure(String performerOfTheProcedure) {
		this.performerOfTheProcedure = performerOfTheProcedure;
	}
	
	public String getBodySite() {
		return bodySite;
	}
	
	public void setBodySite(String bodySite) {
		this.bodySite = bodySite;
	}
	
	public String getOutcome() {
		return outcome;
	}
	
	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}
	
	public Patient getSubject() {
		return subject;
	}
	
	public void setSubject(Patient subject) {
		this.subject = subject;
	}
	
	/**
	 * @return
	 */
	@Override
	public Integer getId() {
		return null;
	}
	
	/**
	 * @param integer
	 */
	@Override
	public void setId(Integer integer) {
		
	}
	
	@Override
	public String toString() {
		return "Procedure{" + "procedureId=" + procedureId + ", status='" + status + '\'' + ", statusReason='"
		        + statusReason + '\'' + ", category='" + category + '\'' + ", procedureCode='" + procedureCode + '\''
		        + ", performerOfTheProcedure='" + performerOfTheProcedure + '\'' + ", bodySite='" + bodySite + '\''
		        + ", outcome='" + outcome + '\'' + ", subject=" + subject + '}';
	}
}
