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
import edu.njpi.dc.domain.SchoolAwards;
import edu.njpi.dc.service.ISchoolAwardsService;
import edu.njpi.dc.common.utils.poi.ExcelUtil;
import edu.njpi.dc.common.core.page.TableDataInfo;

/**
 * 学校获奖（荣誉）情况Controller
 * 
 * @author njpidc
 * @date 2025-12-12
 */
@RestController
@RequestMapping("/dc/school_awards")
public class SchoolAwardsController extends BaseController
{
    @Autowired
    private ISchoolAwardsService schoolAwardsService;

    /**
     * 查询学校获奖（荣誉）情况列表
     */
    @PreAuthorize("@ss.hasPermi('dc:school_awards:list')")
    @GetMapping("/list")
    public TableDataInfo list(SchoolAwards schoolAwards)
    {
        startPage();
        List<SchoolAwards> list = schoolAwardsService.selectSchoolAwardsList(schoolAwards);
        return getDataTable(list);
    }

    /**
     * 导出学校获奖（荣誉）情况列表
     */
    @PreAuthorize("@ss.hasPermi('dc:school_awards:export')")
    @Log(title = "学校获奖（荣誉）情况", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SchoolAwards schoolAwards)
    {
        List<SchoolAwards> list = schoolAwardsService.selectSchoolAwardsList(schoolAwards);
        ExcelUtil<SchoolAwards> util = new ExcelUtil<SchoolAwards>(SchoolAwards.class);
        util.exportExcel(response, list, "学校获奖（荣誉）情况数据");
    }

    /**
     * 获取学校获奖（荣誉）情况详细信息
     */
    @PreAuthorize("@ss.hasPermi('dc:school_awards:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(schoolAwardsService.selectSchoolAwardsById(id));
    }

    /**
     * 新增学校获奖（荣誉）情况
     */
    @PreAuthorize("@ss.hasPermi('dc:school_awards:add')")
    @Log(title = "学校获奖（荣誉）情况", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SchoolAwards schoolAwards)
    {
        return toAjax(schoolAwardsService.insertSchoolAwards(schoolAwards));
    }

    /**
     * 修改学校获奖（荣誉）情况
     */
    @PreAuthorize("@ss.hasPermi('dc:school_awards:edit')")
    @Log(title = "学校获奖（荣誉）情况", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SchoolAwards schoolAwards)
    {
        return toAjax(schoolAwardsService.updateSchoolAwards(schoolAwards));
    }

    /**
     * 删除学校获奖（荣誉）情况
     */
    @PreAuthorize("@ss.hasPermi('dc:school_awards:remove')")
    @Log(title = "学校获奖（荣誉）情况", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(schoolAwardsService.deleteSchoolAwardsByIds(ids));
    }
}
