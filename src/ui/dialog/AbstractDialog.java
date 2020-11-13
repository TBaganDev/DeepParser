package ui.dialog;

import main.App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public abstract class AbstractDialog extends JDialog {
    protected static final Color BACK = App.getMetaData().getDialogBackground();
    protected static final Color FORE = App.getMetaData().getDialogForeground();

    public AbstractDialog(Component parent, String title) {
        super((Dialog) null, title, true);
        setSize(400, 300);
        setLayout(new BorderLayout());
        setLocationRelativeTo(parent);
        setResizable(false);
    }
    public void exitOnClose() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                App.dispose();
                dispose();
            }
        });
    }
    public void close() {
        setVisible(false);
        dispose();
    }
}
