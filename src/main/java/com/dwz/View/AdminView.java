package com.dwz.View;

import com.dwz.Pojo.Thing;
import com.dwz.Pojo.User;
import com.dwz.Service.StudentService;
import com.dwz.Service.UserService;
import com.dwz.Utlis.Button;
import com.dwz.Utlis.Tool;
import com.dwz.Utlis.replacementPanel;
import sun.swing.table.DefaultTableCellHeaderRenderer;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AdminView extends JFrame {
    User user;
    public JPanel getAdminhome() {
        JPanel jpHome = new JPanel();
        JTextArea textArea = new JTextArea();
        String text = user.getU_id();
        text += "管理员：欢迎使用佛山科学技术学院教务管理系统！";

        textArea.setText(text);
        textArea.setFont(new Font("黑体", 1, 30));

        ImageIcon imageIcon = new ImageIcon("/Users/weizhendeng/work-space/EMS/src/main/resources/img/新功能预测.png");

        JLabel jLabel = new JLabel(imageIcon);
        Dimension dimension = new Dimension(800, 500);
        jLabel.setPreferredSize(dimension);
        jpHome.add(textArea);
        jpHome.add(jLabel,BorderLayout.CENTER);

        return jpHome;
    }

    public JPanel getAdminhome1() {
        JPanel jpHome = new JPanel();
        JTextArea textArea = new JTextArea();
        String text = user.getU_id();
        text += "管理员：欢迎使用佛山科学技术学院教务管理系统！";
        textArea.setText(text);
        textArea.setFont(new Font("黑体", 1, 30));
        jpHome.add(textArea);
        return jpHome;
    }

    public AdminView(User user){
        super("佛山科学技术学院教务管理系统");
        this.user = user;
        Container cp = this.getContentPane();
        cp.setLayout(new BorderLayout());
        JButton Home = new com.dwz.Utlis.Button().getButton("首页", "img/shouyefill.png");
        JButton Teacher = new com.dwz.Utlis.Button().getButton("老师管理", "img/laoshiguanli.png");
        JButton Student = new com.dwz.Utlis.Button().getButton("学生管理", "img/xueshengguanli-01.png");
        JButton User = new com.dwz.Utlis.Button().getButton("个人中心", "img/yonghuguanli.png");
        JButton Inform = new Button().getButton("通知管理", "img/guoneizhengtongzhichaxun.png");
        JPanel bar = new JPanel();
        bar.add(Home);
        bar.add(Teacher);
        bar.add(Student);
        bar.add(Inform);
        bar.add(User);
        JPanel mid = getAdminhome();
        cp.add(bar, BorderLayout.NORTH);
        cp.add(mid, BorderLayout.CENTER);

        this.setSize(800, 650);
        /*
        * 居中
        * */
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new replacementPanel().replacement(mid ,getAdminhome1());
            }
        });
        Teacher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new replacementPanel().replacement(mid,GetTeacherUser());
            }
        });
        Student.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new replacementPanel().replacement(mid,GetStudentUser());
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
                new replacementPanel().replacement(mid,getAdminuser());
            }
        });
    }

    /*
    * 教师用户管理
    * */
    public JPanel GetTeacherUser() {
        JPanel jpTeacherUser = new JPanel(new BorderLayout());
        JPanel top = new JPanel();
        JButton jbtUpdatepwd = new JButton("修改密码");
        JButton AddTeacher = new JButton("增加");
        JButton jVerifyButton = new JButton("确认");
        top.add(jbtUpdatepwd);
        top.add(AddTeacher);
        top.add(jVerifyButton);
        jpTeacherUser.add(top, BorderLayout.NORTH);
        JTable table = new JTable() {
            public boolean isCellEditable(int row, int column) {
                return true;
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
        jpTeacherUser.add(tab, BorderLayout.CENTER);
        List<User> teacherUser = new UserService().GetTeacherUser();
        Object[][] tableDate = new Object[teacherUser.size()][5];
        for (int i = 0; i < teacherUser.size(); i++) {
            for (int j = 0; j < 5; j++) {
                if (j == 0)
                    tableDate[i][j] = teacherUser.get(i).getU_id();
                else if (j == 1)
                    tableDate[i][j] = teacherUser.get(i).getT_name();
                else if (j == 2)
                    tableDate[i][j] = teacherUser.get(i).getU_pwd();
                else if (j==3)
                    tableDate[i][j] = teacherUser.get(i).getU_status();
            }
        }
        String[] name = {"ID","姓名","密码", "身份"};
        table.removeAll();
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();    //获得表格模型
        tableModel.setRowCount(0);    //清空表格中的数据
        tableModel.setColumnIdentifiers(name);    //设置表头
        Tool.setColumnSize(table,1,10,160,160);
        for (int i = 0; i < teacherUser.size(); i++) {
            tableModel.addRow(tableDate[i]);
        }
        table.setRowHeight(30);
        table.setModel(tableModel);    //应用表格模型
        JFrame jf = this;


        AddTeacher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableModel.addRow(new Object[1]);
            }
        });
        jVerifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //重新进行表格渲染
                List<User> users = new ArrayList<>();
                User userTeacher = new User();
                for (int j = 0; j < table.getColumnCount(); j++) {
                    if (j == 0)
                        userTeacher.setU_id((String) table.getValueAt(table.getSelectedRow(), j));
                    else if (j == 1){
                        userTeacher.setT_name((String) table.getValueAt(table.getSelectedRow(),j));
                    }
                    else if (j == 3)
                        userTeacher.setSsex((String) table.getValueAt(table.getSelectedRow(),j));
                    users.add(userTeacher);
                }
                boolean addTeacher = new UserService().AddTeacher(users);
                System.out.println(addTeacher);
            }
        });

        jbtUpdatepwd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<User> users = new ArrayList<>();
                for (int i = 0; i < table.getRowCount(); i++) {
                    User test = new User();
                    for (int j = 0; j < table.getColumnCount(); j++) {
                        if (j == 0)
                            test.setU_id((String) table.getValueAt(i, j));
                        else if (j == 2)
                            test.setU_pwd((String) table.getValueAt(i, j));
                    }
                    users.add(test);
                    System.out.println(users);
                }
                if (new UserService().UpdateTeacherPwd(users)) {
                    JOptionPane.showMessageDialog(jf, "密码修改成功", "提示", JOptionPane.PLAIN_MESSAGE);
                    //重新进行表格渲染
                    List<User> userList = new UserService().GetTeacherUser();
                    Object[][] tableDate = new Object[userList.size()][5];
                    for (int i = 0; i < userList.size(); i++) {
                        for (int j = 0; j < 5; j++) {
                            if (j == 0)
                                tableDate[i][j] = userList.get(i).getU_id();
                            else if (j == 1)
                                tableDate[i][j] = userList.get(i).getT_name();
                            else if (j == 2)
                                tableDate[i][j] = userList.get(i).getU_pwd();
                            else if (j == 3)
                                tableDate[i][j] = userList.get(i).getU_status();
                        }
                    }
                    String[] name = {"ID", "姓名", "密码", "状态"};
                    table.removeAll();
                    DefaultTableModel tableModel = (DefaultTableModel) table.getModel();    //获得表格模型
                    tableModel.setRowCount(0);    //清空表格中的数据
                    tableModel.setColumnIdentifiers(name);    //设置表头
                    for (int i = 0; i < userList.size(); i++) {
                        tableModel.addRow(tableDate[i]);
                    }
                    table.setRowHeight(30);
                    table.setModel(tableModel);    //应用表格模型
                }
            }
        });
        return jpTeacherUser;

    }

    /*
    * 学生用户管理
    * */
    public JPanel GetStudentUser(){
        JPanel jpStudentUser = new JPanel(new BorderLayout());
        JPanel top = new JPanel();
        JButton jbtUpdatepwd = new JButton("修改密码");
        JButton AddStudent = new JButton("增加");
        JButton jVerifyButton = new JButton("确认");
        top.add(jbtUpdatepwd);
        top.add(AddStudent);
        top.add(jVerifyButton);
        jpStudentUser.add(top, BorderLayout.NORTH);
        JTable table = new JTable() {
            public boolean isCellEditable(int row, int column) {
                return true;
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
        jpStudentUser.add(tab, BorderLayout.CENTER);
        List<User> studentUser = new UserService().GetStudentUser();
        Object[][] tableDate = new Object[studentUser.size()][5];
        for (int i = 0; i < studentUser.size(); i++) {
            for (int j = 0; j < 5; j++) {
                if (j == 0)
                    tableDate[i][j] = studentUser.get(i).getU_id();
                else if (j == 1)
                    tableDate[i][j] = studentUser.get(i).getS_name();
                else if (j == 2)
                    tableDate[i][j] = studentUser.get(i).getU_pwd();
                else if (j==3)
                    tableDate[i][j] = studentUser.get(i).getU_status();
            }
        }
        String[] name = {"ID","姓名","密码", "身份(可输入性别栏)"};
        table.removeAll();
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();    //获得表格模型
        tableModel.setRowCount(0);    //清空表格中的数据
        tableModel.setColumnIdentifiers(name);    //设置表头
        Tool.setColumnSize(table,1,10,160,160);
        for (int i = 0; i < studentUser.size(); i++) {
            tableModel.addRow(tableDate[i]);
        }
        table.setRowHeight(30);
        table.setModel(tableModel);    //应用表格模型
        JFrame jf = this;

        AddStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableModel.addRow(new Object[1]);
            }
        });
        jVerifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //重新进行表格渲染
                List<User> users = new ArrayList<>();
                User userStudent = new User();
                for (int j = 0; j < table.getColumnCount(); j++) {
                    if (j == 0)
                        userStudent.setU_id((String) table.getValueAt(table.getSelectedRow(), j));
                    else if (j == 1){
                        userStudent.setS_name((String) table.getValueAt(table.getSelectedRow(),j));
                    }
                    else if (j == 3)
                        userStudent.setSsex((String) table.getValueAt(table.getSelectedRow(),j));
                users.add(userStudent);
                }
                boolean addStudent = new UserService().AddStudent(users);
                System.out.println(addStudent);
            }
        });
        jbtUpdatepwd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<User> users = new ArrayList<>();
                for (int i = 0; i < table.getRowCount(); i++) {
                    User userStudent = new User();
                    for (int j = 0; j < table.getColumnCount(); j++) {
                        if (j == 0)
                            userStudent.setU_id((String) table.getValueAt(i, j));
                        else if (j == 2)
                            userStudent.setU_pwd((String) table.getValueAt(i, j));
                    }
                    users.add(userStudent);
                }
                if (new UserService().UpdateStudentPwd(users)) {
                    JOptionPane.showMessageDialog(jf, "密码修改成功", "提示", JOptionPane.PLAIN_MESSAGE);
                    //重新进行表格渲染
                    List<User> userList = new UserService().GetStudentUser();
                    Object[][] tableDate = new Object[userList.size()][5];
                    for (int i = 0; i < userList.size(); i++) {
                        for (int j = 0; j < 5; j++) {
                            if (j == 0)
                                tableDate[i][j] = userList.get(i).getU_id();
                            else if (j == 1)
                                tableDate[i][j] = userList.get(i).getS_name();
                            else if (j == 2)
                                tableDate[i][j] = userList.get(i).getU_pwd();
                            else if (j == 3)
                                tableDate[i][j] = userList.get(i).getU_status();
                        }
                    }
                    String[] name = {"ID", "姓名", "密码", "状态"};
                    table.removeAll();
                    DefaultTableModel tableModel = (DefaultTableModel) table.getModel();    //获得表格模型
                    tableModel.setRowCount(0);    //清空表格中的数据
                    tableModel.setColumnIdentifiers(name);    //设置表头
                    for (int i = 0; i < userList.size(); i++) {
                        tableModel.addRow(tableDate[i]);
                    }
                    table.setRowHeight(30);
                    table.setModel(tableModel);    //应用表格模型
                }
            }
        });
        return jpStudentUser;
    }

    /*
    * 通知管理
    * */
    public JPanel getInform() {
        JPanel jpGrade = new JPanel(new BorderLayout());
        JPanel top = new JPanel();
        List<Thing> things = new StudentService().GetInform();
        JButton AddjButton = new JButton("增加");
        JButton VerifyjButton = new JButton("确认");
        JButton jDeleteButton = new JButton("删除");
        top.add(AddjButton);
        top.add(VerifyjButton);
        top.add(jDeleteButton);
        jpGrade.add(top, BorderLayout.NORTH);
        JTable table = new JTable() {
            public boolean isCellEditable(int row, int column) {
                return true;
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
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
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
                else if (j==3){
                    tableDate[i][j] = inform.get(i).getId();
                }
            }
        }
        String[] name = {"通知", "年份", "时间","编号"};
        table.removeAll();
        tableModel.setRowCount(0);    //清空表格中的数据
        tableModel.setColumnIdentifiers(name);    //设置表头
        Tool.setColumnSize(table,1,10,160,160);
        for (int i = 0; i < inform.size(); i++) {
            tableModel.addRow(tableDate[i]);
        }
        table.setRowHeight(30);
        table.setModel(tableModel);    //应用表格模型
        jDeleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id;
                id = (String) table.getValueAt(table.getSelectedRow(),3);
                boolean b = new UserService().DeleteInform(id);
                System.out.println(b);
            }
        });
        AddjButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableModel.addRow(new Object[1]);
            }
        });
        VerifyjButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Thing> thingList = new ArrayList<>();
                Thing thing = new Thing();
                for (int j = 0; j < table.getColumnCount(); j++) {
                    if (j == 0)
                        thing.setThingtxt((String) table.getValueAt(table.getSelectedRow(), j));
                    else if (j == 1)
                        thing.setYear((String) table.getValueAt(table.getSelectedRow(),j));
                    else if (j == 3){
                        thing.setId((String) table.getValueAt(table.getSelectedRow(),j));
                    }
                    thingList.add(thing);
                }
                boolean addInform = new UserService().AddInform(thingList);
                System.out.println(addInform);
            }
        });
        return jpGrade;
    }

    /*
    * 管理员页面
    * */
    public JPanel getAdminuser() {
        JPanel jpStudentuser = new JPanel(new GridLayout(6, 2, 2, 2));
        JPanel jPanel = new JPanel(new BorderLayout());
        JFrame jf = this;
        JLabel jlId = new JLabel("账号：");
        JLabel jlPwd = new JLabel("密码：");
        JTextField jtfId = new JTextField(10);
        jtfId.setEditable(false);
        jtfId.setText(user.getU_id());
        JTextField jtfName = new JTextField(10);
        jtfName.setEditable(false);
        jtfName.setText(user.getU_pwd());
        JButton jbtQuit = new JButton("退出");
        JPanel jpBottom = new JPanel();
        jpBottom.add(jbtQuit);
        jpStudentuser.add(jlId);
        jpStudentuser.add(jtfId);
        jpStudentuser.add(jlPwd);
        jpStudentuser.add(jtfName);
        jPanel.add(jpStudentuser, BorderLayout.NORTH);
        jPanel.add(jpBottom, BorderLayout.CENTER);
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
