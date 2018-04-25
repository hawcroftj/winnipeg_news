package hawcroftj.github.com.winnipegnews

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.ListView

class SourceList : AppCompatActivity() {

    private lateinit var lvSources: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_source_list)

        // initialize views
        lvSources = findViewById<ListView>(R.id.lvSources)
    }

    /**
     * Prepares and populates the sources ListView with Source object data.
     */
    override fun onStart() {
        super.onStart()

        // pull news source names and Urls from sources.xml
        val sourceNames = resources.getStringArray(R.array.source_name)
        val sourceUrls = resources.getStringArray(R.array.source_url)

        // create Source objects for each entry
        val sources = ArrayList<Source>()
        for(i in 0 until sourceNames.size) {
            sources.add(Source(sourceNames[i], sourceUrls[i]))
        }

        // prepare adapter for lvSources
        val sourceAdapter = SourceAdapter(this, sources)
        lvSources.adapter = sourceAdapter

        // send selected Source to ItemList activity
        lvSources.setOnItemClickListener { parent, view, position, id ->
            val selectedSource = sourceAdapter.getItem(position)
            val sourceIntent = Intent(this, ItemList::class.java)
            sourceIntent.putExtra("source", selectedSource as Parcelable)
            startActivity(sourceIntent)
        }
    }
}
