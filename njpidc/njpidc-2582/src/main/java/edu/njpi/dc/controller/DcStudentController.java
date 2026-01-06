package edu.njpi.dc.controller;

import edu.njpi.dc.domain.DcStudent;
import edu.njpi.dc.service.DcStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class DcStudentController {

    @Autowired
    private DcStudentService dcStudentService;

    @GetMapping("/list")
    public List<DcStudent> getAllStudent() {
        return dcStudentService.getAllStudent();
    }

}
