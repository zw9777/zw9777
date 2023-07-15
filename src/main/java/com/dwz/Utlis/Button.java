package com.dwz.Utlis;

import javax.swing.*;
import java.awt.*;

public class Button extends JFrame {
    /*
    * 设置菜单按钮*/
    public JButton getButton (String text,String img){
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource(img));
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(28,28, Image.SCALE_DEFAULT));
        Font font = new Font("行书",Font.LAYOUT_LEFT_TO_RIGHT,16);
        JButton jbt1 = new JButton(text,imageIcon);
        jbt1.setFont(font);
        /*
        *无边框*/
        jbt1.setBorderPainted(false);
        /*
        * 文字与图片垂直对齐*/
        jbt1.setVerticalTextPosition(SwingConstants.BOTTOM);
        /*
        * 点击变成手型
        * */
        jbt1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return jbt1;
    }
}
