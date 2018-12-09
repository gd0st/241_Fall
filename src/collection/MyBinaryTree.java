package collection;
import collection.MyQueue;
import collection.MyBinaryNode;
public class MyBinaryTree {
	protected MyBinaryNode root; 
	public MyBinaryTree() {
		root = new MyBinaryNode(null);	
	}
	public MyBinaryTree(Object item) {
		root = new MyBinaryNode(item);	
	}
	public int numberOfNodes() {
		return numberOfNodes(root);
	}
	public int numberOfNodes (MyBinaryNode node) {
		if (node == null) {
			return 0;	
		} else {
			return (numberOfNodes(node.leftChild) + 1 + numberOfNodes(node.rightChild));	
		}	
	}
	public int depth() {
		return depth(root);	
	} 
	private int depth(MyBinaryNode node) {
		if (node == null) return 0;	
		else {
			int leftDepth = depth(node.leftChild);
			int rightDepth = depth(node.rightChild);			
			if (leftDepth > rightDepth) {
				return leftDepth + 1;	
			} else {
				return rightDepth + 1;	
			}
		}
	}
	public void insert(Object item) {
		if (root.data == null) root = new MyBinaryNode(item);
		else
			insertHelper(root, item);	
	}
	private void insertHelper(MyBinaryNode root, Object key) {
		MyQueue q = new MyQueue();	
		q.insertBack(root);
		int levels = 0; 
		while (!q.isEmpty()) {
			MyBinaryNode chosen = (MyBinaryNode)q.removeFront();	
			if (chosen.leftChild == null) {
				MyBinaryNode temp = new MyBinaryNode(key);
				chosen.leftChild = temp;
				break;
			} else {
				q.insertBack(chosen.leftChild);	
				levels++;
			}
			if (chosen.rightChild == null) {
				MyBinaryNode temp = new MyBinaryNode(key);
				chosen.rightChild = temp;	

				break;
			} else {
				q.insertBack(chosen.rightChild);	
			
			}
		}
	
	}
	private void postorder(MyBinaryNode root) {
		if(root==null) return;	
		postorder(root.leftChild);
		postorder(root.rightChild);
		System.out.print(root.data.toString() + " ");
	}
	private void inorder(MyBinaryNode root) {
		if (root== null) {
			return;	
		}
		inorder(root.leftChild);
		System.out.print(root.data.toString() + " ");
		inorder(root.rightChild);	
	}
	private void preorder(MyBinaryNode root) {
		if (root == null) {
			return;		
		}
		System.out.print(root.data.toString() + " ");
		preorder(root.leftChild);
		preorder(root.rightChild);
	
	}
	public void inorder() {
		inorder(root);	
		System.out.println();
	}
	public void postorder() {
		postorder(root);	
		System.out.println();

	}
	public void preorder() {
		preorder(root);	
		System.out.println();

	}
}