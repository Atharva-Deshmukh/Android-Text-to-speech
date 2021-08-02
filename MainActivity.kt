package com.example.texttospeech

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.EditText
import java.util.*

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    //declare variable
    lateinit var tts : TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //we need 2 variabes

        //one for button
        var b1 = findViewById<Button>(R.id.button)
        //one for edit text
        var e1 = findViewById<EditText>(R.id.button)

        //giving functionality to button
        b1.setOnClickListener {
            //initialize instance of tect to sppech whenever user clicks on it  //this it is integer variable
            tts = TextToSpeech(applicationContext, TextToSpeech.OnInitListener {
                if (it == TextToSpeech.SUCCESS) {
                    //set the language
                    tts.language = Locale.ENGLISH
                    //set speech rate to normal
                    tts.setSpeechRate(1.0f)
                    //speak the content available in edittext
                    tts.speak(e1.text.toString(),TextToSpeech.QUEUE_ADD,null)

                }
            })
        }

    }

}