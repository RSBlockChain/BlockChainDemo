package com.blockchaindemo.model;

import java.util.ArrayList;
import java.util.List;

public class Peer implements Comparable<Peer> {

	private List<Block> blocks;

	public Peer() {
		this.blocks = new ArrayList<>();
	}

	public Peer(List<Block> blocks) {
		this.blocks = blocks;
	}

	public List<Block> getBlocks() {
		return blocks;
	}

	public void setBlocks(List<Block> blocks) {
		this.blocks = blocks;
	}

	public void display() {
		for (Block b : blocks) {
			b.display();
		}
	}

	@Override
	public int compareTo(Peer other) {
		if (getBlocks().get(getBlocks().size() - 1).hashCode() == other.getBlocks().get(other.getBlocks().size() - 1)
				.hashCode()) {
			return 0;
		}
		return -1;
	}

}
