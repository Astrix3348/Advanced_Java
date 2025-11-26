package cdac;

public class Student1 {

	String his_name;
	int his_prn;
	String his_email;

	public Student1(String his_name, int his_prn, String his_email) {
		this.his_name = his_name;
		this.his_prn = his_prn;
		this.his_email = his_email;
	}

	public String getName() {
		return his_name;
	}

	public int getPrn() {
		return his_prn;
	}

	public String getEmail() {
		return his_email;
	}
}
