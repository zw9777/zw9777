package com.dwz.View;

import com.dwz.Pojo.Grade;
import com.dwz.Pojo.Teacher;
import com.dwz.Pojo.TeacherPlan;
import com.dwz.Service.StudentService;
import com.dwz.Service.TeacherService;
import com.dwz.Utlis.Button;
import com.dwz.Utlis.Tool;
import com.dwz.Utlis.replacementPanel;
import sun.swing.table.DefaultTableCellHeaderRenderer;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TeacherView extends JFrame {
    Teacher teacher;
    /*
    * 首页*/
    public JPanel getTeacherhome() {
        JPanel jpHome = new JPanel();
        JTextArea textArea = new JTextArea();
        String text = teacher.getT_name();
        text += "老师：欢迎使用佛山科学技术学院教务管理系统！";

        ImageIcon imageIcon = new ImageIcon("/Users/weizhendeng/work-space/EMS/src/main/resources/img/新功能预测.png");
        JLabel jLabel = new JLabel(imageIcon);
        Dimension dimension = new Dimension(800, 500);
        jLabel.setPreferredSize(dimension);

        textArea.setText(text);
        textArea.setFont(new Font("黑体", 1, 30));
        jpHome.add(textArea);
        jpHome.add(jLabel,BorderLayout.NORTH);
        return jpHome;
    }
    /*
    * 主页*/
    public JPanel getTeacherhome1() {
        JPanel jpHome = new JPanel();
        JTextArea textArea = new JTextArea();
        String text = teacher.getT_name();
        text += "老师：欢迎使用佛山科学技术学院教务管理系统！";
        textArea.setText(text);
        textArea.setFont(new Font("黑体", 1, 30));
        jpHome.add(textArea);
        return jpHome;
    }


    public TeacherView(Teacher teacher) {
        super("佛山科学技术学院教务管理系统");
        this.teacher = teacher;
        Container cp = this.getContentPane();
        cp.setLayout(new BorderLayout());
        JButton jbtHome = new Button().getButton("首页", "img/shouyefill.png");
        JButton jbtArrangement = new Button().getButton("教学安排", "img/mianshoujiaoxueanpai.png");
        JButton jbtGradeinput = new Button().getButton("成绩录入", "img/chengjiluru.png");
        JButton jbtUser = new Button().getButton("个人中心", "img/laoshi.png");
        JPanel bar = new JPanel();
        bar.add(jbtHome);
        bar.add(jbtArrangement);
        bar.add(jbtGradeinput);
        bar.add(jbtUser);
        JPanel mid = getTeacherhome();
        cp.add(bar, BorderLayout.NORTH);
        cp.add(mid, BorderLayout.CENTER);
        this.setSize(800, 650);
        //居中
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jbtHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new replacementPanel().replacement(mid,getTeacherhome1());
            }
        });
        jbtArrangement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new replacementPanel().replacement(mid,getArrangement());
            }
        });
        jbtGradeinput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new replacementPanel().replacement(mid,getGradeinput());
            }
        });
        jbtUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new replacementPanel().replacement(mid,getUser());
            }
        });
    }
    /*
    * 得到教学计划
    * */
    public JPanel getArrangement() {
        JPanel arrangement = new JPanel(new BorderLayout());
        class TableViewRenderer extends JTextArea implements TableCellRenderer {
            public TableViewRenderer() {
                /*
                * 将表格设为自动换行*/
                setLineWrap(true);
                setWrapStyleWord(true);
            }
            /*
            * obj是单元格内*/
            public Component getTableCellRendererComponent(JTable jtable, Object obj,
                                                           boolean isSelected, boolean hasFocus,
                                                           int row, int column) {
                setText(obj == null ? "" : obj.toString());
                /*
                * 利用JTextArea的setText设置文本方法*/
                return this;
            }
        }
        JPanel top = new JPanel();
        JLabel jlYear = new JLabel("学年:");
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.addItem("--请选择--");
        java.util.List<String> year = new StudentService().getYear();
        for (String str : year) {
            comboBox.addItem(str);
        }
        JButton jbtSelect = new JButton("查询");
        top.add(jlYear);
        top.add(comboBox);
        top.add(jbtSelect);
        arrangement.add(top, BorderLayout.NORTH);
        /*
        * 不可编辑表格内容*/
        JTable table = new JTable() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JScrollPane tab = new JScrollPane(table);
        /*
        * 表格内容居中*/
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();//单元格渲染器
        TableViewRenderer tableViewRenderer = new TableViewRenderer();
        tableViewRenderer.setPreferredSize(new Dimension(50, 75));
        tableViewRenderer.setBackground(new Color(211, 211, 211));
        table.setDefaultRenderer(Object.class, tableViewRenderer);
        /*
        * 表格表头居中*/
        DefaultTableCellHeaderRenderer hr = new DefaultTableCellHeaderRenderer();
        hr.setHorizontalAlignment(JLabel.CENTER);
        hr.setPreferredSize(new Dimension(50, 78));
        table.getTableHeader().setDefaultRenderer(hr);
        /*
        * 设置面板大小*/
        tab.setPreferredSize(new Dimension(750, 472));
        /*
        * 设置透明*/
        tab.setOpaque(false);
        tab.getViewport().setOpaque(false);
        arrangement.add(tab, BorderLayout.CENTER);
        jbtSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object cp_year = comboBox.getSelectedItem();
                List<TeacherPlan> teachingplan = new TeacherService().GetTeacherPlan(teacher.getT_id(), (String) cp_year);
                Object[][] tableDate = new Object[5][6];
                tableDate[0][0] = "\n\n          1-2节";
                tableDate[1][0] = "\n\n          3-4节";
                tableDate[2][0] = "\n\n          5-6节";
                tableDate[3][0] = "\n\n          7-8节";
                tableDate[4][0] = "\n\n          9-10节";
                for (int i = 0; i < 5; i++) {
                    for (int j = 1; j < 6; j++) {
                        tableDate[i][j] = "";
                    }
                }
                String[] name = {" ", "周一", "周二", "周三", "周四", "周五"};
                for (int i = 0; i < teachingplan.size(); i++) {
                    String res;
                    String tc_time = teachingplan.get(i).getTc_time();
                    //获得最终上课时间与地点
                    String[] res_time = tc_time.split(" ");
                    for (int j = 0; j < res_time.length; j++) {
                        int week = res_time[j].charAt(0) - '0';
                        int section = res_time[j].charAt(2) - '0';
                        res = "\n  " + teachingplan.get(i).getTc_name() + "\n  " + teachingplan.get(i).getTc_point();
                        tableDate[section - 1][week] = res;
                    }
                }
                table.removeAll();
                DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
                tableModel.setRowCount(0);
                tableModel.setColumnIdentifiers(name);
                for (int i = 0; i < 5; i++) {
                    tableModel.addRow(tableDate[i]);
                }
                table.setRowHeight(78);
                table.setModel(tableModel);    //应用表格模型
            }
        });
        return arrangement;
    }
    /*
    * 成绩录入
    * */
    public JPanel getGradeinput() {
        JPanel gradeInput = new JPanel(new BorderLayout());
        JPanel top = new JPanel();
        JLabel jlYear = new JLabel("学年:");
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.addItem("--请选择--");    //向下拉列表中添加一项
        java.util.List<String> year = new StudentService().getYear();
        for (String str : year) {
            comboBox.addItem(str);
        }
        JLabel jlClass = new JLabel("教学班级:");
        JComboBox<String> cmbClass = new JComboBox<>();
        cmbClass.addItem("--请选择--");
        JButton jbtSelect = new JButton("查询");
        JButton jbtSubmit = new JButton("提交");
        top.add(jbtSubmit);
        top.add(jlYear);
        top.add(comboBox);
        top.add(jlClass);
        top.add(cmbClass);
        top.add(jbtSelect);
        gradeInput.add(top, BorderLayout.NORTH);
        JTable table = new JTable();
        JScrollPane tab = new JScrollPane(table);
        //表格内容居中
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();//单元格渲染器
        tcr.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, tcr);
        //表格表头居中
        DefaultTableCellHeaderRenderer hr = new DefaultTableCellHeaderRenderer();
        hr.setHorizontalAlignment(JLabel.CENTER);
        hr.setPreferredSize(new Dimension(25, 25));
        table.getTableHeader().setDefaultRenderer(hr);
        //设置面板大小
        tab.setPreferredSize(new Dimension(600, 500));
        //设置透明
        tab.setOpaque(false);
        tab.getViewport().setOpaque(false);
        gradeInput.add(tab, BorderLayout.CENTER);
        JPanel bottom = new JPanel();
        gradeInput.add(bottom, BorderLayout.SOUTH);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object cp_year = comboBox.getSelectedItem();
                List<TeacherPlan> teachingplan = new TeacherService().GetTeacherPlan(teacher.getT_id(), (String) cp_year);
                cmbClass.removeAllItems();
                if (teachingplan.size() == 0)
                    cmbClass.addItem("无对应教学班级");
                else {
                    for (int i = 0; i < teachingplan.size(); i++) {
                        cmbClass.addItem(teachingplan.get(i).getTc_name());
                    }
                }
            }
        });
        jbtSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object className = cmbClass.getSelectedItem();
                List<Grade> gradebyClass = new TeacherService().GetGradeByClass((String) className);
                Object[][] tableDate = new Object[gradebyClass.size()][5];
                for (int i = 0; i < gradebyClass.size(); i++) {
                    for (int j = 0; j < 5; j++) {
                        if (j == 0)
                            tableDate[i][j] = gradebyClass.get(i).getS_id();
                        else if (j == 1)
                            tableDate[i][j] = gradebyClass.get(i).getS_name();
                        else if (j == 2)
                            tableDate[i][j] = gradebyClass.get(i).getG_ps();
                        else if (j == 3)
                            tableDate[i][j] = gradebyClass.get(i).getG_exam();
                        else
                            tableDate[i][j] = gradebyClass.get(i).getG_final();
                    }
                }
                String[] name = {"学号", "姓名", "平时成绩", "考试成绩", "总成绩"};
                table.removeAll();
                DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
                tableModel.setRowCount(0);
                tableModel.setColumnIdentifiers(name);
                for (int i = 0; i < gradebyClass.size(); i++) {
                    tableModel.addRow(tableDate[i]);
                }
                table.setRowHeight(30);
                table.setModel(tableModel);
            }
        });
        JFrame jf = this;

        jbtSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                List<Grade> grades = new ArrayList<>();
                Object className = cmbClass.getSelectedItem();
                for (int i = 0; i < table.getRowCount(); i++) {
                    Grade grade = new Grade();
                    for (int j = 0; j < table.getColumnCount(); j++) {
                        if (j == 0)
                            grade.setS_id((String) table.getValueAt(i, j));
                        else if (j == 2)
                            grade.setG_ps(Double.valueOf(table.getValueAt(i, j).toString()));
                        else if (j == 3)
                            grade.setG_exam(Double.valueOf(table.getValueAt(i, j).toString()));
                        else if (j == 4) {
                            Double res;
                            res = Double.valueOf(table.getValueAt(i, 2).toString())+
                                    Double.valueOf(table.getValueAt(i, 3).toString());
                            grade.setG_final(res);
                        } else
                            continue;
                    }
                    grades.add(grade);
                }
                if (new TeacherService().updateGrade(grades, (String) className)) {
                    JOptionPane.showMessageDialog(jf, "成绩录入成功", "提示", JOptionPane.PLAIN_MESSAGE);
                    /*
                    * 重新进行表格渲染*/
                    List<Grade> gradebyClass = new TeacherService().GetGradeByClass((String) className);
                    Object[][] tableDate = new Object[gradebyClass.size()][5];
                    for (int i = 0; i < gradebyClass.size(); i++) {
                        for (int j = 0; j < 5; j++) {
                            if (j == 0)
                                tableDate[i][j] = gradebyClass.get(i).getS_id();
                            else if (j == 1)
                                tableDate[i][j] = gradebyClass.get(i).getS_name();
                            else if (j == 2)
                                tableDate[i][j] = gradebyClass.get(i).getG_ps();
                            else if (j == 3)
                                tableDate[i][j] = gradebyClass.get(i).getG_exam();
                            else
                                tableDate[i][j] = gradebyClass.get(i).getG_final();
                        }
                    }
                    String[] name = {"学号", "姓名", "平时性成绩", "考试成绩", "总成绩"};
                    table.removeAll();
                    /*
                    * 获得表格模型*/
                    DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
                    /*
                    * 清空表格数据*/
                    tableModel.setRowCount(0);
                    /*
                    * 设置表头*/
                    tableModel.setColumnIdentifiers(name);
                    for (int i = 0; i < gradebyClass.size(); i++) {
                        tableModel.addRow(tableDate[i]);
                    }
                    table.setRowHeight(30);
                    /*
                    * 应用表格模型*/
                    table.setModel(tableModel);
                }
            }
        });
        return gradeInput;
    }
    /*
    * 用户管理面板
    * */
    public JPanel getUser() {
        JPanel jpTeacheruser = new JPanel(new GridLayout(6, 2, 2, 2));
        JPanel jPanel = new JPanel(new BorderLayout());
        JFrame jf = this;
        JLabel jlId = new JLabel("教师号：");
        JLabel jlName = new JLabel("姓名：");
        JLabel jlSex = new JLabel("性别：");
        JTextField jtfId = new JTextField(10);
        jtfId.setEditable(false);
        jtfId.setText(teacher.getT_id());
        JTextField jtfName = new JTextField(10);
        jtfName.setEditable(false);
        jtfName.setText(teacher.getT_name());
        JTextField jtfSex = new JTextField(10);
        jtfSex.setEditable(false);
        jtfSex.setText(teacher.getT_sex());
        JButton jbt = new JButton("修改密码");
        JButton jbtQuit = new JButton("退出");
        JPanel jpBottom = new JPanel();
        jpBottom.add(jbt);
        jpBottom.add(jbtQuit);
        jpTeacheruser.add(jlId);
        jpTeacheruser.add(jtfId);
        jpTeacheruser.add(jlName);
        jpTeacheruser.add(jtfName);
        jpTeacheruser.add(jlSex);
        jpTeacheruser.add(jtfSex);
        jPanel.add(jpTeacheruser, BorderLayout.NORTH);
        jPanel.add(jpBottom, BorderLayout.CENTER);
        /*
        * 修改密码*/
        jbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPasswordField jpOldPassword = new JPasswordField();
                JPasswordField jpPassword = new JPasswordField();
                JPasswordField jpRepassword = new JPasswordField();
                Object[] message = {
                        "旧密码:", jpOldPassword,
                        "新密码:", jpPassword,
                        "重复新密码:", jpRepassword
                };
                int option = JOptionPane.showConfirmDialog(jf, message, "修改密码", JOptionPane.YES_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    String oldPassword = new StudentService().GetOldPassword(teacher.getT_id());
                    if (!oldPassword.equals(Tool.transitionPassword(jpOldPassword.getPassword()))) {
                        JOptionPane.showMessageDialog(jf, "原密码输入错误", "错误 ", 0);
                    } else if (!Tool.transitionPassword(jpPassword.getPassword()).equals(Tool.transitionPassword(jpRepassword.getPassword()))) {
                        JOptionPane.showMessageDialog(jf, "两次密码输入不一致", "错误 ", 0);
                    } else {
                        if (new StudentService().updatePassword(Tool.transitionPassword(jpPassword.getPassword()), teacher.getT_id())) {
                            JOptionPane.showMessageDialog(jf, "密码修改成功！", "提示", JOptionPane.PLAIN_MESSAGE);
                            jf.dispose();
                            new Login().setVisible(true);
                        }
                    }
                }
            }
        });
        /*
        * 退出事件*/
        jbtQuit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jf.dispose();
                new Login().setVisible(true);
            }
        });
        return jPanel;
    }
}
