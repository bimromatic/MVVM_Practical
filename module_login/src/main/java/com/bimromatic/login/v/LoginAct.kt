package com.bimromatic.login.v

import android.util.Log
import com.alibaba.android.arouter.facade.annotation.Route
import com.bimromatic.base.structure.mvvm.v.BaseVmActivity
import com.bimromatic.common.constant.RouteUrl
import com.bimromatic.login.databinding.ActLoginBinding
import com.bimromatic.login.vm.LoginVm
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

/**
 * author : bimromatic
 * e-mail : xxx@xx
 * time   : 2021/12/7
 * desc   :
 * version: 1.0
 */

@AndroidEntryPoint
@Route(path = RouteUrl.Login.loginAct)
open class LoginAct : BaseVmActivity<ActLoginBinding,LoginVm>() {

 private  val TAG = "LoginAct"

 override fun ActLoginBinding.initView() {
  val bookList = ServiceLoader.load(Book::class.java, javaClass.classLoader).toList()
  bookList.forEach {
   Log.d(TAG, it.name())
  }
 }

 override fun initLiveDataObserve() {
 }

 override fun initRequestData() {
 }




// override fun onCreate(savedInstanceState: Bundle?) {
//  super.onCreate(savedInstanceState)
//  setContentView(R.layout.act_login)
//  Log.e("lifecycle", "$TAG:onCreate");
//
//  //创建方式
//  val viewmodel:LoginModel = ViewModelProvider(this).get(LoginModel::class.java)
//  addFragment(LoginFragment(),R.id.fLContainer)
// }


// override fun onStart() {
//  super.onStart()
//  Log.e("lifecycle", "$TAG:onStart");
// }
//
// override fun onResume() {
//  super.onResume()
//  Log.e("lifecycle", "$TAG:onResume");
// }
//
// override fun onPause() {
//  super.onPause()
//  Log.e("lifecycle", "$TAG:onPause");
// }
//
// override fun onStop() {
//  super.onStop()
//  Log.e("lifecycle", "$TAG:onStop");
// }
//
// override fun onDestroy() {
//  super.onDestroy()
//  Log.e("lifecycle", "$TAG:onDestroy");
// }


// @Inject //表示注入Truck 字段(todo 注入的字段不能被private 关键字修饰，否则会编译报错)
// lateinit var truck: Truck
//
// override fun ActLoginBinding.initView() {
//  truck.deliver()
//val viewmodel:LoginModel = ViewModelProvider(this).get(LoginModel::class.java)
// }
//
// override fun initLiveDataObserve() {
//
// }
//
// override fun initRequestData() {
//
// }


}