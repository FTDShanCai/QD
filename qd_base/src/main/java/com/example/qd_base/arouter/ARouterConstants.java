package com.example.qd_base.arouter;

/**
 * @author ddc
 * 邮箱: 931952032@qq.com
 * <p>description: 路由常量
 */
public class ARouterConstants {

    public static class Module {
        public static class WanAndroid {
            //主页
            public static final String WAN_ANDROID_MAIN = "/WanAndroid/Main";
            //文章列表
            public static final String WAN_ANDROID_ARTICLELIST = "/WanAndroid/ArticleList";
            //结构数据
            public static final String WAN_ANDROID_SYSTEMDATA = "/WanAndroid/SystemData";
            //常用网站
            public static final String WAN_ANDROID_USUALLYNET = "/WanAndroid/UsuallyNet";
        }

        public static class Weahter {
            public static final String WEATHER_MAIN = "/Weather/Main";
        }

        public static final String BASE_WEB = "/base/web";
    }


    public static class Bundle {
        public static final String TITLE = "title";
        public static final String URL = "url";
    }
}
