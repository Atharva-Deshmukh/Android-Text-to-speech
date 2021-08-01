package com.example.texttospeech

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.*


class MainActivity : AppCompatActivity() {

    //declare variable
    lateinit var tts : TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //declaring button variable and cast it into Button
        var b1=findViewById<Button>(R.id.button)

        //same for text and cast it into edittext
        var e1=findViewById<EditText>(R.id.editTextTextMultiLine)

            //whenever user click on button b1
        b1.setOnClickListener {
            //initialize instance of text to speech

            //constructor of TextToSpeech
            tts= TextToSpeech(applicationContext,TextToSpeech.OnInitListener {
                if(it==TextToSpeech.SUCCESS)
                {
                    //set language
                    tts.language= Locale.US

                    //set speech rate
                    tts.setSpeechRate(1.0f)

                    //speak content available in edit text
                    tts.speak(e1.text.toString(),TextToSpeech.QUEUE_ADD,null)
                }
            })
        }

    }

}