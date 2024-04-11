package lv.stumburs.app.screenshothandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Paths;
import java.util.Objects;

public class ScreenshotHandler {

    private static String outputDirectory;
    private static long screenshotCount = 1;

    static public void TakeScreenshot() throws Exception {
        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage capture = new Robot().createScreenCapture(screenRect);

        File newFolder;
        newFolder = new File(Objects.requireNonNullElseGet(outputDirectory, () -> Paths.get(".").toAbsolutePath().normalize()) + "/screenshots");

        if (!newFolder.exists()) {
            if (!newFolder.mkdirs()) {
                throw new Exception("Failed to create directory");
            }
        }

        File imageFile = new File(newFolder + "/capture"+screenshotCount+".png");
        screenshotCount++;

        System.out.println("Image saved to: " + newFolder.getAbsolutePath());
        ImageIO.write(capture, "png", imageFile);
    }

    public static void SetOutputDirectory(String destination) {
        outputDirectory = destination;
    }

    public static void reset() {
        screenshotCount = 1;
    }
}
