package Lab5;

public class Container {
	// Do not change the value of the following constants.
	protected final int ORIGINAL_SIZE = 10; 
	protected Object[] list; // is a container that stores the element of MyList
	protected Object[] set; // is a container that stores the element of MySet
	protected int size; // this variable holds the actual number of elements that are stored in either of the containers (i.e. MyList or MySet).

	/**
	 * This method adds the <code> obj </code> to the end of the container.
	 * @param obj is the object that is added to the container.
	 */
	void add(Object obj) {
		System.out.println("The object was added to the contianer");
	}
	/**
	 * This method removes the <code> obj </code> from the container. 
	 * It shifts all the elements to make sure that removal of the element
	 * does not create a whole in the container.
	 * @param obj is the object that is removed from the container. 
	 * @return It returns the object that was removed.
	 */
	Object remove(Object obj) {
		System.out.println("The object was removed from the container.");
		return obj;
	}
	/**
	 * This method returns true if the container is empty.
	 * @return It returns true if the container is empty, otherwise false.
	 */
	boolean isEmpty() {
		boolean flag = false;
		if(size == 0) {
			flag = true;
		}
		else {
			flag = false;
		}
		return flag;
	}

	/**
	 * This method returns the number of elements stored in the container.
	 * @return It returns the number of elements in the container.
	 */
	int getSize() {
		// you may want to change this return value.
		return this.size;
	}

}

/**
 * 
 * This class simulates an ArrayList, where you can add unlimited number of 
 * elements to the list.
 *
 */
class MyList extends Container{
	/**
	 * This is the default constructor that sets all the instance variables to their defualt value. 
	 */
	public MyList () {
		list = new Object[ORIGINAL_SIZE];
		size = 0; 
	}

	/**
	 * This method returns the element that is stored at index <code> index </code>.
	 * @param index is the<code> index </code> at which the element is accessed and returned. 
	 * @return it returns the element stored at the given <code> index </code>.
	 */
	public Object get(int index) {
		Object obj1 = list[index];
		return obj1;
	}
	/**
	 * This method overrides the <code> add </code> method defined in class <code> container</code>. By
	 * adding the <code> obj </code> to the back of the <code> list </code> array. 
	 * The original size of the <code> array </code> is defined by <code> ORIGINAL_SIZE </code>, however, it is possible that 
	 * more elements is added to this array. In case the array does not have enough capacity to add one more element, it grows itself 
	 * by doubling the size of <code> list </code> array.     
	 */
	@Override
	void add(Object obj) {
		if (size < list.length ) {
			list[size] = obj; 
		}
		else {
			Object[] doubleSize = new Object[2 * list.length];
			for(int i = 0; i < list.length; i++) {
				doubleSize[i] = list[i]; 
				doubleSize[i] = obj;
				list = doubleSize; 
			}
		}
		size++; 
	}


	/**
	 * This method removes the first occurrence of <code> obj </code>
	 * from <code> list </code>
	 * @pre <code> obj </code> exists in the <code>list</code> array.
	 * 
	 */
	@Override
	Object remove(Object obj) {
		int firstOccur = 0; 
		Object[] remove = new Object [list.length];
		for(int i = 0; i < this.getSize(); i++) {
			if(list[i].equals(obj)) {
				firstOccur = i;
			}
			else {
				remove[firstOccur] = list[i]; 
				firstOccur++;
			}
		}
		list = remove;
		size--; 
		return obj;
	}

	/**
	 * This method returns the elements of the MyList in a form of 
	 * [obj1 obj2 obj3 ...]
	 */

	@Override
	public String toString() {
		String toStr = "[";
		for(int i = 0; i < this.getSize(); i++){
			toStr += list[i];
			if(i != size-1) {
				toStr += " ";
			}
		}
		return toStr +="]";
	}

}

class MySet extends Container{
	public MySet() {
		set = new Object[ORIGINAL_SIZE];
		size = 0; 
	}

	/**
	 * This method overrrides the <code> add </code> method defined in class <code> container</code>. By
	 * adding the <code> obj </code> to the back of the <code> set </code> array. 
	 * The original size of the <code> set </code> is defined by <code> ORIGINAL_SIZE </code>, however, it is possible that 
	 * more elements is added to this set. In case the set does not have enough capacity to add one more element, it grows itself 
	 * by doubling the size of <code> set </code> array.      
	 */

	@Override
	void add(Object obj) {
		boolean numExist = false;

		if(size >= set.length){
			Object[] doubleSize1 = new Object[2*set.length];
			for(int i = 0; i < size; i++) {
				doubleSize1[i] = set[i];
				doubleSize1[size] = obj;
			}
			set = doubleSize1;
		}

		for(int i = 0; i < this.getSize(); i++){
			if(set[i].equals(obj)) {
				numExist = true;
			}
		}

		if(numExist == false) {
			set[size] = obj;
			size++;
		}		
	}


	/**
	 * This method removes the first occurrence of <code> obj </code>
	 * from <code> set </code>
	 * @pre <code> obj </code> exists in the <code>set</code> array.
	 * 
	 */
	@Override
	Object remove(Object obj) {
		// insert your code here. You may want to change the return value.		
		Object[] remove = new Object [set.length];
		int firstOccur1 = 0; 

		for(int i = 0; i < this.getSize(); i++) {
			if(set[i].equals(obj)) {
				firstOccur1 = i;
			}
			else {
				remove[firstOccur1] = set[i]; 
				firstOccur1++;
			}
		}

		set = remove;
		size--; 
		return obj;
	}

	/**
	 * This method returns the elements of the MySet in a form of 
	 * [obj1 obj2 obj3 ...]
	 */

	@Override
	public String toString() {
		// insert your code here. You may want to change the return value.		
		String toString2 = "[";
		
		for(int i = 0; i < this.getSize(); i++){
			toString2 += set[i];
			if(i != size - 1)
				toString2 += " ";
		}
		
		toString2 += "]";
		return toString2;
	}


}
