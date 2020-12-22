package edu.ucsb.cs.cs184.amandaserex.aserexmmmedley.ui.texttospeech

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.speech.tts.TextToSpeech.OnInitListener
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.floatingactionbutton.FloatingActionButton
import edu.ucsb.cs.cs184.amandaserex.aserexmmmedley.R

class TextToSpeechFragment : Fragment() {

    companion object {
        fun newInstance() = TextToSpeechFragment()
    }

    private lateinit var viewModel: TextToSpeechViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_texttospeech, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TextToSpeechViewModel::class.java)

        val speech: EditText = requireActivity().findViewById<EditText>(R.id.speechTextBox)

        var w = false
        val tts = TextToSpeech(context,
                OnInitListener {
                    w = true
                })

        val fab: FloatingActionButton = requireActivity().findViewById<FloatingActionButton>(R.id.fabtts)
        fab.setOnClickListener {
            if(w) tts.speak(speech.text,TextToSpeech.QUEUE_ADD, null, "yay")
        }
    }

}