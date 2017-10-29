package com.blockchaindemo.model;

import java.util.ArrayList;
import java.util.List;

public class Block {

	private String blockId;
	private int prevBlockHash;
	private List<Transaction> transactions;

	public Block(){
		transactions = new ArrayList<Transaction>();
	}
	
	public Block(String blockId, List<Transaction> transactions) {
		this.blockId = blockId;
		this.transactions = new ArrayList<>();
		this.transactions = transactions;
	}
	
	public Block(Block block) {
		this.blockId = block.getBlockId();
		this.transactions = new ArrayList<>();
		this.transactions = block.getTransactions();
		this.prevBlockHash = block.getPrevBlockHash();
	}

	public String getBlockId() {
		return blockId;
	}

	public void setBlockId(String blockId) {
		this.blockId = blockId;
	}

	public int getPrevBlockHash() {
		return prevBlockHash;
	}

	public void setPrevBlockHash(int prevBlockHash) {
		this.prevBlockHash = prevBlockHash;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public void display() {
		System.out.println("\n\tBlock ID=" + blockId +", hash code=" + hashCode() + ", prevBlockHash=" + prevBlockHash + "\n\t-------------------------------------------------------");
		for(Transaction t: transactions){
			t.display();
		}
		System.out.println();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((blockId == null) ? 0 : blockId.hashCode());
		result = prime * result + prevBlockHash;
		result = prime * result + ((transactions == null) ? 0 : transactions.hashCode());
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
		Block other = (Block) obj;
		if (blockId == null) {
			if (other.blockId != null)
				return false;
		} else if (!blockId.equals(other.blockId))
			return false;
		if (prevBlockHash != other.prevBlockHash)
			return false;
		if (transactions == null) {
			if (other.transactions != null)
				return false;
		} else if (!transactions.equals(other.transactions))
			return false;
		return true;
	}
	
}
