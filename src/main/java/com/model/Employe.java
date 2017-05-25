package com.model;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="EMPLOYEE")
public class Employe {

	@Id
	@GeneratedValue
	@Column(name="employee_id")
	private Long employeeId;
 
    @Size(min=3, max=50)
    @Column(name = "NAME", nullable = false)
    private String name;
 
 
    @NotNull
    @Column(name = "SALARY", nullable = false)
    private int salary;
     
 
    @ManyToOne(cascade={CascadeType.MERGE})
	@JoinColumn(name="department_id")
	private Department department;
    
 
 
    public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }

 
    
 
    public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}


}
