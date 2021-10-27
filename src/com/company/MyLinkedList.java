package com.company;


public class MyLinkedList<E> {
    protected final Node<E> myFront, myBack; // dummy header/tail
    protected int mySize; // # of elements in list

    /* Constructs a new empty list. */
    public MyLinkedList() {
        myFront = new Node<E>(null);
        myBack = new Node<E>(null);
        myBack.setPrevious(myFront);
        myFront.setNext(myBack);
        mySize = 0;
    }

    private Node<E> getNodeAt(int index) {
        if (index == -1) {
            return myFront;
        }
        else if (index == mySize) {
            return myBack;
        } else {
            Node<E> current = myFront.getNext();

            int i = 0;
            while (i < index) {
                current = current.next;
                i++;
            }

            return current;
        }
    }

    public E get(int index) {
        Node<E> node = getNodeAt(index);

        if (node.element == null) {
            throw new IllegalArgumentException("Beyond the MyLinkedList");
        } else return node.element;
    }

    /* Inserts the given element at the given index. */
    public void add(int index, E element) {
        checkIndex(index, size());

        Node<E> curr = getNodeAt(index);

        // create the new node to hold the new element
        Node<E> newNode = new Node<E>(element, curr.getPrevious(), curr);

        (newNode.getNext()).setPrevious(newNode);
        (newNode.getPrevious()).setNext(newNode);

        mySize++;
    }

    /* Appends the given element to the end of this list. Returns true. */
    public void add(E element) {
        add(size(), element);
    }

    /*
    Removes the element of this list at the given index and returns it.
    Throws IndexOutOfBoundsException if index is out of range.
    */
    public void remove(int index) {
        checkIndex(index, size() - 1);

        // get the node to remove, and update the references
        Node<E> nodeToRemove = getNodeAt(index);

        (nodeToRemove.getPrevious()).setNext(nodeToRemove.getNext());
        (nodeToRemove.getNext()).setPrevious(nodeToRemove.getPrevious());

        mySize--;
    }

    /*
    Sets the element of this list at the given index to have the given value.
    Throws IndexOutOfBoundsException if index is out of range.
    */
    public void set(int index, E value) {
        checkIndex(index, size() - 1);
        getNodeAt(index).element = value;
    }

    /* Returns the number of elements in this list. */
    public int size() {
        return mySize;
    }

    /* Returns true if this list contains no elements. */
    public boolean isEmpty() {
        return mySize == 0;
    }

    /* Removes all elements from this list. */
    public void clear() {
        myFront.setNext(myBack);
        myBack.setPrevious(myFront);
        mySize = 0;
    }

    /*
     Helper method: Throws an IndexOutOfBoundsException
     if 0 <= index <= max is not true.
    */
    private void checkIndex(int index, int max) throws IndexOutOfBoundsException {
        if (index < 0 || index > max) throw new IndexOutOfBoundsException();
    }

    public void print() {
        Node<E> current = myFront.getNext();

        while (current.next != null) {
            System.out.println(current.element);
            current = current.next;
        }

        System.out.println();
    }
}

class Node<E> {
    public E element;

    public Node<E> next;

    private Node<E> prev;

    /* Constructs a new node to store the given element, with no next node. */
    public Node(E element) {
        this(element, null, null);
    }

    /* Constructs a new node to store the given element and the given next node. */
    public Node(E element, Node<E> prev, Node<E> next) {
        this.element = element;
        this.prev = prev;
        this.next = next;
    }

    /* Accessor methods. */
    public E getElement() {
        return element;
    }

    public Node<E> getNext() {
        return next;
    }

    public Node<E> getPrevious() {
        return prev;
    }

    /* Mutator methods.*/
    public void setElement(E el) {
        element = el;
    }

    public void setNext(Node<E> newNext) {
        next = newNext;
    }

    public void setPrevious(Node<E> newPrev) {
        prev = newPrev;
    }

    /* Returns a string representation of this node. */
    public String toString() {
        return "(" + element + ")";
    }
}
