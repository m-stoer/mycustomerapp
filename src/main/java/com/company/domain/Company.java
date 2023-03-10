package com.company.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.company.business.JsonLocalDateSerializer;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.SerdeImport;
import io.micronaut.serde.annotation.Serdeable;
import io.micronaut.serde.annotation.Serdeable.Deserializable;
import io.micronaut.serde.annotation.Serdeable.Serializable;

@Introspected
@Serdeable
@SerdeImport(value=LocalDate.class)
public class Company
{
	@NotNull
	@NotBlank
	private String name;
	@Serializable(using = JsonLocalDateSerializer.class)
	@Deserializable(using = JsonLocalDateSerializer.class)
	private LocalDate foundedDate;
	@Valid
	private List<Employee> employees = new ArrayList<>();

	public Company()
	{
	}

	public Company(final String name, final LocalDate foundedDate, final List<Employee> employees)
	{
		this.name = name;
		this.foundedDate = foundedDate;
		this.employees = employees;
	}

	public Company(final Company copy)
	{
		this.name = copy.name;
		this.foundedDate = copy.foundedDate;
		this.employees = copy.employees.stream()
			.map(Employee::new)
			.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(final String name)
	{
		this.name = name;
	}

	public LocalDate getFoundedDate()
	{
		return this.foundedDate;
	}

	public void setFoundedDate(final LocalDate foundedDate)
	{
		this.foundedDate = foundedDate;
	}

	public List<Employee> getEmployees()
	{
		return this.employees;
	}

	public void setEmployees(final List<Employee> employees)
	{
		this.employees = employees;
	}
}
