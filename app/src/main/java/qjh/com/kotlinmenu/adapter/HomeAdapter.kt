package qjh.com.kotlinmenu.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

import qjh.com.kotlinmenu.R

/**
 * Created by qinjiahong on 2017/10/16.
 */

class HomeAdapter(context: Context) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder? {
        var view: View? = LayoutInflater.from(context).inflate(R.layout.item_home, null)
        return HomeViewHolder(view!!)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        var metri: DisplayMetrics = context?.resources!!.displayMetrics
        var par: LinearLayout.LayoutParams? = holder.textView.layoutParams as LinearLayout.LayoutParams
        par?.width = metri.widthPixels
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

    inner class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView: TextView

        init {
            textView = itemView.findViewById(R.id.item_home_text)
        }
    }

    interface OnItemClickListener {
        fun onCallBack(position: Int);
    }
}
