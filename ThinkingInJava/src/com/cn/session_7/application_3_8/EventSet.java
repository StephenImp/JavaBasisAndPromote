package com.cn.session_7.application_3_8;

/**
 * Created by admin on 2018/8/2.
 *
 * EventSet 可容纳100 个事件。
 * index （索引）在这里用于跟踪下一个可用的空间，
 * 而next（下一个）帮助我们寻找列表中的下一个事件，了解自己是否已经循环到头。
 * 在对getNext()的调用中，这一点是至关重要的，因为一旦运行，Event 对象就会从列表中删去（使用removeCurrent()）。
 * 所以getNext()会在列表中向前移动时遇到“空洞”。
 *
 */
public class EventSet {

    private Event[] events = new Event[100];
    private int index = 0;
    private int next = 0;
    public void add(Event e) {
        if(index >= events.length){
            return; // (In real life, throw exception)
        }
        events[index++] = e;
    }


    public Event getNext() {
        boolean looped = false;
        int start = next;
        do {
            next = (next + 1) % events.length;
            // See if it has looped to the beginning:
            if(start == next){
                looped = true;
            }

            // If it loops past start, the list
            // is empty:
            if((next == (start + 1) % events.length)
                    && looped){
                return null;
            }
        } while(events[next] == null);
        return events[next];
    }

    public void removeCurrent() {
        events[next] = null;
    }
}
