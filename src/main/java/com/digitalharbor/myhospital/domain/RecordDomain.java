package com.digitalharbor.myhospital.domain;

import java.time.LocalDateTime;

public class RecordDomain {
    private String description;
    private LocalDateTime recordDate;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(LocalDateTime recordDate) {
        this.recordDate = recordDate;
    }
}
