package com.example.koidev.mvp_dagger_rx.mvp.model;

public class ForecastResponse {
    private ForecastResponseData[] data;
    private int totalevent;
    private int perpages;
    private String status;

    public ForecastResponseData[] getData() {
        return this.data;
    }

    public void setData(ForecastResponseData[] data) {
        this.data = data;
    }

    public int getTotalevent() {
        return this.totalevent;
    }

    public void setTotalevent(int totalevent) {
        this.totalevent = totalevent;
    }

    public int getPerpages() {
        return this.perpages;
    }

    public void setPerpages(int perpages) {
        this.perpages = perpages;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
