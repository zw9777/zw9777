package com.dwz.View;

import com.dwz.Pojo.User;
import com.dwz.Service.StudentService;
import com.dwz.Service.TeacherService;
import com.dwz.Service.UserService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login extends JFrame {
    JTextField jtfId = new JTextField(15);
    JPasswordField jpfPassword = new JPasswordField(15);
    JLabel jlId = new JLabel("账号：");
    JLabel jlPassword = new JLabel("密码：");
    JButton jbtLogin = new JButton("登录");

    public Login(){
        this.setTitle("佛山科学技术学院教务管理系统");
        this.setLayout(new FlowLayout());

        ImageIcon imageIcon = new ImageIcon("/Users/weizhendeng/work-space/EMS/src/main/resources/img/img.png");

        JLabel jLabel = new JLabel(imageIcon);
        Dimension dimension = new Dimension(308, 133);
        jLabel.setPreferredSize(dimension);
        this.add(jLabel);

        JPanel Jlogin = new JPanel();
        Jlogin.add(jlId);
        Jlogin.add(jtfId);

        JPanel jpPassword = new JPanel();
        jpPassword.add(jlPassword);
        jpPassword.add(jpfPassword);

        JPanel jpLogin = new JPanel();
        jpLogin.add(jbtLogin);

        this.add(Jlogin);
        this.add(jpPassword);
        this.add(jpLogin);
        this.setSize(308, 290);
        //居中
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFrame jf = this;
        jpfPassword.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent pwd) {
                if(pwd.getKeyChar() == '\n')
                    jbtLogin.doClick();
            }
        });
        jbtLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String uId = jtfId.getText();
                String uPassword = "";
                char[] password = jpfPassword.getPassword();
                for (int i = 0; i < password.length; i++) {
                    uPassword += password[i];
                }
                User user = new User(uId, uPassword, null);
                UserService userService = new UserService();
                if (userService.judgeUser(user)) {
                    if (user.getU_status().equals("老师")) {
                        jf.dispose();
                        TeacherView teacherView = new TeacherView(new TeacherService().getTeacher(uId));
                        teacherView.setVisible(true);
                    } else if (user.getU_status().equals("学生")){
                        jf.dispose();
                        StudentsView studentsView = new StudentsView(new StudentService().getStudent(uId));
                        studentsView.setVisible(true);
                    }else {
                        jf.dispose();
                        AdminView adminView = new AdminView(new UserService().getUser(uId));
                        adminView.setVisible(true);
                    }
                }else {
                    JOptionPane.showMessageDialog(jf, "用户名密码输入有误", "错误", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }
}
