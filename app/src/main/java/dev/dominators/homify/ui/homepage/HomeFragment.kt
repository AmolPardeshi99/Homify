package dev.dominators.homify.ui.homepage

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dev.dominators.homify.R
import dev.dominators.homify.databinding.FragmentHomeBinding
import dev.dominators.homify.datamodel.Jobs
import dev.dominators.homify.ui.homepage.diffutil.NewJobAdapter
import dev.dominators.homify.datamodel.NewJobData

class HomeFragment : Fragment() {

    private lateinit var auth: FirebaseAuth
    private val db = Firebase.firestore
    private val jobRef = db.collection("jobs")

    private var newJobList = ArrayList<Jobs>()
    private val TAG = "HomeFragment"
    lateinit var fragmentHomeBinding: FragmentHomeBinding
    lateinit var newJobAdapter: NewJobAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentHomeBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)
        val view = fragmentHomeBinding.root
        val recyclerView = fragmentHomeBinding.newJobRecycler
        recyclerView.layoutManager = LinearLayoutManager(context)
        buildData()
        newJobAdapter = NewJobAdapter(newJobList)
        recyclerView.adapter = newJobAdapter
        return view
    }





    private fun buildData() {
        val docRef = db.collection("cities").document("SF")
        docRef.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    Log.d(TAG, "DocumentSnapshot data: ${document.data}")
                } else {
                    Log.d(TAG, "No such document")
                }
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "get failed with ", exception)
            }


        for (i in 1..3){
            val newJobData = NewJobData("10:00 PM","Ranjan${1}",
                "Plot No.61, JP Colony, Jalgaon, Maharashtra, India","9:00 PM",
                "12 Dec 2021",1234567800,"I want best service",
                1200.0000f,0.0000f,0.0000f)
           // newJobList.add(newJobData)

        }
    }

}