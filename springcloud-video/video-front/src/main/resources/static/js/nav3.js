var isLogin=false;
$(function () {
    var v_navHtml = '<nav class="navbar navbar-inverse navbar-fixed-top">'+
        '<div class="container-fluid">'+
        '<div class="navbar-header">'+
        '<div id="img"></div>'+
        '</div>'+
        '<div id="navbar" class="navbar-collapse collapse">'+
        '<div class="header-top-right">'+
        '<div class="file">'+
        '<a href="UserCenter.html">个人中心</a>'+
        '</div>'+
        '<div class="signin">'+
        '<a href="register.html">注册</a>'+
        '</div>'+
        '<div class="signin" id="loginInfo" >'+
        '<a href="login.html">登录</a>'+
        '</div>'+
        '<div class="clearfix"> </div>'+
        '</div>'+
        '</div>'+
        '<div class="clearfix"> </div>'+
        '</div>'+
        '</nav>';

    $("#navDiv").html(v_navHtml);
    //像请求头中赋值
    $.ajaxSetup({
        beforeSend: function(xhr) {
            var token = window.sessionStorage.getItem("userId");
            console.log("token:"+token);
            if (token!="null"){
                xhr.setRequestHeader("userId",token);
            }


        }
    });




//查询用户是否已登录
    $.ajax({
        url:"http://192.168.12.61:8089/video_user/user/getUser",
        type:"post",
        dataType:"json",
        async:false,
        success:function (data) {
            if (data.status == 200){
                isLogin = true;
                $("#loginInfo").html("");
                $("#loginInfo").append('<a href="javascript::" onclick="loginOut()">退出</a>');

                if (data.data.userPath!="" && data.data.userPath!=undefined){
                    $("#img").html("<img src='http://192.168.12.61:8000/"+data.data.userPath+"' style=\"width:50px; height:50px; border-radius:50%; \"/>&nbsp;&nbsp;&nbsp;")
                } else {
                    $("#img").html("<font size='4'>木有头像</font>&nbsp;&nbsp;&nbsp;")
                }

                if (data.data.userStatus==0){
                    $("#img").append("<font size='4'>用户:"+data.data.userName+"</font>");
                } else{
                    $("#img").append("<font size='4'>会员:"+data.data.userName+"</font>&nbsp;<img src='/images/timg.jfif' width='35px'/>");
                }


            }
        }

    });

});


//退出登陆
function loginOut(){
    $.post(
        "http://192.168.12.61:8089/video_user/user/loginOut",
        function(data){
            if(data.status==200){
                window.location.href="/movies.html"
            }
        }
    )
}









