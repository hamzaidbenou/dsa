package utils;

public class TreeNode {
    public int data;
    public int height;
    public int pos;
    public TreeNode left;
    public TreeNode right;
    public TreeNode nextRight;
    
    public TreeNode(int data){
        this.data = data;
        this.height = 1;
    }
}
