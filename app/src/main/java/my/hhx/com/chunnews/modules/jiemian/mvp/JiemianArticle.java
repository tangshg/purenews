package my.hhx.com.chunnews.modules.jiemian.mvp;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hhx on 2017/10/20.
 */

public class JiemianArticle implements Serializable{
    @Override
    public String toString() {
        return "JiemianArticle{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", result=" + result +
                '}';
    }

    /**
     * code : 0
     * message : suss
     * result : {"article":{"ar_id":"1694701","ar_tl":"Air Jordan XXXII的背后：意大利启发 技术增质感","ar_sum":"除开最近发售的Air Jordan XXXII\u201cBred\u201d，接下来的两个月中，这款鞋还将推出更多配色。","ar_pt":"1508467671","ar_ding":"2","ar_st":"图片来源：ESPN","ar_ot":"","ar_hl":"1","ar_con":"%3Cp%3E%5Bimg%3A0%5D%3C%2Fp%3E%3Cp%3E%5Bimg%3A1%5D%3C%2Fp%3E%3Cp%3E%5Bimg%3A2%5D%3C%2Fp%3E%3Cp%3E%5Bimg%3A3%5D%3C%2Fp%3E%3Cp%3E%5Bimg%3A4%5D%3C%2Fp%3E%3Cp%3E%5Bimg%3A5%5D%3C%2Fp%3E%3Cp%3E%5Bimg%3A6%5D%3C%2Fp%3E%3Cp%3E%5Bimg%3A7%5D%3C%2Fp%3E%3Cp%3E%5Bimg%3A8%5D%3C%2Fp%3E%3Cp%3E%5Bimg%3A9%5D%3C%2Fp%3E%3Cp%3E%5Bimg%3A10%5D%3C%2Fp%3E%3Cp%3E%5Bimg%3A11%5D%3C%2Fp%3E","ar_fr":"","ar_fr_url":"","ar_ut":"","ar_image":"https://img3.jiemian.com/101/original/20171020/150843306664387300.jpg"},"author_list":[{"uid":"115067559","name":"占悦","head_img":"https://img.jiemian.com/userface/210x210/741/676/115067559-1504705612.jpg","is_v":"2","is_show_v":"2","remark":"界面实习记者","user_other":"","weixin":""}],"photos":[{"order":1,"image":"https://img.jiemian.com/101/original/20171020/150843327331710000_a580xH.jpg","size":"0*0","intro":"就在10月18日这天，Air Jordan XXXII（也称AJ 32）\u201cBred\u201d迎来了正式发售，鞋身由象征着芝加哥公牛的黑色与红色构成。随着这款鞋在今年逐步问世，其背后生动的诞生故事也引发了关注。","photo":"1"},{"order":2,"image":"https://img.jiemian.com/101/original/20171020/150843328626266700_a580xH.jpg","size":"0*0","intro":"Air Jordan系列的精髓是\u201c飞人\u201d。由于迈克尔·乔丹惊人的弹跳力与扣篮表现，他赢得了\u201c飞人乔丹\u201d这个称号。随后Air Jordan将其作为该系列鞋履的灵魂。Jordan品牌创意总监David Creech认为Air Jordan就是表达关于\u201c飞人\u201d的理念，\u201c无论何时我们都希望人们能够从Air Jordan系列中，联想到乔丹经典扣篮的照片\u201d。 ","photo":"1"},{"order":3,"image":"https://img.jiemian.com/101/original/20171020/150843329949107900_a580xH.jpg","size":"0*0","intro":"Air Jordan 32是根据Air Jordan 2来进行设计的。Air Jordan 2在1980年代诞生时，便成为鞋履市场独树一帜的\u201c景象\u201d。该鞋采用了人工鬣蜥皮材质，鞋舌处嵌有\u201c翅膀\u201d标志，鞋内许多精致小细节均展现出这双鞋来自于意大利的高级制作。尽管这双鞋售价为100美元，但Creech称其为\u201c首双豪华篮球鞋\u201d，甚至于还影响了后来的许多Air Jordan款式的制作。","photo":"1"},{"order":4,"image":"https://img.jiemian.com/101/original/20171020/15084333166678300_a580xH.jpg","size":"0*0","intro":"耐克是在意大利都灵，揭晓Air Jordan 32真容的。相比较于纽约、洛杉矶等大城市，意大利的都灵都不是一个传统的篮球之乡。但这里拥有许多地标式建筑与雕像、各类的咖啡店、知名的裁缝与手工艺人，历史与文化环境启发着设计师们。Air Jordan 32的高级设计师Tate Kuerbis表示：\u201c我们在这里走访了许多经典的意大利品牌，将他们细致的技术融入到鞋履制作中，人们会明显感觉到这鞋履是手工制作的。\u201d","photo":"1"},{"order":5,"image":"https://img.jiemian.com/101/original/20171020/150843333023789800_a580xH.jpg","size":"0*0","intro":"坐落于都灵的国家汽车博物馆，收藏着经典的法拉利跑车，而跑车也是Air Jordan 32的灵感来源之一。Air Jordan 32还推出了法拉利红款配色（Rosso Corsa），该鞋的制作方式以及皮革的味道，也受到了法拉利跑车的方向盘的启发。而此前的Air Jordan 14，灵感便来源于法拉利550M。Kuerbis认为Air Jordan系列与法拉利跑车很相似，不仅外观夺目，内部细节也十分精致，性能出色。","photo":"1"},{"order":6,"image":"https://img.jiemian.com/101/original/20171020/150843334557780000_a580xH.jpg","size":"0*0","intro":"此外，法拉利也是乔丹在进入NBA之后钟爱的跑车，当时他还将车牌自定义为\u201cUNC 23\u201d与\u201cM AIR J\u201d。彼时，Kuerbis 还被乔丹邀请到家中参观，并被他车库中数量巨多的意大利车所震惊。","photo":"1"},{"order":7,"image":"https://img.jiemian.com/101/original/20171020/150843335976916000_a580xH.jpg","size":"0*0","intro":"有了灵感后，设计师该进行创作了。大部分鞋履的创作周期为14到18个月，这意味着包括Kuerbis在内的设计师，要一直在草稿纸上涂涂改改。\u201c我几乎难以和制图板分离，有时候会因为某些动作得到灵感，有时候也会从以往的鞋子设计得到灵感。\u201d","photo":"1"},{"order":8,"image":"https://img.jiemian.com/101/original/20171020/150843337823517700_a580xH.jpg","size":"0*0","intro":"在设计接近尾声时，乔丹与设计师会召开会议，设计师将快要完成的图纸交于乔丹，并由后者决定是否投入生产、是否需要重新修改。Air Jordan 32的出炉没有面临太多困难，乔丹只提出了一个修改建议，即希望鞋履的后端可以更活泼、更酷。","photo":"1"},{"order":9,"image":"https://img.jiemian.com/101/original/20171020/150843339736314600_a580xH.jpg","size":"0*0","intro":"会议之后，Kuerbis又重新拿起了制图板。他灵光一闪，便将鞋跟设计成棱纹样式。而六条棱纹则象征了乔丹的六座NBA总冠军奖杯。","photo":"1"},{"order":10,"image":"https://img.jiemian.com/101/original/20171020/150843341064898400_a580xH.jpg","size":"0*0","intro":"除开鞋履样式与细节的创新，Air Jordan 32也运用了先进技术。此前，Air Jordan系列的鞋面采用的是梭织物材料，而Air Jordan 32则运用了质感更好的3D针织物。同时，编织图案也较为复杂，一旦出现扭曲，就得重新来过。Kuerbis称这双鞋的制作极具挑战性，仅鞋头的部分就需要300多个步骤。","photo":"1"},{"order":11,"image":"https://img.jiemian.com/101/original/20171020/150843342271626400_a580xH.jpg","size":"0*0","intro":"此外，球鞋搭载的前后掌Zoom Air气垫在Flight Plate科技的加持下，拥有更出色的缓震效果，而人字形大底纹路也提高了抓地力。","photo":"1"},{"order":12,"image":"https://img.jiemian.com/101/original/20171020/150843342964303200_a580xH.jpg","size":"0*0","intro":"对于乔丹来说，Air Jordan 32是对他30年前所穿着的Air Jordan 2的致敬。他在一则公开声明中表示：\u201c我们挖掘了新的材料与科技去创造新球鞋，但我们依旧坚守着品牌的核心价值。\u201d在不久之后，Air Jordan 32也将推出\u201cCEO\u201d、\u201cWIN LIKE \u201882\u2019\u201d、\u201cRUSS\u201d、\u201cWIN LIKE \u201896\u2019\u201d等款式。","photo":"1"}],"count":{"comment":"0"},"share":{"tl":"Air Jordan XXXII的背后：意大利启发 技术增质感","summary":"除开最近发售的Air Jordan XXXII\u201cBred\u201d，接下来的两个月中，这款鞋还将推出更多配色。","image":"https://img3.jiemian.com/101/original/20171020/150843306664387300.jpg","url":"http://m.jiemian.com/article/1694701.html"}}
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

    public static class ResultBean {
        @Override
        public String toString() {
            return "ResultBean{" +
                    "article=" + article +
                    ", count=" + count +
                    ", share=" + share +
                    ", author_list=" + author_list +
                    ", photos=" + photos +
                    '}';
        }

        /**
         * article : {"ar_id":"1694701","ar_tl":"Air Jordan XXXII的背后：意大利启发 技术增质感","ar_sum":"除开最近发售的Air Jordan XXXII\u201cBred\u201d，接下来的两个月中，这款鞋还将推出更多配色。","ar_pt":"1508467671","ar_ding":"2","ar_st":"图片来源：ESPN","ar_ot":"","ar_hl":"1","ar_con":"%3Cp%3E%5Bimg%3A0%5D%3C%2Fp%3E%3Cp%3E%5Bimg%3A1%5D%3C%2Fp%3E%3Cp%3E%5Bimg%3A2%5D%3C%2Fp%3E%3Cp%3E%5Bimg%3A3%5D%3C%2Fp%3E%3Cp%3E%5Bimg%3A4%5D%3C%2Fp%3E%3Cp%3E%5Bimg%3A5%5D%3C%2Fp%3E%3Cp%3E%5Bimg%3A6%5D%3C%2Fp%3E%3Cp%3E%5Bimg%3A7%5D%3C%2Fp%3E%3Cp%3E%5Bimg%3A8%5D%3C%2Fp%3E%3Cp%3E%5Bimg%3A9%5D%3C%2Fp%3E%3Cp%3E%5Bimg%3A10%5D%3C%2Fp%3E%3Cp%3E%5Bimg%3A11%5D%3C%2Fp%3E","ar_fr":"","ar_fr_url":"","ar_ut":"","ar_image":"https://img3.jiemian.com/101/original/20171020/150843306664387300.jpg"}
         * author_list : [{"uid":"115067559","name":"占悦","head_img":"https://img.jiemian.com/userface/210x210/741/676/115067559-1504705612.jpg","is_v":"2","is_show_v":"2","remark":"界面实习记者","user_other":"","weixin":""}]
         * photos : [{"order":1,"image":"https://img.jiemian.com/101/original/20171020/150843327331710000_a580xH.jpg","size":"0*0","intro":"就在10月18日这天，Air Jordan XXXII（也称AJ 32）\u201cBred\u201d迎来了正式发售，鞋身由象征着芝加哥公牛的黑色与红色构成。随着这款鞋在今年逐步问世，其背后生动的诞生故事也引发了关注。","photo":"1"},{"order":2,"image":"https://img.jiemian.com/101/original/20171020/150843328626266700_a580xH.jpg","size":"0*0","intro":"Air Jordan系列的精髓是\u201c飞人\u201d。由于迈克尔·乔丹惊人的弹跳力与扣篮表现，他赢得了\u201c飞人乔丹\u201d这个称号。随后Air Jordan将其作为该系列鞋履的灵魂。Jordan品牌创意总监David Creech认为Air Jordan就是表达关于\u201c飞人\u201d的理念，\u201c无论何时我们都希望人们能够从Air Jordan系列中，联想到乔丹经典扣篮的照片\u201d。 ","photo":"1"},{"order":3,"image":"https://img.jiemian.com/101/original/20171020/150843329949107900_a580xH.jpg","size":"0*0","intro":"Air Jordan 32是根据Air Jordan 2来进行设计的。Air Jordan 2在1980年代诞生时，便成为鞋履市场独树一帜的\u201c景象\u201d。该鞋采用了人工鬣蜥皮材质，鞋舌处嵌有\u201c翅膀\u201d标志，鞋内许多精致小细节均展现出这双鞋来自于意大利的高级制作。尽管这双鞋售价为100美元，但Creech称其为\u201c首双豪华篮球鞋\u201d，甚至于还影响了后来的许多Air Jordan款式的制作。","photo":"1"},{"order":4,"image":"https://img.jiemian.com/101/original/20171020/15084333166678300_a580xH.jpg","size":"0*0","intro":"耐克是在意大利都灵，揭晓Air Jordan 32真容的。相比较于纽约、洛杉矶等大城市，意大利的都灵都不是一个传统的篮球之乡。但这里拥有许多地标式建筑与雕像、各类的咖啡店、知名的裁缝与手工艺人，历史与文化环境启发着设计师们。Air Jordan 32的高级设计师Tate Kuerbis表示：\u201c我们在这里走访了许多经典的意大利品牌，将他们细致的技术融入到鞋履制作中，人们会明显感觉到这鞋履是手工制作的。\u201d","photo":"1"},{"order":5,"image":"https://img.jiemian.com/101/original/20171020/150843333023789800_a580xH.jpg","size":"0*0","intro":"坐落于都灵的国家汽车博物馆，收藏着经典的法拉利跑车，而跑车也是Air Jordan 32的灵感来源之一。Air Jordan 32还推出了法拉利红款配色（Rosso Corsa），该鞋的制作方式以及皮革的味道，也受到了法拉利跑车的方向盘的启发。而此前的Air Jordan 14，灵感便来源于法拉利550M。Kuerbis认为Air Jordan系列与法拉利跑车很相似，不仅外观夺目，内部细节也十分精致，性能出色。","photo":"1"},{"order":6,"image":"https://img.jiemian.com/101/original/20171020/150843334557780000_a580xH.jpg","size":"0*0","intro":"此外，法拉利也是乔丹在进入NBA之后钟爱的跑车，当时他还将车牌自定义为\u201cUNC 23\u201d与\u201cM AIR J\u201d。彼时，Kuerbis 还被乔丹邀请到家中参观，并被他车库中数量巨多的意大利车所震惊。","photo":"1"},{"order":7,"image":"https://img.jiemian.com/101/original/20171020/150843335976916000_a580xH.jpg","size":"0*0","intro":"有了灵感后，设计师该进行创作了。大部分鞋履的创作周期为14到18个月，这意味着包括Kuerbis在内的设计师，要一直在草稿纸上涂涂改改。\u201c我几乎难以和制图板分离，有时候会因为某些动作得到灵感，有时候也会从以往的鞋子设计得到灵感。\u201d","photo":"1"},{"order":8,"image":"https://img.jiemian.com/101/original/20171020/150843337823517700_a580xH.jpg","size":"0*0","intro":"在设计接近尾声时，乔丹与设计师会召开会议，设计师将快要完成的图纸交于乔丹，并由后者决定是否投入生产、是否需要重新修改。Air Jordan 32的出炉没有面临太多困难，乔丹只提出了一个修改建议，即希望鞋履的后端可以更活泼、更酷。","photo":"1"},{"order":9,"image":"https://img.jiemian.com/101/original/20171020/150843339736314600_a580xH.jpg","size":"0*0","intro":"会议之后，Kuerbis又重新拿起了制图板。他灵光一闪，便将鞋跟设计成棱纹样式。而六条棱纹则象征了乔丹的六座NBA总冠军奖杯。","photo":"1"},{"order":10,"image":"https://img.jiemian.com/101/original/20171020/150843341064898400_a580xH.jpg","size":"0*0","intro":"除开鞋履样式与细节的创新，Air Jordan 32也运用了先进技术。此前，Air Jordan系列的鞋面采用的是梭织物材料，而Air Jordan 32则运用了质感更好的3D针织物。同时，编织图案也较为复杂，一旦出现扭曲，就得重新来过。Kuerbis称这双鞋的制作极具挑战性，仅鞋头的部分就需要300多个步骤。","photo":"1"},{"order":11,"image":"https://img.jiemian.com/101/original/20171020/150843342271626400_a580xH.jpg","size":"0*0","intro":"此外，球鞋搭载的前后掌Zoom Air气垫在Flight Plate科技的加持下，拥有更出色的缓震效果，而人字形大底纹路也提高了抓地力。","photo":"1"},{"order":12,"image":"https://img.jiemian.com/101/original/20171020/150843342964303200_a580xH.jpg","size":"0*0","intro":"对于乔丹来说，Air Jordan 32是对他30年前所穿着的Air Jordan 2的致敬。他在一则公开声明中表示：\u201c我们挖掘了新的材料与科技去创造新球鞋，但我们依旧坚守着品牌的核心价值。\u201d在不久之后，Air Jordan 32也将推出\u201cCEO\u201d、\u201cWIN LIKE \u201882\u2019\u201d、\u201cRUSS\u201d、\u201cWIN LIKE \u201896\u2019\u201d等款式。","photo":"1"}]
         * count : {"comment":"0"}
         * share : {"tl":"Air Jordan XXXII的背后：意大利启发 技术增质感","summary":"除开最近发售的Air Jordan XXXII\u201cBred\u201d，接下来的两个月中，这款鞋还将推出更多配色。","image":"https://img3.jiemian.com/101/original/20171020/150843306664387300.jpg","url":"http://m.jiemian.com/article/1694701.html"}
         */

