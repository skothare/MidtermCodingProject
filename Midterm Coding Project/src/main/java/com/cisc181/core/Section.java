package com.cisc181.core;

import java.util.UUID;

public class Section{
	private UUID SectionID;
	private int RoomID;
	private UUID CourseID;
	private UUID SemesterID;
	
	public Section(){
		RoomID = 0;
		
		
	}
	
	public Section(UUID semesterID, UUID courseID){
		SectionID = UUID.randomUUID();
		this.SemesterID = semesterID;
		this.CourseID = courseID;
		
	}

	public UUID getSectionID() {
		return SectionID;
	}

	public UUID getCourseID() {
		return CourseID;
	}

	public void setCourseID(UUID courseID) {
		CourseID = courseID;
	}

	public UUID getSemesterID() {
		return SemesterID;
	}

	public void setSemesterID(UUID semesterID) {
		SemesterID = semesterID;
	}

	public void setSectionID(UUID sectionID) {
		SectionID = sectionID;
	}

	public int getRoomID() {
		return RoomID;
	}

	public void setRoomID(int roomID) {
		RoomID = roomID;
	}
}
