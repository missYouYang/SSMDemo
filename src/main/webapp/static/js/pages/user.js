$('#table').bootstrapTable('destroy').bootstrapTable({
    url: '../user/selectUsrList',
    method: 'post',
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
            sortOrder: params.order //排位命令（desc，asc）
        }
        return temp;
    },
    columns: [
        {
            checkbox: true
        },{
            field: 'userName',
            title:'用户名',
            valign: 'middle',
            width: '16%',
            sortable: true
        },{
            field: 'userPassword',
            title:'姓名',
            width: '16%'
        },{
            field: 'userPhone',
            title:'电话号码',
            width: '16%'
        },{
            field: 'userSex',
            title:'性别',
            valign: 'middle',
            width: '16%'
        },{
            field: 'createUser',
            title:'创建者',
            width: '16%'
        }
    ],
});

function getSelectValue(){
    var a = $table.bootstrapTable('getSelections');//获取选中行的数据
    if(a.length > 0){
        console.log(a);
    }
}

/*按钮的操作 清空input*/
function btn_empty() {
    $(".body_solr .body_name").val("");
}

function btn_search() {

    console.log($("input[name='userName']").val());
    console.log($("input[name='userTel']").val());
}
/*点击按钮搜索*/