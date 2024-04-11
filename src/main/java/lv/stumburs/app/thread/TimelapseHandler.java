package lv.stumburs.app.thread;

import lv.stumburs.app.screenshothandler.ScreenshotHandler;

import java.time.Duration;

public class TimelapseHandler extends Thread {

    Duration interval;

    public TimelapseHandler(Duration interval) {
        super();
        this.interval = interval;
    }

    @Override
    public void run() {
        System.out.println("Timelapse thread started with interval: " + interval);

        ScreenshotHandler.reset();

        while (!Thread.interrupted()) {
            try {
                ScreenshotHandler.TakeScreenshot();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                System.out.println("Timelapse thread interrupted");
                return;
            }
        }
        System.out.println("Timelapse thread exited");
    }
}
