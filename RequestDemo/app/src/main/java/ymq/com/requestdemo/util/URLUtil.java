package ymq.com.requestdemo.util;

import android.content.Context;

import java.util.Map;

/**
 * Created by iyunshu on 2019/8/22.
 */

public class URLUtil {
    public static String getUrl(Context context, String url) {
        return "" +url;
    }

    public static String getTestUrl(Context context, String url){
        return "http://service.iyunshu.com/IyunshuApp/" +url;
    }
    /**
     * 将map转换成url
     * @param map
     * @return
     */
    public static String getUrlParamsByMap(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(entry.getKey() + "=" + entry.getValue());
            sb.append("&");
        }
        String s = sb.toString();
        if (s.endsWith("&")) {
            s = substringBeforeLast(s, "&");
        }
        return s;
    }

    public static String substringBeforeLast(String str, String separator) {
        if(!isEmpty(str) && !isEmpty(separator)) {
            int pos = str.lastIndexOf(separator);
            return pos == -1?str:str.substring(0, pos);
        } else {
            return str;
        }
    }

    public static boolean isEmpty(CharSequence cs) {
        return cs == null || cs.length() == 0;
    }
}
