package binary_tree_general;

public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        ThreeNode root = new ThreeNode(3,
                new ThreeNode(9, null, null),
                new ThreeNode(20,
                        new ThreeNode(15, null, null),
                        new ThreeNode(7, null, null)));

        System.out.println(maxDepth(root));
    }

    public static int maxDepth(ThreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }
    }
}
