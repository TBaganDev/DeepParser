package data;

import javax.swing.*;
import java.util.regex.Pattern;

public class IconMap {
    private Pattern pattern;
    private Icon icon;

    public IconMap(String regex, String name) {
        pattern = Pattern.compile(regex);
        icon = new ImageIcon("res/icons/" + name);
    }

    public boolean matches(String text) {
        return pattern.matcher(text).matches();
    }

    public Icon getIcon() {
        return icon;
    }
}
