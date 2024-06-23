package com.Libray.manager;

import java.util.Date;

public class Student {
	private String regNumber;
	private String firstName;
	private String otherNames;
	private String level ;
	private String studyClass;
	private String stream;
	private String gender;
	private String bookTitle;
	private Date issueOut;
	private Date issueIn;
	private String status;
	
	
	
	public Student(String regNumber, String firstName, String otherNames, String level, String studyClass,
			String stream, String gender, String bookTitle, Date issueOut) {
		super();
		this.regNumber = regNumber;
		this.firstName = firstName;
		this.otherNames = otherNames;
		this.level = level;
		this.studyClass = studyClass;
		this.stream = stream;
		this.gender = gender;
		this.bookTitle = bookTitle;
		this.issueOut = issueOut;
	}

	public Student(String regNumber, Date issueIn, String status) {
		super();
		this.regNumber = regNumber;
		this.issueIn = issueIn;
		this.status = status;
	}

	public Student(String regNumber, String firstName, String otherNames, String level, String studyClass, String stream,
			String gender, String bookTitle, Date issueOut, Date issueIn, String status) {
		super();
		this.regNumber = regNumber;
		this.firstName = firstName;
		this.otherNames = otherNames;
		this.level = level;
		this.studyClass = studyClass;
		this.stream = stream;
		this.gender = gender;
		this.bookTitle = bookTitle;
		this.issueOut = issueOut;
		this.issueIn = issueIn;
		this.status = status;
	}

	public String getRegNumber() {
		return regNumber;
	}

	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getOtherNames() {
		return otherNames;
	}

	public void setOtherNames(String otherNames) {
		this.otherNames = otherNames;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getStudyClass() {
		return studyClass;
	}

	public void setStudyClass(String studyClass) {
		this.studyClass = studyClass;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public Date getIssueOut() {
		return issueOut;
	}

	public void setIssueOut(Date issueOut) {
		this.issueOut = issueOut;
	}

	public Date getIssueIn() {
		return issueIn;
	}

	public void setIssueIn(Date issueIn) {
		this.issueIn = issueIn;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
