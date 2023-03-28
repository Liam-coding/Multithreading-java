package threadSignal.dataStructure;

// A simple representation of a heap using an array
class Heap {
    // A class to store the heap properties
    static class HeapProperty {
        int capacity; // maximum size of the heap
        int size; // current size of the heap
        int[] items; // array to store the heap elements

        HeapProperty(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            this.items = new int[capacity];
        }
    }

    // A utility method to get the index of the parent of a given node
    static int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    // A utility method to get the index of the left child of a given node
    static int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    // A utility method to get the index of the right child of a given node
    static int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    // A utility method to check if a given node has a parent
    static boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    // A utility method to check if a given node has a left child
    static boolean hasLeftChild(int index, HeapProperty hp) {
        return getLeftChildIndex(index) < hp.size;
    }

    // A utility method to check if a given node has a right child
    static boolean hasRightChild(int index, HeapProperty hp) {
        return getRightChildIndex(index) < hp.size;
    }

    // A utility method to swap two elements in an array
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // A utility method to heapify up from a given node
    static void heapifyUp(HeapProperty hp) {
        // Start from the last inserted node and compare it with its parent
        int index = hp.size - 1;
        while (hasParent(index) && hp.items[getParentIndex(index)] > hp.items[index]) {
            // Swap the parent and the child if the parent is larger
            swap(hp.items, getParentIndex(index), index);
            // Update the index to the parent's index
            index = getParentIndex(index);
        }
    }

    // A utility method to heapify down from a given node
    static void heapifyDown(HeapProperty hp) {
        // Start from the root node and compare it with its children
        int index = 0;
        while (hasLeftChild(index, hp)) {
            // Find the smaller child among the left and right children
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index, hp) && hp.items[getRightChildIndex(index)] < hp.items[smallerChildIndex]) {
                smallerChildIndex = getRightChildIndex(index);
            }
            // Swap the parent and the smaller child if the parent is larger
            if (hp.items[index] > hp.items[smallerChildIndex]) {
                swap(hp.items, index, smallerChildIndex);
                // Update the index to the smaller child's index
                index = smallerChildIndex;
            } else {
                // Break the loop if the heap property is satisfied
                break;
            }
        }
    }

    // A method to insert a new element into the heap
    static void insert(HeapProperty hp, int item) {
        // Check if the heap is full or not
        if (hp.size == hp.capacity) {
            System.out.println("Heap is full");
            return;
        }
        // Add the new element at the end of the array
        hp.items[hp.size] = item;
        // Increment the size of the heap
        hp.size++;
        // Heapify up from the last inserted node
        heapifyUp(hp);
    }

    // A method to remove and return the minimum element from the heap
    static int removeMin(HeapProperty hp) {
        // Check if the heap is empty or not
        if (hp.size == 0) {
            System.out.println("Heap is empty");
            return -1;
        }
        // Store the root element in a variable
        int minItem = hp.items[0];
        // Replace the root element with the last element in the array
        hp.items[0] = hp.items[hp.size - 1];
        // Decrement the size of the heap
        hp.size--;
        // Heapify down from the root node
        heapifyDown(hp);
        // Return the minimum element
        return minItem;
    }

    // A method to print the heap elements
    static void printHeap(HeapProperty hp) {
        for (int i = 0; i < hp.size; i++) {
            System.out.print(hp.items[i] + " ");
        }
        System.out.println();
    }

    // A main method to test the heap operations
    public static void main(String[] args) {
        // Create a heap with a capacity of 10 elements
        HeapProperty hp = new HeapProperty(10);
        // Insert some elements into the heap
        insert(hp, 10);
        insert(hp, 15);
        insert(hp, 20);
        insert(hp, 17);
        insert(hp, 8);
        insert(hp, 25);
        insert(hp, 12);
        // Print the heap elements
        printHeap(hp);
        // Remove and print the minimum element from the heap
        System.out.println("The minimum element is: " + removeMin(hp));
        // Print the heap elements after removal
        printHeap(hp);
    }
}