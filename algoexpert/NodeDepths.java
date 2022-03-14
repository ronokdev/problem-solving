package com.ronok.algoexpert;

public class NodeDepths {
   public static void main(String[] args) {

       BinaryTree root = new BinaryTree(1);
       root.left = new BinaryTree(2);
       root.left.left = new BinaryTree(4);
       root.left.left.left = new BinaryTree(8);
       root.left.left.right = new BinaryTree(9);
       root.left.right = new BinaryTree(5);
       root.right = new BinaryTree(3);
       root.right.left = new BinaryTree(6);
       root.right.right = new BinaryTree(7);

       System.out.println(nodeDepths(root));
   }

    private static int nodeDepths(BinaryTree root) {

       int depth = -1;
       return doCalculateDepth(root,depth); //  Expected output : 16

    }

    private static int doCalculateDepth(BinaryTree root,int depth) {

       /*
       * Tree
       *                     1            (depth = 0)
                        /        \
                        2          3      (depth = 1)
                     /     \      / \
                    4       5    6    7   (depth = 2)
                  /   \    / \  / \  / \
                 8     9   0  0 0 0  0 0  (depth = 3)
                / \   / \
               0   0  0  0
               *
               *
               * Steps
               *    - we need to calculate the (current depth of the current node + sum of left sub Tree + sum of Right sub Tree)
               *
               * Explanation
               *    - for node ` 8 `
               *        - the current depth is                  = 3
               *        - the depth sum of left subtree is      = 0
               *        - the depth sum of Right subtree is     = 0
               *        - so the calculation on node `8` is (3+0+0) = 3
               *
               *    - for node ` 9 `
               *        - the current depth is                   = 3
               *        - the depth sum of left subtree is       = 0
               *        - the depth sum of Right subtree is      = 0
               *        - so the calculation on node `9` is (3+0+0) = 3
               *
               *    - for node ` 4 `
               *        - the current depth is                   = 2
               *        - the depth sum of left subtree is       = 3
               *        - the depth sum of Right subtree is      = 3
               *        - so the calculation on node `4` is (2+3+3) = 8
               *
               *     - for node ` 5 `
               *        - the current depth is                   = 2
               *        - the depth sum of left subtree is       = 0
               *        - the depth sum of Right subtree is      = 0
               *        - so the calculation on node `4` is (2+0+0) = 2
               *
               *    - for node ` 2 `
               *        - the current depth is                   = 1
               *        - the depth sum of left subtree is       = 8
               *        - the depth sum of Right subtree is      = 2
               *        - so the calculation on node `2` is (1+8+2) = 11
               *
               *    - so the total depth sum of left subtree(Node ` 8 9 4 5 2 `) is 11
               *    - and if we calculate the depth sum of left subtree (Node ` 6 7 3`) is 5
               *    - so the total depth sum is 16
               *
               *    - Time Complexity  : O(n), where n is the number of Nodes
               *    - space complexity : O(h), where h is the height of Nodes
               *
       * */


       BinaryTree current = root;

       if(current == null){
           return 0;
       }

       depth++;

//     System.out.println(current.value+"__"+depth);

       int leftDepth  = doCalculateDepth(current.left,depth);
       int rightDepth = doCalculateDepth(current.right,depth);

       return depth + leftDepth + rightDepth;
    }


    // Binary Tree Class
    public static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
}
