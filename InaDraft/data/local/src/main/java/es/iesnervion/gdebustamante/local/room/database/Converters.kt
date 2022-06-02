package es.iesnervion.gdebustamante.local.room.database

import android.annotation.SuppressLint
import androidx.room.TypeConverter
import java.time.LocalDate
import java.util.*

class Converters {

    @SuppressLint("NewApi")
    @TypeConverter
    fun fromTimestamp(value: Long?): LocalDate? {
        return value?.let { LocalDate.ofEpochDay(it) }
    }

    @SuppressLint("NewApi")
    @TypeConverter
    fun dateToTimestamp(date: LocalDate?): Long? {
        return date?.toEpochDay()?.toLong()
    }
}