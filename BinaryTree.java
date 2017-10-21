

//import java.util.*;
public class BinaryTree {
	
	Node root;
	
	public void addNode(int key, String name) {
		Node newNode= new Node(key,name);
		
		if(root==null) {
			
			root=newNode;
			return;
			
		} else {
			
			Node focusNode = root;
			Node parent;
			
			while(true) {
				
				parent=focusNode;
				
				if(key < focusNode.key) {
					
					focusNode = focusNode.left;
					
					if(focusNode==null) {
						
						parent.left=newNode;
						return;
						
					}
				} else {
					
					focusNode = focusNode.right;
						
					if(focusNode==null) {
						
						parent.right=newNode;
						return;
						
					}
					
				}
			}
			
		}
	}
	
	public void inOrderTraversal(Node focusNode) {
		if(focusNode!=null) {
			
			inOrderTraversal(focusNode.left);
			System.out.println(focusNode);
			inOrderTraversal(focusNode.right);
		}
	}
	
	public void preOrderTraversal(Node focusNode) {
		if(focusNode!=null) {
			System.out.println(focusNode);
			preOrderTraversal(focusNode.left);
			preOrderTraversal(focusNode.right);
		}
	}
	
	public void postOrderTraversal(Node focusNode) {
		if(focusNode!=null) {
			
			postOrderTraversal(focusNode.left);
			postOrderTraversal(focusNode.right);
			System.out.println(focusNode);
		}
	}
	
	public Node findNode(int key) {
		Node parent = root;
		while(true) {
			if(parent==null) {
				return null;
			}
			if(key==parent.key) {
				return parent;
			} else {
				if(key>parent.key) {
					parent=parent.right;
				} else {
					parent=parent.left;
				}
			}
		}
	}
	
	public boolean removeNode (int key) {
		
		Node focusNode = root;
		Node parent=root;
		
		boolean isItALeftChild = true;
		
		while(focusNode.key != key) {
			
			parent=focusNode;
			
			if(key < focusNode.key) {
				
				isItALeftChild = true;
				
				focusNode = focusNode.left;
			} else {
				
				isItALeftChild = false;
				
				focusNode = focusNode.right;
			}
			
			if(focusNode==null) 
				return false;
			
		}
		
		if(focusNode.left==null && focusNode.right==null) {
			
			if(focusNode==root) {root=null;}
			else if(isItALeftChild) {parent.left=null;}
			else {parent.right=null;}
			
		}
		
		else if(focusNode.right==null) {
			if(focusNode==root) {
				root = focusNode.left;
			} else if(isItALeftChild) {
				parent.left=focusNode.left;
			} else {
				parent.right=focusNode.left;
			}
			
		}
		
		else if (focusNode.left==null){
			if(focusNode==root) {
				root=focusNode.right;
			} else if(isItALeftChild) {
				parent.left=focusNode.right;
			} else {
				parent.right=focusNode.right;
			}
			
		}
		
		else {
			Node replacement = getReplacementNode(focusNode);
			
			if(focusNode==root) {
				root=replacement;
			}
			
			else if(isItALeftChild) {
				parent.left=replacement;
			}
			
			else {
				parent.right=replacement;
			}
			
			replacement.left=focusNode.left;
		}
		
		return true;
	}
	
	public Node getReplacementNode(Node replacedNode) {
		
		Node replacementParent = replacedNode;
		Node replacement = replacedNode;
		
		Node focusNode = replacedNode.right;
		
		while(focusNode!=null) {
			
			replacementParent=replacement;
			replacement=focusNode;
			focusNode=focusNode.left;
		}
		
		if(replacement != replacedNode.right) {
			replacementParent.left = replacement.right;
			replacement.right = replacedNode.right;
		}
		
		return replacement;
	}

	public static void main(String[] args) {
		
		/*BinaryTree mTree = new BinaryTree();
	
		mTree.addNode(50, "Boss");
		mTree.addNode(25, "Vice press");
		mTree.addNode(15, "Office Manager");
		mTree.addNode(30, "Secretary");
		mTree.addNode(27, "Secretary");
		mTree.addNode(75, "Sales Manager");
		mTree.addNode(85, "Sales man");
		mTree.addNode(70, "super man");
		int node = 50;
		
		try {
		System.out.println(mTree.findNode(node).name);
		}
		catch(Exception e) {
			System.out.println("Node not found");
		}
		
		mTree.removeNode(node);
		
		try {
			System.out.println(mTree.findNode(node).name);
			}
			catch(Exception e) {
				System.out.println("Node not found");
			}*/


	}
	
	
}

class Node{
	
	int key;
	String name;
	
	Node left;
	Node right;
	
	
	public Node(int key, String name) {
		this.key = key;
		this.name = name;
	}

	public String toString() {
		return name + " has a key of " + key;
	}
	
	
}
