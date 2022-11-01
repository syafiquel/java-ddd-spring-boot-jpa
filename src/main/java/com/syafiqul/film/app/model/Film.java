package com.syafiqul.film.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.time.LocalDateTime;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Entity
@Table(name = "films")
public class Film {

	private Integer id;
	private String registrationNo;
	private String title;
	private String distributor;
    private String result;
    private String classification;
    private Date submissionDate;
	
	public Film() {
		
	}
	
	public Film(String registrationNo, String title, String distributor, String result, String classification, Date submissionDate) {
		this.registrationNo = registrationNo;
		this.title = title;
		this.distributor = distributor;
        this.result = result;
		this.classification = classification;
		this.submissionDate = submissionDate;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	// @CreationTimestamp
    // private LocalDateTime created_at;
 
    // @UpdateTimestamp
    // private LocalDateTime updated_at;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "registration_no", nullable = false)
	public String getRegistrationNo() {
		return registrationNo;
	}
	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}
	
	@Column(name = "title", nullable = false)
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name = "distributor", nullable = false)
	public String getDistributor() {
		return distributor;
	}
	public void setDistributor(String distributor) {
		this.distributor = distributor;
	}

    @Column(name = "result", nullable = false)
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	@Column(name = "classification", nullable = false)
	public String getClassification() {
		return classification;
	}
	public void setClassification(String classification) {
		this.title = classification;
	}
	
	@Column(name = "submission_date", nullable = false)
	public Date getSubmissionDate() {
		return submissionDate;
	}
	public void setSubmissionDate(Date submissionDate) {
		this.submissionDate = submissionDate;
	}

	@Override
	public String toString() {

		//Dummy date
		String date = "01-01-2022";
		DateFormat df = new SimpleDateFormat(date);
		String strSubmissionDate = df.format(submissionDate);
		return "Film [id=" + id + ", registrationNo=" + registrationNo + ", title=" + title + ", distributor=" + distributor + 
                ", result=" + result + ", classification=" + classification + ", submissionDate= " + strSubmissionDate
				+ "]";
	}
	
}