package binary_tree_general;

public class InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2,
                new TreeNode(1, null, null),
                new TreeNode(3, null, null));


    }

////    public static TreeNode invertTree(TreeNode root) {
////        while (root.left != null || root.right != null) {
////            swap(root);
////            root =
////        }
//
//    }

    public static void swap(TreeNode root) {
        int temp;
        temp = root.left.val;
        root.left.val = root.right.val;
        root.right.val = temp;
    }
}
