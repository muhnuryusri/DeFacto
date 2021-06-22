package com.application.defacto.menu.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.application.defacto.data.local.entity.ProfileEntity
import com.application.defacto.databinding.FragmentProfileBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ProfileFragment : Fragment() {
    private lateinit var profileViewModel: ProfileViewModel
    private lateinit var profileBinding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        profileBinding = FragmentProfileBinding.inflate(layoutInflater)
        return profileBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        profileViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[ProfileViewModel::class.java]
        val user = profileViewModel.getUserProfile()
        populateProfileData(user)
    }

    private fun populateProfileData(data: ProfileEntity) {
        Glide.with(this)
            .load(data.photo)
            .centerCrop()
            .apply(RequestOptions().override(330, 500))
            .into(profileBinding.imgPhoto)

        profileBinding.tvName.text = data.nama
        profileBinding.tvEmail.text = data.email
        profileBinding.rvList
    }
}