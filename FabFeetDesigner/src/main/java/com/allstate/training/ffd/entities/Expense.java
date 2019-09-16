package com.allstate.training.ffd.entities;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Expense {
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 private int expenseId;
 private String expenseType;
 private float expenseAmount;
 private Blob expenseDoc;
public int getExpenseId() {
	return expenseId;
}
public void setExpenseId(int expenseId) {
	this.expenseId = expenseId;
}
public String getExpenseType() {
	return expenseType;
}
public void setExpenseType(String expenseType) {
	this.expenseType = expenseType;
}
public float getExpenseAmount() {
	return expenseAmount;
}
public void setExpenseAmount(float expenseAmount) {
	this.expenseAmount = expenseAmount;
}
public Blob getExpenseDoc() {
	return expenseDoc;
}
public void setExpenseDoc(Blob expenseDoc) {
	this.expenseDoc = expenseDoc;
}
@Override
public String toString() {
	return "Expense [expenseId=" + expenseId + ", expenseType=" + expenseType + ", expenseAmount=" + expenseAmount
			+ ", expenseDoc=" + expenseDoc + "]";
}
 
}