        private ArticleBean article;
        private CountBean count;
        private ShareBean share;
        private List<AuthorListBean> author_list;
        private List<PhotosBean> photos;

        public ArticleBean getArticle() {
            return article;
        }

        public void setArticle(ArticleBean article) {
            this.article = article;
        }

        public CountBean getCount() {
            return count;
        }

        public void setCount(CountBean count) {
            this.count = count;
        }

        public ShareBean getShare() {
            return share;
        }

        public void setShare(ShareBean share) {
            this.share = share;
        }

        public List<AuthorListBean> getAuthor_list() {
            return author_list;
        }

        public void setAuthor_list(List<AuthorListBean> author_list) {
            this.author_list = author_list;
        }

        public List<PhotosBean> getPhotos() {
            return photos;
        }

        public void setPhotos(List<PhotosBean> photos) {
            this.photos = photos;
        }

        public static class ArticleBean {
            @Override
            public String toString() {
                return "ArticleBean{" +
                        "ar_id='" + ar_id + '\'' +
                        ", ar_tl='" + ar_tl + '\'' +
                        ", ar_sum='" + ar_sum + '\'' +
                        ", ar_pt='" + ar_pt + '\'' +
                        ", ar_ding='" + ar_ding + '\'' +
                        ", ar_st='" + ar_st + '\'' +
                        ", ar_ot='" + ar_ot + '\'' +
                        ", ar_hl='" + ar_hl + '\'' +
                        ", ar_con='" + ar_con + '\'' +
                        ", ar_fr='" + ar_fr + '\'' +
                        ", ar_fr_url='" + ar_fr_url + '\'' +
                        ", ar_ut='" + ar_ut + '\'' +
                        ", ar_image='" + ar_image + '\'' +
                        '}';
            }

