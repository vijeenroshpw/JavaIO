import java.io.*;
import IO.*;
class Node {
	public int data;
	public Node left;	
	public Node right;
	public	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
};

class BTree {
	Node root;
	public BTree() {
		root = null;
	}
			
	public void insert(int data) {
		Node node = new Node(data);
		if(root == null)
			root = node;
		else {
			Node current = root;
			Node parent = null;
			while(true) {
				parent = current;				
				if(data <= current.data) {
					current = current.left;
					if(current == null) {
						parent.left = node;	
						return;
					}
				} else {
					current = current.right;
					if(current == null){
						parent.right = node;
						return;
					}
				}
			}
		}
	}
	public Node search(int data) {
		Node current = root;		
		if(root == null)
			return null;
		while(true) {
			if(current.data == data) {
				return current;
			} 
			if(current.data >= data)
				current = current.left;
			if(current.data < data)
				current = current.right;
			if(current == null)
				return null;
		}
	}
	private Node getSuccessor(Node delNode) {
		Node successorParent = delNode;
		Node successor = delNode;
		Node current = delNode.right;
		while(current != null) {
			successorParent = successor;
			successor = current;
			current = current.left;
		}


		if(successor != delNode.right){

			successorParent.left = successor.right;
			successor.right = delNode.right;
		}
		return successor;
	}
	
	public boolean delete(int data) {
		Node parent = root;
		Node current = root;
		Node delNode = null;		
		boolean isLeftChild = false;
		if(root == null)
			return false;
		while(current.data != data) {
			parent = current;
			if(current.data < data){
				isLeftChild = true;
				current = current.left;
			} else {
				isLeftChild = false;			
				current = current.right;
			}
		}
		delNode = current;		
		// when the node to be deleted has no children
		if(delNode.right == null && delNode.left == null) {		
			if(delNode == root) {
				root = null;
			} else if(isLeftChild) {
				parent.left = null;
			} else {
				parent.right =  null;
			}
		} else if(delNode.right == null) {     // node to be deleted has only a left child
			if(delNode == root){
				root = delNode.left;
			} else if(isLeftChild) {
				parent.left = delNode.left;
			} else {
				parent.right = delNode.left;
			}
		} else if(delNode.left == null) {        //if the node has only a right child , then
			if(delNode == root) {
				root = delNode.right;		
			} else if(isLeftChild) {
				parent.left = delNode.right;
			} else {
				parent.right = delNode.right;
			}
		} else {                                // node to be deleted has two children
							
			Node successor  = getSuccessor(delNode);
			if(current == root)
				root = successor;
			else if(isLeftChild) 	
				parent.left = successor;
			else
				parent.right = successor;
			successor.left  = current.left;	
		}
		return true;
	}
	public void inorder() {
		__inorder__(root);
		System.out.println();	
	}
	private void __inorder__(Node node) {
		if(node == null)
			return;
		__inorder__(node.left);
		System.out.print("  " + node.data + "  ");
		__inorder__(node.right);
	}
	public void preorder() {
		__preorder__(root);
		System.out.println();	
	}
	private void __preorder__(Node node) {
		if(node == null)
			return;	
		System.out.print("  " + node.data + "  ");
		__preorder__(node.left);
		__preorder__(node.right);
	}
	public void postorder() {
		__postorder__(root);
		System.out.println();
	}
	private void __postorder__(Node node) {
		if(node == null)
			return;
		__postorder__(node.left);
		__postorder__(node.right);
		System.out.print("  " + node.data + "  ");
	}
 
};

class btree {
	public static void main(String argv[]) {
		BTree tree = new BTree();
		Node node = null;		
		int i;
		char ch = 'n';
		System.out.println(" Binary Search Tree Implementation. ");
		System.out.println(" i - Insert   d - Delete   v - View  e - exit ");
		System.out.println(" Enter the operation to be performed ");
		System.out.print(">>>");		
		ch = IO.readChar();              //simplified IO
		while(ch != 'e') {
			if(ch == 'i') {
				System.out.print(" Enter the element to be inserted :");
				i = IO.readInt();       //simplified IO
				tree.insert(i);
				System.out.println(" Element is insserted.");
			} else if(ch == 'd') {
			
				System.out.print(" Enter the element to be deleted :");
				i  = IO.readInt();     //simplified IO
				if(tree.delete(i))
					System.out.println(" Element succesfully deleted ");
				else
					System.out.println(" There is no such element ");
			} else if(ch == 'v') {
			
				System.out.print( " Inorder : " );
				tree.inorder();
				System.out.print(" Preorder : ");
				tree.preorder();
				System.out.print(" Postorder : ");
				tree.postorder();
			} else {
				// no operation
			}
			System.out.print(">>>");
			ch = IO.readChar();                  // simplified IO
		}
					
		
	}
}


		
