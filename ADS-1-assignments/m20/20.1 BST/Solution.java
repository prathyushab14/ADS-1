import java.util.Iterator;
import java.util.Scanner;
/**
 * Class for binary search tree.
 * @param      <Key>     The key
 * @param      <Value>  The values
 */
class BinarySearchTree<Key extends Comparable<Key>, Value> {
    /**.
     * starting element in the BST.
     */
    private Node root;
    /**.
     * Class for node.
     */
    class Node {
        /**.
         * Object of Book class with book details.
         */
        private Key key;
        /**.
         * value of the book in Book class
         */
        private Value value;
        /**.
         * Left and Right node of the BST
         */
        private Node left, right;
        /**
         * size.
         */
        private int size;
        /**
         * Constructs the object.
         * @param      k     key.
         * @param      v     value.
         * @param      s     size.
         */
        Node(final Key k, final Value v, final int s) {
            key = k;
            value = v;
            size = s;
        }
    }
    /**
     * Determines if empty.
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return size() == 0;
    }
    /**
     * size method that returns the size.
     * @return     size of type int.
     */
    public int size() {
        return size(root);
    }
    /**
     * size method that returns the size.
     * @param      x     Node.
     * @return     size of type int.
     */
    private int size(final Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.size;
        }
    }
    /**.
     * This method is to add a key and value to BST.
     * Time Complexity is O(N).
     * because it calls another put method to add elements.
     *
     * @param      key    The key
     * @param      value  The value
     */
    public void put(final Key key, final Value value) {
        if (key == null) {
            return;
        }
        root = put(root, key, value);
    }
    /**.
     * This method is to add element to BST
     * Time Complexity is O(N) for worst case.
     * element is added until it reaches to the
     * position it should added at.
     *
     * @param      node   The node
     * @param      key    The key
     * @param      value  The value
     *
     * @return     returns node
     */
    public Node put(final Node node, final Key key,
                    final Value value) {
        if (node == null) {
            return new Node(key, value, 1);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }
        return node;
    }
    /**.
     * This method is to return the value of that key
     * Time Complexity is O(N)
     *
     * @param      key   The key
     *
     * @return     returns the value.
     */
    public Value get(final Key key) {
        return get(root, key);
    }
    /**.
     * This method is to return the value of that key
     * Time Complexity is O(N)
     *
     * @param      node  the node where the book details and
     *                   values.
     * @param      key   The key
     *
     * @return     returns the value of that key.
     */
    private Value get(final Node node, final Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return get(node.left, key);
        } else if (cmp > 0) {
            return get(node.right, key);
        } else {
            return node.value;
        }
    }
    /**
     * min method that returns the minimum node.
     * @return     Key of type Book.
     */
    public Key min() {
        return min(root).key;
    }
    /**
     * min method that returns the minimum node.
     * @param      x     Node.
     * @return     Node.
     */
    private Node min(final Node x) {
        if (x.left == null) {
            return x;
        } else {
            return min(x.left);
        }
    }
    /**
     * max method that returns the maximum node.
     * @return     Key of type Book.
     */
    public Key max() {
        return max(root).key;
    }
    /**
     * min method that returns the minimum node.
     * @param      x     Node.
     * @return     Node.
     */
    private Node max(final Node x) {
        if (x.right == null) {
            return x;
        } else {
            return max(x.right);
        }
    }
    /**
     * floor method that returns the node less
     * than given node.
     * @param      key   The key
     * @return     Key of type Book.
     */
    public Key floor(final Key key) {
        Node x = floor(root, key);
        if (x == null) {
            return null;
        } else {
            return x.key;
        }
    }
    /**
     * floor method that returns the node less
     * than given node.
     * @param      x     Node.
     * @param      key   The key
     * @return     Node.
     */
    private Node floor(final Node x, final Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        }
        if (cmp < 0) {
            return floor(x.left, key);
        }
        Node t = floor(x.right, key);
        if (t != null) {
            return t;
        } else {
            return x;
        }
    }
    /**
     * ceiling method that returns the node greater
     * than given node.
     * @param      key   The key
     * @return     Key of type Book.
     */
    public Key ceiling(final Key key) {
        Node x = ceiling(root, key);
        if (x == null) {
            return null;
        } else {
            return x.key;
        }
    }
    /**
     * ceiling method that returns the node greater
     * than given node.
     * @param      x     Node.
     * @param      key   The key
     * @return     Node.
     */
    private Node ceiling(final Node x, final Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        }
        if (cmp < 0) {
            Node t = ceiling(x.left, key);
            if (t != null) {
                return t;
            } else {
                return x;
            }
        }
        return ceiling(x.right, key);
    }
    /**
     * select method that returns the node at particular index.
     * @param      k     index.
     * @return     Key of type Book.
     */
    public Key select(final int k) {
        Node x = select(root, k);
        return x.key;
    }
    /**
     * select method that returns the node at particular index.
     * @param      x     Node.
     * @param      k     index.
     * @return     Node.
     */
    private Node select(final Node x, final int k) {
        if (x == null) {
            return null;
        }
        int t = size(x.left);
        if (t > k) {
            return select(x.left, k);
        } else if (t < k) {
            return select(x.right, k - t - 1);
        } else {
            return x;
        }
    }
    /**
     * rank method that returns the number of nodes less than
     * given node.
     * @param      key   The key
     * @return     rank of type int.
     */
    public int rank(final Key key) {
        return rank(key, root);
    }
    /**
     * rank method that returns the number of nodes less than
     * given node.
     * @param      key   The key
     * @param      x     Node.
     * @return     rank of type int.
     */
    private int rank(final Key key, final Node x) {
        if (x == null) {
            return 0;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return rank(key, x.left);
        } else if (cmp > 0) {
            return 1 + size(x.left) + rank(key, x.right);
        }
        return size(x.left);
    }
    /**
     * keys method that prints the nodes.
     * @return     Iterable type.
     */
    public Iterable<Key> keys() {
        if (isEmpty()) {
            return new Queue<Key>();
        }
        return keys(min(), max());
    }
    /**
     * keys method that prints the nodes.
     * @param      lo    The lower
     * @param      hi    The higher
     * @return     Iterable type.
     */
    public Iterable<Key> keys(final Key lo, final Key hi) {
        Queue<Key> queue = new Queue<Key>();
        keys(root, queue, lo, hi);
        return queue;
    }
    /**
     * keys method that prints the node.
     * @param      x      Node.
     * @param      queue  The queue
     * @param      lo     The lower
     * @param      hi     The higher
     */
    private void keys(final Node x, final Queue<Key> queue,
        final Key lo, final Key hi) {
        if (x == null) {
            return;
        }
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0) {
            keys(x.left, queue, lo, hi);
        }
        if (cmplo <= 0 && cmphi >= 0) {
            queue.enqueue(x.key);
        }
        if (cmphi > 0) {
            keys(x.right, queue, lo, hi);
        }
    }
}
/**
 * Class for book.
 */
