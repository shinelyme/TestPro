package com.lsngo.myapplication.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/3/23.
 */

public class WeatherBean {

        /**
         * airCondition : 良
         * city : 杭州
         * coldIndex : 易发期
         * date : 2017-03-23
         * distrct : 杭州
         * dressingIndex : 夹衣类
         * exerciseIndex : 不适宜
         * future : [{"date":"2017-03-23","night":"小雨","temperature":"8°C","week":"今天","wind":"东北风 小于3级"},{"date":"2017-03-24","dayTime":"中雨","night":"小雨","temperature":"11°C / 8°C","week":"星期五","wind":"东北风 小于3级"},{"date":"2017-03-25","dayTime":"多云","night":"多云","temperature":"17°C / 8°C","week":"星期六","wind":"西北风 小于3级"},{"date":"2017-03-26","dayTime":"多云","night":"晴","temperature":"18°C / 7°C","week":"星期日","wind":"西北风 3～4级"},{"date":"2017-03-27","dayTime":"晴","night":"晴","temperature":"20°C / 8°C","week":"星期一","wind":"西北风 3～4级"},{"date":"2017-03-28","dayTime":"晴","night":"多云","temperature":"21°C / 11°C","week":"星期二","wind":"东南风 小于3级"},{"date":"2017-03-29","dayTime":"多云","night":"阵雨","temperature":"21°C / 10°C","week":"星期三","wind":"东北风 小于3级"},{"date":"2017-03-30","dayTime":"雨","night":"零散阵雨","temperature":"17°C / 9°C","week":"星期四","wind":"东北偏北风 2级"},{"date":"2017-03-31","dayTime":"多云","night":"阵雨","temperature":"17°C / 9°C","week":"星期五","wind":"东北风 2级"},{"date":"2017-04-01","dayTime":"零散阵雨","night":"局部多云","temperature":"19°C / 8°C","week":"星期六","wind":"东北偏北风 2级"}]
         * humidity : 湿度：94%
         * pollutionIndex : 70
         * province : 浙江
         * sunrise : 06:00
         * sunset : 18:12
         * temperature : 9℃
         * time : 22:22
         * updateTime : 20170323224020
         * washIndex : 不适宜
         * weather : 阴
         * week : 周四
         * wind : 东风2级
         */

        private String airCondition;
        private String city;
        private String coldIndex;
        private String date;
        private String distrct;
        private String dressingIndex;
        private String exerciseIndex;
        private String humidity;
        private String pollutionIndex;
        private String province;
        private String sunrise;
        private String sunset;
        private String temperature;
        private String time;
        private String updateTime;
        private String washIndex;
        private String weather;
        private String week;
        private String wind;
        private List<FutureBean> future;

        public String getAirCondition() {
            return airCondition;
        }

        public void setAirCondition(String airCondition) {
            this.airCondition = airCondition;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getColdIndex() {
            return coldIndex;
        }

        public void setColdIndex(String coldIndex) {
            this.coldIndex = coldIndex;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getDistrct() {
            return distrct;
        }

        public void setDistrct(String distrct) {
            this.distrct = distrct;
        }

        public String getDressingIndex() {
            return dressingIndex;
        }

        public void setDressingIndex(String dressingIndex) {
            this.dressingIndex = dressingIndex;
        }

        public String getExerciseIndex() {
            return exerciseIndex;
        }

        public void setExerciseIndex(String exerciseIndex) {
            this.exerciseIndex = exerciseIndex;
        }

        public String getHumidity() {
            return humidity;
        }

        public void setHumidity(String humidity) {
            this.humidity = humidity;
        }

        public String getPollutionIndex() {
            return pollutionIndex;
        }

        public void setPollutionIndex(String pollutionIndex) {
            this.pollutionIndex = pollutionIndex;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getSunrise() {
            return sunrise;
        }

        public void setSunrise(String sunrise) {
            this.sunrise = sunrise;
        }

        public String getSunset() {
            return sunset;
        }

        public void setSunset(String sunset) {
            this.sunset = sunset;
        }

        public String getTemperature() {
            return temperature;
        }

        public void setTemperature(String temperature) {
            this.temperature = temperature;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getWashIndex() {
            return washIndex;
        }

        public void setWashIndex(String washIndex) {
            this.washIndex = washIndex;
        }

        public String getWeather() {
            return weather;
        }

        public void setWeather(String weather) {
            this.weather = weather;
        }

        public String getWeek() {
            return week;
        }

        public void setWeek(String week) {
            this.week = week;
        }

        public String getWind() {
            return wind;
        }

        public void setWind(String wind) {
            this.wind = wind;
        }

        public List<FutureBean> getFuture() {
            return future;
        }

        public void setFuture(List<FutureBean> future) {
            this.future = future;
        }

    public WeatherBean(String airCondition, String city, String coldIndex, String date, String distrct, String dressingIndex, String exerciseIndex, String humidity, String pollutionIndex, String province, String sunrise, String sunset, String temperature, String time, String updateTime, String washIndex, String weather, String week, String wind, List<FutureBean> future) {
        this.airCondition = airCondition;
        this.city = city;
        this.coldIndex = coldIndex;
        this.date = date;
        this.distrct = distrct;
        this.dressingIndex = dressingIndex;
        this.exerciseIndex = exerciseIndex;
        this.humidity = humidity;
        this.pollutionIndex = pollutionIndex;
        this.province = province;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.temperature = temperature;
        this.time = time;
        this.updateTime = updateTime;
        this.washIndex = washIndex;
        this.weather = weather;
        this.week = week;
        this.wind = wind;
        this.future = future;
    }

    @Override
    public String toString() {
        return "WeatherBean{" +
                "airCondition='" + airCondition + '\'' +
                ", city='" + city + '\'' +
                ", coldIndex='" + coldIndex + '\'' +
                ", date='" + date + '\'' +
                ", distrct='" + distrct + '\'' +
                ", dressingIndex='" + dressingIndex + '\'' +
                ", exerciseIndex='" + exerciseIndex + '\'' +
                ", humidity='" + humidity + '\'' +
                ", pollutionIndex='" + pollutionIndex + '\'' +
                ", province='" + province + '\'' +
                ", sunrise='" + sunrise + '\'' +
                ", sunset='" + sunset + '\'' +
                ", temperature='" + temperature + '\'' +
                ", time='" + time + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", washIndex='" + washIndex + '\'' +
                ", weather='" + weather + '\'' +
                ", week='" + week + '\'' +
                ", wind='" + wind + '\'' +
                ", future=" + future +
                '}';
    }

    public WeatherBean() {
        super();
    }
}
