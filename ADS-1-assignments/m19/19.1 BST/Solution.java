import java.util.Scanner;
/**
 * Class for book.
 */
class Book implements Comparable<Book> {
    /**
     * book name.
     */
    private String name;
    /**
     * author name.
     */
    private String author;
    /**
     * price of the book.
     */
    private double price;
    /**
     * Constructs the object.
     */
    Book() {
    }
    /**
     * Constructs the object.
     *
     * @param      n    The name
     * @param      au  The author
     * @param      pr   The price
     */
    Book(final String n, final String au, final double pr) {
        this.name = n;
        this.author = au;
        this.price = pr;
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return name;
    }
    /**
     * Gets the author.
     *
     * @return     The author.
     */
    public String getAuthor() {
        return author;
    }
    /**
     * Gets the price.
     *
     * @return     The price.
     */
    public double getPrice() {
        return price;
    }
    /**
     * Method to compare.
     *
     * @param      that  The that
     *
     * @return     integer value +1,-1,0
     */
    public int compareTo(final Book that) {
        return this.name.compareTo(that.name);
    }
    public String toString() {
    	return getName() + ", " +getAuthor() + ", " + getPrice();
    }
}
/**
 * Class for node.
 *
 */
class Node {
    /**
     * Book object.
     */
    private Book key;
    /**
     * value.
     */
    private String value;
    /**
     * left node, right node.
     */
    private Node left, right;
    /**
     * Constructs the object.
     *
     * @param      k    The key
     * @param      val  The value
     */
    private int count;
    Node(final Book k, final String val, final int c) {
        this.key = k;
        this.value = val;
        this.count = count;
    }
    /**
     * Gets the key.
     *
     * @return     The key.
     */
    public Book getKey() {
        return key;
    }
    /**
     * Gets the value.
     *
     * @return     The value.
     */
    public String getValue() {
        return value;
    }
    /**
     * Gets the left.
     *
     * @return     The left.
     */
    public Node getLeft() {
        return left;
    }
    /**
     * Gets the right.
     *
     * @return     The right.
     */
    public Node getRight() {
        return right;
    }
    public int getCount() {
        return count;
    }
    /**
     * Sets the left.
     *
     * @param      l  The left
     */
    public void setLeft(final Node l) {
        this.left = l;
    }
    /**
     * Sets the right.
     *
     * @param      r  The right
     */
    public void setRight(final Node r) {
        this.right = r;
    }
    /**
     * Sets the value.
     *
     * @param      val   The value
     */
    public void setValue(final String val) {
        this.value = val;
    }
    public void setCount(final int c) {
        this.count = c;
    }
    // public String toString() {
    // 	return key.toString();
    // }
}
/**
 * Class for binary st.
 *
 */
