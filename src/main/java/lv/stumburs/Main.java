package lv.stumburs;

import com.formdev.flatlaf.intellijthemes.FlatOneDarkIJTheme;
import lv.stumburs.app.App;

public class Main {
    public static void main(String[] args) {
        FlatOneDarkIJTheme.setup();
        new App(800, 600);
    }
}