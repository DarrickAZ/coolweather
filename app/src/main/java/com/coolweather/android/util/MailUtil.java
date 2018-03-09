package com.coolweather.android.util;

import android.util.Log;

import com.sun.mail.util.MailSSLSocketFactory;

import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @author Darrick
 * @package com.coolweather.android.util
 * @class MailUtil
 * @date 2018/3/9 14:24
 * @description 邮件发送工具类
 * @versions 1.0
 */
public class MailUtil {

    private static final String TAG = "MailUtil";

    public static final String userName = "13018006329@163.com";

    public static final String password =  "tjq101zww723";

    public static final String sendTo = "zhangweiwei@collabtech.cn";
    /**
     * 163纯文本发送
     * @param content
     */
    public static void sendEMailBy163(String content){
        Log.i(TAG,"sendEMailBy163 >>> "+content);
        try {
            Properties props = new Properties();
            // 开启debug调试
            props.setProperty("mail.debug", "true");
            // 发送服务器需要身份验证
            props.setProperty("mail.smtp.auth", "true");
            // 设置邮件服务器主机名
            props.setProperty("mail.host", "smtp.163.com");
            // 发送邮件协议名称
            props.setProperty("mail.transport.protocol", "smtp");

            //qq邮箱用于ssl加密
            MailSSLSocketFactory sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            props.put("mail.smtp.ssl.enable", "true");
            props.put("mail.smtp.ssl.socketFactory", sf);

            // 设置环境信息
            Session session = Session.getInstance(props);

            // 创建邮件对象
            Message msg = new MimeMessage(session);
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String d = sdf.format(date);
            msg.setSubject("CoolWeather "+" ["+d+"]");
            // 设置邮件内容
            msg.setText("错误结果为 开始： ["+content+"]  错误结束.阿门!!!");
            // 设置发件人
            msg.setFrom(new InternetAddress(userName));

            Transport transport = session.getTransport();
            // 连接邮件服务器以及账户、smtp授权码 pmjtrxzpdiateaed
            transport.connect("smtp.163.com",userName,password);
            // 发送邮件
            transport.sendMessage(msg, new Address[] { new InternetAddress(sendTo) });
            // 关闭连接
            transport.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
