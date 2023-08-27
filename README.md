# Programming-Assignment-Deques-and-Randomized-Queues
This repository contains the code that I developed to address the second programming assignment for the course "Algorithms, Part I"

* Link to the course [algorithms-part1](https://www.coursera.org/learn/algorithms-part1)
* Assignment specifications: [queues specifications](https://coursera.cs.princeton.edu/algs4/assignments/queues/specification.php)


## Assignment description
Write a generic data type for a deque and a randomized queue.

#### What is a deque?
A deque, short for "double-ended queue," is a data structure that allows you to efficiently add and remove elements from both ends (the front and the back). It's like a queue but with the added flexibility of being able to add and remove elements from both sides.
  
#### What is a randomized queue? 
A randomized queue is a data structure that stores a collection of items, much like a regular queue, but can randomly select and remove items from it.
You can imagine it as a bag of items where you can reach in and pull out an item at random. However, you don't get any guarantees about the order in which items are removed; it's entirely random.

#### About my solution? 
* An initial project is provided containing initial packages that can be used to solve the assignment, you can find it in the specifications.
* The Deque class contains my implementation of the deque data structure based on a doubly linked list.
* The doubly linked list made it possible for all the operations provided in the API to be performed in constant worst-case time.
* The RandomizedQueue class contains my implementation of the randomized queue based on a resizing array.
* Thanks to the resizing array my randomized queue implementation supports each randomized queue operation in constant amortized time with the exception of creating an iterator.
* Finally the Permutation class contains my solution for a problem provided in the specifications using the RandomizedQueue.
