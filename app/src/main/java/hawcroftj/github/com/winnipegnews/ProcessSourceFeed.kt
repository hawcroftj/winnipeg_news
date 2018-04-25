package hawcroftj.github.com.winnipegnews

import android.os.AsyncTask
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
    override fun onPreExecute() {
        super.onPreExecute()
    }

    override fun doInBackground(vararg params: Source?): Long? {
        var saxParser: SAXParser? = null
        val currentUrl: URL
        val connection: HttpURLConnection
        val stream: InputStream
        val handler: SourceHandler = SourceHandler()

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
                is IOException -> { }
                is MalformedURLException -> { }
                is ParserConfigurationException, is SAXException -> { }
            }
        }

        return null
    }

    override fun onProgressUpdate(vararg values: Int?) {
        super.onProgressUpdate(*values)
    }

    override fun onPostExecute(result: Long?) {
        super.onPostExecute(result)
    }
}