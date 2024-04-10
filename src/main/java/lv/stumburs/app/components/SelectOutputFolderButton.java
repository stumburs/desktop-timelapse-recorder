package lv.stumburs.app.components;

import lv.stumburs.app.screenshothandler.ScreenshotHandler;

import javax.swing.*;
import java.io.File;

public class SelectOutputFolderButton extends JButton {
    public SelectOutputFolderButton(String text) {
        super(text);
        addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Choose output directory");
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int choice = fileChooser.showOpenDialog(null);
            if (choice == JFileChooser.APPROVE_OPTION) {
                File directory = fileChooser.getSelectedFile();
                String destination = directory.getAbsolutePath();

                ScreenshotHandler.SetOutputDirectory(destination);
            }
        });
    }
}
