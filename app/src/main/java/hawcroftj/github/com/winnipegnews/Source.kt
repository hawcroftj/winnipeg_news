package hawcroftj.github.com.winnipegnews

import android.os.Parcel
import android.os.Parcelable

/**
 * Source
 * A news source to be displayed in a ListView.
 * A source contains a name (i.e. 'Local News'),
 * and a URL (i.e. 'www.local-news.com').
 */
class Source(val name: String, val url: String) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Source> {
        override fun createFromParcel(parcel: Parcel): Source {
            return Source(parcel)
        }

        override fun newArray(size: Int): Array<Source?> {
            return arrayOfNulls(size)
        }
    }
}