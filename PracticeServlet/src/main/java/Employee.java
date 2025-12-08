
public class Employee {
	int id;
	String e_name;
	int e_sal;
	
	public Employee(int id, String e_name, int e_sal) {
		this.id = id;
		this.e_name = e_name;
		this.e_sal = e_sal;
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return e_name;
	}
	public int getSal() {
		return e_sal;
	}
}
