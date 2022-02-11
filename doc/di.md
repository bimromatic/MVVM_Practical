1:重用代码
2:易于重构
3:易于测试


// @HiltAndroidApp//会触发 Hilt 的代码生成操作，生成的代码包括应用的一个基类，该基类充当应用级依赖项容器

// 在 Application 类中设置了 Hilt 且有了应用级组件后，Hilt 可以为带有 @AndroidEntryPoint 注释的其他 Android 类提供依赖项 Hilt 目前支持以下 Android 类：

    Application（通过使用 @HiltAndroidApp）
    Activity
    Fragment
    View
    Service
    BroadcastReceiver

>注意：
在 Hilt 对 Android 类的支持方面还要注意以下几点：
Hilt 仅支持扩展 ComponentActivity 的 Activity，如 AppCompatActivity
Hilt 仅支持扩展 androidx.Fragment 的 Fragment
Hilt 不支持保留的 Fragment
> 
> 
> Hilt模块化报错ClassCastException
> 在使用多模块的时候，把Application放在公共模块里面，运行的时候报错
> 把Application放到app模块下就可以了
> 
> https://www.jianshu.com/p/35f5f5a4ec67
> 
> 
> 
> 组件的作用范围 && 组件作用域


