function user_login () {
    $("#login_error").text("");
    if($("#userName").val() == null || $("#userName").val() == ''){
        $("#username_error").text("用户名不能为空");
        return false;
    }else{
        $("#username_error").text("");
    }

    if($("#password").val() == null || $("#password").val() == ''){
        $("#password_error").text("密码不能为空");
        return false;
    }else {
        $("#password_error").text("");
    }
    $.ajax({
        async:false,
        url:"user/userLogin",
        type:"post",
        dataType:"json",
        contentType:"application/json;charset=utf-8",
        data:JSON.stringify({
            "userName":$("#userName").val(),
            "userPassword":$("#password").val()
        }),
        success:function (data) {
            if(data.isSuccess == true){
                window.location.href="user/rest?url=pages/home";
            }else{
                console.log(data);
                $("#login_error").text(data.msg);
            }
        },
        error:function (data) {
            alert(data.msg);
        }
    });
}