
var userName;
var userPhone;
function btn_search() {
    userName = $("input[name='userName']").val();
    userPhone = $("input[name='userTel']").val();
    $("#table").bootstrapTable("refresh");
}

$('#table').bootstrapTable('destroy').bootstrapTable({
    url: '../user/selectUsrList',
    method: 'post',
    dataType:'json',
    contentType:'application/x-www-form-urlencoded; charset=UTF-8',
    uniqueId: 'userId',                        // 绑定ID，不显示
    striped: false,                         //是否显示行间隔色
    cache: false,                          //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
    sortable: true,                        //是否启用排序
    sortOrder: "asc",                      //排序方式
    sidePagination: "client",              //分页方式：client客户端分页，server服务端分页（*）
    undefinedText: '--',
    clickToSelect: true,                   // 点击选中行
    pagination: true,                      //是否显示分页
    pageNumber:1,                          //初始化加载第一页，默认第一页,并记录
    pageSize:10,//每页显示的数量
    pageList: [10, 20, 50, 100],//设置每页显示的数量
    paginationPreText:"上一页",
    paginationNextText:"下一页",
    paginationLoop:false,
    height:489,
    data_local: "zh-US",
    showHeader:true,
    queryParams : function (params) {
        var temp = {
            rows: params.limit,                         //页面大小
            page: (params.offset / params.limit) + 1,   //页码
            sort: params.sort,      //排序列名
            sortOrder: params.order,//排位命令（desc，asc）
            userName:userName,
            userPhone:userPhone
        }
        return temp;
    },
    columns: [
        {
            checkbox: true,
            width:50
        },{
            field: 'userPassword',
            title: '姓名',
            align: 'center',
            colspan: 1,
            width:100

        },
        {
            field: 'userName',
            title:'用户名',
            align: 'center',
            colspan: 1,
            width:100
        },{
            field: 'userSex',
            title:'性别',
            align: 'center',
            colspan: 1,
            width:100
        },{
            field: 'userPhone',
            title:'电话号码',
            align: 'center',
            colspan: 1,
            width:100
        },{
            field: 'createUser',
            title:'创建者',
            align: 'center',
            colspan: 1,
            width:100
        }
    ],
});

/*function getSelectValue(){
    var a = $table.bootstrapTable('getSelections');//获取选中行的数据
    if(a.length > 0){
        console.log(a);
    }
}*/

/*按钮的操作 清空input*/
function btn_empty() {
    $(".body_solr .body_name").val("");
}


/*点击按钮搜索*/