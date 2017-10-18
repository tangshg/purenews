package my.hhx.com.chunnews.util;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import my.hhx.com.chunnews.modules.wangyinews.mvp.WangyiContent;

/**
 * Created by hhx on 2017/8/2.
 */

public class WebUtil {
    public static final String BASE_URL = "file:///android_asset/";
    public static final String MIME_TYPE = "text/html";
    public static final String ENCODING = "utf-8";
    public static final String ZHIHU_FAIL_URL = "http://daily.zhihu.com/";
    public static final String IT_FAIL_URL = "https://www.ithome.com/list/";
    public static final String WANGYI_FAIL_URL = "http://news.163.com/";

    private static final String CSS_LINK_PATTERN = " <link href=\"%s\" type=\"text/css\" rel=\"stylesheet\" />";
    private static final String NIGHT_DIV_TAG_START = "<div class=\"night\">";
    private static final String NIGHT_DIV_TAG_END = "</div>";
    private static final String IMG_URL_TAG = "<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>";
    private static final String Zhihu_IMG_URL_TAG = "<img class=\"content-image\"[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>";
    //"<img\\s+src=(?:['\"])?(?<src>\\w+.(jpg|png))(?:['\"])?\\s*/>"
    private static final String IMG_URL_CONTENT = "http(s?):\"?(.*?)(\"|>|\\s+)";

    private static final String DIV_IMAGE_PLACE_HOLDER = "class=\"img-place-holder\"";
    private static final String DIV_IMAGE_PLACE_HOLDER_IGNORED = "class=\"img-place-holder-ignored\"";

    public static String buildHtmlWithCss(String html, List<String> cssUrls, boolean isNightMode) {
        StringBuilder result = new StringBuilder();
        for (String cssUrl : cssUrls) {
            result.append(String.format(CSS_LINK_PATTERN, cssUrl));
        }

        if (isNightMode) {
            result.append(NIGHT_DIV_TAG_START);
        }
        result.append(html.replace(DIV_IMAGE_PLACE_HOLDER, DIV_IMAGE_PLACE_HOLDER_IGNORED));
        if (isNightMode) {
            result.append(NIGHT_DIV_TAG_END);
        }
        String data = result.toString();
        //让文字不再散乱
        data = data.replace("<p", "<p style='text-align:justify' ");
        return data;
    }

    public static String buildHtmlForIt(String content, boolean isNightMode) {
        StringBuilder modifiedHtml = new StringBuilder();
        modifiedHtml.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>" + "<!DOCTYPE html PUBLIC \"-//WAPFORUM//DTD XHTML Mobile 1.0//EN\" \"http://www.wapforum.org/DTD/xhtml-mobile10.dtd\">"
                + "<html xmlns=\"http://www.w3.org/1999/xhtml\">" + "<head>" + "<meta http-equiv=\"Content-Type\" content=\"application/xhtml+xml; charset=utf-8\"/>"
                + "<meta http-equiv=\"Cache-control\" content=\"public\" />" + "<meta name=\"viewport\" content=\"width=device-width,initial-scale=1,user-scalable=no,minimum-scale=1.0,maximum-scale=1.0\" />"
                + "<link rel=\"stylesheet\" href=\"file:///android_asset/news.css\" type=\"text/css\">"
                + "<script src=\"file:///android_asset/jquery.min.js\"></script>" + "<script src=\"file:///android_asset/info.js\"></script>");
        modifiedHtml.append("<body ");
        if (isNightMode) {
            modifiedHtml.append("class=\'night\'");
        }
        modifiedHtml.append(">");
        modifiedHtml.append(content);
        modifiedHtml.append("</body></html>");
        return modifiedHtml.toString();
    }

    public static String buildHtmlForWangyi(String content, List<WangyiContent.Content.ImgBean> image, List<WangyiContent.Content.VideoBean> video, boolean isNightMode) {
        StringBuilder modifiedHtml = new StringBuilder();
        modifiedHtml.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>" + "<!DOCTYPE html PUBLIC \"-//WAPFORUM//DTD XHTML Mobile 1.0//EN\" \"http://www.wapforum.org/DTD/xhtml-mobile10.dtd\">"
                + "<html xmlns=\"http://www.w3.org/1999/xhtml\">" + "<head>" + "<meta http-equiv=\"Content-Type\" content=\"application/xhtml+xml; charset=utf-8\"/>"
                + "<meta http-equiv=\"Cache-control\" content=\"public\" />" + "<meta name=\"viewport\" content=\"width=device-width,initial-scale=1,user-scalable=no,minimum-scale=1.0,maximum-scale=1.0\" />"
                + "<link rel=\"stylesheet\" href=\"file:///android_asset/news.css\" type=\"text/css\">");
        modifiedHtml.append("<body ");
        if (isNightMode) {
            modifiedHtml.append("class=\'night\'");
        }
        modifiedHtml.append(">");
        if (image != null) {
            for (int i = 0; i < image.size(); i++) {
                String a = "<!--IMG#" + i + "-->";
                content = content.replace(a, "<img src=\"" + image.get(i).getSrc() + "\" />");
            }
        }
        if (video != null) {
            for (int i = 0; i < video.size(); i++) {
                String a = "<!--VIDEO#" + i + "-->";
                String b = video.get(i).getCover();
                content = content.replace(a, "<video controls=\"\" autoplay=\"\" name=\"media\" poster=\""+b+"\"><source src=\"" + video.get(i).getUrl_mp4() + "\" type=\"video/mp4\"></video>");

            }
        }
        modifiedHtml.append(content);
        modifiedHtml.append("</body></html>");

        return modifiedHtml.toString();

    }

    public static List<String> getAllImgUrl(String html) {
        Matcher matcher = Pattern.compile(IMG_URL_TAG).matcher(html);
        List<String> listImgUrl = new ArrayList<String>();
        while (matcher.find()) {
            listImgUrl.add(matcher.group());

        }
        for (int i = 0; i < listImgUrl.size(); i++) {
            Log.e("listimg", listImgUrl.get(i));
        }
        //从图片对应的地址对象中解析出 src 标签对应的内容
        List<String> imgUrl = new ArrayList<>();
        for (String image : listImgUrl) {
            Matcher matcher1 = Pattern.compile(IMG_URL_CONTENT).matcher(image);
            while (matcher1.find()) {
                String a = matcher1.group();
                a = a.substring(0, a.length() - 1);
                imgUrl.add(a);
            }
        }
        for (int i = 0; i < imgUrl.size(); i++) {
            Log.e("imgurl", imgUrl.get(i));
        }
        return imgUrl;

    }

    public static List<String> getAllZhihuImgUrl(String html) {
        Matcher matcher = Pattern.compile(Zhihu_IMG_URL_TAG).matcher(html);
        List<String> listImgUrl = new ArrayList<String>();
        while (matcher.find()) {
            listImgUrl.add(matcher.group());

        }
        for (int i = 0; i < listImgUrl.size(); i++) {
            Log.e("listimg", listImgUrl.get(i));
        }
        //从图片对应的地址对象中解析出 src 标签对应的内容
        List<String> imgUrl = new ArrayList<>();
        for (String image : listImgUrl) {
            Matcher matcher1 = Pattern.compile(IMG_URL_CONTENT).matcher(image);
            while (matcher1.find()) {
                String a = matcher1.group();
                a = a.substring(0, a.length() - 1);
                imgUrl.add(a);
            }
        }
        for (int i = 0; i < imgUrl.size(); i++) {
            Log.e("imgurl", imgUrl.get(i));
        }
        return imgUrl;

    }
}
