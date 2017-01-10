package com.upraiselabs.clientresponses;

public class GenericResponse {
  private String msg = "";
  private String type = "form_level";
  private String field = "";

  public GenericResponse() {
  }

  public GenericResponse(String msg) {
    this.msg = msg;
  }

  public GenericResponse(String msg, String type) {
    this.msg = msg;
    this.type = type;
  }

  public GenericResponse(String msg, String type, String field) {
    this.msg = msg;
    this.type = type;
    this.field = field;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getField() {
    return field;
  }

  public void setField(String field) {
    this.field = field;
  }

}
