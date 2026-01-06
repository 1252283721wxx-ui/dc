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
import edu.njpi.dc.domain.DcMajor;
import edu.njpi.dc.service.IDcMajorService;
import edu.njpi.dc.common.utils.poi.ExcelUtil;
import edu.njpi.dc.common.core.page.TableDataInfo;

/**
 * 专业表Controller
 * 
 * @author yuu
 * @date 2025-10-31
 */
@RestController
@RequestMapping("/student/major")
public class DcMajorController extends BaseController
{
    @Autowired
    private IDcMajorService dcMajorService;

    /**
     * 查询专业表列表
     */
    @PreAuthorize("@ss.hasPermi('student:major:list')")
    @GetMapping("/list")
    public TableDataInfo list(DcMajor dcMajor)
    {
        startPage();
        List<DcMajor> list = dcMajorService.selectDcMajorList(dcMajor);
        return getDataTable(list);
    }

    /**
     * 导出专业表列表
     */
    @PreAuthorize("@ss.hasPermi('student:major:export')")
    @Log(title = "专业表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DcMajor dcMajor)
    {
        List<DcMajor> list = dcMajorService.selectDcMajorList(dcMajor);
        ExcelUtil<DcMajor> util = new ExcelUtil<DcMajor>(DcMajor.class);
        util.exportExcel(response, list, "专业表数据");
    }

    /**
     * 获取专业表详细信息
     */
    @PreAuthorize("@ss.hasPermi('student:major:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(dcMajorService.selectDcMajorById(id));
    }

    /**
     * 新增专业表
     */
    @PreAuthorize("@ss.hasPermi('student:major:add')")
    @Log(title = "专业表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DcMajor dcMajor)
    {
        return toAjax(dcMajorService.insertDcMajor(dcMajor));
    }

    /**
     * 修改专业表
     */
    @PreAuthorize("@ss.hasPermi('student:major:edit')")
    @Log(title = "专业表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DcMajor dcMajor)
    {
        return toAjax(dcMajorService.updateDcMajor(dcMajor));
    }

    /**
     * 删除专业表
     */
    @PreAuthorize("@ss.hasPermi('student:major:remove')")
    @Log(title = "专业表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(dcMajorService.deleteDcMajorByIds(ids));
    }
}
