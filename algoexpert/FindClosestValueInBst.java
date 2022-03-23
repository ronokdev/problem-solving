
package com.ronok.algoexpert;

import com.sun.org.apache.bcel.internal.generic.ARETURN;

public class FindClosestValueInBst {

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
        root.right.left.addNode(14);

        System.out.println(findClosestValueInBst(root,12));

    }

    public static int findClosestValueInBst(BST tree, int target){
        return doFindClosestValueInBst(tree,target,Math.abs(tree.value - target),tree.value);
    }

    public static int doFindClosestValueInBst(BST tree, int target, int currentRemaining,int currentTartgetValue){

        /*
        * STEPS
        *   - Iterate via inOrder DFS (left, root, right)
        *   - do subtraction on each node with the target and
        *   - keep track of the currentRemaining
        *   - we will change the currentRemaining if and only if we get a currentRemaining which is smaller
        * */

        BST current = tree;

        while(current != null){

//            int res = Math.abs(Math.min(currentRemaining, Math.abs(target - current.value)));
//            if(res < currentRemaining){
//                currentTartgetValue = current.value;
//            }

            if(target >= current.value){
                System.out.println(current.value);
                current = current.right;
            }
            else{
                System.out.println(current.value);
                current = current.left;
            }
        }
        return currentTartgetValue;
    }
}