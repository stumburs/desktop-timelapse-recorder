package lv.stumburs.app.components;

import javax.swing.*;

public class TimeIntervalDropdown extends JComboBox<String> {
    String[] timeIntervals = {"ms", "s", "min", "h"};

    public TimeIntervalDropdown() {
        super();
        for (String interval : timeIntervals) {
            this.addItem(interval);
        }
        this.setSelectedItem("s"); // seconds
    }
}
