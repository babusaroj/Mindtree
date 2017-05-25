package com.service;

import java.util.List;

import com.model.Department;
import com.model.Employe;

public interface EmployeeService {

	 Employe findById(int id);
	 
	 public  void saveEmploye(Employe emp);
	 
	 public  void updateEmploye(Employe emp);
	 
	 public void deleteEmploye(Employe emp);
	 
	 public List<Employe> findAllEmploye();
}

