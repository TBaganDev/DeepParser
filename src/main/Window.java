package main;

import data.MetaData;
import ui.menu.EditMenu;
import ui.menu.FileMenu;
import ui.menu.HelpMenu;
import ui.menu.ViewMenu;
import ui.tree.DirTree;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private MetaData meta;
    private Container container;
    private MenuBar bar;
    private JSplitPane pane;
    private JScrollPane treeScroll;
    private JScrollPane viewerScroll;
    private DirTree tree;
    private JPanel viewer;

    public Window(MetaData meta) {
        super("Deep Parser " + meta.getVersion());
        this.meta = meta;
        bar = new MenuBar();
        tree = new DirTree();
        viewer = new JPanel();
        treeScroll = new JScrollPane(tree);
        viewerScroll = new JScrollPane(viewer);
        pane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, treeScroll, viewerScroll);

        //Setup Window properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setVisible(true);
        //setSize(App.getScreenDimension().width/2, App.getScreenDimension().height);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new BorderLayout());
        container = getContentPane();

        //Register Panels and SubFrame Components
        setMenuBar(bar);
        container.add(pane, BorderLayout.CENTER);
        pane.setDividerLocation(300);
        viewerScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        treeScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        treeScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);


        //MenuBar Components
        loadMenus();

        //Tree Components
        loadTree();

        //Viewer Components
        loadViewer();

        resetColors();
    }

    public DirTree getTree() {
        return tree;
    }

    private void loadMenus() {
        bar.add(new FileMenu());
        bar.add(new EditMenu());
        bar.add(new ViewMenu());
        bar.setHelpMenu(new HelpMenu());
    }

    private void loadTree() {

    }

    private void loadViewer() {

    }

    public void resetColors() {
        Color fore = meta.getForeground();
        Font font = meta.getFont();

        container.setBackground(meta.getViewBackground());
        container.setFont(font);
        viewer.setBackground(meta.getViewBackground());
        tree.setBackground(meta.getTreeBackground());
    }
}
