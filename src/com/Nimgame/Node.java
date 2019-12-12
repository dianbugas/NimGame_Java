package com.Nimgame;

public class Node {
	int[] tumpukan;
	Node simpulLama;
	int nilai;
	int atDepth;
	String pemain;

	public Node() {}
	public Node(int[] tumpukan, Node parentNode, int heuristicValue, int atDepth) {
		this.tumpukan = tumpukan;
		this.simpulLama = parentNode;
		this.nilai = heuristicValue;
		this.atDepth = atDepth;
	}
	public Node(int[] piles) {
		this(piles,null,0,0);
	}
}
