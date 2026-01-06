package edu.njpi.dc.service.impl;

import java.util.List;
import edu.njpi.dc.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.njpi.dc.mapper.DcExternalTeacherInfoMapper;
import edu.njpi.dc.domain.DcExternalTeacherInfo;
import edu.njpi.dc.service.IDcExternalTeacherInfoService;

/**
 * 1.4.2_校外教师基本情况Service业务层处理
 * 
 * @author njpidc
 * @date 2025-12-10
 */
@Service
public class DcExternalTeacherInfoServiceImpl implements IDcExternalTeacherInfoService 
{
    @Autowired
    private DcExternalTeacherInfoMapper dcExternalTeacherInfoMapper;

    /**
     * 查询1.4.2_校外教师基本情况
     * 
     * @param id 1.4.2_校外教师基本情况主键
     * @return 1.4.2_校外教师基本情况
     */
    @Override
    public DcExternalTeacherInfo selectDcExternalTeacherInfoById(Long id)
    {
        return dcExternalTeacherInfoMapper.selectDcExternalTeacherInfoById(id);
    }

    /**
     * 查询1.4.2_校外教师基本情况列表
     * 
     * @param dcExternalTeacherInfo 1.4.2_校外教师基本情况
     * @return 1.4.2_校外教师基本情况
     */
    @Override
    public List<DcExternalTeacherInfo> selectDcExternalTeacherInfoList(DcExternalTeacherInfo dcExternalTeacherInfo)
    {
        return dcExternalTeacherInfoMapper.selectDcExternalTeacherInfoList(dcExternalTeacherInfo);
    }

    /**
     * 新增1.4.2_校外教师基本情况
     * 
     * @param dcExternalTeacherInfo 1.4.2_校外教师基本情况
     * @return 结果
     */
    @Override
    public int insertDcExternalTeacherInfo(DcExternalTeacherInfo dcExternalTeacherInfo)
    {
        dcExternalTeacherInfo.setCreateTime(DateUtils.getNowDate());
        return dcExternalTeacherInfoMapper.insertDcExternalTeacherInfo(dcExternalTeacherInfo);
    }

    /**
     * 修改1.4.2_校外教师基本情况
     * 
     * @param dcExternalTeacherInfo 1.4.2_校外教师基本情况
     * @return 结果
     */
    @Override
    public int updateDcExternalTeacherInfo(DcExternalTeacherInfo dcExternalTeacherInfo)
    {
        dcExternalTeacherInfo.setUpdateTime(DateUtils.getNowDate());
        return dcExternalTeacherInfoMapper.updateDcExternalTeacherInfo(dcExternalTeacherInfo);
    }

    /**
     * 批量删除1.4.2_校外教师基本情况
     * 
     * @param ids 需要删除的1.4.2_校外教师基本情况主键
     * @return 结果
     */
    @Override
    public int deleteDcExternalTeacherInfoByIds(Long[] ids)
    {
        return dcExternalTeacherInfoMapper.deleteDcExternalTeacherInfoByIds(ids);
    }

    /**
     * 删除1.4.2_校外教师基本情况信息
     * 
     * @param id 1.4.2_校外教师基本情况主键
     * @return 结果
     */
    @Override
    public int deleteDcExternalTeacherInfoById(Long id)
    {
        return dcExternalTeacherInfoMapper.deleteDcExternalTeacherInfoById(id);
    }
}
