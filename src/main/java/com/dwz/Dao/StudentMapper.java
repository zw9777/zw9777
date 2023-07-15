package com.dwz.Dao;

import com.dwz.Pojo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentMapper {
    /*
    * 查询学生
    * */
    Student getStudents_s_id(String id);

    /*
    * 获得学生信息
    * */
    List<Student> getStudentList();

    /*
    * 获得学生的学年信息
    * */
    List<String> getCp_year();

    /*
    * 获得授课id
    * */
    List<String> getTeachingClassId(Map<String,Object> map);

    /*
    * 获得教师班级
    * */
    Teacher_class getTeacherclass1(String tc_id);

    /*
    * 获得教师班级列表
    * */
    List<Teacher_class> getTeacherclass2(Map map);

    /*
    * 获得课程信息
    * */
    List<Seclet_Course> getSelectCourse(String cp_year);

    /*
    * 获得授课名字
    * */
    String getTeachingclassIdbyName(String tc_name);

    /*
    * 增加选课记录
    * */
    boolean addCourse(@Param("s_id")String s_id,@Param("tc_name")String tc_name);

    /*
    * 获得成绩列表
    * */
    List<Grade> GetGradeList(Map<String,Object> map);

    /*
    * 通过成绩的tc_id查找这门课程的名字
    * */
    String GetCourseName(String tc_id);

    /*
    * 学生修改密码功能
    * */
    String GetOldPassword(String Sid);
    boolean UpdatePassword(@Param("newPassword") String newPassword, @Param("Sid") String id);

    /*
    * 获得学院名称
    * */
    String GetAcademyName(String ClassId);

    /*
    * 获得通知信息
    * */
    List<Thing> GetInform();

}
