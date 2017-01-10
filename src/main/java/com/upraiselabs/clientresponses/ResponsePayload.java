package com.upraiselabs.clientresponses;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

public class ResponsePayload {
  private int statusCode = -1;
  private List<GenericResponse> responses = new ArrayList<GenericResponse>();

  public ResponsePayload(int statusCode) {
    this.statusCode = statusCode;
  }

  public ResponsePayload(int statusCode, List<GenericResponse> responses) {
    this.statusCode = statusCode;
    this.responses = responses;
  }

  public int getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(int statusCode) {
    this.statusCode = statusCode;
  }

  public List<GenericResponse> getResponses() {
    return responses;
  }

  public void setResponses(List<GenericResponse> responses) {
    this.responses = responses;
  }

  public JSONObject getResponsePayload() {
    JSONObject obj = new JSONObject();
    obj.put("statusCode", this.getStatusCode());
    obj.put("responses", this.getResponses());
    return obj;
  }
}
