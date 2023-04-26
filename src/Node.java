public class Node <K extends Comparable<K>> implements Comparable<K> {
    private K key;
    private Node<K> left;
    private Node<K> right;
    private int height;

    public Node( K key, Node<K> left, Node<K> right){
        this.key = key;
        this.left = left;
        this.right = right;
        height   = 0;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public Node<K> getLeft() {
        return left;
    }

    public void setLeft(Node<K> left) {
        this.left = left;
    }

    public Node<K> getRight() {
        return right;
    }

    public void setRight(Node<K> right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int compareTo(K o) {
        return 0;
    }
}

