package com.rest.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.model.Department;
import com.model.Employe;

public interface DepartmentApi {
	
	
	public String showWelcomepage(ModelMap model);
	public String listEmployees(ModelMap model);
	public String listDepartment(ModelMap model) ;
	public  ModelAndView saveEmploye();
	public  ModelAndView saveEmploye( Employe employee) ;
	public  ModelAndView saveDepartment();
	public ModelAndView saveDepartment(Department department);
    public String editEmployee(@PathVariable String empid, ModelMap model);
    public String updateEmployee( Employe employee,ModelMap model, @PathVariable String empid);
    public String deleteEmployee( ModelMap model, @PathVariable String empid);
    public String editDepartment(@PathVariable String deptid, ModelMap model) ;
    public String updateDepartment( Department department,ModelMap model, @PathVariable String deptid);
    public String deleteDepartment( ModelMap model, @PathVariable String deptid);
	
	
}
