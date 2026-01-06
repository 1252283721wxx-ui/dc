package edu.njpi.dc.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.njpi.dc.common.annotation.Log;
import edu.njpi.dc.common.core.controller.BaseController;
import edu.njpi.dc.common.core.domain.AjaxResult;
import edu.njpi.dc.common.enums.BusinessType;
import edu.njpi.dc.domain.DcSchoolTeacherInfo;
import edu.njpi.dc.service.IDcSchoolTeacherInfoService;
import edu.njpi.dc.common.utils.poi.ExcelUtil;
import edu.njpi.dc.common.core.page.TableDataInfo;

/**
 * 1.4.1_校内教师基本信息Controller
 * 
 * @author njpidc
 * @date 2025-12-10
 */
@RestController
@RequestMapping("/dc/school_teacher_info")
public class DcSchoolTeacherInfoController extends BaseController
{
    @Autowired
    private IDcSchoolTeacherInfoService dcSchoolTeacherInfoService;

    /**
     * 查询1.4.1_校内教师基本信息列表
     */
    @PreAuthorize("@ss.hasPermi('dc:school_teacher_info:list')")
    @GetMapping("/list")
    public TableDataInfo list(DcSchoolTeacherInfo dcSchoolTeacherInfo)
    {
        startPage();
        List<DcSchoolTeacherInfo> list = dcSchoolTeacherInfoService.selectDcSchoolTeacherInfoList(dcSchoolTeacherInfo);
        return getDataTable(list);
    }

    /**
     * 导出1.4.1_校内教师基本信息列表
     */
    @PreAuthorize("@ss.hasPermi('dc:school_teacher_info:export')")
    @Log(title = "1.4.1_校内教师基本信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DcSchoolTeacherInfo dcSchoolTeacherInfo)
    {
        List<DcSchoolTeacherInfo> list = dcSchoolTeacherInfoService.selectDcSchoolTeacherInfoList(dcSchoolTeacherInfo);
        ExcelUtil<DcSchoolTeacherInfo> util = new ExcelUtil<DcSchoolTeacherInfo>(DcSchoolTeacherInfo.class);
        util.exportExcel(response, list, "1.4.1_校内教师基本信息数据");
    }

    /**
     * 获取1.4.1_校内教师基本信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('dc:school_teacher_info:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(dcSchoolTeacherInfoService.selectDcSchoolTeacherInfoById(id));
    }

    /**
     * 新增1.4.1_校内教师基本信息
     */
    @PreAuthorize("@ss.hasPermi('dc:school_teacher_info:add')")
    @Log(title = "1.4.1_校内教师基本信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DcSchoolTeacherInfo dcSchoolTeacherInfo)
    {
        return toAjax(dcSchoolTeacherInfoService.insertDcSchoolTeacherInfo(dcSchoolTeacherInfo));
    }

    /**
     * 修改1.4.1_校内教师基本信息
     */
    @PreAuthorize("@ss.hasPermi('dc:school_teacher_info:edit')")
    @Log(title = "1.4.1_校内教师基本信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DcSchoolTeacherInfo dcSchoolTeacherInfo)
    {
        return toAjax(dcSchoolTeacherInfoService.updateDcSchoolTeacherInfo(dcSchoolTeacherInfo));
    }

    /**
     * 删除1.4.1_校内教师基本信息
     */
    @PreAuthorize("@ss.hasPermi('dc:school_teacher_info:remove')")
    @Log(title = "1.4.1_校内教师基本信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(dcSchoolTeacherInfoService.deleteDcSchoolTeacherInfoByIds(ids));
    }
}
