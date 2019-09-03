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
import androidx.recyclerview.widget.LinearLayoutManager
import com.tpm.batch1.di.Injection
import com.tpm.batch1.ui.adapter.LearningMaterialsAdapter
import com.tpm.batch1.viewmodels.LearningMaterialsViewModel
import com.tpm.batch1.viewmodels.factory.LearningMaterialsViewModelFactory
import kotlinx.android.synthetic.main.fragment_learning_materials.*
import android.content.Intent
import android.net.Uri
import com.tpm.batch1.network.network_response.learning_material.LearningMaterial
import com.tpm.batch1.util.Utils
import okhttp3.internal.Util


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class LearningMaterialsFragment : Fragment() {

    private val materialsAdapter : LearningMaterialsAdapter by lazy { LearningMaterialsAdapter(this::onClickPdfOpen) }
    private val materialsViewModel : LearningMaterialsViewModel by lazy {
        ViewModelProviders.of(this,LearningMaterialsViewModelFactory(Injection.provideLearningMaterialsRepository(context!!)))
            .get(LearningMaterialsViewModel::class.java)
    }
    private var trackId : String = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(com.tpm.batch1.ace.R.layout.fragment_learning_materials, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerMaterials.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = materialsAdapter
        }
        trackId = "1"
        if(Utils.isOnline(context!!))
        {
            materialsViewModel.materialsListGetSuccessState.observe(this, Observer {
                Log.d("act",it.size.toString())
                materialsAdapter.setMaterialsList(it)
            })
            materialsViewModel.materialsListGetErrorState.observe(this, Observer {
                Toast.makeText(context,it,Toast.LENGTH_SHORT).show()
            })
            materialsViewModel.loadTrainerList(trackId)

        }
        else
        {
            Toast.makeText(activity,"Check your internet connection.",Toast.LENGTH_SHORT).show()
        }


    }

    private fun onClickPdfOpen(material : LearningMaterial)
    {
        /*val targetFile = File(material.fileLink)
        val targetUri = Uri.fromFile(targetFile)

        val intent: Intent
        intent = Intent(Intent.ACTION_VIEW)
        intent.setDataAndType(targetUri, "application/pdf")

        startActivity(intent)*/
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(material.fileLink))
        startActivity(browserIntent)
    }
}
