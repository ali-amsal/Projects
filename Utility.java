package Lab8;
import java.util.List;
import java.util.ArrayList;

/**
 * This class contains a number of methods that 
 * works on a wide range of data types. 
 */

/* This is a parameterized class. You should decide 
 * what the parameter should look like in order to 
 * pass all the test cases. 
 */
public class Utility <T> {  //Change this line to create a parameterized class

	public List<T> list; 

	public Utility() {
		this.list = new ArrayList<T>();
	}

	public Utility(List<T> mylist) {
		this.list = new ArrayList<T>(mylist);
	}

	public <T extends Comparable> int linearSearch(T item) {
		int position = -1;
		for (int i = 0; i < list.size(); i++) {
			if (item.compareTo(list.get(i)) == 0) {
				position = i;
				break;
			}
		}
		return position; 
	}

	public void mergeList(List<? super T> list) {
		for (T obj : this.list)
			list.add(obj);
	}


	public boolean containList(List<T> list) {
		if (this.list.containsAll(list)) {
			this.list = new ArrayList<T>();
			for (T obj : list) 
				this.list.add(obj);
			return true;
		} 
		else
			return false;
	}

	public static void removeZero (List <? extends MyInteger> myList) { 
		for (int i = 0; i < myList.size(); i++) {
			if (MyInteger.isZero(myList.get(i))) {
				myList.remove(i);
				i--;
			}
		}
	}

}
/**
 * This class implements a 2D points. 
 */
class Point implements Comparable<Point>{
	double x; 
	double y; 
	public Point(double x, double y) {
		this.x = x; 
		this.y = y;
	}
	@Override 
	public int compareTo(Point p) {
		if (this.x == p.x && this.y == p.y) return 0;
		else if (this.x == p.x) return 1;
		else return -1;	
	}
}

/**
 * This class represents an Integer number. 
 */
class MyInteger implements Comparable<MyInteger>{
	int x; 
	public MyInteger() {
		this.x = 0; 
	}
	public MyInteger(int x) {
		this.x = x; 
	}
	public static boolean isZero(MyInteger input) {
		return input.x == 0; 
	}
	@Override
	public int compareTo(MyInteger input) {
		if (this.x == input.x ) return 0;
		else if (this.x < input.x) return -1;
		else return 1;	
	}
}
/**
 * This class represents a subset of integer numbers that are natural numbers. 
 */
class NaturalNumber extends MyInteger{
	public NaturalNumber(int x) {
		super(x);
	}
}
/**
 * This class represents the odd natural numbers. 
 */

class OddNumber extends NaturalNumber{
	public OddNumber(int x) {
		super(x);
	}

}
/**
 * This class represents the even natural numbers. 
 */
class EvenNumber extends NaturalNumber{
	public EvenNumber(int x) {
		super(x);
	}
}






















































public class FourLinkedList<E> implements List<E>{
	
	/**
	 * Instance variables: 
	 * - first refers to the first node in the list. 
	 * - last refers to the last node in the list
	 * - currentNode has been declared in case we need to manipulate a node in any of the following methods. 
	 * - length refers to the size of the list.
	 */
	
	Node<E> first;
	Node<E> last;
	Node<E> currentNode;
	private int length;
	
	/**
	 * This default constructor creates an empty four linked list. 
	 */
	
	public FourLinkedList() {
		this.first = null;
		this.last = null;
		this.currentNode = null;
		this.length = 0;
	}
	
	//---------------------- nested Node class ------------------------
		private static class Node<E> {
			
			//---------------------- nested Node class ------------------------
			/**
			 * The purpose of this class is to create a Node resembling that of the ones in the image in the pdf. 
			 *
			 * @param <E>: E refers to generics, meaning that a client could create a node of any type, without the programmer having 
			 * to code the class over and over again.
			 */
			
			
			private E element;
			private Node<E> next;
			private Node<E> previous;
			private Node<E> nextFour;
			private Node<E> prevFour;
			
			/**
			 * This overloaded constructor creates the Node.	
			 * @param p4 refers to the link connecting the node to the node that is 4 before the current one. 
			 * @param p refers to the link connecting the node to the node that is before the current one.
			 * @param e refers to the element that the node being created is carrying.
			 * @param n refers to the link connecting this node to the next one. 
			 * @param n4 refers to the link connecting this node to the one that is 4 nodes after it. 
			 */
			
			
			public Node(Node<E> p4, Node<E> p, E e, Node<E> n, Node<E> n4) {
			this.element  = e;
			this.next = n;
			this.previous = p;
			this.nextFour = n4;
			this.prevFour = p4;
			}
			
			
		} // ---------------------- end of nested Node class -----------------
	
    public Node<E> getFirst() {
    	return first;
    }
    
    public Node<E> getLast() {
    	return last;
    }
    
    /**
	 * This method adds a new node to the end of the four linked list, and returns true if successful. 
	 * @param E refers to the type of the element being added. Generics was used here to avoid redundant code. 
	 */
		
