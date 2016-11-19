package cn.qingchengfit.widgets.utils;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * power by
 * <p>
 * d8888b.  .d8b.  d8888b. d88888b d8888b.
 * 88  `8D d8' `8b 88  `8D 88'     88  `8D
 * 88oodD' 88ooo88 88oodD' 88ooooo 88oobY'
 * 88~~~   88~~~88 88~~~   88~~~~~ 88`8b
 * 88      88   88 88      88.     88 `88.
 * 88      YP   YP 88      Y88888P 88   YD
 * <p>
 * <p>
 * Created by Paper on 15/10/21 2015.
 */
public class StringUtils {
    public static boolean contains(String s1, String s2) {
        return s1.contains(s2);
    }

    public static boolean equals(String s1, String s2) {
        return s1.equals(s2);
    }


    public static String getFloatDot2(float f) {
        if (((int) (f * 100)) % 100 != 0)
            return String.format(Locale.CHINA, "%.2f", f);
        if (f == 0)
            return "0";

        return String.format(Locale.CHINA, "%.0f", f);

    }
    public static String getFloatDot1(float fo) {
        return String.format(Locale.CHINA, "%.1f", fo);
    }


    /**
     * 数字数组,包含头尾
     *
     * @param from
     * @param to
     * @return
     */
    public static List<String> getNums(int from, int to) {
        List<String> ret = new ArrayList<>();
        for (int i = from; i < to + 1; i++) {
            ret.add(Integer.toString(i));
        }
        return ret;
    }


    public static String List2Str(List<String> stringList) {
        String ret = "";
        if (stringList == null)
            return null;
        for (int i = 0; i < stringList.size(); i++) {
            if (i < stringList.size() - 1)
                ret = TextUtils.concat(ret, stringList.get(i), ",").toString();
            else ret = TextUtils.concat(ret, stringList.get(i)).toString();
        }
        return ret;
    }

    public static List<String> Str2List(String s) {
        if (s == null)
            return null;
        List<String> ret = new ArrayList<>();
        if (s.contains(",")) {
            String[] rets = s.split(",");
            for (int i = 0; i < rets.length; i++) {
                ret.add(rets[i]);
            }
        } else {
            ret.add(s);
        }
        return ret;

    }


}
