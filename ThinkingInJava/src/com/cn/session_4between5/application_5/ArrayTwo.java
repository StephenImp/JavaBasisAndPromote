package com.cn.session_4between5.application_5;

/**
 * Created by admin on 2018/7/31.
 * 二维转一维
 */
public class ArrayTwo {

    public static void main(String[] args) {
        int [][] a =new int [][] {{6,7,4},{2,1,8},{9,5,3}};
        int [] b =new int [9];

        //二维转一维
        int i,j ;
        int k;
        int m,n;
        int t;

        for(i=0,k=0;i<a.length;i++){//a.length表示二维数组的行数
            for(j=0;j<a[i].length;j++){//a[i].length表示二维数组每一行的列数。
                b[k]=a[i][j];
                k++;
            }
        }

        //冒泡排序
        for(n=0;n<b.length-1;n++){//一共比较几趟
            for(m=0;m<b.length-1-n;m++){//比较到第几趟
                if(b[m]>b[m+1]){
                    t=b[m];
                    b[m]=b[m+1];
                    b[m+1]=t;
                }
            }
        }

        //一维转二维
        for(i=0,k=0;i<3;i++){
            for(j=0;j<3;j++){
                a[i][j]=b[k];//k是一维数组的下标
                System.out.print(a[i][j]);
                k++;
            }
        }
    }
}
