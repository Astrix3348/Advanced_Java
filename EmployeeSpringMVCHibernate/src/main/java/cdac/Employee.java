package cdac;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
	// we have to convert this into a hibernate entity

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@Column(name = "e_name")
	String e_name;

	@Column(name = "e_income")
	int e_income;

	@Column(name = "e_company")
	String e_company;

	@Column(name = "e_gender")
	String e_gender;

	public Employee() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getE_name() {
		return e_name;
	}

	public void setE_name(String e_name) {
		this.e_name = e_name;
	}

	public int getE_income() {
		return e_income;
	}

	public void setE_income(int e_income) {
		this.e_income = e_income;
	}

	public String getE_company() {
		return e_company;
	}

	public void setE_company(String e_company) {
		this.e_company = e_company;
	}

	public String getE_gender() {
		return e_gender;
	}

	public void setE_gender(String e_gender) {
		this.e_gender = e_gender;
	}

}
