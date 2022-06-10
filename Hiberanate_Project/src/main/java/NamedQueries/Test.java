package NamedQueries;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		testNameQuer1();

	}

	private static void testNameQuer1() {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();

		Query q = s.getNamedQuery("allUser");

		List<UserPOJO> li = q.list();
		Iterator<UserPOJO> it = li.iterator();

		while (it.hasNext()) {
			UserPOJO u = (UserPOJO) it.next();
			System.out.print("\t" + u.getId());
			System.out.print("\t" + u.getfName());
			System.out.print("\t" + u.getLname());
			System.out.print("\t" + u.getUserId());
			System.out.println(u.getPassword());

		}
		s.close();

	}
}
