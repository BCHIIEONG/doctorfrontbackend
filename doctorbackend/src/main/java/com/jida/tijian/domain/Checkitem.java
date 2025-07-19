package com.jida.tijian.domain;

public class Checkitem {
    private Integer ciId;

    private String ciName;

    private String ciContent;

    private String meaning;

    private String remarks;

    public Integer getCiId() {
        return ciId;
    }

    public void setCiId(Integer ciId) {
        this.ciId = ciId;
    }

    public String getCiName() {
        return ciName;
    }

    public void setCiName(String ciName) {
        this.ciName = ciName == null ? null : ciName.trim();
    }

    public String getCiContent() {
        return ciContent;
    }

    public void setCiContent(String ciContent) {
        this.ciContent = ciContent == null ? null : ciContent.trim();
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning == null ? null : meaning.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}