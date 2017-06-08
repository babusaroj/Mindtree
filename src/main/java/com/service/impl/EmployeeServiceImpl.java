package com.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.EmployeeDao;
import com.model.Employe;
import com.service.EmployeeService;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
    private EmployeeDao dao;
	
	@Override
	public Employe findById(int id) {
		return dao.findById(id);
	}
	
	public  void saveEmploye(Employe employee){
		dao.saveEmployee(employee);
	}
	public  void updateEmploye(Employe employee){
		dao.updateEmployee(employee);
	}
	
	public List<Employe> findAllEmploye(){
		return dao.findAllEmployees();
	}
	
	public String deleteEmploye(Employe emp){
		return dao.deleteEmployee(emp);
	}
}
