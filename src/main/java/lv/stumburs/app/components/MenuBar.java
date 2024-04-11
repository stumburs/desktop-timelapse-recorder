package lv.stumburs.app.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;

public class MenuBar extends JMenuBar {
    JMenu fileMenu;
    JMenuItem exitMenuItem;
    JMenu helpMenu;
    JMenuItem aboutMenuItem;

    public MenuBar() {
        super();

        // File
        fileMenu = new JMenu("File");
        exitMenuItem = new JMenuItem("Exit");

        // Help
        helpMenu = new JMenu("Help");
        aboutMenuItem = new JMenuItem("About");

        exitMenuItem.addActionListener(e -> System.exit(0));
        aboutMenuItem.addActionListener(e -> {
            String creator = "stumburs";
            String version = "1.0";
            String githubLink = "https://github.com/stumburs/desktop-timelapse-recorder";
            String message = "<html><body>" +
                    "<h2>About</h2>" +
                    "<p>Created by: <b>" + creator + "</b> in collaboration with ChatGPT</p>" +
                    "<p>Version: " + version + "</p>" +
                    "<p>GitHub: <a href=\"" + githubLink + "\">" + githubLink + "</a></p>" +
                    "</body></html>";
            String title = "About";

            JLabel label = new JLabel(message);
            label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            label.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        Desktop.getDesktop().browse(new URI(githubLink));
                    } catch (Exception ex) {
                        String errorMessage = "<html><body>" +
                                "<h2>Couldn't open URL :(</h2>" +
                                "<p>" + ex.getMessage() + "</p>" +
                                "</body></html>";
                        JOptionPane.showMessageDialog(null, errorMessage, "Something went wrong...", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            JOptionPane.showMessageDialog(null, label, title, JOptionPane.INFORMATION_MESSAGE);
        });

        fileMenu.add(exitMenuItem);
        helpMenu.add(aboutMenuItem);

        this.add(fileMenu);
        this.add(helpMenu);
    }
}
