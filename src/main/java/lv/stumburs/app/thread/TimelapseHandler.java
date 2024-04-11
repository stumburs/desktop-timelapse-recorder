package lv.stumburs.app.thread;

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

        while (!Thread.interrupted()) {
            System.out.println("Screenshot taken");
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
