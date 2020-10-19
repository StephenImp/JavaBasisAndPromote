package myself.DataStructures.Tree234;

/**
 * Created by MOZi on 2018/11/8.
 */
public class Tree234 {

    /**
     * 所有的操作都是从根开始的
     */
    private Node root = new Node();

    /**
     * 从根开始对每个节点调用节点的findItem()来查看数据项是否在那里
     * 如果是的话，返回数据项在节点的数据项数组中的索引值
     *
     * 如果find()没有找到数据项，查找就失败了，返回-1，
     * 如果在当前节点查找不到数据项，并且节点不是叶节点，
     * find()调用getNextChild(),找出下一步需要转向节点的那个子节点
     * @param key
     * @return
     */
    public int find(long key){

        Node curNode = root;
        int childNumber;
        while (true){
            if ((childNumber = curNode.findItem(key))!=-1){

                return childNumber;
            }else if (curNode.isLeft()){
                return -1;
            }else {
                curNode = getNextChild(curNode,key);
            }
        }
    }

    /**
     * 除了找到满的节点就分裂节点之外，
     * insert()开始的代码与find()类似
     *
     * 没有失败，不断查找，一层一层深入地找下去，直到找到一个叶节点
     * 这时把新的数据项插入到叶节点中。(叶节点中总会有空间：否则叶节点就需要分裂)
     *
     *
     * @param dValue
     */
    public void insert(long dValue){

        Node curNode = root;
        DataItem tempItem = new DataItem(dValue);

        while (true){

            if (curNode.isFull()){

                split(curNode);
                curNode = curNode.getParent();
                curNode = getNextChild(curNode,dValue);
            }else if (curNode.isLeft()){

                break;
            }else {
                curNode = getNextChild(curNode,dValue);
            }
        }

        curNode.insertItem(tempItem);
    }

    /**
     * 分裂
     *
     * 首先，最右边的两个数据项从节点中删除并保存起来
     * 然后断开最右边两个子节点的连接：他们的引用也保存起来
     *
     * 建立一个新节点。newRight.它将置于被分裂节点的右边
     * 如果要分裂的节点是根，还要再创建一个新节点：新的根点
     *
     * 要把分裂节点连接到它父节点的合适位置上去
     * 父节点可能使已经存在的，
     * 或如果根分裂时，父节点是新创建的根节点。
     *
     * 假设分裂节点中三个数据项A,B,C
     * 数据项B插入到它的父节点中，
     * 如果有必要的话，父节点中已经存在的子节点先断开连接，再连接到右移一位的新位子上，
     * 为新的数据项和新的连接腾出位子，newRight节点连接到它的父节点上。
     *
     * @param thisNode  将要分裂的节点
     */
    public void split(Node thisNode){

        DataItem itemB;
        DataItem itemC;

        Node parent;
        Node child2;
        Node child3;

        int itemIndex;

        itemC = thisNode.removeItem();
        itemB = thisNode.removeItem();

        child2 = thisNode.disconnectChild(2);
        child3 = thisNode.disconnectChild(3);

        Node newRight = new Node();

        if (thisNode == root){
            root = new Node();
            parent = root;
            root.connectChild(0,thisNode);
        }else {
            parent = thisNode.getParent();
        }

        itemIndex = parent.insertItem(itemB);
        int n = parent.getNumItems();

        for (int i = n-1; i >itemIndex ; i--) {
            Node temp = parent.disconnectChild(i);
            parent.connectChild(i+1,temp);
        }

        parent.connectChild(itemIndex+1,newRight);

        newRight.insertItem(itemC);
        newRight.connectChild(0,child2);
        newRight.connectChild(1,child3);
    }

    public Node getNextChild(Node theNode,long theValue){

        int i;
        int numItems = theNode.getNumItems();

        for (i = 0; i <numItems ; i++) {
            if (theValue<theNode.getItem(i).dData){
                return theNode.getChild(i);
            }
        }

        return theNode.getChild(i);
    }

    public void displayTree(){
        recDisplayTree(root,0,0);
    }

    private void recDisplayTree(Node thisNode,int level,int childNumber){

        System.out.println("level= "+level+"child=" + childNumber+"");
        thisNode.displayNode();

        int numItems= thisNode.getNumItems();

        for (int i = 0; i <numItems+1 ; i++) {

            Node nextNode = thisNode.getChild(i);
            if (nextNode!=null){

                recDisplayTree(nextNode,level+1,i);
            }else {
                return;
            }
        }
    }
}
