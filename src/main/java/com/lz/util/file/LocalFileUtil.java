package com.lz.util.file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author 孙阳阳
 * @Date 2019/10/9
 **/
public class LocalFileUtil {

    private static final long serialVersionUID = 1L;

    /**
     * 读取文件
     * @param filePath
     * 			文件路径
     * @return byte[]
     * 			返回数据
     * */
    public static byte[] bufferRead(String filePath) throws Exception {
        FileInputStream fis = null;
        byte [] data = null;
        try{
            fis = new FileInputStream(filePath);
            data = new byte [fis.available()];
            fis.read(data);
        }finally{
            FileUtil.closeStream(fis);
        }
        return data;
    }

    /**
     * 按行读取文件
     * @param data
     * 			文件数据byte[]
     * @return List<String>
     * 			返回行数据集合
     * */
    public static List<String> lineReadFile(byte[] data) throws Exception {
        ByteArrayInputStream bais = null;
        try{
            bais = new ByteArrayInputStream(data);
            return lineReadFile(bais,"UTF-8");
        }finally{
            FileUtil.closeStream(bais);
        }
    }

    /**
     * 按行读取文件,默认:UTF-8
     * @param filePath
     * 			文件路径
     * @param encoding
     * 			字符集
     * @return List<String>
     * 			返回行数据集合
     * */
    public static List<String> lineReadFile(String filePath,String encoding) throws Exception {
        FileInputStream fis = null;
        try{
            fis = new FileInputStream(filePath);
            if(encoding==null||"".equals(encoding))
                encoding = "UTF-8";
            return lineReadFile(fis,encoding);
        }finally{
            FileUtil.closeStream(fis);
        }
    }

    /**
     * 按行读取文件
     * @param is
     * 			读取文件流对象
     * @param encoding
     * 			字符集
     * @return List<String>
     * 			返回行数据集合
     * */
    public static List<String> lineReadFile(InputStream is, String encoding) throws Exception {
        List<String> data = new ArrayList<String>();
        InputStreamReader isr = null;
        BufferedReader br = null;
        try{
            isr = new InputStreamReader(is,encoding);
            br = new BufferedReader(isr);
            String resultStr = null;
            while((resultStr=br.readLine())!=null){
                data.add(resultStr);
            }
        }finally{
            FileUtil.closeStream(br);
            FileUtil.closeStream(isr);
        }
        return data;
    }

    /**
     * 写入文件(覆盖)
     * @param filePath
     * 			文件路径
     * @param is
     * 			读取的文件流
     * */
    public static void writeFile(String filePath,InputStream is) throws Exception {
        byte[] data = new byte[is.available()];
        is.read(data);
        bufferWrite(filePath,data,false);
        data = null;
    }

    /**
     * 写入文件
     * @param filePath
     * 			文件路径
     * @param is
     * 			读取的文件流
     * @param append
     * 			内容写入方式,false 覆盖;true 追加.
     * */
    public static void writeFile(String filePath,InputStream is,boolean append) throws Exception {
        byte[] data = new byte[is.available()];
        is.read(data);
        bufferWrite(filePath,data,append);
        data = null;
    }

