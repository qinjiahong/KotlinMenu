package qjh.com.kotlinmenu.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_other.*
import qjh.com.kotlinmenu.R
import qjh.com.kotlinmenu.adapter.OtherAdapter
import qjh.com.kotlinmenu.utlis.DividerItemDecoration

/**
 * Created by qinjiahong on 2017/10/14.
 */

class OtherFragment : Fragment(), OtherAdapter.OnItemClickListener {
    override fun onCallBack(position: Int) {
        Toast.makeText(activity, "你点击了  " + mData?.get(position), Toast.LENGTH_SHORT).show()
    }

    internal var view: View? = null
    var mData: ArrayList<String>? = null
    var adapter: OtherAdapter? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        view = inflater!!.inflate(R.layout.fragment_other, null)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        other_text?.setText("分类")
        initData()
        other_text.setOnClickListener(View.OnClickListener {
            if (other_drawerlayout.isDrawerOpen(Gravity.RIGHT)) {
                other_drawerlayout.closeDrawer(Gravity.RIGHT)
            } else {
                other_drawerlayout.openDrawer(Gravity.RIGHT)
            }
        })
     /*   var bean:HomeBean?= HomeBean("张三",20)
        Log.e("TAG","bean="+bean.toString())*/
    }

    private fun initData() {
        other_recyclerview.layoutManager = LinearLayoutManager(activity)
        other_recyclerview.addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.HORIZONTAL_LIST))
        mData = arrayListOf()
        adapter = OtherAdapter(activity)
        for (i in 0..29) {
            mData?.add("分类" + i)
        }
        adapter?.setDatas(mData!!)
        other_recyclerview.adapter = adapter
        adapter?.setOnOnItemClickListener(this)
    }
}
