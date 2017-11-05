package com.creditsuisse;

import com.creditsuisse.drawing.Canvas;
import com.creditsuisse.drawing.Graphics;
import com.creditsuisse.drawing.Line;
import com.creditsuisse.drawing.Drawing;
import com.creditsuisse.util.StringUtil;


import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * This is the main application class which is responsible for drawing.
 */
public class DrawingApplication {

    ResourceBundle resourceBundle;
    Logger logger = Logger.getLogger("DrawingApplication");
    private static final String QUIT_COMMAND = "Q";

    // Initialize the resourceBundle
    DrawingApplication() {
        this.resourceBundle = ResourceBundle.getBundle("message");
    }

    public static void main(String[] args) {
        DrawingApplication drawingApplication = new DrawingApplication();
        drawingApplication.init();
        drawingApplication.drawGrphics();
    }

    // This method accepts the command and draw it using the graphics methods.
    public void drawGrphics() {
        Graphics graphics = new Graphics(resourceBundle);
        Scanner scannerInput = new Scanner(System.in);
        while (true) {
            System.out.print("Enter Command : ");
            if (scannerInput != null) {
                String inputCommand = scannerInput.nextLine();
                if (inputCommand != null) {
                    if(!isQuitCommand(inputCommand)) {
                        if (graphics.setDrawing(inputCommand)) {
                            graphics.drawGraphics();
                        }
                    } else {
                        break;
                    }
                }
            }
        }
    }

    /**
     *  Initialize the resources.
     */
    private void init() {
        // Read welcome message and command description from the file an print it.
        if(resourceBundle != null) {
            System.out.println(resourceBundle.getString("welcomeMessage"));
            System.out.println(resourceBundle.getString("commandDesc"));
        }
    }

    private boolean isQuitCommand(String inputCommand) {
        if(StringUtil.isNotNull(inputCommand) && QUIT_COMMAND.equalsIgnoreCase(inputCommand)) {
            return true;
        }
        return false;
    }
}
