package com.coolweather.android.util;

/**
 * @author Darrick
 * @package com.coolweather.android.util
 * @class MailHandler
 * @date 2018/3/9 15:34
 * @description
 * @versions 1.0
 */
public class MailHandler implements Runnable{

    public String content;

    public MailHandler(String content) {
        this.content = content;
    }
    @Override
    public void run() {
        MailUtil.sendEMailBy163(content);
    }
}
