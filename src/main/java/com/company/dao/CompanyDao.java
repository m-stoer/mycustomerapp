package com.company.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.company.db.DB;
import com.company.domain.Company;

public class CompanyDao
{
	public static void insert(final Company company)
	{
		final List<Company> companies = DB.root().companies;
		companies.add(company);
		DB.store(companies);
	}

	public static boolean update(final Company company)
	{
		final List<Company> companies = DB.root().companies;
		final Optional<Company> foundCompany = companies.stream()
			.filter(c -> c.getName().equals(company.getName()))
			.findAny();

		foundCompany.ifPresent(c ->
		{
			if (company.getEmployees() != null)
			{
				c.setEmployees(new ArrayList<>(company.getEmployees()));
			}

			if (company.getFoundedDate() != null)
			{
				c.setFoundedDate(company.getFoundedDate());
			}

			DB.store(c);
		});

		return foundCompany.isPresent();
	}

	public static boolean delete(final Company company)
	{
		final List<Company> companies = DB.root().companies;
		final Optional<Company> foundCompany = companies.stream()
			.filter(c -> c.getName().equals(company.getName()))
			.findAny();

		foundCompany.ifPresent(c ->
		{
			companies.remove(c);
			DB.store(companies);
		});

		return foundCompany.isPresent();
	}

	public static List<Company> list()
	{
		return Collections.unmodifiableList(DB.root().companies);
	}
	
	public static Company find(final Company company)
	{
		return new Company(company);
	}
}
