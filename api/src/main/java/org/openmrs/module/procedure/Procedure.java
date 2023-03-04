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
import org.openmrs.User;

import java.io.Serializable;

public class Procedure extends BaseOpenmrsData implements Serializable {
	
	private Integer procedureId;
	
	private String status;
	
	private String statusReason;
	
	private String category;
	
	private String procedureCode;
	
	private User performerOfTheProcedure;
	
	private String bodySite;
	
	private String outcome;
	
	private Patient subject;
	
	public Procedure() {
	}
	public Procedure(Integer procedureId, String status, String statusReason, String category, String procedureCode,
			User performerOfTheProcedure, String bodySite, String outcome, Patient subject) {
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
	
	public User getPerformerOfTheProcedure() {
		return performerOfTheProcedure;
	}
	
	public void setPerformerOfTheProcedure(User performerOfTheProcedure) {
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
		return "Procedure{" +
				"procedureId=" + procedureId +
				", status='" + status + '\'' +
				", statusReason='" + statusReason + '\'' +
				", category='" + category + '\'' +
				", procedureCode='" + procedureCode + '\'' +
				", performerOfTheProcedure='" + performerOfTheProcedure + '\'' +
				", bodySite='" + bodySite + '\'' +
				", outcome='" + outcome + '\'' +
				", subject=" + subject +
				'}';
	}
}
