package tree;

import utils.TreeNode;

class Solotion {

    /**
     * Given an AVL tree and N values to be deleted from the tree. Write a function to delete a given value from the tree.
     * All the N values which needs to be deleted are passed one by one as input data by driver code itself, you are asked 
     * to return the root of modified tree after deleting the value.
     * @param root
     * @param key
     * @return
     */
    public static TreeNode deleteNode(TreeNode root, int key){
        if(root == null) return root;
        
        if(key < root.data) root.left = deleteNode(root.left, key);
        else {
            if(key > root.data) root.right = deleteNode(root.right, key);
            else {
                if(root.right != null){
                    TreeNode tmp = getMinValue(root.right);
                    root.data = tmp.data;
                    root.right = deleteNode(root.right, tmp.data);
                } else {
                    if(root.left != null) root = root.left;
                    else root = null;
                }
            }
        }
        
        if(root == null) return root;
        
        root.height = Math.max(height(root.left), height(root.right)) + 1;
        int balance = getBalance(root);
        
        // Left Left Case
        if (balance > 1 && getBalance(root.left) >= 0) return rightRotate(root);
 
        // Left Right Case
        if (balance > 1 && getBalance(root.left) < 0){
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
 
        // Right Right Case
        if (balance < -1 && getBalance(root.right) <= 0) return leftRotate(root);
 
        // Right Left Case
        if (balance < -1 && getBalance(root.right) > 0){
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        
        return root;
    }
    
    public static TreeNode getMinValue(TreeNode node){
        TreeNode current = node;
        while(current.left != null) current = current.left;
        return current;
    }
    
    public static int height(TreeNode root){
        if(root == null) return 0;
        return root.height;
    }
    
    public static int getBalance(TreeNode root){
        if(root == null) return 0;
        return height(root.left) - height(root.right);
    }
    
    public static TreeNode leftRotate(TreeNode x){
        TreeNode y = x.right;
        TreeNode T2 = y.left;
 
        // Perform rotation
        y.left = x;
        x.right = T2;
 
        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
 
        // Return new root
        return y;
    }
    
    public static TreeNode rightRotate(TreeNode y){
        TreeNode x = y.left;
        TreeNode T2 = x.right;
 
        // Perform rotation
        x.right = y;
        y.left = T2;
 
        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
 
        // Return new root
        return x;
    }
}
