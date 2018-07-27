layui.use(['element', "laytpl"], function () {
    var element = layui.element;
    var laytpl = layui.laytpl;

    var active = {
        tabAdd: function (val,url,id) {
            if(url === "#"){
                url = basePath+'/page/error';
            };
            var tabNum = ".layui-tab-title li[lay-id='"+ id +"']";
            if ( $(tabNum).length > 0 ) {

            } else{
                //添加选项卡事件
                element.tabAdd('demo', {
                    title:val + '<i class="layui-icon layui-unselect layui-tab-close">&#x1006;</i>'
                    , content: '<iframe id='+ id + ' style="width:100%;height:800px;border:0;" src="'+basePath+ url +'"></iframe>' //表示一个iframe页面,宽度为100%,高度为800px
                    , id:id  //表示菜单id
                });
                //增加点击关闭事件
                var r = $(".layui-tab-title").find("li");
                r.eq(r.length - 1).children("i").on("click", function () {
                    element.tabDelete("demo", $(this).parent("li").attr('lay-id'));
                }), element.tabChange("demo", r.length - 1);
                //element.init();
                //element.render('nav');
            }
            //跳转到最新添加的选项卡
            element.tabChange("demo",id);
        }

    }

    loadMenu(laytpl,function () {
        element.render('nav');

        $('.a-tab-add').on('click', function () {
            var val = $(this).data('val');
            var url = $(this).data('url');
            var id = $(this).data('id');
            var type = $(this).data('type');
            active[type] ? active[type].call(this,val,url,id) : '';
            // active.tabAdd(val,url,id);

        });
    });

    $(".menu-switch").on("click",menuSwitch);

});

/**
 * 左侧菜单加载方法
 * @param laytpl
 * @param cb
 */
function loadMenu(laytpl,cb){
    $.ajax({
        url:"/menu/list",
        type:"get",
        success:function(res){
            //数据
            var data = {result:res};
            //数据放到模板中
            var gettpl = document.getElementById('menu_src').innerHTML;
            // 模板放到页面某个地方
            laytpl(gettpl).render(data,function(html) {
                document.getElementById('layui-ul').innerHTML = html;
            });
            if (typeof cb === 'function') cb();
        }
    })
}

/**
 * 左边菜单显示/隐藏功能
 * @type {boolean}
 */
function menuSwitch(){

        if ($(".layui-layout-admin .layui-side").css("left") == '0px') {
            $(".layui-layout-admin .layui-side").animate({left: "-200px"});
            $(".layui-layout-admin .content-body").animate({left: "0px"});
            $(".layui-layout-admin .layui-footer").animate({left: "0px"});
        } else {
            $(".layui-layout-admin .layui-side").animate({left: "0px"});
            $(".layui-layout-admin .content-body").animate({left: "200px"});
            $(".layui-layout-admin .layui-footer").animate({left: "200px"});
        }
}




