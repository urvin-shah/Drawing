package com.creditsuisse.drawing;

import java.util.List;

public class BucketFill implements Drawing {
    private int x;
    private int y;
    private char color;
    private Canvas canvas;

    /**
     * This method validate the input parameters of the BucketFill Command.
     * @param inputParams
     * @return
     */
    @Override
    public boolean validate(List<String> inputParams) {
        if(inputParams != null && inputParams.size() == 3) {
            int x = Integer.parseInt(inputParams.get(0))+2;
            int y = Integer.parseInt(inputParams.get(1))+2;
            char color = inputParams.get(2).charAt(0);
            if(color != 0 && x <= canvas.getWidth() && y<=canvas.getHeight() && x>2 && y>2) {
                return true;
            }
        }
        return false;
    }

    // This method fill the bucket by given color supplied in the command
    @Override
    public void draw() {
        char[][] drawingCanvas = canvas.getDrawingCanvas();
        if(drawingCanvas != null) {
            for(int y=0;y<canvas.getHeight();y++) {
                for(int x=0;x<canvas.getWidth();x++) {
                    if(drawingCanvas[x][y] == 0) {
                        drawingCanvas[x][y] = color;
                    }
                }
            }
        }
    }

    /**
     * This method set the attributes of the BucketFill class.
     * @param inputParams
     */
    @Override
    public void setAttributes(List<String> inputParams) {
        if(inputParams != null && inputParams.size() == 3) {
            this.x = Integer.parseInt(inputParams.get(0))+2;
            this.y = Integer.parseInt(inputParams.get(1))+2;
            this.color = inputParams.get(2).charAt(0);
        }
    }

    // This method set the Canvas object in the BucketFill Class.
    @Override
    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }
}
