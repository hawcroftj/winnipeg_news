package hawcroftj.github.com.winnipegnews

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class ItemList : AppCompatActivity(), AsyncResponse {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_list)

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
    }
}
