package hawcroftj.github.com.winnipegnews

/**
 * AsyncResponse
 * Allows ProcessSourceFeed class to return Source article
 * data to the main thread as a collection of Items.
 */
interface AsyncResponse {
    fun processFinish(sourceItems: ArrayList<Item>)
}