# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.md.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile


#####################################   文件内容通用  ###################################
#代码混淆压缩比，在0~7之间，默认为5，一般不做修改
-optimizationpasses 5

#使代码不被压缩优化,使得注解代码不被优化掉（优化掉了，点击事件就不能用了,如xutils的点击事件的代码就被优化掉了）
-dontshrink

#混合时不使用大小写混合，混合后的类名为小写
-dontusemixedcaseclassnames

#指定不去忽略非公共库的类
-dontskipnonpubliclibraryclasses

# 指定不去忽略非公共库的类成员
-dontskipnonpubliclibraryclassmembers

# #不优化输入的类文件/不要优化;会导致log依旧能输出   -dontoptimize

 #不做预校验，preverify是proguard的四个步骤之一，
 #Android不需要preverify，去掉这一步能够加快混淆速度。
-dontpreverify

#避免混淆泛型 如果混淆报错建议关掉
-keepattributes Signature

# 抛出异常时保留代码行号
-keepattributes SourceFile,LineNumberTable

##记录生成的日志数据,gradle build时在本项目根目录输出-start##
 #混淆时是否记录日志
-verbose
#忽略警告
#-ignorewarning
#apk 包内所有 class 的内部结构
#-dump proguard/class_files.txt
#未混淆的类和成员
-printseeds proguard/seeds.txt
#列出从 apk 中删除的代码
-printusage proguard/unused.txt
#混淆前后的映射
-printmapping proguard/mapping.txt
########记录生成的日志数据，gradle build时 在本项目根目录输出-end######
 # 指定混淆是采用的算法，后面的参数是一个过滤器
 # 这个过滤器是谷歌推荐的算法，一般不做更改
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*
# 保留Annotation不混淆
-keepattributes *Annotation*,InnerClasses
#############################################
#
# Android开发中一些需要保留的公共部分
#
#############################################
# 保留我们使用的四大组件，自定义的Application等等这些类不被混淆
# 因为这些子类都有可能被外部调用
-keep public class * extends android.app.Fragment
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
#-keep class com.redoor.rcs.RCSApplication{*;}
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class * extends android.view.View
#-keep public class com.android.vending.licensing.ILicensingService
# 保留support下的所有类及其内部类: 包含了 multidex
-keep class android.support.** {*;}

#如果有引用v4包可以添加下面这行
-keep public class * extends android.support.v4.**
-keep public class * extends android.support.v7.**
-keep public class * extends android.support.annotation.**
#如果引用了v4或者v7包
-dontwarn android.support.**
#这个主要是在layout 中写的onclick方法android:onclick="onClick"，不进行混淆
-keepclassmembers class * extends android.app.Activity {
   public void *(android.view.View);
}


####混淆保护自己项目的部分代码以及引用的第三方jar包library-end####



#保持 native 方法不被混淆
-keepclasseswithmembernames class * {
    native <methods>;
}

#保持自定义控件类不被混淆
-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}

#保持自定义控件类不被混淆
-keepclassmembers class * extends android.app.Activity {
   public void *(android.view.View);
}

-keep public class * extends android.view.View {
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
    public void set*(...);
}

#保持 Parcelable 不被混淆
-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}

#保持 Serializable 不被混淆
-keepnames class * implements java.io.Serializable
#保持 Serializable 不被混淆并且enum 类也不被混淆
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    !static !transient <fields>;
    !private <fields>;
    !private <methods>;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}

# 对于带有回调函数的onXXEvent、**On*Listener的，不能被混淆
-keepclassmembers class * {
    void *(**On*Event);
    void *(**On*Listener);
}

# webView处理，项目中没有使用到webView忽略即可
#-keepclassmembers class fqcn.of.javascript.interface.for.Webview {
#    public *;
#}
#-keepclassmembers class * extends android.webkit.WebViewClient {
#    public void *(android.webkit.WebView, java.lang.String, android.graphics.Bitmap);
#    public boolean *(android.webkit.WebView, java.lang.String);
#}
#-keepclassmembers class * extends android.webkit.WebViewClient {
#    public void *(android.webkit.webView, jav.lang.String);
#}

#保持枚举 enum 类不被混淆
-keepclassmembers enum * {
  public static **[] values();
  public static ** valueOf(java.lang.String);
}

-keepclassmembers class * {
    public void *ButtonClicked(android.view.View);
}

#不混淆资源类
-keepclassmembers class **.R$* {
    public static <fields>;
}

