package edu.njpi.dc.dm.service;

import edu.njpi.dc.dm.domain.dto.ReviewSubmitDto;

public interface IReviewService {
    /**
     * 提交审核
     */
    int submit(ReviewSubmitDto reviewSubmitDto);

    /**
     * 部门审核通过
     */
    int deptApprove(Long itemId, String comment);

    /**
     * 部门审核驳回
     */
    int deptReject(Long itemId, String comment);

    /**
     * 学校审核通过
     */
    int schoolApprove(Long itemId, String comment);

    /**
     * 学校审核驳回
     */
    int schoolReject(Long itemId, String comment);
}
