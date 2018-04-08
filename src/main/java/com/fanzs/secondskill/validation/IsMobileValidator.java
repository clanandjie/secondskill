package com.fanzs.secondskill.validation;

import com.fanzs.secondskill.util.ValidationUtil;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Validation;

/**
 * Created by fzs on 2018/4/8.
 */
public class IsMobileValidator implements ConstraintValidator<IsMobile,String>{

    private boolean required=false;
    @Override
    public void initialize(IsMobile constraintAnnotation) {
        required=constraintAnnotation.required();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(!required){
            if(StringUtils.isEmpty(value)){
                return true;
            }else{
                return ValidationUtil.isMobile(value);
            }
        }else{
            return ValidationUtil.isMobile(value);
        }
    }
}
