package com.model;


	import java.util.Set;

import javax.persistence.CascadeType;
	import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

	@Entity
	@Table(name="DEPARTMENT")
	public class Department {

		@Id
		@GeneratedValue
		@Column(name="DEPARTMENT_ID")
		private Long departmentId;
		
		@Column(name="DEPT_NAME")
		private String departmentName;
		
		@OneToMany(mappedBy="department",cascade={CascadeType.ALL})
		private Set<Employe> employees;

		public Long getDepartmentId() {
			return departmentId;
		}

		public void setDepartmentId(Long departmentId) {
			this.departmentId = departmentId;
		}

		public String getDepartmentName() {
			return departmentName;
		}

		public void setDepartmentName(String departmentName) {
			this.departmentName = departmentName;
		}

		public Set<Employe> getEmployees() {
			return employees;
		}

		public void setEmployees(Set<Employe> employees) {
			this.employees = employees;
		}
	
		

}
