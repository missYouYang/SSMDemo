package com.lz.util.file;

import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * @Description: 此类中提供对字符串进行Base64编码及解码 支持JDK6和8,根据系统JDK版本自动切换
 * @Author 孙阳阳
 * @Date 2019/10/9
 **/
public class BaseUtil {


    private static final long serialVersionUID = 1L;
    private static final String java_ver = System.getProperty("java.version"); //获取JDK版本
    private static final String java_bit = System.getProperty("sun.arch.data.model"); //获取版本位(32/64位)

    public static String encoding(String msg) throws UnsupportedEncodingException {

        return encoding(msg,"UTF-8");
    }

    public static String encoding(byte[] data){

        if(java_ver.contains("1.8."))
            return jdk8Encoding(data);
        else
            return jdk6Encoding(data);
    }

    public static String encoding(String msg,String charset) throws UnsupportedEncodingException {

        if(java_ver.contains("1.8."))
            return jdk8Encoding(msg.getBytes(charset));
        else
            return jdk6Encoding(msg.getBytes(charset));
    }

    public static byte[] decoding(String base)  {

        if(java_ver.contains("1.8."))
            return jdk8Decoding(base);
        else
            return jdk6Decoding(base);
    }

    public static String decoding(String base,String charset) throws UnsupportedEncodingException {

        if(!CommUtils.isNotEmpty(charset))
            charset = "UTF-8";
        if(java_ver.contains("1.8."))
            return new String(jdk8Decoding(base),charset);
        else
            return new String(jdk6Decoding(base),charset);
    }

    /**================JDK1.8 编码/解码================**/
    private static String jdk8Encoding(byte[] data){

        return Base64.getEncoder().encodeToString(data);
    }

    private static byte[] jdk8Decoding(String base){

        return Base64.getDecoder().decode(base);
    }

    /**================JDK1.6 编码/解码================**/
    private static String jdk6Encoding(byte[] data){

        return DatatypeConverter.printBase64Binary(data);
    }

    private static byte[] jdk6Decoding(String base){

        return DatatypeConverter.parseBase64Binary(base);
    }
}
