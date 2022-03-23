package com.ronok.algoexpert;

import java.util.ArrayList;
import java.util.List;

public class BranchSum {
    public static void main(String[] args){

        // constructing new Tree with all the Nodes

        BinaryTree root = new BinaryTree(1);
        root.addNode(2,3);
        root.left.addNode(4,5);
        root.left.right.addNode(10);
        root.left.left.addNode(8,9);
        root.right.addNode(6,7);

       /*
       * Expected Binary Tree after all node add
       *
       *                        1
       *                    /       \
       *                   2         3
       *                 /   \      /  \
       *                4     5     6   7
       *              /  \    /
       *             8    9  10
       * */

        // calling the branchSums function
        System.out.println(branchSums(root)); // Expected Output: [15, 16, 18, 10, 11]
    }


    public static class BinaryTree{
      private int value;
      BinaryTree left;
      BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }

        public BinaryTree addNode(int leftValue,int rightValue){

            BinaryTree leftChild = new BinaryTree(leftValue);
            this.left = leftChild;

            BinaryTree rightChild = new BinaryTree(rightValue);
            this.right = rightChild;

            return this;
        }

        public BinaryTree addNode(int leftValue){

            BinaryTree leftChild = new BinaryTree(leftValue);
            this.left = leftChild;

            return this;
        }
    }



    // MAIN Solution CODE

    public static List<Integer> branchSums(BinaryTree root){
        return doBrunchSum(root,0,new ArrayList<>());
    }

    public static List<Integer> doBrunchSum(BinaryTree root, int runningSum, ArrayList<Integer> sumList){

        /*
        * Steps
        *   - we will traverse the Tree in DFS order
        *   - we will do the In-order Traversal
        *       - why ?
        *           - because we need to go from the root of the node to the leaf of the node and
        *           - we need to go from left to right kind of way
        *               - we need to traverse 1 -> 2 -> 4 -> 8 and then
        *               - we need to traverse 1 -> 2 -> 4 -> 9 and then
        *               - we need to traverse 1 -> 2 -> 5 -> 10 and then
        *               - we need to traverse 1 -> 3 -> 6 and then
        *               - we need to traverse 1 -> 3 -> 7
        *           - so we are, visiting the root node first then left node then right node which is inOrder traversing in DFS
        *   - we need to check for leaf node and when found
        *       - we need to store the running Sum into a List
        *   - After all the traversing we need to return the list of Sum
        *
        *
        *   - Time Complexity  : O(n), where n is the number of nodes, and we are doing constant time operation in each node
        *   - Space Complexity : O(n)
        *       - Space Complexity explanation
        *           - in a binary tree we will have n nodes, and we can have maximum of n branch sum and that's why the space complexity is O(n)
        * */


        if(root == null)
            return sumList;

        runningSum = runningSum + root.value;
        doBrunchSum(root.left,runningSum,sumList);
        doBrunchSum(root.right,runningSum,sumList);

        if(checkLeaf(root)){
            sumList.add(runningSum);
        }
        return sumList;
    }

    public static boolean checkLeaf(BinaryTree leafNode){
        if(leafNode.left == null && leafNode.right == null)
            return true;

        return false;
    }
}
