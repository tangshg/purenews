package com.hhx.pureNews.modules.wangyinews.mvp;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hhx on 2017/8/18.
 */

public class WangyiNews {
    @Override
    public String toString() {
        return "WangyiNews{" +
                "bean=" + bean +
                '}';
    }

    @SerializedName(value = "T1348647909107", alternate = {"T1348649580692", "T1348648517839", "T1370583240249", "T1348649079062", "T1348654151579", "T1397016069906", "T1348649654285", "T1348649176279", "T1348649145984", "T1348649776727", "T1351233117091", "T1350383429665", "T1467284926140", "T1414389941036", "T1348648756099", "T1348654225495", "T1441074311424", "T1414142214384", "T1411113472760", "T1368497029546", "T1473054348939", "T1356600029035", "T1348649475931", "T1348649503389", "T1348654204705", "T1349837698345", "T1348654060988", "T1348648141035"})
    private List<Bean> bean;


    public void setBean(List<Bean> bean) {
        this.bean = bean;
    }


    public List<Bean> getBean() {
        return bean;
    }

    public static class Bean implements MultiItemEntity {


        public static final int BANNER = 0;
        public static final int ITEM = 1;
        private int multiItem;

        public Bean(int multiItem) {
            this.multiItem = multiItem;

        }

        @Override
        public int getItemType() {
            return multiItem;
        }

        public int getMultiItem() {
            return multiItem;
        }

        public void setMultiItem(int multiItem) {
            this.multiItem = multiItem;
        }

        /**
         * imgextra : [{"imgsrc":"http://cms-bucket.nosdn.127.net/c4a6e79100ab4aa596db7db2199b8e3720170904084220.jpeg"},{"imgsrc":"http://cms-bucket.nosdn.127.net/f91b447970e54a0a95d84818402980bf20170904084220.jpeg"}]
         * template : normal1
         * skipID : 00AO0001|2273674
         * lmodify : 2017-09-04 08:53:59
         * postid : PHOT25CCA000100A
         * source : 人民网
         * title : 山火熊熊 美国洛杉矶进入紧急状态
         * mtime : 2017-09-04 08:53:59
         * hasImg : 1
         * topic_background : http://img2.cache.netease.com/m/newsapp/reading/cover1/C1348646712614.jpg
         * digest :
         * photosetID : 00AO0001|2273674
         * boardid : photoview_bbs
         * alias : Top News
         * hasAD : 1
         * imgsrc : http://cms-bucket.nosdn.127.net/93c449e695194753acb406765dc0ee4520170904084219.jpeg
         * ptime : 2017-09-04 08:42:38
         * daynum : 17413
         * hasHead : 1
         * order : 1
         * votecount : 2155
         * hasCover : false
         * docid : 9IG74V5H00963VRO_CTFPQ2GEbjjikeupdateDoc
         * tname : 头条
         * priority : 354
         * ads : [{"subtitle":"","skipType":"photoset","skipID":"00AN0001|2273678","tag":"photoset","title":"台风\"玛娃\"登陆广东 渔船陆续回港避风","imgsrc":"http://cms-bucket.nosdn.127.net/361a0e57b3ca468d9cd4b89561b4cea620170904090631.jpeg","url":"00AN0001|2273678"},{"subtitle":"","skipType":"photoset","skipID":"00AP0001|2273676","tag":"photoset","title":"宠物狗看病被弄伤 主人向医院索赔万元","imgsrc":"http://cms-bucket.nosdn.127.net/4d0211795a6444aea210f3e319e253d120170904085131.jpeg","url":"00AP0001|2273676"},{"subtitle":"","skipType":"photoset","skipID":"00AN0001|2273669","tag":"photoset","title":"印度总理莫迪抵达厦门 出席金砖峰会","imgsrc":"http://cms-bucket.nosdn.127.net/cdb6ab88db354ca0b904c0369510218b20170904074452.jpeg","url":"00AN0001|2273669"},{"subtitle":"","skipType":"photoset","skipID":"00AO0001|2273671","tag":"photoset","title":"德国展示未引爆二战炸弹 6万民众疏散","imgsrc":"http://cms-bucket.nosdn.127.net/7d14bd0386f74c19aa48622c061a980620170904075616.jpeg","url":"00AO0001|2273671"},{"subtitle":"","skipType":"photoset","skipID":"00AP0001|2273666","tag":"photoset","title":"上海市民外滩楼顶泳池嬉戏享清凉","imgsrc":"http://cms-bucket.nosdn.127.net/5315cea1a5df42a08d84ecbec86c1f1420170904042629.jpeg","url":"00AP0001|2273666"}]
         * ename : androidnews
         * replyCount : 2425
         * imgsum : 7
         * hasIcon : false
         * skipType : photoset
         * cid : C1348646712614
         * url_3w : http://news.163.com/17/0903/18/CTE922JG000189FH.html
         * url : http://3g.163.com/news/17/0903/18/CTE922JG000189FH.html
         * ltitle : 习近平出席金砖国家工商论坛开幕式并发表主旨演讲
         * subtitle :
         * specialID : S1503751299789
         */

