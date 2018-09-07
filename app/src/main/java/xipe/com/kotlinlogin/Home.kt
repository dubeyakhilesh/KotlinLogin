package xipe.com.kotlinlogin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Home : AppCompatActivity() {

    lateinit var textWelcome: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        init()
    }

    private fun init(){
        textWelcome = findViewById(R.id.textWelcome) as TextView
        val intent = getIntent()
        var name = intent.getStringExtra("name")
        var message = "Welcome" + "\n\n" + name
        textWelcome.setText(message)
    }
}
