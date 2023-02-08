package com.company.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Company
{
	private String name;
	private LocalDate foundedDate;
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
