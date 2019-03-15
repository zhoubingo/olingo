package com.penninkhof.odata.repository;

import org.springframework.data.repository.CrudRepository;
import com.penninkhof.odata.entities.Person;

public interface PersonReposity extends CrudRepository<Person, Integer> {

}
