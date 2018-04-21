package hawcroftj.github.com.winnipegnews

import hawcroftj.github.com.winnipegnews.*
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class SourceList : AppCompatActivity() {

    private lateinit var lvSources: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_source_list)

        /* TODO
         * Potential Sources:
         * Free Press, Global News, CTV News, CBC Manitoba, Winnipeg Sun, Chris D
         */

        // initialize views
        lvSources = findViewById<ListView>(R.id.lvSources)
    }

    override fun onStart() {
        super.onStart()

        // pull news source names and Urls from sources.xml
        var sourceNames = resources.getStringArray(R.array.source_name)
        var sourceUrls = resources.getStringArray(R.array.source_url)
        // create Source objects for each entry
        var sources = ArrayList<Source>()
        for(i in 0..sourceNames.size - 1) {
            sources.add(Source(sourceNames[i], sourceUrls[i]))
        }

        // prepare simple adapter for lvSources
        val sourceAdapter = SourceAdapter(this, sources)
        lvSources.adapter = sourceAdapter
    }
}
