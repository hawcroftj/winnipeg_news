package hawcroftj.github.com.winnipegnews

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class ItemList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_list)

        /* TODO
         * Format:
         * Title, Post Date, Content, [optional] Image
         */

        val sourceIntent = intent
        val selectedSource = sourceIntent.getParcelableExtra<Source>("source")
        Toast.makeText(this, selectedSource.name, Toast.LENGTH_SHORT).show()

        val processTask: ProcessSourceFeed = ProcessSourceFeed(selectedSource)
        processTask.execute()

    }
}
