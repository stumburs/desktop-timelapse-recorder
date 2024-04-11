package lv.stumburs.app;

import lv.stumburs.app.components.MenuBar;
import lv.stumburs.app.components.SelectOutputFolderButton;
import lv.stumburs.app.components.TakeScreenshotButton;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.text.NumberFormat;

public class App {
    final int windowWidth;
    final int windowHeight;

    JFrame app;

    JLabel jLabel;

    JTextPane centerPanel;

    MenuBar menuBar;

    String[] timeIntervals = {"ms", "s", "min"};
    JComboBox<String> timeIntervalsDropdown;

    // Number input
    NumberFormat format;
    NumberFormatter numberFormatter;
    JFormattedTextField numberInputField;
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

        timeIntervalsDropdown = new JComboBox<>(timeIntervals);
        timeIntervalsDropdown.setSelectedIndex(1); // seconds

        // Number input
        format = NumberFormat.getIntegerInstance();
        format.setGroupingUsed(false);

        numberFormatter = new NumberFormatter(format);
        numberFormatter.setValueClass(Long.class);
        numberFormatter.setAllowsInvalid(false);

        numberInputField = new JFormattedTextField(numberFormatter);
        numberInputField.setValue(10);

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
