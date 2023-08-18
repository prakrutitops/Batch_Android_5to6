package com.example.sharedata

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.DialogFragment
import com.example.sharedata.R.id.btn1
import com.example.sharedata.R.id.txt1
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var btn1:Button
    lateinit var btn2:Button
    companion object
    {
        lateinit var txt1:TextView
    }



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        txt1 = findViewById(R.id.txt1)

        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)

    }

    override fun onClick(v: View?)
    {
        if(v==btn1)
        {
            var d = DatePickerEx()
            d.show(supportFragmentManager,"")
        }

        if(v==btn2)
        {
            var d = TimerPickerEx()
            d.show(supportFragmentManager,"")
        }
    }


}
class DatePickerEx : DialogFragment(), DatePickerDialog.OnDateSetListener
{
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog
    {
        var calender = Calendar.getInstance()
        var day = calender.get(Calendar.DAY_OF_MONTH)
        var month = calender.get(Calendar.MONTH)
        var year = calender.get(Calendar.YEAR)
        return DatePickerDialog(requireActivity(),this,year,month,day)
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int)
    {
            //Toast.makeText(requireActivity(),"$dayOfMonth - $month - $year",Toast.LENGTH_LONG).show()
        (MainActivity).txt1.setText("$dayOfMonth - $month - $year")
    }
}


class TimerPickerEx : DialogFragment(), TimePickerDialog.OnTimeSetListener {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog
    {
        var calender = Calendar.getInstance()
        var hour = calender.get(Calendar.HOUR_OF_DAY)
        var minute = calender.get(Calendar.MINUTE)
        return TimePickerDialog(requireActivity(),this,hour,minute,true)
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        (MainActivity).txt1.setText("$hourOfDay - $minute")
    }


}
