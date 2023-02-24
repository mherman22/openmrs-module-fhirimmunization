package org.openmrs.module.immunizationonfhir.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.openmrs.BaseOpenmrsData;
import org.openmrs.Encounter;
import org.openmrs.Location;
import org.openmrs.Patient;
import org.openmrs.Person;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * An action that is or was performed on or for a patient.
 * This can be a physical intervention like an operation, or less invasive like long term services,
 * counseling, or hypnotherapy.
 * For more information,
 * @see <a href="https://www.hl7.org/fhir/procedure.html">click here</a>
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Table(name = "procedure_tbl")
@Entity
public class Procedure extends BaseOpenmrsData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "status_reason")
	private String statusReason;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "procedure_code")
	private String procedureCode;
	
	@Column(name = "performer_of_the_procedure")
	private Person performerOfTheProcedure;
	
	@Column(name = "recorder_of_the_procedure")
	private Person recorderOfTheProcedure;
	
	@Column(name = "location_of_the_procedure")
	private Location locationOfTheProcedure;
	
	@Column(name = "body_site")
	private String bodySite;
	
	@Column(name = "out_come")
	private String outCome;
	
	@Column(name = "subject")
	private Patient subject;
	
	@Column(name = "encounter")
	private Encounter encounter;
	
	/**
	 * @param integer
	 */
	@Override
	public void setId(Integer integer) {
		
	}
}
