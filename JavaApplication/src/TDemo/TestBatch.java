package TDemo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestBatch {

    @Test
    public void test(){

        List<String> list = new ArrayList<>();

        for (int i = 0; i <102; i++) {
            list.add(String.valueOf(i));
        }

        insertDataBatch(list);
    }


    private void insertDataBatch(List<String> list) {
        int batchSize = 10;
        if (list != null && list.size() > 0) {
            int length = list.size();
            int i = 0;
            while (length > batchSize) {
                list.subList(i, i + batchSize);
                i = i + batchSize;
                length = length - batchSize;
            }
            if (length > 0) {
                list.subList(i, i + length);
            }
        }
    }
}
