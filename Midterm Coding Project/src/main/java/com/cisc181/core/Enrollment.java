package com.cisc181.core;

import java.util.UUID;

public class Enrollment {
	Section section = new Section();
	private UUID SectionID;
	private UUID StudentID;
	private UUID EnrollmentID;
	private static double Grade;
	private static double GradePoints;
	
	private Enrollment(){
		
	}
	public Enrollment(UUID StudentID, UUID SectionID, double grade, int GradePoints){
		UUID EnrollmentID = UUID.randomUUID();
		this.Grade = grade;
		this.GradePoints = GradePoints;
		
		
	}
	
	public static void SetGrade(double grade){
		Grade = grade;
	}
	
	public double getGPA(){
		double GPA = Grade/GradePoints;
		return GPA;
	}
	public UUID getSectionID() {
		return SectionID;
	}
	public void setSectionID(UUID sectionID) {
		SectionID = sectionID;
	}
	public UUID getStudentID() {
		return StudentID;
	}
	public void setStudentID(UUID studentID) {
		StudentID = studentID;
	}
	public UUID getEnrollmentID() {
		return EnrollmentID;
	}
	public void setEnrollmentID(UUID enrollmentID) {
		EnrollmentID = enrollmentID;
	}
	public static double getGrade() {
		return Grade;
	}
	public static void setGrade(double grade) {
		Grade = grade;
	}
	public static double getGradePoints() {
		return GradePoints;
	}
	public static void setGradePoints(double gradePoints) {
		GradePoints = gradePoints;
	}
	
	
}
