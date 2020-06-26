package com.example.runing_city.ui.mapPoint

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.runing_city.R
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.fragment_onepoint.view.*

class OnePointFragment : Fragment() {

    private lateinit var pointViewModel: PointViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        pointViewModel =
                ViewModelProviders.of(requireActivity()).get(PointViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_onepoint, container, false)

        val textDescriptionView: TextView = root.findViewById(R.id.point_description)
        val textDetailsView: TextView = root.findViewById(R.id.point_details)
        val textAnswer: TextInputEditText = root.findViewById(R.id.answerText)
        val textPassed: TextView = root.findViewById(R.id.point_passed_result)

        val pointId = OnePointFragmentArgs.fromBundle(requireArguments()).pointId
        val currentPoint = pointViewModel.getPoint(pointId)

        if (currentPoint.passed){
            toogleVisibility(root)
        }


        (activity as? AppCompatActivity)?.supportActionBar?.title = currentPoint.title
        textDescriptionView.text = currentPoint.description
        textDetailsView.text = currentPoint.details
        textPassed.text = if (currentPoint.passed) "Yes!" else "No!"
//        slideshowViewModel.getPoint(1).observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        root.submitButton.setOnClickListener @Suppress("UNUSED_ANONYMOUS_PARAMETER")
        { view: View ->
            if(textAnswer.text.toString().toLowerCase() == currentPoint.answer.toLowerCase() ){
                currentPoint.passed = true
                textPassed.text = "Yes!"
                val toast: Toast =
                    Toast.makeText(context, R.string.correct, Toast.LENGTH_LONG)
                val text = toast.view.findViewById(android.R.id.message) as TextView
                text.setTextColor(R.color.correctc_answer)
                toast.show()
                toogleVisibility(root)
                pointViewModel.onCorrect()
            }
            else {
                val toast: Toast =
                    Toast.makeText(context, R.string.wrong, Toast.LENGTH_LONG)
                val text = toast.view.findViewById(android.R.id.message) as TextView
                text.setTextColor(R.color.wrong_answer)
                toast.show()
            }
        }
        return root
    }

    private fun toogleVisibility(root:View) {
        root.findViewById<TextInputLayout>(R.id.answerLayout).visibility = View.INVISIBLE
        root.submitButton.visibility = View.INVISIBLE
    }

}
