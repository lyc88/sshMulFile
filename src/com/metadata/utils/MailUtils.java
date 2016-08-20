package com.metadata.utils;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;


import java.io.File;
import java.security.Security;
import java.util.Properties;

/**
 * Created by Administrator on 2016/8/20.
 */
public class MailUtils {
    public static void main(String [] args) throws AddressException, MessagingException {
        // 收件人电子邮箱
        String to = "984006207@qq.com";

        // 发件人电子邮箱
        String from = "861354950@qq.com";

        // 指定发送邮件的主机为 localhost
        String host = "smtp.qq.com";  //QQ 邮件服务器

        // 获取系统属性
        Properties properties = System.getProperties();

        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", host);

        properties.put("mail.smtp.auth", "true");
        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.smtp.port", "465");
        properties.setProperty("mail.smtp.socketFactory.port", "465");
        properties.put("mail.debug", "true");
        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties,new Authenticator(){
            public PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication("861354950@qq.com", "ifiaetxxmmpsbejg"); //发件人邮件用户名、密码
            }
        });

        try{
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);

            // Set From: 头部头字段
            message.setFrom(new InternetAddress(from));

            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));

            // Set Subject: 头部头字段
            message.setSubject("This is the Subject Line!");
            // 发送 HTML 消息, 可以插入html标签
            /*message.setContent("<h1>This is actual message</h1>",
                    "text/html" );*/

            // 创建消息部分
            BodyPart messageBodyPart = new MimeBodyPart();

            // 消息
            messageBodyPart.setText("This is message body");

            // 创建多重消息
            Multipart multipart = new MimeMultipart();

            // 设置文本消息部分
            multipart.addBodyPart(messageBodyPart);

            // 附件部分
            messageBodyPart = new MimeBodyPart();
            String filename = "F:\\student.txt";
            File file = new File(filename);
            System.out.println(file.getName());
            messageBodyPart.setContent(message, "text/html;charset=UTF-8");
            DataSource source = new FileDataSource(file);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName("student.txt");
            //messageBodyPart.setFileName(MimeUtility.encodeWord(attachment.getName()));
            multipart.addBodyPart(messageBodyPart);

            // 发送完整消息
            message.setContent(multipart);

            // 设置消息体
            // message.setText("This is actual message");
            // 保存邮件
            message.saveChanges();
            // 发送消息
            Transport.send(message,message.getAllRecipients());
            //Transport.close();
            System.out.println("Sent message successfully....from w3cschool.cc");
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
