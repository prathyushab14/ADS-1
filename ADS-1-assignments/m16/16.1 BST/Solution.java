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
}
/**
 * Class for node.
 *
 */
class Node {
    /**
     * Book object.
     */
    Book key;
    /**
     * value.
     */
    String value;
    /**
     * left node, right node.
     */
    Node left, right;
    /**
     * Constructs the object.
     *
     * @param      key    The key
     * @param      val  The value
     */
    Node(final Book key, final String val) {
        this.key = key;
        this.value = val;
    }
}
/**
 * Class for binary st.
 *
 */
class BinaryST {
    /**
     * Rot node.
     */
    Node root;
    /**
     * Constructs the object.
     */
    BinaryST() {
    }
    /**
     * Method to insert the key.
     *
     * @param      key    The key
     * @param      value  The value
     */
    public void put(final Book key, final String value) {
        root = put(root, key, value);
    }
    /**
     * Method to insert the keys.
     *
     * @param      x      The node.
     * @param      key    The key
     * @param      value  The value
     *
     * @return     The node.
     */
    public Node put(final Node x, final Book key, final String value) {
        if (x == null) {
            return new Node(key, value);
        }
        int cmp = key.getName().compareTo(x.key.getName());
        if (cmp < 0) {
            x.left = put(x.left, key, value);
        }
        if (cmp > 0) {
            x.right = put(x.right, key, value);
        }
        if (cmp == 0) {
            x.value = value;
        }
        return x;
    }
    /**
     * Method to get value of the key.
     *
     * @param      key   The key
     *
     * @return     The value of the key
     */
    public String get(final Book key) {
        Node x = root;
        while (x != null) {
            int cmp = key.getName().compareTo(x.key.getName());
            if (cmp < 0) {
                x = x.left;
            }
            if (cmp > 0) {
                x = x.right;
            }
            if (cmp == 0) {
                return x.value;
            }
        }
        return null;
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
                default:
                break;
            }
        }
    }
}