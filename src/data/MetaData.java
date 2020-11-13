package data;
import java.awt.*;
import java.util.Iterator;
import java.util.LinkedList;

public class MetaData {
    private Version baseVersion;
    private Version baroVersion;
    private LinkedList<String> authors;
    private Color background;
    private Color foreground;
    private Font font;

    public MetaData() {
         baseVersion = new Version(0,0,0);
         baroVersion = new Version(0,0,0);
         authors = new LinkedList<>();
         foreground = new Color(255,255,255);
         background = new Color(47, 64, 68);
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

    public Color getBackground() { return background; }

    public Color getForeground() { return foreground; }

    public Font getFont(){ return font; }

    public Version getBaroVersion() { return baroVersion; }

    public Version getVersion() { return baseVersion; }
}
