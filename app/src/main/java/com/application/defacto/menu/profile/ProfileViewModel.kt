package com.application.defacto.menu.profile

import androidx.lifecycle.ViewModel
import com.application.defacto.data.local.entity.ProfileEntity
import com.application.defacto.utils.DataDummy

class ProfileViewModel: ViewModel() {
    fun getUserProfile(): ProfileEntity = DataDummy.getDummyUserProfile()
}