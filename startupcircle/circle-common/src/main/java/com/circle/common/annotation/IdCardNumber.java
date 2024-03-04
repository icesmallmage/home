package com.circle.common.annotation;

import com.circle.common.idcardvaild.IdCardValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER}) // 指定注解作用于字段和参数上
@Retention(RetentionPolicy.RUNTIME)                 // 运行时保留注解信息
@Documented
@Constraint(validatedBy = IdCardValidator.class)    // 指定校验器类
public @interface IdCardNumber {

    String message() default "Invalid id card number"; // 默认错误提示消息

    Class<?>[] groups() default {}; // 分组

    Class<? extends Payload>[] payload() default {}; // 载荷

}
