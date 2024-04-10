package lv.stumburs.app.components;

import lv.stumburs.app.screenshothandler.ScreenshotHandler;

import javax.swing.*;

public class TakeScreenshotButton extends JButton {
    public TakeScreenshotButton(String text) {
        super(text);
        addActionListener(e -> {
            try {
                ScreenshotHandler.TakeScreenshot();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
    }
}
