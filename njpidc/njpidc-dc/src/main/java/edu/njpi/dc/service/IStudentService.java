package edu.njpi.dc.service;

import java.util.List;
import edu.njpi.dc.domain.Student;

/**
 * 学生列表Service接口
 * 
 * @author Yuu
 * @date 2025-10-24
 */
public interface IStudentService 
{
    /**
     * 查询学生列表
     * 
     * @param stuNo 学生列表主键
     * @return 学生列表
     */
    public Student selectStudentByStuNo(String stuNo);

    /**
     * 查询学生列表列表
     * 
     * @param student 学生列表
     * @return 学生列表集合
     */
    public List<Student> selectStudentList(Student student);

    /**
     * 新增学生列表
     * 
     * @param student 学生列表
     * @return 结果
     */
    public int insertStudent(Student student);

    /**
     * 修改学生列表
     * 
     * @param student 学生列表
     * @return 结果
     */
    public int updateStudent(Student student);

    /**
     * 批量删除学生列表
     * 
     * @param stuNos 需要删除的学生列表主键集合
     * @return 结果
     */
    public int deleteStudentByStuNos(String[] stuNos);

    /**
     * 删除学生列表信息
     * 
     * @param stuNo 学生列表主键
     * @return 结果
     */
    public int deleteStudentByStuNo(String stuNo);
}
