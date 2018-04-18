package com.interview.dreamerleon.foreachviewchilds

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    /*
    * 2018.4.15 杭州绿湾面试题
    * 逐层打印rootView下各子view的id
    */
    var layer = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStart.setOnClickListener{
            tvLog.text = ""
            layer = 0
            var vps =  ArrayList<View>()
            vps.add(this@MainActivity.window.decorView.findViewById(android.R.id.content))
            while (vps.size > 0){
                vps = printAndGetChilds(vps,layer)
            }

        }
    }

    fun printAndGetChilds(views: ArrayList<View>, layer: Int): ArrayList<View> {
        val nextLayer = ArrayList<View>()
        this@MainActivity.layer++
        tvLog.append("第$layer 层")
        for (v in views) {
//            为方便查看此处改为打印Tag
            tvLog.append(v.tag?.toString() + " ")
            if (v is ViewGroup){
                for (i in 0 until v.childCount){
                    nextLayer.add(v.getChildAt(i))
                }
            }
        }
        tvLog.append("\n")
        return nextLayer
    }

}
