package com.creditsuisse.drawing;

import com.creditsuisse.constant.DrawingConstant;
import com.creditsuisse.util.StringUtil;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * This is Graphics class, DrawingApplication set Canvas and other drawings and finally render the graphics using the drawGraphics() method.
 */
public class Graphics {
    private Canvas canvas;

    private ResourceBundle resourceBundle;
    private static final String DRAW_CANVAS_COMMAND = "C";

    // Set the ResourceBundle object insude the Graphics
    public Graphics(ResourceBundle rs) {
        this.resourceBundle = rs;
    }

    /**
     * This method accepts the drawingCommand and set the appropriate drawing object and its values in the drawingCanvas
     * @param drawingCommand
     * @return
     */
    public boolean setDrawing(String drawingCommand) {
        if(StringUtil.isNotNull(drawingCommand)) {
            String[] cmdParams = drawingCommand.split(" ");
            List<String> attributes = null;

            if (DRAW_CANVAS_COMMAND.equalsIgnoreCase(cmdParams[0])) { // Draw Canvas
                canvas = new Canvas();
                attributes = getInputParams(cmdParams);
                if (canvas.validate(attributes)) {
                    canvas.setAttributes(attributes);
                    canvas.drawCanvas();
                } else {
                    canvas = null;
                    printInvalidCommand();
                    return false;
                }
            } else { // Draw drawings.
                Drawing drawing = DrawingFactory.getInstance(cmdParams[0]);
                if (drawing != null) {
                    attributes = getInputParams(cmdParams);
                    if (canvas != null) {
                        drawing.setCanvas(canvas);
                        if (drawing.validate(attributes)) {
                            drawing.setAttributes(attributes);
                            drawing.draw();
                        } else {
                            printInvalidCommand();
                            return false;
                        }
                    } else {
                        System.out.println(resourceBundle.getString(DrawingConstant.MESSAGE_CANVAS_NOT_CREATED));
                        return false;
                    }
                }
            }
        } else {
            printInvalidCommand();
            return false;
        }
        return true;
    }

    // This method is responsible to render the output.
    public void drawGraphics() {
        char[][] drawingCanvas = canvas.getDrawingCanvas();
        if(drawingCanvas != null) {
            for(int y=0;y<canvas.getHeight();y++) {
                for(int x=0;x<canvas.getWidth();x++) {
                    if(drawingCanvas[x][y] != 0) {
                        System.out.print(drawingCanvas[x][y]);
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println("");
            }
        }
    }

    // This method parse the input parameters and prepare the list.
    public List<String> getInputParams(String[] cmdInput) {
        List<String> inputParams = null;
        if(cmdInput != null && cmdInput.length > 1) {
            inputParams = new ArrayList<String>();
            for(int i=1;i<cmdInput.length;i++) {
                inputParams.add(cmdInput[i]);
            }
        }
        return inputParams;
    }

    // This will print message when invalid command applied.
    private void printInvalidCommand() {
        System.out.println(resourceBundle.getString(DrawingConstant.MESSAGE_INVALID_COMMAND));
    }
}