package com.dwz.View;

import com.dwz.Pojo.*;
import com.dwz.Pojo.Class;
import com.dwz.Service.StudentService;
import com.dwz.Utlis.Button;
import com.dwz.Utlis.Tool;
import com.dwz.Utlis.replacementPanel;
import sun.swing.table.DefaultTableCellHeaderRenderer;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.xml.bind.annotation.XmlAnyAttribute;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class StudentsView extends JFrame {
    Student student;
    /*
    * 首页面板
    * */
    public JPanel getStudenthome() {
        JPanel jpHome = new JPanel();
        JTextArea textArea = new JTextArea();
        String text = student.getS_name();
        text += "同学：欢迎使用佛山科学技术学院教务管理系统！";
        textArea.setText(text);
        textArea.setFont(new Font("黑体", 1, 30));
        ImageIcon imageIcon = new ImageIcon("/Users/weizhendeng/work-space/EMS/src/main/resources/img/新功能预测.png");
        JLabel jLabel = new JLabel(imageIcon);
        Dimension dimension = new Dimension(800, 500);
        jLabel.setPreferredSize(dimension);
        jLabel.setVerticalAlignment(SwingUtilities.CENTER);
        jpHome.add(textArea);
        jpHome.add(jLabel,BorderLayout.CENTER);
        return jpHome;
    }
    /*
    * 主页面板
    * */
    public JPanel getStudenthome1() {
        JPanel jpHome = new JPanel();
        JTextArea textArea = new JTextArea();
        String text = student.getS_name();
        text += "同学：欢迎使用佛山科学技术学院教务管理系统！";
        textArea.setText(text);
        textArea.setFont(new Font("黑体", 2, 30));
        jpHome.add(textArea);
        return jpHome;
    }
    public StudentsView(Student student){
        super("佛山科学技术学院教务管理系统");
        this.student = student;
        Container cp = this.getContentPane();
        cp.setLayout(new BorderLayout());
        JButton Home = new Button().getButton("首页", "img/shouyefill.png");
        JButton Course = new Button().getButton("课程查询", "img/kechengchaxun.png");
        JButton Selectcourse = new Button().getButton("选课系统", "img/zizhuxuanke.png");
        JButton Grade = new Button().getButton("成绩查询", "img/chengjichaxun-.png");
        JButton User = new Button().getButton("个人中心", "img/yonghuguanli.png");
        JButton Inform = new Button().getButton("通知管理", "img/guoneizhengtongzhichaxun.png");
        JPanel bar = new JPanel();
        bar.add(Home);
        bar.add(Course);
        bar.add(Selectcourse);
        bar.add(Grade);
        bar.add(Inform);
        bar.add(User);
        JPanel mid = getStudenthome();
        cp.add(bar, BorderLayout.NORTH);
        cp.add(mid, BorderLayout.CENTER);
        this.setSize(800, 650);
        //居中
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new replacementPanel().replacement(mid,getStudenthome1());
            }
        });
        Course.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new replacementPanel().replacement(mid,getStudentCourse());
            }
        });
        Selectcourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new replacementPanel().replacement(mid,getSelectCourse());
            }
        });
        Grade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new replacementPanel().replacement(mid,getStudentgrade());
            }
        });
        Inform.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new replacementPanel().replacement(mid,getInform());
            }
        });
        User.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new replacementPanel().replacement(mid,getStudentuser());
            }
        });

    }

    /*
    * 获得选课
    * */
    public JPanel getStudentCourse(){
        class TableViewRenderer extends JTextArea implements TableCellRenderer {
            public TableViewRenderer() {
                /*
                * 将表格设为自动换行*/
                setLineWrap(true);
                /*
                * 单词过长的时候是否把长单词移动到下一行*/
                setWrapStyleWord(true);
            }
            /*
            * obj指的是单元格内容*/
            public Component getTableCellRendererComponent(JTable jtable, Object obj,
                                                           boolean isSelected,
                                                           boolean hasFocus, int row, int column) {
                setText(obj == null ? "" : obj.toString());
                /*
                * 利用JTextArea的setText设置文本方法*/
                return this;
            }
        }
        JPanel jpCourse = new JPanel(new BorderLayout());
        JPanel top = new JPanel();
        JLabel jlYear = new JLabel("学年:");
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.addItem("--请选择--");
        List<String> year = new StudentService().getYear();
        for (String str : year) {
            comboBox.addItem(str);
        }
        JButton jbtSelect = new JButton("查询");
        top.add(jlYear);
        top.add(comboBox);
        top.add(jbtSelect);
        jpCourse.add(top, BorderLayout.NORTH);
        /*
        * 不可编辑表格内容*/
        JTable table = new JTable() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JScrollPane tab = new JScrollPane(table);
        /*
        * 表格内容居中且换行*/
        TableViewRenderer tableViewRenderer = new TableViewRenderer();
        /*
        * 自定义表格格式渲染器*/
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
        jpCourse.add(tab, BorderLayout.CENTER);
        jbtSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object cp_year = comboBox.getSelectedItem();
                List<Teacher_class> teachingclass = new StudentService().getTeachingclass(student.getS_id(), (String) cp_year);
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
                for (int i = 0; i < teachingclass.size(); i++) {
                    String res;
                    String tc_time = teachingclass.get(i).getTc_time();
                    /*
                    * 获得最终上课时间与地点*/
                    String[] res_time = tc_time.split(" ");
                    for (int j = 0; j < res_time.length; j++) {
                        int week = res_time[j].charAt(0) - '0';
                        int section = res_time[j].charAt(2) - '0';
                        res = "\n  " + teachingclass.get(i).getTc_name() + "\n  " + teachingclass.get(i).getTc_point();
                        tableDate[section - 1][week] = res;
                    }
                }
                table.removeAll();
                /*
                * 获得表格模型*/
                DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
                /*
                * 清空表格中的数据*/
                tableModel.setRowCount(0);
                /*
                * 设置表头*/
                tableModel.setColumnIdentifiers(name);
                for (int i = 0; i < 5; i++) {
                    tableModel.addRow(tableDate[i]);
                }
                table.setRowHeight(78);
                /*
                * 应用表格模型*/
                table.setModel(tableModel);
            }
        });
        return jpCourse;
    }
    /*
    * 选择课程
    * */
    public JPanel getSelectCourse(){
        JPanel jpSC = new JPanel(new BorderLayout());
        JPanel top = new JPanel();
        JLabel jlYear = new JLabel("学年:");
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.addItem("--请选择--");
        List<String> year = new StudentService().getYear();
        for (String str : year) {
            comboBox.addItem(str);
        }
        JButton jbtSelect = new JButton("查询");
        JButton jbtAdd = new JButton("选择");
        top.add(jbtAdd);
        top.add(jlYear);
        top.add(comboBox);
        top.add(jbtSelect);
        jpSC.add(top, BorderLayout.NORTH);

        JTable table = new JTable() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JScrollPane tab = new JScrollPane(table);
        /*
        * 表格内容居中*/
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();//单元格渲染器
        tcr.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, tcr);
        /*
        * 表格表头居中*/
        DefaultTableCellHeaderRenderer hr = new DefaultTableCellHeaderRenderer();
        hr.setHorizontalAlignment(JLabel.CENTER);
        hr.setPreferredSize(new Dimension(25, 25));
        table.getTableHeader().setDefaultRenderer(hr);
        /*
        * 设置面板大小*/
        tab.setPreferredSize(new Dimension(750, 480));
        /*
        * 设置透明*/
        tab.setOpaque(false);
        tab.getViewport().setOpaque(false);
        jpSC.add(tab, BorderLayout.CENTER);
        JFrame jf = this;
        /*
        * 查询选课点击事件*/
        jbtSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object cp_year = comboBox.getSelectedItem();
                List<Seclet_Course> selectCourse = new StudentService().getSelectcourse(student.getS_id(), (String)cp_year);
                System.out.println(selectCourse);
                Object[][] tableDate = new Object[selectCourse.size()][5];
                for (int i = 0; i < selectCourse.size(); i++) {
                    for (int j = 0; j < 5; j++) {
                        if (j == 0)
                            tableDate[i][j] = selectCourse.get(i).getCourseName();
                        else if (j == 1)
                            tableDate[i][j] = selectCourse.get(i).getCredit();
                        else if (j == 2)
                            tableDate[i][j] = selectCourse.get(i).getTeacherClass();
                        else if (j == 3)
                            tableDate[i][j] = selectCourse.get(i).getTeacherName();
                        else {
                            String str = "";
                            str += selectCourse.get(i).getCoursePoint();
                            str += '/';
                            String[] s = selectCourse.get(i).getCourseTime().split(" ");
                            for (int k = 0; k < s.length; k++) {
                                str += Tool.getWeek(s[k].charAt(0));
                                str += Tool.getPitch(s[k].charAt(2));
                                if (k != s.length - 1)
                                    str += ',';
                            }
                            tableDate[i][j] = str;
                        }
                    }
                }
                String[] name = {"课程名", "课程学分", "课程班级", "教学教师", "上课地点/上课时间"};
                table.removeAll();
                /*
                * 获得表格模型
                * */
                DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
                /*
                * 清空表格中的数据*/
                tableModel.setRowCount(0);
                /*
                * 设置表头*/
                tableModel.setColumnIdentifiers(name);
                for (int i = 0; i < selectCourse.size(); i++) {
                    tableModel.addRow(tableDate[i]);
                }
                Tool.setColumnSize(table, 0, 140, 140, 140);
                Tool.setColumnSize(table, 1, 80, 80, 80);
                Tool.setColumnSize(table, 2, 140, 140, 140);
                Tool.setColumnSize(table, 3, 80, 80, 80);
                table.setRowHeight(30);
                /*
                * 应用表格模型*/
                table.setModel(tableModel);
            }
        });
        /*
        * 增加课程*/
        jbtAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    /*
                    * 获取你选中的行号（记录）*/
                    int count = table.getSelectedRow();
                    System.out.println(count);
                    /*
                    * 读取你获取行号的某一列的值（也就是字段)*/
                    String className = table.getValueAt(count, 2).toString();
                    System.out.println(className);
                    Object cp_year = comboBox.getSelectedItem();
                    List<Seclet_Course> courses = new StudentService().getSelectcourse(student.getS_id(), (String) cp_year);
                    /*
                    * 选中的课程安排*/
                    String courseTime = courses.get(count).getCourseTime();
                    /*
                    * 判断是否与当前课程冲突*/
                    boolean conflict = new StudentService().isConflict(student.getS_id(), (String) cp_year, courseTime);
                    if (conflict) {
                        JOptionPane.showMessageDialog(jf, "请检查选择的课是否与已选的选课冲突！", "错误 ", JOptionPane.ERROR_MESSAGE);
                    } else {
                        boolean courseAdd = new StudentService().courseAdd(className, student.getS_id());
                        System.out.println(courseAdd);
                        if (courseAdd)
                            JOptionPane.showMessageDialog(jf, "选课成功!", "提示", JOptionPane.PLAIN_MESSAGE);
                        else
                            JOptionPane.showMessageDialog(jf, "请检查是否已选择该课", "错误 ", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(jf, "未选择要选修的课程！", "错误 ", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        return jpSC;
    }
    /*
    * 获取学生成绩
    * */
    public JPanel getStudentgrade() {
        JPanel jpGrade = new JPanel(new BorderLayout());
        JPanel top = new JPanel();
        JLabel jlYear = new JLabel("学年:");
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.addItem("--请选择--");
        List<String> year = new StudentService().getYear();
        for (String str : year) {
            comboBox.addItem(str);
        }
        JButton jbtSelect = new JButton("查询");
        top.add(jlYear);
        top.add(comboBox);
        top.add(jbtSelect);
        jpGrade.add(top, BorderLayout.NORTH);
        JTable table = new JTable() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JScrollPane tab = new JScrollPane(table);
        //表格内容居中
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, tcr);
        //表格表头居中
        DefaultTableCellHeaderRenderer hr = new DefaultTableCellHeaderRenderer();
        hr.setHorizontalAlignment(JLabel.CENTER);
        hr.setPreferredSize(new Dimension(25, 25));
        table.getTableHeader().setDefaultRenderer(hr);
        tab.setPreferredSize(new Dimension(650, 500));
        //设置透明
        tab.setOpaque(false);
        tab.getViewport().setOpaque(false);
        jpGrade.add(tab, BorderLayout.CENTER);
        jbtSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object cp_year = comboBox.getSelectedItem();
                List<Grade> grade = new StudentService().getGrade(student.getS_id(), (String) cp_year);
                Object[][] tableDate = new Object[grade.size()][5];
                for (int i = 0; i < grade.size(); i++) {
                    for (int j = 0; j < 5; j++) {
                        if (j == 0)
                            tableDate[i][j] = grade.get(i).getS_id();
                        else if (j == 1)
                            tableDate[i][j] = grade.get(i).getCourse_name();
                        else if (j == 2)
                            tableDate[i][j] = grade.get(i).getG_ps();
                        else if (j == 3)
                            tableDate[i][j] = grade.get(i).getG_exam();
                        else
                            tableDate[i][j] = grade.get(i).getG_final();
                    }
                }
                String[] name = {"学号", "课程名", "平时性成绩", "考试成绩","总成绩"};
                table.removeAll();
                DefaultTableModel tableModel = (DefaultTableModel) table.getModel();    //获得表格模型
                tableModel.setRowCount(0);    //清空表格中的数据
                tableModel.setColumnIdentifiers(name);    //设置表头
                Tool.setColumnSize(table,1,10,160,160);
                for (int i = 0; i < grade.size(); i++) {
                    tableModel.addRow(tableDate[i]);
                }
                table.setRowHeight(30);
                table.setModel(tableModel);    //应用表格模型
            }
        });
        return jpGrade;
    }
    /*
    * 通知管理页面
    * */
    public JPanel getInform() {
        JPanel jpGrade = new JPanel(new BorderLayout());
        JPanel top = new JPanel();
        List<Thing> things = new StudentService().GetInform();
        jpGrade.add(top, BorderLayout.NORTH);
        JTable table = new JTable() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
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
        tab.setPreferredSize(new Dimension(650, 500));
        //设置透明
        tab.setOpaque(false);
        tab.getViewport().setOpaque(false);
        jpGrade.add(tab, BorderLayout.CENTER);


        List<Thing> inform = new StudentService().GetInform();
        Object[][] tableDate = new Object[inform.size()][5];
        for (int i = 0; i < inform.size(); i++) {
            for (int j = 0; j < 5; j++) {
                if (j == 0)
                    tableDate[i][j] = inform.get(i).getThingtxt();
                else if (j == 1)
                    tableDate[i][j] = inform.get(i).getYear();
                else if (j == 2)
                    tableDate[i][j] = inform.get(i).getTine();
            }
        }
        String[] name = {"通知", "年份", "时间"};
        table.removeAll();
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();    //获得表格模型
        tableModel.setRowCount(0);    //清空表格中的数据
        tableModel.setColumnIdentifiers(name);    //设置表头
        Tool.setColumnSize(table,1,10,160,160);
        for (int i = 0; i < inform.size(); i++) {
            tableModel.addRow(tableDate[i]);
        }
        table.setRowHeight(30);
        table.setModel(tableModel);    //应用表格模型
//        jbtSelect.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                List<Thing> inform = new StudentService().GetInform();
//                Object[][] tableDate = new Object[inform.size()][5];
//                for (int i = 0; i < inform.size(); i++) {
//                    for (int j = 0; j < 5; j++) {
//                        if (j == 0)
//                            tableDate[i][j] = inform.get(i).getThingtxt();
//                        else if (j == 1)
//                            tableDate[i][j] = inform.get(i).getYear();
//                        else if (j == 2)
//                            tableDate[i][j] = inform.get(i).getTine();
//                    }
//                }
//                String[] name = {"通知", "年份", "时间"};
//                table.removeAll();
//                DefaultTableModel tableModel = (DefaultTableModel) table.getModel();    //获得表格模型
//                tableModel.setRowCount(0);    //清空表格中的数据
//                tableModel.setColumnIdentifiers(name);    //设置表头
//                Tool.setColumnSize(table,1,10,160,160);
//                for (int i = 0; i < inform.size(); i++) {
//                    tableModel.addRow(tableDate[i]);
//                }
//                table.setRowHeight(30);
//                table.setModel(tableModel);    //应用表格模型
//            }
//        });
        return jpGrade;
    }
    /*
    *学生个人信息以及修改密码面板
    * */
    public JPanel getStudentuser() {
        JPanel jpStudentuser = new JPanel(new GridLayout(6, 2, 2, 2));
        JPanel jPanel = new JPanel(new BorderLayout());
        JFrame jf = this;
        JLabel jlId = new JLabel("学号：");
        JLabel jlName = new JLabel("姓名：");
        JLabel jlSex = new JLabel("性别：");
        JLabel jlAc = new JLabel("学院：");
        JLabel jlClass = new JLabel("行政班级：");
        JTextField jtfId = new JTextField(10);
        jtfId.setEditable(false);
        jtfId.setText(student.getS_id());
        JTextField jtfName = new JTextField(10);
        jtfName.setEditable(false);
        jtfName.setText(student.getS_name());
        JTextField jtfSex = new JTextField(10);
        jtfSex.setEditable(false);
        jtfSex.setText(student.getS_sex());
        JTextField jtfAc = new JTextField(10);
        jtfAc.setEditable(false);
        String ac = new StudentService().GetAcademyName(student.getC_id());
        jtfAc.setText(ac);
        JTextField jtfClass = new JTextField(10);
        jtfClass.setEditable(false);
        jtfClass.setText(student.getC_id());
        JButton jbt = new JButton("修改密码");
        JButton jbtQuit = new JButton("退出");
        JPanel jpBottom = new JPanel();
        jpBottom.add(jbt);
        jpBottom.add(jbtQuit);
        jpStudentuser.add(jlId);
        jpStudentuser.add(jtfId);
        jpStudentuser.add(jlName);
        jpStudentuser.add(jtfName);
        jpStudentuser.add(jlSex);
        jpStudentuser.add(jtfSex);
        jpStudentuser.add(jlAc);
        jpStudentuser.add(jtfAc);

        jpStudentuser.add(jlClass);
        jpStudentuser.add(jtfClass);
        jPanel.add(jpStudentuser, BorderLayout.NORTH);
        jPanel.add(jpBottom, BorderLayout.CENTER);
        //修改密码事件
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
                    String oldPassword = new StudentService().GetOldPassword(student.getS_id());
                    if (!oldPassword.equals(Tool.transitionPassword(jpOldPassword.getPassword()))) {
                        JOptionPane.showMessageDialog(jf, "原密码输入错误", "错误 ", 0);
                    } else if (!Tool.transitionPassword(jpPassword.getPassword()).equals(Tool.transitionPassword(jpRepassword.getPassword()))) {
                        JOptionPane.showMessageDialog(jf, "两次密码输入不一致", "错误 ", 0);
                    } else {
                        if (new StudentService().updatePassword(Tool.transitionPassword(jpPassword.getPassword()), student.getS_id())) {
                            JOptionPane.showMessageDialog(jf, "密码修改成功！", "提示", JOptionPane.PLAIN_MESSAGE);
                            jf.dispose();
                            new Login().setVisible(true);
                        }
                    }
                }
            }
        });
        //退出事件
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
