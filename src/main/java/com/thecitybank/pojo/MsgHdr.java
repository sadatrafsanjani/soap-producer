package com.thecitybank.pojo;

public class MsgHdr {

    private OrgnlBizQry orgnlBizQry;
    private String creDtTm;
    private String msgId;
    public OrgnlBizQry getOrgnlBizQry() {
        return orgnlBizQry;
    }
    public void setOrgnlBizQry(OrgnlBizQry orgnlBizQry) {
        this.orgnlBizQry = orgnlBizQry;
    }
    public String getCreDtTm() {
        return creDtTm;
    }
    public void setCreDtTm(String creDtTm) {
        this.creDtTm = creDtTm;
    }
    public String getMsgId() {
        return msgId;
    }
    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }
}
