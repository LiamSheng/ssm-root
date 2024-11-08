package linzi.spring.restful.crud.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import linzi.spring.restful.crud.validator.GenderValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {GenderValidator.class}) // 校验器真正完成校验功能
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE,
        ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DIYGender {

    String message() default "{jakarta.validation.constraints.Min.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
