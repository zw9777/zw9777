//package com.dwz.Service;
//
//import com.dwz.Dao.StudentMapper;
//import com.dwz.Dao.TeacherMapper;
//import com.dwz.Pojo.Student;
//import com.dwz.Pojo.Teacher;
//import com.dwz.Utlis.Mybatis;
//import org.apache.ibatis.session.SqlSession;
//import org.junit.Test;
//
//import java.util.List;
//
//public class TeacherServiceTest {
//    @Test
//    public void getTeacher(){
//        SqlSession sqlSession = Mybatis.getSqlSession();
//        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
//        Teacher teacher = teacherMapper.getTeacher("101101011");
//        System.out.println(teacher);
//        sqlSession.close();
//    }
//    @Test
//    public void getTeacherList(){
//        SqlSession sqlSession = Mybatis.getSqlSession();
//        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
//        List<Teacher> teacherList = teacherMapper.getTeacherList();
//        for (Teacher teacher: teacherList){
//            System.out.println(teacher);
//        }
//        sqlSession.close();
//    }
//}
