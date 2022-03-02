package com.ronok.algoexpert;

public class RemoveDuplicatesFromLInkedList {

    //Make a linkedList Node Class
    public static class LinkedListNode {
        public int value;
        public LinkedListNode next;

        public LinkedListNode(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedListNode first;
    public static LinkedListNode last;

    // Adding node to the End of the LinkedList
    private static void addNodeToLast(int value){

        LinkedListNode newNode = new LinkedListNode(value);

        if(first == null){
            first = newNode;
        }
        else{
            last.next = newNode;
        }
        last = newNode;
    }

    public static void main(String[] args){

        // Adding Value to the LinkedList
        addNodeToLast(1);
        addNodeToLast(1);
        addNodeToLast(1);
        addNodeToLast(3);
        addNodeToLast(4);
        addNodeToLast(4);
        addNodeToLast(4);
        addNodeToLast(5);
        addNodeToLast(6);
        addNodeToLast(6);

        System.out.println(doRemoveDuplicates(first).toString()); // Expected output : 1 -> 3 -> 4 -> 5 -> 6
    }

    private static LinkedListNode doRemoveDuplicates(LinkedListNode node) {


        /*
        * When doing iteration in Linked List , we can use two pointer named current and previous
        * Time complexity  : O(n) where n is the number of nodes
        * Space complexity : O(1) because we are not using any additional space we are removing nodes in place
        * */

        LinkedListNode current = node;
        LinkedListNode previous = null;

        // Edge case: checking if the LinkedList only contain one element
        if(current.next == null){
            return node;
        }

        // start checking each an every Node
        while(current != null){


            // Checking if the previous is null and then setting the current and the previous pointer accordingly
            if(previous == null){
                previous = current;
                current = current.next;
            }

            // checking if the value matches for concurrent nodes
            if(previous.value == current.value){

                // checking the edge case where it is the End of the Linked List
               if(current.next != null){
                   current = current.next;
                   continue;
               }

               // in case of linkedList end, the previous node will point to the next node which will be NULL
               previous.next = current = null;
            }
            else{
                // value does not matches for concurrent nodes

                //so the previous node will point to the Current node
                previous.next = current;

                //set the previous and current again
                previous = current;
                current = current.next;
            }
        }
        return node;
    }
}
