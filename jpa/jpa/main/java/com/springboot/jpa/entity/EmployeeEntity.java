package com.springboot.jpa.entity;

	import jakarta.persistence.Column;
	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.Table;

	@Entity
	@Table(name="employeedetails")
	public class EmployeeEntity {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id")
		private int id;
		
		@Column(name = "ename")
		private String ename;
		
		@Column(name = "eadd")
		private String eadd;
		
		@Column(name = "emob")
		private String emob;
		

		@Column(name = "email")
		private String email;


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getEname() {
			return ename;
		}


		public void setEname(String ename) {
			this.ename = ename;
		}


		public String getEadd() {
			return eadd;
		}


		public void setEadd(String eadd) {
			this.eadd = eadd;
		}


		public String getEmob() {
			return emob;
		}


		public void setEmob(String emob) {
			this.emob = emob;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		@Override
		public String toString() {
			return "EmployeeEntity [id=" + id + ", ename=" + ename + ", eadd=" + eadd + ", emob=" + emob + ", email="
					+ email + "]";
		}

		
	}



