package com.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.DepartmentDao;
import com.dao.EmployeeDao;
import com.model.Department;
import com.model.Employe;
import com.service.DepartmentService;

@Service("departmentService")
@Transactional
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
    private DepartmentDao dao;
	
	@Override
	public void saveDepartment(Department dept) {
		 dao.saveDepartment(dept);
	}
	@Override
	public Department findById(long id){
		return dao.findById(id);
	}
	@Override
	public List<Department> findAllDepartment() {
		return dao.findAllDepartment();
	}
	
	@Override
	public void updateDepartment(Department dept) {
		 dao.saveDepartment(dept);
	}
	@Override
	public String deleteDepartment(Department dept) {
		 return dao.deleteDepartment(dept);
	}
}
