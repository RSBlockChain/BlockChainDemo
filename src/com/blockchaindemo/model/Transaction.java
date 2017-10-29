package com.blockchaindemo.model;

import java.util.Random;
import java.util.UUID;

public class Transaction {

	private String from;
	private String to;
	private int amount;

	public Transaction(String from, String to, int amount) {
		this.from = from;
		this.to = to;
		this.amount = amount;
	}
	
	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void display() {
		System.out.println("\tFrom=" + from + ", To =" + to + ", amount=" + amount);
	}
	
	public static Transaction getTransaction(){
		String from = UUID.randomUUID().toString().substring(0,5);
		String to = UUID.randomUUID().toString().substring(0,5);
		int  amount = new Random().nextInt(50) + 1;
		
		return new Transaction(from, to, amount);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + ((from == null) ? 0 : from.hashCode());
		result = prime * result + ((to == null) ? 0 : to.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (amount != other.amount)
			return false;
		if (from == null) {
			if (other.from != null)
				return false;
		} else if (!from.equals(other.from))
			return false;
		if (to == null) {
			if (other.to != null)
				return false;
		} else if (!to.equals(other.to))
			return false;
		return true;
	}
	
}
