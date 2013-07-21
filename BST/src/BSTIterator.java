import java.util.NoSuchElementException;

/**
 * Created with IntelliJ IDEA.
 * User: Guy
 * Date: 26/04/13
 * Time: 17:18
 * To change this template use File | Settings | File Templates.
 */
public class BSTIterator<T> {
    private TreeNode<T> current;

    public BSTIterator(TreeNode<T> root) {
        current = root;
        if(current == null) {
            return;
        }

        while (current.getLeft() != null)
            current = current.getLeft();
    }

    public boolean hasNext() {
        return current != null;
    }

    public TreeNode<T> next(){
        //if there is no next node, throw an exception
        if(!hasNext()) throw new NoSuchElementException();
        //this is the current node now
        TreeNode<T> node = current;
       //if you can go right, then do, and traverse the node

        if(current.getRight() != null){
            current = current.getRight();
       //while there is a node to the left
            while (current.getLeft() != null)
                //traverse this node
                current = current.getLeft();
        } else while(true){
            //if the node has no parent, return the node
            if(current.getParent() == null){
                current = null;
                return node;
            }
            //if the current node is to the left of the parent node, return this node
            if(current.getParent().getLeft() == current){
                current = current.getParent();
                return node;
            }
            //go up one level in the tree
            current = current.getParent();
        }

        return node;
    }
}
