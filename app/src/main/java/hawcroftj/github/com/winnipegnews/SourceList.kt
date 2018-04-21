package hawcroftj.github.com.winnipegnews

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

        // pull news source URLs from sources.xml
        var sourceUrlList = resources.getStringArray(R.array.news_sources)
        // prepare simple adapter for lvSources
        val sourceAdapter = ArrayAdapter(this, R.layout.source_row, sourceUrlList)
        lvSources.adapter = sourceAdapter
    }
}
