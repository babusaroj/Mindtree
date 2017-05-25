package com.rest.api.impl;

import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.model.Department;
import com.model.Employe;
import com.rest.api.DepartmentApi;
import com.service.DepartmentService;
import com.service.EmployeeService;

@Controller
public class DepartmentApiImpl implements DepartmentApi {

	@Autowired
    EmployeeService empService;
	
	@Autowired
    DepartmentService deptservice;
	
	
	
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
    public String showWelcomepage(ModelMap model) {
        return "welcome";
    }
	
	@RequestMapping(value = { "/allEmploye" }, method = RequestMethod.GET)
    public String listEmployees(ModelMap model) {
 
        List<Employe> employees = empService.findAllEmploye();
        model.addAttribute("employees", employees);
        return "allemployees";
    }
	
	@RequestMapping(value = { "/allDepartment" }, method = RequestMethod.GET)
    public String listDepartment(ModelMap model) {
 
        List<Department> department = deptservice.findAllDepartment();
        model.addAttribute("department", department);
        return "alldepartment";
    }
	@RequestMapping(value="/addEmploye",method = RequestMethod.GET)
	@Override
	public  ModelAndView saveEmploye() {
		
		ModelAndView mav=new ModelAndView();
	    mav.addObject("employee",new Employe());
	    mav.addObject("edit", false);
		mav.setViewName("employeeregistration");
		return mav;
}
	@RequestMapping(value="/addEmploye",method = RequestMethod.POST)
	@Override
	public  ModelAndView saveEmploye( Employe employee) {
		
		ModelAndView mav=new ModelAndView();
		Department dept=deptservice.findById(employee.getDepartment().getDepartmentId());
		employee.setDepartment(dept);
		empService.saveEmploye(employee);
	    mav.addObject("employee", employee);
	    mav.addObject("edit", false);
		mav.setViewName("sucesses");
		return mav;
}
	@RequestMapping(value="/addDepartment",method = RequestMethod.GET)
	@Override
	public  ModelAndView saveDepartment() {
			ModelAndView mav=new ModelAndView();
		    mav.addObject("department",new Department());
		    mav.addObject("edit", false);
			mav.setViewName("departmentregistration");
			return mav;
	}
	@RequestMapping(value="/addDepartment",method = RequestMethod.POST)
	@Override
	public ModelAndView saveDepartment(Department department) {
		
		ModelAndView mav=new ModelAndView();
		deptservice.saveDepartment(department);
		mav.setViewName("sucesses");
		return mav;
	}
	

	@RequestMapping(value = { "/edit-{empid}-employee" }, method = RequestMethod.GET)
    public String editEmployee(@PathVariable String empid, ModelMap model) {
        Employe employee = empService.findById(Integer.parseInt(empid));
        model.addAttribute("employee", employee);
        model.addAttribute("edit", true);
        return "registration";
    }
	@RequestMapping(value = { "/edit-{empid}-employee" }, method = RequestMethod.POST)
    public String updateEmployee( Employe employee,ModelMap model, @PathVariable String empid) {
		empService.updateEmploye(employee);
        //model.addAttribute("success", "Employee " + employee.getName()  + " updated successfully");
        return "sucesses";
    }
	
	@RequestMapping(value = { "/delete-{empid}-employee" }, method = RequestMethod.GET)
    public String deleteEmployee( ModelMap model, @PathVariable String empid) {
		 Employe employee = empService.findById(Integer.parseInt(empid));
		 empService.deleteEmploye(employee);
        model.addAttribute("success", "Employee " + employee.getName()  + " deleted successfully");
        return "sucesses";
    }
	
	@RequestMapping(value = { "/edit-{deptid}-department" }, method = RequestMethod.GET)
    public String editDepartment(@PathVariable String deptid, ModelMap model) {
		Department department = deptservice.findById(Long.parseLong(deptid));
        model.addAttribute("department", department);
        model.addAttribute("edit", true);
        return "departmentregistration";
    }
	@RequestMapping(value = { "/edit-{deptid}-department" }, method = RequestMethod.POST)
    public String updateDepartment( Department department,ModelMap model, @PathVariable String deptid) {
		deptservice.updateDepartment(department);
        model.addAttribute("success", "Department " + department.getDepartmentId()  + " updated successfully");
        return "sucesses";
    }
	
	@RequestMapping(value = { "/delete-{deptid}-department" }, method = RequestMethod.GET)
    public String deleteDepartment( ModelMap model, @PathVariable String deptid) {
		Department department = deptservice.findById(Long.parseLong(deptid));
		deptservice.deleteDepartment(department);
        model.addAttribute("success", "Department " + department.getDepartmentId()  + " deleted successfully");
        return "sucesses";
    }


}