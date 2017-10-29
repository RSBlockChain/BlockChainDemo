package com.blockchaindemo.main;

import com.blockchaindemo.model.Block;
import com.blockchaindemo.model.BlockChainManager;
import com.blockchaindemo.model.Transaction;

public class BlockChainDemo {

	public static void main(String[] args) {

		BlockChainManager blockChainManager = new BlockChainManager(3);

		for (int i = 0; i < 3; i++) {
			Block block = getBlock(i);
			blockChainManager.addBlock(block);
		}

		blockChainManager.display();

		System.out.println(blockChainManager.validatePeers());

		blockChainManager.hackATransaction();

		blockChainManager.display();

		System.out.println(blockChainManager.validatePeers());

	}

	public static Block getBlock(int blockNum){
		//int numberOfTransactions = new Random().nextInt(10) + 1;
		
		Block block = new Block();
		block.setBlockId(String.valueOf(blockNum));
		for(int i = 0; i < 3; i++){
			block.getTransactions().add(Transaction.getTransaction());
		}
		
		return block;
	}
	
}