            /**
             * ar_id : 1694701
             * ar_tl : Air Jordan XXXII的背后：意大利启发 技术增质感
             * ar_sum : 除开最近发售的Air Jordan XXXII“Bred”，接下来的两个月中，这款鞋还将推出更多配色。
             * ar_pt : 1508467671
             * ar_ding : 2
             * ar_st : 图片来源：ESPN
             * ar_ot :
             * ar_hl : 1
             * ar_con : %3Cp%3E%5Bimg%3A0%5D%3C%2Fp%3E%3Cp%3E%5Bimg%3A1%5D%3C%2Fp%3E%3Cp%3E%5Bimg%3A2%5D%3C%2Fp%3E%3Cp%3E%5Bimg%3A3%5D%3C%2Fp%3E%3Cp%3E%5Bimg%3A4%5D%3C%2Fp%3E%3Cp%3E%5Bimg%3A5%5D%3C%2Fp%3E%3Cp%3E%5Bimg%3A6%5D%3C%2Fp%3E%3Cp%3E%5Bimg%3A7%5D%3C%2Fp%3E%3Cp%3E%5Bimg%3A8%5D%3C%2Fp%3E%3Cp%3E%5Bimg%3A9%5D%3C%2Fp%3E%3Cp%3E%5Bimg%3A10%5D%3C%2Fp%3E%3Cp%3E%5Bimg%3A11%5D%3C%2Fp%3E
             * ar_fr :
             * ar_fr_url :
             * ar_ut :
             * ar_image : https://img3.jiemian.com/101/original/20171020/150843306664387300.jpg
             */

