package hawcroftj.github.com.winnipegnews

import org.xml.sax.Attributes
import org.xml.sax.helpers.DefaultHandler

/**
 * SourceHandler
 * Converts news article data (json, XML) from a given Source feed into Item objects.
 */
class SourceHandler : DefaultHandler (){
    // these flags will determine which node is being processed for a given Item
    var inItem: Boolean = false
    var inTitle: Boolean = false
    var inLink: Boolean = false
    var inContent: Boolean = false
    var inDate: Boolean = false
    var inAuthor: Boolean = false
    // initialize StringBuilder for each property of the Item
    var titleString: StringBuilder = StringBuilder()
    var linkString: StringBuilder = StringBuilder()
    var contentString: StringBuilder = StringBuilder()
    var dateString: StringBuilder = StringBuilder()
    var authorString: StringBuilder = StringBuilder()

    override fun startElement(uri: String?, localName: String?, qName: String?, attributes: Attributes?) {
        super.startElement(uri, localName, qName, attributes)
        when(qName) {
            // TODO determine which node is being processed
            // TODO 'open' the node (set flag to true)
        }
    }

    override fun endElement(uri: String?, localName: String?, qName: String?) {
        super.endElement(uri, localName, qName)
        when(qName) {
            // TODO determine which node has just been processed
            // TODO 'close' the node (set flag to false)
            // TODO if the node was an entry (indicating end of article), then
            // TODO create new Item and add it to a collection
        }
    }

    override fun characters(ch: CharArray?, start: Int, length: Int) {
        super.characters(ch, start, length)
        // TODO if inside an article, and the node contains data
        // TODO determine which node is being processed and add char data to string builder
    }
}