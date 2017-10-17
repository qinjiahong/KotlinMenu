package qjh.com.kotlinmenu.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.DebugUtils
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import qjh.com.kotlinmenu.R
import qjh.com.kotlinmenu.utlis.DensityUtil

/**
 * Created by qinjiahong on 2017/10/16.
 */

class OtherAdapter(context: Context) : RecyclerView.Adapter<OtherAdapter.OtherViwHoler>() {
    var data: List<String>? = null
    var context: Context? = context
    var listener: OnItemClickListener? = null
    fun setDatas(data: List<String>) {
        this.data = data
        notifyDataSetChanged()
    }

    fun setOnOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OtherViwHoler? {
        var view: View? = LayoutInflater.from(context).inflate(R.layout.item_home, null)
        return OtherViwHoler(view!!)
    }

    override fun onBindViewHolder(holder: OtherViwHoler, position: Int) {
        var par: LinearLayout.LayoutParams? = holder.textView.layoutParams as LinearLayout.LayoutParams
        par?.width = DensityUtil().dip2px(context!!, 200f)
        holder.textView.layoutParams = par
        holder.textView.setText(data?.get(position))
        holder.itemView.setTag(position)
        holder.itemView.setOnClickListener(View.OnClickListener {
            listener?.onCallBack(holder.itemView.getTag() as Int)
        })
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    inner class OtherViwHoler(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView: TextView

        init {
            textView = itemView.findViewById(R.id.item_home_text)
        }
    }

    interface OnItemClickListener {
        fun onCallBack(position: Int)
    }
}
