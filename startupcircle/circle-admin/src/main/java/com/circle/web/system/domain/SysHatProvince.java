package com.circle.web.system.domain;

import com.circle.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 【请填写功能名称】对象 sys_hat_province
 * 
 * @author ruoyi
 * @date 2024-02-22
 */
public class SysHatProvince extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private String sid;

    /** $column.columnComment */
    private String provinceID;

    /** $column.columnComment */
    private String province;

    public void setSid(String sid) 
    {
        this.sid = sid;
    }

    public String getSid() 
    {
        return sid;
    }
    public void setProvinceID(String provinceID) 
    {
        this.provinceID = provinceID;
    }

    public String getProvinceID() 
    {
        return provinceID;
    }
    public void setProvince(String province) 
    {
        this.province = province;
    }

    public String getProvince() 
    {
        return province;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("sid", getSid())
            .append("provinceID", getProvinceID())
            .append("province", getProvince())
            .toString();
    }
}
