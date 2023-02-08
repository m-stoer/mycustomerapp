package com.company.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.company.dao.CompanyDao;
import com.company.domain.Company;
import com.company.dto.CompanyDto;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Patch;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Put;

@Controller("/company")
public class CompanyController
{
	@Get
	public List<CompanyDto> getCompanies()
	{
		return CompanyDao.list().stream().map(CompanyDto::new).collect(Collectors.toList());
	}

	@Get("/{companyName}")
	public CompanyDto getCompany(@PathVariable @NotBlank final String companyName)
	{
		return CompanyDao.list()
			.stream()
			.filter(c -> c.getName().equals(companyName))
			.map(CompanyDto::new)
			.findAny()
			.orElse(null);
	}

	@Put
	public void putCompany(@Body @NotNull final Company company)
	{
		CompanyDao.insert(company);
	}

	@Patch
	public boolean patchCompany(@Body @NotNull final Company company)
	{
		return CompanyDao.update(company);
	}

	@Delete
	public boolean deleteCompany(@Body @NotNull final Company company)
	{
		return CompanyDao.delete(company);
	}
}
