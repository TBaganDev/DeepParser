package ui.menu;

import ui.menu.item.WebsiteMenuItem;

import java.awt.*;

public class HelpMenu extends AbstractMenu {

    public HelpMenu() {
        super("Help");
    }

    @Override
    protected void define() {
        MenuItem github = new WebsiteMenuItem("Github Page", "https://github.com/nullmaton/DeepParser");
        MenuItem about = new MenuItem("About");
        MenuItem report = new WebsiteMenuItem("Report Issue", "https://github.com/nullmaton/DeepParser/issues/new");
        Menu barotrauma = new AbstractMenu("Barotrauma") {
            @Override
            protected void define() {
                MenuItem wiki = new WebsiteMenuItem("Wiki", "https://barotrauma.gamepedia.com/Barotrauma_Wiki");
                MenuItem discord = new WebsiteMenuItem("Discord", "https://discord.com/invite/undertow");
                MenuItem workshop = new WebsiteMenuItem("Workshop", "https://steamcommunity.com/workshop/browse/?appid=602960&browsesort=trend&section=readytouseitems");
                MenuItem website = new WebsiteMenuItem("Website", "https://barotraumagame.com/");
                layout(wiki, discord, workshop, website);
            }
        };

        layout(about, github, null, report, null, barotrauma);
    }
}
