package com.lz.util.file;

import com.lz.model.DataBean;
import com.lz.model.LoginBean;

import java.io.BufferedReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.math.RoundingMode;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description:
 * @Author 孙阳阳
 * @Date 2019/10/9
 **/
public class CommUtils {

    private static final long serialVersionUID = 1L;

    /**
     * 保留两位小数(非四舍五入)
     * */
    public static String doubleFormat(double num){
        return doubleFormat(num,true);
    }

    static DecimalFormat df =new DecimalFormat("0.00");
    public static String doubleFormat(double num,boolean flag){

        if((""+num).indexOf(".")>-1){
            if(Double.parseDouble((""+num).substring((""+num).indexOf(".")+1))==0)
                return String.format("%.0f",num);
        }else
            return String.format("%.0f",num);

        if(flag)
            df.setRoundingMode(RoundingMode.DOWN);
        return df.format(num);
    }

    /**
     * 字符串转为double,默认值0
     * */
    public static double convertDobule(Object obj){
        if(isNotEmpty(obj)){
            try{
                return Double.parseDouble(obj+"");
            }catch (Exception e) {
                return 0;
            }
        }else
            return 0;
    }

    /**
     * Object类型转为int类型
     * @param obj
     *          需进行转换的值
     * @return
     *          默认返回0
     * */
    public static int convertInt(Object obj){

        return convertInteger(obj,0);
    }

    /**
     * Object类型转为int类型
     * @param obj
     *          需进行转换的值
     * @param defaultNum
     *          报错或=0时指定默认值
     * */
    public static Integer convertInteger(Object obj,int defaultNum){
        Integer num =convertInteger(obj);
        if(num==null||num==0)
            return defaultNum;
        else
            return num;
    }

    /**
     * Object类型转为int类型
     * @param obj
     *          需进行转换的值
     * @return Integer
     *          抛错返回null
     * */
    public static Integer convertInteger(Object obj){
        try{
            return Integer.parseInt(obj+"");
        }catch (Exception e) {
            return null;
        }
    }

    /**
     * 祛掉第一个字符
     * */
    public static String delFirstChar(String str){
        StringBuffer sb = new StringBuffer(str);
        delFirstChar(sb);
        return sb.toString();
    }

    /**
     * 祛掉第一个字符
     * */
    public static void delFirstChar(StringBuffer sb){
        if(isNotEmpty(sb))
            sb.deleteCharAt(0);
    }

    /**
     * 祛掉最后一个字符
     * */
    public static String delLastChar(String str){
        StringBuffer sb = new StringBuffer(str);
        delLastChar(sb);
        return sb.toString();
    }

    /**
     * 祛掉最后一个字符
     * */
    public static void delLastChar(StringBuffer sb){
        if(isNotEmpty(sb))
            sb.deleteCharAt(sb.length()-1);
    }

    /**
     * null转成""空字符串
     * */
    public static String convertStr(Object obj){

        return obj==null?"":obj+"";
    }

    /**
     * null转成""空字符串
     * */
    public static String convertStr(Object obj,String defaultValue){
        if(obj==null||"".equals(obj))
            return defaultValue;
        else
            return obj+"";
    }

    /**
     * CLOB转字符串
     * */
    public static String clobToStr(Object obj) throws Exception{

        if(obj==null)
            return "";

        if(obj instanceof java.sql.Clob){
            java.sql.Clob clob = (java.sql.Clob)obj;
            Reader reader = null;
            BufferedReader br = null;
            try{
                StringBuffer sb = new StringBuffer();
                reader = clob.getCharacterStream();
                br = new BufferedReader(reader);
                String lineStr = br.readLine();
                while (lineStr!=null) {
                    sb.append(lineStr);
                    lineStr = br.readLine();
                }
                return sb.toString();
            }finally{
                FileUtil.closeStream(br);
                FileUtil.closeStream(reader);
            }
        }

        return obj==null?"":obj+"";
    }

    /**
     * 汉字转换成URL编码(默认:utf8)
     * */
    public static String encode(String str) throws UnsupportedEncodingException {
        return encode(str,"utf8");
    }

    /**
     * 汉字转换成URL编码
     * */
    public static String encode(String str,String charset) throws UnsupportedEncodingException{
        return URLEncoder.encode(str,charset);
    }

    /**
     * URL编码汉字转换成字符串(默认:utf8)
     * */
    public static String decode(String str) throws UnsupportedEncodingException {
        return decode(str,"utf8");
    }

    /**
     * URL编码汉字转换成字符串
     * */
    public static String decode(String str,String charset) throws UnsupportedEncodingException {
        return URLDecoder.decode(str,charset);
    }

    /**
     *判断传入对象有值
     * */
    public static boolean isNotEmpty(Object obj){
        if(obj==null)
            return false;

        if(obj instanceof String){
            if("".equals(obj))
                return false;
        }else if(obj instanceof StringBuffer){
            if(((StringBuffer)obj).length()==0)
                return false;
        }else if(obj instanceof Integer){
            if(((int)obj)==0)
                return false;
        }else if(obj instanceof Double){
            if(((double)obj)==0)
                return false;
        }else if(obj instanceof Float){
            if(((float)obj)==0)
                return false;
        }else if(obj instanceof Long){
            if(((long)obj)==0)
                return false;
        }else if(obj instanceof List){
            if(((List)obj).isEmpty())
                return false;
        }else if(obj instanceof Map){
            if(((Map)obj).isEmpty())
                return false;
        }

        return true;
    }

