package com.lz.util;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.lz.util.date.DateUtil;
import com.lz.util.file.FileUtil;
import org.apache.log4j.Logger;
import org.springframework.transaction.CannotCreateTransactionException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class ConstUtil implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Map<String,String> userInfo =  new HashMap<String,String>();   //用户登录信息

    protected static final Logger controllerDebug = Logger.getLogger("controllerDebug");
    protected static final Logger controllerError = Logger.getLogger("controllerError");
    protected static final Logger serviceError = Logger.getLogger("serviceError");
    protected static final Logger daoError = Logger.getLogger("daoError");

    public static final String PAGE_CODE = "code";
    public static final int PAGE_CODE_SUCCESS = 200;
    public static final int PAGE_CODE_RELOGIN = 300;
    public static final int PAGE_CODE_FAIL = 500;
    public static final String PAGE_IS_SUCCESS = "isSuccess";
    public static final boolean PAGE_IS_SUCCESS_SUCCESS = true;
    public static final boolean PAGE_IS_SUCCESS_FAIL = false;
    public static final String PAGE_MESSAGE = "message";
    public static final String PAGE_RESULT = "result";
    public static final String PAGE_PAGE_INFO="pageInfo";

   // public static final String SYS_FILE_HEAD_PATH = "/PaaS/app/saferycomdev/files/";

    //window 分盘；
    public static final String SYS_FILE_HEAD_PATH = "D:/PaaS/app/saferycomdev/files/";
    public static final String CLIENT_PC_INFO_PATH = "pcinfo";
    public static final String WARNING_PATH = "warn";
    public static final String UPLOAD_PDF_LOG = "uploadPdfLog";
    /**
     * 新增时,使用数据库日期函数
     * */
    public static String getSysDate(){

        return "SYSDATE";
    }

