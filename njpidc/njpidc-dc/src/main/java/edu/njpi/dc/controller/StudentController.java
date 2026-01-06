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
import edu.njpi.dc.domain.Student;
import edu.njpi.dc.service.IStudentService;
import edu.njpi.dc.common.utils.poi.ExcelUtil;
import edu.njpi.dc.common.core.page.TableDataInfo;

/**
 * 学生列表Controller
 * 
 * @author Yuu
 * @date 2025-10-24
 */
@RestController
@RequestMapping("/dc/student")
public class StudentController extends BaseController
{
    @Autowired
    private IStudentService studentService;

    /**
     * 查询学生列表列表
     */
    @PreAuthorize("@ss.hasPermi('dc:student:list')")
    @GetMapping("/list")
    public TableDataInfo list(Student student)
    {
        startPage();
        List<Student> list = studentService.selectStudentList(student);
        return getDataTable(list);
    }

    /**
     * 导出学生列表列表
     */
    @PreAuthorize("@ss.hasPermi('dc:student:export')")
    @Log(title = "学生列表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Student student)
    {
        List<Student> list = studentService.selectStudentList(student);
        ExcelUtil<Student> util = new ExcelUtil<Student>(Student.class);
        util.exportExcel(response, list, "学生列表数据");
    }

    /**
     * 获取学生列表详细信息
     */
    @PreAuthorize("@ss.hasPermi('dc:student:query')")
    @GetMapping(value = "/{stuNo}")
    public AjaxResult getInfo(@PathVariable("stuNo") String stuNo)
    {
        return success(studentService.selectStudentByStuNo(stuNo));
    }

    /**
     * 新增学生列表
     */
    @PreAuthorize("@ss.hasPermi('dc:student:add')")
    @Log(title = "学生列表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Student student)
    {
        return toAjax(studentService.insertStudent(student));
    }

    /**
     * 修改学生列表
     */
    @PreAuthorize("@ss.hasPermi('dc:student:edit')")
    @Log(title = "学生列表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Student student)
    {
        return toAjax(studentService.updateStudent(student));
    }

    /**
     * 删除学生列表
     */
    @PreAuthorize("@ss.hasPermi('dc:student:remove')")
    @Log(title = "学生列表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{stuNos}")
    public AjaxResult remove(@PathVariable String[] stuNos)
    {
        return toAjax(studentService.deleteStudentByStuNos(stuNos));
    }
}