        private List<Specialextra> specialextra;
        private String template;
        private int read;

        public int getRead() {
            return read;
        }

        public void setRead(int read) {
            this.read = read;
        }

        public List<Specialextra> getSpecialextra() {
            return specialextra;
        }

        public void setSpecialextra(List<Specialextra> specialextra) {
            this.specialextra = specialextra;
        }

        private String skipID;
        private String lmodify;
        private String postid;
        private String source;
        private String title;
        private String mtime;
        private int hasImg;
        private String topic_background;
        private String digest;
        private String photosetID;
        private String boardid;
        private String alias;
        private int hasAD;
        private String imgsrc;
        private String ptime;
        private String daynum;
        private int hasHead;
        private int order;
        private int votecount;
        private boolean hasCover;
        private String docid;
        private String tname;
        private int priority;
        private String ename;
        private int replyCount;
        private int imgsum;
        private boolean hasIcon;
        private String skipType;
        private String cid;
        private String url_3w;
        private String url;
        private String ltitle;
        private String subtitle;
        private String specialID;
        private List<ImgextraBean> imgextra;
        @SerializedName("ads")
        private List<AdsBean> ads;

        public static class Specialextra implements Serializable {
            public String docid;

            public String getDocid() {
                return docid;
            }

            public void setDocid(String docid) {
                this.docid = docid;
            }
        }

        public String getTemplate() {
            return template;
        }

        public void setTemplate(String template) {
            this.template = template;
        }

        public String getSkipID() {
            return skipID;
        }

        public void setSkipID(String skipID) {
            this.skipID = skipID;
        }

        public String getLmodify() {
            return lmodify;
        }

        public void setLmodify(String lmodify) {
            this.lmodify = lmodify;
        }

        public String getPostid() {
            return postid;
        }

