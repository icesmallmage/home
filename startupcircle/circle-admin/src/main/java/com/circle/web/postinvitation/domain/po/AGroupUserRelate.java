package com.circle.web.postinvitation.domain.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class AGroupUserRelate {

    /** 群聊和用户关联表id */
    private String id;

    /**
     * 群聊id
     */
    private String gId;

    /**
     * 用户id
     */
    private String userId;

    /** 创建者 */
    private String createBy;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /** 更新者 */
    private String updateBy;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /** 删除标志 */
    private String delFlag;

}
