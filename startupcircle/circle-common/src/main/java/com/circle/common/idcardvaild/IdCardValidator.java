package com.circle.common.idcardvaild;

import com.circle.common.annotation.IdCardNumber;
import org.apache.commons.lang3.StringUtils;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IdCardValidator implements ConstraintValidator<IdCardNumber, String>{

    private static final int ID_CARD_NUMBER_LENGTH = 18;

    @Override
    public void initialize(IdCardNumber constraintAnnotation) {}

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || !isIdCardNumberFormatCorrect(value)) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 判断身份证号格式是否正确
     */
    private boolean isIdCardNumberFormatCorrect(String idCardNumber) {
        if (!StringUtils.isNumericSpace(idCardNumber)) {
            return false;
        }

        if (idCardNumber.length() != ID_CARD_NUMBER_LENGTH) {
            return false;
        }

        try {
            Long.parseLong(idCardNumber);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

}
