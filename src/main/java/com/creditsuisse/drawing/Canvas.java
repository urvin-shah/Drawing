package com.creditsuisse.drawing;

import java.util.ArrayList;
import java.util.List;

public class Canvas {
    private int height;
    private int width;
    private char[][] drawingCanvas;
    private static final char HORIZONTAL_CHAR = '-';
    private static final char VERTICAL_CHAR = '|';
    public static final char DRAWING_CHAR = 'x';
    public static final char EMPTY_CHAR = ' ';

    /**
     * This method validate the Canvas input parameters
     * @param inputParams
     * @return
     */
    public boolean validate(List<String> inputParams) {
        if(inputParams != null && inputParams.size() == 2) {
            int width = Integer.parseInt(inputParams.get(0));
            int height = Integer.parseInt(inputParams.get(1));
            if(height > 0 && width >0) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method set the attributes of Canvas
     * @param attributes
     */
    public void setAttributes(List<String> attributes) {
        if(attributes !=null && attributes.size() ==2) {
            width = Integer.parseInt(attributes.get(0))+2;
            height =Integer.parseInt(attributes.get(1))+2;
            drawingCanvas = new char[width][height];
        }
    }

    // Method to prepare the drawCanvas object based on the width and height
    public void drawCanvas() {
        if(drawingCanvas != null) {
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    if (y == 0 || y == (height - 1)) {
                        drawingCanvas[x][y] = HORIZONTAL_CHAR;
                    } else if (x == 0 || x == (width - 1)) {
                        drawingCanvas[x][y] = VERTICAL_CHAR;
                    }
                }
            }
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public char[][] getDrawingCanvas() {
        return drawingCanvas;
    }
}