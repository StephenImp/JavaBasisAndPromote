package DataStructures.BinaryTree.TreeDemo;


import java.util.Stack;

/**
 * Created by admin on 2018/7/10.
 */
public class Tree {

    private Node root;//根节点

    public Node find(int key) {
        Node current = root;
        while (current.iData != key) {

            if (key < current.iData) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }

            if (current == null) {
                return null;
            }
        }

        return current;
    }

    public void insert(int id, double dd) {

        Node newNode = new Node();
        newNode.iData = id;
        newNode.dData = dd;

        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current.leftChild;

                if (id < current.iData) {   //go left
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void delete() {

    }

    /**
     * 中序遍历
     */
    private void inOrder(Node localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.leftChild);
            System.out.println(localRoot.iData + "");
            inOrder(localRoot.rightChild);
        }
    }

    /**
     * 前序遍历
     */
    private void preOrder(Node localRoot) {
        if (localRoot != null) {
            System.out.println(localRoot.iData + "");
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }

    /**
     * 后序遍历
     */
    private void postOrder(Node localRoot) {
        if (localRoot != null) {
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.println(localRoot.iData + "");
        }
    }

    /**
     * 查找最小值
     * 要找最小值，先走到根的左子节点处，然后走到那个子节点的左子节点处，
     * 如此类推，直到找到一个没有左子节点的节点，这个节点就是最小值的节点
     * <p>
     * 同理，最大值
     * current = current.rightChild;
     */
    public Node minimun() {
        Node current;
        Node last = null;
        current = root;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last;
    }

    /**
     * 删除节点：
     * 首先，要查找要删除的节点，并且要保存要删除节点的父节点，这样就可以修改它的子节点的值了
     * 如果找到节点，就从while循环中跳出，parent保存要删除的节点
     * 如果找不到要删除的节点，就从delete()方法返回false
     */

    public boolean delete(int key) {
        Node current = root;
        Node parent = root;

        boolean isLeftChild = true;//current节点（要删除的节点）是否为左节点

        while (current.iData != key) {

            parent = current;//这里保存要删除的节点的父节点

            if (key < current.iData) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }

            if (current == null) {
                return false;
            }
        }

        if (current.leftChild == null && current.rightChild == null) {//删除没有子节点的节点
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } else if (current.rightChild == null) {//删除有一个子节点的节点
            /**
             * 要删除的节点的子节点为左节点时
             * 删除节点后，把删除节点的子节点拼接上来
             */
            if (current == root) {
                root = current.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }

        } else if (current.leftChild == null) {//删除有一个子节点的节点

            /**
             * 要删除的节点的子节点为右节点时
             * 同理
             */
            if (current == root) {
                root = current.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        } else {
            /**
             * 删除的节点的子节点有两个节点的时候
             */
            Node successor = getSuccessor(current);//找到要删除节点的后继节点

            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;

                /**
                 * 当要删除节点的为右节点时
                 * 要删除节点的左节点为后继节点的左节点
                 */
                successor.leftChild = current.leftChild;
            }

        }
        return true;
    }

    /**
     * 寻找后继节点
     * <p>
     * 中序后继：
     * 对于每一个节点来说，比该关键字值次高的节点是它的中序后继，简称为该节点的后继
     * <p>
     * 后继节点可能是删除节点的右子节点，或者也可能是删除节点的右子节点的左子孙节点
     */
    private Node getSuccessor(Node delNote) {

        Node successorParent = delNote;//后继节点的父节点
        Node successor = delNote;//后继节点
        Node current = delNote.rightChild;

        /**
         * 这个循环找到后继节点，以及后继节点的父节点
         */
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }

        if (successor != delNote.rightChild) {
            successorParent.leftChild = successor.rightChild;//后继节点父节点的左节点为后继节点的右节点

            /**
             * 后继节点的右节点为删除节点的右节点
             * 这里是因为 把后继节点的位置移到删除节点位置的时候
             * 后继节点的右节点就是原来删除节点的右节点
             */
            successor.rightChild = delNote.rightChild;
        }

        return successor;
    }

    public void traverse(int traverseType) {
        switch (traverseType) {
            case 1:
                System.out.println("\nPreorder traversal:");
                preOrder(root);
                break;
            case 2:
                System.out.println("\nInorder traversal:");
                inOrder(root);
                break;
            case 3:
                System.out.println("\nPostorder traversal:");
                postOrder(root);
                break;
        }

        System.out.println();
    }

    public void displayTree() {
        Stack globaStack = new Stack();
        globaStack.push(root);

        int nBlanks = 32;
        boolean isRowEmpty = false;

        System.out.println("******************************************");
        while (isRowEmpty) {
            Stack localStack = new Stack();
            isRowEmpty = true;

            for (int j = 0; j < nBlanks; j++) {
                System.out.println("");
            }

            while (globaStack.isEmpty() == false) {

                Node temp = (Node) globaStack.pop();
                if (temp != null) {
                    System.out.println(temp.iData);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);

                    if (temp.leftChild != null || temp.rightChild != null) {
                        isRowEmpty = false;
                    } else {
                        System.out.println("--");
                        localStack.push(null);
                        localStack.push(null);
                    }
                }
            }

            for (int j = 0; j < nBlanks * 2 - 2; j++) {
                System.out.println(" ");
            }

            System.out.println();
            nBlanks /= 2;

            while (localStack.isEmpty() == false) {
                globaStack.push(localStack.pop());
            }

            System.out.println("******************************************");
        }
    }

}
