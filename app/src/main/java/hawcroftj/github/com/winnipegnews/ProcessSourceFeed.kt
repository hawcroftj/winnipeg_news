package hawcroftj.github.com.winnipegnews

import android.os.AsyncTask
import java.io.InputStream
import java.net.HttpURLConnection
import javax.xml.parsers.SAXParser

/**
 * ProcessSourceFeed
 * This class processes the RSS feed of a given Source by
 * converting news articles into Item objects for the ItemList.
 */
class ProcessSourceFeed(val source: Source) : AsyncTask<Source, Int, Long>() {
    override fun onPreExecute() {
        super.onPreExecute()
    }

    override fun doInBackground(vararg params: Source?): Long? {
        val saxParser: SAXParser
        val connection: HttpURLConnection
        val stream: InputStream



        return null
    }

    override fun onProgressUpdate(vararg values: Int?) {
        super.onProgressUpdate(*values)
    }

    override fun onPostExecute(result: Long?) {
        super.onPostExecute(result)
    }
}