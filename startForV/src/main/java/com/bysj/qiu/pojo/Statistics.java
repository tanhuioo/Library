package com.bysj.qiu.pojo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class Statistics {
    private BigDecimal sumconsume;
    private String fivemonth;

    public BigDecimal getSumconsume() {
        return sumconsume;
    }

    public void setSumconsume(BigDecimal sumconsume) {
        this.sumconsume = sumconsume;
    }

    public String getFivemonth() {
        return fivemonth;
    }

    public void setFivemonth(String fivemonth) {
        this.fivemonth = fivemonth;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "sumconsume=" + sumconsume +
                ", fivemonth=" + fivemonth +
                '}';
    }
}
