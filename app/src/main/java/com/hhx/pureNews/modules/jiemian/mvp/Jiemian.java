package com.hhx.pureNews.modules.jiemian.mvp;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hhx on 17-9-24.
 */

public class Jiemian implements Serializable {

    @Override
    public String toString() {
        return "Jiemian{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", result=" + result +
                '}';
    }

    /**
     * code : 0
     * message : suss
     * result : {"page":"1","pageCount":"91","lastTime":"0","carousel":[{"special":{"id":"387","tl":"孙宏斌首次召开\u201c新乐视\u201d管理层闭门会：全面转型大屏生态","image":"https://img1.jiemian.com/101/original/20170818/150303669881537300_a750x422.jpg","type_name":"专题"},"type":"special"},{"article":{"ar_id":"1642909","ar_tl":"【特写】回不去的HTC","ar_image":"https://img1.jiemian.com/101/original/20170922/150605585186153100_a750x422.jpg"},"type":"article"},{"article":{"ar_id":"1641546","ar_tl":"阿里首个\u201c新零售\u201d项目家居馆今天开业  我们去现场抢鲜体验了","ar_image":"https://img2.jiemian.com/101/original/20170922/150601189531178100_a750x422.jpg"},"type":"article"},{"article":{"ar_id":"1640811","ar_tl":"暴风TV两天内获8亿投资意向 冯鑫铁了心要让亏损最大的子业务独立","ar_image":"https://img3.jiemian.com/101/original/20170921/150598762347656000_a750x422.jpg"},"type":"article"}],"icon":[],"list":[{"article":{"ar_id":"1646071","ar_tl":"阿里巴巴PK亚马逊 杭州与西雅图决战在即","ar_sum":"奔向5000亿美元市值的赛道上，阿里巴巴超越亚马逊的历史性一刻，或许很快就要到来。","ar_pt":"1506231966","ar_cmt":"0","ar_hit":"","ar_surl":"http://m.jiemian.com/article/1646071.html","ar_an":"中国经营报 ","ar_cate":"科技","ar_image":"https://img3.jiemian.com/101/original/20170924/150622937223653700_a280x210.jpg","ar_i_type":"article"},"i_show_tpl":"show_img_right","type":"article","count":{"comment":"0","hit":""}},{"article":{"ar_id":"1645746","ar_tl":"腾讯主要创办人张志东：谈谈互联网产品的老化","ar_sum":"张志东提出了一个让这些已经有所成就的创业者们产生了\u201c焦虑共鸣\u201d的问题：互联网产品获得成功之后，容易老化。产品如何避免老化？怎样的人和文化，才能让一个企业对抗老化？","ar_pt":"1506214476","ar_cmt":"7","ar_hit":"39.7w","ar_surl":"http://m.jiemian.com/article/1645746.html","ar_an":"腾讯学院","ar_cate":"科技","ar_image":"https://img2.jiemian.com/101/original/20170924/150622537398451400_a280x210.jpg","ar_i_type":"article"},"i_show_tpl":"show_img_right","type":"article","count":{"comment":"7","hit":"39.7w"}},{"article":{"ar_id":"1645694","ar_tl":"【科技早报】饿了么无人机首次亮相 小米校招事件涉事员工承认言辞不当","ar_sum":"饿了么无人机首次亮相，最高飞行速度达65千米/小时；小米校招事件涉事员工承认言辞不当，称已当面道歉；打击盗版，荷兰法院下令屏蔽海盗湾；国家新闻出版广电总局与省政府签署备忘录，发展广东4K产业；中国电信iPhone 8合约套餐公布：5888元起不限流量；Uber不服营业执照被吊销，在伦敦发起请愿活动。","ar_pt":"1506211192","ar_cmt":"20","ar_hit":"50w","ar_surl":"http://m.jiemian.com/article/1645694.html","ar_an":"陈俊杰","ar_cate":"科技","ar_image":"https://img2.jiemian.com/101/original/20170924/150620807946597700_a280x210.jpg","ar_i_type":"article"},"i_show_tpl":"show_img_right","type":"article","count":{"comment":"20","hit":"50w"}},{"article":{"ar_id":"1645718","ar_tl":"这些\u201c表情包\u201d不能发 已有人被索赔40万","ar_sum":"今天，你开启社交软件\u201c一言不合就斗图\u201d模式了吗？","ar_pt":"1506210000","ar_cmt":"24","ar_hit":"67.3w","ar_surl":"http://m.jiemian.com/article/1645718.html","ar_an":"央视财经","ar_cate":"科技","ar_image":"https://img2.jiemian.com/101/original/20170924/150620980469951200_a280x210.jpg","ar_i_type":"article"},"i_show_tpl":"show_img_right","type":"article","count":{"comment":"24","hit":"67.3w"}},{"article":{"ar_id":"1645393","ar_tl":"美团\u201c狙击\u201d二维火 餐饮新兴巨头大战进行时","ar_sum":"两个月前，他说要收割战场，两个月后，他面临被收割。","ar_pt":"1506169800","ar_cmt":"14","ar_hit":"93.2w","ar_surl":"http://m.jiemian.com/article/1645393.html","ar_an":"钛媒体","ar_cate":"科技","ar_image":"https://img3.jiemian.com/101/original/20170923/15061699305686200_a280x210.jpg","ar_i_type":"article"},"i_show_tpl":"show_img_right","type":"article","count":{"comment":"14","hit":"93.2w"}},{"article":{"ar_id":"1645317","ar_tl":"谷歌收购HTC手机业务背后：Nexus之死与Pixel之生","ar_sum":"不过 Pixel 系列手机还将会继续存在，不仅因为这回 Google 从 HTC 手里接过了部分手机业务，还因为 Pixel 有了更重要的使命。","ar_pt":"1506167829","ar_cmt":"5","ar_hit":"83w","ar_surl":"http://m.jiemian.com/article/1645317.html","ar_an":"钛媒体","ar_cate":"科技","ar_image":"https://img2.jiemian.com/101/original/20170923/150616195548559300_a280x210.jpg","ar_i_type":"article"},"i_show_tpl":"show_img_right","type":"article","count":{"comment":"5","hit":"83w"}},{"article":{"ar_id":"1645167","ar_tl":"遭股东起诉 扎克伯格放弃发行无投票权新股","ar_sum":"由于遭到股东起诉，Facebook首席执行官马克-扎克伯格（Mark Zuckerberg）放弃了发行无投票权C类股票的计划。","ar_pt":"1506153176","ar_cmt":"4","ar_hit":"93.9w","ar_surl":"http://m.jiemian.com/article/1645167.html","ar_an":"腾讯科技 ","ar_cate":"科技","ar_image":"https://img3.jiemian.com/101/original/20170923/150615317024423200_a280x210.jpg","ar_i_type":"article"},"i_show_tpl":"show_img_right","type":"article","count":{"comment":"4","hit":"93.9w"}},{"article":{"ar_id":"1644732","ar_tl":"【财富中文网】专访库克：苹果为改变世界而生","ar_sum":"当被要求解释苹果如何改变世界的时候，库克做出了乔布斯式的回答：\u201c我们的产品\u201d。","ar_pt":"1506150129","ar_cmt":"24","ar_hit":"96.9w","ar_surl":"http://m.jiemian.com/article/1644732.html","ar_an":"财富中文网","ar_cate":"科技","ar_image":"https://img1.jiemian.com/101/original/20170923/150613355513193800_a280x210.jpg","ar_i_type":"article"},"i_show_tpl":"show_img_right","type":"article","count":{"comment":"24","hit":"96.9w"}},{"article":{"ar_id":"1645108","ar_tl":"中国联通独董闭门会首次发声：联通混改背后的真实意图是什么？","ar_sum":"混改将会给联通带来怎样的改变？联通引入的投资者多数与通讯有关，互相业务交叉，股权关系复杂，混改之后会形成怎样的关联交易？如何看待联通以及未来其他混改中的透明度和公平性问题？","ar_pt":"1506150013","ar_cmt":"0","ar_hit":"85.1w","ar_surl":"http://m.jiemian.com/article/1645108.html","ar_an":"经济观察网","ar_cate":"科技","ar_image":"https://img1.jiemian.com/101/original/20170923/150614998266970300_a280x210.jpg","ar_i_type":"article"},"i_show_tpl":"show_img_right","type":"article","count":{"comment":"0","hit":"85.1w"}},{"article":{"ar_id":"1644555","ar_tl":"iOS11更新2天，刷榜游戏集体跑路","ar_sum":"游戏并不怕制作不够精良，显得粗糙、显得丑；怕就怕不仅丑，而且还丑得没特色。","ar_pt":"1506140100","ar_cmt":"6","ar_hit":"80.9w","ar_surl":"http://m.jiemian.com/article/1644555.html","ar_an":"GameLook","ar_cate":"科技","ar_image":"https://img2.jiemian.com/101/original/20170923/150612690432541700_a280x210.jpg","ar_i_type":"article"},"i_show_tpl":"show_img_right","type":"article","count":{"comment":"6","hit":"80.9w"}},{"article":{"ar_id":"1644941","ar_tl":"扎克伯格欲出售18%Facebook股票","ar_sum":"扎克伯格要出售公司股票投入慈善事业，但同时又不想失去绝对控制权。","ar_pt":"1506138770","ar_cmt":"18","ar_hit":"86w","ar_surl":"http://m.jiemian.com/article/1644941.html","ar_an":"郑超前","ar_cate":"科技","ar_image":"https://img1.jiemian.com/101/original/20170923/15061378765394600_a280x210.jpg","ar_i_type":"article"},"i_show_tpl":"show_img_right","type":"article","count":{"comment":"18","hit":"86w"}}]}
     */

