package lv.stumburs.app;

import lv.stumburs.app.components.*;
import lv.stumburs.app.components.MenuBar;
import lv.stumburs.app.thread.TimelapseHandler;

import javax.swing.*;
import java.awt.*;
import java.time.Duration;

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
    JButton startThreadButton;
    JButton stopThreadButton;

    TimelapseHandler timelapseHandler;

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

        startThreadButton = new JButton("Start Thread");
        startThreadButton.addActionListener(e -> {
            timelapseHandler = new TimelapseHandler(calculateIntervalDuration());
            timelapseHandler.start();
        });
        stopThreadButton = new JButton("Stop Thread");
        stopThreadButton.addActionListener(e -> timelapseHandler.interrupt());

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
        centerPanel.add(numberInputField);
        centerPanel.add(timeIntervalsDropdown);
        centerPanel.add(testButton);
        centerPanel.add(startThreadButton);
        centerPanel.add(stopThreadButton);
        centerPanel.add(selectOutputFolderButton);
        centerPanel.add(takeScreenshotButton);
        centerPanel.setEditable(false);
        centerPanel.setFocusable(false);

        // App frame
        app.add(centerPanel, BorderLayout.CENTER);
    }


    private Duration calculateIntervalDuration() {
        Object selectedItem = timeIntervalsDropdown.getSelectedItem();
        if (selectedItem == null) {
            throw new IllegalStateException("Selected item is null.");
        }

        long value;
        try {
            value = Long.parseLong(numberInputField.getText());
        } catch (NumberFormatException e) {
            throw new IllegalStateException("Invalid value in number input field.", e);
        }

        return switch (selectedItem.toString()) {
            case "ms" -> Duration.ofMillis(value);
            case "s" -> Duration.ofSeconds(value);
            case "min" -> Duration.ofMinutes(value);
            case "h" -> Duration.ofHours(value);
            default -> throw new IllegalStateException("Unexpected value: " + selectedItem);
        };
    }
}
