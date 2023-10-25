import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    BinaryTreeNode(T data) {
        this.data = data;
    }
}

class BinaryTreeOperation {
    String Nodename = "root";
    Scanner sc = new Scanner(System.in);

    BinaryTreeNode<Integer> insert() {
        System.out.println("enter the element " + Nodename + " data or enter -1");
        int data = sc.nextInt();
        if (data == -1) {
            return null;
        }
        BinaryTreeNode<Integer> node = new BinaryTreeNode<>(data);
        Nodename = "left";
        node.left = insert();
        Nodename = "right";
        node.right = insert();
        Nodename = "root";
        return node;

    }

    void print(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        String result = "";
        result += root.data + "->";
        if (root.left != null) {
            result += "left" + root.left.data;
        }
        if (root.right != null) {
            result += "right" + root.right.data;
        }
        System.out.println(result);
        print(root.left);
        print(root.right);
    }

    void inorder(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }

    void preorder(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }

    void iterativeWayOfPreOrder(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryTreeNode<Integer> currentnode = stack.pop();
            System.out.println(currentnode.data + " ");

            if (currentnode.right != null) {
                stack.push(currentnode.right);
            }
            if (currentnode.left != null) {
                stack.push(currentnode.left);
            }
        }
        System.out.println();
    }

    void iterativeWayOfPreOrder2(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
        BinaryTreeNode<Integer> currentnode = root;
        while (currentnode != null || stack.isEmpty()) {
            while (currentnode != null) {
                System.out.println(currentnode.data + " ");
                if (currentnode.right != null) {
                    stack.push(currentnode.right);
                }
                currentnode = currentnode.left;
            }
            if (!stack.isEmpty()) {
                currentnode = stack.pop();
            }
        }
        System.out.println();
    }

    void iterativeInorder(BinaryTreeNode<Integer> root) {
        Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
        BinaryTreeNode<Integer> currentnode = root;
        while (currentnode != null || stack.isEmpty()) {
            while (currentnode != null) {
                stack.push(currentnode);
                currentnode = currentnode.left;
            }
            currentnode = stack.pop();
            System.out.println(currentnode.data + " ");
            currentnode = currentnode.right;
        }
    }

    void postorder(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.data);
    }

    void levelOrder(BinaryTreeNode<Integer> root) {
        LinkedList<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // Remove the first element from the queue
            BinaryTreeNode<Integer> node = queue.removeFirst();
            System.out.print(node.data + " ");
            // Put parent Left and Right in a Queue
            if (node.left != null) {
                queue.addLast(node.left);
            }
            if (node.right != null) {
                queue.addLast(node.right);
            }
        }
    }

    int height(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int leftheight = height(root.left);
        int rightheight = height(root.right);
        int val = Math.max(leftheight, rightheight);
        return val + 1;
    }

    int sizeofBinarytree(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int counter = 1;
        counter += sizeofBinarytree(root.left);
        counter += sizeofBinarytree(root.right);
        return counter;
    }

    void levelOrder2(BinaryTreeNode<Integer> root) {
        LinkedList<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // Remove the first element from the queue
            int countQueue = queue.size();
            for (int i = 0; i < countQueue; i++) {
                BinaryTreeNode<Integer> currentNode = queue.poll();
                System.out.print(currentNode.data + " ");
                if (currentNode.left != null) {
                    queue.addLast(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.addLast(currentNode.right);
                }

            }
            System.out.println();
        }
    }

}

class BinaryTree {
    public static void main(String[] args) {
        BinaryTreeOperation opr = new BinaryTreeOperation();
        Scanner scanner = new Scanner(System.in);
        BinaryTreeNode<Integer> root = null;
        while (true) {
            System.out.println("Binary Tree Operations ");
            System.out.println("1. Insert");
            System.out.println("2. Print");
            System.out.println("3. Exit");
            System.out.println("Enter the Choice");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    root = opr.insert();
                    break;
                case 2:
                    opr.levelOrder2(root);
                    break;
                case 3:
                    return;
            }

        }

    }
}
