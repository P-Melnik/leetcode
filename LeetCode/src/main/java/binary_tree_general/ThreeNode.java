package binary_tree_general;

public class ThreeNode {
    int val;
    ThreeNode right;
    ThreeNode left;

    ThreeNode() {}

    public ThreeNode(int val) {
        this.val = val;
    }

    public ThreeNode(int val, ThreeNode left, ThreeNode right) {
        this.val = val;
        this.right = right;
        this.left = left;
    }
}
