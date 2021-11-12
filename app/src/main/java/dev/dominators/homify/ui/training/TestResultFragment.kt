package dev.dominators.homify.ui.training

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import dev.dominators.homify.R
import dev.dominators.homify.databinding.FragmentTestResultBinding
import java.lang.Exception
import java.util.ArrayList

class TestResultFragment : Fragment() {

    private val TAG = "TestResultFragment"
    lateinit var fragmentTestResultBinding: FragmentTestResultBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentTestResultBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_test_result,container,false)

        return return fragmentTestResultBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = arrayListOf<PieEntry>()
        addDatatoList(list)
        val pieDataSet = PieDataSet(list,"Test Result")
        pieDataSet.colors = ColorTemplate.JOYFUL_COLORS.asList()
        pieDataSet.valueTextColor = Color.BLACK

        val pieData = PieData(pieDataSet)
        fragmentTestResultBinding.apply {
            pieChart.data=pieData
            try {
                pieChart.description.isEnabled = true
                pieChart.centerText = "Test Results"
                pieChart.animate()
            }
            catch (e:Exception){
                Log.d(TAG, "onViewCreated: $e")
            }

        }
    }

    private fun addDatatoList(list: ArrayList<PieEntry>) {
        list.add(PieEntry(75f,"Correct Answers"))
        list.add(PieEntry(25f,"Incorrect Answers"))
    }

    // pieChart.inValidate()
}