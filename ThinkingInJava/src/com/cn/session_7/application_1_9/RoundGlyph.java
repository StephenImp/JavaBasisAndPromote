package com.cn.session_7.application_1_9;

public class RoundGlyph extends Glyph {

    private int radius = 1;

    RoundGlyph(int r) {
        radius = r;
        System.out.println("RoundGlyph.RoundGlyph.radius = " + radius);
    }

    @Override
    void draw() {
        System.out.println("RoundGlyph.draw().radius = "+radius);
    }
}
