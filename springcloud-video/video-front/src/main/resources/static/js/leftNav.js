$(function () {
    var v_leftNavHtml = '<div class="col-sm-3 col-md-2 sidebar">'+
        '<div class="top-navigation">'+
        '<div class="t-menu">MENU</div>'+
        '<div class="t-img">'+
        '<img src="images/lines.png" alt="" />'+
        '</div>'+
        '<div class="clearfix"> </div>'+
        '</div>'+
        '<div class="drop-navigation drop-navigation">'+
        '<ul class="nav nav-sidebar">'+
        '<li><a href="index.html" class="home-icon"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>Home</a></li>'+
        '<li><a href="shows.html" class="user-icon"><span class="glyphicon glyphicon-home glyphicon-blackboard" aria-hidden="true"></span>TV Shows</a></li>'+
        '<li><a href="movies.html" class="menu1"><span class="glyphicon glyphicon-film" aria-hidden="true"></span>Movies<span class="glyphicon glyphicon-menu-down" aria-hidden="true"></span></a></li>'+
        '<li><a href="news.html" class="news-icon"><span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>News</a></li>'+
        '</ul>'+
        '</div>'+
        '</div>';

    $("#leftNavDiv").html(v_leftNavHtml);
});