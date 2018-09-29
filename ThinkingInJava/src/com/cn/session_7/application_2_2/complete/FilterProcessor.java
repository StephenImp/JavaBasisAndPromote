package com.cn.session_7.application_2_2.complete;

/**
 * 完全解耦3
 * 适配器方式
 *
 *   BandPass extends Filter
     HighPass extends Filter
     LowPass extends Filter

     FilterAdapter implements Processor    --->普通类
     StringProcessor implements Processor  --->抽象类

     Downcase extends StringProcessor
     Upcase extends StringProcessor
     Spilitter extends StringProcessor


    传入不同的基类（FilterAdapter，StringProcessor），达到不同的效果，
    但是运行的方法还是Apply.process(Processor p ,Object s){}方法

    这里的FilterAdapter，StringProcessor  相当于是做出了两种不同的选择。


    在这种使用适配器的方式中，FilterAdapter的构造器接受了你所拥有的接口Filter，
    然后生成具有你所需要的Processor接口的对象。
    你可能还注意到了，在FilterAdapter类中用到了代理。
    将接口从具体实现中解耦使得接口可以应用于多种不同的具体实现，因此代码也就更具有可复用性。

 */
public class FilterProcessor {

    public static String s = "If she weighs the same as duck ,she's made of wood";

    public static void main(String[] args) {
        Waveform w = new Waveform();
        
        Apply.process(new FilterAdapter(new LowPass(1.0)), w);
        Apply.process(new FilterAdapter(new HighPass(2.0)), w);
        Apply.process(new FilterAdapter(new BandPass(3.0,4.0)), w);

        System.out.println("********************************************************");

        Apply.process(new Downcase(),s);
        Apply.process(new Upcase(),s);
        Apply.process(new Spilitter(),s);


//      Apply.process(new StringProcessor() {
//            @Override
//            public String process(Object input) {
//                return null;
//            }
//        },w);
    }
}