	public boolean add(E object) {
		
        currentNode = last;
     // if the list is empty, the first element will be the new element and also the last element. 
        if (first == null) {
            first = new Node<E>(null, null, object, null, null);  
            last = first;  
        }
        
        // length < 4 not length < 5
        else if (length < 4){
        	
        	Node<E> newNode = new Node<E>(null, currentNode, object, null, null);
            currentNode.next = newNode;
            last = newNode;

        }
        
        // add this part for previous 4 to exist
        // if length is exactly 4, after the new node is added, the link connecting the new node to the previous 4th node will be 3 before
        // the last node before the new node was added.
        
        else if (length == 4){
        	
        	Node<E> newNode = new Node<E>(currentNode.previous.previous.previous, currentNode, object, null, null);
            currentNode.next = newNode;
            newNode.prevFour.nextFour = newNode;
            last = newNode;

        }
        
     // in every other case, the last node before the new node was added will have to update it's next link, the new node's previous 4 link will be updated,
        // and the next four of the node that is 4 before the last node before the new node was added will have to be updated. 
        
        else {
            Node<E> newNode = new Node<E>(null, currentNode, object, null, null);
            currentNode.next = newNode;
            newNode.prevFour = currentNode.prevFour.next;
            currentNode.prevFour.next.nextFour = newNode;
            
            last = newNode;

        }
        length++;
        return true;    
    }

	
	/**
     * This method was created because it was needed in the add (int index, E element) method. It adds an object to the beginning of the linked list. 
     * @param object refers to the element being added at the beginning of the list. 
     * At the beginning of this method, currentNode has been set to the first node. 
     */
	
	public void appendBegin(E object){
        currentNode = first;
        
     // if the list is empty, then the element being added to the list will be the first, and the last, and will have no links referencing any other nodes. 
        if (first == null) {
            first = new Node<E>(null, null, object, null, null);  
            last = first;  
        }
        
     // if the length of the list is less than 5, the next link of the new node will be currentNode, and there will be no links referencing the previous and previous 4 nodes. 
        else if (length < 5){
        	
        	Node<E> newNode = new Node<E>(null, null, object, currentNode, null);
            currentNode.previous = newNode;
            first = newNode;

        }
        
     // in every other case, the new node will have to update its next and next four links, and the node that is 4 ahead of the new node will have to update its previous 4.
        
        else {
            Node<E> newNode = new Node<E>(null, null, object, currentNode, currentNode.nextFour.previous);
            currentNode.previous = newNode;
            currentNode.nextFour.previous.prevFour = newNode;
            first = newNode;

        }
        
         
    }
	
	/**
	 * This method adds a node at a specific index and updates the links to all affected nodes. 
	 * @param index refers to the index of the list where the new node will be added. 
	 * @param element refers to the data that is being added to the new node. 
	 */
	
	public void add(int index, E element) {
		
		// if the index is bigger than the list, it cannot be added and will throw an UnsupportedOperationException.
	        if(index>length){
	            throw new UnsupportedOperationException();
	        }
        
	       if(index==length) {
				add(element);
				length--;
			}
			
			
			else if(index>0 && index<length) {
			Node<E> current = getNode(index);
			Node<E> newN = new Node<E>(null, current.previous, element, current, null);
			
			current.previous.next= newN;
			current.previous=newN;
			
			Node<E> temp2 = current;
			
			try{newN.prevFour=current.prevFour;}
			catch(Exception e2) {}
			
			
			
			
			
			for(int i=0 ; i<4; i++) {
				try {
					temp2.prevFour = temp2.previous.previous.previous.previous;
					temp2=temp2.next;
					
				}
				catch(Exception e){
					try{temp2=temp2.next;}
					catch(Exception e2) {}
				}
			}
			Node<E> temp = getNode(index-2);
			
			for(int i=0 ; i<4; i++) {
				try {
				
					temp.nextFour = temp.next.next.next.next; 
					temp=temp.previous;
				}
				catch(Exception e){
					try{temp=temp.previous;}
					catch(Exception e2) {}
					
				}
			}
			
		
			
			
			
			}
			
			else if(index==0) {
				appendBegin(element);
			}
			
			
			length++;


		}
	
	/**
	 * This method removes an element from the linked list at a sepcific index. 
	 * @param index refers to the element that is being removed from the linked list. 
	 */
	
