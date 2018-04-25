package hawcroftj.github.com.winnipegnews

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class ItemList : AppCompatActivity(), AsyncResponse {

    private lateinit var lvItems: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_list)

        // initialize views
        lvItems = findViewById(R.id.lvItems)

        // receive the selected news Source
        val sourceIntent = intent
        val selectedSource = sourceIntent.getParcelableExtra<Source>("source")

        // begin processing the selected Source
        val processTask = ProcessSourceFeed(selectedSource)
        processTask.delegate = this
        processTask.execute()
    }

    override fun processFinish(sourceItems: ArrayList<Item>) {
        var items: ArrayList<Item> = sourceItems

        // prepare adapter for lvItems
        val itemsAdapter = ItemAdapter(this, items)
        lvItems.adapter = itemsAdapter
        itemsAdapter.notifyDataSetChanged()
    }
}
