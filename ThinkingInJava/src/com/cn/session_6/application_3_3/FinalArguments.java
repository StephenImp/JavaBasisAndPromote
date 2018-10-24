package com.cn.session_6.application_3_3;

/**
 * final 自变量
 */
public class FinalArguments {

    void with(final Gizmo g){
        //g = new Gizmo(); //g is final
    }
    
    void without(Gizmo g){
        g = new Gizmo();
        g.spin();
    }
    
    void f(final int i){
        //i++; Can't change
    }

    int g(final int i){
        return i+1;
    }
    
    public static void main(String[] args) {
        FinalArguments bf = new FinalArguments();
        bf.without(null);
        bf.with(null);
    }
}
