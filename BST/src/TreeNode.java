/**
 * Created with IntelliJ IDEA.
 * User: Guy
 * Date: 26/04/13
 * Time: 14:47
 * To change this template use File | Settings | File Templates.
 */
public class TreeNode<T> {

    private int key;
    private T element;
    private TreeNode<T> parent;
    private TreeNode<T> left, right;

    public TreeNode(T newElem, int keyValue,TreeNode<T> parentNode, TreeNode<T> leftChild, TreeNode<T> rightChild){
        key = keyValue;
        element = newElem;
        parent = parentNode;
        left = leftChild;
        right = rightChild;
    }

    public T getElem() {
        return element;
    }

    public int getKey() {
        return key;
    }

    public void setParent(TreeNode<T> parentNode) {
        parent = parentNode;
    }

    public TreeNode<T> getParent() {
        return parent;
    }

    public void setLeft(TreeNode<T> Node){
        left = Node;
    }

    public TreeNode<T> getLeft(){
        return left;
    }

    public void setRight(TreeNode<T> Node){
        right = Node;
    }

    public TreeNode<T> getRight() {
        return right;
    }
}
