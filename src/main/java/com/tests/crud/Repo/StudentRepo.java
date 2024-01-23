package com.tests.crud.Repo;

import org.springframework.data.repository.CrudRepository;

import com.tests.crud.entity.Student;

public interface StudentRepo  extends CrudRepository<Student,Integer>{

}
