package com.springboot.jpa.Consumer;

public class PersonModel1 {
	
	
		  private String fname ; 
		  private String lname ;
		  private String email ;
		  private String password ;
		  private String mobile ;
		  
		  public String getFname() {
			return fname;
		}
		public void setFname(String fname) {
			this.fname = fname;
		}
		public String getLname() {
			return lname;
		}
		public void setLname(String lname) {
			this.lname = lname;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getMobile() {
			return mobile;
		}
		public void setMobile(String mobile) {
			this.mobile = mobile;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		private String gender;

		@Override
		public String toString() {
			return "PersonModel1 [fname=" + fname + ", lname=" + lname + ", email=" + email + ", password=" + password
					+ ", mobile=" + mobile + ", gender=" + gender + "]";
		}
		

}
