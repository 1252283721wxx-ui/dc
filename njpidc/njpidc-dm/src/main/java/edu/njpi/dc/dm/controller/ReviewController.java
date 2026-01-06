package edu.njpi.dc.dm.controller;

import edu.njpi.dc.common.core.controller.BaseController;
import edu.njpi.dc.common.core.domain.AjaxResult;
import edu.njpi.dc.dm.domain.dto.ReviewSubmitDto;
import edu.njpi.dc.dm.service.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/review")
public class ReviewController extends BaseController {

    /**
     * submit
     * reSubmit
     * batchSubmit
     * <p>
     * deptApprove
     * deptReject
     * deptBatchApprove
     * deptBatchReject
     * <p>
     * schoolApprove
     * schoolReject
     * schoolBatchApprove
     * schoolBatchReject
     *
     */


    @Autowired
    private IReviewService reviewService;


    @PostMapping("/submit")
    @Transactional
    public AjaxResult submit(@RequestBody ReviewSubmitDto reviewSubmitDto) {
        int num = reviewService.submit(reviewSubmitDto);
        if (num == 0) {
            return error("数据已提交，不允许重复提交");
        } else {
            return toAjax(num);
        }
    }

    /**
     * 部门审核通过
     */
    @PostMapping("/dept/approve")
    @Transactional
    public AjaxResult deptApprove(Long itemId, String comment) {
        return toAjax(reviewService.deptApprove(itemId, comment));
    }

    /**
     * 部门审核驳回
     */
    @PostMapping("/dept/reject")
    @Transactional
    public AjaxResult deptReject(Long itemId, String comment) {
        return toAjax(reviewService.deptReject(itemId, comment));
    }

    /**
     * 学校审核通过
     */
    @PostMapping("/school/approve")
    @Transactional
    public AjaxResult schoolApprove(Long itemId, String comment) {
        return toAjax(reviewService.schoolApprove(itemId, comment));
    }

    /**
     * 学校审核驳回
     */
    @PostMapping("/school/reject")
    @Transactional
    public AjaxResult schoolReject(Long itemId, String comment) {
        return toAjax(reviewService.schoolReject(itemId, comment));
    }


}
