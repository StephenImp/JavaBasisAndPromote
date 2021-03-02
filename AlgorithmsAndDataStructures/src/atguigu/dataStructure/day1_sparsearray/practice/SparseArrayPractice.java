package atguigu.dataStructure.day1_sparsearray.practice;

/**
 * SparseArrayPractice
 *
 * @author wupw
 * @date 2021/3/2
 */
public class SparseArrayPractice {

    /**
     * 二维数组 转 稀疏数组的思路
     * <p>
     * I.遍历原始的二维数组，得到有效数据的个数 sum (上图的有效个数为2)
     * <p>
     * II. 根据sum 就可以创建 稀疏数组 sparseArr   int[sum + 1] [3]
     * <p>
     * III. 将二维数组的有效数据数据存入到 稀疏数组
     * <p>
     * 稀疏数组 转 原始的二维数组的思路
     * <p>
     * I. 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
     * <p>
     * II. 在读取稀疏数组后几行的数据，并赋给 原始的二维数组 即可.
     */

    public static void main(String[] args) {


        //创建数组
        int[][] originalArr = new int[11][11];

        //为数组赋值
        originalArr[1][2] = 1;
        originalArr[2][3] = 2;

        System.out.println("打印原始二维数组：");

        //打印二维数组
        for (int i = 0; i < originalArr.length; i++) {
            for (int j = 0; j < originalArr[i].length; j++) {
                System.out.print(originalArr[i][j] + "\t");
            }
            System.out.println();
        }


        //二维数组 转 稀疏数组

        int sum = 0;
        //I.遍历原始的二维数组，得到有效数据的个数 sum (上图的有效个数为2)
        for (int i = 0; i < originalArr.length; i++) {
            for (int j = 0; j < originalArr[i].length; j++) {
               if (originalArr[i][j]!=0){
                   sum++;
               }
            }
        }

        //II. 根据sum 就可以创建 稀疏数组 sparseArr   int[sum + 1] [3]
        int [][] sparseArr = new int[sum+1][3];

        //III. 将二维数组的有效数据数据存入到 稀疏数组
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;


        // 这里练习时有些卡顿      真是垃圾啊
        int count = 0;
        for (int i = 0; i < originalArr.length; i++) {
            for (int j = 0; j < originalArr[i].length; j++) {
                if (originalArr[i][j]!=0){
                    count++;
                    sparseArr[count][0] = i ;//有效数据行号
                    sparseArr[count][1] = j; //有效数据列号
                    sparseArr[count][2] =  originalArr[i][j];//有效数据值
                }
            }
        }

        System.out.println();
        System.out.println("打印稀疏数组");

        for (int i = 0; i <sparseArr.length ; i++) {
            System.out.println(sparseArr[i][0]+"\t"+sparseArr[i][1]+"\t"+sparseArr[i][2]+"\t");
        }


        //稀疏数组 转 原始的二维数组的思路

        //先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
        int[][] originalArrCopy = new int[sparseArr[0][0]][sparseArr[0][1]];


        //II. 在读取稀疏数组后几行的数据，并赋给 原始的二维数组 即可.

        for (int i = 1; i <sparseArr.length ; i++) {
            originalArrCopy[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        System.out.println();
        System.out.println("还原二维数组");


        for (int i = 0; i < originalArrCopy.length; i++) {
            for (int j = 0; j < originalArrCopy[i].length; j++) {
                System.out.print(originalArr[i][j] + "\t");
            }
            System.out.println();
        }


    }

}
