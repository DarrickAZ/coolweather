package com.coolweather.android.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author Darrick
 * @package com.coolweather.android.util
 * @class PrintStackTraceUtil
 * @date 2018/3/9 16:03
 * @description
 * @versions 1.0
 */
public class PrintStackTraceUtil {

    public static String getMessage(Exception e){
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        String msg=sw.toString();
        return msg;
    }



}
