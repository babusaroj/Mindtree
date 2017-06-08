package com.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.dao.AbstractDao;
import com.dao.EmployeeDao;
import com.model.Employe;

@Repository("employeDao")
public class EmployeeDaoImpl extends AbstractDao<Integer, Employe> implements EmployeeDao{

	@Override
	public Employe findById(int id) {
		return getByKey(id);
	}

	@Override
	public void saveEmployee(Employe employee) {
		persist(employee);
		
	}
	
	@Override
	public void updateEmployee(Employe employee) {
		persist(employee);
		
	}
	

	@Override
	public String deleteEmployee(Employe employee) {
		try{
		delete(employee);
		 return "record deleted sucessfull";
		}catch(Exception ex){
			
		  return"record not deleted";
		 
		}
	}

	@Override
	public List<Employe> findAllEmployees() {
		
	        Criteria criteria = createEntityCriteria();
	        return (List<Employe>) criteria.list();
	    
	}

	@Override
	public Employe findEmployeeBySsn(String ssn) {
		// TODO Auto-generated method stub
		return null;
	}

}
