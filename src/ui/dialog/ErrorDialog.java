package ui.dialog;

import main.App;
import ui.dialog.AbstractDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.net.URI;

public class ErrorDialog extends AbstractDialog {
    public ErrorDialog(Component parent, String text, boolean reportable) {
        super(parent, "Error!");
        exitOnClose();
        JButton button = new JButton("Copy Error and Report");
        button.setBackground(BACK);
        button.setForeground(App.getMetaData().getForeground());

        button.addActionListener((ActionEvent event) -> {
            StringSelection stringSelection = new StringSelection("### Context: \n *...please write what occurred here...* \n\n### Error Log: \n```\n"
                    + text + "\n```");
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);

            try {
                Desktop.getDesktop().browse(new URI("https://github.com/nullmaton/DeepParser/issues/new"));
            } catch (Exception e1) {
                button.setBackground(new Color(0,125,200));
                button.setText("Please goto the Website manually.");
            }
        });

        JTextArea label = new JTextArea(text);
        label.setBackground(BACK);
        label.setForeground(FORE);
        label.setOpaque(true);
        label.setLineWrap(true);
        label.setWrapStyleWord(true);
        label.setEditable(false);
        JScrollPane pane = new JScrollPane(label);
        pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(pane, BorderLayout.CENTER);

        if(reportable)
            add(button, BorderLayout.SOUTH);
        //add(label, BorderLayout.CENTER);

        setVisible(true);
    }
}