            private String ar_id;
            private String ar_tl;
            private String ar_sum;
            private String ar_pt;
            private String ar_ding;
            private String ar_st;
            private String ar_ot;
            private String ar_hl;
            private String ar_con;
            private String ar_fr;
            private String ar_fr_url;
            private String ar_ut;
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

            public String getAr_ding() {
                return ar_ding;
            }

            public void setAr_ding(String ar_ding) {
                this.ar_ding = ar_ding;
            }

            public String getAr_st() {
                return ar_st;
            }

            public void setAr_st(String ar_st) {
                this.ar_st = ar_st;
            }

            public String getAr_ot() {
                return ar_ot;
            }

            public void setAr_ot(String ar_ot) {
                this.ar_ot = ar_ot;
            }

            public String getAr_hl() {
                return ar_hl;
            }

            public void setAr_hl(String ar_hl) {
                this.ar_hl = ar_hl;
            }

            public String getAr_con() {
                return ar_con;
            }

            public void setAr_con(String ar_con) {
                this.ar_con = ar_con;
            }

            public String getAr_fr() {
                return ar_fr;
            }

            public void setAr_fr(String ar_fr) {
                this.ar_fr = ar_fr;
            }

            public String getAr_fr_url() {
                return ar_fr_url;
            }

            public void setAr_fr_url(String ar_fr_url) {
                this.ar_fr_url = ar_fr_url;
            }

