package edu.ucsb.cs.cs184.amandaserex.aserexmmmedley.ui.speechtotext

import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.floatingactionbutton.FloatingActionButton
import edu.ucsb.cs.cs184.amandaserex.aserexmmmedley.R
import java.util.*


class SpeechToTextFragment : Fragment() {

    companion object {
        fun newInstance() = SpeechToTextFragment()
        private const val requestCode = 1
    }


    private lateinit var viewModel: SpeechToTextViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_speechtotext, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SpeechToTextViewModel::class.java)

        val fab: FloatingActionButton = requireActivity().findViewById<FloatingActionButton>(R.id.fabstt)

        val speech = requireActivity().findViewById<TextView>(R.id.textboxbox)

        viewModel.text.observe(viewLifecycleOwner, {speech.text = it})
        fab.setOnClickListener {
            val intent = Intent(
                RecognizerIntent.ACTION_RECOGNIZE_SPEECH
            )
            intent.putExtra(
                RecognizerIntent.EXTRA_LANGUAGE,
                Locale.getDefault()
            )
            intent.putExtra(
                RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
            )

            intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak!")
            startActivityForResult(intent, requestCode)


            }

        }
    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int, intent: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, intent)
        when(requestCode) {
            requestCode -> {
                val list = intent?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
                val spokenText = list!![0]
                viewModel.text.value = spokenText
            }
        }

    }

}