package com.cisc181.core;

import java.util.Date;

import com.cisc181.core.Person;

public class PersonException extends Exception {
	private Person myPerson;
	public PersonException(Person myPerson){
		this.myPerson = myPerson;
	}
	
	public Person getmyPerson(){
		return myPerson;
		
	}
}
