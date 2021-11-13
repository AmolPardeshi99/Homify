package dev.dominators.homify.ui.homepage

import android.content.Intent
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
import dev.dominators.homify.ui.JobCheck.JobActivity
import dev.dominators.homify.ui.homepage.clicklisteners.JobClickListener

class HomeFragment : Fragment(),JobClickListener {

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
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newJobAdapter = NewJobAdapter(newJobList,this)
        fragmentHomeBinding.newJobRecycler.adapter = newJobAdapter
    }

    private fun buildData() {

        Log.d(TAG, "buildData: ${FirebaseAuth.getInstance().currentUser?.uid}")
        jobRef.get().addOnSuccessListener { document ->
            for (doc in document){
                val address =doc.data.get("address").toString()
                val contact = doc.data.get("contact").toString()
                val createdAt = doc.data.get("createdAt").toString()
                val date = doc.data.get("date").toString()
                val name = doc.data.get("name").toString()
                val time = doc.data.get("time").toString()
                val type = doc.data.get("type").toString()
                val id = doc.data.get("id").toString()
                val jobs = Jobs(address, contact, createdAt, date, name, time, type, id)
                newJobList.add(jobs)
            }
            newJobAdapter.notifyDataSetChanged()
        }.addOnFailureListener { e ->
            Log.d(TAG, "buildData: ${e.toString()}")
        }
    }


    override fun setOnJobClickListener(jobs: Jobs) {
        val intent = Intent(activity,JobActivity::class.java)
        intent.putExtra("jobs",jobs)
        startActivity(intent)
    }

}