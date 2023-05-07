package com.thecitybank.pojo;

public class AppHdr {
    private String xmlns;
    private String creDt;
    private String msgDefIdr;
    private String bizMsgIdr;
    private To to;
    private Fr fr;
    private String bizSvc;
    public String getXmlns() {
        return xmlns;
    }
    public void setXmlns(String xmlns) {
        this.xmlns = xmlns;
    }
    public String getCreDt() {
        return creDt;
    }
    public void setCreDt(String creDt) {
        this.creDt = creDt;
    }
    public String getMsgDefIdr() {
        return msgDefIdr;
    }
    public void setMsgDefIdr(String msgDefIdr) {
        this.msgDefIdr = msgDefIdr;
    }
    public String getBizMsgIdr() {
        return bizMsgIdr;
    }
    public void setBizMsgIdr(String bizMsgIdr) {
        this.bizMsgIdr = bizMsgIdr;
    }
    public To getTo() {
        return to;
    }
    public void setTo(To to) {
        this.to = to;
    }
    public Fr getFr() {
        return fr;
    }
    public void setFr(Fr fr) {
        this.fr = fr;
    }
    public String getBizSvc() {
        return bizSvc;
    }
    public void setBizSvc(String bizSvc) {
        this.bizSvc = bizSvc;
    }
}
