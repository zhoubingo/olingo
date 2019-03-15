package com.penninkhof.odata.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.penninkhof.odata.entities.Company;



public interface CompanyRepository extends CrudRepository<Company, Integer> {
	
	@Query("select c from Company c")
	List<Company> findAllCompany();
	
	
	@Query("select c from Company c where c.id=:id")
    Company findCompanyById(@Param("id") int id);
}

	
