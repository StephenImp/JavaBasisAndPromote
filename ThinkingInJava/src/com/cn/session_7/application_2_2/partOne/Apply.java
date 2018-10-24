package com.cn.session_7.application_2_2.partOne;

/**
 * 完全解耦1
 */
public class Apply {

    public static void process(Processor p, Object s){
        System.out.println("Using Processor"+p.name());
        System.out.println(p.process(s));
    }
    
    public static String s = "Disagreement with belief is by definition incorrect";
    
    public static String z = "Disagreement:with:belief:is:by:definition:incorrect";
    
    public static void main(String[] args) {
        process(new Upcase(),s);
        process(new Downcase(),s);
        process(new Spilitter(),s);


//        String string = Arrays.toString(((String)z).split(":"));
//        System.out.println(string);
//
//        String[] split = z.split(":");
//        for(String x:split){
//            System.out.println(x);
//        }
    }
    
}
