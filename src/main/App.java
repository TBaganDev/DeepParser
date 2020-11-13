package main;

import data.MetaData;

import javax.swing.*;
import java.util.Vector;

public class App {
    private static Window window;
    private static MetaData meta = new MetaData();

    public static void main(String[] args) {

        //Displays the Window
        SwingUtilities.invokeLater(() -> {
            window = new Window(meta);
        });
    }
}