    /**
     * 写入文件
     * @param filePath
     * 			文件路径
     * @param data
     * 			文件内容数据
     * @param append
     * 			内容写入方式,false 覆盖;true 追加.
     * */
    public static void bufferWrite(String filePath,byte[] data,boolean append) throws Exception {
        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream(filePath,append);
            fos.write(data);
        }finally{
            FileUtil.closeStream(fos);
        }
    }

    /**
     * 按行写入文件,默认:UTF-8
     * @param filePath
     * 			文件路径
     * @param data
     * 			输入文件的内容
     *@param encoding
     * 			字符集
     * */
    public static void lineWriteFile(String filePath,List<String> data,String encoding) throws Exception {
        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream(filePath);
            if(encoding==null||"".equals(encoding))
                encoding = "UTF-8";
            lineWriteFile(fos, data,encoding);
        }finally{
            FileUtil.closeStream(fos);
        }
    }

    /**
     * 按行写入文件
     * @param os
     * 			输入文件流对象
     * @param data
     * 			内容数据
     * @param encoding
     * 			字符集
     * */
    public static void lineWriteFile(OutputStream os,List<String> data,String encoding) throws Exception {
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try{
            osw = new OutputStreamWriter(os,encoding);
            bw = new BufferedWriter(osw);
            for(String str:data){
                bw.write(str);
                bw.newLine();
            }
        }finally{
            FileUtil.closeStream(bw);
            FileUtil.closeStream(osw);
        }
    }

    /**
     * 删除文件
     * @param filePath
     * 			文件及路径
     * */
    public static void deleteFile(String filePath) throws Exception {
        if(exists(filePath)){
            File file = new File(filePath);
            file.delete();
            file = null;
        }
    }

    /**
     * 本地目录拷贝文件
     * @param sourcePath
     * 			源文件
     * @param tagertPath
     * 			目标文件
     * */
    public static void copy(String sourcePath,String tagertPath) throws Exception {
        byte[] data = bufferRead(sourcePath);
        bufferWrite(tagertPath, data, false);
        data = null;
    }

    /**
     * 获取路径下的所有文件名称(含层级)
     * @param path
     * 			路径
     * @param fileList
     * 			保存数据集合
     * */
    public static void fileList(String path,List<String> fileList) throws Exception {
        if(fileList==null)
            return;
        List<String> dirList = new ArrayList<String>();
        listFiles(path, 1, fileList);//获取当前路径下的所有文件名称
        dirList(path,dirList);//获取所有文件夹名称
        List<String> files = new ArrayList<String>();
        for(int i=0;i<dirList.size();i++){
            files.clear();
            listFiles(path+"/"+dirList.get(0), 1, files);//获取所有文件夹名称
            for(String file:files)
                fileList.add(dirList.get(0)+"/"+file);
            dirList.remove(i);
            i--;
        }
        dirList.clear();
        files.clear();
        dirList = null;
        files = null;
    }

    /**
     * 获取路径下的所有文件夹名称(含层级)
     * @param path
     * 			路径
     * @param dirList
     * 			保存数据集合
     * */
    public static void dirList(String path,List<String> dirList) throws Exception {
        if(dirList==null)
            return;
        List<String> dirTemp = new ArrayList<String>();
        listFiles(path, 2, dirTemp);//获取所有文件夹名称
        List<String> dir = new ArrayList<String>();
        for(int i=0;i<dirTemp.size();i++){
            dirList.add(dirTemp.get(0));
            dir.clear();
            listFiles(path+"/"+dirTemp.get(0), 2, dir);//获取所有文件夹名称
            for(String d:dir)
                dirTemp.add(dirTemp.get(0)+"/"+d);
            dirTemp.remove(i);
            i--;
        }
        dirTemp.clear();
        dir.clear();
        dirTemp = null;
        dir = null;
    }

    /**
     * 获取当前路径下文件及文件夹的名称
     * @param path
     * 			路径
     * @param type
     * 			获取类型,0 文件及文件夹名称;1 文件名称;2 文件夹名称
     * @param listFiles
     * 			保存数据集合
     * */
    public static void listFiles(String path,int type,List<String> listFiles) throws Exception {
        if(listFiles==null)
            return;
        File f = new File(path);
        File[] files = f.listFiles();
        for(File file:files){
            if(type==0)
                listFiles.add(file.getName());
            else if(type==1&&file.isFile())
                listFiles.add(file.getName());
            else if(type==2&&file.isDirectory())
                listFiles.add(file.getName());
        }
    }

    /**
     * 判断文件或路径是否存在
     * @param path
     * 			文件或目录结构
     * @return boolean
     * 			true 存在;false 不存在
     * */
    public static boolean exists(String path){
        File file = new File(path);
        if(file.exists())
            return true;
        return false;
    }

    /**
     *创建文件路径,支持路径中包含文件
     *传入路径不包含文件,若路径最后一级中包含“.”,请在最后加入“/”,如:/work/dd.bb/
     *@param  path
     *			路径
     * */
    public static void mkdirs (String path){

        mkdirs (path,false);
    }

    /**
     *创建文件路径,支持路径中包含文件
     *传入路径不包含文件,若路径最后一级中包含“.”,请在最后加入“/”,如:/work/dd.bb/
     *@param  path
     *			路径
     * @param 	flag
     * 			文件是否无后缀
     * */
    public static void mkdirs (String path,boolean flag){

        if(exists(path)){return;}

        File file = null;
        if(path.matches("(.*)[.][0-9a-zA-Z]+")||flag){
            file = new File(path);
            path = path.substring(0,path.length()-file.getName().length());
        }
        file = new File(path);
        file.mkdirs();
    }
}
