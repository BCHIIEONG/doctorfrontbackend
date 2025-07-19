package com.jida.tijian.exception;

public enum TijianAPPExceptionEnum {
    SYSTEM_ERROR(2003,"系统错误"),
    DOCTOR_NOT_HAVE_ACCOUNT(2005,"该账户不存在"),DOCTOR_PASSWORD_WRONG(2006,"医生密码错误");

    TijianAPPExceptionEnum() {

    }

    TijianAPPExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;
    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
