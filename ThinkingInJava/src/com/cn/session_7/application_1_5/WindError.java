package com.cn.session_7.application_1_5;

/**
 * Created by admin on 2018/8/1.
 * 覆盖与过载
 */
public class WindError {

    public static void tune(InstrumentX i) {
        i.play(NoteX.MIDDLE_C);
    }

    public static void main(String[] args) {

        /**
         * WindX中并没有重写父类中的play()方法，只是重载。
         * 编译器此时假定的是程序员有意进行“过载”(重载)，而非“覆盖”（重写）。
         *
         * 在tune 中，“InstrumentX i ”会发出play()消息，同时将某个NoteX 成员作为自变量使用（MIDDLE_C）。
           由于NoteX 包含了int 定义，重载的play()方法的int 版本会得到调用。
           同时由于它尚未被“覆盖”（重写），所以会使用基础类版本。
         */
        WindX flute = new WindX();
        tune(flute); // Not the desired behavior!
    }
}
