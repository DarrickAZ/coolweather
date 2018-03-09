package com.coolweather.android;

import com.sun.mail.util.MailSSLSocketFactory;

import org.junit.Test;

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

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testSendMailByQQ() throws GeneralSecurityException, MessagingException {
                    Properties props = new Properties();
                    // 开启debug调试
                    props.setProperty("mail.debug", "true");
                    // 发送服务器需要身份验证
                    props.setProperty("mail.smtp.auth", "true");
                    // 设置邮件服务器主机名
                    props.setProperty("mail.host", "smtp.qq.com");
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
                    msg.setSubject("JavaMail测试");
                    // 设置邮件内容
                    msg.setText("这是一封由JavaMail发送的邮件！");
                    // 设置发件人
                    msg.setFrom(new InternetAddress("2171651923@qq.com"));

                    Transport transport = session.getTransport();
                    // 连接邮件服务器以及账户、smtp授权码 pmjtrxzpdiateaed
                    transport.connect("smtp.qq.com","2171651923@qq.com", "pmjt rxzp diat eaed");
                    // 发送邮件
                    transport.sendMessage(msg, new Address[] { new InternetAddress("zhangweiwei@collabtech.cn") });
                    // 关闭连接
                    transport.close();

    }

    @Test
    public void testSendMailBy163() throws GeneralSecurityException, MessagingException {
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
        msg.setSubject("JavaMail测试----"+d);
        // 设置邮件内容
        msg.setText("这是一封由JavaMail发送的邮件！");
        // 设置发件人
        msg.setFrom(new InternetAddress("13018006329@163.com"));

        Transport transport = session.getTransport();
        // 连接邮件服务器以及账户、smtp授权码 pmjtrxzpdiateaed
        transport.connect("smtp.163.com","13018006329@163.com", "tjq101zww723");
        // 发送邮件
        transport.sendMessage(msg, new Address[] { new InternetAddress("zhangweiwei@collabtech.cn") });
        // 关闭连接
        transport.close();

    }

}