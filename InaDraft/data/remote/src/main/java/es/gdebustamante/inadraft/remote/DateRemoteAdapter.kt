package es.gdebustamante.inadraft.remote

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

internal class DateRemoteAdapter {

    private val df = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

    @ToJson
    fun toJson(value: Date): String {
        return df.format(value)
    }

    @FromJson
    fun fromJson(source: String): Date {
        return df.parse(source)
    }
}