package com.cisc181.core;

import java.util.UUID;
import com.cisc181.eNums.*;

public class Course {
	
	private UUID CourseID;
	private String CourseName;
	private int GradePoints;
	private eMajor eMajor;
	
	public Course(){
		GradePoints = 0;
		
	}
	public Course(String CourseName, int GradePoints){
		this.CourseName = CourseName;
		this.GradePoints = GradePoints;
		CourseID = UUID.randomUUID();
	}
	
	public eMajor geteMajor() {
		return eMajor;
	}

	public void seteMajor(eMajor eMajor) {
		this.eMajor = eMajor;
	}

	// Setters and Getters for private attributes given above.
	public UUID getCourseID() {
		return CourseID;
	}

	public void setCourseID(UUID courseID) {
		CourseID = courseID;
	}

	public String getCourseName() {
		return CourseName;
	}

	public void setCourseName(String courseName) {
		CourseName = courseName;
	}

	public int getGradePoints() {
		return GradePoints;
	}

	public void setGradePoints(int gradePoints) {
		GradePoints = gradePoints;
	}
	

}
