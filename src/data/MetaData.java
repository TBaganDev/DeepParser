package data;
import ui.tree.DirTree;
import ui.tree.Node;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;

public class MetaData {
    private Version baseVersion;
    private Version baroVersion;
    private LinkedList<String> authors;
    private Color foreground;
    private Color viewBackground;
    private Color treeBackground;
    private Color dialogForeground;
    private Color dialogBackground;
    private Color buttonForeground;
    private Font font;
    private String path;

    private IconMap[] iconMaps;
    private Icon emptyFolderIcon;
    private Icon projectFolderIcon;
    private Icon defaultFolderIcon;

    public MetaData() {
         baseVersion = new Version(0,0,0);
         baroVersion = new Version(0,0,0);
         authors = new LinkedList<>();
         foreground = new Color(255,255,255);
         viewBackground = new Color(47, 64, 68);
         treeBackground = new Color(32, 44, 47);
         dialogBackground = new Color(40, 40, 40);
         dialogForeground = new Color(230, 125, 0);
         font = new Font("TimesRoman", Font.PLAIN, 11);
         path = "C:\\Program Files (x86)\\Steam\\steamapps\\common\\Barotrauma";
         iconMaps = new IconMap[]{
                 new IconMap("^filelist\\.xml$", "src_xml_file"),
                 new IconMap("^.*\\.xml$","xml_file.png"),
                 new IconMap("^.*\\.png$", "image_file.png"),
                 new IconMap("^.*\\.sub$", "sub_file.png"),
                 new IconMap("^.*\\.ogg$","sound_file.png"),
                 new IconMap("^.*\\.xnb$","shader_file.png"),
                 new IconMap("^.*$", "file.png")
         };
         emptyFolderIcon = new ImageIcon("res/icons/folders/empty_folder.png");
         defaultFolderIcon= new ImageIcon("res/icons/folders/folder.png");
         projectFolderIcon = new ImageIcon("res/icons/folders/project_folder.png");
    }

    public Icon getIcon(Node node) {
        File file = node.getFile();
        if(file.isDirectory()) {
            if(node.isRoot()) {
                return projectFolderIcon;
            } else if(node.isLeaf()) {
                return emptyFolderIcon;
            } else {
                return defaultFolderIcon;
            }
        }
        for(IconMap map : iconMaps) {
            if(map.matches(file.getName())) {
                return map.getIcon();
            }
        }
        return null;
    }

    public String getCredits() {
        StringBuilder builder = new StringBuilder();
        Iterator<String> iterator = authors.iterator();

        while (iterator.hasNext()) {
            builder.append(iterator.next());
            builder.append('\n');
        }
        return builder.toString();
    }

    public Color getDialogForeground() { return dialogForeground; }

    public Color getDialogBackground() { return dialogBackground; }

    public Color getViewBackground() { return viewBackground; }

    public Color getTreeBackground() { return treeBackground; }

    public Color getForeground() { return foreground; }

    public Font getFont(){ return font; }

    public Version getBaroVersion() { return baroVersion; }

    public Version getVersion() { return baseVersion; }

    public String getPath() { return path; }
}