/*    *//**
     * 数据库日期数值转为yyyy-MM-dd
     * *//*
    public static String dateFormat(Object obj){
        return dateFormat("yyyy-MM-dd",obj);
    }

    *//**
     * 数据库日期时间数值转为yyyy-MM-dd HH:mm:ss
     * *//*
    public static String dateTimeFormat(Object obj){
        return dateFormat("yyyy-MM-dd HH:mm:ss",obj);
    }*/

 /*   *//**
     * 日期数值转为指定格式
     * *//*
    public static String dateFormat(String format,Object obj){
        if(obj==null||"".equals(obj))
            return "";
        try{
            if(obj instanceof Date){
                Date date = (Date)obj;
                return DateUtil.dateFormat(date, format);
            }else if(obj instanceof oracle.sql.TIMESTAMP){
                Class<?> clz = obj.getClass();
                Method m = clz.getMethod("timestampValue");
                Timestamp ts =(Timestamp) m.invoke(obj);

                return DateUtil.dateFormat(ts, format);
            }else
                return DateUtil.dateFormat(DateUtil.strFormat(obj+"", format),format);
        }catch (Exception e) {
            return "";
        }
    }
*/
    /**
     * 错误信息组合
     * */
    public static void controllerDebug(String msg){
        controllerDebug.debug( msg);
    }

    /**
     * 错误信息组合
     * */
    public static String controllerError(String msg,Throwable t){
        controllerError.error( msg, t);
        return "[CONTROLLER]"+msg;
    }

    /**
     * 错误信息组合
     * */
    public static String controllerError(String msg){
        controllerError.error(msg);
        return "[CONTROLLER]"+msg;
    }

    /**
     * 错误信息组合
     * */
    public static String serviceError(String msg,Throwable t){
        serviceError.error( msg, t);
        return "[SERVICE]"+msg;
    }

    /**
     * 错误信息组合
     * */
    public static String serviceError(String msg){
        serviceError.error(msg);
        return "[SERVICE]"+msg;
    }

    /**
     * 错误信息组合
     * */
    public static String daoError(String msg,Throwable t){
        daoError.error( msg, t);
        return "[DAO]"+msg;
    }

    /**
     * 错误信息组合
     * */
    public static String daoError(String msg){
        daoError.error(msg);
        return "[DAO]"+msg;
    }

    /**
     * 控制是否输出错误信息
     * */
    public static void printStackTrace(Exception e){
        if(e instanceof CannotCreateTransactionException)
            System.out.println("连接数据库失败!");
        e.printStackTrace();
    }

    /**
     * 获取分页数据
     * */
    public static JSONObject getPageInfo(int curPage, int curPageCount, long totalCount){
        JSONObject pageInfo = new JSONObject(4);
        pageInfo.put("totalCount",totalCount);
        if(totalCount/curPageCount<1)
            pageInfo.put("totalPage",1);
        else if(totalCount%curPageCount==0)
            pageInfo.put("totalPage",totalCount/curPageCount);
        else
            pageInfo.put("totalPage",totalCount/curPageCount+1);//整数相除,直接舍弃小数位,保留整数(不进行四舍五入换算)
        pageInfo.put("curPage",curPage);
        pageInfo.put("curPageCount",curPageCount);
        return pageInfo;
    }






    /**
     * 清除userInfo中相应的值
     * @param token
     * 			当前 token 值
     * */
    public static void clearUserInfo(String token){

        if(!CommUtils.isNotEmpty(token))
            return;

        if(userInfo.containsKey(token))
            userInfo.remove(token);
    }


    /**
     * 页面提示信息
     * */
    public static void printPageMsg(HttpServletResponse response, Object msg) throws Exception{
        //response.setHeader("Content-Type", "text/html;charset=UTF-8");
        /*支持跨域访问*/
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Allow-Headers", "*");

        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter pw = response.getWriter();
        pw.print(JSON.toJSONString(msg, SerializerFeature.WriteNullStringAsEmpty));//用于实现null字段也能返回
        //pw.print(msg);
        pw.flush();
        if (pw != null) {
            pw.close();
        }
    }

    public static void printPageFile(HttpServletResponse response, byte[] data, String fileName, String fileSuffix, String type) throws Exception{
        //0 下载;1 在线预览
        if(CommUtils.equalsIgnoreCase("0",type)){
            response.setContentType("application/x-download charset=UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + (CommUtils.isNotEmpty(fileName)?URLEncoder.encode(fileName, "utf-8"):"") +(CommUtils.isNotEmpty(fileSuffix)?"."+fileSuffix:""));
        }else{
            if(CommUtils.equalsIgnoreCase("js",fileSuffix)){
                response.setContentType("application/x-javascript");
            }else if(CommUtils.equalsIgnoreCase("PDF",fileSuffix)){
                response.setContentType("application/pdf");
            }else if(fileSuffix.matches("(jpg|jpeg|jfif|jpe)")){
                response.setContentType("image/jpeg");
            }else if(fileSuffix.matches("(png)")){
                response.setContentType("image/png");
            }else if(CommUtils.equalsIgnoreCase("GIF",fileSuffix)){
                response.setContentType("image/gif");
            }else if(fileSuffix.matches("^.*\\.emf$")){
                response.setContentType("application/x-emf");
            }else if(fileSuffix.matches("^.*\\.(doc|docx)$")){
                response.setContentType("application/msword");
            }else if(CommUtils.equalsIgnoreCase("TIF",fileSuffix)){
                response.setContentType("application/x-tif");
            }else if(CommUtils.equalsIgnoreCase("json",fileSuffix)){
                response.setContentType("application/json");
            }else if(CommUtils.isNotEmpty(fileSuffix)){
                response.setContentType("text/"+fileSuffix);
            }else {
                response.setContentType("application/octet-stream");
            }
        }

        OutputStream os = null;
        try {
            os = response.getOutputStream();
            response.setBufferSize(data.length);
            os.write(data);
            os.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            data = null;
            FileUtil.closeStream(os);
        }
    }

    /**
     * 模拟返回HTTP请求错误信息
     * */
    public static void sendError(HttpServletResponse response, String status, String msg) throws Exception{
        if(CommUtils.isNotEmpty(status))
            status="500";
        sendError(response,Integer.parseInt(status), msg);
    }
    /**
     * 模拟返回HTTP请求错误信息
     * */
    public static void sendError(HttpServletResponse response, int status, String msg) throws Exception{
        response.sendError(status,msg);
    }

    /**
     * 获取纳秒
     * */
    public static String getNanoTime(){
        return System.nanoTime()+"";
    }

    public static void main(String[] args)throws Exception{
        System.out.println(getPageInfo(1,10,0).toJSONString());
        System.out.println(getPageInfo(1,10,18).toJSONString());
        System.out.println(getPageInfo(1,10,20).toJSONString());

    }

}
