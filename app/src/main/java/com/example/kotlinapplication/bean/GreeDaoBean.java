package com.example.kotlinapplication.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 作者:wangyu
 * 创建时间:2019/12/3 16:10
 * 描述:
 */
@Entity
public class GreeDaoBean {

    @Id
    private Long GreeDaoId;
    private String name;
    @Generated(hash = 688530193)
    public GreeDaoBean(Long GreeDaoId, String name) {
        this.GreeDaoId = GreeDaoId;
        this.name = name;
    }
    @Generated(hash = 1126439234)
    public GreeDaoBean() {
    }
    public Long getGreeDaoId() {
        return this.GreeDaoId;
    }
    public void setGreeDaoId(Long GreeDaoId) {
        this.GreeDaoId = GreeDaoId;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
