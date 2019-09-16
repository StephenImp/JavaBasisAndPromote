package list;

import org.junit.Test;


public class TestArray {

    /**
     * 这样吧需要的元素赋值到新数组好像不可行
     * 不是不行，是我这个有问题
     */
    @Test
    public void test1(){

        String[] namelist = {"01POSITION_01_082019091020190910161509017158070H","08POSITION_01_082019091220190912161509017158070H","01POSITION_01_082019072320190710161509017158070H"};

        String[] newNameList = new String[namelist.length];

        for (int i = 0; i <namelist.length ; i++) {
            if (namelist[i].contains("01POSITION_01_08")){
                newNameList[i] = namelist[i];
            }
        }

        System.out.println(newNameList.length);

        if (newNameList.length!=0){
            namelist = newNameList;
        }

        for(String name:namelist){
            System.out.println(name);
        }
    }

    /**
     * 删除指定元素  https://blog.csdn.net/weixin_41933796/article/details/79860279
     *
     * 现在我要改成保存指定元素
     */
    public static void main(String[] args) {
        String[] namelist = {"01POSITION_01_082019091020190910161509017158070H","08POSITION_01_082019091220190912161509017158070H","01POSITION_01_082019072320190710161509017158070H"};

        String value = "09POSITION_01_08";
        namelist = delElement(namelist, value);

        for (String s:namelist) {
            System.out.println(s);
        }

    }


    //删除指定的元素
    public static String[] delElement(String[] arr,String value){
        //判断数组中是否包含指定值
        if(!isExist(arr,value)){
            //return arr;
            return new String[0];//不包含直接返回空
        }
        //统计有多少个要删除的元素
        //改成统计有多少需要保存的元素
        int count = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i].contains(value)){
                count++;
            }
        }
        //创建新数组
        //String[] res = new String[arr.length - count];
        String[] res = new String[count];

        //遍历原数组,把不等于value的值赋值给res
        int index = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i].contains(value)){
                res[index++] = arr[i];
            }
        }
        return res;
    }
    //判断数组中是否包含指定值
    public static boolean isExist(String[] arr,String value){
        for(int i = 0;i<arr.length;i++){
            if(arr[i].contains(value)){
                return true;
            }
        }
        return false;
    }

}