#移除Log类打印各个等级日志的代码，打正式包的时候可以做为禁log使用，
#这里可以作为禁止log打印的功能使用，
#另外的一种实现方案是通过BuildConfig.DEBUG的变量来控制
-assumenosideeffects class android.util.Log {
    public static *** v(...);
    public static *** i(...);
    public static *** d(...);
    public static *** w(...);
    public static *** e(...);
}
-assumenosideeffects class java.io.PrintStream {
     public *** println(...);
     public *** print(...);
}


-keep public class * extends android.app.Fragment


#-keep public class com.bimromatic.nest_tree.lib_base.provider{*;}
#==================gson && protobuf==========================
-dontwarn com.google.**
-keep class com.google.gson.** {*;}
-keep class com.google.protobuf.** {*;}
-keep class com.alibaba.idst.util.*{*;}

-dontwarn com.alibaba.fastjson.**
-keep class com.alibaba.fastjson.** { *; }

##不混淆某个包所有的类
#-keep class com.bimromatic.nest_tree.lib_net.interceptor.log.** { *; }
#-keep class com.bimromatic.nest_tree.lib_net.interceptor.DynamicSwitchUrlInterceptor{*;}
#
##-keep class org.json.JSONObject.**{*;}
#-keep class com.bimromatic.nest_tree.lib_net.json.** {*;}
#-keep class org.json.**
#-keepclassmembers,includedescriptorclasses class org.json.** { *; }


# 保留源文件名和具体代码行号
-keepattributes SourceFile,LineNumberTable

##自定义混淆字典配置
-obfuscationdictionary ../files/proguard-tradition.txt
-packageobfuscationdictionary ../files/proguard-tradition.txt
-classobfuscationdictionary ../files/proguard-tradition.txt


#PictureSelector
-keep class com.luck.picture.lib.** { *; }

#ucrop
-dontwarn com.yalantis.ucrop**
-keep class com.yalantis.ucrop** { *; }
-keep interface com.yalantis.ucrop** { *; }


# AOP
-adaptclassstrings
-keepattributes InnerClasses, EnclosingMethod, Signature, *Annotation*

#-keepnames @org.aspectj.lang.annotation.Aspect class * {
#    public <methods>;
#}

## 不混淆被 DebugLog 注解的方法信息
#-keepclassmembernames class ** {
#    @com.hjq.demo.aop.DebugLog <methods>;
#}


# OkHttp3
-keepattributes Signature
-keepattributes *Annotation*
-keep class okhttp3.** { *; }
-keep interface okhttp3.** { *; }
-dontwarn okhttp3.**
-dontwarn okio.**
-dontwarn org.conscrypt.**


##
##基线包使用，生成mapping.txt
#-printmapping mapping.txt
##生成的mapping.txt在app/build/outputs/mapping/release路径下，移动到/app路径下
##修复后的项目使用，保证混淆结果一致
##-applymapping mapping.txt
##hotfix
#-keep class com.taobao.sophix.**{*;}
#-keep class com.ta.utdid2.device.**{*;}
#-dontwarn com.alibaba.sdk.android.utils.**
##防止inline
#-dontoptimize
#
##
#-keepclassmembers class com.bimromatic.nest_tree.lib_base.app.BaseApplication {
#    public <init>();
#}
#-keep class com.bimromatic.nest_tree.lib_base.app.HotfixApplication$RealApplicationStub

#bugly
-dontwarn com.tencent.bugly.**
-keep public class com.tencent.bugly.**{*;}

-keep class androidx.core.app.CoreComponentFactory { *; }


##
##基线包使用，生成mapping.txt
##-printmapping mapping.txt
##生成的mapping.txt在app/build/outputs/mapping/release路径下，移动到/app路径下
##修复后的项目使用，保证混淆结果一致
#-applymapping mapping.txt
##hotfix
#-keep class com.taobao.sophix.**{*;}
#-keep class com.ta.utdid2.device.**{*;}
##防止inline
#-dontoptimize
#
##
#-keepclassmembers class com.bimromatic.nest_tree.lib_base.app.BaseApplication {
#    public <init>();
#}
#-keep class com.bimromatic.nest_tree.lib_base.app.HotfixApplication$RealApplicationStub
#
##bugly
#-dontwarn com.tencent.bugly.**
#-keep public class com.tencent.bugly.**{*;}
#-keep class android.support.**{*;}

# ViewBinding
-keepclassmembers class * implements androidx.viewbinding.ViewBinding {
  public static * inflate(android.view.LayoutInflater);
}

-keep public interface androidx.viewbinding.ViewBinding
-keep class * implements androidx.viewbinding.ViewBinding{
    *;
}