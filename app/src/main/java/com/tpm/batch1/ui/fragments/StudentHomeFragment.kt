package com.tpm.batch1.ui.fragments


import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

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

        tvTrainer.setOnClickListener {
            showAlert("Trainers","Information technology trainers may teach IT professional skill ( hard skill) and soft-skill for future career")
        }
        tvAssignment.setOnClickListener {
            showAlert("Assignments","Write your assignment using your plan to guide you.As you write, you may well get new ideas or think about ideas in slightly different ways")
        }
        tvCourse.setOnClickListener {
            showAlert("Courses","Our Information Technology (IT) courses will equip you with the technical skills and knowledge you need to succeed in this exciting profession")
        }
        tvTeamMember.setOnClickListener {
            showAlert("TeamMember","A person belonging to a specific group of people involved in attempting to achieve a common goal")
        }

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
    private fun showAlert(title: String, bodyText: String)
    {
        val dialogBuilder = AlertDialog.Builder(context!!)
        dialogBuilder.setMessage(bodyText)
            .setCancelable(false)
            .setNegativeButton("Close", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
        val alert = dialogBuilder.create()
        alert.setTitle(title)
        alert.show()
    }
}
