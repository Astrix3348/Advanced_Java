package cdac;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ProjectDAO {

	@Autowired
	SessionFactory sessionFactory;

	public void insertProject(Project p) {
		Session session = sessionFactory.getCurrentSession();
		session.save(p);
	}

	public List<Project> getProject() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Project", Project.class).list();
	}
	
	public List<Project> searchProject(String keyword){
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Project where p_name like :key";
		Query<Project> q = session.createQuery(hql, Project.class);
		q.setParameter("key", "%" + keyword + "%");
		return q.list();
	}
}
