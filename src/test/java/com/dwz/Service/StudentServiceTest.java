//package com.dwz.Service;
//
//import com.dwz.Dao.StudentMapper;
//import com.dwz.Pojo.Seclet_Course;
//import com.dwz.Pojo.Student;
//import com.dwz.Pojo.Thing;
//import com.dwz.Utlis.Mybatis;
//import org.apache.ibatis.session.SqlSession;
//import org.junit.Test;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class StudentServiceTest {
//
////    根据s_id获得Student用户
//    @Test
//    public void getStudent(){
//        SqlSession sqlSession = Mybatis.getSqlSession();
//        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
//        Student students = studentMapper.getStudents_s_id("20220101");
//        System.out.println(students);
//        sqlSession.close();
//    }
//
////        获得全部学生用户
//    @Test
//    public void getStudentList(){
//        SqlSession sqlSession = Mybatis.getSqlSession();
//        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
//        List<Student> studentList = studentMapper.getStudentList();
//        for (Student student: studentList){
//            System.out.println(student);
//        }
//        sqlSession.close();
//    }
////    获得年份列表
//    @Test
//    public void getCpyearList(){
//        SqlSession sqlSession = Mybatis.getSqlSession();
//        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
//        List<String> cp_year = studentMapper.getCp_year();
//        for (String cp_list: cp_year){
//            System.out.println(cp_list);
//        }
//        sqlSession.close();
//    }
//
////    获得班级id,当传入学号，年份的时候会去查询选课记录
//    @Test
//    public void getTeachingClassId(){
//        SqlSession sqlSession = Mybatis.getSqlSession();
//        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
//        Map<String,Object> map = new HashMap<>();
//        map.put("s_id","20220101");
//        map.put("cp_year","2020-2021上");
//        List<String> year = mapper.getTeachingClassId(map);
//        System.out.println(mapper.getTeacherclass1("tc1001"));
//        System.out.println(year);
//        sqlSession.close();
//    }
//
////    获得班级
//    @Test
//    public void getTeachingclass1(){
//        SqlSession sqlSession = Mybatis.getSqlSession();
//        StudentMapper studentMapper_1 = sqlSession.getMapper(StudentMapper.class);
//        Map<String, Object> map = new HashMap<>();
//
//    }
//    @Test
//    //    获得选课信息
//    public void getSelectCourse(){
//        String id = "20220101".substring(0, 2);
//        System.out.println(id);
//        SqlSession sqlSession = Mybatis.getSqlSession();
//        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
//        List<Seclet_Course> selectCourse = mapper.getSelectCourse("2020-2021下");
//        for (Seclet_Course seclet_course : selectCourse){
//            System.out.println(seclet_course);
//        }
//        for (int i = 0; i < selectCourse.size(); i++) {
//            System.out.println(selectCourse.get(i).getClass().equals(id));
//            if (!selectCourse.get(i).getClass().equals(id))
//                System.out.println(selectCourse.get(i).getClass());
////                selectCourse.remove(i);//移除信息
//        }
//    }
//
//    @Test
//    public void addSelectCourse() {
//        SqlSession sqlSession = Mybatis.getSqlSession();
//        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
//        System.out.println(mapper.getTeachingclassIdbyName("大英1班"));
//        String ss = mapper.getTeachingclassIdbyName("大英1班");
//        mapper.addCourse("20220101", ss);
//        System.out.println(mapper);
//        System.out.println(mapper);
////        sqlSession.commit();
//        sqlSession.close();
//    }
//
//    @Test
//    public void GetCourseNameTest(){
//        SqlSession sqlSession = Mybatis.getSqlSession();
//        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
//        String CourseName = mapper.GetCourseName("tc1001");
//        System.out.println(CourseName);
//    }
//
//    @Test
//    public void GetAcadmy(){
//        SqlSession sqlSession = Mybatis.getSqlSession();
//        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
//        String c101 = mapper.GetAcademyName("c101");
//        sqlSession.close();
//        System.out.println(c101);
//    }
//
//    @Test
//    public void GetInform(){
//        SqlSession sqlSession = Mybatis.getSqlSession();
//        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
//        List<Thing> things = mapper.GetInform();
//        for (Thing thing : things){
//            System.out.println(thing.getThingtxt());
//        }
//        sqlSession.close();
//    }
//}
