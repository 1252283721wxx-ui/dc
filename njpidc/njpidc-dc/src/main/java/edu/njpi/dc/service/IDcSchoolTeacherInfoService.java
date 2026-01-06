package edu.njpi.dc.service;

import java.util.List;
import edu.njpi.dc.domain.DcSchoolTeacherInfo;

/**
 * 1.4.1_校内教师基本信息Service接口
 * 
 * @author njpidc
 * @date 2025-12-10
 */
public interface IDcSchoolTeacherInfoService 
{
    /**
     * 查询1.4.1_校内教师基本信息
     * 
     * @param id 1.4.1_校内教师基本信息主键
     * @return 1.4.1_校内教师基本信息
     */
    public DcSchoolTeacherInfo selectDcSchoolTeacherInfoById(Long id);

    /**
     * 查询1.4.1_校内教师基本信息列表
     * 
     * @param dcSchoolTeacherInfo 1.4.1_校内教师基本信息
     * @return 1.4.1_校内教师基本信息集合
     */
    public List<DcSchoolTeacherInfo> selectDcSchoolTeacherInfoList(DcSchoolTeacherInfo dcSchoolTeacherInfo);

    /**
     * 新增1.4.1_校内教师基本信息
     * 
     * @param dcSchoolTeacherInfo 1.4.1_校内教师基本信息
     * @return 结果
     */
    public int insertDcSchoolTeacherInfo(DcSchoolTeacherInfo dcSchoolTeacherInfo);

    /**
     * 修改1.4.1_校内教师基本信息
     * 
     * @param dcSchoolTeacherInfo 1.4.1_校内教师基本信息
     * @return 结果
     */
    public int updateDcSchoolTeacherInfo(DcSchoolTeacherInfo dcSchoolTeacherInfo);

    /**
     * 批量删除1.4.1_校内教师基本信息
     * 
     * @param ids 需要删除的1.4.1_校内教师基本信息主键集合
     * @return 结果
     */
    public int deleteDcSchoolTeacherInfoByIds(Long[] ids);

    /**
     * 删除1.4.1_校内教师基本信息信息
     * 
     * @param id 1.4.1_校内教师基本信息主键
     * @return 结果
     */
    public int deleteDcSchoolTeacherInfoById(Long id);
}
