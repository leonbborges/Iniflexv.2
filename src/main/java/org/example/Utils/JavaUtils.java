package org.example.Utils;

import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class JavaUtils {
    public final static void clearConsole() throws Exception {
        try {
            Robot robbie = new Robot();
            robbie.keyPress(17); // Holds CTRL key.
            robbie.keyPress(76); // Holds L key.
            robbie.keyRelease(17); // Releases CTRL key.
            robbie.keyRelease(76); // Releases L key.
        } catch (AWTException ex) {
            Logger.getLogger(JavaUtils.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

