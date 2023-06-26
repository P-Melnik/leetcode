package binary_tree_general;

public class InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2,
                new TreeNode(1, null, null),
                new TreeNode(3, null, null));


    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.right);
        invertTree(root.left);

        return root;
    }

}
