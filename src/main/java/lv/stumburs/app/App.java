package lv.stumburs.app;

import lv.stumburs.app.components.SelectOutputFolderButton;
import lv.stumburs.app.components.TakeScreenshotButton;

import javax.swing.*;
import java.awt.*;

public class App {
    final int windowWidth;
    final int windowHeight;

    JFrame f;

    TakeScreenshotButton takeScreenshotButton;
    SelectOutputFolderButton selectOutputFolderButton;

    public App(int windowWidth, int windowHeight) {
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;

        f = new JFrame();
        f.setTitle("Desktop Timelapse Recorder");

        takeScreenshotButton = new TakeScreenshotButton("Take screenshot");

        selectOutputFolderButton = new SelectOutputFolderButton("Select output folder");

        f.setLayout(new BorderLayout());
        f.setSize(windowWidth, windowHeight);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setVisible(true);

        // Add components
        f.add(takeScreenshotButton, BorderLayout.SOUTH);
        f.add(selectOutputFolderButton, BorderLayout.CENTER);
    }
}
