package com.circle.web.postinvitation.domain.to;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class AOperateCountDto {

    @ApiModelProperty(value = "帖子id")
    @NotEmpty(message = "帖子id不能为空")
    private String tId;

    @ApiModelProperty(value = "用户id")
    @NotEmpty(message = "用户id不能为空")
    private String userId;

    @ApiModelProperty(value = "0=收藏; 1=点赞")
    @NotEmpty(message = "操作类型不能为空")
    private String operateType;

    @ApiModelProperty(value = "0=否; 1=是")
    @NotEmpty(message = "是否点击不能为空")
    private String isOperate;

}
