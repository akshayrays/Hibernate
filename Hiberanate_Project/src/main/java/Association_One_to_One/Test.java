package Association_One_to_One;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {

		Employee emp1 = new Employee();
		emp1.setFirstName("nisha");
		emp1.setLastName("mehta");
		Address adr1 = new Address();
		adr1.setStreet("abc");
		adr1.setState("xyz");
		adr1.setCity("ert");

		emp1.setAddress(adr1);
		// adr1.setEmployee(emp1);

		Employee emp2 = new Employee();
		emp2.setFirstName("nisha");
		emp2.setLastName("mehta");
		Address adr2 = new Address();
		adr2.setStreet("abc");
		adr2.setState("xyz");
		adr2.setCity("ert");

		emp2.setAddress(adr2);
		// adr2.setEmployee(emp2);

		Employee emp3 = new Employee();
		emp3.setFirstName("nisha");
		emp3.setLastName("mehta");
		Address adr3 = new Address();
		adr3.setStreet("abc");
		adr3.setState("xyz");
		adr3.setCity("ert");

		emp3.setAddress(adr3);
		// adr3.setEmployee(emp3);

		List<Employee> list = new ArrayList<Employee>();

		list.add(emp1);
		list.add(emp2);
		list.add(emp3);

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();

		Iterator<Employee> it = list.iterator();
		while (it.hasNext()) {
			Employee employee = (Employee) it.next();
			Transaction tx = s.beginTransaction();
			s.save(employee);
			tx.commit();

		}

		s.close();
		System.out.println("added");
	}
}
