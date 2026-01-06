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
import edu.njpi.dc.domain.DcExternalTeacherInfo;
import edu.njpi.dc.service.IDcExternalTeacherInfoService;
import edu.njpi.dc.common.utils.poi.ExcelUtil;
import edu.njpi.dc.common.core.page.TableDataInfo;

/**
 * 1.4.2_校外教师基本情况Controller
 * 
 * @author njpidc
 * @date 2025-12-10
 */
@RestController
@RequestMapping("/dc/external_teacher_info")
public class DcExternalTeacherInfoController extends BaseController
{
    @Autowired
    private IDcExternalTeacherInfoService dcExternalTeacherInfoService;

    /**
     * 查询1.4.2_校外教师基本情况列表
     */
    @PreAuthorize("@ss.hasPermi('dc:external_teacher_info:list')")
    @GetMapping("/list")
    public TableDataInfo list(DcExternalTeacherInfo dcExternalTeacherInfo)
    {
        startPage();
        List<DcExternalTeacherInfo> list = dcExternalTeacherInfoService.selectDcExternalTeacherInfoList(dcExternalTeacherInfo);
        return getDataTable(list);
    }

    /**
     * 导出1.4.2_校外教师基本情况列表
     */
    @PreAuthorize("@ss.hasPermi('dc:external_teacher_info:export')")
    @Log(title = "1.4.2_校外教师基本情况", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DcExternalTeacherInfo dcExternalTeacherInfo)
    {
        List<DcExternalTeacherInfo> list = dcExternalTeacherInfoService.selectDcExternalTeacherInfoList(dcExternalTeacherInfo);
        ExcelUtil<DcExternalTeacherInfo> util = new ExcelUtil<DcExternalTeacherInfo>(DcExternalTeacherInfo.class);
        util.exportExcel(response, list, "1.4.2_校外教师基本情况数据");
    }

    /**
     * 获取1.4.2_校外教师基本情况详细信息
     */
    @PreAuthorize("@ss.hasPermi('dc:external_teacher_info:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(dcExternalTeacherInfoService.selectDcExternalTeacherInfoById(id));
    }

    /**
     * 新增1.4.2_校外教师基本情况
     */
    @PreAuthorize("@ss.hasPermi('dc:external_teacher_info:add')")
    @Log(title = "1.4.2_校外教师基本情况", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DcExternalTeacherInfo dcExternalTeacherInfo)
    {
        return toAjax(dcExternalTeacherInfoService.insertDcExternalTeacherInfo(dcExternalTeacherInfo));
    }

    /**
     * 修改1.4.2_校外教师基本情况
     */
    @PreAuthorize("@ss.hasPermi('dc:external_teacher_info:edit')")
    @Log(title = "1.4.2_校外教师基本情况", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DcExternalTeacherInfo dcExternalTeacherInfo)
    {
        return toAjax(dcExternalTeacherInfoService.updateDcExternalTeacherInfo(dcExternalTeacherInfo));
    }

    /**
     * 删除1.4.2_校外教师基本情况
     */
    @PreAuthorize("@ss.hasPermi('dc:external_teacher_info:remove')")
    @Log(title = "1.4.2_校外教师基本情况", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(dcExternalTeacherInfoService.deleteDcExternalTeacherInfoByIds(ids));
    }
}
