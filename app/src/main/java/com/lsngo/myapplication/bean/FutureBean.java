package com.lsngo.myapplication.bean;

/**
 * Created by Administrator on 2017/3/23.
 */

public class FutureBean {

        /**
         * date : 2017-03-23
         * night : 小雨
         * temperature : 8°C
         * week : 今天
         * wind : 东北风 小于3级
         * dayTime : 中雨
         */

        private String date;
        private String night;
        private String temperature;
        private String week;
        private String wind;
        private String dayTime;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getNight() {
            return night;
        }

        public void setNight(String night) {
            this.night = night;
        }

        public String getTemperature() {
            return temperature;
        }

        public void setTemperature(String temperature) {
            this.temperature = temperature;
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

        public String getDayTime() {
            return dayTime;
        }

        public void setDayTime(String dayTime) {
            this.dayTime = dayTime;
        }

    @Override
    public String toString() {
        return "FutureBean{" +
                "date='" + date + '\'' +
                ", night='" + night + '\'' +
                ", temperature='" + temperature + '\'' +
                ", week='" + week + '\'' +
                ", wind='" + wind + '\'' +
                ", dayTime='" + dayTime + '\'' +
                '}';
    }

    public FutureBean()   {
        super();
    }

    public FutureBean(String date, String night, String temperature, String week, String wind, String dayTime) {
        this.date = date;
        this.night = night;
        this.temperature = temperature;
        this.week = week;
        this.wind = wind;
        this.dayTime = dayTime;
    }
}
