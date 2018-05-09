package com.lsngo.myapplication.bean;

/**
 * Created by Administrator on 2017/3/23.
 */

public class WebBean {
        /**
         * date : 1489543138
         * title : 雪地精灵---------紫貂！
         * pic_url : http://bbs.qn.img-space.com/g2/M00/01/22/Cg-4k1jF6VOICz-mAAQ0YZIl0zoAABxVAHiw0sABDR5542.jpg?imageView2/2/w/200/q/90/ignore-error/1/961/176/38435127_200.jpg
         * detail_url : http://api.fengniao.com/app_ipad/pic_bbs_detail.php?id=9546083&fid=16
         * web_url : http://bbs.fengniao.com/forum/9546083.html
         */

        private String date;
        private String title;
        private String pic_url;
        private String detail_url;
        private String web_url;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPic_url() {
            return pic_url;
        }

        public void setPic_url(String pic_url) {
            this.pic_url = pic_url;
        }

        public String getDetail_url() {
            return detail_url;
        }

        public void setDetail_url(String detail_url) {
            this.detail_url = detail_url;
        }

        public String getWeb_url() {
            return web_url;
        }

        public void setWeb_url(String web_url) {
            this.web_url = web_url;
        }

    public WebBean(String date, String title, String pic_url, String detail_url, String web_url) {
        this.date = date;
        this.title = title;
        this.pic_url = pic_url;
        this.detail_url = detail_url;
        this.web_url = web_url;
    }

    @Override
    public String toString() {
        return "WebBean{" +
                "date='" + date + '\'' +
                ", title='" + title + '\'' +
                ", pic_url='" + pic_url + '\'' +
                ", detail_url='" + detail_url + '\'' +
                ", web_url='" + web_url + '\'' +
                '}';
    }

    public WebBean() {
        super();
    }
}
