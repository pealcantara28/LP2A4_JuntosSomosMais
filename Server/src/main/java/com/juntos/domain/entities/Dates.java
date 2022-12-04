package com.juntos.domain.entities;

import java.util.Calendar;
import java.util.Date;

public class Dates {

	public Dates() {
		super();
	}

	private int age;
	
	private Date date;
	
	public Dates(Date date)
	{
		this.date = date;
		Calendar present = Calendar.getInstance();
	    Calendar now = Calendar.getInstance();
	    now.setTime(date);
		this.age = generateAge(now, present);
	}
	public int getAge() {
		return age;
	}
	private int generateAge(Calendar first, Calendar second)
	{
		int years = 0;
		
		while(first.before(second))
		{
			first.add(Calendar.YEAR, 1);
			if(first.before(second)) years++;
		}
		
		return years;
	}

	public Date getDate() {
		return date;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
