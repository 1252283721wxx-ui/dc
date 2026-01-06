package edu.njpi.dc.mapper;

import java.util.List;
import edu.njpi.dc.domain.DcExternalTeacherInfo;

/**
 * 1.4.2_校外教师基本情况Mapper接口
 * 
 * @author njpidc
 * @date 2025-12-10
 */
public interface DcExternalTeacherInfoMapper 
{
    /**
     * 查询1.4.2_校外教师基本情况
     * 
     * @param id 1.4.2_校外教师基本情况主键
     * @return 1.4.2_校外教师基本情况
     */
    public DcExternalTeacherInfo selectDcExternalTeacherInfoById(Long id);

    /**
     * 查询1.4.2_校外教师基本情况列表
     * 
     * @param dcExternalTeacherInfo 1.4.2_校外教师基本情况
     * @return 1.4.2_校外教师基本情况集合
     */
    public List<DcExternalTeacherInfo> selectDcExternalTeacherInfoList(DcExternalTeacherInfo dcExternalTeacherInfo);

    /**
     * 新增1.4.2_校外教师基本情况
     * 
     * @param dcExternalTeacherInfo 1.4.2_校外教师基本情况
     * @return 结果
     */
    public int insertDcExternalTeacherInfo(DcExternalTeacherInfo dcExternalTeacherInfo);

    /**
     * 修改1.4.2_校外教师基本情况
     * 
     * @param dcExternalTeacherInfo 1.4.2_校外教师基本情况
     * @return 结果
     */
    public int updateDcExternalTeacherInfo(DcExternalTeacherInfo dcExternalTeacherInfo);

    /**
     * 删除1.4.2_校外教师基本情况
     * 
     * @param id 1.4.2_校外教师基本情况主键
     * @return 结果
     */
    public int deleteDcExternalTeacherInfoById(Long id);

    /**
     * 批量删除1.4.2_校外教师基本情况
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDcExternalTeacherInfoByIds(Long[] ids);
}
