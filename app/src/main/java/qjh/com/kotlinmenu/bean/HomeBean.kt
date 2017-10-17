package qjh.com.kotlinmenu.bean

/**
 * Created by qinjiahong on 2017/10/16.
 */

data class HomeBean(val name: String, val age: Int) {
    override fun hashCode(): Int {
        return super.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun toString(): String {
        return "name=" + name + ",age=" + age
    }
}
