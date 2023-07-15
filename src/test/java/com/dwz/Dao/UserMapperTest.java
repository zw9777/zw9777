//package com.dwz.Dao;
//
//import com.dwz.Pojo.Thing;
//import com.dwz.Pojo.User;
//import com.dwz.Utlis.Mybatis;
//import org.apache.ibatis.session.SqlSession;
//import org.junit.After;
//import org.junit.Test;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class UserMapperTest {
//    @Test
//    public void getUserList(){
//        SqlSession sqlSession = Mybatis.getSqlSession();
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        List<User> userList = userMapper.getUserList();
//        for (User user : userList){
//            System.out.println(user);
//        }
//        sqlSession.close();
//    }
//    @Test
//    public void GetTeacherUse() {
//        SqlSession sqlSession = Mybatis.getSqlSession();
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        List<User> userList = userMapper.GetTeacherUser();
//        for (User user : userList) {
//            System.out.println(user);
//        }
//        sqlSession.close();
//    }
//
//    @Test
//    public void UpdateTeacherPwd(){
//        SqlSession sqlSession = Mybatis.getSqlSession();
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
////        boolean b = mapper.UpdateTeacherUserPwd("101101011", "000000");
//        sqlSession.commit();
//
////        System.out.println(b);
//    }
////    @Test
////    public boolean UpdateTeacherPwd1(){
////        SqlSession sqlSession = Mybatis.getSqlSession();
////        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
////        Map<String, String> map = new HashMap<>();
////        User[] users = new User[];
////        for (User user:users){
////            map.put("t_id",user.getU_id());
////            map.put("pwd",user.getU_pwd());
////        }
////        boolean b = userMapper.UpdateTeacherUserPwd(map);
////        sqlSession.commit();
////        if (b)
////            return true;
////        return false;
////    }
//    @Test
//    public void UpdateTeacherpwd(){
//        SqlSession sqlSession = Mybatis.getSqlSession();
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        Map<String,Object> map = new HashMap<>();
//        map.put("t_id","101101011");
//        map.put("pwd","123456");
//        userMapper.UpdateTeacherUserPwd(map);
//        sqlSession.commit();
//        sqlSession.close();
//    }
//
//    @Test
//    public void GetStudentUser(){
//        SqlSession sqlSession = Mybatis.getSqlSession();
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        List<User> userList = userMapper.GetStudentUser();
//        for (User user : userList ){
//            System.out.println(user);
//        }
//        sqlSession.close();
//
//    }
//
//    @Test
//    public void AddStudent(){
//        SqlSession sqlSession = Mybatis.getSqlSession();
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        Map<String,Object> map = new HashMap<>();
//        map.put("id","6");
//        map.put("sname","ee");
//        map.put("ssex","男");
//        userMapper.AddStudentUser(map);
////        sqlSession.commit();
//        sqlSession.close();
//    }
//
////    @Test
////    public void AddInform(){
////        SqlSession sqlSession = Mybatis.getSqlSession();
////        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
////        Map<String,Object> map = new HashMap<>();
////        map.put("thingtxt","想放假？想屁吃");
////        map.put("id",11);
////        map.put("year","2023");
////        mapper.AddInform(map);
////        System.out.println("成功了");
////        sqlSession.commit();
////        sqlSession.close();
////    }
//
////    @Test
////    public void Delete(){
////        SqlSession sqlSession = Mybatis.getSqlSession();
////        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
////        mapper.DeleteInform("11");
////        sqlSession.close();
////    }
//}
