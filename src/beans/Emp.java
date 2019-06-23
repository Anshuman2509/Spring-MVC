package beans;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import validators.IsValidCar;

public class Emp {
	@Min(value = 1000)@Max(value = 2000)
	private int empId;
	@Size(max = 50,min=5)
	private String empName;
	private Date dateOfJoining;
	@NotNull
	private char gender;
	@Length(min = 1,max = 50)
	private String city;
	@NotEmpty@IsValidCar(listOfValidCars = "BMW|Audi|Mercedes")
	private String car;
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getCar() {
		return car;
	}
	public void setCar(String car) {
		this.car = car;
	}
	@Override
	public String toString() {
		return "Emp [empId=" + empId + ", empName=" + empName + ", dateOfJoining=" + dateOfJoining + ", gender="
				+ gender + ", city=" + city + ", car=" + car + "]";
	}
	
	
	
	
}
