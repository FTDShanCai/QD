package com.app.wanandroid.bean;

import java.util.ArrayList;

/**
 * @author ddc
 * 邮箱: 931952032@qq.com
 * <p>description:
 */
public class ArticleResult {

    /**
     * curPage :1
     * offset : 20
     * over : false
     * pageCount : 322
     * size : 20
     * total : 6435
     */

    private String curPage;
    private String offset;
    private String over;
    private String pageCount;
    private String size;
    private String total;
    private ArrayList<Data> datas;

    public String getCurPage() {
        return curPage;
    }

    public void setCurPage(String curPage) {
        this.curPage = curPage;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getOver() {
        return over;
    }

    public void setOver(String over) {
        this.over = over;
    }

    public String getPageCount() {
        return pageCount;
    }

    public void setPageCount(String pageCount) {
        this.pageCount = pageCount;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public ArrayList<Data> getDatas() {
        return datas;
    }

    public void setDatas(ArrayList<Data> datas) {
        this.datas = datas;
    }

    public static class Data {

        /**
         * apkLink :
         * author : KeepClam
         * chapterId : 100
         * chapterName : RecyclerView
         * collect : false
         * courseId : 13
         * desc :
         * envelopePic :
         * fresh : false
         * id : 8345
         * link : https://blog.csdn.net/qq_34501274/article/details/89433711
         * niceDate : 2019-05-02
         * origin :
         * prefix :
         * projectLink :
         * publishTime : 1556784394000
         * superChapterId : 151
         * superChapterName : 5.+高新技术
         * tags : []
         * title : 我所了解的Recyclerview绘制流程
         * type : 0
         * userId : -1
         * visible : 1
         * zan : 0
         */

        private String apkLink;
        private String author;
        private String chapterId;
        private String chapterName;
        private String collect;
        private String courseId;
        private String desc;
        private String envelopePic;
        private String fresh;
        private String id;
        private String link;
        private String niceDate;
        private String origin;
        private String prefix;
        private String projectLink;
        private String publishTime;
        private String superChapterId;
        private String superChapterName;
        private String title;
        private String type;
        private String userId;
        private String visible;
        private String zan;
        private ArrayList<Tag> tags;


        public static class Tag {

            /**
             * name : 公众号
             * url : /wxarticle/list/414/1
             */

            private String name;
            private String url;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public String getApkLink() {
            return apkLink;
        }

        public void setApkLink(String apkLink) {
            this.apkLink = apkLink;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getChapterId() {
            return chapterId;
        }

        public void setChapterId(String chapterId) {
            this.chapterId = chapterId;
        }

        public String getChapterName() {
            return chapterName;
        }

        public void setChapterName(String chapterName) {
            this.chapterName = chapterName;
        }

        public String getCollect() {
            return collect;
        }

        public void setCollect(String collect) {
            this.collect = collect;
        }

        public String getCourseId() {
            return courseId;
        }

        public void setCourseId(String courseId) {
            this.courseId = courseId;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getEnvelopePic() {
            return envelopePic;
        }

        public void setEnvelopePic(String envelopePic) {
            this.envelopePic = envelopePic;
        }

        public String getFresh() {
            return fresh;
        }

        public void setFresh(String fresh) {
            this.fresh = fresh;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getNiceDate() {
            return niceDate;
        }

        public void setNiceDate(String niceDate) {
            this.niceDate = niceDate;
        }

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public String getPrefix() {
            return prefix;
        }

        public void setPrefix(String prefix) {
            this.prefix = prefix;
        }

        public String getProjectLink() {
            return projectLink;
        }

        public void setProjectLink(String projectLink) {
            this.projectLink = projectLink;
        }

        public String getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(String publishTime) {
            this.publishTime = publishTime;
        }

        public String getSuperChapterId() {
            return superChapterId;
        }

        public void setSuperChapterId(String superChapterId) {
            this.superChapterId = superChapterId;
        }

        public String getSuperChapterName() {
            return superChapterName;
        }

        public void setSuperChapterName(String superChapterName) {
            this.superChapterName = superChapterName;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getVisible() {
            return visible;
        }

        public void setVisible(String visible) {
            this.visible = visible;
        }

        public String getZan() {
            return zan;
        }

        public void setZan(String zan) {
            this.zan = zan;
        }

        public ArrayList<Tag> getTags() {
            return tags;
        }

        public void setTags(ArrayList<Tag> tags) {
            this.tags = tags;
        }
    }

}
