package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.BeforeClass;
import org.junit.Test;
import java.util.Date;
import com.cisc181.eNums.eTitle;
import com.cisc181.core.Staff;
import com.cisc181.core.*;
import com.cisc181.core.PersonException;

public class Staff_Test {
	
	static ArrayList<Staff> StaffList = new ArrayList<Staff>();
	
	@BeforeClass
	public static void setup() throws PersonException {
		/**
		 * Create new Staff instances and add them to the ArrayList in the Before class
		 * This provides access to the ArrayList for every Test to run 
		 */
		Staff TaylorP = new Staff("Taylor", "Elizabeth", "Pearson", Date(1995, 7, 20) , "500 Independence, DE", "302-911-1111", "tep@udel.edu", "4pm-5pm, MW", 0, 10000, Date(2015,07,21), eTitle.MS);
		Staff SherlockH = new Staff("Sherlock", "William Scott", "Holmes", Date(1995, 7, 15) , "221B Baker Street", "303-333-4444", "SH@london.com", "4pm-5pm, TF", 0, 11000, Date(2015,12,12), eTitle.MR);
		Staff HermioneGW = new Staff("Hermione", "Isabelle", "Granger-Weasley", Date(1990, 5, 14) , "Diagon Alley", "301-224-3020", "HGW@Hogwarts.com", "8am-10am, TF", 0, 20000, Date(2013,10,2), eTitle.MRS);
		Staff JamesK = new Staff("James", "Tiberius", "Kirk", Date(2100, 2, 29) , "USS Enterprise", "924 721 2224", "JTK@USSE.com", "12pm-1pm, MF", 0, 100000, Date(2121,12,12), eTitle.MR);
		Staff GandhiMK = new Staff("Mohandas", "Karamchand", "Gandhi", Date(1869, 10, 2) , "Porbander, India", "302-376-3171", "MKGandhi@1947.in", "4pm-5pm, MWF", 0, 50000.50, Date(1940,8,11), eTitle.MR);
		StaffList.add(TaylorP);
		StaffList.add(SherlockH);
		StaffList.add(HermioneGW);
		StaffList.add(JamesK);
		StaffList.add(GandhiMK);
		
	}
	
	@Test
	public void test() {
		assertEquals(1,1);
	}	
	/**
	 * java.util.Calendar.setTime() Method
	 * @param Year
	 * @param Month
	 * @param Day
	 * @return
	 */
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
	public final void testSalary() throws PersonException{
		/*for(int counter = 0; counter <= StaffList.size(); counter++){
			double SumSalary += Staff;
		}*/
		double SumSalary = 0.0;
		for (Staff Staff: StaffList){
			SumSalary += Staff.getSalary();
		}
		double Average_Salary = 0;
		Average_Salary = SumSalary/(StaffList.size());
		assertEquals(38200.1, Average_Salary, 0.00001);
	}
	
	@Test(expected = PersonException.class)
	public final void testInvalidPhoneNumber() throws PersonException{
		Staff SherlockH = new Staff("Sherlock", "William Scott", "Holmes", Date(1995, 7, 15) , "221B Baker Street", "44 098 9999", "SH@london.com", "4pm-5pm, TF", 0, 11000, Date(2015,12,12), eTitle.MR);
		fail("Expected a PersonException to be thrown");
	}
	
	/**
	 * Checks for a person born more than hundred years ago, that is, an invalid person.
	 * @throws PersonException
	 */
	@Test(expected = PersonException.class)
	public final void testInvalidDOB() throws PersonException{
		Staff GandhiMK = new Staff("Mohandas", "Karamchand", "Gandhi", Date(1600, 10, 2) , "Porbander, India", "302-376-3171", "MKGandhi@1947.in", "4pm-5pm, MWF", 0, 50000.50, Date(1940,8,11), eTitle.MR);
		fail("Expected a PersonException to be thrown");
	}
	
		
}

