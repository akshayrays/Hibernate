package Criteria;

import java.util.Iterator;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class TestCriteriaMain {
	public static void main(String[] args) {
		// testCriteria();
		testAdd();
		// testAND();//Restrictions
		// testOR();//Restrictions
		// testOR1();//Restrictions
		// testLike1();//Restrictions
		// testSingleColumn();//Projections
		// testMultiColumn();//Projections
		// testOrderBy();//Restrictions
		// testPagination();
		// testDetachedCriteria();
		// testJoin();
		// testGroupBy();Projections
		// testAliases();
		// testAggre();//Projections

	}

	private static void testDetachedCriteria() {

		DetachedCriteria dc = DetachedCriteria.forClass(CriteriaPojo.class);
		dc.add(Restrictions.eq("empName", "nisha"));
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		dc.getExecutableCriteria(s);
		List li = ((Criteria) dc).list();
		Iterator it = li.iterator();
		CriteriaPojo cp;
		while (it.hasNext()) {
			cp = (CriteriaPojo) it.next();
			System.out.println(cp.getId());
			System.out.println(cp.getEmpName());

		}

		s.close();

	}

	/*
	 * private static void testJoin() { SessionFactory sf = new
	 * Configuration().configure().buildSessionFactory(); Session s =
	 * sf.openSession(); Criteria c= s.createCriteria(CriteriaPOJO.class);
	 * c.setMaxResults(2);//Max records c.setFirstResult(0);//first few record and
	 * index c.createAlias("empSalary", "emp"); List<CriteriaPOJO> li=c.list();
	 * Iterator<CriteriaPOJO> it = li.iterator(); CriteriaPOJO cp; while
	 * (it.hasNext()) { cp = (CriteriaPOJO) it.next();
	 * System.out.println(cp.getId()); System.out.println(cp.getEmpName());
	 * System.out.println(cp.getEmpSalary());
	 * 
	 * }
	 * 
	 * s.close();
	 * 
	 * }
	 * 
	 */

	private static void testGroupBy() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();

		List li = s.createCriteria(CriteriaPojo.class).setProjection(
				Projections.projectionList().add(Projections.count("id")).add(Projections.groupProperty("id"))

		).list();

		Iterator it = li.iterator();

		while (it.hasNext()) {

			Integer i = (Integer) it.next();
			System.out.println(i);

		}

		s.close();

	}

	private static void testAliases() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Criteria c = s.createCriteria(CriteriaPojo.class);
		c.setMaxResults(2);// Max records
		c.setFirstResult(0);// first few record and index
		c.createAlias("empSalary", "emp");
		List<CriteriaPojo> li = c.list();
		Iterator<CriteriaPojo> it = li.iterator();
		CriteriaPojo cp;
		while (it.hasNext()) {
			cp = (CriteriaPojo) it.next();
			System.out.println(cp.getId());
			System.out.println(cp.getEmpName());
			System.out.println(cp.getEmpSalary());

		}

		s.close();

	}

	private static void testAggre() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Criteria c = s.createCriteria(CriteriaPojo.class);
		ProjectionList p = Projections.projectionList();
		p.add(Projections.count("id"));
		p.add(Projections.rowCount());
		c.setProjection(p);
		List li = c.list();
		Iterator it = li.iterator();
		CriteriaPojo cp;
		while (it.hasNext()) {
			int i = (Integer) it.next();
			System.out.println(i);

		}

		s.close();

	}

	private static void testPagination() {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Criteria c = s.createCriteria(CriteriaPojo.class);
		c.setMaxResults(2);// Max records
		c.setFirstResult(0);// first few record and index
		List<CriteriaPojo> li = c.list();
		Iterator<CriteriaPojo> it = li.iterator();
		CriteriaPojo cp;
		while (it.hasNext()) {
			cp = (CriteriaPojo) it.next();
			System.out.println(cp.getId());
			System.out.println(cp.getEmpName());
			System.out.println(cp.getEmpSalary());

		}

		s.close();

	}

	private static void testOrderBy() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Criteria c = s.createCriteria(CriteriaPojo.class);
		c.add(Restrictions.like("empName", "n%"));
		c.addOrder(Order.asc("empSalary"));
		c.addOrder(Order.asc("empName"));
		c.addOrder(Order.desc("id"));
		List<CriteriaPojo> li = c.list();
		Iterator<CriteriaPojo> it = li.iterator();
		CriteriaPojo cp;
		while (it.hasNext()) {
			cp = (CriteriaPojo) it.next();
			System.out.println(cp.getId());
			System.out.println(cp.getEmpName());
			System.out.println(cp.getEmpSalary());

		}

		s.close();

	}

	private static void testMultiColumn() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Criteria c = s.createCriteria(CriteriaPojo.class);
		ProjectionList p = Projections.projectionList();
		p.add(Projections.property("id"));
		p.add(Projections.property("empName"));
		c.setProjection(p);
		List li = c.list();
		Iterator it = li.iterator();

		while (it.hasNext()) {
			Object[] ob = (Object[]) it.next();

			System.out.println(ob[0]);
			System.out.println(ob[1]);

		}

		s.close();

	}

	private static void testSingleColumn() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Criteria c = s.createCriteria(CriteriaPojo.class);
		ProjectionList p = Projections.projectionList();
		p.add(Projections.property("empName"));
		// p.add(Projections.property("id"));
		c.setProjection(p);
		List li = c.list();
		Iterator it = li.iterator();

		while (it.hasNext()) {
			String s1 = (String) it.next();
			// Integer i=(Integer) it.next();
			System.out.println(s1);

		}

		s.close();

	}

	private static void testOR1() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Criteria c = s.createCriteria(CriteriaPojo.class);
		c.add(Restrictions.or(Restrictions.eq("empSalary", 2000000),
				Restrictions.or(Restrictions.like("empName", "n%"), Restrictions.eq("id", 2))));

		List<CriteriaPojo> li = c.list();
		Iterator<CriteriaPojo> it = li.iterator();
		CriteriaPojo cp;
		while (it.hasNext()) {
			cp = (CriteriaPojo) it.next();
			System.out.println(cp.getId());
			System.out.println(cp.getEmpName());
			System.out.println(cp.getEmpSalary());

		}

		s.close();

	}

	private static void testOR() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Criteria c = s.createCriteria(CriteriaPojo.class);
		c.add(Restrictions.or(Restrictions.like("empName", "n%"), Restrictions.eq("id", 2)));

		List<CriteriaPojo> li = c.list();
		Iterator<CriteriaPojo> it = li.iterator();
		CriteriaPojo cp;
		while (it.hasNext()) {
			cp = (CriteriaPojo) it.next();
			System.out.println(cp.getId());
			System.out.println(cp.getEmpName());

		}

		s.close();

	}

	private static void testAND() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Criteria c = s.createCriteria(CriteriaPojo.class);
		c.add(Restrictions.like("empName", "n%"));// this also
		c.add(Restrictions.eq("id", 1));// this two method are satisfied with each other

		List<CriteriaPojo> li = c.list();
		Iterator<CriteriaPojo> it = li.iterator();
		CriteriaPojo cp;
		while (it.hasNext()) {
			cp = (CriteriaPojo) it.next();
			System.out.println(cp.getId());
			System.out.println(cp.getEmpName());

		}

		s.close();

	}

	private static void testLike1() {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Criteria c = s.createCriteria(CriteriaPojo.class);
		c.add(Restrictions.like("empName", "a%"));

		List<CriteriaPojo> li = c.list();
		Iterator<CriteriaPojo> it = li.iterator();
		CriteriaPojo cp;
		while (it.hasNext()) {
			cp = (CriteriaPojo) it.next();
			System.out.println(cp.getId());
			System.out.println(cp.getEmpName());
			System.out.println(cp.getEmpSalary());
		}

		s.close();

	}

	private static void testAdd() {
		CriteriaPojo cp = new CriteriaPojo();

		cp.setEmpName("Aksh");
		cp.setEmpSalary(2000000);

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		s.save(cp);
		t.commit();
		s.close();
		System.out.println("added");

	}

	private static void testCriteria() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Criteria c = s.createCriteria(CriteriaPojo.class);
		List<CriteriaPojo> li = c.list();
		Iterator<CriteriaPojo> it = li.iterator();
		CriteriaPojo cp;
		while (it.hasNext()) {
			cp = (CriteriaPojo) it.next();
			System.out.println(cp.getId());
			System.out.println(cp.getEmpName());
			System.out.println(cp.getEmpSalary());
		}

		s.close();

	}

}
