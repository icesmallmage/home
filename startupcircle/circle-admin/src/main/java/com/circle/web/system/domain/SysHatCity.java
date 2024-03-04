package com.circle.web.system.domain;

import com.circle.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 【请填写功能名称】对象 sys_hat_city
 * 
 * @author ruoyi
 * @date 2024-02-22
 */
public class SysHatCity extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private String cid;

    /** $column.columnComment */
    private String cityID;

    /** $column.columnComment */
    private String city;

    /** $column.columnComment */
    private String father;

    public void setCid(String cid) 
    {
        this.cid = cid;
    }

    public String getCid() 
    {
        return cid;
    }
    public void setCityID(String cityID) 
    {
        this.cityID = cityID;
    }

    public String getCityID() 
    {
        return cityID;
    }
    public void setCity(String city) 
    {
        this.city = city;
    }

    public String getCity() 
    {
        return city;
    }
    public void setFather(String father) 
    {
        this.father = father;
    }

    public String getFather() 
    {
        return father;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("cid", getCid())
            .append("cityID", getCityID())
            .append("city", getCity())
            .append("father", getFather())
            .toString();
    }
}
