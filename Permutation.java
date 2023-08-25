/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;

public class Permutation {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> queue = new RandomizedQueue<>();
        while (!StdIn.isEmpty()) {
            String element = StdIn.readString();
            if (element.equals(args[0]))
                continue;
            queue.enqueue(element);
        }
        for (int i = 0; i < k; i++) {
            System.out.println(queue.dequeue());
        }


    }
}
