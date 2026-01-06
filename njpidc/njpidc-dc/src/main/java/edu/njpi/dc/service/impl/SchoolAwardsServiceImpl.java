package edu.njpi.dc.service.impl;

import java.util.List;
import edu.njpi.dc.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.njpi.dc.mapper.SchoolAwardsMapper;
import edu.njpi.dc.domain.SchoolAwards;
import edu.njpi.dc.service.ISchoolAwardsService;

/**
 * 学校获奖（荣誉）情况Service业务层处理
 * 
 * @author njpidc
 * @date 2025-12-12
 */
@Service
public class SchoolAwardsServiceImpl implements ISchoolAwardsService 
{
    @Autowired
    private SchoolAwardsMapper schoolAwardsMapper;

    /**
     * 查询学校获奖（荣誉）情况
     * 
     * @param id 学校获奖（荣誉）情况主键
     * @return 学校获奖（荣誉）情况
     */
    @Override
    public SchoolAwards selectSchoolAwardsById(Long id)
    {
        return schoolAwardsMapper.selectSchoolAwardsById(id);
    }

    /**
     * 查询学校获奖（荣誉）情况列表
     * 
     * @param schoolAwards 学校获奖（荣誉）情况
     * @return 学校获奖（荣誉）情况
     */
    @Override
    public List<SchoolAwards> selectSchoolAwardsList(SchoolAwards schoolAwards)
    {
        return schoolAwardsMapper.selectSchoolAwardsList(schoolAwards);
    }

    /**
     * 新增学校获奖（荣誉）情况
     * 
     * @param schoolAwards 学校获奖（荣誉）情况
     * @return 结果
     */
    @Override
    public int insertSchoolAwards(SchoolAwards schoolAwards)
    {
        schoolAwards.setCreateTime(DateUtils.getNowDate());
        return schoolAwardsMapper.insertSchoolAwards(schoolAwards);
    }

    /**
     * 修改学校获奖（荣誉）情况
     * 
     * @param schoolAwards 学校获奖（荣誉）情况
     * @return 结果
     */
    @Override
    public int updateSchoolAwards(SchoolAwards schoolAwards)
    {
        schoolAwards.setUpdateTime(DateUtils.getNowDate());
        return schoolAwardsMapper.updateSchoolAwards(schoolAwards);
    }

    /**
     * 批量删除学校获奖（荣誉）情况
     * 
     * @param ids 需要删除的学校获奖（荣誉）情况主键
     * @return 结果
     */
    @Override
    public int deleteSchoolAwardsByIds(Long[] ids)
    {
        return schoolAwardsMapper.deleteSchoolAwardsByIds(ids);
    }

    /**
     * 删除学校获奖（荣誉）情况信息
     * 
     * @param id 学校获奖（荣誉）情况主键
     * @return 结果
     */
    @Override
    public int deleteSchoolAwardsById(Long id)
    {
        return schoolAwardsMapper.deleteSchoolAwardsById(id);
    }
}
