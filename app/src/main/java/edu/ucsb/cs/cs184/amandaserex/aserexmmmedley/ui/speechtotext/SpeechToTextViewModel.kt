package edu.ucsb.cs.cs184.amandaserex.aserexmmmedley.ui.speechtotext

import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.ucsb.cs.cs184.amandaserex.aserexmmmedley.R

class SpeechToTextViewModel : ViewModel() {

    var text: MutableLiveData<String> = MutableLiveData("Tap on FAB to speak!")

}