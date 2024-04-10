package lv.stumburs.app.screenshothandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ScreenshotHandler {

    private static String outputDirectory;

    static public void TakeScreenshot() throws Exception {
        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage capture = new Robot().createScreenCapture(screenRect);

        File imageFile;
        if (outputDirectory == null) {
            imageFile = new File("capture.png");
        } else {
            imageFile = new File(outputDirectory + "/capture.png");
        }

        System.out.println("Image saved to: " + outputDirectory);
        ImageIO.write(capture, "png", imageFile);
    }

    public static void SetOutputDirectory(String destination) {
        outputDirectory = destination;
    }
}
