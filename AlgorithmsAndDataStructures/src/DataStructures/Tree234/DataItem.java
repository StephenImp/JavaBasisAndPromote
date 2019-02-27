package DataStructures.Tree234;

/**
 * Created by MOZi on 2018/11/8.
 *
 * 表示存储在节点中的数据项
 *
 * 实际生活中可以是任意对象
 */
public class DataItem {

    public long dData;

    public DataItem(long dd){

        dData = dd;
    }

    public void displayItem(){

        System.out.println("/"+dData);

    }
}
