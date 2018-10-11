import java.util.*;
/**
 * Class for book.
 */
class Book implements Comparable<Book>{
	/**
	 * { var_description }
	 */
	String name;
	/**
	 * { var_description }
	 */
	String author;
	/**
	 * { var_description }
	 */
	double price;
	/**
	 * Constructs the object.
	 */
	Book() {
    }
    /**
     * Constructs the object.
     *
     * @param      name    The name
     * @param      author  The author
     * @param      price   The price
     */
	Book(String name, String author, double price) {
		this.name = name;
		this.author = author;
		this.price = price;
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
     * { function_description }
     *
     * @param      that  The that
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(Book that) {
    	return this.name.compareTo(that.name);
    }
}
/**
 * Class for node.
 *
 * @param      <Key>     The key
 * @param      <String>  The string
 */
class Node {
	Book key;
	String value;
	Node left, right;
	Node(Book key, String value) {
		this.key = key;
		this.value = value;
	}
}
/**
 * Class for binary st.
 *
 * @param      <Key>     The key
 * @param      <String>  The string
 */
class BinaryST {
	/**
	 * { var_description }
	 */
	Node root;
	/**
	 * Constructs the object.
	 */
	BinaryST() {
		root = null;
    }
	public void put(Book key, String value) {
		root = put(root, key, value);
	}
	public Node put(Node x, Book key, String value) {
		if (x == null) {
			root = new Node(key, value);
		}
		int cmp = key.getName().compareTo(x.key.getName());
		if (cmp < 0) {
			x.left = put(x.left, key, value);
		} else if (cmp > 0) {
			x.right = put(x.right, key, value);
		} else {
			x.value = value;
		}
		return x;
	}
    public String get(Book key) {
    	Node x = root;
    	while (x != null) {
    		int cmp = key.getName().compareTo(x.key.getName());
    		if (cmp < 0) {
    			x = x.left;
    		} else if (cmp > 0) {
    			x = x.right;
    		} else {
    			return x.value;
    		}
    	}
    	return null;
    }

}
class Solution {
	Solution() {
    }
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	BinaryST bst = new BinaryST();
    	while (sc.hasNext()) {
    		String data = sc.nextLine();
    		String[] tokens = data.split(",");
    		switch (tokens[0]) {
    			case "put":
    			Book book = new Book();
    			book = new Book(tokens[1], tokens[2], Double.parseDouble((tokens[3])));
    			bst.put(book, tokens[4]);
    			break;
    			case "get":
    			book = new Book(tokens[1], tokens[2], Double.parseDouble(tokens[3]));
    			System.out.println(bst.get(book));
    			break;
    			default:
    			break;
    		}
    	}
    }
}