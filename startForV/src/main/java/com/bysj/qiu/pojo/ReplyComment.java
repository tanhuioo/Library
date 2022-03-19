package com.bysj.qiu.pojo;

import java.util.Date;

public class ReplyComment {
    private int sonid;
    private String replyer;
    private String replytext;
    private String mytowho;
    private Date replytime;

    public int getSonid() {
        return sonid;
    }

    public void setSonid(int sonid) {
        this.sonid = sonid;
    }

    public String getReplyer() {
        return replyer;
    }

    public void setReplyer(String replyer) {
        this.replyer = replyer;
    }

    public String getReplytext() {
        return replytext;
    }

    public void setReplytext(String replytext) {
        this.replytext = replytext;
    }

    public String getMytowho() {
        return mytowho;
    }

    public void setMytowho(String mytowho) {
        this.mytowho = mytowho;
    }

    public Date getReplytime() {
        return replytime;
    }

    public void setReplytime(Date replytime) {
        this.replytime = replytime;
    }

    @Override
    public String toString() {
        return "ReplyComment{" +
                "sonid=" + sonid +
                ", replyer='" + replyer + '\'' +
                ", replytext='" + replytext + '\'' +
                ", mytowho='" + mytowho + '\'' +
                ", replytime=" + replytime +
                '}';
    }
}
