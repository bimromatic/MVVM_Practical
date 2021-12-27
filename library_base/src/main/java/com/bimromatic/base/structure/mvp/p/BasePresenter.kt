package com.bimromatic.base.structure.mvp.p

import com.bimromatic.base.structure.mvp.contract.BaseContract
import io.reactivex.rxjava3.disposables.Disposable
import java.lang.ref.WeakReference

/**
 * author : bimromatic
 * e-mail : xxx@xx
 * time   : 2021/12/7
 * desc   :
 * version: 1.0
 */
class BasePresenter<V: BaseContract.BaseView> : BaseContract.BasePresenter {
    protected var mView: V? = null
    private var weakView: WeakReference<BaseContract.BaseView>? = null
    protected var listReqs: MutableList<Disposable> =
        ArrayList()

    override fun attachView(view: BaseContract.BaseView) {
        weakView = WeakReference(view)
        mView = weakView!!.get() as V?
    }

    override fun detachView() {
        if (mView != null) {
            mView = null
            weakView!!.clear()
            weakView = null
        }
    }

    override fun cancelAll() {
        for (disposable in listReqs) {
            disposable.dispose()
        }
    }

    protected fun addReqs(disposable: Disposable) {
        listReqs.add(disposable)
    }
}