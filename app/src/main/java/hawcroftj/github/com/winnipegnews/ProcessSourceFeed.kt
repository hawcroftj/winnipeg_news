package hawcroftj.github.com.winnipegnews

import android.nfc.Tag
import android.os.AsyncTask
import android.util.Log
import android.widget.Toast
import org.xml.sax.SAXException
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import javax.xml.parsers.ParserConfigurationException
import javax.xml.parsers.SAXParser
import javax.xml.parsers.SAXParserFactory

/**
 * ProcessSourceFeed
 * This class processes the RSS feed of a given Source via AsyncTask
 * by grabbing the news items available in a feed and converting them
 * into Item objects.
 */
class ProcessSourceFeed(val source: Source) : AsyncTask<Source, Int, Long>() {

    private val TAG: String = "SAX-parse"
    private val handler: SourceHandler = SourceHandler()
    var sourceItems: ArrayList<Item> = ArrayList()

    override fun onPreExecute() {
        super.onPreExecute()
    }

    override fun doInBackground(vararg params: Source?): Long? {
        var saxParser: SAXParser? = null
        val currentUrl: URL
        val connection: HttpURLConnection
        val stream: InputStream

        try {
            // grab the Source RSS feed URL
            currentUrl = URL(source.url)
            // initialize SAXParser, HttpURLConnection, and InputStream
            saxParser = SAXParserFactory.newInstance().newSAXParser()
            connection = currentUrl.openConnection() as HttpURLConnection
            stream = connection.inputStream

            saxParser.parse(stream, handler)

        } catch (ex: Exception) { // TODO implement exception handling
            when(ex) {
                is IOException -> { Log.d(TAG, ex.message) }
                is MalformedURLException -> { Log.d(TAG, ex.message) }
                is ParserConfigurationException, is SAXException -> { Log.d(TAG, ex.message) }
            }
        }

        return null
    }

    override fun onProgressUpdate(vararg values: Int?) {
        super.onProgressUpdate(*values)
    }

    override fun onPostExecute(result: Long?) {
        super.onPostExecute(result)
        Log.d(TAG, "Done!")
        // retrieve the Items parsed in the handler
        sourceItems = handler.sourceItems
    }
}