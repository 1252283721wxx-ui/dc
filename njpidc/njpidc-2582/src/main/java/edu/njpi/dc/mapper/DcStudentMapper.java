package edu.njpi.dc.mapper;

import edu.njpi.dc.domain.DcStudent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DcStudentMapper{
//    int insert(DcStudent stu);
//
//    DcStudent selectDcStudentById(String stuno);
//
    List<DcStudent> selectDcStudentList();
//    int update(DcStudent stu);
//
//    int delete(DcStudent stu);
}
