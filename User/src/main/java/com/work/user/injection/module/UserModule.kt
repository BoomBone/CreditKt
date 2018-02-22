package com.work.user.injection.module

import com.work.user.presenter.service.UserService
import com.work.user.presenter.service.impl.UserServiceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Named

/**
 * Created by Ting on 2018/2/22.
 * @function 用户模块module
 */
@Module
class UserModule {

    @Provides
    fun providerUserService(userServiceImpl: UserServiceImpl): UserService {
        return userServiceImpl
    }
}