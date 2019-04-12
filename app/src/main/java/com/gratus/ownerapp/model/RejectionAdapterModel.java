package com.gratus.ownerapp.model;

import java.io.Serializable;

public class RejectionAdapterModel implements Serializable {
    private String reason;
    private Boolean selected;

    public RejectionAdapterModel(String reason, Boolean selected) {
        this.reason = reason;
        this.selected = selected;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }
}
