package entities;

import java.util.ArrayList;
import java.util.List;

public class Employee {
	private String name;
	private Integer hours;
	private Double valuePerHour;
	
	private List<Employee> employees = new ArrayList<Employee>();
	
	public Employee() {
	}

	public Employee(String name, Integer hours, Double valuePerHour) {
		super();
		this.name = name;
		this.hours = hours;
		this.valuePerHour = valuePerHour;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}

	public Double getValuePerHour() {
		return valuePerHour;
	}

	public void setValuePerHour(Double valuePerHour) {
		this.valuePerHour = valuePerHour;
	}

	public List<Employee> getEmployees() {
		return employees;
	}
	
	public void addEmployee(Employee employee) {
		employees.add(employee);
	}

	public Double payment() {
		return valuePerHour * hours;
	}
	@Override
	public String toString() {
		return name + " - $" + payment(); 
	}
	
}
