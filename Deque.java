/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */


import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Node head;
    private Node tail;
    private int size;

    // construct an empty deque
    public Deque() {
        size = 0;
        head = null;
        tail = null;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null)
            throw new IllegalArgumentException();
        Node oldHead = head;
        head = new Node();
        head.value = item;
        head.previous = null;
        head.next = oldHead;
        if (size == 0)
            tail = head;
        else
            oldHead.previous = head;
        size++;
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null)
            throw new IllegalArgumentException();
        Node oldTail = tail;
        tail = new Node();
        tail.value = item;
        tail.next = null;
        tail.previous = oldTail;
        if (size == 0) {
            head = tail;
        }
        else {
            oldTail.next = tail;
        }
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();
        Item returnedItem = (Item) head.value;
        head = head.next;
        if (head != null)
            head.previous = null;
        else
            tail = null;
        
        size--;
        return returnedItem;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();
        Item returnedItem = (Item) tail.value;
        tail = tail.previous;
        if (tail != null)
            tail.next = null;
        else
            head = null;
        size--;
        return returnedItem;
    }

    public Iterator<Item> iterator() {

        return new DequeIterator();
    }

    private class Node<Item> {
        Item value;
        Node next;
        Node previous;
    }

    private class DequeIterator implements Iterator<Item> {

        private Node current = head;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            Item returnedItem = (Item) current.value;
            current = current.next;
            return returnedItem;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        Deque deque = new Deque<String>();

        deque.addLast("test");
        deque.removeFirst();

        System.out.println("###################");
        for (Object element : deque) {
            System.out.print((String) element);
        }
    }
}
