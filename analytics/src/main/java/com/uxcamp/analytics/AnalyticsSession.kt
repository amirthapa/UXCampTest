package com.uxcamp.analytics

import android.content.Context
import androidx.annotation.RestrictTo
import androidx.room.Room
import com.uxcamp.analytics.data.AppDatabase
import com.uxcamp.analytics.data.ENVIRONMENT
import com.uxcamp.analytics.data.Event
import com.uxcamp.analytics.data.EventEntity
import com.uxcamp.analytics.data.UserInfo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
@RestrictTo(RestrictTo.Scope.LIBRARY)
class AnalyticsSession(private val context: Context) {


    private val startTime: Long = System.currentTimeMillis()
    private var endTime: Long? = null
    private val database: AppDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "analytics-database"
    ).build()

    fun addEvent(event: Event) {
        // Save data
        persistSessionData(event)
    }

    fun endSession() {
        endTime = System.currentTimeMillis()


    }

    private fun persistSessionData( event: Event) {
        if (UserInfo.environment == ENVIRONMENT.DEBUG) {
            println("Session started at: $startTime")
            println("Session ended at: $endTime")
            println("Events: $event")
        }


        // Save device info and event on room database
        CoroutineScope(Dispatchers.IO).launch {

                val eventEntity = EventEntity(
                    sessionId = startTime,
                    name = event.name,
                    deviceInfo = getDeviceInfo(),
                    properties = event.properties.toString()
                )
                database.eventDao().insert(eventEntity)
            }

    }

    private fun getDeviceInfo(): String {
        return "Model:" + UserInfo.deviceModel + "Os version:" + UserInfo.deviceOsVersion+"App Version:"+UserInfo.appVersion
    }
}
