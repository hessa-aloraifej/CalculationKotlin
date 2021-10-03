package com.example.calculationkotlin


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.text.DecimalFormat
import org.mariuszgromada.math.mxparser.Expression


class MainActivity : AppCompatActivity() {
    lateinit var sign: Button
    lateinit var delButton:Button
    lateinit var n0: Button
    lateinit var n1: Button
    lateinit var n2: Button
    lateinit var n3: Button
    lateinit var n4: Button
    lateinit var n5: Button
    lateinit var n6: Button
    lateinit var n7: Button
    lateinit var n8: Button
    lateinit var n9: Button
    lateinit var add: Button
    lateinit var sub: Button
    lateinit var div: Button
    lateinit var mul: Button
    lateinit var dot: Button
    lateinit var resultButton: Button
    lateinit var cButton: Button
    lateinit var display: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        n0 = findViewById(R.id.n0)
        n1 = findViewById(R.id.n1)
        n2 = findViewById(R.id.n2)
        n3 = findViewById(R.id.n3)
        n4 = findViewById(R.id.n4)
        n5 = findViewById(R.id.n5)
        n6 = findViewById(R.id.n6)
        n7 = findViewById(R.id.n7)
        n8 = findViewById(R.id.n8)
        n9 = findViewById(R.id.n9)
        add = findViewById(R.id.add)
        sub = findViewById(R.id.sub)
        mul = findViewById(R.id.mul)
        div = findViewById(R.id.div)
        dot = findViewById(R.id.dot)
        sign=findViewById(R.id.sign)
        delButton = findViewById(R.id.delButton)
        resultButton = findViewById(R.id.resultButton)
        display = findViewById(R.id.textView)
        cButton = findViewById(R.id.cButton)

        cButton.setOnClickListener {
           display.text=""


        }


        n0.setOnClickListener {
            display.text = addToInputText("0")
        }
        n1.setOnClickListener {
            display.text = addToInputText("1")
        }
        n2.setOnClickListener {
            display.text = addToInputText("2")
        }
        n3.setOnClickListener {
            display.text = addToInputText("3")
        }
        n4.setOnClickListener {
            display.text = addToInputText("4")
        }
        n5.setOnClickListener {
            display.text = addToInputText("5")
        }
        n6.setOnClickListener {
            display.text = addToInputText("6")
        }
        n7.setOnClickListener {
            display.text = addToInputText("7")
        }
        n8.setOnClickListener {
            display.text = addToInputText("8")
        }
        n9.setOnClickListener {
            display.text = addToInputText("9")
        }
        dot.setOnClickListener {
            display.text = addToInputText(".")
        }
        sign.setOnClickListener {

             display.text = addToInputText("-")
        }
        delButton.setOnClickListener {
        val length=display.length()
           if (display.text.isEmpty()){ display.text=""}
           else{ display.text =display.text.subSequence(0, length - 1)}
        }
        div.setOnClickListener {
            display.text = addToInputText("/") // ALT + 0247
        }
        mul.setOnClickListener {
            display.text = addToInputText("*") // ALT + 0215
        }
        sub.setOnClickListener {
            display.text = addToInputText("-")
        }
        add.setOnClickListener {
            display.text = addToInputText("+")
        }

        resultButton.setOnClickListener {
            showResult()
        }


    }

    private fun addToInputText(buttonValue: String): String = "${display.text}$buttonValue"


    private fun showResult() {


            val result = Expression(display.text.toString()).calculate()

                if(result.isNaN()){
                    display.text ="0.0"
                }
               else{ display.text = DecimalFormat("0.######").format(result).toString().toFloat().toString()}



    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putString("display", display.text.toString())


    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        display.text = savedInstanceState.getString("display", "0")
        display.text = " $display"
    }
}