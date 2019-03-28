package com.lishuangqi;

/**
 * Created by michael on 2019/3/22.
 */
public class MyBinSearchTree<E extends Comparable<E>> {
    private TreeNode<E> root;

    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<E>(e);
    }

    public boolean insert(E e) {
        if (root == null) {
            root = createNewNode(e);
        } else {
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null) {
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else {
                    return false;
                }
            }

            if (e.compareTo(parent.element) < 0) {
                parent.left = createNewNode(e);
            } else {
                parent.right = createNewNode(e);
            }
        }
        return true;
    }

    // 二叉查找树的搜索
    public boolean search(E e) {

        TreeNode<E> current = root;

        while (current != null) {

            if (e.compareTo(current.element) < 0) {
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                current = current.right;
            } else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        MyBinSearchTree<Integer> tree = new MyBinSearchTree<>();
        tree.insert(63);
        tree.insert(90);
        tree.insert(70);
        tree.insert(55);
        tree.insert(67);
        tree.insert(42);
        tree.insert(98);
        tree.insert(83);
        System.out.println("pre:");
        System.out.println("");
        tree.root.preorder(tree.root);
        System.out.println("in:");
        System.out.println("");
        tree.root.inorder(tree.root);
        System.out.println("post:");
        System.out.println("");
        tree.root.postorder(tree.root);
    }
}
