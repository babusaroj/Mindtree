package com.dao;

import java.util.List;

import com.model.Department;
import com.model.Employe;

public interface DepartmentDao {
	
	Department findById(long id);
	 
    public void saveDepartment(Department department);
    
    public void updateDepartment(Department department);
     
    List<Department> findAllDepartment();
    
    public String deleteDepartment(Department department);

}
