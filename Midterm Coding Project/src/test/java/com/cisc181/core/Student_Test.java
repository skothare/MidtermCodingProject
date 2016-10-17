package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;

public class Student_Test {
	static ArrayList<Course> CourseList = new ArrayList<Course>();
	static ArrayList<Semester> SemesterList = new ArrayList<Semester>();
	static ArrayList<Section> SectionList = new ArrayList<Section>();
	static ArrayList<Student> StudentList = new ArrayList<Student>();
	static ArrayList<Enrollment> EnrollmentList = new ArrayList<Enrollment>();
	@BeforeClass
	public static void setup() throws PersonException {
		// Create instances of Course and a Course List
		Course Java = new Course("Java", 3);
		Course Kinetics = new Course("Kinetics", 3);
		Course Econometrics = new Course("Econometrics",3);
		CourseList.add(Java);
		CourseList.add(Econometrics);
		CourseList.add(Kinetics);
		// Creates instances of Semester and a Semester List
		Semester Fall = new Semester(Date(2013, 8, 31), Date(2013, 12, 20));
		Semester Spring = new Semester(Date(2014, 2, 6), Date(2014, 5, 30));
		SemesterList.add(Fall);
		SemesterList.add(Spring);
		// Creates instances of Sections for the three courses and the two semesters
		Section FJ = new Section(Fall.getSemesterID(),Java.getCourseID());
		Section FE = new Section(Fall.getSemesterID(),Econometrics.getCourseID());
		Section FK = new Section(Fall.getSemesterID(),Kinetics.getCourseID());
		SectionList.add(FJ);
		SectionList.add(FK);
		SectionList.add(FE);
		Section SJ = new Section(Spring.getSemesterID(),Java.getCourseID());
		Section SE = new Section(Spring.getSemesterID(),Econometrics.getCourseID());
		Section SK = new Section(Spring.getSemesterID(),Kinetics.getCourseID());
		SectionList.add(SJ);
		SectionList.add(SK);
		SectionList.add(SE);
		// Create instances of Students and a Student List.
		Student TomP = new Student("Thomas", "John", "Patterson",Date(1990, 5, 25),
				eMajor.BUSINESS, "52 North Petersburg", "302-377-4134", "tjp@udl.edu");
		Student OlgaD = new Student("Olga", "Mary", "Denisovich",Date(1995, 7, 17),
				eMajor.COMPSI, "Vladivostok, Russia", "302-566-1122", "OMD@udl.edu");
		Student SteveG = new Student("Steven", "Cody", "Gable",Date(1992, 2, 5),
				eMajor.CHEM, "Atlanta, GA", "302-772-4354", "scg@udl.edu");
		Student JackieM = new Student("Jackie", "Marie", "Montero",Date(1996, 12, 25),
				eMajor.PHYSICS, "72 Downing St.", "401-447-4134", "jmm@udl.edu");
		Student TammyP = new Student("Tammy", "Jane", "Pearson",Date(1994, 5, 25),
				eMajor.BUSINESS, "21 Sears Avenue", "302-322-4134", "stud@udl.edu");
		Student AdamS = new Student("Adam", "John", "Sanders",Date(1996, 6, 25),
				eMajor.BUSINESS, "5 South Ave.", "402-377-4134", "stud@udl.edu");
		Student KatieF = new Student("Katie", "Alicia", "Fisher",Date(1998, 10, 20),
				eMajor.NURSING, "17 Garland St.", "302-317-4134", "stud@udl.edu");
		Student JoanneB = new Student("Joanne", "John", "Buckingham",Date(1995, 7, 19),
				eMajor.CHEM, "52 Fredericksberg", "302-366-4134", "stud@udl.edu");
		Student RaviK = new Student("Ravi", "Suraj", "Kishan",Date(1996, 11, 13),
				eMajor.COMPSI, "Central Avenue", "302-373-4134", "stud@udl.edu");
		Student NingjaW = new Student("Ningja", "X", "Xian",Date(1993, 6, 5),
				eMajor.NURSING, "52 North Petersburg", "302-344-4134", "stud@udl.edu");
		// Add all elements simultaneously to an arrayList.
		StudentList.addAll(Arrays.asList(TomP, OlgaD, SteveG, TammyP, JackieM, AdamS,
				KatieF, JoanneB, RaviK, NingjaW));
		
		Enrollment S1 = new Enrollment(TomP.getStudentID(),FJ.getSectionID(),12,
				Java.getGradePoints());
		Enrollment S2 = new Enrollment(OlgaD.getStudentID(),SK.getSectionID(),11.1,
				Kinetics.getGradePoints());
		Enrollment S3 = new Enrollment(SteveG.getStudentID(),SE.getSectionID(),5.1,
				Econometrics.getGradePoints());
		EnrollmentList.addAll(Arrays.asList(S1,S2,S3));
		
	}

	public static Date Date(int Year, int Month, int Day){
		// A calendar object is created
		Calendar calendar = Calendar.getInstance();
		// Creates a new date object with the deprecated 3-argument method Date()
		Date date = new Date(Year, (Month - 1), Day);
		// Sets the calendar to the arguments passed in the static method Date(Y,M,D)
		calendar.setTime(date);
		// Returns the new set date to the static method Date(Y,M,D)
		return calendar.getTime();
	}
	
	@Test
	public void test() {
		assertEquals(1, 1);
	}
	/**
	 * Uses a "for-loop" and tests the GPA calculated for each student enrolled.
	 */
	@Test
	public final void testGPA(){
		for(Enrollment Enrollment : EnrollmentList){
			assertEquals(Enrollment.getGPA(),((Enrollment.getGrade())/(Enrollment.getGradePoints())),0.0001);
		}
	}
	/**
	 * Uses assertEquals to test the average of three gradeunits (3,3,3) for the three
	 * courses
	 */
	@Test
	public final void testAverageGrade(){
		int averageGrade = 0;
		int sum = 0;
		for(Course Course : CourseList){
			sum +=Course.getGradePoints();
			averageGrade = sum/(CourseList.size());
		}
		assertEquals(averageGrade, 3);
	}

}