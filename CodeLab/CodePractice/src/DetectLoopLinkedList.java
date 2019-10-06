import java.util.HashSet;

public class DetectLoopLinkedList {
	
	static Node currentHead ;
	
	static class Node{
		
		int data ;
		Node next;
		
		/*
		 * Creation of new Node 
		 */
		
		Node(int incomingData){
			data = incomingData;
			next = null;
		}
		
}
	/*
	 * Insert a new Node in LinkedList
	 */
	
	static public void push(int newData) {
		
		Node newNode = new Node(newData);
		/*
		 * As u create new Node , insert in the front of Linked List 
		 * Move the current node to the next position 
		 */
		newNode.next = currentHead;
		currentHead = newNode ;
	}
	
	static boolean detectLoop(Node checkNode) {
		
		HashSet<Node> listOfNodes = new HashSet<Node>();
		
		/*
		 * Client will just pass a node , it can contain 10 nodes after 
		 * that . If u already found in the list u have loop 
		 */
		
		while(checkNode !=null) {
			
			if(listOfNodes.contains(checkNode)) {
				return true;
			}
			listOfNodes.add(checkNode);
			checkNode = checkNode.next;
		}
		return false;
		
	}

	public static void main(String[] args) {
		
		DetectLoopLinkedList detectLoopLinkedList = new DetectLoopLinkedList();
		DetectLoopLinkedList.push(10);
		detectLoopLinkedList.push(20);
		detectLoopLinkedList.push(30);
		//detectLoopLinkedList.push(50);
		
		
		detectLoopLinkedList.currentHead.next.next.next.next = detectLoopLinkedList.currentHead;
		
		if(detectLoop(currentHead)) {
			System.out.println("Loop found");
		}else {
			System.out.println("Not found");

		}
		
	}		

}
