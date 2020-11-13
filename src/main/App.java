package main;

import data.MetaData;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Vector;

public class App {
    private static Window window;
    private static MetaData meta = new MetaData();

    public static void main(String[] args) {

        //Displays the Window
        SwingUtilities.invokeLater(() -> {
            window = new Window(meta);
        });

        //Deals with any Runtime Errors
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            public void uncaughtException(Thread t, Throwable e) {
                JFrame frame = new JFrame("Runtime Error");
                frame.setVisible(true);
                frame.setLayout(new BorderLayout());
                frame.setSize(500,500);

                Container container = frame.getContentPane();
                JButton button = new JButton("Copy Error and Report");
                button.setBackground(new Color(255, 125,0));


                StringBuilder builder = new StringBuilder();
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

                button.addActionListener((ActionEvent event) -> {
                    StringSelection stringSelection = new StringSelection("### Context: \n *...please write what occurred here...* \n\n### Error Log: \n```\n"
                            + builder.toString() + "\n```");
                    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                    clipboard.setContents(stringSelection, null);

                    try {
                        Desktop.getDesktop().browse(new URI("https://github.com/nullmaton/DeepParser/issues/new"));
                    } catch (Exception e1) {
                        button.setBackground(new Color(0,125,200));
                        button.setText("Please goto the Website manually.");
                    }

                });

                builder.append("\n\n");
                builder.append("It seems you've encountered an error, sorry for any inconvenience caused. \n" +
                        "Please file this error message in https://github.com/nullmaton/DeepParser/issues/new, \n" +
                        "with context of what you were attempting before the error appeared.");

                TextArea text = new TextArea(builder.toString());
                text.setEditable(false);
                container.add(text, BorderLayout.CENTER);
                container.add(button, BorderLayout.SOUTH);
            }
        });

    }
}