            public String getAr_ut() {
                return ar_ut;
            }

            public void setAr_ut(String ar_ut) {
                this.ar_ut = ar_ut;
            }

            public String getAr_image() {
                return ar_image;
            }

            public void setAr_image(String ar_image) {
                this.ar_image = ar_image;
            }
        }

        public static class CountBean {
            @Override
            public String toString() {
                return "CountBean{" +
                        "comment='" + comment + '\'' +
                        '}';
            }

            /**
             * comment : 0
             */

            private String comment;

            public String getComment() {
                return comment;
            }

            public void setComment(String comment) {
                this.comment = comment;
            }
        }

        public static class ShareBean {
            @Override
            public String toString() {
                return "ShareBean{" +
                        "tl='" + tl + '\'' +
                        ", summary='" + summary + '\'' +
                        ", image='" + image + '\'' +
                        ", url='" + url + '\'' +
                        '}';
            }

            /**
             * tl : Air Jordan XXXII的背后：意大利启发 技术增质感
             * summary : 除开最近发售的Air Jordan XXXII“Bred”，接下来的两个月中，这款鞋还将推出更多配色。
             * image : https://img3.jiemian.com/101/original/20171020/150843306664387300.jpg
             * url : http://m.jiemian.com/article/1694701.html
             */

            private String tl;
            private String summary;
            private String image;
            private String url;

