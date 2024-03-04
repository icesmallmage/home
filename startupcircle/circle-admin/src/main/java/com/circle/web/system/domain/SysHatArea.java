package com.circle.web.system.domain;

import com.circle.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 【请填写功能名称】对象 sys_hat_area
 * 
 * @author ruoyi
 * @date 2024-02-22
 */
public class SysHatArea extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private String rid;

    /** $column.columnComment */
    private String areaID;

    /** $column.columnComment */
    private String area;

    /** $column.columnComment */
    private String father;

    public void setRid(String rid) 
    {
        this.rid = rid;
    }

    public String getRid() 
    {
        return rid;
    }
    public void setAreaID(String areaID) 
    {
        this.areaID = areaID;
    }

    public String getAreaID() 
    {
        return areaID;
    }
    public void setArea(String area) 
    {
        this.area = area;
    }

    public String getArea() 
    {
        return area;
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
            .append("rid", getRid())
            .append("areaID", getAreaID())
            .append("area", getArea())
            .append("father", getFather())
            .toString();
    }
}
