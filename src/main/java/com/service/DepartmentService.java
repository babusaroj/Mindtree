package com.service;

import java.util.List;

import com.model.Department;
import com.model.Employe;

public interface DepartmentService {

	public Department findById(long id);
	public  void saveDepartment(Department dept);
	public  void updateDepartment(Department dept);
	public List<Department> findAllDepartment();
	public  void deleteDepartment(Department dept);
}
