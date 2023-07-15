package com.dwz.Service;

import com.dwz.Dao.StudentMapper;
import com.dwz.Pojo.*;
import com.dwz.Utlis.Mybatis;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentService {

    /*
    * 根据s_id获得Student用户
    * */
    public Student getStudent(String s_id){
        SqlSession sqlSession = Mybatis.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student students = studentMapper.getStudents_s_id(s_id);
        sqlSession.close();
        return students;
    }
    /*
    * 获得全部学生用户
    * */
    public List<Student> getStudentList(){
        SqlSession sqlSession = Mybatis.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList = studentMapper.getStudentList();
        sqlSession.close();
        return studentList;
    }
    /*
    * 获得年份列表
    * */
    public List<String> getYear(){
        SqlSession sqlSession = Mybatis.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<String> cp_yearList = studentMapper.getCp_year();
        sqlSession.close();
        return cp_yearList;
    }
    /*
    * 获得班级
    * */
    public List<Teacher_class> getTeachingclass(String id,String year){
        SqlSession sqlSession = Mybatis.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("s_id", id);
        map.put("cp_year", year);
        List<String> teachingClassId = mapper.getTeachingClassId(map);
        if (teachingClassId.size() == 0)
            return new ArrayList<>();
        map.put("teachingClassIdList",teachingClassId);
        List<Teacher_class> teachingClassList = mapper.getTeacherclass2(map);
        sqlSession.close();
        return teachingClassList;
    }
    /*
    * 获得选课信息
    * */
    public List<Seclet_Course> getSelectcourse(String studentid,String cp_year){
        String id = studentid.substring(0, 2);
        SqlSession sqlSession = Mybatis.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Seclet_Course> selectCourse = mapper.getSelectCourse(cp_year);
        return selectCourse;
    }
    /*
    * 判断是否冲突
    * */
    public boolean isConflict(String id, String year, String course) {
        List<Teacher_class> teachingclass = getTeachingclass(id, year);
        String[] s = course.split(" ");
        for (int i = 0; i < teachingclass.size(); i++) {
            for (int j = 0; j < s.length; j++) {
                if (teachingclass.get(i).getTc_time().contains(s[j]))
                    return true;
            }
        }
        return false;
    }
    /*
    * 增加选课记录
    * */
    public boolean courseAdd(String teachingClassname ,String studentId) {
        SqlSession sqlSession = Mybatis.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        String teachingclassId = mapper.getTeachingclassIdbyName(teachingClassname);
        System.out.println(studentId);
        System.out.println(teachingclassId);
        boolean res = mapper.addCourse(studentId,teachingclassId);
        sqlSession.commit();
        sqlSession.close();
        if (res) {
            return true;
        }
        return false;
    }
    /*
    * 实现成绩
    * */
    public List<Grade> getGrade(String id, String year) {
        SqlSession sqlSession = Mybatis.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Map<String, Object> map = new HashMap();
        map.put("sid", id);
        map.put("cpYear", year);
        List<Grade> gradeList = mapper.GetGradeList(map);
        sqlSession.close();
        return gradeList;
    }
    /*
    * 根据成绩的tc_id去寻找课程的名字
    * */
    public String GetCourseByid(String tc_id){
        SqlSession sqlSession = Mybatis.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        String CourseName = mapper.GetCourseName(tc_id);
        sqlSession.close();
        return CourseName;
    }
    /*
    * 获得旧密码
    * */
    public String GetOldPassword(String StuedntId){
        SqlSession sqlSession = Mybatis.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        String OldPassword = mapper.GetOldPassword(StuedntId);
        sqlSession.close();
        return OldPassword;
    }
    public boolean updatePassword(String newPassword, String id) {
        SqlSession sqlSession = Mybatis.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        boolean b = mapper.UpdatePassword(newPassword,id);
        sqlSession.commit();
        if (b)
            return true;
        return false;
    }

    /*
    * 通过班级账号获得学院名称
    * */
    public String GetAcademyName(String ClassId){
        SqlSession sqlSession = Mybatis.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        String academyName = mapper.GetAcademyName(ClassId);
        System.out.println(academyName);
        sqlSession.close();
        return academyName;
    }

    public List<Thing> GetInform(){
        SqlSession sqlSession = Mybatis.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Thing> things = mapper.GetInform();
        for (Thing thing: things){
            System.out.println(thing);
        }
        return things;
    }
}
