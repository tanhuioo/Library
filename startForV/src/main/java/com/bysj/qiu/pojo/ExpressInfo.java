package com.bysj.qiu.pojo;
//快递基本信息
public class ExpressInfo {
    private int id;
    private String transfername;
    private String tellphone;
    private String address;
    private String buyer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTransfername() {
        return transfername;
    }

    public void setTransfername(String transfername) {
        this.transfername = transfername;
    }

    public String getTellphone() {
        return tellphone;
    }

    public void setTellphone(String tellphone) {
        this.tellphone = tellphone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    @Override
    public String toString() {
        return "ExpressInfo{" +
                "id=" + id +
                ", transfername='" + transfername + '\'' +
                ", tellphone=" + tellphone +
                ", address='" + address + '\'' +
                ", buyer='" + buyer + '\'' +
                '}';
    }
}
