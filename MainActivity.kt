package tops.tech.otpverify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity()
{
    lateinit var edtPhone: EditText
    lateinit var edtOtp:EditText
    lateinit var btn1: Button
    lateinit var btn2:Button

    //1
    private lateinit var auth: FirebaseAuth
    lateinit var verificationid:String
    lateinit var mcallback:PhoneAuthProvider.OnVerificationStateChangedCallbacks

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtPhone = findViewById(R.id.edtnum)
        edtOtp = findViewById(R.id.edtotp)
        btn1 = findViewById(R.id.btnSubmit)
        btn2 = findViewById(R.id.btnverify)
        auth = FirebaseAuth.getInstance()

        //2
        btn1.setOnClickListener {

            if(TextUtils.isEmpty(edtPhone.text.toString()))
            {
                Toast.makeText(this@MainActivity, "Please enter a valid phone number.", Toast.LENGTH_SHORT).show()
            }
            else
            {

                var mob = edtPhone.text.toString()
                //var mob2 = num.toString()+mob.toString()
                sendverificationcode(mob)
            }



        }
        //5
        btn2.setOnClickListener {

            if(TextUtils.isEmpty(edtOtp.text.toString()))
            {
                Toast.makeText(this@MainActivity, "Please enter a valid OTP.", Toast.LENGTH_SHORT).show()
            }
            else
            {
                val otp: String = edtOtp.text.toString()
                verifycode(otp)
            }

        }
        //4
        mcallback= object :PhoneAuthProvider.OnVerificationStateChangedCallbacks()
        {
            override fun onVerificationCompleted(p0: PhoneAuthCredential)
            {

                var code =p0.smsCode//get otp

                if(code!=null)
                {
                    edtOtp.setText(code)
                }
                else
                {

                    Toast.makeText(applicationContext,"Error  ", Toast.LENGTH_LONG).show();

                }


            }

            override fun onVerificationFailed(p0: FirebaseException)
            {
                Toast.makeText(applicationContext,"Failed",Toast.LENGTH_LONG).show()
            }

            override fun onCodeSent(p0: String, p1: PhoneAuthProvider.ForceResendingToken)
            {
                verificationid=p0
            }
        }

    }
    //6
    private fun verifycode(otp: String)
    {
        val credential = PhoneAuthProvider.getCredential(verificationid, otp)
        signinwithcredential(credential)
    }
    //7
    private fun signinwithcredential(credential: PhoneAuthCredential)
    {

      /*  auth.signInWithCredential(credential).addOnCompleteListener {
            if(it.isSuccessful)
            {
                Toast.makeText(applicationContext,"success",Toast.LENGTH_LONG).show()
               // var i = Intent(this,MainActivity2::class.java)
                //startActivity(i)
            }
            else
            {
                Toast.makeText(applicationContext,"Error",Toast.LENGTH_LONG).show()
            }
        }
            .addOnFailureListener()
            {

            }*/

    }

    //3
    private fun sendverificationcode(mob: String)
    {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(mob,60,TimeUnit.SECONDS,this,mcallback)
    }

}