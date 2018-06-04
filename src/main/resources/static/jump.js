$(function(){
    $(".premium-menu").on("click", "li", function(){
        var sId = $(this).data("id");  //获取data-id的值
        window.location.hash = sId;  //设置锚点
        loadInner(sId);
    });
    function loadInner(sId){
        var sId = window.location.hash;
        var pathn, i;
        switch(sId){
            case "#10-30": pathn = "/history_10_30/index.html"; i = 0; break;
　　　　　　　case "#10-29": pathn = "/history_10_23/index.html"; i = 1; break;
            case "#10-28": pathn = "/history_10_31/index.html"; i = 2; break;
            case "#10-27": pathn = "user_info.html"; i = 3; break;
            case "#10-26": pathn = "user_info.html"; i = 4; break;
            case "#10-25": pathn = "user_info.html"; i = 5; break;
            case "#10-24": pathn = "user_info.html"; i = 6; break;
            case "#10-23": pathn = "user_info.html"; i = 7; break;
            case "#10-22": pathn = "user_info.html"; i = 8; break;
            case "#10-21": pathn = "user_info.html"; i = 9; break;
            case "#10-20": pathn = "user_info.html"; i = 10; break;

        }
        $(".content").load(pathn); //加载相对应的内容
         window.history.pushState(sId, null, pathn);
         window.addEventListener('popstate', function(e) {
         var state=e.state;
            loadInner(state);
         //注意：此处不要调用setState();了，因为在历史记录堆栈中跳转时不需要往堆栈中写入数据
         });
    }
    var sId = window.location.hash;
    loadInner(sId);
});