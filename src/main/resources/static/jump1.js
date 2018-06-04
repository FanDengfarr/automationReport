function opens(url){
    //var uurl='http://'+window.location.host+'/automation/'+url;
  //parent.document.getElementById("ifr").src=uurl;
  var substrArray = url.split("/");
    loadIframe(substrArray[1]);
  //window.history.pushState({},0,uurl);
  }

$(document).ready(function(){
	$("a.fa").click(function(){
		$("a.fa").removeClass("fa-caret-right");
        $(this).addClass("fa-caret-right");
	});
});


function loadIframe(url){
  var u = window.location.href;
  var end = u.indexOf("#");
  var rurl = u.substring(0,end);
  //设置新的锚点
  window.location.href = rurl + "#" + url;
}
 window.onhashchange = function(){
        var hash = location.hash;
        var url = hash.substring(1,hash.length);
        var uurl='http://'+window.location.host+'/automation/logs/'+url+'/index.html';
        $("#ifr").attr("src",uurl);
    }

document.addEventListener('DOMContentLoaded', function () {
     var hash = location.hash;
     var url = hash.substring(1,hash.length);
     var uurl='http://'+window.location.host+'/automation/logs/'+url+'/index.html';
     $("#ifr").attr("src", uurl);
}, false)