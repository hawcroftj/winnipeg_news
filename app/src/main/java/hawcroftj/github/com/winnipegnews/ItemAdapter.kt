package hawcroftj.github.com.winnipegnews

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ItemAdapter(private val context: Context,
                  private val items: ArrayList<Item>) : BaseAdapter() {

    /**
     * View Holder
     * Defines a row for ListView which can be recycled to improve performance.
     */
    private class ViewHolder(row: View?) {
        var tvTitle: TextView? = null
        var tvContent: TextView? = null
        var tvDate: TextView? = null
        //var tvAuthor: TextView? = null

        init {
            this.tvTitle = row?.findViewById(R.id.tvTitle)
            this.tvContent = row?.findViewById(R.id.tvContent)
            this.tvDate = row?.findViewById(R.id.tvDate)
            //this.tvAuthor = row?.findViewById(R.id.tvAuthor)
        }
    }

    /**
     * Populates Views in an item_row with Item object data,
     * then returns the row as a View to be displayed in a ListView.
     */
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View?
        val viewHolder: ViewHolder

        // if convertView is null, inflate a View with a new item_row
        if(convertView == null) {
            val inflater =
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.item_row, null)
            viewHolder = ViewHolder(view)
            view?.tag = viewHolder
        } else {
            // if convertView has already been used, recycle it
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        // set the value of TextViews in the row to Item object data
        var item = items[position]
        viewHolder.tvTitle?.text = item.title
        viewHolder.tvContent?.text = String.format("%s...", item.content.substring(0, 100))
        viewHolder.tvDate?.text = item.date
        //viewHolder.tvAuthor?.text = item.author

        return view as View
    }

    /**
     * Returns the size of the items list.
     */
    override fun getCount(): Int {
        return items.size
    }

    /**
     * Returns the Item object at a given position in the list.
     */
    override fun getItem(position: Int): Any {
        return items[position]
    }

    /**
     * Returns the Item object Id at a given position in the list.
     */
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
}
