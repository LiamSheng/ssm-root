package linzi.spring.restful.crud.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import linzi.spring.restful.crud.annotation.DIYGender;

public class GenderValidator implements ConstraintValidator<DIYGender, String> {

    /**
     *
     * @param s 前端提交过来的属性值.
     * @param constraintValidatorContext 校验上下文.
     * @return 校验是否成功的布尔值.
     */
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return "男".equals(s) || "女".equals(s);
    }

}
