package com.circle.web.postinvitation.domain.po;

import com.circle.common.annotation.Excel;
import com.circle.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 【群聊】对象 a_group_chat
 * 
 * @author ruoyi
 * @date 2024-03-08
 */
public class AGroupChat extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 群聊id */
    private String id;

    /** 群聊名 */
    @Excel(name = "群聊名")
    private String name;

    /** 关联帖子id */
    @Excel(name = "关联帖子id")
    private String tId;

    /** 关联帖子名 */
    @Excel(name = "关联帖子名")
    private String tName;

    /** 群主id */
    @Excel(name = "群主id")
    private String groOwnId;

    /** 群主名 */
    @Excel(name = "群主名")
    private String groOwnName;

    /** 群公告 */
    @Excel(name = "群公告")
    private String groNotice;

    /** 群人数 */
    @Excel(name = "群人数")
    private Long peoNum;

    /** 删除标志 */
    private String delFlag;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void settId(String tId) 
    {
        this.tId = tId;
    }

    public String gettId() 
    {
        return tId;
    }
    public void settName(String tName) 
    {
        this.tName = tName;
    }

    public String gettName() 
    {
        return tName;
    }
    public void setGroOwnId(String groOwnId) 
    {
        this.groOwnId = groOwnId;
    }

    public String getGroOwnId() 
    {
        return groOwnId;
    }
    public void setGroOwnName(String groOwnName) 
    {
        this.groOwnName = groOwnName;
    }

    public String getGroOwnName() 
    {
        return groOwnName;
    }
    public void setGroNotice(String groNotice) 
    {
        this.groNotice = groNotice;
    }

    public String getGroNotice() 
    {
        return groNotice;
    }
    public void setPeoNum(Long peoNum) 
    {
        this.peoNum = peoNum;
    }

    public Long getPeoNum() 
    {
        return peoNum;
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
            .append("name", getName())
            .append("tId", gettId())
            .append("tName", gettName())
            .append("groOwnId", getGroOwnId())
            .append("groOwnName", getGroOwnName())
            .append("groNotice", getGroNotice())
            .append("peoNum", getPeoNum())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
