package com.example.polls.security;

import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.lang.annotation.*;

/**
 *
 * Spring security提供了一个名为@AuthenticationPrincipal的注释来访问控制器中当前经过身份验证的用户。
 * CurrentUser注释是@AuthenticationPrincipal注释的包装器。
 * 我们创建了一个元注释，这样我们就不会在项目中到处与Spring安全相关的注释纠缠不去。
 * 这减少了对Spring安全性的依赖。
 * 因此，如果我们决定从我们的项目中删除Spring Security，我们可以简单地通过更改CurrentUser注释—来完成
 */
@Target({ElementType.PARAMETER, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@AuthenticationPrincipal
public @interface CurrentUser {

}
