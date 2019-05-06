package com.example.weather.entity;

import java.util.ArrayList;

/**
 * @author ddc
 * 邮箱: 931952032@qq.com
 * <p>description:
 */
public class WeatherResult {

    private String cityid;
    private String update_time;
    private String city;
    private String cityEn;
    private String country;
    private String countryEn;
    private ArrayList<Data> data;

    public String getCityid() {
        return cityid;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityEn() {
        return cityEn;
    }

    public void setCityEn(String cityEn) {
        this.cityEn = cityEn;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryEn() {
        return countryEn;
    }

    public void setCountryEn(String countryEn) {
        this.countryEn = countryEn;
    }

    public ArrayList<Data> getData() {
        return data;
    }

    public void setData(ArrayList<Data> data) {
        this.data = data;
    }

    public static class Data {
        private String day;
        private String date;
        private String week;
        private String wea;
        private String wea_img;
        private String air;
        private String humidfy;
        private String air_level;
        private String air_tips;
        private String tem1;
        private String tem2;
        private String tem;
        private String win_speed;

        private Alarm alarm;
        private ArrayList<Hours> hours;
        private ArrayList<Index> index;


        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getWeek() {
            return week;
        }

        public void setWeek(String week) {
            this.week = week;
        }

        public String getWea() {
            return wea;
        }

        public void setWea(String wea) {
            this.wea = wea;
        }

        public String getWea_img() {
            return wea_img;
        }

        public void setWea_img(String wea_img) {
            this.wea_img = wea_img;
        }

        public String getAir() {
            return air;
        }

        public void setAir(String air) {
            this.air = air;
        }

        public String getHumidfy() {
            return humidfy;
        }

        public void setHumidfy(String humidfy) {
            this.humidfy = humidfy;
        }

        public String getAir_level() {
            return air_level;
        }

        public void setAir_level(String air_level) {
            this.air_level = air_level;
        }

        public String getAir_tips() {
            return air_tips;
        }

        public void setAir_tips(String air_tips) {
            this.air_tips = air_tips;
        }

        public String getTem1() {
            return tem1;
        }

        public void setTem1(String tem1) {
            this.tem1 = tem1;
        }

        public String getTem2() {
            return tem2;
        }

        public void setTem2(String tem2) {
            this.tem2 = tem2;
        }

        public String getTem() {
            return tem;
        }

        public void setTem(String tem) {
            this.tem = tem;
        }

        public String getWin_speed() {
            return win_speed;
        }

        public void setWin_speed(String win_speed) {
            this.win_speed = win_speed;
        }

        public Alarm getAlarm() {
            return alarm;
        }

        public void setAlarm(Alarm alarm) {
            this.alarm = alarm;
        }

        public ArrayList<Hours> getHours() {
            return hours;
        }

        public void setHours(ArrayList<Hours> hours) {
            this.hours = hours;
        }

        public ArrayList<Index> getIndex() {
            return index;
        }

        public void setIndex(ArrayList<Index> index) {
            this.index = index;
        }

        public static class Alarm {
            private String alarm_type;
            private String alarm_level;
            private String alarm_content;

            public String getAlarm_type() {
                return alarm_type;
            }

            public void setAlarm_type(String alarm_type) {
                this.alarm_type = alarm_type;
            }

            public String getAlarm_level() {
                return alarm_level;
            }

            public void setAlarm_level(String alarm_level) {
                this.alarm_level = alarm_level;
            }

            public String getAlarm_content() {
                return alarm_content;
            }

            public void setAlarm_content(String alarm_content) {
                this.alarm_content = alarm_content;
            }
        }

        public static class Hours {
            private String day;
            private String wea;
            private String tem;
            private String win;
            private String win_speed;

            public String getDay() {
                return day;
            }

            public void setDay(String day) {
                this.day = day;
            }

            public String getWea() {
                return wea;
            }

            public void setWea(String wea) {
                this.wea = wea;
            }

            public String getTem() {
                return tem;
            }

            public void setTem(String tem) {
                this.tem = tem;
            }

            public String getWin() {
                return win;
            }

            public void setWin(String win) {
                this.win = win;
            }

            public String getWin_speed() {
                return win_speed;
            }

            public void setWin_speed(String win_speed) {
                this.win_speed = win_speed;
            }
        }

        public static class Index {
            private String title;
            private String level;
            private String desc;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getLevel() {
                return level;
            }

            public void setLevel(String level) {
                this.level = level;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }
        }
    }

}
