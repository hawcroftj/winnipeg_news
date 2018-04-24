package hawcroftj.github.com.winnipegnews

import android.os.Parcel
import android.os.Parcelable

/**
 * Item
 * A news item to be displayed in a ListView.
 * An item contains a title, some content (i.e. an article),
 * and optionally, an image.
 */
class Item(val title: String, val content: String, val image: String) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(content)
        parcel.writeString(image)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Item> {
        override fun createFromParcel(parcel: Parcel): Item {
            return Item(parcel)
        }

        override fun newArray(size: Int): Array<Item?> {
            return arrayOfNulls(size)
        }
    }

}