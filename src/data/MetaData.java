package data;
import java.awt.*;
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
}