            public String getTl() {
                return tl;
            }

            public void setTl(String tl) {
                this.tl = tl;
            }

            public String getSummary() {
                return summary;
            }

            public void setSummary(String summary) {
                this.summary = summary;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class AuthorListBean {
            @Override
            public String toString() {
                return "AuthorListBean{" +
                        "uid='" + uid + '\'' +
                        ", name='" + name + '\'' +
                        ", head_img='" + head_img + '\'' +
                        ", is_v='" + is_v + '\'' +
                        ", is_show_v='" + is_show_v + '\'' +
                        ", remark='" + remark + '\'' +
                        ", user_other='" + user_other + '\'' +
                        ", weixin='" + weixin + '\'' +
                        '}';
            }

            /**
             * uid : 115067559
             * name : 占悦
             * head_img : https://img.jiemian.com/userface/210x210/741/676/115067559-1504705612.jpg
             * is_v : 2
             * is_show_v : 2
             * remark : 界面实习记者
             * user_other :
             * weixin :
             */

            private String uid;
            private String name;
            private String head_img;
            private String is_v;
            private String is_show_v;
            private String remark;
            private String user_other;
            private String weixin;

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getHead_img() {
                return head_img;
            }

            public void setHead_img(String head_img) {
                this.head_img = head_img;
            }

            public String getIs_v() {
                return is_v;
            }

            public void setIs_v(String is_v) {
                this.is_v = is_v;
            }

            public String getIs_show_v() {
                return is_show_v;
            }

            public void setIs_show_v(String is_show_v) {
                this.is_show_v = is_show_v;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public String getUser_other() {
                return user_other;
            }

            public void setUser_other(String user_other) {
                this.user_other = user_other;
            }

            public String getWeixin() {
                return weixin;
            }

            public void setWeixin(String weixin) {
                this.weixin = weixin;
            }
        }

        public static class PhotosBean {
            @Override
            public String toString() {
                return "PhotosBean{" +
                        "order=" + order +
                        ", image='" + image + '\'' +
                        ", size='" + size + '\'' +
                        ", intro='" + intro + '\'' +
                        ", photo='" + photo + '\'' +
                        '}';
            }

            /**
             * order : 1
             * image : https://img.jiemian.com/101/original/20171020/150843327331710000_a580xH.jpg
             * size : 0*0
             * intro : 就在10月18日这天，Air Jordan XXXII（也称AJ 32）“Bred”迎来了正式发售，鞋身由象征着芝加哥公牛的黑色与红色构成。随着这款鞋在今年逐步问世，其背后生动的诞生故事也引发了关注。
             * photo : 1
             */

            private int order;
            private String image;
            private String size;
            private String intro;
            private String photo;

            public int getOrder() {
                return order;
            }

            public void setOrder(int order) {
                this.order = order;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getSize() {
                return size;
            }

            public void setSize(String size) {
                this.size = size;
            }

            public String getIntro() {
                return intro;
            }

            public void setIntro(String intro) {
                this.intro = intro;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }
        }
    }
}
