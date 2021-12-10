package com.bimromatic.library_base.structure.mvvm.v

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.bimromatic.library_base.base.BaseStatusActivity
import com.bimromatic.library_base.base.state.BaseFrameViewStatusHelperImp
import com.bimromatic.library_base.base.state.ViewStatusHelper
import com.bimromatic.library_base.structure.mvvm.impl.IFrameView
import com.bimromatic.library_base.structure.mvvm.impl.IStatusView
import com.bimromatic.library_base.structure.mvvm.vm.BaseViewModel
import com.bimromatic.library_base.untils.reflex.BindingReflex


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
        super.onDestroy()
    }



}