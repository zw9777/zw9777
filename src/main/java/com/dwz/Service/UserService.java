package com.dwz.Service;

import com.dwz.Dao.UserMapper;
import com.dwz.Pojo.Thing;
import com.dwz.Pojo.User;
import com.dwz.Utlis.Mybatis;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {
    public boolean judgeUser(User user){
        SqlSession sqlSession = Mybatis.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User userMapperUser = userMapper.getUserById(user.getU_id());
        /*
        * 代码解释
        * 这里不是传了一个user的用户嘛，我们拿到这个user的id，拿着这个id通过
        * Mybatis去数据库找到这个用户，然后关闭，在去数据库调出这个用户的密码，
        * 将这个密码和user自己传进来的密码进行比较即可*/
        sqlSession.close();
        if (userMapperUser != null){
            if (userMapperUser.getU_pwd().equals(user.getU_pwd())){
                user.setU_status(userMapperUser.getU_status());
                return true;
            }
        }
        return false;
    }
    /*获得User对象*/
    public User getUser(String u_id){
        SqlSession sqlSession = Mybatis.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserById(u_id);
        sqlSession.close();
        return user;
    }

    /*
    * 获得教师用户信息
    * */
    public List<User> GetTeacherUser(){
        SqlSession sqlSession = Mybatis.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.GetTeacherUser();
        for (User user : userList ){
            System.out.println(user);
        }
        sqlSession.close();
        return userList;
    }

    /*
    * 修改教师密码
    * */
    /*TeacherUpdateTest
    * */
    public boolean UpdateTeacherPwd(List<User> teacherUpdateTests){
        SqlSession sqlSession = Mybatis.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Object> map = new HashMap<>();
        for (User teacherUpdateTest : teacherUpdateTests){
            map.put("t_id",teacherUpdateTest.getU_id());
            map.put("pwd",teacherUpdateTest.getU_pwd());
            userMapper.UpdateTeacherUserPwd(map);
            sqlSession.commit();
        }
        sqlSession.close();
        return true;
    }

    /*
    * 获得学生用户
    * */
    public List<User> GetStudentUser(){
        SqlSession sqlSession = Mybatis.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.GetStudentUser();
        for (User user : userList ){
            System.out.println(user);
        }
        sqlSession.close();
        return userList;
    }

    /*
    * 修改学生用户密码
    * */
    public boolean UpdateStudentPwd(List<User> StudentList){
        SqlSession sqlSession = Mybatis.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Object> map = new HashMap<>();
        for (User StudentUser : StudentList){
            map.put("t_id",StudentUser.getU_id());
            map.put("pwd",StudentUser.getU_pwd());
            userMapper.UpdateTeacherUserPwd(map);
            sqlSession.commit();
        }
        sqlSession.close();
        return true;
    }

    /*
    * 增加学生账户
    * */
    public boolean AddStudent(List<User> Studentslist){
        SqlSession sqlSession = Mybatis.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Object> map = new HashMap<>();
        for (User user:Studentslist){
            map.put("id",user.getU_id());
            map.put("sname",user.getS_name());
            map.put("ssex",user.getSsex());
            userMapper.AddStudentUser(map);
            sqlSession.commit();
        }
        sqlSession.close();
        return true;
    }

    /*
     * 增加老师账户
     * */
    public boolean AddTeacher(List<User> list){
        SqlSession sqlSession = Mybatis.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Object> map = new HashMap<>();
        for (User user:list){
            map.put("id",user.getU_id());
            map.put("sname",user.getT_name());
            map.put("ssex",user.getSsex());
            userMapper.AddTeacherUser(map);
            sqlSession.commit();
        }
        sqlSession.close();
        return true;
    }

    /*
    * 增加通知
    * */
    public boolean AddInform(List<Thing> thingList){
        SqlSession sqlSession = Mybatis.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Object> map = new HashMap<>();
        for (Thing thing:thingList){
            map.put("thingtxt",thing.getThingtxt());
            map.put("id",thing.getId());
            map.put("year",thing.getYear());
            mapper.AddInform(map);
            sqlSession.commit();
        }
        sqlSession.close();
        return true;
    }

    /*
    * 删除通知
    * */
    public boolean DeleteInform(String id){
        SqlSession sqlSession = Mybatis.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.DeleteInform(id);
        sqlSession.commit();
        sqlSession.close();
        return true;
    }
}

