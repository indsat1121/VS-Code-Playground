public class RecursionBasics {

    // Factorial of n: n! = n * (n-1) * ... * 1
    // Time: O(n), Space: O(n) due to recursive call stack.
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    // Fibonacci using recursion:
    // F(0)=0, F(1)=1, F(n)=F(n-1)+F(n-2)
    // Time: O(2^n), Space: O(n).
    public static int fibonacciRecursive(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative");
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Optimized Fibonacci with iteration.
    // Time: O(n), Space: O(1).
    public static int fibonacciIterative(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative");
        }
        if (n <= 1) {
            return n;
        }
        int prev = 0;
        int curr = 1;
        for (int i = 2; i <= n; i++) {
            int next = prev + curr;
            prev = curr;
            curr = next;
        }
        return curr;
    }

    // Tree-style recursion thinking:
    // At each node, solve the same subproblem on left and right.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Returns total nodes in a binary tree.
    // Time: O(n), Space: O(h), where h is tree height.
    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // Returns height in nodes (empty tree => 0).
    // Time: O(n), Space: O(h).
    public static int treeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(treeHeight(root.left), treeHeight(root.right));
    }

    private static TreeNode sampleTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        return root;
    }

    public static void main(String[] args) {
        System.out.println("factorial(5) = " + factorial(5));
        System.out.println("fibonacciRecursive(7) = " + fibonacciRecursive(7));
        System.out.println("fibonacciIterative(7) = " + fibonacciIterative(7));

        TreeNode root = sampleTree();
        System.out.println("countNodes(tree) = " + countNodes(root));
        System.out.println("treeHeight(tree) = " + treeHeight(root));
    }
}
