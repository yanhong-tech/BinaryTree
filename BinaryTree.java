
/***********************************************************
 * Create Binary Tree.
 * 
 * how to do the node/ traverse the tree by inOrder, preOrder, postOrder / find the node if it is in the tree
 ***********************************************************/

public class BinaryTree {
	Node root;
	
	//build tree
	public void addNode(int key, String name) {
		Node newNode= new Node(key, name);
		if(root==null) {
			root=newNode;
		}else {
			//if root is not null, build another node we can always to focus
			//    --
			//  -     -
			//first set focusNode to root becasue we need to compare the root child to decide left or right
			Node focusNode=root; 
			Node parent;
			//while true to loop to add more node layer by layer
			//focuseNode change by which node we are focus on now.
			while(true) {
				parent=focusNode;
				if(key<focusNode.key) {
					focusNode=focusNode.leftChild;
					if(focusNode==null) {
						parent.leftChild=newNode;
						return;
					}
				}
				else {
					focusNode=focusNode.rightChild;
					if(focusNode==null) {
						parent.rightChild=newNode;
						return;
					}
				}
			}
			
			
		}	
	}
	
	//traversal tree
	//in-order: increasing leftNode-parent-rightNode
	public void inOrderTraverseTree(Node focusNode) {
		if(focusNode!=null) {
			//remember focusNode always change
			//when we add the node to make a tree we already know that the lefterNode less
			inOrderTraverseTree(focusNode.leftChild); 
			System.out.println(focusNode);
			inOrderTraverseTree(focusNode.rightChild);
		}
	}
	
	//traversal tree
	//pre-order: parent-leftNode-rightNode
	public void preOrderTraverseTree(Node focusNode) {
		if(focusNode!=null) {
			//remember focusNode always change
			//when we add the node to make a tree we already know that the lefterNode less
			System.out.println(focusNode);
			preOrderTraverseTree(focusNode.leftChild); 
			preOrderTraverseTree(focusNode.rightChild);
		}
	}
	
	//traversal tree
	//post-order: leftNode-parent-rightNode
	public void postOrderTraverseTree(Node focusNode) {
		if(focusNode!=null) {
			//remember focusNode always change
			//when we add the node to make a tree we already know that the lefterNode less
			postOrderTraverseTree(focusNode.leftChild); 
			postOrderTraverseTree(focusNode.rightChild);
			System.out.println(focusNode);
		}
	}
	
	
   //how to find a node in the binary tree
	public Node findNode(int key) {
		Node focusNode=root;
		
		//while the serach key not == to focusNode, keep looking
		while(focusNode.key!=key) {
			//if search less than the tree root key, check the left key, otherwise check the right key
			if(key < focusNode.key) {
				focusNode=focusNode.leftChild;
			}else {
				focusNode=focusNode.rightChild;
			}
			
			//remember to add if the node is null. then return null. which can not find in the build binary tree. 
			if(focusNode==null) {
				return null;
			}
		}
		return focusNode;
	}
	
	
	/***********************************************************
	 * main class
	 ***********************************************************/
	
	public static void main(String[] args) {
		
		BinaryTree theTree = new BinaryTree();
		
		theTree.addNode(45, "A");
		theTree.addNode(20, "B");
		theTree.addNode(10, "C");
		theTree.addNode(25, "D");
		theTree.addNode(70, "E");
		theTree.addNode(98, "F");
		
		theTree.inOrderTraverseTree(theTree.root);//check why here is root
		System.out.println();
		theTree.preOrderTraverseTree(theTree.root);
		System.out.println();
		theTree.postOrderTraverseTree(theTree.root);
		
		//try to use the different numbers to test. 
		
		System.out.println("now we can try serach number 11 ");
		
		System.out.println("we found serah number " + theTree.findNode(11));
	}
	
	
	/***********************************************************
	 * Node class
	 ***********************************************************/
	class Node{
		int key; 
		String name;
		
		Node leftChild;
		Node rightChild;
		
		Node(int key, String name){
			this.key=key;
			this.name=name;
			
		}
		public String toString() {
			return name + " has a key " + key;
		}
		
	}

}
