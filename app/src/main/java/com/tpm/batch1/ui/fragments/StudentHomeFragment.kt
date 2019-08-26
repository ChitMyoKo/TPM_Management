package com.tpm.batch1.ui.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.tpm.batch1.ace.R
import com.tpm.batch1.ui.activities.*
import kotlinx.android.synthetic.main.fragment_home.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class StudentHomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        trainer.setOnClickListener {
           activity?.let {
               it.startActivity(TrainerActivity.newIntent(it))
           }

        }
        teamMember.setOnClickListener {
            activity?.let {
                it.startActivity(TeamMemberActivity.newIntent(it))
            }

        }
        course.setOnClickListener {
            activity?.let {
                it.startActivity(CourseDetailsActivity.newIntent(it))
            }
        }
        assignment.setOnClickListener {
            activity?.let {
                it.startActivity(AssignmentActivity.newIntent(it))
            }
        }
    }
}
