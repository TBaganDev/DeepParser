package ui.menu;

import main.App;

import java.awt.*;
import java.awt.event.ActionEvent;

public class FileMenu extends AbstractMenu {

    public FileMenu() {
        super("File");
    }

    @Override
    protected void define() {
        Menu open = new AbstractMenu("Open") {
            @Override
            protected void define() {
                MenuItem vanilla = new MenuItem("Vanilla Content");
                MenuItem mod = new MenuItem("Modded Content...");

                layout(vanilla, mod);
            }
        };
        MenuItem save = new MenuItem("Save");
        MenuItem saveAs = new MenuItem("Save As...");

        MenuItem settings = new MenuItem("Settings");
        MenuItem exit = new MenuItem("Exit");
        exit.addActionListener((ActionEvent e) -> {
            App.exit();
        });
        MenuItem refresh = new MenuItem("Reload Files");
        refresh.addActionListener((ActionEvent e) -> {
            App.getWindow().getTree().refresh();
        });
        layout(open, save, saveAs, null, refresh,  null, settings, exit);
    }
}
