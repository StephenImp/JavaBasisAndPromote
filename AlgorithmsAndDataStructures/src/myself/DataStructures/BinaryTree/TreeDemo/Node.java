package myself.DataStructures.BinaryTree.TreeDemo;

/**
 * Created by admin on 2018/7/10.
 */
public class Node {

    int iData;
    double dData;
    Node leftChild;
    Node rightChild;

    public void displayNode(){

        System.out.println("{");
        System.out.println("iData");
        System.out.println(",");
        System.out.println("dData");
        System.out.println("}");
    }

    @Override
    public String toString() {
        return "Node{" +
                "iData=" + iData +
                ", dData=" + dData +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                '}';
    }
}
