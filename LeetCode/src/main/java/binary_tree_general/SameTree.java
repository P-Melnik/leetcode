package binary_tree_general;

public class SameTree {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1,
                new TreeNode(2, null, null),
                new TreeNode(3, null, null));

        TreeNode q = new TreeNode(1,
                new TreeNode(2, null, null),
                new TreeNode(3, null, null));

        System.out.println(isSameTree(p, q));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (q == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
