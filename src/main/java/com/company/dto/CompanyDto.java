package com.company.dto;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.company.domain.Company;

public class CompanyDto
{
	private String name;
	private String foundedDate;
	private List<EmployeeDto> employees;

	public CompanyDto()
	{
	}

	public CompanyDto(final String name, final String foundedDate, final List<EmployeeDto> employees)
	{
		this.name = name;
		this.foundedDate = foundedDate;
		this.employees = employees;
	}

	public CompanyDto(final Company company)
	{
		this(
			company.getName(),
			DateTimeFormatter.ISO_DATE.format(company.getFoundedDate()),
			company.getEmployees()
				.stream()
				.map(EmployeeDto::new)
				.collect(ArrayList::new, ArrayList::add, ArrayList::addAll)
		);
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(final String name)
	{
		this.name = name;
	}

	public String getFoundedDate()
	{
		return this.foundedDate;
	}

	public void setFoundedDate(final String foundedDate)
	{
		this.foundedDate = foundedDate;
	}

	public List<EmployeeDto> getEmployees()
	{
		return this.employees;
	}

	public void setEmployees(final List<EmployeeDto> employees)
	{
		this.employees = employees;
	}
}
