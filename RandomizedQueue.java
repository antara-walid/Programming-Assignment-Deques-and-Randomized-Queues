/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] array;
    private int size;
    private int last;

    // construct an empty randomized queue
    public RandomizedQueue() {
        array = (Item[]) new Object[1];
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if (size == array.length)
            resize(size * 2);
        array[last++] = item;
        size++;
    }

    // remove and return a random item
    public Item dequeue() {
        int randomIndex = StdRandom.uniformInt(size);
        Item returnedValue = array[randomIndex];
        last--;
        swap(randomIndex, last); // we swap the random value with the last value in the array
        // so that we can keep the null value in the end of the array
        array[last] = null;
        size--;
        if (size == array.length / 4)
            resize(array.length / 2);
        return returnedValue;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        int randomIndex = StdRandom.uniformInt(size);
        Item returnedValue = array[randomIndex];
        return returnedValue;
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private void resize(int capacity) {
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = array[i];
        }

        array = temp;
        last = size;
    }

    private void swap(int firstIndex, int secondeIndex) {
        Item temp = array[firstIndex];
        array[firstIndex] = array[secondeIndex];
        array[secondeIndex] = temp;
    }

    private class RandomizedQueueIterator implements Iterator<Item> {

        int index;
        Item copy[];

        public RandomizedQueueIterator() {
            copy = (Item[]) new Object[size];
            for (int i = 0; i < size; i++)
                copy[i] = array[i];
            StdRandom.shuffle(copy);
        }

        public boolean hasNext() {
            return index < size;
        }

        public Item next() {
            return copy[index++];
        }
    }

    public static void main(String[] args) {
        RandomizedQueue queue = new RandomizedQueue();
        queue.enqueue(1);
        queue.enqueue(7);
        queue.enqueue(10);
        queue.enqueue(15);
        queue.enqueue(20);
        System.out.println(queue.dequeue());
        System.out.println("size :" + queue.size());
        System.out.println("isEmpty :" + queue.isEmpty());
        for (Object element : queue) {
            System.out.print((int) element);
        }
        System.out.println();
    }
}
