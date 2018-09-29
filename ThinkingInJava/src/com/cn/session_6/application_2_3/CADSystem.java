package com.cn.session_6.application_2_3;

/**
 * 确保正确的清除，这里可能是告诉我们清除用finally关键字吧
 */
public class CADSystem extends Shape{

    private Circle c;
    private Triangle t;
    private Line[] lines = new Line[3];//这里只是new了一个Line[]，并没有创建实际的Line对象

    //private Line l  = new Line(3,4);

    //这里只调了一次Shape constructor
//    public CADSystem(int i){
//        super(i);
//        //System.out.println("CADSystem constructor");
//    }



    public CADSystem(int i){
        super(i+1);
        for(int j =0;j<lines.length;j++){
            lines[j] = new Line(j,j*i);
            c = new Circle(1);
            t = new Triangle(1);
            System.out.println("Combined constructor");//Combined  综合
        }
    }

    @Override
    public void dispose(){
        System.out.println("-------------------------------");
        System.out.println("CADSystem dispose() ");
        t.dispose();
        c.dispose();
        for(int i = lines.length -1;i>=0;i--){
            lines[i].dispose();
            super.dispose();
        }
    }

    public static void main(String[] args) {
        
        CADSystem x = new CADSystem(47);
        try{
            
        }finally{
            x.dispose();
        }
    }
}
