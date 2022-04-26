package apeexplorer;

import javafx.application.Application;

/**
 * Driver for the {@code OmegaApp} class.
 */
public class ApeExplorerDriver {

    /**
     * Main entry-point into the application.
     * @param args the command-line arguments.
     */
    public static void main(String[] args) {
        try {
            Application.launch(ApeExplorerApp.class, args);
        } catch (UnsupportedOperationException e) {
            e.printStackTrace();
            System.err.println();
            System.err.println(e);
            System.err.println("System Error. Possible bad Xserver connection.");
            System.exit(1);
        } catch (RuntimeException re) {
            re.printStackTrace();
            System.err.println();
            System.err.println(re);
            System.err.println("Runtime Exception. Check Backtrace");
            System.exit(1);
        } // try
    } // main

} // ApeExplorerDriver
