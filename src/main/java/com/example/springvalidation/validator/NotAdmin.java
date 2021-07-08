package com.example.springvalidation.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = NotAdminValidator.class)
public @interface NotAdmin {
    String message() default "{javax.validations.constraints.NotNull.message}";
     Class <?>[] group() default { };
    Class<? extends Payload>[] payload() default { };

}
