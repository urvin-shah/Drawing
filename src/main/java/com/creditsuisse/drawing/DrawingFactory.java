package com.creditsuisse.drawing;

import com.creditsuisse.util.StringUtil;

public class DrawingFactory {
    private static Drawing drawing;

    private static final String DRAW_LINE_COMMAND = "L";
    private static final String DRAW_RECTANGLE_COMMAND = "R";
    private static final String FILL_COLOR_COMMAND = "B";

    /**
     * This method will provide an instance of appropriate drawing, and in case of Q it will exit the system
     * @param drawingType
     * @return
     */
    public static Drawing getInstance(String drawingType) {
        if(StringUtil.isNotNull(drawingType)) {
            if(DRAW_LINE_COMMAND.equalsIgnoreCase(drawingType)) {
                return new Line();
            }
            if(DRAW_RECTANGLE_COMMAND.equalsIgnoreCase(drawingType)) {
                return new Rectangle();
            }
            if(FILL_COLOR_COMMAND.equalsIgnoreCase(drawingType)) {
                return new BucketFill();
            }
        }
        return null;
    }
}