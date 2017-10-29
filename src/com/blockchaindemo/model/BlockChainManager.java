package com.blockchaindemo.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BlockChainManager {

	private List<Peer> peers;

	public BlockChainManager() {
		this.peers = new ArrayList<>();
	}

	public BlockChainManager(int numberOfPeers) {
		List<Peer> peers = new ArrayList<Peer>();

		for (int i = 0; i < numberOfPeers; i++) {
			Peer peer = new Peer();
			peers.add(peer);
		}
		this.peers = peers;
	}

	public void addBlock(Block newBlock) {
		for (Peer peer : peers) {
			List<Block> allBlocks = peer.getBlocks();
			if (allBlocks.size() > 0) {
				Block lastBlock = allBlocks.get(allBlocks.size() - 1);
				newBlock.setPrevBlockHash(lastBlock.hashCode());
			} else {
				newBlock.setPrevBlockHash(0);
			}
			
			allBlocks.add(new Block(newBlock));
		}
	}

	public void hackATransaction(){
		
		// Get a peer
		Peer peer = peers.get(1);
		// Get a block in the peer
		Block block = peer.getBlocks().get(1);
		
		// Get a transaction
		Transaction transaction = block.getTransactions().get(1);
		transaction.setAmount(100);
		
		reMinePeer(peer);
	}
	
	private void reMinePeer(Peer peer) {
		Iterator<Block> iterator = peer.getBlocks().iterator();
		Block prevBlock = iterator.next();
		
		while (iterator.hasNext()) {
			Block currentBlock = iterator.next();
			currentBlock.setPrevBlockHash(prevBlock.hashCode());
			prevBlock = currentBlock;
		}
	}

	public boolean validatePeers() {

		if (peers.get(0).getBlocks().size() <= 0) {
			return true;
		}

		Iterator<Peer> iterator = peers.iterator();
		Peer peer = iterator.next();
		while (iterator.hasNext()) {
			Peer nextPeer = iterator.next();
			if (peer.compareTo(nextPeer) != 0) {
				return false;
			}
		}
		return true;
	}

	public void display() {
		for (Peer p : peers) {
			System.out.println("Peer: " + peers.indexOf(p));
			p.display();
		}
	}

}
