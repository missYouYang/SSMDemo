package com.lz.model;

import java.io.Serializable;

/**
 * @Description: TODO
 * @Author AZT
 * @Date 2019/10/9
 **/
public abstract class DataBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private int curPage;            //页面分页时使用,记录当前需要展示的数据页码
    private int curPageCount;       //页面分页时使用,记录每页显示个数
    private int startRow;           //页面分页时使用,记录开始行数
    private String dataId;          //操作数据ID
    private String rowId;           //mybatis操作返回的字段
    private String operId;          //创建人
    private String operName;        //创建人名称
    private String createTime;      //创建时间
    private String updateUserId;    //最后修改人
    private String updateUserName;  //最后修改人名称
    private String updateTime;      //最后更新时间
    private String deleteFlg;       //删除状态,-1 删除;1 正常
    private String fileSuffx;       //文件后缀(不带“.”)
    private Object obj;             //扩展字段
    private String dataState;
    private String state;
    private int status;
    private String type;
    private String startTime;
    private String endTime;

    private String searchLike;
    private String searchDataState;
    private String searchState;
    private String searchStatus;
    private String searchType;

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        setStartRow((curPage-1)*curPageCount);
        this.curPage = curPage;
    }

    public int getCurPageCount() {
        return curPageCount;
    }

    public void setCurPageCount(int curPageCount) {
        setStartRow((curPage-1)*curPageCount);
        this.curPageCount = curPageCount;
    }

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public String getOperId() {
        return operId;
    }

    public void setOperId(String operId) {
        this.operId = operId;
    }

    public String getOperName() {
        return operName;
    }

    public void setOperName(String operName) {
        this.operName = operName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getDeleteFlg() {
        return deleteFlg;
    }

    public void setDeleteFlg(String deleteFlg) {
        this.deleteFlg = deleteFlg;
    }

    public String getFileSuffx() {
        return fileSuffx;
    }

    public void setFileSuffx(String fileSuffx) {
        this.fileSuffx = fileSuffx;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public String getDataState() {
        return dataState;
    }

    public void setDataState(String dataState) {
        this.dataState = dataState;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getSearchLike() {
        return searchLike;
    }

    public void setSearchLike(String searchLike) {
        this.searchLike = searchLike;
    }

    public String getSearchDataState() {
        return searchDataState;
    }

    public void setSearchDataState(String searchDataState) {
        this.searchDataState = searchDataState;
    }

    public String getSearchState() {
        return searchState;
    }

    public void setSearchState(String searchState) {
        this.searchState = searchState;
    }

    public String getSearchStatus() {
        return searchStatus;
    }

    public void setSearchStatus(String searchStatus) {
        this.searchStatus = searchStatus;
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public abstract String getModuleName();
    public abstract String getModuleInfo();
}
