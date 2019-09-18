package com.allstate.training.ffd.services; 

import java.sql.Clob;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allstate.training.ffd.daos.ExpenseDao;
import com.allstate.training.ffd.entities.Expense;
import com.allstate.training.ffd.entities.Order;
import com.allstate.training.ffd.exceptions.BuisnessException;

@Service
public class ExpenseServiceImpl implements ExpenseService {
	
	@Autowired
	ExpenseDao expenseDao;

	@Override
	public void addExpense(Expense ex) throws BuisnessException{
		// TODO Auto-generated method stub
		
		if(ex.getExpenseType().matches("a-zA-Z{4,}")) {
			expenseDao.addExpense(ex);
		}
		throw new RuntimeException("ExpenseType is invalid");

	}

	@Override
	public void deleteExpense(int id) throws BuisnessException {
		// TODO Auto-generated method stub
		
		expenseDao.deleteExpense(id);
		

	}

	@Override
	public float calculateNetAmount(int start, int end) throws BuisnessException {
		// TODO Auto-generated method stub
		float sum=0;
		float sum1=0; 
		List<Expense> l= expenseDao.calculateNetAmount(start, end);
		for(Expense ex:l) {
		sum=sum+ex.getExpenseAmount();
	}
		
		
		/*List<Order> o=expenseDao.getOrderByMonth(start, end);
		for(Order order:o) {
			sum1=sum1+order.getAmount();
			
	}*/
		return sum1-sum;
	}

	@Override
	public void updateExpense(int expenseId, int expenseAmount, String expenseType, Date expenseDate,
			Clob expenseDocument) throws BuisnessException {
		// TODO Auto-generated method stub
		
		expenseDao.updateExpense(expenseId, expenseAmount, expenseType, expenseDate, expenseDocument);;

	}

}
