package com.jida.tijian.service;


import com.jida.tijian.domain.Doctor;
import com.jida.tijian.dto.ResponseObject;
import com.jida.tijian.exception.TijianAPPException;
import com.jida.tijian.exception.TijianAPPExceptionEnum;
import com.jida.tijian.mapper.DoctorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    DoctorMapper doctorMapper;

    @Override
    public ResponseObject doctorLogin(Doctor doctor){
        //doctorMapper.selectByPrimaryKey()
        Doctor result= doctorMapper.selectByDocCode(doctor);

        if(result==null) {
            //抛出异常
            //System.out.println("没有找到该名医生");
            //return new ResponseObject(3001,"您尚未注册");
            throw new TijianAPPException(TijianAPPExceptionEnum.DOCTOR_NOT_HAVE_ACCOUNT.getCode(), TijianAPPExceptionEnum.DOCTOR_NOT_HAVE_ACCOUNT.getMessage());
        } else if (!result.getPassword().equals(doctor.getPassword())) {
                throw new TijianAPPException(TijianAPPExceptionEnum.DOCTOR_PASSWORD_WRONG.getCode(),TijianAPPExceptionEnum.DOCTOR_PASSWORD_WRONG.getMessage());


        }

        else{
            return new ResponseObject(ResponseObject.SUCCESS_STATUS,ResponseObject.SUCCESS_DESC,result);
        }
    }
}





