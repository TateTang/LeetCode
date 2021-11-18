package com;

import java.util.List;

/**
 * @Author tangmf
 * @Date 2020/4/9 16:54
 * @Description
 */
public class Node {
	public int val;
	public List<Node> children;
	public Node left;
	public Node right;

	public Node() {
	}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, List<Node> _children) {
		val = _val;
		children = _children;
	}
	public Node(int _val,Node _left,Node _right) {
		val = _val;
		left = _left;
		right = _right;
	}
}
