package model.entities;

public class Employee {
	private String name;
	private Integer hours;
	private Double valuePerHour;
	
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
	
	public Double payment() {
		return getHours() * getValuePerHour();
	}
	
	@Override
	public String toString() {
		return getName() + " - " + String.format("%.2f", payment());
	}
}