    /**
     * 判断传入的不是空对象
     * */
    public static boolean isNotNull(Object obj){
        if(obj==null)
            return false;

        return true;
    }

    /**
     * 若值为空,则返回null,其他则返回原值
     * */
    public static String emptyToNull(Object obj){
        if(obj==null)
            return null;
        if("".equals(obj))
            return null;

        return obj+"";
    }

    /**
     *判断某字符串是为空或长度为0或由空白符(whitespace)构成
     * */
    public static boolean isBlank(CharSequence cs) {
        int strLen;
        if (cs != null && (strLen = cs.length()) != 0) {
            for(int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(cs.charAt(i))) {
                    return false;
                }
            }
            return true;
        } else {
            return true;
        }
    }

    /**
     *判断某字符串是否不为空且长度不为0且不由空白符(whitespace)构成
     * */
    public static boolean isNotBlank(CharSequence cs) {
        return !isBlank(cs);
    }

    /**
     * 转为UTF-8编码
     * */
    public static String parseUTF8(byte[] msg) {
        return parse(msg,"UTF-8");
    }

    /**
     * 转编码
     * */
    public static String parse(byte[] msg,String charset) {
        try {
            return new String(msg,charset);
        }catch (Exception e) {

        }
        return null;
    }

    /**
     * 原对比顺序:字符对比>大写>小写,
     * 故,在非汉字字符串对比情况下,建议使用此方法,稍稍提高一下执行效率
     * */
    public static boolean equalsIgnoreCase(String value1,Object obj){

        String value2 = convertStr(obj);
        return equalsIgnoreCase(value1,value2);
    }

    /**
     * 原对比顺序:字符对比>大写>小写,
     * 故,在非汉字字符串对比情况下,建议使用此方法,稍稍提高一下执行效率
     * */
    public static boolean equalsIgnoreCase(String value1,String value2){
        if(isNotEmpty(value1))
            value1 = value1.toUpperCase();
        else
            value1 = "";

        if (isNotEmpty(value2))
            value2 = value2.toUpperCase();
        else
            value2 = "";

        return value1.equalsIgnoreCase(value2);
    }

    /**
     * 正则提取字符串 regex
     * */
    public static String matcherSubstring(String str,String regex){
        if(!isNotEmpty(str))
            return "";
        if(!isNotEmpty(regex))
            return str;

        Matcher matcher = Pattern.compile(regex).matcher(str);
        if(matcher.find())
            return str.substring(matcher.start(),matcher.end());

        return str;
    }

    /**
     * 替换所有指定字符串
     * */
    public static void replaceAll(StringBuffer sb,String target,String oldChar,String newChar){

        if(sb==null)
            return;
        if(!isNotEmpty(target))
            return;

        sb.setLength(0);
        target = target.replaceAll(oldChar,newChar);
        sb.append(target);
        if(target.indexOf(oldChar)>-1)
            replaceAll(sb,target,oldChar,newChar );
    }

    /**
     * 将字符串的首字母转大写
     * @param str 需要转换的字符串
     * @return
     */
    private static String firstUpperCase(String str) {
        if(!isNotEmpty(str))
            return "";

        char[] cs=str.toCharArray();
        if(cs[0]-32>64)
            cs[0]-=32;
        return String.valueOf(cs);
    }

    /**
     *使用反射取值,验证是否存在值,仅适用于有返回值的方法
     * @param obj
     * 			实体bean
     * @param fieldNames
     * 			方法名称
     * @return String
     * 			验证通过,返回null;反之则返回提示信息
     * */
    public static String validateJavaBean(DataBean obj, String fieldNames) throws Exception {

        if(obj==null)
            return  "实体JavaBean不允许为空!";
        if(!isNotEmpty(fieldNames))
            return "验证实体JavaBean的属性不允许为空!";

        Object value = "";
        for(String field:fieldNames.split(",")){

            if(!field.startsWith("get"))
                value = obj.getClass().getDeclaredMethod("get"+firstUpperCase(field)).invoke(obj);
            else
                value = obj.getClass().getDeclaredMethod(field).invoke(obj);

            if(!isNotEmpty(value))
                return "字段["+field+"]不允许为空!";
        }
        return null;
    }


    public static void main(String[] args) throws Exception {
        StringBuffer a = new StringBuffer();
        a.append("f,d,a,f,a,f,");
        delLastChar(a);
        System.out.println("dd:"+a.toString());
        System.out.println("dd:"+a.deleteCharAt(a.length()-1));
        System.out.println("".split(",")[0]);
        System.out.println(equalsIgnoreCase("1",null));
        String str = "123          45  6  78 8";
        StringBuffer sb = new StringBuffer();
        replaceAll(sb,str,"  "," ");
        System.out.println(sb.toString());
        LoginBean loginBean = new LoginBean();
        loginBean.setSearchPwd("112");
        System.out.println(validateJavaBean(loginBean,"searchPwd,searchUserID"));
        str = "2019-09-03/11:47:22";
        if(str.split("\\/").length==2)
            System.out.println("dd:"+str.replaceAll("\\/"," "));
        System.out.println(firstUpperCase("InterfaceName"));
        System.out.println("http://baidu.com".substring(0,4));
    }
}
