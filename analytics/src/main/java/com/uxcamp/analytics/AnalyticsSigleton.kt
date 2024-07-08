package com.uxcamp.analytics

import android.content.Context
import com.uxcamp.analytics.data.Event

object AnalyticsSingleton {

    private  var currentSession: AnalyticsSession? = null


    fun startSession( context: Context) {
        currentSession = AnalyticsSession(context)
    }

    fun stopSession() {
        if(currentSession!=null){
            currentSession = null
        }

    }

    fun addEvent( event: Event) {
        if (currentSession!=null){
            currentSession?.addEvent(event)
        }

    }
}