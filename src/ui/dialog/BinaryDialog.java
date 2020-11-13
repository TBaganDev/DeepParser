package ui.dialog;

import main.App;
import ui.dialog.AbstractDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public abstract class BinaryDialog extends AbstractDialog implements Runnable {


    public BinaryDialog(Component parent, String action) {
        super(parent, "Verification");
        setSize(200,100);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        JButton yes = new JButton("Yes");
        JButton no = new JButton("No");
        JTextArea label = new JTextArea("Are you sure you want to " + action + "?");
        label.setBackground(BACK);
        label.setForeground(FORE);
        label.setOpaque(true);
        label.setLineWrap(true);
        label.setWrapStyleWord(true);
        label.setEditable(false);
        add(label, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setBackground(BACK);
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(0,10,0,10);
        constraints.gridx=0;
        constraints.gridy=0;
        panel.add(yes, constraints);
        constraints.gridx=1;
        constraints.gridy=0;
        panel.add(no, constraints);
        add(panel, BorderLayout.SOUTH);
        yes.addActionListener((ActionEvent e) -> { run(); close(); });
        yes.setBackground(BACK);
        yes.setForeground(App.getMetaData().getForeground());
        no.addActionListener((ActionEvent e) -> { close(); });
        no.setBackground(BACK);
        no.setForeground(App.getMetaData().getForeground());
        setVisible(true);

    }
}
