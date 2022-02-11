Android Gradle 插件版本说明 :https://developer.android.com/studio/releases/gradle-plugin?hl=zh-cn

https://www.wenjiangs.com/doc/xgnt3apw1

查看Project中所有的Task：$ gradle tasks
查看Project中所有的properties：$ gradle properties



Gradle Wrapper 成为Gradle 包装器，是对Gradle的一层包装



#每个module 都存在一个build.gradle文件，然而这个文件代表是当前module的构建脚本，它定义了当前模块的构建规则，根目录也存在一个
build.gradle 的文件它代表的是整个工程的构建，也定义了这个工程所有模块的构建规则


#相信很多朋友对创建Android工程以后，编辑器生成的默认几个gradle配置文件都一知半解，今天我们就详细介绍下这几个gradle解释：
>gradle.properties：这个文件中定义了一系列“属性”。实际上，这个文件中定义了一系列供build.gradle使用的常量，比如keystore的存储路径、keyalias等等
>gradlew与gradlew.bat: gradlew为Linux下的shell脚本，gradlew.bat是Windows下的批处理文件。gradlew是gradle wrapper的缩写，也就是说它对gradle的命令进行了包装，比如我们进入到指定Module目录并执行“gradlew.bat assemble”即可完成对当前Module的构建（Windows系统下）
>local.properties: 从名字就可以看出来，这个文件中定义了一些本地属性，比如SDK的路径。
>settings.gradle: 假如我们的项目包含了不只一个Module时，我们想要一次性构建所有Module以完成整个项目的构建，这时我们需要用到这个文件。比如我们的项目包含了ModuleA和ModuleB这两个模块，则这个文件中会包含这样的语句：include ':ModuleA', ':ModuleB'