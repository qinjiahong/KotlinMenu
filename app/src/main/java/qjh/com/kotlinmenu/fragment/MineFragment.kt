package qjh.com.kotlinmenu.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_mine.*
import qjh.com.kotlinmenu.R

/**
 * Created by qinjiahong on 2017/10/14.
 */
class MineFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_mine, null)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mine_text.setText("我的")
        getValues()
    }

    //Kotlin高阶函数
    fun add(x: Int = 0, y: Int = 0): Int {
        return x + y
    }

    fun operate(x: Int = 0, y: Int = 0, body: (Int, Int) -> Int) {
        Log.e("TAG", "this result is " + body(x, y))
    }

    fun getValues() {
        operate(3, 7) { x, y -> add(x, y) }

    }
}