	public E remove(int index) {
        Node<E> currentNode = getNode(index);
        if(first == null || index > (length - 1)) {
            // error
        }
        else if(index < 4) {
            if(index == 0 && length < 2) {
                first = null;
                last = null;
            }
            else if(index == 0) {
            	first.next.previous = null;
                if(first.nextFour != null) {
                	first.nextFour.prevFour = null;
                }
                first = first.next;
            }
            else if(index != (length - 1)) {
            	currentNode.previous.next =  currentNode.next;
            	currentNode.next.previous = currentNode.previous;
            	if(currentNode.nextFour != null) {
        			currentNode.previous.nextFour = currentNode.nextFour;
        			currentNode.nextFour.prevFour = currentNode.previous;
        		}
        		else {
        			currentNode.previous.nextFour = null;
        		}
        		currentNode = currentNode.previous;
            	for(int i = 0; i < index - 1; i++) {
            		if(currentNode.nextFour != null) {
            			currentNode.previous.nextFour = currentNode.nextFour.previous;
            			currentNode.nextFour.previous.prevFour = currentNode.previous;
            		}
            		else {
            			currentNode.previous.nextFour = null;
            		}
            		currentNode = currentNode.previous;
            	}
            }
            else {
            	last.previous.next = null;
            	last = last.previous;
            }
        }
        
        // fix 
        else if(index > (length - 5)) {
            if(index == length - 1) {
            	last.prevFour.nextFour = null;
            	last.previous.next = null;
                last = last.previous;
                

            }
            else if(index != (length - 1)) {
            	for(int i = 1; i < length - index; i ++) {
            		getNode((index+i)).prevFour=getNode((index+i)).prevFour.previous;
            		getNode((index+i)).prevFour.nextFour=getNode((index+i));
            	}
            	currentNode.previous.next =  currentNode.next;
            	currentNode.next.previous = currentNode.previous;
            }
            
        }
        else if (index == 4) {
        	currentNode.previous.next =  currentNode.next;
        	currentNode.next.previous = currentNode.previous;
        	if(currentNode.nextFour != null) {
    			currentNode.prevFour.nextFour = currentNode.nextFour;
    			currentNode.nextFour.prevFour = currentNode.prevFour;
    		}
        }
        else {
        	for(int i = 1; i < 5; i ++) {
        		getNode((index+i)).prevFour=getNode((index+i)).prevFour.previous;
        		getNode((index+i)).prevFour.nextFour=getNode((index+i));
        	}
        	currentNode.previous.next =  currentNode.next;
        	currentNode.next.previous = currentNode.previous;
        	
        	
        	
        }
		length--;
		return null;
	}
	
	

    /**
     * This method returns the node at a specific index. 
     * @param index refers to the index at which the desired node is located. 
     * @return value is the desired node. In this case it is held by currentNode. 
     */
    
	public Node<E> getNode(int index) {
		int counter = 0;
		
		if(index >= length || index < 0) {
			currentNode = null;
		}
		else if(index == 0) {
			currentNode = first;
		}
		else if(index == length - 1) {
			currentNode = last;
		}
		else if(index < 4) {
			currentNode = first;
			for(int i = 0; i < index; i++) {
                currentNode = currentNode.next;
		    }
		}
		else if((length - 1 - index) < 4) {
			currentNode = last;
			for(int i = length - 1; i > index; i--) {
                currentNode = currentNode.previous;
		    }
		}
		else {
			if(index < (length/2)) {
				currentNode = first;
	            for(int i = 4; i < index; i += 4) {
	            	currentNode = currentNode.nextFour;
	            	counter = i;
	            }
	            if(index == 4) {
	            	currentNode = currentNode.nextFour;
	            }
	            int remainder = (index - counter) % 4;
	            for(int i = 0; i < remainder; i++) {
	            	currentNode = currentNode.next;
	            }
	        }
			else if(index >= (length/2)) {
	            currentNode = last;
	            for(int i = length - 1; i > index + 3; i -= 4) {
                    currentNode = currentNode.prevFour;
                    counter = i;
    		    }
                counter -= 4;
                int remainder = (counter - index) % 4;
                for(int i = 0; i < remainder; i++) {
                    currentNode = currentNode.previous;
    		    }
	        }
		}
                        
		return currentNode;
	}
	
	
	/**
	 * This method calls on the getNode method and just returns the element of the node. 
	 * @param index refers to the index of the element of the desired node. 
	 */
	
	public E get(int index) {
		return getNode(index).element;
	}
	

    /**
     * This method returns the size of the list. 
     */
	
	public int size() {
		return length;
	}
	
	/**
	 * This method clears the entire list by setting the links and elements of the first and last nodes to null and assigning the length to equal zero.
	 */
	
	public void clear() {
		
		this.first = null;
		this.last = null;
		this.length = 0;
	}
	
	/**
	 * This method converts list into a string and returns it. This can be used to ouput the list to a user or for JUnit testing purposes. 
	 * @return value is a string variable named result. 
	 */
	
	public String toString() {
		String result = "[";
		
		// add an if for when first is null
		if (first == null) {
			result += "]";
		}
		else {
			currentNode = first;
			// length not length - 1
			for(int i = 0; i < length; i++) {
				//currentNode = currentNode.next;  get rid of
				
				// length - 1 not length - 2
				if (i < length - 1) {
					result += currentNode.element + ", ";
				}
				else {
					result += currentNode.element + "]";
				}
				// add this
				currentNode = currentNode.next;
			} 
		}
		return result;
	}