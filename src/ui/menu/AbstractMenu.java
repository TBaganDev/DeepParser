package ui.menu;

import javax.swing.*;
import java.awt.*;
import java.net.URI;
import java.util.LinkedList;

public abstract class AbstractMenu extends Menu {
    public AbstractMenu(String title) {
        super(title);
        define();
    }

    /**
     *  Performs a series of add(...) and addSeparator() to display the sub menus options.
     *
     *  A null argument indicates a separator at the given position.
     * @param menus
     */
    protected void layout(MenuItem... menus) {
        for(MenuItem menu : menus) {
            if(menu == null) {
                addSeparator();
            } else {
                add(menu);
            }
        }
    }

    /**
     *  Defines all menus and their properties.
     */
    protected abstract void define();
}
