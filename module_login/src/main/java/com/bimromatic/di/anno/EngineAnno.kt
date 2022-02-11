package com.bimromatic.di.anno

import javax.inject.Qualifier

/**
 * author : bimromatic
 * e-mail : xxx@xx
 * time   : 2022/1/11
 * desc   : 给相同类型注入不同的实例
 * version: 1.0
 * Link    :
 */

@Qualifier
//@Qualifier进行声明
@Retention(AnnotationRetention.BINARY)
//@Retention，是用于声明注解的作用范围，选择AnnotationRetention.BINARY表示该注解在编译之后会得到保留，但是无法通过反射去访问这个注解。这应该是最合理的一个注解作用范围
annotation class BindGasEngine()


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BindElectricEngine

