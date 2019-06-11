package com.erikriosetiawan.konversiusdtoidr;

public class ConvertUsdToIdr {

    private Double usd;

    protected Double getUsd() {
        return usd;
    }

    protected void setUsd(Double usd) {
        this.usd = usd;
    }

    protected Double result() {
        return getUsd() * 13157;
    }
}
