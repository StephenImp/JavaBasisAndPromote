package com.cn.session_7.application_2_2.complete;

public abstract class StringProcessor implements Processor {

    @Override
    public String name(){
        return getClass().getSimpleName();
    }

    @Override
    public abstract String process(Object input);
    
    public static String s = "If she weighs the same as duck ,she's made of wood";
    
    public static void main(String[] args) {
        
        Apply.process(new Upcase(),s);
        Apply.process(new Downcase(),s);
        Apply.process(new Spilitter(),s);
        
    }

    
}
