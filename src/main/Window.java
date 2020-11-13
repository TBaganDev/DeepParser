package main;

import data.MetaData;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private MetaData meta;
    private Container container;
    private MenuBar bar;
    private JSplitPane pane;
    private JPanel tree;
    private JPanel viewer;

    public Window(MetaData meta) {
        super("Deep Parser " + meta.getVersion());
        this.meta = meta;
        bar = new MenuBar();
        tree = new JPanel();
        viewer = new JPanel();
        pane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, tree, viewer);

        setVisible(true);
        setSize(500,500);
        setLayout(new BorderLayout());
        container = getContentPane();

        //Register Panels and SubFrame Components
        setMenuBar(bar);
        container.add(pane, BorderLayout.CENTER);

        //MenuBar Components
        Menu menu = new Menu("File");
        MenuItem base = new MenuItem("Open Base");
        MenuItem mod = new MenuItem("Open Mod");
        MenuItem settings = new MenuItem("Settings");
        menu.add(base);
        menu.add(mod);
        menu.addSeparator();
        menu.add(settings);
        bar.add(menu);

        //Tree Components

        //Viewer Components

        resetColors();
    }

    public void resetColors() {
        Color back = meta.getBackground();
        Color fore = meta.getForeground();
        Font font = meta.getFont();

        container.setBackground(back);
        container.setFont(font);
        viewer.setBackground(back);
        tree.setBackground(back);
    }
}
