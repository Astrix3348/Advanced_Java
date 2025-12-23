package cdac;

import javax.persistence.*;

@Entity
@Table(name = "projects")
public class Project {
	// converting this into entity
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //hibernate creates unique id for each record
	int id;

	@Column(name = "p_name")
	String p_name;

	@Column(name = "p_desc")
	String p_desc;

	public Project() {
	}

	public int getId() {
		return id;
	}

	public String getP_name() {
		return p_name;
	}

	public String getP_desc() {
		return p_desc;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public void setP_desc(String p_desc) {
		this.p_desc = p_desc;
	}

}
