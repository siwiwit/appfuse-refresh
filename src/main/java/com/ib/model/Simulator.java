package com.ib.model;

import javax.persistence.*;

/**
 * Created by IMAM on 12/17/14.
 */
@Entity
@Table(name = "simulator")
public class Simulator extends BaseObject {
    private Long id;
    private String type;

    private String responseCode;
    private String description;

    private String data1;
    private String desc1;
    private String data2;
    private String desc2;
    private String data3;
    private String desc3;
    private String data4;
    private String desc4;
    private String data5;
    private String desc5;
    private String data6;
    private String desc6;
    private String data7;
    private String desc7;

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getData1() {
        return data1;
    }

    public void setData1(String data1) {
        this.data1 = data1;
    }

    public String getData2() {
        return data2;
    }

    public void setData2(String data2) {
        this.data2 = data2;
    }

    public String getData3() {
        return data3;
    }

    public void setData3(String data3) {
        this.data3 = data3;
    }

    public String getData4() {
        return data4;
    }

    public void setData4(String data4) {
        this.data4 = data4;
    }

    public String getData5() {
        return data5;
    }

    public void setData5(String data5) {
        this.data5 = data5;
    }

    public String getData6() {
        return data6;
    }

    public void setData6(String data6) {
        this.data6 = data6;
    }

    public String getData7() {
        return data7;
    }

    public void setData7(String data7) {
        this.data7 = data7;
    }

    @Column(name="response_code", length=10)
    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getDesc1() {
        return desc1;
    }

    public void setDesc1(String desc1) {
        this.desc1 = desc1;
    }

    public String getDesc2() {
        return desc2;
    }

    public void setDesc2(String desc2) {
        this.desc2 = desc2;
    }

    public String getDesc3() {
        return desc3;
    }

    public void setDesc3(String desc3) {
        this.desc3 = desc3;
    }

    public String getDesc4() {
        return desc4;
    }

    public void setDesc4(String desc4) {
        this.desc4 = desc4;
    }

    public String getDesc5() {
        return desc5;
    }

    public void setDesc5(String desc5) {
        this.desc5 = desc5;
    }

    public String getDesc6() {
        return desc6;
    }

    public void setDesc6(String desc6) {
        this.desc6 = desc6;
    }

    public String getDesc7() {
        return desc7;
    }

    public void setDesc7(String desc7) {
        this.desc7 = desc7;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Simulator simulator = (Simulator) o;

        if (type != null ? !type.equals(simulator.type) : simulator.type != null) return false;
        if (data1 != null ? !data1.equals(simulator.data1) : simulator.data1 != null) return false;
        if (data2 != null ? !data2.equals(simulator.data2) : simulator.data2 != null) return false;
        if (data3 != null ? !data3.equals(simulator.data3) : simulator.data3 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (data1 != null ? data1.hashCode() : 0);
        result = 31 * result + (data2 != null ? data2.hashCode() : 0);
        result = 31 * result + (data3 != null ? data3.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Simulator{" +
                "id=" + id +
                ", type=" + type +
                ", data1=" + data1 +
                ", data2=" + data2 +
                ", data3=" + data3 +
                "}";
    }
}
