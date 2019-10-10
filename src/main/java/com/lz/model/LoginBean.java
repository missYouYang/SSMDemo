package com.lz.model;

/**
 * @Description: TODO
 * @Author AZT
 * @Date 2019/10/9
 **/
public class LoginBean extends DataBean{

    private static final long serialVersionUID = 1L;
    private String userID;          //用户工号
    private String pwd;             //工号密码

    private String searchUserID;
    private String searchPwd;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        setDataId(userID);//用于系统记录操作时定位到具体数据
        this.userID = userID;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getSearchUserID() {
        return searchUserID;
    }

    public void setSearchUserID(String searchUserID) {
        setDataId(searchUserID);//用于系统记录操作时定位到具体数据
        this.searchUserID = searchUserID;
    }

    public String getSearchPwd() {
        return searchPwd;
    }

    public void setSearchPwd(String searchPwd) {
        this.searchPwd = searchPwd;
    }

    public String getModuleName(){
        return "登录管理";
    }
    public String getModuleInfo(){
        return "登录";
    }
}
