package com.ronok.algoexpert;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {
    public static void main(String[] args){

        Node root = new Node("A");

        root.addChildren("B");
        root.addChildren("C");
        root.addChildren("D");

        root.children.get(0).addChildren("E");
        root.children.get(0).addChildren("F");
        root.children.get(0).children.get(1).addChildren("I");
        root.children.get(0).children.get(1).addChildren("J");

        root.children.get(2).addChildren("G");
        root.children.get(2).addChildren("H");

        root.children.get(2).children.get(0).addChildren("K");


        List<String> finalArray = new ArrayList<>();

        root.dfs(finalArray);           // Expected Output: [A, B, E, F, I, J, C, D, G, K, H]
        System.out.println(finalArray);
    }



    //Node class
    static class Node {

       private String name;
       private List<Node> children = new ArrayList<>();

        public Node(String name) {
            this.name = name;
        }

        public Node addChildren(String name){

            Node childNode = new Node(name);
            children.add(childNode);

            return this;
        }

        /*
        * Graph
        *                  A
        *             /    |    \
        *             B    C     D
        *           /  \       /   \
        *          E   F      G     H
        *             / \      \
        *            I   J      K
        *
        *  STEPS
        *   - For every node we are going to add the node name to the finalArray and
        *   - For every Child node of that node we are going to call the dfs function
        *   - and pass the finalArray
        *
        *  STEPS Explanation
        *   - in the below code `this` contains the root of the array
        *   - At first we are at the root of the Tree (node ` A `)
        *   - we are adding the node ` A ` to the finalArray and then
        *   - calling the dfs function to the Children of the ` A ` node (node `B C D`)
        *   - Then, we are at node ` B ` so,
        *   - we add ` B ` to the finalArray and
        *   - we are going to call the dfs function to the children of the node ` B ` (node ` E F `)
        *   - Then we are at the node ` E ` so
        *   - we are adding node ` E ` to the finalArray and
        *   - we are going to call the dfs function to the children of the node ` E ` (There is No Children of Node ` E `)
        *   - So, our code moves to ` F `
        *   - adds node ` F ` to the finalArray and
        *   - calls the dfs function to the children of the node ` F ` (Node ` I J `)
        *   - and it Continues
        *
        *   - Time Complexity : O(v+e), where v(vertices) is the number of Nodes and, e(edge) is the number of Children of that nodes
        *       - Explanation
        *           - Time complexity is O(v+e) because
        *               - we are traversing each and every node's and for each node we are calling the dfs function
        *               - and the length of the for loop in the dfs function will be the number of children(e) of the node(v)
        *               - that's why the time complexity is O(v+e)
        *
        *   - Space Complexity : O(v)
        *       - Explanation
        *           - we are storing the node name in an array and the length of the array will be the number of Nodes(v) also,
        *           - when traversing we are adding `FRAME` and the maximum frame number will be the number of Nodes(v)
        * */


        private List<String> dfs(List<String> finalArray) {

            // Adding the node name to the finalArray
            finalArray.add(this.name);

            for(int i=0; i< this.children.size(); i++) {

                // Calling dfs function at the Child Nodes of the current Node
                this.children.get(i).dfs(finalArray);
            }
            return finalArray;
        }
    }
}
