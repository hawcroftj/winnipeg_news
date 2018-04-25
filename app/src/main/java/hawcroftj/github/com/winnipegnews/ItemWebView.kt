package hawcroftj.github.com.winnipegnews

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.webkit.WebView

class ItemWebView : AppCompatActivity() {

    private lateinit var selectedItem: Item

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_web_view)

        // receive the selected Item
        selectedItem = intent.getParcelableExtra("item")
    }

    override fun onStart() {
        super.onStart()
        // load the Item url in the web view
        var wvItemView = findViewById<WebView>(R.id.wvItemView)
        wvItemView.loadUrl(selectedItem.url)
    }

    /**
     * Modify default UP button navigation to preserve Source list data
     * in calling activity: SourceList.
     */
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item!!.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
            else -> { return super.onOptionsItemSelected(item) }
        }
    }
}
