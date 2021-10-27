package com.company;


public class MyLinkedList<E> {
    protected final Node<E> myFront, myBack;
    protected int mySize;

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

    public void add(int index, E element) {
        checkIndex(index, size());

        Node<E> curr = getNodeAt(index);

        Node<E> newNode = new Node<E>(element, curr.getPrevious(), curr);

        (newNode.getNext()).setPrevious(newNode);
        (newNode.getPrevious()).setNext(newNode);

        mySize++;
    }

    public void add(E element) {
        add(size(), element);
    }

    public void remove(int index) {
        checkIndex(index, size() - 1);

        Node<E> nodeToRemove = getNodeAt(index);

        (nodeToRemove.getPrevious()).setNext(nodeToRemove.getNext());
        (nodeToRemove.getNext()).setPrevious(nodeToRemove.getPrevious());

        mySize--;
    }

    public void set(int index, E value) {
        checkIndex(index, size() - 1);
        getNodeAt(index).element = value;
    }

    public int size() {
        return mySize;
    }

    public boolean isEmpty() {
        return mySize == 0;
    }

    public void clear() {
        myFront.setNext(myBack);
        myBack.setPrevious(myFront);
        mySize = 0;
    }

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

    public Node(E element) {
        this(element, null, null);
    }

    public Node(E element, Node<E> prev, Node<E> next) {
        this.element = element;
        this.prev = prev;
        this.next = next;
    }

    public E getElement() {
        return element;
    }

    public Node<E> getNext() {
        return next;
    }

    public Node<E> getPrevious() {
        return prev;
    }

    public void setElement(E el) {
        element = el;
    }

    public void setNext(Node<E> newNext) {
        next = newNext;
    }

    public void setPrevious(Node<E> newPrev) {
        prev = newPrev;
    }

    public String toString() {
        return "(" + element + ")";
    }
}
