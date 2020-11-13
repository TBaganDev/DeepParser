package ui.menu.item;

import main.App;
import ui.dialog.ErrorDialog;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URI;

public class WebsiteMenuItem extends MenuItem {
    public WebsiteMenuItem(String title, String url) {
        super(title);
        addActionListener((ActionEvent a) -> {
            try {
                Desktop.getDesktop().browse(new URI(url));
            } catch (Exception e) {
                new ErrorDialog(App.getWindow(),"Couldn't open browser and connect to: " + url + ".", false);
            }
        });
    }
}
