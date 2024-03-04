package com.circle.web.postinvitation.domain.po;

import com.circle.common.annotation.Excel;
import com.circle.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 【请填写功能名称】对象 a_post_invitation
 * 
 * @author ruoyi
 * @date 2024-01-30
 */
public class APostInvitation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private String id;

    /** 发帖人id */
    @ApiModelProperty(value = "发帖人id")
    @Excel(name = "发帖人id")
    private String postUserId;

    /** 发帖人昵称 */
    @ApiModelProperty(value = "发帖人昵称")
    @Excel(name = "发帖人昵称")
    private String postNickName;

    /** 标题 */
    @ApiModelProperty(value = "标题")
    @Excel(name = "标题")
    private String title;

    /** 内容 */
    @ApiModelProperty(value = "内容")
    @Excel(name = "内容")
    private String content;

    /** 行业 */
    @ApiModelProperty(value = "行业")
    private String industry;

    /** 职业 */
    @ApiModelProperty(value = "职业")
    private String profession;

    @ApiModelProperty(value = "发评论人省份")
    private String province;

    @ApiModelProperty(value = "发评论人城市")
    private String city;

    /** 浏览量 */
    @ApiModelProperty(value = "浏览量")
    @Excel(name = "浏览量")
    private String viewCount;

    /** 点赞量 */
    @ApiModelProperty(value = "点赞量")
    @Excel(name = "点赞量")
    private String upvoteCount;

    /** 评论量 */
    @ApiModelProperty(value = "评论量")
    @Excel(name = "评论量")
    private String criticCount;

    /** 删除标志 */
    @ApiModelProperty(value = "删除标志")
    private String delFlag;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
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
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public void setViewCount(String viewCount)
    {
        this.viewCount = viewCount;
    }

    public String getViewCount() 
    {
        return viewCount;
    }
    public void setUpvoteCount(String upvoteCount) 
    {
        this.upvoteCount = upvoteCount;
    }

    public String getUpvoteCount() 
    {
        return upvoteCount;
    }
    public void setCriticCount(String criticCount)
    {
        this.criticCount = criticCount;
    }

    public String getCriticCount()
    {
        return criticCount;
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
            .append("title", getTitle())
            .append("content", getContent())
            .append("industry", getIndustry())
            .append("profession", getProfession())
            .append("viewCount", getViewCount())
            .append("upvoteCount", getUpvoteCount())
            .append("criticCount", getCriticCount())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
