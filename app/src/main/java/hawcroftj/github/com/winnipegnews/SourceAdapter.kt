package hawcroftj.github.com.winnipegnews

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class SourceAdapter(private val context: Context,
                    private val sources: ArrayList<Source>) : BaseAdapter() {

    private class ViewHolder(row: View?) {
        var tvSourceName: TextView? = null
        var tvSourceUrl: TextView? = null

        init {
            this.tvSourceName = row?.findViewById(R.id.tvSourceName)
            this.tvSourceUrl = row?.findViewById(R.id.tvSourceUrl)
        }
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View?
        val viewHolder: ViewHolder

        if(convertView == null) {
            val inflater =
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.source_row, null)
            viewHolder = ViewHolder(view)
            view?.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        var source = sources[position]
        viewHolder.tvSourceName?.text = source.name
        viewHolder.tvSourceUrl?.text = source.url

        return view as View
    }

    override fun getCount(): Int {
        return sources.size
    }

    override fun getItem(position: Int): Any {
        return sources[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
}
