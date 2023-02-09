package com.company.domain;

import java.time.LocalDate;

import com.company.business.JsonLocalDateSerializer;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable.Deserializable;
import io.micronaut.serde.annotation.Serdeable.Serializable;

@Introspected
@Deserializable
@Serializable
public class Employee
{
	private String firstname;
	private String lastname;
	private String email;
	@Serializable(using = JsonLocalDateSerializer.class)
	@Deserializable(using = JsonLocalDateSerializer.class)
	private LocalDate birthday;

	public Employee()
	{
	}

	public Employee(final String firstname, final String lastname, final String email, final LocalDate birthday)
	{
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.birthday = birthday;
	}

	public Employee(final Employee copy)
	{
		this.firstname = copy.firstname;
		this.lastname = copy.lastname;
		this.email = copy.email;
		this.birthday = copy.birthday;
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

	public LocalDate getBirthday()
	{
		return this.birthday;
	}

	public void setBirthday(final LocalDate birthday)
	{
		this.birthday = birthday;
	}
}
