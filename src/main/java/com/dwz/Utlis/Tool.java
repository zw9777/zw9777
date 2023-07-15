package com.dwz.Utlis;

import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class Tool {
    /*
    * 设置列宽
    * */
    public static void setColumnSize(JTable table, int i, int preferedWidth, int maxWidth, int minWidth) {
        /*
        * 表格的列模型
        * */
        TableColumnModel cm = table.getColumnModel();
        /*
        * 得到第i个列对象
        * */
        TableColumn column = cm.getColumn(i);
        column.setPreferredWidth(preferedWidth);
        column.setMaxWidth(maxWidth);
        column.setMinWidth(minWidth);
    }


    /*
    * 获取星期字符串
    * */
    public static String getWeek(char week) {
        switch (week) {
            case '1':
                return "周一";
            case '2':
                return "周二";
            case '3':
                return "周三";
            case '4':
                return "周四";
            case '5':
                return "周五";
        }
        return null;
    }

    public static String getPitch(char pitch) {
        switch (pitch) {
            case '1':
                return "[1-2]节";
            case '2':
                return "[3-4]节";
            case '3':
                return "[5-6]节";
            case '4':
                return "[7-8]节";
            case '5':
                return "[9-10]节";
        }
        return null;
    }

    /*
    * 转换密码为字符串
    * */
    public static String transitionPassword(char[] password) {
        String res = "";
        for (char ch : password) {
            res += ch;
        }
        return res;
    }
}
