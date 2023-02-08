package com.company.dto;

import java.time.format.DateTimeFormatter;

import com.company.domain.Employee;

public class EmployeeDto
{
	private String firstname;
	private String lastname;
	private String email;
	private String birthday;

	public EmployeeDto()
	{
	}

	public EmployeeDto(final String firstname, final String lastname, final String email, final String birthday)
	{
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.birthday = birthday;
	}

	public EmployeeDto(final Employee employee)
	{
		this(
			employee.getFirstname(),
			employee.getLastname(),
			employee.getEmail(),
			DateTimeFormatter.ISO_DATE.format(employee.getBirthday())
		);
	}

	public String getFirstname()
	{
		return this.firstname;
	}

	public void setFirstname(final String firstname)
	{
		this.firstname = firstname;
	}

	public String getLastname()
	{
		return this.lastname;
	}

	public void setLastname(final String lastname)
	{
		this.lastname = lastname;
	}

	public String getEmail()
	{
		return this.email;
	}

	public void setEmail(final String email)
	{
		this.email = email;
	}

	public String getBirthday()
	{
		return this.birthday;
	}

	public void setBirthday(final String birthday)
	{
		this.birthday = birthday;
	}
}
