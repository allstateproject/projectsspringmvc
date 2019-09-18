package com.allstate.training.ffd.daos;

import java.sql.Clob;
import java.sql.Date;
import java.util.List;

import com.allstate.training.ffd.entities.Expense;

public interface ExpenseDao {
	
	public void addExpense(Expense ex);
	public void deleteExpense(int id);
	public List<Expense> calculateNetAmount(int start, int end);
	public void updateExpense(int expenseId, int expenseAmount, String expenseType, Date expenseDate, Clob expenseDocument);

}
