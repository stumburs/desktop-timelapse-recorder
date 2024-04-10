package lv.stumburs.app;

import lv.stumburs.app.screenshothandler.ScreenshotHandler;

import javax.swing.*;
import java.awt.*;

public class App {
    final int windowWidth;
    final int windowHeight;

    JFrame f;

    // JFileChooser fileChooser;

    JButton takeScreenshotButton;

    public App(int windowWidth, int windowHeight) {
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;

        f = new JFrame();
        f.setTitle("Desktop Timelapse Recorder");

        takeScreenshotButton = new JButton("Take screenshot");
        takeScreenshotButton.addActionListener(e -> {
            try {
                ScreenshotHandler.TakeScreenshot();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        // Add components
        f.add(takeScreenshotButton);

        f.setLayout(new FlowLayout());
        f.setSize(windowWidth, windowHeight);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setVisible(true);

/*        fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.showSaveDialog(null);

        System.out.println(fileChooser.getCurrentDirectory());
        System.out.println(fileChooser.getSelectedFile());*/
    }
}
