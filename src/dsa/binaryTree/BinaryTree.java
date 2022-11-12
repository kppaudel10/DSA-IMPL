package dsa.binaryTree;

public class BinaryTree implements BinaryTreeOperation {
    class Node{
        private Integer data;
        private Node leftChild;
        private Node rightChild;
    }
    Node rootNode;

    @Override
    public void insert(Integer data) {
        Node newNode = new Node();
        newNode.data = data;
        if (rootNode == null){
            rootNode = newNode;
            // set left and right child
            rootNode.leftChild = rootNode.rightChild = null;
        }


    }
}
