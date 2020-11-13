package main;

import data.MetaData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(500,500);
        setLayout(new BorderLayout());
        container = getContentPane();


        //Register Panels and SubFrame Components
        setMenuBar(bar);
        container.add(pane, BorderLayout.CENTER);

        //MenuBar Components
        loadMenus();

        //Tree Components
        loadTree();

        //Viewer Components
        loadViewer();

        resetColors();
    }

    private void loadMenus() {
        Menu fileMenu = new Menu("File");
        MenuItem base = new MenuItem("Open Base");
        MenuItem mod = new MenuItem("Open Mod");
        MenuItem settings = new MenuItem("Settings");

        base.addActionListener((ActionEvent e) -> {
            int[] test = new int[-1];
        });
        fileMenu.add(base);
        fileMenu.add(mod);
        fileMenu.addSeparator();
        fileMenu.add(settings);
        Menu helpMenu = new Menu("Help");
        bar.add(fileMenu);
        bar.add(helpMenu);
    }

    private void loadTree() {

    }

    private void loadViewer() {

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
