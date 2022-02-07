$(document).ready(function(){
    var wd = parseInt($(".vs").width());
    function ani1() {
        $(".vs .img_box").not(":animated").animate({"margin-left":"-"+wd}, 600, function(){
            $(".vs .img_box").append($(".vs .img_box li").eq(0));
            $(".vs .img_box").css("margin-left","0px");
        });
    }
    var intv = setInterval(function(){ ani1(); }, 3000);
}); 