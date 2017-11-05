How to execute the project?
Please copy the Drawing.jar at appropriate location.
Command to execute jar : java -cp Drawing.jar com.creditsuisse.DrawingApplication

Please enter valid commands mentioned under the requirement, you will get the appropriate result.

Assumtion: 

1. Bucket Fill : In example of the problem statement if the line drawn horizontal and vertical in that area also color is not getting filled as below :
enter command: B 10 3 o
----------------------
|oooooooooooooxxxxxoo|
|xxxxxxooooooox   xoo|
|     xoooooooxxxxxoo|
|     xoooooooooooooo|
----------------------
But according to Bucket fill functionality only the inside of rectangle only color must not fill so according to my program the out put of the above command should be below :
enter command: B 10 3 o
----------------------
|oooooooooooooxxxxxoo|
|xxxxxxooooooox   xoo|
|oooooxoooooooxxxxxoo|
|oooooxoooooooooooooo|
----------------------

2. Casesensetiveness : command can be lower or upper case. (C 20 4 and c 20 4 both should give the same result)

Sample out of the program :

H:\Urvin\CS\CS_Project\jar>java -cp Drawing.jar com.creditsuisse.DrawingApplication
:: Welcome to Drawing application ::
 1. Create a new Canvas.
 2. Start drawing on canvas by issuing various commands.
 3. Quit
Command          Description
 C w h           Should create a new canvas of width w and height h.
 L x1 y1 x2 y2   Should create a new line from (x1,y1) to (x2,y2). Currently only horizontal or vertical lines are supported.
 R x1 y1 x2 y2   Should create a new rectangle, whose upper left corner is (x1,y1) and lower right corner is (x2,y2).
 B x y c         Should fill the entire area connected to (x,y) with "colour" c.
 Q               Quit the program.
Enter Command : C 20 5
----------------------
|                    |
|                    |
|                    |
|                    |
|                    |
----------------------
Enter Command : L -1 2 -1 5
Invalid command, please enter valid command
Enter Command : L 1 2 6 2
----------------------
|                    |
|xxxxxx              |
|                    |
|                    |
|                    |
----------------------
Enter Command : l 6 -3 6 2
Invalid command, please enter valid command
Enter Command : l 6 3 6 5
----------------------
|                    |
|xxxxxx              |
|     x              |
|     x              |
|     x              |
----------------------
Enter Command : R -1 -2 -3 -4
Invalid command, please enter valid command
Enter Command : r 12 1 18 4
----------------------
|           xxxxxxx  |
|xxxxxx     x     x  |
|     x     x     x  |
|     x     xxxxxxx  |
|     x              |
----------------------
Enter Command : B -1 -1 o
Invalid command, please enter valid command
Enter Command : B 0 0 o
Invalid command, please enter valid command
Enter Command : B 1 1 o
----------------------
|oooooooooooxxxxxxxoo|
|xxxxxxooooox     xoo|
|oooooxooooox     xoo|
|oooooxoooooxxxxxxxoo|
|oooooxoooooooooooooo|
----------------------
Enter Command : q
