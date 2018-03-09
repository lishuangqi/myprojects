package com.lishuangqi.gpdb.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by michael on 2017/8/8.
 */
public class CarFlow {
//    private String id;
    private Integer clxxbh;//序号
    private String kkbh;//卡口编号
//    private String kkmc;//卡口名称
//    法1: 注解在实体字段上
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date jgsk;//经过时间
//    private Integer cdbh;//车道编号
    private String hphm;//牌号码
//    private String hpys;// 号牌颜色[0	白色 1	黄色 2	蓝色 3	黑色 4	其它颜色]
//    private Integer xsfxdm;//行驶方向代码
//    private String xsfx;//行驶方向
//    private String cllx;//车辆类型[ga24.4]
//    private String csys;//车身颜色[ga24.8]
//    private String hpzl;//号牌种类[ga24.7]
//    private Integer clsd;//车辆速度

//    public String getId() {
//        return this.id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }

    public Integer getClxxbh() {
        return this.clxxbh;
    }

    public void setClxxbh(Integer clxxbh) {
        this.clxxbh = clxxbh;
    }

    public String getKkbh() {
        return this.kkbh;
    }

    public void setKkbh(String kkbh) {
        this.kkbh = kkbh;
    }
//
//    public String getKkmc() {
//        return this.kkmc;
//    }
//
//    public void setKkmc(String kkmc) {
//        this.kkmc = kkmc;
//    }

    public Date getJgsk() {
        return this.jgsk;
    }

    public void setJgsk(Date jgsk) {
        this.jgsk = jgsk;
    }

//    public Integer getCdbh() {
//        return this.cdbh;
//    }
//
//    public void setCdbh(Integer cdbh) {
//        this.cdbh = cdbh;
//    }

    public String getHphm() {
        return this.hphm;
    }

    public void setHphm(String hphm) {
        this.hphm = hphm;
    }

//    public String getHpys() {
//        return this.hpys;
//    }
//
//    public void setHpys(String hpys) {
//        this.hpys = hpys;
//    }
//
//    public Integer getXsfxdm() {
//        return this.xsfxdm;
//    }
//
//    public void setXsfxdm(Integer xsfxdm) {
//        this.xsfxdm = xsfxdm;
//    }
//
//    public String getXsfx() {
//        return this.xsfx;
//    }
//
//    public void setXsfx(String xsfx) {
//        this.xsfx = xsfx;
//    }
//
//    public String getCllx() {
//        return this.cllx;
//    }
//
//    public void setCllx(String cllx) {
//        this.cllx = cllx;
//    }
//
//    public String getCsys() {
//        return this.csys;
//    }
//
//    public void setCsys(String csys) {
//        this.csys = csys;
//    }
//
//    public String getHpzl() {
//        return this.hpzl;
//    }
//
//    public void setHpzl(String hpzl) {
//        this.hpzl = hpzl;
//    }
//
//    public Integer getClsd() {
//        return this.clsd;
//    }
//
//    public void setClsd(Integer clsd) {
//        this.clsd = clsd;
//    }

}
