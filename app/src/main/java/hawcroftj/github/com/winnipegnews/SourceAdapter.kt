package hawcroftj.github.com.winnipegnews

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class SourceAdapter(private val context: Context,
                    private val sources: ArrayList<Source>) : BaseAdapter() {

    /**
     * View Holder
     * Defines a row for ListView which can be recycled to improve performance.
     */
    private class ViewHolder(row: View?) {
        var tvSourceName: TextView? = null
        //var tvSourceUrl: TextView? = null

        init {
            this.tvSourceName = row?.findViewById(R.id.tvSourceName)
            //this.tvSourceUrl = row?.findViewById(R.id.tvSourceUrl)
        }
    }

    /**
     * Populates Views in a source_row with Source object data,
     * then returns the row as a View to be displayed in a ListView.
     */
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View?
        val viewHolder: ViewHolder

        // if convertView is null, inflate a View with a new source_row
        if(convertView == null) {
            val inflater =
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.source_row, null)
            viewHolder = ViewHolder(view)
            view?.tag = viewHolder
        } else {
            // if convertView has already been used, recycle it
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        // set the value of TextViews in the row to Source object data
        var source = sources[position]
        viewHolder.tvSourceName?.text = source.name
        //viewHolder.tvSourceUrl?.text = source.url

        return view as View
    }

    /**
     * Returns the size of the sources list.
     */
    override fun getCount(): Int {
        return sources.size
    }

    /**
     * Returns the Source object at a given position in the list.
     */
    override fun getItem(position: Int): Any {
        return sources[position]
    }

    /**
     * Returns the Source object Id at a given position in the list.
     */
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
}
