/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2017 All Rights Reserved.
 */
package cn.io.anno;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 * @author HuHui
 * @version $Id: MyAnnotation.java, v 0.1 2017年3月16日 上午12:52:16 HuHui Exp $
 */
@Inherited
@Documented
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    int value() default 123;

    String name();

    int age();

    String[] newNames();

}
