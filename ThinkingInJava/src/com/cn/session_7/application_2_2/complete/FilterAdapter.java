package com.cn.session_7.application_2_2.complete;

public class FilterAdapter implements Processor {

    Filter filter;
    
    
    public FilterAdapter(Filter filter){
        this.filter = filter;
    }
    
    @Override
    public String name() {
        return filter.name();
    }

    @Override
    public Object process(Object input) {
        return filter.process((Waveform)input);
    }

}
