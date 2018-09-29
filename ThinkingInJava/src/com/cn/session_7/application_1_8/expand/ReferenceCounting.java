package com.cn.session_7.application_1_8.expand;

public class ReferenceCounting {

    public static void main(String[] args) {
        Shared shared = new Shared();
        
        Composing[] composing = {
                new Composing(shared),new Composing(shared),new Composing(shared),
                new Composing(shared),new Composing(shared)
        };
        
        for(Composing c : composing){
            c.dispose();
        }
    }
}
