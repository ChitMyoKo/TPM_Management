package com.tpm.batch1.ui.fragments


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.squareup.picasso.Picasso

import com.tpm.batch1.ace.R
import com.tpm.batch1.di.Injection
import com.tpm.batch1.util.Utils
import com.tpm.batch1.viewmodels.ProfileViewModel
import com.tpm.batch1.viewmodels.factory.ProfileViewModelFactory
import kotlinx.android.synthetic.main.fragment_profile.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class ProfileFragment : Fragment() {

    private val profileViewModel: ProfileViewModel by lazy {
        ViewModelProviders.of(this, ProfileViewModelFactory(Injection.provideProfileRepository(context!!)))
            .get(ProfileViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (Utils.isOnline(context!!)) {
            lyProfile.visibility = View.VISIBLE
            profileViewModel.profileGetSuccessState.observe(this, Observer {
                tvProfileName.setText(it.firstName + " " + it.lastName)
                tvTrackName.text = it.trackNamest!!.trackName!!
                tvDob.setText(it.dateofbirth)
                tvPhone.setText(it.phone)
                tvEmail.setText(it.email)
                tvNrc.setText(it.nrc)
                tvGender.setText(it.gender)
                tvAddress.setText(it.address)
                tvFbAccLink.setText(it.fbLink)
                tvQualification.setText(it.qualification)
                if (it.phone.equals("09969979091"))
                    ivProfilePicture.setImageResource(R.drawable.cmk)
                else
                    Picasso.get().load(it.img_link).into(ivProfilePicture)
            })
            profileViewModel.profileGetErrorState.observe(this, Observer {
                Log.d("errMsg", it)
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            })
            profileViewModel.loadProfile("1")
        } else {
            lyProfile.visibility = View.INVISIBLE
            Toast.makeText(activity, "Check your internet connection.", Toast.LENGTH_SHORT).show()
        }
    }
}
