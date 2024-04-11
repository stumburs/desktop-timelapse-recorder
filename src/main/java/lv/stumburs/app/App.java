package lv.stumburs.app;

import lv.stumburs.app.components.*;
import lv.stumburs.app.components.MenuBar;

import javax.swing.*;
import java.awt.*;

public class App {
    final int windowWidth;
    final int windowHeight;

    JFrame app;

    JLabel jLabel;

    JTextPane centerPanel;

    MenuBar menuBar;

    TimeIntervalDropdown timeIntervalsDropdown;

    // Number input
    NumberInputField numberInputField;
    JButton testButton;

    TakeScreenshotButton takeScreenshotButton;
    SelectOutputFolderButton selectOutputFolderButton;

    public App(int windowWidth, int windowHeight) {
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;

        takeScreenshotButton = new TakeScreenshotButton("Take screenshot");

        selectOutputFolderButton = new SelectOutputFolderButton("Select output folder");

        centerPanel = new JTextPane();
        centerPanel.setLayout(new FlowLayout());

        jLabel = new JLabel("Yes");

        menuBar = new MenuBar();

        timeIntervalsDropdown = new TimeIntervalDropdown();

        // Number input
        numberInputField = new NumberInputField();

        testButton = new JButton("Test");
        testButton.addActionListener(e -> System.out.println(numberInputField.getValue().toString() + timeIntervalsDropdown.getSelectedItem()));

        // App
        app = new JFrame();
        app.setTitle("Desktop Timelapse Recorder");
        app.setLayout(new BorderLayout());
        app.setSize(windowWidth, windowHeight);
        app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        app.setVisible(true);
        app.setJMenuBar(menuBar);

        // Add components

        // Center frame
        centerPanel.setFocusable(false);
        centerPanel.add(numberInputField);
        centerPanel.add(timeIntervalsDropdown);
        centerPanel.add(testButton);
        centerPanel.add(selectOutputFolderButton);
        centerPanel.add(takeScreenshotButton);

        // App frame
        app.add(centerPanel, BorderLayout.CENTER);
    }
}
