package hawcroftj.github.com.winnipegnews

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class ItemList : AppCompatActivity(), AsyncResponse {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_list)

        val sourceIntent = intent
        val selectedSource = sourceIntent.getParcelableExtra<Source>("source")
        Toast.makeText(this, selectedSource.name, Toast.LENGTH_SHORT).show()

        val processTask: ProcessSourceFeed = ProcessSourceFeed(selectedSource)
        processTask.delegate = this
        processTask.execute()

        // TODO implement interface to return data to this activity
        // https://stackoverflow.com/questions/12575068/how-to-get-the-result-of-onpostexecute-to-main-activity-because-asynctask-is-a

    }

    override fun processFinish(sourceItems: ArrayList<Item>) {
        var items: ArrayList<Item> = sourceItems
    }
}
