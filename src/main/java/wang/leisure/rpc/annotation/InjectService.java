package wang.leisure.rpc.annotation;

import java.lang.annotation.*;

/**
 * 该注解用于注入远程服务
 *
 * @author 东方雨倾
 * @since 1.0.0
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface InjectService {

}
