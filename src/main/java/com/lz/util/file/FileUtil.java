package com.lz.util.file;

import java.io.*;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * 文件处理工具类
 */
public class FileUtil implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 读取文件
     * @param filePath
     * 			文件不存在时,会抛出异常
     * @return byte[]
     * */
    public static byte[] bufferRead(String filePath) throws Exception {
        return LocalFileUtil.bufferRead(filePath);
    }

    /**
     * 读取文件
     * @param filePath
     * 			文件不存在时,会抛出异常
     * @return String
     * 			BASE64加密字符串
     * */
    public static String base64Read(String filePath) throws Exception {
        byte [] buffer = null;
        buffer = LocalFileUtil.bufferRead(filePath);
        return BaseUtil.encoding(buffer);
    }

    /**
     * 数据写入文件(覆盖式)
     * @param str
     * 			二进制数据
     * @param filePath
     * 			文件路径,不存在时会创建
     * */
    public static void stringWrite(String str,String filePath) throws Exception {
        if(str==null)
            throw new Exception("文件内容不允许为空!");

        bufferWrite(str.getBytes("utf-8"),filePath,false);
    }

    /**
     * 数据写入文件(覆盖式)
     * @param buffer
     * 			二进制数据
     * @param filePath
     * 			文件路径,不存在时会创建
     * */
    public static void bufferWrite(byte [] buffer,String filePath) throws Exception {
        bufferWrite(buffer,filePath,false);
    }

    /**
     * 数据写入文件
     * @param buffer
     * 			二进制数据
     * @param filePath
     * 			文件路径,不存在时会创建
     * @param isAddEndum
     * 			当文件存在时,是否追加内容
     * */
    public static void bufferWrite(byte [] buffer,String filePath,boolean isAddEndum) throws Exception {
        LocalFileUtil.mkdirs(filePath,true);
        LocalFileUtil.bufferWrite(filePath, buffer, isAddEndum);
    }

    /**
     * BASE64数据写入文件(覆盖式)
     * @param base64
     * 			BASE64加密字符串
     * @param filePath
     * 			文件路径,不存在时会创建
     * */
    public static void base64Write(String base64,String filePath) throws Exception {
        base64Write(base64,filePath,false);
    }

    /**
     * 删除文件
     * @param filePath
     * 			文件及路径
     * */
    public static void deleteFile(String filePath) throws Exception {
        LocalFileUtil.deleteFile(filePath);
    }

    /**
     * BASE64数据写入文件
     * @param base64
     * 			BASE64加密字符串
     * @param filePath
     * 			文件路径,不存在时会创建
     * @param isAddEndum
     * 			当文件存在时,是否追加内容
     * */
    public static void base64Write(String base64,String filePath,boolean isAddEndum) throws Exception {
        byte [] buffer = null;
        buffer = BaseUtil.decoding(base64);
        LocalFileUtil.mkdirs(filePath);
        LocalFileUtil.bufferWrite(filePath, buffer, isAddEndum);
    }

    /**
     * 判断文件或路径是否存在
     * @param path
     * 			文件或目录结构
     * @return boolean
     * 			true 存在;false 不存在
     * */
    public static boolean exists(String path) {

        return LocalFileUtil.exists(path);
    }

    /**
     * 返回文件不带“.”的后缀
     * @param fileName
     * 			文件名称
     * */
    public static String getSuffix(String fileName,String defaultSuffix){
        String fileSuffix = getSuffix(fileName);
        if("".equals(fileSuffix))
            return defaultSuffix;
        else
            return fileSuffix;
    }

    /**
     * 返回文件不带“.”的后缀
     * @param fileName
     * 			文件名称
     * */
    public static String getSuffix(String fileName){
        if(fileName.lastIndexOf(".")>0)
            return fileName.substring(fileName.lastIndexOf(".")+1);
        return "";
    }

    /**
     * 返回不带后缀文件名称
     * @param filePath
     * 			文件路径
     * */
    public static String getFileName(String filePath){
        if(filePath==null)
            return "";

        File file = new File(filePath);
        String fileName = file.getName();
        if(!"".equals(fileName)&&fileName.lastIndexOf(".")>0)
            return fileName.substring(0, fileName.lastIndexOf("."));
        else if(!"".equals(fileName))
            return fileName;

        return "";
    }

    /**
     * 支持关闭流,目前支持关闭：
     * io:FileInputStream,FileOutputStream,
     * ByteArrayInputStream,ByteArrayOutputStream,
     * InputStream,OutputStream,
     * FileReader,FileWriter,
     * BufferedReader,BufferedWriter,
     * InputStreamReader,OutputStreamWriter,
     * BufferedInputStream,BufferedOutputStream,
     * Reader,Writer
     * PrintWriter,PrintStream
     * ZipInputStream,ZipOutputStream
     * */
    public static void closeStream(Object obj){
        if(obj == null)
            return;

        try{
            if(obj instanceof FileInputStream){
                ((FileInputStream) obj).close();
            }else if(obj instanceof FileOutputStream){
                ((FileOutputStream) obj).close();
            }else if(obj instanceof ByteArrayInputStream){
                ((ByteArrayInputStream) obj).close();
            }else if(obj instanceof ByteArrayOutputStream){
                ((ByteArrayOutputStream) obj).close();
            }else if(obj instanceof InputStream){
                ((InputStream) obj).close();
            }else if(obj instanceof OutputStream){
                ((OutputStream) obj).close();
            }else if(obj instanceof FileReader){
                ((FileReader) obj).close();
            }else if(obj instanceof FileWriter){
                ((FileWriter) obj).close();
            }else if(obj instanceof BufferedReader){
                ((BufferedReader) obj).close();
            }else if(obj instanceof BufferedWriter){
                ((BufferedWriter) obj).close();
            }else if(obj instanceof InputStreamReader){
                ((InputStreamReader) obj).close();
            }else if(obj instanceof OutputStreamWriter){
                ((OutputStreamWriter) obj).close();
            }else if(obj instanceof BufferedInputStream){
                ((BufferedInputStream) obj).close();
            }else if(obj instanceof BufferedOutputStream){
                ((BufferedOutputStream) obj).close();
            }else if(obj instanceof Reader){
                ((Reader) obj).close();
            }else if(obj instanceof Writer){
                ((Writer) obj).close();
            }else if(obj instanceof PrintWriter){
                ((PrintWriter) obj).close();
            }else if(obj instanceof PrintStream){
                ((PrintStream) obj).close();
            }else if(obj instanceof ZipInputStream){
                ((ZipInputStream) obj).closeEntry();
                ((ZipInputStream) obj).close();
            }else if(obj instanceof ZipOutputStream){
                ((ZipOutputStream) obj).close();
            }
            obj = null;
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
