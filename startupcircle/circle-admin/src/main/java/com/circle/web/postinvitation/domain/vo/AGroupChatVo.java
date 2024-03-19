package com.circle.web.postinvitation.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class AGroupChatVo {

    /** 群聊id */
    @ApiModelProperty(value = "群聊id")
    private String id;

    /** 群聊名 */
    @ApiModelProperty(value = "群聊名")
    private String name;

    /** 关联帖子id */
    @ApiModelProperty(value = "关联帖子id")
    private String tId;

    /** 关联帖子名 */
    @ApiModelProperty(value = "关联帖子名")
    private String tName;

    /** 群主id */
    @ApiModelProperty(value = "群主id")
    private String groOwnId;

    /** 群主名 */
    @ApiModelProperty(value = "群主名")
    private String groOwnName;

    /** 群公告 */
    @ApiModelProperty(value = "群公告")
    private String groNotice;

    /** 群人数 */
    @ApiModelProperty(value = "群人数")
    private Long peoNum;

    /** 删除标志 */
    @ApiModelProperty(value = "删除标志")
    private String delFlag;

    @ApiModelProperty(value = "创建者")
    private String createBy;

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /** 更新者 */
    @ApiModelProperty(value = "更新者")
    private String updateBy;

    /** 更新时间 */
    @ApiModelProperty(value = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

}
