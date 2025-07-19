package com.jida.tijian.service;

import com.jida.tijian.domain.Doctor;
import com.jida.tijian.dto.ResponseObject;

public interface DoctorService {
    ResponseObject doctorLogin(Doctor doctor);
}
