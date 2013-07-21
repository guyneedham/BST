import com.sun.xml.internal.messaging.saaj.soap.impl.TreeException;



/**
 * Created with IntelliJ IDEA.
 * User: Guy
 * Date: 26/04/13
 * Time: 15:06
 * To change this template use File | Settings | File Templates.
 */
public class BinarySearchTree<T> {

    private TreeNode<T> root;
    private int size;

    public BinarySearchTree() {
        root = null;
    }

    public boolean isEmpty(){
        return (root == null);
    }

    public TreeNode<T> getRoot() throws TreeException{
        if(isEmpty()) {
            throw new TreeException("Exception: Empty Tree");
        } else {
            return root;
        }
    }

    public void insert(T value, int key) {
        TreeNode<T> newNode = new TreeNode<T>(value, key, null, null, null);
        root = insertNode(root, newNode);
    }

    private TreeNode<T> insertNode(TreeNode<T> root, TreeNode<T> newNode){
        if(root == null) {
            root = newNode;
            size++;
            return root;
        }

        if(newNode.getKey() < root.getKey()) {
            newNode.setParent(root);
            root.setLeft(insertNode(root.getLeft(), newNode));

        } else if(newNode.getKey() > root.getKey()) {
            newNode.setParent(root);
            root.setRight(insertNode(root.getRight(), newNode));
        }

        return root;
    }

    public TreeNode<T> find(T value, int key) /*throws Exception*/ {
        TreeNode<T> newNode = new TreeNode<T>(value, key, null, null, null);

        return findNode(newNode);
    }

    private TreeNode<T> findNode(TreeNode<T> newNode) /*throws Exception*/ {
        TreeNode<T> found = null;

        if(isEmpty()) {
            //throw new Exception();
        }

        if(newNode.getKey() < root.getKey()) {
            findNode(root.getLeft());
        }

        if(newNode.getKey() > root.getKey()) {
            findNode(root.getRight());
        }

        if(newNode.getKey() == root.getKey()) {
            found = root;
            //Is it me you're looking for?
        }

        return found;
    }

    public int getSize() {
        return size;
    }
}
