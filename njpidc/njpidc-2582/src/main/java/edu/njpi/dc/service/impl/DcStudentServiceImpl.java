package edu.njpi.dc.service.impl;

import edu.njpi.dc.domain.DcStudent;
import edu.njpi.dc.mapper.DcStudentMapper;
import edu.njpi.dc.service.DcStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Size;
import java.util.List;

@Service
public class DcStudentServiceImpl implements DcStudentService {

    @Autowired
    private DcStudentMapper dcStudentMapper;

    @Override
    public List<DcStudent> getAllStudent() {
        return dcStudentMapper.selectDcStudentList();
    }
}
