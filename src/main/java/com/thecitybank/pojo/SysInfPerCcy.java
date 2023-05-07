package com.thecitybank.pojo;

import java.util.ArrayList;
import java.util.List;

public class SysInfPerCcy {

    private List<Evt> evt = new ArrayList<Evt>();
    public List<Evt> getEvt() {
        return evt;
    }
    public void setEvt(List<Evt> evt) {
        this.evt = evt;
    }
}
