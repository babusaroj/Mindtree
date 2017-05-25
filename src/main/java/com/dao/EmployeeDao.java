package com.dao;

import java.util.List;

import com.model.Employe;

 
public interface EmployeeDao {
 
    Employe findById(int id);
 
    void saveEmployee(Employe employee);
    
    void updateEmployee(Employe employee);
     
    void deleteEmployee(Employe employee);
     
    List<Employe> findAllEmployees();
 
    Employe findEmployeeBySsn(String ssn);
 
}