package com.bimromatic.base.structure.mvvm.v

import android.os.Bundle
import android.util.Log
import androidx.viewbinding.ViewBinding
import com.alibaba.android.arouter.launcher.ARouter
import com.bimromatic.base.base.BaseStatusActivity
import com.bimromatic.base.base.state.BaseFrameViewStatusHelperImp
import com.bimromatic.base.base.state.ViewStatusHelper
import com.bimromatic.base.structure.mvvm.impl.IFrameView
import com.bimromatic.base.structure.mvvm.impl.IStatusView
import com.bimromatic.base.structure.mvvm.vm.BaseViewModel
import com.bimromatic.base.untils.AndroidBugFixUtils
import com.bimromatic.base.untils.EventBusUtils
import com.bimromatic.base.untils.anno.EventBusRegister
import com.bimromatic.base.untils.manager.ActivityStackManager
import com.bimromatic.base.untils.reflex.BindingReflex


/**
 * author : bimromatic
 * e-mail : xxx@xx
 * time   : 2021/12/3
 * desc   :
 * version: 1.0
 */
abstract class BaseVmActivity<VB : ViewBinding,VM : BaseViewModel> :BaseStatusActivity(),IFrameView<VB>,IStatusView{

    protected val mBinding: VB by lazy(mode = LazyThreadSafetyMode.NONE) {
        BindingReflex.reflexViewBinding(javaClass, layoutInflater)
    }

    protected val mViewModel: VM by lazy(mode = LazyThreadSafetyMode.NONE) {
        BindingReflex.reflexViewModel(javaClass, this)
    }

    /**
     * 基础UI状态管理工具 保存了是否重建的状态信息
     */
    private lateinit var mStatusHelper: BaseFrameViewStatusHelperImp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)

        // ARouter 依赖注入
        ARouter.getInstance().inject(this)
        // 注册EventBus
        if (javaClass.isAnnotationPresent(EventBusRegister::class.java)) EventBusUtils.register(this)

        mBinding.initView()
        initLiveDataObserve()
        initRequestData()
    }


    override fun showLoadingView(isShow: Boolean) {
        if (isShow) {

        } else {

        }
    }

    override fun showEmptyView() {

    }

    //错误视图 并且可以重试
    override fun showErrorView(errMsg: String) {

    }

    private fun registerEvent() {
        //接收错误信息
        mViewModel.errorLiveData.observe(this) { errMsg ->
            showErrorView(errMsg)
        }
        //接收Loading信息
        mViewModel.loadingLiveData.observe(this, { isShow ->
            showLoadingView(isShow)
        })
    }


    override fun onRegisterStatusHelper(): ViewStatusHelper? {
        mStatusHelper = BaseFrameViewStatusHelperImp(super.onRegisterStatusHelper())
        return mStatusHelper
    }


    override fun onDestroy() {
        if (javaClass.isAnnotationPresent(EventBusRegister::class.java)) EventBusUtils.unRegister(this)
        // 处理华为手机mlastsrvview内存泄露问题
        AndroidBugFixUtils().fixLeak(this)
        AndroidBugFixUtils().fixSoftInputLeaks(this)
        super.onDestroy()
    }


    override fun onResume() {
        super.onResume()
        Log.d("ActivityLifecycle", "ActivityStack: ${ActivityStackManager.activityStack}")
    }


}