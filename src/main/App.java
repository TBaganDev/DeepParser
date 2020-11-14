package main;

import data.MetaData;
import ui.dialog.BinaryDialog;
import ui.dialog.ErrorDialog;

import javax.swing.*;
import java.awt.*;

public class App {
    private static Window window;
    private static MetaData meta = new MetaData();
    private static Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
    private static Boolean isExited = false;

    public static void main(String[] args) {

        //Displays the Window
        SwingUtilities.invokeLater(() -> {
            window = new Window(meta);
        });

        //Deals with any Runtime Errors
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            public void uncaughtException(Thread t, Throwable e) {
                StringBuilder builder = new StringBuilder("It seems you've encountered an error, sorry for any inconvenience caused. \n" +
                        "Please file this error message in https://github.com/nullmaton/DeepParser/issues/new, \n" +
                        "with context of what you were attempting before the error appeared.\n\n");
                builder.append("--- EXCEPTION TYPE ---\n");
                builder.append(e.getClass().getName());
                builder.append("\n\n--- ERROR MESSAGE ---\n");
                if(e.getMessage() == null) {
                    builder.append("N/A");
                } else {
                    builder.append(e.getMessage());
                }
                builder.append("\n\n--- STACK TRACE: ---\n");
                for(StackTraceElement trace : e.getStackTrace()) {
                    builder.append(trace);
                    builder.append('\n');
                }

                new ErrorDialog(window, builder.toString(), true);
            }
        });

    }

    public static Window getWindow() {
        return window;
    }

    public static Dimension getScreenDimension() {
        return screenDimension;
    }

    public static MetaData getMetaData() {
        return meta;
    }

    public static void dispose() { window.dispose();}


    public static void exit() {
        new BinaryDialog(window, "exit the program") {
            @Override
            public void run() {
                App.dispose();
                isExited = true;
            }
        };
    }

    public static boolean isExited() { return isExited; }
}
