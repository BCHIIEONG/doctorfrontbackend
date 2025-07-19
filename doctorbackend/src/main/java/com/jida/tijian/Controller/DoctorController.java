package com.jida.tijian.controller;

import com.jida.tijian.domain.Doctor;
import com.jida.tijian.dto.ResponseObject;
import com.jida.tijian.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 医生模块的控制器
 */
@RestController
public class DoctorController {
    @Autowired
    DoctorService doctorService;

    @RequestMapping("/doctorLogin")
    public ResponseObject login(@RequestBody Doctor doctor){

        return doctorService.doctorLogin(doctor);

    }

}
