package com.uxcamp.analytics.data

import androidx.annotation.RestrictTo
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase

@RestrictTo(RestrictTo.Scope.LIBRARY)
@Entity
    data class EventEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val sessionId: Long,
    val name: String,
    val deviceInfo:String,
    val properties: String

    )

    @Dao
    interface EventDao {
        @Insert
        fun insert(event: EventEntity)

        @Query("SELECT * FROM EventEntity WHERE name = :eventName")
        fun getEventsByName(eventName: String): List<EventEntity>
    }

    @Database(entities = [EventEntity::class], version = 1)
    abstract class AppDatabase : RoomDatabase() {
        abstract fun eventDao(): EventDao
    }

