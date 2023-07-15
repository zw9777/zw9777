package com.dwz.Dao;

import com.dwz.Pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    /*
    * 得到全部的用户，用户分为三部分，管理员，学生，账号
    * */
    List<User> getUserList();
    /*
    * 通过id获得用户
    * */
    User getUserById(String u_id);
    /*
    * 获得教师用户
    * */
    List<User> GetTeacherUser();
    /*
    * 修改教师密码
    * */
    boolean UpdateTeacherUserPwd(Map<String,Object> map);
    /*
    * 获得学生用户
    * */
    List<User> GetStudentUser();
    /*
    * 修改学生密码
    * */
    boolean UpdateStudentUserPwd(Map<String,Object> map);
    /*
    *增加学生用户
    * */
    boolean AddStudentUser(Map<String,Object> map);
    /*
    * 增加老师用户
    * */
    boolean AddTeacherUser(Map<String,Object> map);
    /*
    * 增加通知
    * */
    boolean AddInform(Map<String,Object> map);
    /*
    * 通知删除
    * */
    boolean DeleteInform(String id);
}
