package com.fady.marvelcomics.api.models


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class CharactersResponse(
    @SerializedName("attributionHTML")
    var attributionHTML: String?,
    @SerializedName("attributionText")
    var attributionText: String?,
    @SerializedName("code")
    var code: Int?,
    @SerializedName("copyright")
    var copyright: String?,
    @SerializedName("data")
    var `data`: Data?,
    @SerializedName("etag")
    var etag: String?,
    @SerializedName("status")
    var status: String?
) {

    data class Data(
        @SerializedName("count")
        var count: Int?,
        @SerializedName("limit")
        var limit: Int?,
        @SerializedName("offset")
        var offset: Int?,
        @SerializedName("results")
        var results: List<Result?>?,
        @SerializedName("total")
        var total: Int?
    ) {

        data class Result(
            @SerializedName("comics")
            var comics: Comics?,
            @SerializedName("description")
            var description: String?,
            @SerializedName("events")
            var events: Events?,
            @SerializedName("id")
            var id: Int?,
            @SerializedName("modified")
            var modified: String?,
            @SerializedName("name")
            var name: String?,
            @SerializedName("resourceURI")
            var resourceURI: String?,
            @SerializedName("series")
            var series: Series?,
            @SerializedName("stories")
            var stories: Stories?,
            @SerializedName("thumbnail")
            var thumbnail: Thumbnail?,
            @SerializedName("urls")
            var urls: List<Url?>?
        ) : Parcelable {

            constructor(parcel: Parcel) : this(
                parcel.readParcelable(Comics::class.java.classLoader),
                parcel.readString(),
                parcel.readParcelable(Events::class.java.classLoader),
                parcel.readValue(Int::class.java.classLoader) as? Int,
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readParcelable(Series::class.java.classLoader),
                parcel.readParcelable(Stories::class.java.classLoader),
                parcel.readParcelable(Thumbnail::class.java.classLoader),
                parcel.createTypedArrayList(Url)
            )

            data class Comics(
                @SerializedName("available")
                var available: Int?,
                @SerializedName("collectionURI")
                var collectionURI: String?,
                @SerializedName("items")
                var items: List<Item?>?,
                @SerializedName("returned")
                var returned: Int?
            ) : Parcelable {

                constructor(parcel: Parcel) : this(
                    parcel.readValue(Int::class.java.classLoader) as? Int,
                    parcel.readString(),
                    parcel.createTypedArrayList(Item),
                    parcel.readValue(Int::class.java.classLoader) as? Int
                )

                data class Item(
                    @SerializedName("name")
                    var name: String?,
                    @SerializedName("resourceURI")
                    var resourceURI: String?
                ) : Parcelable {
                    constructor(parcel: Parcel) : this(
                        parcel.readString(),
                        parcel.readString()
                    )

                    override fun writeToParcel(parcel: Parcel, flags: Int) {
                        parcel.writeString(name)
                        parcel.writeString(resourceURI)
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

                override fun writeToParcel(parcel: Parcel, flags: Int) {
                    parcel.writeValue(available)
                    parcel.writeString(collectionURI)
                    parcel.writeTypedList(items)
                    parcel.writeValue(returned)
                }

                override fun describeContents(): Int {
                    return 0
                }

                companion object CREATOR : Parcelable.Creator<Comics> {
                    override fun createFromParcel(parcel: Parcel): Comics {
                        return Comics(parcel)
                    }

                    override fun newArray(size: Int): Array<Comics?> {
                        return arrayOfNulls(size)
                    }
                }
            }


            data class Events(
                @SerializedName("available")
                var available: Int?,
                @SerializedName("collectionURI")
                var collectionURI: String?,
                @SerializedName("items")
                var items: List<Item?>?,
                @SerializedName("returned")
                var returned: Int?
            ) : Parcelable {

                constructor(parcel: Parcel) : this(
                    parcel.readValue(Int::class.java.classLoader) as? Int,
                    parcel.readString(),
                    parcel.createTypedArrayList(Item),
                    parcel.readValue(Int::class.java.classLoader) as? Int
                )

                data class Item(
                    @SerializedName("name")
                    var name: String?,
                    @SerializedName("resourceURI")
                    var resourceURI: String?
                ) : Parcelable {
                    constructor(parcel: Parcel) : this(
                        parcel.readString(),
                        parcel.readString()
                    )

                    override fun writeToParcel(parcel: Parcel, flags: Int) {
                        parcel.writeString(name)
                        parcel.writeString(resourceURI)
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

                override fun writeToParcel(parcel: Parcel, flags: Int) {
                    parcel.writeValue(available)
                    parcel.writeString(collectionURI)
                    parcel.writeTypedList(items)
                    parcel.writeValue(returned)
                }

                override fun describeContents(): Int {
                    return 0
                }

                companion object CREATOR : Parcelable.Creator<Events> {
                    override fun createFromParcel(parcel: Parcel): Events {
                        return Events(parcel)
                    }

                    override fun newArray(size: Int): Array<Events?> {
                        return arrayOfNulls(size)
                    }
                }
            }


            data class Series(
                @SerializedName("available")
                var available: Int?,
                @SerializedName("collectionURI")
                var collectionURI: String?,
                @SerializedName("items")
                var items: List<Item?>?,
                @SerializedName("returned")
                var returned: Int?
            ) : Parcelable {

                constructor(parcel: Parcel) : this(
                    parcel.readValue(Int::class.java.classLoader) as? Int,
                    parcel.readString(),
                    parcel.createTypedArrayList(Item),
                    parcel.readValue(Int::class.java.classLoader) as? Int
                )

                data class Item(
                    @SerializedName("name")
                    var name: String?,
                    @SerializedName("resourceURI")
                    var resourceURI: String?
                ) : Parcelable {
                    constructor(parcel: Parcel) : this(
                        parcel.readString(),
                        parcel.readString()
                    )

                    override fun writeToParcel(parcel: Parcel, flags: Int) {
                        parcel.writeString(name)
                        parcel.writeString(resourceURI)
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

                override fun writeToParcel(parcel: Parcel, flags: Int) {
                    parcel.writeValue(available)
                    parcel.writeString(collectionURI)
                    parcel.writeTypedList(items)
                    parcel.writeValue(returned)
                }

                override fun describeContents(): Int {
                    return 0
                }

                companion object CREATOR : Parcelable.Creator<Series> {
                    override fun createFromParcel(parcel: Parcel): Series {
                        return Series(parcel)
                    }

                    override fun newArray(size: Int): Array<Series?> {
                        return arrayOfNulls(size)
                    }
                }
            }


            data class Stories(
                @SerializedName("available")
                var available: Int?,
                @SerializedName("collectionURI")
                var collectionURI: String?,
                @SerializedName("items")
                var items: List<Item?>?,
                @SerializedName("returned")
                var returned: Int?
            ) : Parcelable {

                constructor(parcel: Parcel) : this(
                    parcel.readValue(Int::class.java.classLoader) as? Int,
                    parcel.readString(),
                    parcel.createTypedArrayList(Item),
                    parcel.readValue(Int::class.java.classLoader) as? Int
                )

                data class Item(
                    @SerializedName("name")
                    var name: String?,
                    @SerializedName("resourceURI")
                    var resourceURI: String?,
                    @SerializedName("type")
                    var type: String?
                ) : Parcelable {
                    constructor(parcel: Parcel) : this(
                        parcel.readString(),
                        parcel.readString(),
                        parcel.readString()
                    )

                    override fun writeToParcel(parcel: Parcel, flags: Int) {
                        parcel.writeString(name)
                        parcel.writeString(resourceURI)
                        parcel.writeString(type)
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

                override fun writeToParcel(parcel: Parcel, flags: Int) {
                    parcel.writeValue(available)
                    parcel.writeString(collectionURI)
                    parcel.writeTypedList(items)
                    parcel.writeValue(returned)
                }

                override fun describeContents(): Int {
                    return 0
                }

                companion object CREATOR : Parcelable.Creator<Stories> {
                    override fun createFromParcel(parcel: Parcel): Stories {
                        return Stories(parcel)
                    }

                    override fun newArray(size: Int): Array<Stories?> {
                        return arrayOfNulls(size)
                    }
                }
            }


            data class Thumbnail(
                @SerializedName("extension")
                var extension: String?,
                @SerializedName("path")
                var path: String?
            ) : Parcelable {
                constructor(parcel: Parcel) : this(
                    parcel.readString(),
                    parcel.readString()
                )

                override fun writeToParcel(parcel: Parcel, flags: Int) {
                    parcel.writeString(extension)
                    parcel.writeString(path)
                }

                override fun describeContents(): Int {
                    return 0
                }

                companion object CREATOR : Parcelable.Creator<Thumbnail> {
                    override fun createFromParcel(parcel: Parcel): Thumbnail {
                        return Thumbnail(parcel)
                    }

                    override fun newArray(size: Int): Array<Thumbnail?> {
                        return arrayOfNulls(size)
                    }
                }
            }


            data class Url(
                @SerializedName("type")
                var type: String?,
                @SerializedName("url")
                var url: String?
            ) : Parcelable {
                constructor(parcel: Parcel) : this(
                    parcel.readString(),
                    parcel.readString()
                )

                override fun writeToParcel(parcel: Parcel, flags: Int) {
                    parcel.writeString(type)
                    parcel.writeString(url)
                }

                override fun describeContents(): Int {
                    return 0
                }

                companion object CREATOR : Parcelable.Creator<Url> {
                    override fun createFromParcel(parcel: Parcel): Url {
                        return Url(parcel)
                    }

                    override fun newArray(size: Int): Array<Url?> {
                        return arrayOfNulls(size)
                    }
                }
            }

            override fun writeToParcel(parcel: Parcel, flags: Int) {
                parcel.writeParcelable(comics, flags)
                parcel.writeString(description)
                parcel.writeParcelable(events, flags)
                parcel.writeValue(id)
                parcel.writeString(modified)
                parcel.writeString(name)
                parcel.writeString(resourceURI)
                parcel.writeParcelable(series, flags)
                parcel.writeParcelable(stories, flags)
                parcel.writeParcelable(thumbnail, flags)
                parcel.writeTypedList(urls)
            }

            override fun describeContents(): Int {
                return 0
            }

            companion object CREATOR : Parcelable.Creator<Result> {
                override fun createFromParcel(parcel: Parcel): Result {
                    return Result(parcel)
                }

                override fun newArray(size: Int): Array<Result?> {
                    return arrayOfNulls(size)
                }
            }
        }
    }
}