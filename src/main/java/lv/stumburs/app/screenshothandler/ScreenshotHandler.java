package lv.stumburs.app.screenshothandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ScreenshotHandler {
    static public void TakeScreenshot() throws Exception {
        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage capture = new Robot().createScreenCapture(screenRect);

        File imageFile = new File("single-screen.png");
        ImageIO.write(capture, "png", imageFile );
        // assertTrue(imageFile .exists());
    }
}
