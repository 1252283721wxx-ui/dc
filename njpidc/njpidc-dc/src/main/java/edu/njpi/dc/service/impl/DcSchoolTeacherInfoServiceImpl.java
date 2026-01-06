package edu.njpi.dc.service.impl;

import java.util.List;
import edu.njpi.dc.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.njpi.dc.mapper.DcSchoolTeacherInfoMapper;
import edu.njpi.dc.domain.DcSchoolTeacherInfo;
import edu.njpi.dc.service.IDcSchoolTeacherInfoService;

/**
 * 1.4.1_校内教师基本信息Service业务层处理
 * 
 * @author njpidc
 * @date 2025-12-10
 */
@Service
public class DcSchoolTeacherInfoServiceImpl implements IDcSchoolTeacherInfoService 
{
    @Autowired
    private DcSchoolTeacherInfoMapper dcSchoolTeacherInfoMapper;

    /**
     * 查询1.4.1_校内教师基本信息
     * 
     * @param id 1.4.1_校内教师基本信息主键
     * @return 1.4.1_校内教师基本信息
     */
    @Override
    public DcSchoolTeacherInfo selectDcSchoolTeacherInfoById(Long id)
    {
        return dcSchoolTeacherInfoMapper.selectDcSchoolTeacherInfoById(id);
    }

    /**
     * 查询1.4.1_校内教师基本信息列表
     * 
     * @param dcSchoolTeacherInfo 1.4.1_校内教师基本信息
     * @return 1.4.1_校内教师基本信息
     */
    @Override
    public List<DcSchoolTeacherInfo> selectDcSchoolTeacherInfoList(DcSchoolTeacherInfo dcSchoolTeacherInfo)
    {
        return dcSchoolTeacherInfoMapper.selectDcSchoolTeacherInfoList(dcSchoolTeacherInfo);
    }

    /**
     * 新增1.4.1_校内教师基本信息
     * 
     * @param dcSchoolTeacherInfo 1.4.1_校内教师基本信息
     * @return 结果
     */
    @Override
    public int insertDcSchoolTeacherInfo(DcSchoolTeacherInfo dcSchoolTeacherInfo)
    {
        dcSchoolTeacherInfo.setCreateTime(DateUtils.getNowDate());
        return dcSchoolTeacherInfoMapper.insertDcSchoolTeacherInfo(dcSchoolTeacherInfo);
    }

    /**
     * 修改1.4.1_校内教师基本信息
     * 
     * @param dcSchoolTeacherInfo 1.4.1_校内教师基本信息
     * @return 结果
     */
    @Override
    public int updateDcSchoolTeacherInfo(DcSchoolTeacherInfo dcSchoolTeacherInfo)
    {
        dcSchoolTeacherInfo.setUpdateTime(DateUtils.getNowDate());
        return dcSchoolTeacherInfoMapper.updateDcSchoolTeacherInfo(dcSchoolTeacherInfo);
    }

    /**
     * 批量删除1.4.1_校内教师基本信息
     * 
     * @param ids 需要删除的1.4.1_校内教师基本信息主键
     * @return 结果
     */
    @Override
    public int deleteDcSchoolTeacherInfoByIds(Long[] ids)
    {
        return dcSchoolTeacherInfoMapper.deleteDcSchoolTeacherInfoByIds(ids);
    }

    /**
     * 删除1.4.1_校内教师基本信息信息
     * 
     * @param id 1.4.1_校内教师基本信息主键
     * @return 结果
     */
    @Override
    public int deleteDcSchoolTeacherInfoById(Long id)
    {
        return dcSchoolTeacherInfoMapper.deleteDcSchoolTeacherInfoById(id);
    }
}
