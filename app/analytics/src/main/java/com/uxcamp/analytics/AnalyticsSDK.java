package com.uxcamp.analytics;


import android.content.Context;
import android.os.Build;

import android.util.Log;

import com.uxcamp.analytics.data.ENVIRONMENT;
import com.uxcamp.analytics.data.Event;
import com.uxcamp.analytics.data.UserInfo;

public class AnalyticsSDK {

    private final String apiKey;
    private final String appVersion;
    private final Boolean chuckerEnabled;
    private final ENVIRONMENT environment;


    public static class Builder {

        private String apiKey;
        private Boolean chuckerEnabled;

        private String appVersion;
        private ENVIRONMENT environment;

        public Builder() {
        }

        public Builder appVersion(String appVersion) {
            this.appVersion = appVersion;
            return Builder.this;
        }


        public Builder apiKey(String apiKey) {
            this.apiKey = apiKey;
            return Builder.this;
        }

        public Builder chukkerEnable(boolean chukkerEnable) {
            this.chuckerEnabled = chukkerEnable;
            return Builder.this;
        }

        public Builder environment(ENVIRONMENT environment) {
            this.environment = environment;
            return Builder.this;
        }

        public AnalyticsSDK build() {

            if (this.apiKey == null) {
                throw new NullPointerException("The property \"Apikey\" is null. "
                        + "Please set the value by \"Apikey\". "
                        + "The property \"Apikey\" is required.");
            }
            if (this.appVersion == null) {
                throw new NullPointerException("The property \"appVersion\" is null. "
                        + "Please set the value by \"AppVersion\". "
                        + "The property \"AppVersion\" is required.");
            }

            if (this.chuckerEnabled == null) {
                throw new NullPointerException("The property \"chuckerEnabled\" is null. "
                        + "Please set the value by \"chuckerEnabled\". "
                        + "The property \"chuckerEnabled\" is required.");
            }
            if (this.environment == null) {
                throw new NullPointerException("The property \"environment\" is null. "
                        + "Please set the value by \"environment\". "
                        + "The property \"environment\" is required.");
            }


            return new AnalyticsSDK(this);
        }
    }







    public AnalyticsSDK(Builder builder) {
        this.apiKey = builder.apiKey;
        this.chuckerEnabled = builder.chuckerEnabled;
        this.environment = builder.environment;
        this.appVersion = builder.appVersion;

    }


    public void start(Context context) {
        //Set required info to Pref so that can be used on sdk
        UserInfo.INSTANCE.setApiKey(this.apiKey);
        UserInfo.INSTANCE.setChukkaEnable(chuckerEnabled);
        UserInfo.INSTANCE.setEnvironment(environment);
        UserInfo.INSTANCE.setAppVersion(appVersion);
        UserInfo.INSTANCE.setDeviceModel(Build.MODEL);
        UserInfo.INSTANCE.setDeviceOsVersion(Integer.parseInt(Build.VERSION.RELEASE));
        AnalyticsSingleton.INSTANCE.startSession(context);

    }


}

