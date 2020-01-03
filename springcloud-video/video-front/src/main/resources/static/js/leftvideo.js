$(function () {
    var v_leftVideo="<div class=\"col-sm-3 col-md-2 sidebar show-grid-right\">\n" +
        "<div class=\"layui-col-md12\">\n" +
        "<div class=\"grid-demo grid-demo-bg1\" id=\"filePath\">\n" +
        "</div>\n" +
        "</div>\n" +
        "<div style=\"height:180px;\"></div>\n" +
        "<div class=\"layui-col-md12\">\n" +
        "<h3 id=\"movieName\"></h3>\n" +
        "<p id=\"movieInfo\"><b><font color=\"red\" ></font></b></p><br/>\n" +
        "<div id=\"accDiv\"></div>\n" +
        "</div>\n" +
        "</div>";
    $("#leftVideoDiv").html(v_leftVideo);
    initProductList();
});
var imgUrls="http://192.168.12.61:8000/";
var imgUrlsa="/videoShow.html";

function showvideo(id,movieId){
    window.sessionStorage.setItem("accessoryId" ,id );
    window.sessionStorage.setItem("movieId" ,movieId );
    location.href=imgUrlsa;
}
function initProductList(){
    var token = window.localStorage.getItem("movieId");
    $.post(
        "http://192.168.12.61:8089/video_movie/moviec/initNum",
        {"movieId":token},
        function (rest) {
            if(rest.status==200){
                var movie =rest.data;
                $("#movieName").text("影视名称:"+movie.movieName);
                $("#movieInfo").text("影视简介:"+movie.movieIntro);
                $("#filePath").append(
                    '<img src="'+imgUrls+movie.filePath+'" style="height: 300px">'
                );
                initNumberList(token);
            }
        }
    )
}
function initNumberList(id){
    $.post(
        "http://192.168.12.61:8089/video-accessory/accessory/queryList2",
        {"id":id},
        function (data) {
            if(data.status==200){
                var list = data.data;
                var str = "";
                for (var i = 0; i < list.length; i++) {
                    var listElement = list[i].accessoryNumber;
                    var ListMovie = list[i].accessoryId;
                    str +='<div style="height:40px; width:40px;margin-right:10px;float: left;   background:darkgreen">' +
                        '<h3 align="center" style="margin-top: 5px">' +
                        '<a href="javascript:void(0);" onclick="showvideo('+ ListMovie +','+ id +')">'+listElement+'</a></h3>' +
                        '</div>\n';
                    $("#accDiv").html(str);
                }
            }

        }
    )
}