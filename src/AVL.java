import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Math.max;

public class AVL<K extends Comparable<K>> implements Comparable<K> {

    private Node <K> root;


    public void insert(K key) {
        root = insert(key, root);
    }


    private Node<K> insert(K key, Node<K> node) {

        if (node == null){

            node = new Node<>(key, null, null);

        } else if (key.compareTo(node.getKey()) < 0) {

            node.setLeft(insert(key, node.getLeft()));

            if(height(node.getLeft()) - height(node.getRight()) == 2) {

                if (key.compareTo(node.getLeft().getKey()) < 0) {

                    node = rotateLeft(node);

                } else {
                    node = rotateLeft2(node);
                }
            }
        } else if (key.compareTo(node.getKey()) > 0) {


             node.setRight(insert(key, node.getRight()));

            if (height(node.getRight()) - height(node.getLeft()) == 2){

                if (key.compareTo(node.getRight().getKey()) > 0) node = rotateRight(node);
                else node = rotateRight2(node);
            }
        }

        node.setHeight(Math.max(height(node.getLeft()), height(node.getRight())) + 1);

        return node;

    }


    private Node<K> rotateLeft(Node<K> node) {

        Node<K> nodeAux = node.getLeft();

        node.setLeft(nodeAux.getRight());

        nodeAux.setRight(node);

        node.setHeight(max(height(node.getLeft()), height(node.getRight())) + 1);

        nodeAux.setHeight(max(height(nodeAux.getLeft()), node.getHeight()) + 1);

        return nodeAux;
    }

    private Node<K> rotateRight(Node<K> node) {

        Node<K> nodeAux = node.getRight();

        node.setRight(nodeAux.getLeft());

        nodeAux.setLeft(node);

        node.setHeight(max(height(node.getLeft()), height(node.getRight())) + 1);

        nodeAux.setHeight(max(height(nodeAux.getRight()), node.getHeight()) + 1);

        return nodeAux;
    }


    private Node<K> rotateLeft2(Node<K> node) {

        node.getLeft().setRight(rotateRight(node.getLeft().getRight()));

        return rotateLeft(node);
    }

    private Node<K> rotateRight2(Node<K> node) {

        node.getRight().setLeft(rotateLeft(node.getRight().getLeft()));

        return rotateRight(node);
    }

    private int height(Node<K> node) {

        if (node == null) {
            return -1;
        } else {
            return node.getHeight();
        }
    }
    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(Node<K> actualNode) {

        if (actualNode == null) return -1;
        else return 1 + max(getHeight(actualNode.getLeft()),getHeight(actualNode.getRight()));
    }

    @Override
    public int compareTo(K o) {
        return 0;
    }

    public String imprimirPorNiveles() {

        if (root == null) {
            return "";
        }

        Queue<Node<K>> queue = new LinkedList<>();
        queue.offer(root);

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node<K> node = queue.poll();
                sb.append(node.getKey()).append(" ");
                if (node.getLeft() != null) {
                    queue.offer(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.offer(node.getRight());
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
