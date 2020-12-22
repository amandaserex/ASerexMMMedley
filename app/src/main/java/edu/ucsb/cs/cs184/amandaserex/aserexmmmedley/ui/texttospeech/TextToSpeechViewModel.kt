package edu.ucsb.cs.cs184.amandaserex.aserexmmmedley.ui.texttospeech

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TextToSpeechViewModel : ViewModel() {

    var text: MutableLiveData<String> = MutableLiveData("Type something you want me to say!")

}