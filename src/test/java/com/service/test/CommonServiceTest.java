package com.service.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.context.junit4.SpringRunner;

import com.model.Department;
import com.model.Employe;
import com.service.DepartmentService;
import com.service.EmployeeService;
import com.springboot.initialize.SpringBootInitialize;

@RunWith(SpringRunner.class)
//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringBootInitialize.class})
@WebAppConfiguration
public class CommonServiceTest {
	//DI
    @Autowired
    @Qualifier("departmentService")
    DepartmentService departmentService;
    
    @Autowired
    EmployeeService employeeService;
    
    @Test
    public void testDepartmentService() {
        Assert.assertEquals("IT",departmentService.findById(1).getDepartmentName());
    }  
    @Test
    public void testEmployeService() {
        Assert.assertEquals("babu saroj",employeeService.findById(2).getName());
    } 
    @Test
    @Transactional
    @Rollback(true)
    public void testdeleteFailureDepartment()
    {
         
    	Department department = departmentService.findById(Long.parseLong("22"));
        Assert.assertEquals("record not deleted",departmentService.deleteDepartment(department));
        
    }   
    @Test
    @Transactional
    @Rollback(true)
    public void testdeleteDepartment()
    {         
    	Department department = departmentService.findById(Long.parseLong("2"));
        Assert.assertEquals("record deleted sucessfull",departmentService.deleteDepartment(department));
        
    }
    
    @Test
    @Transactional
    @Rollback(true)
    public void testdeleteFailureEmploye()
    {
         
    	Employe employee = employeeService.findById(22);
        Assert.assertEquals("record not deleted",employeeService.deleteEmploye(employee));
        
    }   
    @Test
    @Transactional
    @Rollback(true)
    public void testdeleteEmploye()
    {         
    	Employe employee = employeeService.findById(2);
        Assert.assertEquals("record deleted sucessfull",employeeService.deleteEmploye(employee));
    }
    
}
