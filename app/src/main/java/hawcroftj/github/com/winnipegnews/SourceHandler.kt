package hawcroftj.github.com.winnipegnews

import org.xml.sax.Attributes
import org.xml.sax.helpers.DefaultHandler

/**
 * SourceHandler
 * Converts news article data (json, XML) from a given Source feed into Item objects.
 */
class SourceHandler : DefaultHandler (){
    var sourceItems: ArrayList<Item> = ArrayList()
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
        // 'open' the node which is currently being processed (set flag to true)
        when(qName) {
            "item" -> { inItem = true }
            "title" -> { inTitle = true }
            "link" -> { inLink = true }
            "description" -> { inContent = true }
            "pubDate" -> { inDate = true }
            "author" -> { inAuthor = true }
        }
    }

    override fun endElement(uri: String?, localName: String?, qName: String?) {
        super.endElement(uri, localName, qName)
        // 'close' the node which is currently being processed (set flag to false)
        when(qName) {
            "item" -> { // add the new Item to list of Source Items
                inItem = false
                sourceItems.add(Item(titleString.toString().trim(),
                        contentString.toString().trim(),
                        dateString.toString().trim(),
                        linkString.toString().trim(),
                        authorString.toString().trim(), ""))
            }
            "title" -> { inTitle = false }
            "link" -> { inLink = false }
            "description" -> { inContent = false }
            "pubDate" -> { inDate = false }
            "author" -> { inAuthor = false }
        }
    }

    override fun characters(ch: CharArray?, start: Int, length: Int) {
        super.characters(ch, start, length)
        // add the node data to the correct property string builder
        if(inItem && ch != null) {
            if(inTitle) {
                titleString.append(ch, start, length)
            } else if(inLink) {
                linkString.append(ch, start, length)
            } else if(inContent) {
                contentString.append(ch, start, length)
            } else if(inDate) {
                dateString.append(ch, start, length)
            } else if(inAuthor) {
                authorString.append(ch, start, length)
            }
        }
    }
}