package com.cn.session_7.application_1_X_11;

public class Stage {

    private Actor actor  = new HappyActor();
    
    public void change(){
        actor = new SadActor();
    }
    
    public void performPlay(){
        actor.act();
    }
}
