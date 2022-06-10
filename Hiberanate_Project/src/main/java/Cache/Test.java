package Cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {

		// testget();
		// testAdd();
		testUpdate();

	}

	private static void testUpdate() {
		// TODO Auto-generated method stub

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s1 = sf.openSession();
		CachePOJO cp1 = (CachePOJO) s1.get(CachePOJO.class, 1);

		//System.out.println(cp1.getId());
		System.out.println(cp1.getName());
		s1.close();

		cp1.setName("sss");

		Session s2 = sf.openSession();
		CachePOJO cp2 = (CachePOJO) s2.get(CachePOJO.class, 1);

		Transaction tx = s2.beginTransaction();
		// s2.update(cp1);
		s2.merge(cp1);
		tx.commit();
		System.out.println("added");
	}

	private static void testAdd() {
		CachePOJO cp = new CachePOJO();

		cp.setName("srk");

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		s.save(cp);
		t.commit();
		s.close();
		System.out.println("added");

	}

	private static void testget() {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		System.out.println("got values from the table");
		CachePOJO cp = (CachePOJO) s.get(CachePOJO.class, 1);
		System.out.println(cp.getId());
		System.out.println(cp.getName());
		s.close();
		Session s1 = sf.openSession();
		CachePOJO cp1 = (CachePOJO) s1.get(CachePOJO.class, 1);
		System.out.println(cp1.getId());
		System.out.println(cp1.getName());
		s1.close();
	}

}
