
package com.ronok.algoexpert;

public class FindClosestValueInBst_Recursion {

    public static class BST {
        private int value;
        BST left;
        BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST addNode(int leftValue, int rightValue){

            BST leftChild = new BST(leftValue);
            this.left = leftChild;

            BST rightChild = new BST(rightValue);
            this.right = rightChild;

            return this;
        }

        public BST addNode(int leftValue){

            BST leftChild = new BST(leftValue);
            this.left = leftChild;

            return this;
        }
    }

    public static void main(String[] args){


        // constructing new Tree with all the Nodes

        BST root = new BST(10);
        root.addNode(5,15);
        root.left.addNode(2,5);
        root.left.left.addNode(1);

        root.right.addNode(13,22);
        root.right.left.addNode(0,14);

        /*
         * Expected Binary Tree after all node add
         *
         *                        10
         *                    /       \
         *                   5         15
         *                 /   \      /  \
         *                2     5    13  22
         *              /             \
         *             1              14
         * */

        System.out.println(findClosestValueInBst(root,12)); // Expected output: 13
        System.out.println(findClosestValueInBst(root,10)); // Expected output: 10
    }

    public static int findClosestValueInBst(BST tree, int target){

        // Setting currentRemaining = Math.abs( 10 - 12 ) = 02
        // setting closestNodeValue = root value          = 10

        return doFindClosestValueInBst(tree,target,Math.abs(target - tree.value),tree.value);
    }

    public static int doFindClosestValueInBst(BST tree, int target, int currentRemaining,int closestNodeValue){

        /*
        * Steps
        *   - Iterating through the BST Tree using recursion
        *   - we are starting the recursion with ( tree, targetValue, (rootNodeValue - targetValue), rootNodeValue)
        *
        *   - As it is a BST tree, we can use the property of BST tree to navigate the tree efficiently
        *       - In BST tree the left node value is smaller than the ROOT value and the right node value is greater than the root node value
        *
        *   - we are iterating through the node and reaching the leaf node
        *       - when reaching leaf node we are returning Zero
        *
        *   - when we are at the leaf node we are calculating,
        *       - currentRemaining
        *           - ( Last Closest node value - target value)
        *       - intermediateRemaining
        *           - ( current node value - target value )
        *
        *   - and, After each recursion call ends,we are returning the closestNodeValue to the previous call stack
        *       - so out closestNodeValue trace looks like 10 -> 0 -> 13 -> 13 -> 13
        *
        *
        *   - Explanation
        *       - when we are looking for target 12 we are iterating like :: 10 -> 15 -> 13 -> 0
        *           - and when we are at the last node (node `0`)
        *               - we are calculating, the currentRemaining & intermediateRemaining
        *
        *               - currentRemaining          = Math.abs( 0 - 12)
        *                   - currentRemaining      = 12
        *               - intermediateRemaining     = Math.abs(0-12)
        *                   - intermediateRemaining = 12
        *
        *               - and when the intermediateRemaining is `smaller or equal`, then we are updating the closestNodeValue and
        *               - Returning it to the previous call Stack
        *
        *
        * - Time complexity
        *   - in average case -> O(log (n)), because, on each recursion call we are eliminating half of the Tree
        *   - in worst case , when the tree is like below
        *   -   10
        *         \
        *          15
        *           \
        *            22
        *             \
        *              30
        *               \
        *                44
        *   - Time complexity becomes -> O(n), where n is the number of Nodes in the BST.
        *
        * - Space Complexity
        *   - in average case -> O(1), Though we are using recursion, we are just calculating currentRemaining & intermediateRemaining, and we are not using any space.
        *   - in worst case  --> O(1), space complexity remains the same.
        * */



        if(tree == null){
            return 0;
        }

        if(Math.abs(target) == tree.value){
            return tree.value;
        }
        else if(target < tree.value){
            closestNodeValue =  doFindClosestValueInBst(tree.left,target,currentRemaining,closestNodeValue);
        }
        else if(target > tree.value){
            closestNodeValue = doFindClosestValueInBst(tree.right,target,currentRemaining,closestNodeValue);
        }


        currentRemaining = Math.abs(closestNodeValue - target);
        int intermediateRemaining = Math.abs(tree.value - target);

        if(currentRemaining >= intermediateRemaining){
            closestNodeValue = tree.value;
        }

        return closestNodeValue;
    }
}