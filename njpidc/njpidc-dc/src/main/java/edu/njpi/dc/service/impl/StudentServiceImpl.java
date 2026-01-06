package edu.njpi.dc.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.njpi.dc.mapper.StudentMapper;
import edu.njpi.dc.domain.Student;
import edu.njpi.dc.service.IStudentService;

/**
 * 学生列表Service业务层处理
 * 
 * @author Yuu
 * @date 2025-10-24
 */
@Service
public class StudentServiceImpl implements IStudentService 
{
    @Autowired
    private StudentMapper studentMapper;

    /**
     * 查询学生列表
     * 
     * @param stuNo 学生列表主键
     * @return 学生列表
     */
    @Override
    public Student selectStudentByStuNo(String stuNo)
    {
        return studentMapper.selectStudentByStuNo(stuNo);
    }

    /**
     * 查询学生列表列表
     * 
     * @param student 学生列表
     * @return 学生列表
     */
    @Override
    public List<Student> selectStudentList(Student student)
    {
        return studentMapper.selectStudentList(student);
    }

    /**
     * 新增学生列表
     * 
     * @param student 学生列表
     * @return 结果
     */
    @Override
    public int insertStudent(Student student)
    {
        return studentMapper.insertStudent(student);
    }

    /**
     * 修改学生列表
     * 
     * @param student 学生列表
     * @return 结果
     */
    @Override
    public int updateStudent(Student student)
    {
        return studentMapper.updateStudent(student);
    }

    /**
     * 批量删除学生列表
     * 
     * @param stuNos 需要删除的学生列表主键
     * @return 结果
     */
    @Override
    public int deleteStudentByStuNos(String[] stuNos)
    {
        return studentMapper.deleteStudentByStuNos(stuNos);
    }

    /**
     * 删除学生列表信息
     * 
     * @param stuNo 学生列表主键
     * @return 结果
     */
    @Override
    public int deleteStudentByStuNo(String stuNo)
    {
        return studentMapper.deleteStudentByStuNo(stuNo);
    }
}
