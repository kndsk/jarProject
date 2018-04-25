

package com.whty.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author xus
 * @description
 * @date 2016年8月23日
 */
public abstract class BaseModel implements Serializable {

    private static final long serialVersionUID = -1L;

    private String id;
    private Date createTime;
    private Date updateTime;
    private String createUserId;
    private String updateUserId;

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, false);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj, false);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateTime() {
        if (null == createTime) return null;
        return (Date) createTime.clone();
    }

    public void setCreateTime(Date createTime) {
        if (null == createTime) this.createTime =  null;
        else this.createTime = (Date) createTime.clone();
    }

    public Date getUpdateTime() {
        if (null == updateTime) return null;
        return (Date) updateTime.clone();
    }

    public void setUpdateTime(Date updateTime) {
        if (null == updateTime) this.updateTime = null;
        else this.updateTime = (Date) updateTime.clone();
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }
}
