package qjh.com.kotlinmenu

import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.activity_main.*
import qjh.com.kotlinmenu.fragment.HomeFragment
import qjh.com.kotlinmenu.fragment.MineFragment
import qjh.com.kotlinmenu.fragment.OtherFragment

class MainActivity : FragmentActivity(), RadioGroup.OnCheckedChangeListener {
    var homeFragment: HomeFragment? = null
    var otherFragment: OtherFragment? = null
    var mingFragment: MineFragment? = null
    override fun onCheckedChanged(p0: RadioGroup?, p1: Int) {
        when (p1) {
            R.id.main_rb1 -> {
                supportFragmentManager.beginTransaction().replace(R.id.layout_contain, homeFragment).commit()
            }
            R.id.main_rb2 -> {
                supportFragmentManager.beginTransaction().replace(R.id.layout_contain, otherFragment).commit()
            }
            R.id.main_rb3 -> {
                supportFragmentManager.beginTransaction().replace(R.id.layout_contain, mingFragment).commit()
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        homeFragment = HomeFragment()
        otherFragment = OtherFragment()
        mingFragment = MineFragment()
        supportFragmentManager.beginTransaction().replace(R.id.layout_contain, homeFragment).commit()
        main_rg.setOnCheckedChangeListener(this)

    }
}