    private String code;
    private String message;
    private ResultBean result;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean implements Serializable {
        @Override
        public String toString() {
            return "ResultBean{" +
                    "page='" + page + '\'' +
                    ", pageCount='" + pageCount + '\'' +
                    ", lastTime='" + lastTime + '\'' +
                    ", carousel=" + carousel +
                    ", icon=" + icon +
                    ", list=" + list +
                    '}';
        }

        /**
         * page : 1
         * pageCount : 91
         * lastTime : 0
         * carousel : [{"special":{"id":"387","tl":"孙宏斌首次召开\u201c新乐视\u201d管理层闭门会：全面转型大屏生态","image":"https://img1.jiemian.com/101/original/20170818/150303669881537300_a750x422.jpg","type_name":"专题"},"type":"special"},{"article":{"ar_id":"1642909","ar_tl":"【特写】回不去的HTC","ar_image":"https://img1.jiemian.com/101/original/20170922/150605585186153100_a750x422.jpg"},"type":"article"},{"article":{"ar_id":"1641546","ar_tl":"阿里首个\u201c新零售\u201d项目家居馆今天开业  我们去现场抢鲜体验了","ar_image":"https://img2.jiemian.com/101/original/20170922/150601189531178100_a750x422.jpg"},"type":"article"},{"article":{"ar_id":"1640811","ar_tl":"暴风TV两天内获8亿投资意向 冯鑫铁了心要让亏损最大的子业务独立","ar_image":"https://img3.jiemian.com/101/original/20170921/150598762347656000_a750x422.jpg"},"type":"article"}]
         * icon : []
         * list : [{"article":{"ar_id":"1646071","ar_tl":"阿里巴巴PK亚马逊 杭州与西雅图决战在即","ar_sum":"奔向5000亿美元市值的赛道上，阿里巴巴超越亚马逊的历史性一刻，或许很快就要到来。","ar_pt":"1506231966","ar_cmt":"0","ar_hit":"","ar_surl":"http://m.jiemian.com/article/1646071.html","ar_an":"中国经营报 ","ar_cate":"科技","ar_image":"https://img3.jiemian.com/101/original/20170924/150622937223653700_a280x210.jpg","ar_i_type":"article"},"i_show_tpl":"show_img_right","type":"article","count":{"comment":"0","hit":""}},{"article":{"ar_id":"1645746","ar_tl":"腾讯主要创办人张志东：谈谈互联网产品的老化","ar_sum":"张志东提出了一个让这些已经有所成就的创业者们产生了\u201c焦虑共鸣\u201d的问题：互联网产品获得成功之后，容易老化。产品如何避免老化？怎样的人和文化，才能让一个企业对抗老化？","ar_pt":"1506214476","ar_cmt":"7","ar_hit":"39.7w","ar_surl":"http://m.jiemian.com/article/1645746.html","ar_an":"腾讯学院","ar_cate":"科技","ar_image":"https://img2.jiemian.com/101/original/20170924/150622537398451400_a280x210.jpg","ar_i_type":"article"},"i_show_tpl":"show_img_right","type":"article","count":{"comment":"7","hit":"39.7w"}},{"article":{"ar_id":"1645694","ar_tl":"【科技早报】饿了么无人机首次亮相 小米校招事件涉事员工承认言辞不当","ar_sum":"饿了么无人机首次亮相，最高飞行速度达65千米/小时；小米校招事件涉事员工承认言辞不当，称已当面道歉；打击盗版，荷兰法院下令屏蔽海盗湾；国家新闻出版广电总局与省政府签署备忘录，发展广东4K产业；中国电信iPhone 8合约套餐公布：5888元起不限流量；Uber不服营业执照被吊销，在伦敦发起请愿活动。","ar_pt":"1506211192","ar_cmt":"20","ar_hit":"50w","ar_surl":"http://m.jiemian.com/article/1645694.html","ar_an":"陈俊杰","ar_cate":"科技","ar_image":"https://img2.jiemian.com/101/original/20170924/150620807946597700_a280x210.jpg","ar_i_type":"article"},"i_show_tpl":"show_img_right","type":"article","count":{"comment":"20","hit":"50w"}},{"article":{"ar_id":"1645718","ar_tl":"这些\u201c表情包\u201d不能发 已有人被索赔40万","ar_sum":"今天，你开启社交软件\u201c一言不合就斗图\u201d模式了吗？","ar_pt":"1506210000","ar_cmt":"24","ar_hit":"67.3w","ar_surl":"http://m.jiemian.com/article/1645718.html","ar_an":"央视财经","ar_cate":"科技","ar_image":"https://img2.jiemian.com/101/original/20170924/150620980469951200_a280x210.jpg","ar_i_type":"article"},"i_show_tpl":"show_img_right","type":"article","count":{"comment":"24","hit":"67.3w"}},{"article":{"ar_id":"1645393","ar_tl":"美团\u201c狙击\u201d二维火 餐饮新兴巨头大战进行时","ar_sum":"两个月前，他说要收割战场，两个月后，他面临被收割。","ar_pt":"1506169800","ar_cmt":"14","ar_hit":"93.2w","ar_surl":"http://m.jiemian.com/article/1645393.html","ar_an":"钛媒体","ar_cate":"科技","ar_image":"https://img3.jiemian.com/101/original/20170923/15061699305686200_a280x210.jpg","ar_i_type":"article"},"i_show_tpl":"show_img_right","type":"article","count":{"comment":"14","hit":"93.2w"}},{"article":{"ar_id":"1645317","ar_tl":"谷歌收购HTC手机业务背后：Nexus之死与Pixel之生","ar_sum":"不过 Pixel 系列手机还将会继续存在，不仅因为这回 Google 从 HTC 手里接过了部分手机业务，还因为 Pixel 有了更重要的使命。","ar_pt":"1506167829","ar_cmt":"5","ar_hit":"83w","ar_surl":"http://m.jiemian.com/article/1645317.html","ar_an":"钛媒体","ar_cate":"科技","ar_image":"https://img2.jiemian.com/101/original/20170923/150616195548559300_a280x210.jpg","ar_i_type":"article"},"i_show_tpl":"show_img_right","type":"article","count":{"comment":"5","hit":"83w"}},{"article":{"ar_id":"1645167","ar_tl":"遭股东起诉 扎克伯格放弃发行无投票权新股","ar_sum":"由于遭到股东起诉，Facebook首席执行官马克-扎克伯格（Mark Zuckerberg）放弃了发行无投票权C类股票的计划。","ar_pt":"1506153176","ar_cmt":"4","ar_hit":"93.9w","ar_surl":"http://m.jiemian.com/article/1645167.html","ar_an":"腾讯科技 ","ar_cate":"科技","ar_image":"https://img3.jiemian.com/101/original/20170923/150615317024423200_a280x210.jpg","ar_i_type":"article"},"i_show_tpl":"show_img_right","type":"article","count":{"comment":"4","hit":"93.9w"}},{"article":{"ar_id":"1644732","ar_tl":"【财富中文网】专访库克：苹果为改变世界而生","ar_sum":"当被要求解释苹果如何改变世界的时候，库克做出了乔布斯式的回答：\u201c我们的产品\u201d。","ar_pt":"1506150129","ar_cmt":"24","ar_hit":"96.9w","ar_surl":"http://m.jiemian.com/article/1644732.html","ar_an":"财富中文网","ar_cate":"科技","ar_image":"https://img1.jiemian.com/101/original/20170923/150613355513193800_a280x210.jpg","ar_i_type":"article"},"i_show_tpl":"show_img_right","type":"article","count":{"comment":"24","hit":"96.9w"}},{"article":{"ar_id":"1645108","ar_tl":"中国联通独董闭门会首次发声：联通混改背后的真实意图是什么？","ar_sum":"混改将会给联通带来怎样的改变？联通引入的投资者多数与通讯有关，互相业务交叉，股权关系复杂，混改之后会形成怎样的关联交易？如何看待联通以及未来其他混改中的透明度和公平性问题？","ar_pt":"1506150013","ar_cmt":"0","ar_hit":"85.1w","ar_surl":"http://m.jiemian.com/article/1645108.html","ar_an":"经济观察网","ar_cate":"科技","ar_image":"https://img1.jiemian.com/101/original/20170923/150614998266970300_a280x210.jpg","ar_i_type":"article"},"i_show_tpl":"show_img_right","type":"article","count":{"comment":"0","hit":"85.1w"}},{"article":{"ar_id":"1644555","ar_tl":"iOS11更新2天，刷榜游戏集体跑路","ar_sum":"游戏并不怕制作不够精良，显得粗糙、显得丑；怕就怕不仅丑，而且还丑得没特色。","ar_pt":"1506140100","ar_cmt":"6","ar_hit":"80.9w","ar_surl":"http://m.jiemian.com/article/1644555.html","ar_an":"GameLook","ar_cate":"科技","ar_image":"https://img2.jiemian.com/101/original/20170923/150612690432541700_a280x210.jpg","ar_i_type":"article"},"i_show_tpl":"show_img_right","type":"article","count":{"comment":"6","hit":"80.9w"}},{"article":{"ar_id":"1644941","ar_tl":"扎克伯格欲出售18%Facebook股票","ar_sum":"扎克伯格要出售公司股票投入慈善事业，但同时又不想失去绝对控制权。","ar_pt":"1506138770","ar_cmt":"18","ar_hit":"86w","ar_surl":"http://m.jiemian.com/article/1644941.html","ar_an":"郑超前","ar_cate":"科技","ar_image":"https://img1.jiemian.com/101/original/20170923/15061378765394600_a280x210.jpg","ar_i_type":"article"},"i_show_tpl":"show_img_right","type":"article","count":{"comment":"18","hit":"86w"}}]
         */


        private String page;
        private String pageCount;
        private String lastTime;
        private List<CarouselBean> carousel;
        private List<?> icon;
        private List<ListBean> list;

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public String getPageCount() {
            return pageCount;
        }

        public void setPageCount(String pageCount) {
            this.pageCount = pageCount;
        }

        public String getLastTime() {
            return lastTime;
        }

        public void setLastTime(String lastTime) {
            this.lastTime = lastTime;
        }

        public List<CarouselBean> getCarousel() {
            return carousel;
        }

        public void setCarousel(List<CarouselBean> carousel) {
            this.carousel = carousel;
        }

        public List<?> getIcon() {
            return icon;
        }

        public void setIcon(List<?> icon) {
            this.icon = icon;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class CarouselBean implements Serializable {

            @Override
            public String toString() {
                return "CarouselBean{" +
                        "special=" + special +
                        ", type='" + type + '\'' +
                        ", article=" + article +
                        '}';
            }

            /**
             * special : {"id":"387","tl":"孙宏斌首次召开\u201c新乐视\u201d管理层闭门会：全面转型大屏生态","image":"https://img1.jiemian.com/101/original/20170818/150303669881537300_a750x422.jpg","type_name":"专题"}
             * type : special
             * article : {"ar_id":"1642909","ar_tl":"【特写】回不去的HTC","ar_image":"https://img1.jiemian.com/101/original/20170922/150605585186153100_a750x422.jpg"}
             */

            private SpecialBean special;
            private String type;
            private ArticleBean article;

            public SpecialBean getSpecial() {
                return special;
            }

            public void setSpecial(SpecialBean special) {
                this.special = special;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public ArticleBean getArticle() {
                return article;
            }

            public void setArticle(ArticleBean article) {
                this.article = article;
            }

            public static class SpecialBean implements Serializable {
                @Override
                public String toString() {
                    return "SpecialBean{" +
                            "id='" + id + '\'' +
                            ", tl='" + tl + '\'' +
                            ", image='" + image + '\'' +
                            ", type_name='" + type_name + '\'' +
                            '}';
                }

                /**
                 * id : 387
                 * tl : 孙宏斌首次召开“新乐视”管理层闭门会：全面转型大屏生态
                 * image : https://img1.jiemian.com/101/original/20170818/150303669881537300_a750x422.jpg
                 * type_name : 专题
                 */

                private String id;
                private String tl;
                private String image;
                private String type_name;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getTl() {
                    return tl;
                }

                public void setTl(String tl) {
                    this.tl = tl;
                }

                public String getImage() {
                    return image;
                }

                public void setImage(String image) {
                    this.image = image;
                }

                public String getType_name() {
                    return type_name;
                }

                public void setType_name(String type_name) {
                    this.type_name = type_name;
                }
            }

            public static class ArticleBean implements Serializable {
                /**
                 * ar_id : 1642909
                 * ar_tl : 【特写】回不去的HTC
                 * ar_image : https://img1.jiemian.com/101/original/20170922/150605585186153100_a750x422.jpg
                 */

                private String ar_id;
                private String ar_tl;
                private String ar_image;

                public String getAr_id() {
                    return ar_id;
                }

                public void setAr_id(String ar_id) {
                    this.ar_id = ar_id;
                }

                public String getAr_tl() {
                    return ar_tl;
                }

                public void setAr_tl(String ar_tl) {
                    this.ar_tl = ar_tl;
                }

                public String getAr_image() {
                    return ar_image;
                }

                public void setAr_image(String ar_image) {
                    this.ar_image = ar_image;
                }
            }
        }

        public static class ListBean implements Serializable {
            /**
             * article : {"ar_id":"1646071","ar_tl":"阿里巴巴PK亚马逊 杭州与西雅图决战在即","ar_sum":"奔向5000亿美元市值的赛道上，阿里巴巴超越亚马逊的历史性一刻，或许很快就要到来。","ar_pt":"1506231966","ar_cmt":"0","ar_hit":"","ar_surl":"http://m.jiemian.com/article/1646071.html","ar_an":"中国经营报 ","ar_cate":"科技","ar_image":"https://img3.jiemian.com/101/original/20170924/150622937223653700_a280x210.jpg","ar_i_type":"article"}
             * i_show_tpl : show_img_right
             * type : article
             * count : {"comment":"0","hit":""}
             */
            @SerializedName(value = "article")
            private ArticleBean article;
            private String i_show_tpl;
            private String type;
            private CountBean count;

            public ArticleBean getArticle() {
                return article;
            }

            public void setArticle(ArticleBean article) {
                this.article = article;
            }

            public String getI_show_tpl() {
                return i_show_tpl;
            }

            public void setI_show_tpl(String i_show_tpl) {
                this.i_show_tpl = i_show_tpl;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public CountBean getCount() {
                return count;
            }

            public void setCount(CountBean count) {
                this.count = count;
            }

            public static class ArticleBean implements Serializable {
                /**
                 * ar_id : 1646071
                 * ar_tl : 阿里巴巴PK亚马逊 杭州与西雅图决战在即
                 * ar_sum : 奔向5000亿美元市值的赛道上，阿里巴巴超越亚马逊的历史性一刻，或许很快就要到来。
                 * ar_pt : 1506231966
                 * ar_cmt : 0
                 * ar_hit :
                 * ar_surl : http://m.jiemian.com/article/1646071.html
                 * ar_an : 中国经营报
                 * ar_cate : 科技
                 * ar_image : https://img3.jiemian.com/101/original/20170924/150622937223653700_a280x210.jpg
                 * ar_i_type : article
                 */
                @SerializedName(value = "ar_id")
                private String ar_id;
                private String ar_tl;
                private String ar_sum;
                private String ar_pt;
                private String ar_cmt;
                private String ar_hit;
                private String ar_surl;
                private String ar_an;
                private String ar_cate;
                private String ar_image;
                private String ar_i_type;

                public String getAr_id() {
                    return ar_id;
                }

                public void setAr_id(String ar_id) {
                    this.ar_id = ar_id;
                }

                public String getAr_tl() {
                    return ar_tl;
                }

                public void setAr_tl(String ar_tl) {
                    this.ar_tl = ar_tl;
                }

                public String getAr_sum() {
                    return ar_sum;
                }

                public void setAr_sum(String ar_sum) {
                    this.ar_sum = ar_sum;
                }

                public String getAr_pt() {
                    return ar_pt;
                }

                public void setAr_pt(String ar_pt) {
                    this.ar_pt = ar_pt;
                }

                public String getAr_cmt() {
                    return ar_cmt;
                }

                public void setAr_cmt(String ar_cmt) {
                    this.ar_cmt = ar_cmt;
                }

                public String getAr_hit() {
                    return ar_hit;
                }

                public void setAr_hit(String ar_hit) {
                    this.ar_hit = ar_hit;
                }

                public String getAr_surl() {
                    return ar_surl;
                }

                public void setAr_surl(String ar_surl) {
                    this.ar_surl = ar_surl;
                }

                public String getAr_an() {
                    return ar_an;
                }

                public void setAr_an(String ar_an) {
                    this.ar_an = ar_an;
                }

                public String getAr_cate() {
                    return ar_cate;
                }

                public void setAr_cate(String ar_cate) {
                    this.ar_cate = ar_cate;
                }

                public String getAr_image() {
                    return ar_image;
                }

                public void setAr_image(String ar_image) {
                    this.ar_image = ar_image;
                }

                public String getAr_i_type() {
                    return ar_i_type;
                }

                public void setAr_i_type(String ar_i_type) {
                    this.ar_i_type = ar_i_type;
                }
            }

            public static class CountBean implements Serializable {
                /**
                 * comment : 0
                 * hit :
                 */

                private String comment;
                private String hit;

                public String getComment() {
                    return comment;
                }

                public void setComment(String comment) {
                    this.comment = comment;
                }

                public String getHit() {
                    return hit;
                }

                public void setHit(String hit) {
                    this.hit = hit;
                }
            }
        }
    }

}
