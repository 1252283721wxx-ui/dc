package edu.njpi.dc.mapper;

import java.util.List;
import edu.njpi.dc.domain.SchoolAwards;

/**
 * 学校获奖（荣誉）情况Mapper接口
 * 
 * @author njpidc
 * @date 2025-12-12
 */
public interface SchoolAwardsMapper 
{
    /**
     * 查询学校获奖（荣誉）情况
     * 
     * @param id 学校获奖（荣誉）情况主键
     * @return 学校获奖（荣誉）情况
     */
    public SchoolAwards selectSchoolAwardsById(Long id);

    /**
     * 查询学校获奖（荣誉）情况列表
     * 
     * @param schoolAwards 学校获奖（荣誉）情况
     * @return 学校获奖（荣誉）情况集合
     */
    public List<SchoolAwards> selectSchoolAwardsList(SchoolAwards schoolAwards);

    /**
     * 新增学校获奖（荣誉）情况
     * 
     * @param schoolAwards 学校获奖（荣誉）情况
     * @return 结果
     */
    public int insertSchoolAwards(SchoolAwards schoolAwards);

    /**
     * 修改学校获奖（荣誉）情况
     * 
     * @param schoolAwards 学校获奖（荣誉）情况
     * @return 结果
     */
    public int updateSchoolAwards(SchoolAwards schoolAwards);

    /**
     * 删除学校获奖（荣誉）情况
     * 
     * @param id 学校获奖（荣誉）情况主键
     * @return 结果
     */
    public int deleteSchoolAwardsById(Long id);

    /**
     * 批量删除学校获奖（荣誉）情况
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSchoolAwardsByIds(Long[] ids);
}
