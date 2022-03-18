package com.fady.marvelcomics.api.models


import com.google.gson.annotations.SerializedName


data class ComicsResponse(
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
            @SerializedName("characters")
            var characters: Characters?,
            @SerializedName("collectedIssues")
            var collectedIssues: List<Any?>?,
            @SerializedName("collections")
            var collections: List<Any?>?,
            @SerializedName("creators")
            var creators: Creators?,
            @SerializedName("dates")
            var dates: List<Date?>?,
            @SerializedName("description")
            var description: String?,
            @SerializedName("diamondCode")
            var diamondCode: String?,
            @SerializedName("digitalId")
            var digitalId: Int?,
            @SerializedName("ean")
            var ean: String?,
            @SerializedName("events")
            var events: Events?,
            @SerializedName("format")
            var format: String?,
            @SerializedName("id")
            var id: Int?,
            @SerializedName("images")
            var images: List<Image?>?,
            @SerializedName("isbn")
            var isbn: String?,
            @SerializedName("issn")
            var issn: String?,
            @SerializedName("issueNumber")
            var issueNumber: Int?,
            @SerializedName("modified")
            var modified: String?,
            @SerializedName("pageCount")
            var pageCount: Int?,
            @SerializedName("prices")
            var prices: List<Price?>?,
            @SerializedName("resourceURI")
            var resourceURI: String?,
            @SerializedName("series")
            var series: Series?,
            @SerializedName("stories")
            var stories: Stories?,
            @SerializedName("textObjects")
            var textObjects: List<TextObject?>?,
            @SerializedName("thumbnail")
            var thumbnail: Thumbnail?,
            @SerializedName("title")
            var title: String?,
            @SerializedName("upc")
            var upc: String?,
            @SerializedName("urls")
            var urls: List<Url?>?,
            @SerializedName("variantDescription")
            var variantDescription: String?,
            @SerializedName("variants")
            var variants: List<Any?>?
        ) {

            data class Characters(
                @SerializedName("available")
                var available: Int?,
                @SerializedName("collectionURI")
                var collectionURI: String?,
                @SerializedName("items")
                var items: List<Item?>?,
                @SerializedName("returned")
                var returned: Int?
            ) {

                data class Item(
                    @SerializedName("name")
                    var name: String?,
                    @SerializedName("resourceURI")
                    var resourceURI: String?
                )
            }


            data class Creators(
                @SerializedName("available")
                var available: Int?,
                @SerializedName("collectionURI")
                var collectionURI: String?,
                @SerializedName("items")
                var items: List<Item?>?,
                @SerializedName("returned")
                var returned: Int?
            ) {

                data class Item(
                    @SerializedName("name")
                    var name: String?,
                    @SerializedName("resourceURI")
                    var resourceURI: String?,
                    @SerializedName("role")
                    var role: String?
                )
            }


            data class Date(
                @SerializedName("date")
                var date: String?,
                @SerializedName("type")
                var type: String?
            )


            data class Events(
                @SerializedName("available")
                var available: Int?,
                @SerializedName("collectionURI")
                var collectionURI: String?,
                @SerializedName("items")
                var items: List<Any?>?,
                @SerializedName("returned")
                var returned: Int?
            )


            data class Image(
                @SerializedName("extension")
                var extension: String?,
                @SerializedName("path")
                var path: String?
            )


            data class Price(
                @SerializedName("price")
                var price: Double?,
                @SerializedName("type")
                var type: String?
            )


            data class Series(
                @SerializedName("name")
                var name: String?,
                @SerializedName("resourceURI")
                var resourceURI: String?
            )


            data class Stories(
                @SerializedName("available")
                var available: Int?,
                @SerializedName("collectionURI")
                var collectionURI: String?,
                @SerializedName("items")
                var items: List<Item?>?,
                @SerializedName("returned")
                var returned: Int?
            ) {

                data class Item(
                    @SerializedName("name")
                    var name: String?,
                    @SerializedName("resourceURI")
                    var resourceURI: String?,
                    @SerializedName("type")
                    var type: String?
                )
            }


            data class TextObject(
                @SerializedName("language")
                var language: String?,
                @SerializedName("text")
                var text: String?,
                @SerializedName("type")
                var type: String?
            )


            data class Thumbnail(
                @SerializedName("extension")
                var extension: String?,
                @SerializedName("path")
                var path: String?
            )


            data class Url(
                @SerializedName("type")
                var type: String?,
                @SerializedName("url")
                var url: String?
            )
        }
    }
}