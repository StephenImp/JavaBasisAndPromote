package myself.DataStructures.Tree234;

/**
 * Created by MOZi on 2018/11/8.
 */
public class Node {

    private static final int ORDER = 4;

    private int numItems;//当前字段个数

    private Node parent;//父节点

    private Node childArray[] = new Node[ORDER];//所有子节点的最大引用

    /**
     * 节点存储的最大数据项
     * 有序数组
     * 插入和删除数据时，还必须保持有序的状态
     * 数据项需要移位腾出空间来按序插入新数据项
     * 或者在删除某个数据项后前移以补上空着的数据单元
     */
    private DataItem itemArray[] = new DataItem[ORDER-1];

    //connect child to this node
    public void connectChild(int childNum,Node child){

        childArray[childNum] = child;

        if (child!=null){
            child.parent = this;
        }
    }

    //disconnect child from this node ,return it
    public Node disconnectChild(int childNum){

        Node tempNode = childArray[childNum];
        childArray[childNum] = null;
        return tempNode;
    }


    public Node getChild(int childNum){

        return childArray[childNum];
    }

    public Node getParent(){
        return parent;
    }

    public boolean isLeft(){

        return (childArray[0] == null) ? true : false;
    }

    public int getNumItems(){
        return numItems;
    }

    public DataItem getItem(int index){
        return itemArray[index];
    }

    public boolean isFull(){
        return (numItems == ORDER-1)?true:false;
    }

    public int findItem(long key){

        for (int i = 0; i <ORDER-1 ; i++) {
            if (itemArray[i] == null){
                break;
            }else if (itemArray[i].dData == key){
                return i;
            }
        }
        return -1;
    }

    /**
     * 在节点中插入新的数据项
     * 根据需要移动存在的数据项
     * @param newItem
     * @return
     */
    public int insertItem(DataItem newItem){

        numItems++;
        long newKey = newItem.dData;

        for (int i = ORDER-2; i >0 ; i--) {
            if (itemArray[i] == null){
                continue;
            }else {
                long itsKey = itemArray[i].dData;
                if (newKey<itsKey){

                    itemArray[i+1] = itemArray[i];
                }else {
                    itemArray[i+1] = newItem;
                    return i+1;
                }
            }
        }

        itemArray[0] = newItem;
        return 0;
    }

    /**
     * 删除数据项
     * 根据需要移动存在的数据项
     * @return
     */
    public DataItem removeItem(){

        DataItem temp = itemArray[numItems-1];
        itemArray[numItems-1] = null;
        numItems--;
        return temp;

    }

    public void displayNode(){
        for (int i = 0; i <numItems ; i++) {
            itemArray[i].displayItem();
        }
        System.out.println("/");
    }
}
