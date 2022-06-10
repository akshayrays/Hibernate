package TableParSubClass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {

		CreditSubClass cre = new CreditSubClass();
		cre.setPaymentId(12);
		cre.setAmount(20000);
		cre.setCcType("visa");

		CashSubClass ca = new CashSubClass();
		ca.setPaymentId(13);
		ca.setAmount(30000);

		ChequeSubClass che = new ChequeSubClass();
		che.setPaymentId(14);
		che.setAmount(40000);
		che.setChqNumber(234567);
		che.setBankName("SBI");

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		s.save(cre);
		s.save(ca);
		s.save(che);

		t.commit();
		s.close();
		System.out.println("added");
	}

}
