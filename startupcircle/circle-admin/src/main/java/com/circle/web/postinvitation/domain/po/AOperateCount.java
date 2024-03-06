package com.circle.web.postinvitation.domain.po;

import com.circle.common.annotation.Excel;
import com.circle.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 操作点赞,收藏的对象 a_operate_count
 * 
 * @author ruoyi
 * @date 2024-03-05
 */
public class AOperateCount extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    @ApiModelProperty(value = "id")
    private String id;

    /** 帖子id */
    @Excel(name = "帖子id")
    @ApiModelProperty(value = "帖子id")
    private String tId;

    /** 用户id */
    @Excel(name = "用户id")
    @ApiModelProperty(value = "用户id")
    private String userId;

    /** 0=收藏; 1=点赞 */
    @Excel(name = "0=收藏; 1=点赞")
    @ApiModelProperty(value = "0=收藏; 1=点赞")
    private String operateType;

    /** 0=否; 1=是 */
    @Excel(name = "0=否; 1=是")
    @ApiModelProperty(value = "0=否; 1=是")
    private String isOperate;

    /** 是否删除 */
    @ApiModelProperty(value = "是否删除")
    private String delFlag;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void settId(String tId) 
    {
        this.tId = tId;
    }

    public String gettId() 
    {
        return tId;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setOperateType(String operateType) 
    {
        this.operateType = operateType;
    }

    public String getOperateType() 
    {
        return operateType;
    }
    public void setIsOperate(String isOperate) 
    {
        this.isOperate = isOperate;
    }

    public String getIsOperate() 
    {
        return isOperate;
    }

    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("tId", gettId())
            .append("userId", getUserId())
            .append("operateType", getOperateType())
            .append("isOperate", getIsOperate())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
