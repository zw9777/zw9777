package com.dwz.Utlis;

import java.awt.*;

public class replacementPanel {

    /*
    * 重画面板，全部清除*/
    public void replacement(Container change, Container res) {
        change.removeAll();
        change.add(res);
        change.validate();
        change.repaint();
    }
}
