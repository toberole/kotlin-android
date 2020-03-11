package com.zw.kotlin_android.jetpack

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserInfoViewModel : ViewModel() {
    // LiveData是抽象类，MutableLiveData是它的一个实现类。
    // 其中定义了postValue和setValue用来通知观察者更新数据。
    // postValue为异步操作
    // setValue为同步操作
    var userData: MutableLiveData<UserInfo> = MutableLiveData()

    fun getUserInfo() {
        var userInfo = UserInfo("hello", 11)
        userData.postValue(userInfo)
    }
}