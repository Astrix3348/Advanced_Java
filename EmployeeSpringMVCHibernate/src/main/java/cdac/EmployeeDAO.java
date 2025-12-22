package cdac;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class EmployeeDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public void insertEmployee(Employee e) {
		Session session = sessionFactory.getCurrentSession();
		session.save(e);
	}
	
	public List<Employee> getEmployee(){
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Employee", Employee.class).list();
	}
	
}
