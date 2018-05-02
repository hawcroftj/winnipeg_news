package hawcroftj.github.com.winnipegnews

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class ItemList : AppCompatActivity(), AsyncResponse {

    private lateinit var lvItems: ListView
    private lateinit var itemsAdapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_list)

        // initialize views
        lvItems = findViewById(R.id.lvItems)

        // receive the selected news Source
        val sourceIntent = intent
        val selectedSource = sourceIntent.getParcelableExtra<Source>("source")

        // set activity label
        setTitle(selectedSource.name)

        // begin processing the selected Source
        val processTask = ProcessSourceFeed(selectedSource)
        processTask.delegate = this
        processTask.execute()
    }

    override fun onStart() {
        super.onStart()

        // send selected Item to ItemWebView
        lvItems.setOnItemClickListener { parent, view, position, id ->
            val selectedItem = itemsAdapter.getItem(position) as Item
            val itemIntent = Intent(this, ItemWebView::class.java)
            itemIntent.putExtra("item", selectedItem)
            startActivity(itemIntent)
        }
    }

    /**
     * Receives a collection of Source Items and creates an ItemsAdapter.
     */
    override fun processFinish(sourceItems: ArrayList<Item>) {
        var items: ArrayList<Item> = sourceItems

        // prepare adapter for lvItems
        itemsAdapter = ItemAdapter(this, items)
        lvItems.adapter = itemsAdapter
        itemsAdapter.notifyDataSetChanged()
    }
}
