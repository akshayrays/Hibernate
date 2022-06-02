package in.co.rays.bean;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UserTest {
	public static void main(String[] args) throws Exception {

		// testAdd();
		// testUpdate();
		// testDelete();
		// testGet();
		testAuthenticate("akshay.joshi", "12345");
		 //testList();

	}

	private static void testList() {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();

		Query q = s.createQuery("from User");
		// Query q=s.createSQLQuery("select * from user");
		List<User> li = q.list();
		Iterator<User> it = li.iterator();
		User u;
		while (it.hasNext()) {
			u = (User) it.next();
			System.out.println(u.getId());
			System.out.println(u.getFname());
		}

		s.close();

	}

	public static void testAuthenticate(String login, String pwd) throws Exception {
	
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// cfg file use kara

		Session s = sf.openSession();

		Query q = s.createQuery("from User where userid =? and password =?");

		q.setString(0, login);
		q.setString(1, pwd);


		List list = q.list();

		User u = null;
		if (list.size() == 1) {
			u = (User) list.get(0);
		} else {
			throw new Exception("login.invalid.user");
		}
		System.out.println("authenticated");
		s.close();

	}

	private static void testGet() {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// cfg file use kara

		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();

		User u = (User) s.get(User.class, 1);
		System.out.println(u.getId());
		System.out.println(u.getFname());

		s.close();
	}

	private static void testDelete() {
		User u = new User();
		u.setId(2);
		u.setFname("Akshu");
		u.setLname("joshi");
		u.setUserid("akshayjoshi");
		u.setPassword("123");
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// cfg file use kara

		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();

		s.delete(u);
		tx.commit();

		s.close();

		System.out.println("insert");
	}

	private static void testUpdate() {

		User u = new User();
		u.setId(2);
		u.setFname("Akshu");
		u.setLname("joshi");
		u.setUserid("akshayjoshi");
		u.setPassword("123");
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// cfg file use kara

		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();

		s.update(u);
		tx.commit();

		s.close();

		System.out.println("insert");
	}

	private static void testAdd() {
		User u = new User();
		u.setFname("akki");
		u.setLname("joshi");
		u.setUserid("akshay.joshi");
		u.setPassword("12345");

		SessionFactory sf = new Configuration().configure().buildSessionFactory(); // Load factory
//cfg file use kara

		Session s = sf.openSession(); // create session
		Transaction tx = s.beginTransaction();

		s.save(u); // save pojo
		tx.commit();

		s.close();

		System.out.println("insert");
	}

}
