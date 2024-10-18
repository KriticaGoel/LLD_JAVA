### Agenda
* [Collections](#collections)
    *   [Common Methods](#common-methods-of-collections)



![Topics to be covered.png](..%2F..%2F..%2Fresources%2FTopics%20to%20be%20covered.png)
### Collections
![CollectionFramework.png](..%2F..%2F..%2Fresources%2FCollectionFramework.png)

#### Common methods of Collections:
* **add(E element)** - inserts the specified element to the collection
* **size()** - returns the size of the collection
* **isEmpty()** - returns true if this list contains the specified element
* **contains(Object o)** Returns an iterator over the elements in this list in a proper sequence.
* **remove(Object o)** - removes the specified element from the collection
* **iterator()** - returns an iterator to access elements of the collection
* **clear()** - removes all the elements of the collection
* **toArray()** - Returns an array containing all of the elements in this list in proper sequence
* **toArray(T[] arr)** - Inserts all of the elements in the specified collection into this list at the specified position
* **addAll(Collection c)** - adds all the elements of a specified collection to the collection
* **removeAll()** — removes all the elements of the specified collection from the collection
* **containAll(Collection c)** - Appends all the elements in the specified collection to the end of this list.Return true if this list changed as a result of the call
* **retainAll(Collection c)** - Replaces each element of this list with the result of applying the operator to that element (optional operation)
* **equal(Object o)** - Returns the hash code value for this collection. Any class that overrides the Object.equals method must also override the Object.hashCode method to satisfy the general contract for the Object.hashCode method. In particular, c1.equals(c2) implies that c1.hashCode()==c2.hashCode().
* **hashcode()**

### List
* it is an Interface extends Collection interface
* Ordered Collection: store and access element in a sequential manner
* Include duplicate elements
* Full visibility and control over the ordering of elements

#### Common methods
* All collection methods
* sort(Comparator<? super E> c) 
* replaceAll(UnaryOperator<E> operator)
* listIterator
* sublist()


### Operation of List Interface
1. Adding Elements:
    * **add(Object)**: Collection — This method is used to add an element at the end of the List.
    * **add(int index, Object o)**: Collection-This method is used to add an element at a specific index in the List
    * **addAll(Collection c)**: Collection — This method is used to add a collection of elements at the end of the List.
    * **addAll(int index,Collection c)**: Collection-This method is used to add a collection of elements at a specific index in the List
    * **addFirst()**: List- Add element at 0 index
    * **addLast()**: List- Add element at last index
    
2. Updating Elements:
   * **E set(int index, E element)**: List-**Override element** at particular index and return a previous element of that index
   
3. Search Elements:
   **indexOf(element)**:  List-Returns the index of the **first occurrence** of the specified element in the list, or -1 if the element is not found      
   **lastIndexOf(element)**:  List-Returns the index of the **last occurrence** of the specified element in the list, or -1 if the element is not found
4. Removing Elements:
   * **remove(Object)**: Collection-This method is used to simply remove an object from the List. If there are multiple such objects, then the **first occurrence of the object is removed**.
   * **remove(int index)**: List-Since a List is indexed, this method takes an integer value which simply removes the element present at that specific index in the List. After removing the element, all the elements are moved to the left to fill the space and the indices of the objects are updated.
   * **removeFirst**: List-Remove 0 index from the list
   * **removeLast**: List-Remove last element from the list
   * **clear**: Collection - Remove all elements of a list
5. Accessing Elements:
   * **get(int index)**: List-This method returns the element at the specified index in the list.
   * **getFirst**: List — Get first element of list
   * **getLast**: List —Get lat element of the list
6. Checking Elements:
   * **contains(Object)**: This method takes a single parameter, the object to be checked if it is present in the list.
7. Miscellaneous Method:
   * **reversed()** -Return a reverse-ordered view of this collection
   * **of(E e1,E e2)** -Returns an unmodifiable list containing n elements. List<Integer> integers = List.of(1, 2, 3, 4, 5, 6);
   *** replaceAll**