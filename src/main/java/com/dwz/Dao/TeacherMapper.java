package com.dwz.Dao;

import com.dwz.Pojo.Grade;
import com.dwz.Pojo.Teacher;
import com.dwz.Pojo.TeacherPlan;
import com.dwz.Pojo.Teaching_programme;

import java.util.List;
import java.util.Map;

public interface TeacherMapper {
    /*
    * 通过id获得教师用户
    * */
    Teacher getTeacher(String t_id);
    /*
    * 获得教师列表
    * */
    List<Teacher> getTeacherList();
    /*
    * 获得教师课程安排
    * */
    List<TeacherPlan> getTeacherProgramme(Map<String,Object> map);
    /*
    * 成绩录入
    * */
    List<Grade> GetGradeByClass(String tc_name);

    /*
    * 更新成绩
    * */
    String getTeachingclassIdbyName(String tc_name);
    boolean UpdateGrade(Map<String,Object> map);


}
