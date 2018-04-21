package hawcroftj.github.com.winnipegnews

import android.content.Context
import android.support.v7.view.menu.ActionMenuItemView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView

class SourceAdapter(private val context: Context,
                    private val sourceUrlList: Array<String>) : BaseAdapter() {

    private val inflater: LayoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    private class ViewHolder(row: View?) {

    }

    override fun getCount(): Int {
        return sourceUrlList.size
    }

    override fun getItem(position: Int): Any {
        return sourceUrlList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        return inflater.inflate(R.layout.source_row, parent, false)
    }
}
