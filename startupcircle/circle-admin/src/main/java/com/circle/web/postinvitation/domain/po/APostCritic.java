package com.circle.web.postinvitation.domain.po;

import com.circle.common.annotation.Excel;
import com.circle.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 【请填写功能名称】对象 a_post_critic
 * 
 * @author ruoyi
 * @date 2024-01-30
 */
public class APostCritic extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    private Long id;

    /** 发评论人id */
    @Excel(name = "发评论人id")
    @ApiModelProperty(value = "发评论人id")
    private String postUserId;

    /** 发评论人昵称 */
    @Excel(name = "发评论人昵称")
    @ApiModelProperty(value = "发评论人昵称")
    private String postNickName;

    /** 评论内容 */
    @Excel(name = "评论内容")
    @ApiModelProperty(value = "评论内容")
    private String content;

    /** 关联帖子id */
    @Excel(name = "关联帖子id")
    @ApiModelProperty(value = "关联帖子id")
    private String postInvitationId;

    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @ApiModelProperty(value = "发评论人父id")
    private Long parentId;

    /** 发评论人父昵称 */
    @Excel(name = "发评论人父昵称")
    @ApiModelProperty(value = "发评论人父昵称")
    private String parentNickName;

    @ApiModelProperty(value = "发评论人省份")
    private String province;

    @ApiModelProperty(value = "发评论人城市")
    private String city;

    /** 删除标志 */
    @ApiModelProperty(value = "删除标志")
    private String delFlag;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setPostUserId(String postUserId)
    {
        this.postUserId = postUserId;
    }

    public String getPostUserId()
    {
        return postUserId;
    }
    public void setPostNickName(String postNickName)
    {
        this.postNickName = postNickName;
    }

    public String getPostNickName()
    {
        return postNickName;
    }
    public void setContent(String content)
    {
        this.content = content;
    }

    public String getContent()
    {
        return content;
    }
    public void setPostInvitationId(String postInvitationId)
    {
        this.postInvitationId = postInvitationId;
    }

    public String getPostInvitationId()
    {
        return postInvitationId;
    }
    public void setParentId(Long parentId)
    {
        this.parentId = parentId;
    }

    public Long getParentId()
    {
        return parentId;
    }
    public void setParentNickName(String parentNickName)
    {
        this.parentNickName = parentNickName;
    }

    public String getParentNickName()
    {
        return parentNickName;
    }
    public void setDelFlag(String delFlag)
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag()
    {
        return delFlag;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("postUserId", getPostUserId())
            .append("postNickName", getPostNickName())
            .append("content", getContent())
            .append("postInvitationId", getPostInvitationId())
            .append("parentId", getParentId())
            .append("parentNickName", getParentNickName())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
