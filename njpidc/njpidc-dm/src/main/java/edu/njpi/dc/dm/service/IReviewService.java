package edu.njpi.dc.dm.service;

import edu.njpi.dc.dm.domain.dto.ReviewSubmitDto;

public interface IReviewService {
    int submit(ReviewSubmitDto reviewSubmitDto);
}