class Book implements Comparable<Book> {
    /**
     * name of the book.
     */
    private String name;
    /**
     * author of the book.
     */
    private String author;
    /**
     * price of the book.
     */
    private double price;
    /**
     * Constructs the object.
     * @param      n     name.
     * @param      a     author.
     * @param      p     price.
     */
    Book(final String n, final String a,
        final double p) {
        name = n;
        author = a;
        price = p;
    }
    /**
     * Gets the name.
     * @return     The name.
     */
    String getName() {
        return name;
    }
    /**
     * Gets the author.
     * @return     The author.
     */
    String getAuthor() {
        return author;
    }
    /**
     * Gets the price.
     * @return     The price.
     */
    double getPrice() {
        return price;
    }
    /**
     * compareTo method.
     * @param      b     b of type Book.
     * @return     integer.
     */
    public int compareTo(final Book b) {
        return getName().compareTo(b.getName());
    }
}
/**
 * Queue class.
 * @param      <Item>  The item
 */
class Queue<Item> implements Iterable<Item> {
    /**
     * first of type Node.
     */
    private Node<Item> first;
    /**
     * second of type Node.
     */
    private Node<Item> last;
    /**
     * size.
     */
    private int n;
    /**
     * Class for node.
     * @param      <Item>  The item
     */
    private static class Node<Item> {
        /**
         * item of type Item.
         */
        private Item item;
        /**
         * next of type Node.
         */
        private Node<Item> next;
    }
    /**
     * Initializes an empty queue.
     */
    public Queue() {
        first = null;
        last  = null;
        n = 0;
    }
    /**
     * Returns true if this queue is empty.
     * @return {@code true} if this queue is empty; {@code false} otherwise
     */
    public boolean isEmpty() {
        return first == null;
    }
    /**
     * Returns the number of items in this queue.
     * @return the number of items in this queue
     */
    public int size() {
        return n;
    }
    /**
     * Adds the item to this queue.
     * @param  item the item to add
     */
    public void enqueue(final Item item) {
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldlast.next = last;
        }
        n++;
    }
    /**
     * iterator method.
     * @return     Iterator.
     */
    public Iterator<Item> iterator()  {
        return new ListIterator<Item>(first);
    }
    /**
     * Class for list iterator.
     * @param      <Item>  The item
     */
    private class ListIterator<Item> implements Iterator<Item> {
        /**
         * current of type Node.
         */
        private Node<Item> current;
        /**
         * Constructs the object.
         * @param      f  The first
         */
        ListIterator(final Node<Item> f) {
            current = f;
        }
        /**
         * Determines if it has next.
         * @return     True if has next, False otherwise.
         */
        public boolean hasNext() {
            return current != null;
        }
        /**
         * next method that returns the elements.
         *
         * @return     item.
         */
        public Item next() {
            if (!hasNext()) {
                return null;
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * main method that drives the program.
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        BinarySearchTree<Book, Integer> bst = new BinarySearchTree();
        while (sc.hasNext()) {
            String[] tokens = sc.nextLine().split(",");
            switch (tokens[0]) {
            case "put":
                Book key = new Book(tokens[1],
                    tokens[2], Double.parseDouble(tokens[2 + 1]));
                int value = Integer.parseInt(tokens[2 + 2]);
                bst.put(key, value);
                break;
            case "get":
                key = new Book(tokens[1],
                               tokens[2], Double.parseDouble(tokens[2 + 1]));
                System.out.println(bst.get(key));
                break;
            case "max":
                Book b = bst.max();
                System.out.println(b.getName() + ", "
                    + b.getAuthor() + ", " + b.getPrice());
                break;
            case "min":
                b = bst.min();
                System.out.println(b.getName() + ", "
                    + b.getAuthor() + ", " + b.getPrice());
                break;
            case "select":
                b = bst.select(Integer.parseInt(tokens[1]));
                System.out.println(b.getName() + ", "
                    + b.getAuthor() + ", " + b.getPrice());
                break;
            case "floor":
                b = bst.floor(new Book(tokens[1],
                          tokens[2], Double.parseDouble(tokens[2 + 1])));
                System.out.println(b.getName() + ", "
                    + b.getAuthor() + ", " + b.getPrice());
                break;
            case "ceiling":
                b = bst.ceiling(new Book(tokens[1],
                          tokens[2], Double.parseDouble(tokens[2 + 1])));
                System.out.println(b.getName() + ", "
                    + b.getAuthor() + ", " + b.getPrice());
                break;
            default:
                break;
            }
        }
    }
}
