package com.example.tip_calculator_app

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val seek = findViewById<SeekBar>(R.id.valorPropina)
        seek?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar,
                                           progress: Int, fromUser: Boolean) {
                val propinaPorcentaje = findViewById<TextView>(R.id.porcentajePropina)
                val valorPropina = findViewById<SeekBar>(R.id.valorPropina)
                propinaPorcentaje.setText("${valorPropina.progress}%")

            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                // write custom code for progress is started
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
                // write custom code for progress is stopped
            }
        })
    }

    @SuppressLint("WrongViewCast")
    fun calcularBtnListener(view: android.view.View){
        val valorTicket = findViewById<TextView>(R.id.valorTicket)
        val valorPropina = findViewById<SeekBar>(R.id.valorPropina)
        val valorTotalAPagar = findViewById<TextView>(R.id.totalAPagar)
        val propina = valorTicket.text.toString()
            .toFloat() * (1 + (valorPropina.progress.toFloat() / 100f))
        valorTotalAPagar.setText("$propina")
    }


}