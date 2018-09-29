package com.cn.session_7.application_3_8;

/**
 * Created by admin on 2018/8/2.
 */
public class Controller {

    private EventSet es = new EventSet();
    public void addEvent(Event c) {
        es.add(c);
    }

    public void run() {
        Event e;
        while((e = es.getNext()) != null) {
            if(e.ready()) {
                e.action();
                System.out.println(e.description());
                es.removeCurrent();
            }
        }
    }
}
