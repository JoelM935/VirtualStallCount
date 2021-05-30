package com.example.virtualstallcount

import android.annotation.SuppressLint
import android.media.AudioManager
import android.media.SoundPool
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity(), View.OnTouchListener {

    private var soundPool: SoundPool? = null
    private val soundID = 1
    private var streamId: Int? = 1
    var SoundMap: HashMap<Int, Int>? = null
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        soundPool = SoundPool(6, AudioManager.STREAM_MUSIC, 0)
        SoundMap = HashMap()
        SoundMap!![1] = soundPool!!.load(baseContext, R.raw.stallcount_1, 1)
        SoundMap!![2] = soundPool!!.load(baseContext, R.raw.stallcount_2, 1)
        SoundMap!![3] = soundPool!!.load(baseContext, R.raw.stallcount_3, 1)
        SoundMap!![4] = soundPool!!.load(baseContext, R.raw.stallcount_4, 1)
        SoundMap!![5] = soundPool!!.load(baseContext, R.raw.stallcount_5, 1)
        SoundMap!![6] = soundPool!!.load(baseContext, R.raw.stallcount_6, 1)
        SoundMap!![7] = soundPool!!.load(baseContext, R.raw.stallcount_7, 1)
        SoundMap!![8] = soundPool!!.load(baseContext, R.raw.stallcount_8, 1)
        SoundMap!![9] = soundPool!!.load(baseContext, R.raw.stallcount_9, 1)
//        viewTouch.setOnTouchListener(this)
//        val buttons = arrayOf(
//            this.findViewById(R.id.stallcount),
//            findViewById(R.id.stallcount2),
//            findViewById(R.id.stallcount3),
//            findViewById(R.id.stallcount4),
//            findViewById(R.id.stallcount5),
//            findViewById(R.id.stallcount6),
//            findViewById(R.id.stallcount7),
//            findViewById(R.id.stallcount8),
//            findViewById<Button>(R.id.stallcount9)
//        )
        val one: Button = this.findViewById(R.id.stallcount) as Button
        val two: Button = this.findViewById(R.id.stallcount2) as Button
        val three: Button = this.findViewById(R.id.stallcount3) as Button
        val four: Button = this.findViewById(R.id.stallcount4) as Button
        val five: Button = this.findViewById(R.id.stallcount5) as Button
        val six: Button = this.findViewById(R.id.stallcount6) as Button
        val seven: Button = this.findViewById(R.id.stallcount7) as Button
        val eight: Button = this.findViewById(R.id.stallcount8) as Button
        val nine: Button = this.findViewById(R.id.stallcount9) as Button
//        for (i in 1..9){
//            buttons[i].setOnTouchListener(this)
//            buttons[i].setId(i)
//        }
        one.setOnTouchListener(this)
        two.setOnTouchListener(this)
        three.setOnTouchListener(this)
        four.setOnTouchListener(this)
        five.setOnTouchListener(this)
        six.setOnTouchListener(this)
        seven.setOnTouchListener(this)
        eight.setOnTouchListener(this)
        nine.setOnTouchListener(this)
        one.id = 1
        two.id = 2
        three.id = 3
        four.id = 4
        five.id = 5
        six.id = 6
        seven.id = 7
        eight.id = 8
        nine.id = 9
    }
//    fun playSound(view: View) {
//        soundPool?.play(soundID, 1F, 1F, 0, 0, 1F)
//        Toast.makeText(this, "Stalling", Toast.LENGTH_SHORT).show()
//    }
    override fun onTouch(view: View, motionEvent: MotionEvent): Boolean {
        when(motionEvent.action) {
            MotionEvent.ACTION_DOWN -> {
                streamId = soundPool?.play(SoundMap?.get(view.id)!!, 1F, 1F, 0, 0, 1F)
                Toast.makeText(this, "Stalling", Toast.LENGTH_SHORT).show()
            }
            MotionEvent.ACTION_UP -> {
                soundPool?.stop(streamId!!)
            }
        }
        return true
    }

}

//android:onClick="playSound"