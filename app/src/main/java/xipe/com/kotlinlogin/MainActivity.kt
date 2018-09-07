package xipe.com.kotlinlogin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var editUserName: EditText
    lateinit var editPassword: EditText
    lateinit var buttonLogin: Button
    lateinit var buttonReset: Button
    val userNameDefault = "tester"
    val userPasswordDefault = "123456"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init(){
        editUserName = findViewById(R.id.editUserName) as EditText
        editPassword = findViewById(R.id.editPassword) as EditText
        buttonLogin = findViewById(R.id.buttonLogin) as Button
        buttonLogin.setOnClickListener{
            checkLogin()
        }

        buttonReset = findViewById(R.id.buttonReset) as Button
        buttonReset.setOnClickListener {
            editUserName.setText("")
            editPassword.setText("")

        }
    }

    private fun checkLogin(){
        var userName = editUserName.text.toString().trim()
        var userPassword = editPassword.text.toString().trim()
        if(userName.isEmpty() || userPassword.isEmpty()) {
            Toast.makeText(this, "Username and password can not be empty.", Toast.LENGTH_LONG).show()
            return
        }

        if((userNameDefault == userName) && (userPasswordDefault == userPassword)){
            var intent = Intent(this, Home::class.java)
            intent.putExtra("name", userName)
            startActivity(intent)
            finish()
        }else{
            Toast.makeText(this, "Please enter user name: " + userNameDefault + "\n" + "and password: " +userPasswordDefault, Toast.LENGTH_LONG).show()
        }
    }
}