        public void setPostid(String postid) {
            this.postid = postid;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getMtime() {
            return mtime;
        }

        public void setMtime(String mtime) {
            this.mtime = mtime;
        }

        public int getHasImg() {
            return hasImg;
        }

        public void setHasImg(int hasImg) {
            this.hasImg = hasImg;
        }

        public String getTopic_background() {
            return topic_background;
        }

        public void setTopic_background(String topic_background) {
            this.topic_background = topic_background;
        }

        public String getDigest() {
            return digest;
        }

        public void setDigest(String digest) {
            this.digest = digest;
        }

        public String getPhotosetID() {
            return photosetID;
        }

        public void setPhotosetID(String photosetID) {
            this.photosetID = photosetID;
        }

        public String getBoardid() {
            return boardid;
        }

        public void setBoardid(String boardid) {
            this.boardid = boardid;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public int getHasAD() {
            return hasAD;
        }

        public void setHasAD(int hasAD) {
            this.hasAD = hasAD;
        }

        public String getImgsrc() {
            return imgsrc;
        }

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public String getDaynum() {
            return daynum;
        }

        public void setDaynum(String daynum) {
            this.daynum = daynum;
        }

        public int getHasHead() {
            return hasHead;
        }

        public void setHasHead(int hasHead) {
            this.hasHead = hasHead;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public int getVotecount() {
            return votecount;
        }

        public void setVotecount(int votecount) {
            this.votecount = votecount;
        }

        public boolean isHasCover() {
            return hasCover;
        }

        public void setHasCover(boolean hasCover) {
            this.hasCover = hasCover;
        }

        public String getDocid() {
            return docid;
        }

        public void setDocid(String docid) {
            this.docid = docid;
        }

        public String getTname() {
            return tname;
        }

        public void setTname(String tname) {
            this.tname = tname;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public String getEname() {
            return ename;
        }

        public void setEname(String ename) {
            this.ename = ename;
        }

        public int getReplyCount() {
            return replyCount;
        }

        public void setReplyCount(int replyCount) {
            this.replyCount = replyCount;
        }

        public int getImgsum() {
            return imgsum;
        }

        public void setImgsum(int imgsum) {
            this.imgsum = imgsum;
        }

        public boolean isHasIcon() {
            return hasIcon;
        }

        public void setHasIcon(boolean hasIcon) {
            this.hasIcon = hasIcon;
        }

        public String getSkipType() {
            return skipType;
        }

        public void setSkipType(String skipType) {
            this.skipType = skipType;
        }

        public String getCid() {
            return cid;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }

        public String getUrl_3w() {
            return url_3w;
        }

        public void setUrl_3w(String url_3w) {
            this.url_3w = url_3w;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getLtitle() {
            return ltitle;
        }

        public void setLtitle(String ltitle) {
            this.ltitle = ltitle;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public String getSpecialID() {
            return specialID;
        }

        public void setSpecialID(String specialID) {
            this.specialID = specialID;
        }

        public List<ImgextraBean> getImgextra() {
            return imgextra;
        }

        public void setImgextra(List<ImgextraBean> imgextra) {
            this.imgextra = imgextra;
        }

        public List<AdsBean> getAds() {
            return ads;
        }

        public void setAds(List<AdsBean> ads) {
            this.ads = ads;
        }

        @Override
        public String toString() {
            return "Bean{" +
                    "multiItem=" + multiItem +
                    ", template='" + template + '\'' +
                    ", skipID='" + skipID + '\'' +
                    ", lmodify='" + lmodify + '\'' +
                    ", postid='" + postid + '\'' +
                    ", source='" + source + '\'' +
                    ", title='" + title + '\'' +
                    ", mtime='" + mtime + '\'' +
                    ", hasImg=" + hasImg +
                    ", topic_background='" + topic_background + '\'' +
                    ", digest='" + digest + '\'' +
                    ", photosetID='" + photosetID + '\'' +
                    ", boardid='" + boardid + '\'' +
                    ", alias='" + alias + '\'' +
                    ", hasAD=" + hasAD +
                    ", imgsrc='" + imgsrc + '\'' +
                    ", ptime='" + ptime + '\'' +
                    ", daynum='" + daynum + '\'' +
                    ", hasHead=" + hasHead +
                    ", order=" + order +
                    ", votecount=" + votecount +
                    ", hasCover=" + hasCover +
                    ", docid='" + docid + '\'' +
                    ", tname='" + tname + '\'' +
                    ", priority=" + priority +
                    ", ename='" + ename + '\'' +
                    ", replyCount=" + replyCount +
                    ", imgsum=" + imgsum +
                    ", hasIcon=" + hasIcon +
                    ", skipType='" + skipType + '\'' +
                    ", cid='" + cid + '\'' +
                    ", url_3w='" + url_3w + '\'' +
                    ", url='" + url + '\'' +
                    ", ltitle='" + ltitle + '\'' +
                    ", subtitle='" + subtitle + '\'' +
                    ", specialID='" + specialID + '\'' +
                    ", imgextra=" + imgextra +
                    ", ads=" + ads +
                    '}';
        }

        public static class ImgextraBean {
            /**
             * imgsrc : http://cms-bucket.nosdn.127.net/c4a6e79100ab4aa596db7db2199b8e3720170904084220.jpeg
             */

            private String imgsrc;

            public String getImgsrc() {
                return imgsrc;
            }

            public void setImgsrc(String imgsrc) {
                this.imgsrc = imgsrc;
            }
        }

        public static class AdsBean {
            @Override
            public String toString() {
                return "AdsBean{" +
                        "subtitle='" + subtitle + '\'' +
                        ", skipType='" + skipType + '\'' +
                        ", skipID='" + skipID + '\'' +
                        ", tag='" + tag + '\'' +
                        ", title='" + title + '\'' +
                        ", imgsrc='" + imgsrc + '\'' +
                        ", url='" + url + '\'' +
                        '}';
            }

            /**
             * subtitle :
             * skipType : photoset
             * skipID : 00AN0001|2273678
             * tag : photoset
             * title : 台风"玛娃"登陆广东 渔船陆续回港避风
             * imgsrc : http://cms-bucket.nosdn.127.net/361a0e57b3ca468d9cd4b89561b4cea620170904090631.jpeg
             * url : 00AN0001|2273678
             */


            private String subtitle;
            private String skipType;
            private String skipID;
            private String tag;
            private String title;
            private String imgsrc;
            private String url;

            public String getSubtitle() {
                return subtitle;
            }

            public void setSubtitle(String subtitle) {
                this.subtitle = subtitle;
            }

            public String getSkipType() {
                return skipType;
            }

            public void setSkipType(String skipType) {
                this.skipType = skipType;
            }

            public String getSkipID() {
                return skipID;
            }

            public void setSkipID(String skipID) {
                this.skipID = skipID;
            }

            public String getTag() {
                return tag;
            }

            public void setTag(String tag) {
                this.tag = tag;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImgsrc() {
                return imgsrc;
            }

            public void setImgsrc(String imgsrc) {
                this.imgsrc = imgsrc;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
