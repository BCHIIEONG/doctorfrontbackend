package com.jida.tijian.handler;

import com.jida.tijian.dto.ResponseObject;
import com.jida.tijian.exception.TijianAPPException;
import com.jida.tijian.exception.TijianAPPExceptionEnum;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    //只处理业务异常
    @ResponseBody
    @ExceptionHandler(TijianAPPException.class)
    public ResponseObject handlerTijianAppException(TijianAPPException e){
        e.printStackTrace();
        return new ResponseObject(e.getCode(),e.getMessage());
    }

   /*
   @ExceptionHandler(TijianAppException.class)
    @ResponseBody  //返回json格式数据给前端
    public ApiResponse handleTijianAppException(TijianAppException e){
        e.printStackTrace();
        System.out.println("异常信息："+e.getStackTrace());

        return new ApiResponse(e.getCode(),e.getMessage());

    }*/




    //处理所有异常

    @ExceptionHandler(Exception.class)
    @ResponseBody  //返回json格式数据给前端
    public ResponseObject handleAllException(Exception e){
        e.printStackTrace();
        //System.out.println("异常信息："+e.getStackTrace()+",message:"+e.getMessage());
        return new ResponseObject(TijianAPPExceptionEnum.SYSTEM_ERROR.getCode(),TijianAPPExceptionEnum.SYSTEM_ERROR.getMessage());

    }

}
