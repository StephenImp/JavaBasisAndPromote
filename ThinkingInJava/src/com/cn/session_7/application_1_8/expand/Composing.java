package com.cn.session_7.application_1_8.expand;

public class Composing {

    private Shared shared;
    private static long counter = 0;
    
    private final long id = counter++;
    
    public Composing(Shared shared){
        System.out.println("Creating "+this);
        this.shared = shared;
        this.shared.addRef();
    }
    
    protected void dispose(){
        System.out.println("disposing"+this);
        shared.dispose();
    }
    
    public String toString(){
        return "Composing" + id;
    }
}
