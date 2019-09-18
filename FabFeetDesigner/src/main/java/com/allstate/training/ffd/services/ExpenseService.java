package com.allstate.training.ffd.services;

import java.sql.Clob;
import java.sql.Date;
import java.util.List;

import com.allstate.training.ffd.entities.Expense;
import com.allstate.training.ffd.exceptions.BuisnessException;

public interface ExpenseService {
	
	public void addExpense(Expense ex) throws BuisnessException;
	public void deleteExpense(int id) throws BuisnessException;
	public float calculateNetAmount(int start, int end) throws BuisnessException;
	public void updateExpense(int expenseId, int expenseAmount, String expenseType, Date expenseDate, Clob expenseDocument) throws BuisnessException;


}
