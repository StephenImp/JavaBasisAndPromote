package myself.DataStructures.HashTable.OpeanAddress;

/**
 * Created by admin on 2018/7/25.
 */
public class DataItem {

    private int iData;

    public DataItem(int ii) {
        iData = ii;
    }

    public int getKey(){
        return iData;
    }

    @Override
    public String toString() {
        return "DataItem{" +
                "iData=" + iData +
                '}';
    }
}
