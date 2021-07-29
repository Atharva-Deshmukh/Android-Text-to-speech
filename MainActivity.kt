package com.example.texttospeech

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    //initialize text to speech library
    lateinit var textToSpeech: TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //we will register object of button
        var btn : Button=findViewById(R.id.button)
        //we will register object of edittext
        var editText : EditText=findViewById(R.id.editTextTextMultiLine)
        textToSpeech = TextToSpeech(this,this)
        //button me feature daalenge
        btn.setOnClickListener {
            //gets string from the user
            var ch: String = editText.text.toString()
            textToSpeech.speak(ch,TextToSpeech.QUEUE_FLUSH,null)
        }

    }

    override fun onInit(status: Int){
        if(status==TextToSpeech.SUCCESS){
            val res : Int = textToSpeech.setLanguage(Locale.US)
            if(res==TextToSpeech.LANG_MISSING_DATA || res==TextToSpeech.LANG_NOT_SUPPORTED){
                Toast.makeText(this,"Language not supported!",Toast.LENGTH_LONG).show()
            }
        }
        else{
            Toast.makeText(this,"Failed to initialize library!",Toast.LENGTH_LONG).show()
        }
    }
}