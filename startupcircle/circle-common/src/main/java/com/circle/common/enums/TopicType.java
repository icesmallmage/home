package com.circle.common.enums;

/**
 * @author liuyan
 * topic类型
 * @date 2024/4/4 10:48
 */
public enum TopicType {

    COMMENT_MESSAGE("0", "评论");

    private final String code;
    private final String name;

    TopicType(String code, String name)
    {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

}
