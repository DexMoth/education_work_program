package org.work_program.dtos;

public class VerifyCodeDto {
    private String method; //ms или email
    private String code;

    // геттеры и сеттеры
    public String getMethod() { return method; }
    public void setMethod(String method) { this.method = method; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
}