class BinaryST {
    /**
     * Rot node.
     */
    private Node root;
    /**
     * Constructs the object.
     */
    BinaryST() {
    }
    public boolean isEmpty() {
        return count() == 0;
    }
    public int count() {
        return count(root);
    }
    private int count(final Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.getCount();
        }
    }
    public boolean contains(final Book key) {
        return get(key) != null;
    }
    /**
     * Method to insert the key.
     * Time complexity is O(1).
     * @param      key    The key
     * @param      value  The value
     */
    public void put(final Book key, final String value) {
        root = put(root, key, value);
    }
    /**
     * Method to insert the keys.
     * Time complexity is O(N) in worst case.
     * @param      x      The node.
     * @param      key    The key
     * @param      value  The value
     *
     * @return     The node.
     */
    public Node put(final Node x, final Book key, final String value) {
        if (x == null) {
            return new Node(key, value, 1);
        }
        int cmp = key.getName().compareTo(x.getKey().getName());
        if (cmp < 0) {
            x.setLeft(put(x.getLeft(), key, value));
        }
        if (cmp > 0) {
            x.setRight(put(x.getRight(), key, value));
        }
        if (cmp == 0) {
            x.setValue(value);
        }
        x.setCount(1 + count(x.getLeft()) + count(x.getRight()));
        return x;
    }
    /**
     * Method to get value of the key.
     * Time complexity of this method is O(N).
     * @param      key   The key
     *
     * @return     The value of the key
     */
    public String get(final Book key) {
        Node x = root;
        while (x != null) {
            int cmp = key.getName().compareTo(x.getKey().getName());
            if (cmp < 0) {
                x = x.getLeft();
            }
            if (cmp > 0) {
                x = x.getRight();
            }
            if (cmp == 0) {
                return x.getValue();
            }
        }
        return null;
    }
    /**
     * Returns the smallest key in the symbol table.
     *
     * @return the smallest key in the symbol table
     * 
     */
    public Book min() {

        return min(root).getKey();
    } 

    private Node min(Node x) { 
        if (x.getLeft() == null) return x; 
        else                return min(x.getLeft()); 
    }
    /**
     * Returns the largest key in the symbol table.
     *
     * @return the largest key in the symbol table
     * 
     */
    public Book max() {

        return max(root).getKey();
    } 

    private Node max(Node x) {
        if (x.getRight() == null) return x; 
        else                 return max(x.getRight()); 
    }
    /**
     * Returns the largest key in the symbol table less than or equal to {@code key}.
     *
     * @param  key the key
     * @return the largest key in the symbol table less than or equal to {@code key}
     * 
     * 
     */
    public Book floor(Book key) {
        Node x = floor(root, key);
        if (x == null) return null;
        else return x.getKey();
    } 

    private Node floor(Node x, Book key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.getKey());
        if (cmp == 0) return x;
        if (cmp <  0) return floor(x.getLeft(), key);
        Node t = floor(x.getRight(), key); 
        if (t != null) return t;
        else return x; 
    }
    /**
     * Returns the smallest key in the symbol table greater than or equal to {@code key}.
     *
     * @param  key the key
     * @return the smallest key in the symbol table greater than or equal to {@code key}
     * 
     * 
     */
    public Book ceiling(Book key) {
        Node x = ceiling(root, key);
        if (x == null) return null;
        else return x.getKey();
    }

    private Node ceiling(Node x, Book key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.getKey());
        if (cmp == 0) return x;
        if (cmp < 0) { 
            Node t = ceiling(x.getLeft(), key); 
            if (t != null) return t;
            else return x; 
        } 
        return ceiling(x.getRight(), key); 
    }
    /**
     * Return the key in the symbol table whose rank is {@code k}.
     * This is the (k+1)st smallest key in the symbol table.
     *
     * @param  k the order statistic
     * @return the key in the symbol table of rank {@code k}
     * @throws IllegalArgumentException unless {@code k} is between 0 and
     *        <em>n</em>–1
     */
    public Book select(int k) {
        Node x = select(root, k);
        return x.getKey();
    }

    // Return key of rank k. 
    private Node select(Node x, int k) {
        if (x == null) return null; 
        int t = count(x.getLeft()); 
        if (t > k) {
            return select(x.getLeft(),  k);
        } 
        if (t < k) {
            return select(x.getRight(), k - t); 
        }
        else {
            return x;
        }
    }
}
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryST bst = new BinaryST();
        final int three = 3;
        final int four = 4;
        while (sc.hasNextLine()) {
            String data = sc.nextLine();
            String[] tokens = data.split(",");
            switch (tokens[0]) {
                case "put":
                Book book = new Book();
                book = new Book(tokens[1], tokens[2],
                    Double.parseDouble((tokens[three])));
                bst.put(book, tokens[four]);
                break;
                case "get":
                book = new Book(tokens[1], tokens[2],
                    Double.parseDouble(tokens[three]));
                System.out.println(bst.get(book));
                break;
                case "max":
                System.out.println(bst.max());
                break;
                case "min":
                System.out.println(bst.min());
                break;
                case "select":
                System.out.println(bst.select(Integer.parseInt(tokens[1])));
                break;
                case "floor":
                book = new Book(tokens[1], tokens[2],
                    Double.parseDouble(tokens[three]));
                System.out.println(bst.floor(book));
                break;
                case "ceiling":
                book = new Book(tokens[1], tokens[2],
                    Double.parseDouble(tokens[three]));
                System.out.println(bst.ceiling(book));
                break;
                default:
                break;
            }
        }
    }
}