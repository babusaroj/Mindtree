package com.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.dao.AbstractDao;
import com.dao.DepartmentDao;
import com.model.Department;
import com.model.Employe;


@Repository("departmentDao")
public class DepartmentDaoImpl extends AbstractDao<Integer, Department> implements DepartmentDao{

	@Override
	public Department findById(long id) {
		return getByKey(id);
	}

	@Override
	public void saveDepartment(Department dept) {
		persist(dept);
		
	}
	
	@Override
	public void updateDepartment(Department dept) {
		persist(dept);
		
	}

	@Override
	public List<Department> findAllDepartment() {
		Criteria criteria = createEntityCriteria();
        return (List<Department>) criteria.list();
	}
	
    public String deleteDepartment(Department department){
    	try{
    	  
    	 delete(department);
    	 return "record deleted sucessfull";
    	}catch(Exception ex){
    		return"record not deleted";
    	}
    	
    }

}
