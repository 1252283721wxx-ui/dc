package edu.njpi.dc.service;

import java.util.List;
import edu.njpi.dc.domain.DcMajor;

/**
 * 专业表Service接口
 * 
 * @author yuu
 * @date 2025-10-31
 */
public interface IDcMajorService 
{
    /**
     * 查询专业表
     * 
     * @param id 专业表主键
     * @return 专业表
     */
    public DcMajor selectDcMajorById(Long id);

    /**
     * 查询专业表列表
     * 
     * @param dcMajor 专业表
     * @return 专业表集合
     */
    public List<DcMajor> selectDcMajorList(DcMajor dcMajor);

    /**
     * 新增专业表
     * 
     * @param dcMajor 专业表
     * @return 结果
     */
    public int insertDcMajor(DcMajor dcMajor);

    /**
     * 修改专业表
     * 
     * @param dcMajor 专业表
     * @return 结果
     */
    public int updateDcMajor(DcMajor dcMajor);

    /**
     * 批量删除专业表
     * 
     * @param ids 需要删除的专业表主键集合
     * @return 结果
     */
    public int deleteDcMajorByIds(Long[] ids);

    /**
     * 删除专业表信息
     * 
     * @param id 专业表主键
     * @return 结果
     */
    public int deleteDcMajorById(Long id);
}
