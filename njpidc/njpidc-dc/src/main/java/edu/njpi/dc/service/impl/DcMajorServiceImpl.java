package edu.njpi.dc.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.njpi.dc.mapper.DcMajorMapper;
import edu.njpi.dc.domain.DcMajor;
import edu.njpi.dc.service.IDcMajorService;

/**
 * 专业表Service业务层处理
 * 
 * @author yuu
 * @date 2025-10-31
 */
@Service
public class DcMajorServiceImpl implements IDcMajorService 
{
    @Autowired
    private DcMajorMapper dcMajorMapper;

    /**
     * 查询专业表
     * 
     * @param id 专业表主键
     * @return 专业表
     */
    @Override
    public DcMajor selectDcMajorById(Long id)
    {
        return dcMajorMapper.selectDcMajorById(id);
    }

    /**
     * 查询专业表列表
     * 
     * @param dcMajor 专业表
     * @return 专业表
     */
    @Override
    public List<DcMajor> selectDcMajorList(DcMajor dcMajor)
    {
        return dcMajorMapper.selectDcMajorList(dcMajor);
    }

    /**
     * 新增专业表
     * 
     * @param dcMajor 专业表
     * @return 结果
     */
    @Override
    public int insertDcMajor(DcMajor dcMajor)
    {
        return dcMajorMapper.insertDcMajor(dcMajor);
    }

    /**
     * 修改专业表
     * 
     * @param dcMajor 专业表
     * @return 结果
     */
    @Override
    public int updateDcMajor(DcMajor dcMajor)
    {
        return dcMajorMapper.updateDcMajor(dcMajor);
    }

    /**
     * 批量删除专业表
     * 
     * @param ids 需要删除的专业表主键
     * @return 结果
     */
    @Override
    public int deleteDcMajorByIds(Long[] ids)
    {
        return dcMajorMapper.deleteDcMajorByIds(ids);
    }

    /**
     * 删除专业表信息
     * 
     * @param id 专业表主键
     * @return 结果
     */
    @Override
    public int deleteDcMajorById(Long id)
    {
        return dcMajorMapper.deleteDcMajorById(id);
    }
}
