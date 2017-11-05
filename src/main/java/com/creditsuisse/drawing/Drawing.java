package com.creditsuisse.drawing;

import java.util.List;

// This is an interface to draw various shapes inside the canvas
public interface Drawing {

    // Method to draw the shape in the canvas
    public void draw();
    // Method to set the iput parameters of the given drawing
    public void setAttributes(List<String> inputParams);
    // This method validate the given drawing
    public boolean validate(List<String> inputParams);
    // Set Canvas object in the drawing.
    public void setCanvas(Canvas canvas);
}
