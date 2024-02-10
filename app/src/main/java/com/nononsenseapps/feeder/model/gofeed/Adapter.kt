package com.nononsenseapps.feeder.model.gofeed

import com.nononsenseapps.feeder.sync.adapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.io.IOException

class Experiment {
    private val moshi =
        Moshi.Builder()
//        .add(InstantAdapter())
//        .add(URLAdapter())
            .addLast(KotlinJsonAdapterFactory())
            .build()

    private val goFeedAdapter = moshi.adapter<GoFeed>()

    @Throws(IOException::class)
    fun fromJson(json: ByteArray): GoFeed? {
        return goFeedAdapter.fromJson(json.decodeToString())
    }

    @Throws(IOException::class)
    fun parseBody(body: String): GoFeed? {
        return feedergofeed.Feedergofeed.parseBody(body)?.let {
            return fromJson(it)
        }
    }
}
