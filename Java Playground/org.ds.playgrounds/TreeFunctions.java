import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeFunctions {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    // Preorder traversal (Root, Left, Right)
    // Time: O(n), Space: O(h)
    public static void printPreorder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }

    // Inorder traversal (Left, Root, Right)
    // Time: O(n), Space: O(h)
    public static void printInorder(TreeNode root) {
        if (root == null) {
            return;
        }
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    // Postorder traversal (Left, Right, Root)
    // Time: O(n), Space: O(h)
    public static void printPostorder(TreeNode root) {
        if (root == null) {
            return;
        }
        printPostorder(root.left);
        printPostorder(root.right);
        System.out.print(root.data + " ");
    }

    // Level order traversal (BFS)
    // Time: O(n), Space: O(w) where w is max level width
    public static void printLevelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.data + " ");
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    // Count total nodes
    // Time: O(n), Space: O(h)
    public static int size(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + size(root.left) + size(root.right);
    }

    // Height in nodes (empty tree => 0)
    // Time: O(n), Space: O(h)
    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    // Count leaf nodes
    // Time: O(n), Space: O(h)
    public static int countLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return countLeaves(root.left) + countLeaves(root.right);
    }

    // Search value in tree
    // Time: O(n), Space: O(h)
    public static boolean contains(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        if (root.data == target) {
            return true;
        }
        return contains(root.left, target) || contains(root.right, target);
    }

    // Interview: Validate BST
    // Time: O(n), Space: O(h)
    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isValidBST(TreeNode node, long low, long high) {
        if (node == null) {
            return true;
        }
        if (node.data <= low || node.data >= high) {
            return false;
        }
        return isValidBST(node.left, low, node.data) && isValidBST(node.right, node.data, high);
    }

    // Interview: Balanced binary tree
    // Time: O(n), Space: O(h)
    public static boolean isBalanced(TreeNode root) {
        return balancedHeight(root) != -1;
    }

    private static int balancedHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = balancedHeight(node.left);
        if (left == -1) {
            return -1;
        }
        int right = balancedHeight(node.right);
        if (right == -1) {
            return -1;
        }
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return 1 + Math.max(left, right);
    }

    // Interview: Lowest common ancestor in a binary tree
    // Time: O(n), Space: O(h)
    public static TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        if (root == null || root.data == p || root.data == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }

    // Interview: Diameter of binary tree (in edges)
    // Time: O(n), Space: O(h)
    public static int diameter(TreeNode root) {
        int[] best = new int[1];
        diameterHeight(root, best);
        return best[0];
    }

    private static int diameterHeight(TreeNode node, int[] best) {
        if (node == null) {
            return 0;
        }
        int left = diameterHeight(node.left, best);
        int right = diameterHeight(node.right, best);
        best[0] = Math.max(best[0], left + right);
        return 1 + Math.max(left, right);
    }

    // Interview: Invert/mirror binary tree
    // Time: O(n), Space: O(h)
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    // Interview: Right side view
    // Time: O(n), Space: O(w)
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (i == levelSize - 1) {
                    result.add(node.data);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return result;
    }

    private static TreeNode buildSampleTree() {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(4);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(14);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = buildSampleTree();

        System.out.print("Preorder: ");
        printPreorder(root);
        System.out.println();

        System.out.print("Inorder: ");
        printInorder(root);
        System.out.println();

        System.out.print("Postorder: ");
        printPostorder(root);
        System.out.println();

        System.out.print("Level order: ");
        printLevelOrder(root);
        System.out.println();

        System.out.println("Size: " + size(root));
        System.out.println("Height: " + height(root));
        System.out.println("Leaf count: " + countLeaves(root));
        System.out.println("Contains 10? " + contains(root, 10));
        System.out.println("Is valid BST? " + isValidBST(root));
        System.out.println("Is balanced? " + isBalanced(root));
        System.out.println("Diameter (edges): " + diameter(root));
        System.out.println("Right side view: " + rightSideView(root));

        TreeNode lca = lowestCommonAncestor(root, 2, 6);
        System.out.println("LCA(2, 6): " + (lca != null ? lca.data : "not found"));

        invertTree(root);
        System.out.print("Level order after invert: ");
        printLevelOrder(root);
        System.out.println();
    }
}
