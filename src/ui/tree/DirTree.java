package ui.tree;

import main.App;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.io.File;

public class DirTree extends JTree implements Runnable {
    private Node root;
    private DefaultTreeModel treeModel;

    {
        File file = new File(App.getMetaData().getPath() + "\\Content\\");

        if(!file.exists() || !file.isDirectory()) {
            file = new File("C:\\Program Files (x86)\\Steam\\steamapps\\common\\Barotrauma\\Content\\");
        }
        root = new Node(file);
        treeModel = new DefaultTreeModel(root);
    }

    public DirTree() {
        super();
        setModel(treeModel);
        setShowsRootHandles(true);

        setCellRenderer(new DefaultTreeCellRenderer() {
            @Override
            public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
                Component component = super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
                if(value instanceof Node) {
                    Node node = (Node) value;
                    Icon icon = App.getMetaData().getIcon(node);
                    if(icon != null) {
                        setIcon(icon);
                    }
                    setBackgroundNonSelectionColor(App.getMetaData().getTreeBackground());
                    setBackgroundSelectionColor(App.getMetaData().getViewBackground());
                    setTextNonSelectionColor(App.getMetaData().getForeground());
                    setTextSelectionColor(App.getMetaData().getDialogForeground());
                    setBorderSelectionColor(App.getMetaData().getDialogForeground());
                }

                return component;
            }
        });

        new Thread(this).start();
    }

    @Override
    public void run() {
        root.load();
        while(!App.isExited()) {
            refresh();
        }
    }

    public void refresh() {
        if(root.refresh()) {
            treeModel.reload();
        }
    }

    public void clear() {
        root.destroy();
    }
}
