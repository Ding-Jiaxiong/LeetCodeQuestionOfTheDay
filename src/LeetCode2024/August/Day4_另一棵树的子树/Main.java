package LeetCode2024.August.Day4_另一棵树的子树;

public class Main {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;

        return isSameTree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);  // 要么完全一样，要么左子树和子树一样，要么右子树和子树一样
    }

    // 判断两棵树是否完全一样
    public static boolean isSameTree(TreeNode tree1, TreeNode tree2) {

        if (tree1 == null && tree2 == null) return true;
        if (tree1 == null || tree2 == null) return false;

        return tree1.val == tree2.val && isSameTree(tree1.left, tree2.left) && isSameTree(tree1.right, tree2.right);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        TreeNode subRoot = new TreeNode(4);
        subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(2);

        System.out.println(isSubtree(root, subRoot));

    }
}
