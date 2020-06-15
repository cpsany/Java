package com.sandy.simulator;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.util.Hashtable;


public class DynamicTextSizeProcessor {

    private static final Hashtable hash = new Hashtable();
    Font font = new Font("Segoe Script", Font.PLAIN, 8);
    private LineBreakMeasurer lineBreakMeasurer;
    private int start, end;

    public static void main(String[] args) {
        Dimension d1 = new Dimension(120, 0);
        DynamicTextSizeProcessor rh = new DynamicTextSizeProcessor();
        rh.tryIfStringFits("How did you come to the conclusion that the main method has access to instance variables and methods",d1);
       // tryIfStringFits("sandeep",d1);

    }

    public boolean tryIfStringFits(String textToMeasure, Dimension areaToFit) {
        AttributedString attributedString = new AttributedString(textToMeasure, hash);
        attributedString.addAttribute(TextAttribute.FONT, font);
        AttributedCharacterIterator attributedCharacterIterator =
                attributedString.getIterator();
        start = attributedCharacterIterator.getBeginIndex();
        end = attributedCharacterIterator.getEndIndex();

        lineBreakMeasurer = new LineBreakMeasurer(attributedCharacterIterator,
                new FontRenderContext(null, false, false));

        float width = (float) areaToFit.width;
        float height = 0;
        lineBreakMeasurer.setPosition(start);

        while (lineBreakMeasurer.getPosition() < end) {
            TextLayout textLayout = lineBreakMeasurer.nextLayout(width);
            height += textLayout.getAscent();
            height += textLayout.getDescent() + textLayout.getLeading();
        }

        boolean res = height <= areaToFit.getHeight();
        System.out.println(height);
        return res;
    }
}
