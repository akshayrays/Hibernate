package Inheritance;

import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Association_One_to_One.Employee;

public class Test {

	public static void main(String[] args) {

		testTablePerData();

	}

	private static void testTablePerData() {

		CreditCardPayment creditCardPayment = new CreditCardPayment();
		creditCardPayment.setId(1);
		creditCardPayment.setAmount(250);
		creditCardPayment.setPaymentType("credit");
		creditCardPayment.setCcType("350");

		Cheque cheque = new Cheque();
		cheque.setId(2);
		cheque.setAmount(450);
		cheque.setBankNunmber("boi");
		cheque.setChqNumber("123456789987654321");
		cheque.setPaymentType("visa");

		Cash cash = new Cash();
		cash.setId(3);
		cash.setAmount(550);
		cash.setPaymentType("cash"
				+ "");

		SessionFactory sf = new Configuration().configure().buildSessionFactory(); // Load factory

		Session s = sf.openSession(); // create session
		Transaction tx = s.beginTransaction();

		s.save(creditCardPayment);
		s.save(cheque);
		s.save(cash); // save pojo
		tx.commit();

		s.close();

		System.out.println("insert");

	}

}
