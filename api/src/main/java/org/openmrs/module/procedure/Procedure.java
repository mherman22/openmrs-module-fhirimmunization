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
import org.openmrs.Location;
import org.openmrs.Patient;
import org.openmrs.Person;

import java.io.Serializable;

public class Procedure extends BaseOpenmrsData implements Serializable {
	
	private Integer id;
	
	private String status;
	
	private String statusReason;
	
	private String category;
	
	private String procedureCode;
	
	private Person performerOfTheProcedure;
	
	private Person recorderOfTheProcedure;
	
	private Location locationOfTheProcedure;
	
	private String bodySite;
	
	private String outcome;
	
	private Patient subject;
	
	public Procedure() {
	}
	
	public Procedure(Integer id, String status, String statusReason, String category, String procedureCode,
			Person performerOfTheProcedure, Person recorderOfTheProcedure, Location locationOfTheProcedure, String bodySite,
			String outcome, Patient subject) {
		this.id = id;
		this.status = status;
		this.statusReason = statusReason;
		this.category = category;
		this.procedureCode = procedureCode;
		this.performerOfTheProcedure = performerOfTheProcedure;
		this.recorderOfTheProcedure = recorderOfTheProcedure;
		this.locationOfTheProcedure = locationOfTheProcedure;
		this.bodySite = bodySite;
		this.outcome = outcome;
		this.subject = subject;
	}
	
	@Override
	public Integer getId() {
		return null;
	}
	
	@Override
	public void setId(Integer integer) {
	
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
	
	public Person getPerformerOfTheProcedure() {
		return performerOfTheProcedure;
	}
	
	public void setPerformerOfTheProcedure(Person performerOfTheProcedure) {
		this.performerOfTheProcedure = performerOfTheProcedure;
	}
	
	public Person getRecorderOfTheProcedure() {
		return recorderOfTheProcedure;
	}
	
	public void setRecorderOfTheProcedure(Person recorderOfTheProcedure) {
		this.recorderOfTheProcedure = recorderOfTheProcedure;
	}
	
	public Location getLocationOfTheProcedure() {
		return locationOfTheProcedure;
	}
	
	public void setLocationOfTheProcedure(Location locationOfTheProcedure) {
		this.locationOfTheProcedure = locationOfTheProcedure;
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
	
	@Override
	public String toString() {
		return "Procedure{" +
				"id=" + id +
				", status='" + status + '\'' +
				", statusReason='" + statusReason + '\'' +
				", category='" + category + '\'' +
				", procedureCode='" + procedureCode + '\'' +
				", performerOfTheProcedure=" + performerOfTheProcedure +
				", recorderOfTheProcedure=" + recorderOfTheProcedure +
				", locationOfTheProcedure=" + locationOfTheProcedure +
				", bodySite='" + bodySite + '\'' +
				", outcome='" + outcome + '\'' +
				", subject=" + subject +
				'}';
	}
}
