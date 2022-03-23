package tr.edu.maltepe.assignment4

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.text.SimpleDateFormat
import android.widget.DatePicker
import java.util.*

class MainActivity : AppCompatActivity() {
    private var tvSelectedDate:TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val datepicker: Button = findViewById(R.id.button)
        tvSelectedDate = findViewById(R.id.textView5)

        datepicker.setOnClickListener {
            clickDatePicker()
        }
    }
    fun clickDatePicker(){
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener { view, syear, smonth, sday ->
            val selectedDate = "$sday/$(month+1)/$syear"
            tvSelectedDate?.text = selectedDate

            val sdf = SimpleDateFormat("dd/mm/yyyy")
            val theDate = sdf.parse(selectedDate)
        },
            year,
            month,
            day
        ).show()
    }
}


