package ex2_transactions

import groovy.lang.Closure;

@interface Transactable {
	Class<? extends TransactionManager> value();
}

enum TransactionKind {
	SHORT_RUNNING, LONG_RUNNING, INTERACTIVE
}

interface TransactionManager { 
	void commit()
	void rollback()
	/**
	 * Only applicable for {@link TransactionKind.LONG_RUNNING} 
	 * transactions
	 * @param msg
	 */
	void status(String msg)
	/**
	 * Only applicable for {@link TransactionKind.INTERACTIVE} 
	 * transactions
	 * @param msg
	 */
	def prompt(String msg)
}

class HibernateManager implements TransactionManager {

	void commit() { }
	void rollback() { }
	void status(String msg) { }
	def prompt(String msg) { }
	
	/**
	 * Specific to {@link HibernateManager}
	 */
	String getConnection() { }
}

@Transactable(HibernateManager)
class Person {
  String first
  String last
  int age
  
  int recalculateAge() {
	  // churn, churn, churn
  }
}

Person p = new Person(age: 18, first: 'Guillaume', last: 'LaForge')
p.transaction (kind: TransactionKind.SHORT_RUNNING) {
	age = 33
	try {
		
		recalculateAge()
	} catch (e) {
		rollback()	
	}
	status('not allowed!')
	prompt('not allowed!')
} 

p.transaction (kind: TransactionKind.INTERACTIVE, rollbackOnException:true) {
	age = prompt("Enter new age")
	while (age < 20) {
		age = prompt("That's too young!\nEnter new age")
	}
	if (prompt("Are you sure?")) {
		commit()
	} else {
		rollback()
	}
	status('not allowed!')
}   

p.transaction kind: TransactionKind.LONG_RUNNING, rollbackOnException:true, {
	status("Recalculating age...this may take a while")
	age = recalculateAge()
	prompt('not allowed!')
}
