package com.dwz.Service;

import com.dwz.Dao.StudentMapper;
import com.dwz.Dao.TeacherMapper;
import com.dwz.Pojo.Grade;
import com.dwz.Pojo.Student;
import com.dwz.Pojo.Teacher;
import com.dwz.Pojo.TeacherPlan;
import com.dwz.Utlis.Mybatis;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeacherService {
    /*
    * 根据s_id获得Student用户
    * */
    public Teacher getTeacher(String s_id){
        SqlSession sqlSession = Mybatis.getSqlSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = teacherMapper.getTeacher(s_id);
        sqlSession.close();
        return teacher;
    }
    /*
    * 获得全部老师用户
    * */
    public List<Teacher> getTeacherList(){
        SqlSession sqlSession = Mybatis.getSqlSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> teacherList = teacherMapper.getTeacherList();
        sqlSession.close();
        return teacherList;
    }
    /*
    * 获得教学计划
    * */
    public List<TeacherPlan> GetTeacherPlan(String t_id , String cp_year){
        SqlSession sqlSession = Mybatis.getSqlSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("t_id",t_id);
        map.put("cp_year",cp_year);
        List<TeacherPlan> planList = teacherMapper.getTeacherProgramme(map);
        sqlSession.close();
        return planList;
    }
    /*
    * 修改成绩
    * */
    public List<Grade> GetGradeByClass(String tc_name){
        SqlSession sqlSession = Mybatis.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Grade> grades = mapper.GetGradeByClass(tc_name);
        sqlSession.close();
        return grades;
    }
    public boolean updateGrade(List<Grade> grades, String className) {
        SqlSession sqlSession = Mybatis.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        String teachingclassId = mapper.getTeachingclassIdbyName(className);

        Map<String, Object> map = new HashMap<>();
        map.put("tcId", teachingclassId);
        for (Grade grade : grades) {
            map.put("sId", grade.getS_id());
            map.put("ps", grade.getG_ps());
            map.put("exam", grade.getG_exam());
            map.put("final", grade.getG_final());
            mapper.UpdateGrade(map);
            sqlSession.commit();
        }
        sqlSession.close();
        return true;
    }

}
