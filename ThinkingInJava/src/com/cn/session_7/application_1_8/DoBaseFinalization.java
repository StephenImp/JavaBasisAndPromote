package com.cn.session_7.application_1_8;

/**
 * Created by admin on 2018/8/1.
 *
 * DoBasefinalization 类只是简单地容纳了一个标志，向分级结构中的每个类指出是否应调用super.finalize()。
 * 这个标志的设置建立在命令行参数的基础上，所以能够在进行和不进行基础类收尾工作的前提下查看行为。
 */
public class DoBaseFinalization {

    public static boolean flag = false;
}
