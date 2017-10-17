package qjh.com.kotlinmenu.fragment

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.util.DisplayMetrics
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_home.*

import qjh.com.kotlinmenu.R
import qjh.com.kotlinmenu.adapter.HomeAdapter
import qjh.com.kotlinmenu.utlis.DividerItemDecoration


/**
 * Created by qinjiahong on 2017/10/14.
 */

class HomeFragment : Fragment(), ViewPager.OnPageChangeListener, HomeAdapter.OnItemClickListener {
    override fun onCallBack(position: Int) {
        Toast.makeText(activity, "你点击了  " + mData?.get(position), Toast.LENGTH_SHORT).show()
    }

    internal var view: View? = null
    var list: ArrayList<Int>? = arrayListOf(R.mipmap.bg1, R.mipmap.bg2, R.mipmap.bg3, R.mipmap.bg4)
    var data: ArrayList<ImageView>? = arrayListOf()
    var mData: ArrayList<String>? = arrayListOf()
    var adapter: HomeAdapter? = null
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        view = inflater!!.inflate(R.layout.fragment_home, null)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initListView()
        initData()
    }

    fun initListView() {
        home_recyclerview.layoutManager = LinearLayoutManager(activity)
        home_recyclerview.addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.HORIZONTAL_LIST,1,Color.parseColor("#99999999")))
        adapter = HomeAdapter(activity)
        for (i in 0..29) {
            mData?.add("数据   " + i)
        }
        /*for (i in 9 downTo 1){//递减
            Log.e("TAG","i="+i)
        }*/
        adapter?.setDatas(mData!!)
        home_recyclerview.adapter = adapter
        adapter?.setOnOnItemClickListener(this)
    }

    fun initData() {
        for (i in 0..((list?.size ?: 0) - 1)) {
            var image: ImageView? = ImageView(activity)
            image?.setImageResource(list!!.get(i))
            image?.scaleType = ImageView.ScaleType.CENTER_CROP
            data?.add(image!!)
        }
        var adapter: MyPagerAdapter? = MyPagerAdapter()
        home_viewpager.adapter = adapter
        home_viewpager.currentItem = data!!.size * 100
        home_viewpager.setOnPageChangeListener(this)

    }

    inner class MyPagerAdapter : PagerAdapter() {
        override fun isViewFromObject(view: View?, `object`: Any?): Boolean {
            return view == `object`
        }

        override fun getCount(): Int {

            return Int.MAX_VALUE
        }

        override fun destroyItem(container: ViewGroup?, position: Int, `object`: Any?) {
            //   container?.removeView(`object` as View?)
        }

        override fun instantiateItem(container: ViewGroup?, position: Int): Any {
            if (data?.get(position % data!!.size)!!.parent != null) {
                ((data?.get(position % data!!.size)!!.parent) as ViewPager).removeView(data?.get(position % data!!.size))
            }
            container?.addView(data!!.get(position % data!!.size), 0)
            return data!!.get(position % data!!.size)
        }
    }


    override fun onPageScrollStateChanged(state: Int) {
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
    }

    override fun onPageSelected(position: Int) {
        Log.e("TAG", "position=" + (position % data!!.size))
    }

}
