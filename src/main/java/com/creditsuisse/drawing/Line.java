package com.creditsuisse.drawing;

import java.util.List;

public class Line implements Drawing {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private Canvas canvas;

    // Resoponsible to draw the lines inside the canvas.
    @Override
    public void draw() {
        char[][] drawingCanvas = canvas.getDrawingCanvas();
        if(drawingCanvas != null) {
            for (int y = 0; y < y2; y++) {
                if (y >= (y1 - 1)) {
                    for (int x = 0; x <= x2; x++) {
                        if (x >= x1) {
                            drawingCanvas[(x - 2)][(y - 1)] = Canvas.DRAWING_CHAR;
                        }
                    }
                }
            }
        }
    }

    // Set attributes of the Line.
    @Override
    public void setAttributes(List<String> attributes) {
        if(attributes !=null && attributes.size() == 4) {
            int x1 = Integer.parseInt(attributes.get(0))+2;
            int y1 = Integer.parseInt(attributes.get(1))+2;
            int x2 = Integer.parseInt(attributes.get(2))+2;
            int y2 = Integer.parseInt(attributes.get(3))+2;
            this.x1 = Math.min(x1,x2);
            this.x2 = Math.max(x1,x2);
            this.y1 = Math.min(y1,y2);
            this.y2 = Math.max(y1,y2);
        }
    }

    // Validate the input parameters
    @Override
    public boolean validate(List<String> inputParams) {
        if(inputParams != null && inputParams.size() == 4) {
            int x1 = Integer.parseInt(inputParams.get(0))+2;
            int y1 = Integer.parseInt(inputParams.get(1))+2;
            int x2 = Integer.parseInt(inputParams.get(2))+2;
            int y2 = Integer.parseInt(inputParams.get(3))+2;
            if((x1 == x2 || y1 == y2) && (x1 <= canvas.getWidth() && x2 <= canvas.getWidth() && y1 <= canvas.getHeight()) && x1 > 2 && y1 >2 && x2 >2 && y2 > 2) {
                return true;
            }
        }
        return false;
    }

    // This method can be used to set the Canvas obkect.
    @Override
    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }
}