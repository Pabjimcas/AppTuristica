package com.example.pabji.appturistica.models;

/**
 * Created by pabji on 01/06/2016.
 */
public class ResponseModel {
    String status;
    DataModel data;

    public ResponseModel(String status, DataModel data) {
        this.status = status;
        this.data = data;
    }
    public ResponseModel(){}

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DataModel getData() {
        return data;
    }

    public void setData(DataModel data) {
        this.data = data;
    }
}
