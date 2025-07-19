package com.jida.tijian.domain;

public class Cidetailedreport {
    private Integer cidrId;

    private String name;

    private String unit;

    private Double minrange;

    private Double maxrange;

    private String normalValue;

    private String normalValueString;

    private Integer type;

    private String value;

    private Integer isError;

    private Integer ciId;

    private Integer orderId;

    public Integer getCidrId() {
        return cidrId;
    }

    public void setCidrId(Integer cidrId) {
        this.cidrId = cidrId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public Double getMinrange() {
        return minrange;
    }

    public void setMinrange(Double minrange) {
        this.minrange = minrange;
    }

    public Double getMaxrange() {
        return maxrange;
    }

    public void setMaxrange(Double maxrange) {
        this.maxrange = maxrange;
    }

    public String getNormalValue() {
        return normalValue;
    }

    public void setNormalValue(String normalValue) {
        this.normalValue = normalValue == null ? null : normalValue.trim();
    }

    public String getNormalValueString() {
        return normalValueString;
    }

    public void setNormalValueString(String normalValueString) {
        this.normalValueString = normalValueString == null ? null : normalValueString.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public Integer getIsError() {
        return isError;
    }

    public void setIsError(Integer isError) {
        this.isError = isError;
    }

    public Integer getCiId() {
        return ciId;
    }

    public void setCiId(Integer ciId) {
        this.ciId = ciId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}