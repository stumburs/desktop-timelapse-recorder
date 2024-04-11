package lv.stumburs.app.components;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.text.NumberFormat;

public class NumberInputField extends JFormattedTextField {
    NumberFormat format;
    NumberFormatter numberFormatter;

    public NumberInputField() {
        super();

        format = NumberFormat.getIntegerInstance();
        format.setGroupingUsed(false);

        numberFormatter = new NumberFormatter(format);
        numberFormatter.setValueClass(Long.class);
        numberFormatter.setAllowsInvalid(false);

        this.setFormatter(numberFormatter);
        this.setValue(10);
    }
}
