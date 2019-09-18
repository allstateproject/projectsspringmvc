package com.allstate.training.ffd.daos;

import java.sql.Clob;
import java.sql.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.allstate.training.ffd.entities.Customer;
import com.allstate.training.ffd.entities.Employees;
import com.allstate.training.ffd.entities.Expense;
import com.allstate.training.ffd.entities.Order;

@Repository
public class ExpenseDaoImpl implements ExpenseDao {
	
	  @Autowired
			SessionFactory sessionFactory;

			public ExpenseDaoImpl(){
				
				Configuration con=new Configuration().configure().addAnnotatedClass(Expense.class);
			    
			   sessionFactory=con.buildSessionFactory();
			    
			    			
			}
	@Override
	public void addExpense(Expense ex) {
		// TODO Auto-generated method stub
		
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(ex);
		
		session.getTransaction().commit();
		session.close();		

	}

	@Override
	public void updateExpense(int expenseId, int expenseAmount, String expenseType, Date expenseDate, Clob expenseDocument) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		Expense ex1=(Expense)session.get(Expense.class, expenseId);
		ex1.setExpenseAmount(expenseAmount);
		ex1.setExpenseType(expenseType);
		ex1.setExpenseDoc(expenseDocument);
		ex1.setExpenseDate(expenseDate);
		
		session.update(ex1);
		
		session.getTransaction().commit();
		session.close();

	}

	@Override
	public void deleteExpense(int expenseId) {
		// TODO Auto-generated method stub
		
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Expense ex=(Expense)session.get(Expense.class, expenseId);
		session.delete(ex);
		
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public List<Expense> calculateNetAmount(int start, int end) {
		// TODO Auto-generated method stub
		//String month;
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		/*String sql="SELECT EXTRACT(MONTH FROM expenseDate) from expense";
		SQLQuery query=session.createSQLQuery(sql);
		List<Object[]> object=query.list();
		for(Object[] ob:object) {
			month= (String) ob[0];
		}*/
		
		Criteria cr = session.createCriteria(Expense.class);
		cr.add(Restrictions.between("expenseDate", start, end));
		
		List expenses = cr.list();
		session.close();
		return expenses;
		/*for(Expense ex:cr.list()) {
			return ex.getCost();
		}*/
		return cr.list();
		
		
		 
		
		
		return 0;
	}



}
