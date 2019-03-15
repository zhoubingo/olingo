package com.penninkhof.odata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.penninkhof.odata.entities.Company;
import com.penninkhof.odata.repository.CompanyRepository;


@Service
public class CompanyService {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	public List<Company> findAllcompany(){
		
		return companyRepository.findAllCompany();
	}
	
	public Company findCompanyById(int id){
		
		return companyRepository.findCompanyById(id);
	}
	
	public List<Company> findCompany() {	
		List<Company> list = (List<Company>) companyRepository.findAll();
		return list;
	}
}
