layui.config({
    base: 'js/',
    version: new Date().getTime()
}).use(['element','layer','form','navbar','tab'],function(exports){
    var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
    var $ = layui.jquery;        //调用jq方法
    var layer = layui.layer;
    var navbar = layui.navbar();
    var form = layui.form;
    var h = $(window).height();
    var w = $(window).width();
    var data;
    $("body").css("height",h+"px");
    $("iframe").css("height",h-80+"px");
    $(".title_ul").css("width",(w-$("#left_ul_one").width()-80)+"px");
    // layer.alert("");
    $(".layui-layer-btn0").attr('disabled',"true");
    $('#left_ul_one').slimScroll({
        width: '199px',//宽度
        height: h-50+"px",//高度
        size: '3px',//大小
        position: 'right',//位置
        color: '#666',//颜色
//	    alwaysVisible: true,
//	    distance: '20px',//距离
//	    start: $('#child_image_element'),//开始
//	    railVisible: true,
//	    railColor: '#222',
//	    railOpacity: 0.3,
//	    wheelStep: 10,
//	    allowPageScroll: false,
//	    disableFadeOut: false
    });
    //侧面菜单传值并循环
    $('.form table tbody tr').children().eq(1).on('click',function(){
        $(this).parent().children().eq(1).parents(".initials_name").siblings(".cases").show()
    })
//          $(this).children().eq(1).parents(".initials_name").siblings(".cases").show()
    $(".slimScrollDiv").css("width","200px");

    var isShow = true;  //定义一个标志位
    $('.navBtn').click(function(){
        //document.getElementById('FrameID').contentWindow.location.reload(true);
        //window.parent.frames.location.reload()
        //需要刷新一下当前页面所有的子页面
        //判断isshow的状态
        if(isShow){
            $("iframe").css({
                "width":w-79+"px"
            });
            $("#top_tabs").css({
                "width":w-79+"px"
            });
            $('#left_ul_one').width(79); //设置宽度
            $('.kit-side-fold i').css('margin-right', '70%');  //修改图标的位置
            //将footer和body的宽度修改
            $(".layui-body").css({
                "left":80+"px"
            });
            $(".layui-footer").css({
                "left":80+"px"
            });
            //将二级导航栏隐藏
            $('dd span').each(function(){
                $(this).hide();
            });
            $(".slimScrollDiv").css("width","80px");
            $('#left_ul_one').slimScroll({
                width: '79px',//宽度
                height: h-50+"px",//高度
                size: '3px',//大小
                position: 'right',//位置
                color: '#666',//颜色
                //	    alwaysVisible: true,
                //	    distance: '20px',//距离
                //	    start: $('#child_image_element'),//开始
                //	    railVisible: true,
                //	    railColor: '#222',
                //	    railOpacity: 0.3,
                //	    wheelStep: 10,
                //	    allowPageScroll: false,
                //	    disableFadeOut: false
            });
            $(".layui-nav-item a cite").css("padding","0 45px");
            $(".admin_right").css({
                "width":w-259+"px"
            });
            $(".title_ul").css("width",(w-$("#left_ul_one").width()-40)+"px");
            //修改标志位
            isShow =false;
        }else{
            $("iframe").css({
                "width":w-199+"px"
            });
            $("#top_tabs").css({
                "width":w-199+"px"
            });
            $('#left_ul_one').width(199);
            $('.kit-side-fold i').css('margin-right', '10%');
            $(".layui-body").css({
                "left":200+"px"
            });
            $(".layui-footer").css({
                "left":200+"px"
            });
            $('dd span').each(function(){
                $(this).show();
            });
            $(".layui-nav-item a cite").css("padding","0 10px");
            $(".slimScrollDiv").css("width","200px");
            $('#left_ul_one').slimScroll({
                width: '199px',//宽度
                height: h-50+"px",//高度
                size: '3px',//大小
                position: 'right',//位置
                color: '#666',//颜色
                //	    alwaysVisible: true,
                //	    distance: '20px',//距离
                //	    start: $('#child_image_element'),//开始
                //	    railVisible: true,
                //	    railColor: '#222',
                //	    railOpacity: 0.3,
                //	    wheelStep: 10,
                //	    allowPageScroll: false,
                //	    disableFadeOut: false
            });
            $(".admin_right").css({
                "width":w-400+"px"
            });
            $(".title_ul").css("width",(w-$("#left_ul_one").width()-40)+"px");
            isShow =true;
        }
    });
    //取出用户信息列入用户名
    var arrStr = document.cookie.split("; ");
    for (var i = 0; i < arrStr.length; i++) {
        var temp = arrStr[i].split("=");
        if( temp[0] == "username"){
            userName = temp[1]
        }
    };
    $("#logOut").click(function () {
        document.cookie = "username="+ "" +";password="+ "" +";";
        window.location.href = './login.html';
    });
    //配置用户信息，并发起渲染
    $("#username").html(userName);
    if( userName == "" || userName == null || userName == undefined){

    }
    $.ajax({
        url:getRootPath_web()+"getUserPerm ",
        type: "POST",
        dataType: "json",
        data:{
            username:userName,
        },
        success:function (data) {
        //将一位数组改变成树状结构图
        function treeObj(originObj){
            //对象深拷贝
            var obj ={};
            for (key in originObj){
                var val = originObj[key];
                obj[key] = typeof val === 'object' ? arguments.callee(val):val;
            }
            //对象新增children键值，用于存放子树
            obj['children'] = [];
            return obj;
        }
    //data：带转换成树形结构的对象数组
    //attributes：对象属性
    function toTreeData (data, attributes) {
        var resData = data;
        var tree = [];
        //找寻根节点 默认返回的parentId为空后期可以更改判断
        for (var i = 0; i < resData.length; i++) {
            if ( resData[i][attributes.parentId] === ''|| resData[i][attributes.parentId] === null ||resData[i][attributes.parentId] == 0) {
                tree.push( treeObj(resData[i]) );
                resData.splice(i, 1);
                i--;
            }
        }
        run(tree);
        //找寻子树
        function run(chiArr) {
            if (resData.length !== 0) {
                for (var i = 0; i < chiArr.length; i++) {
                    for (var j = 0; j < resData.length; j++) {
                        if (chiArr[i][attributes.id] === resData[j][attributes.parentId]){
                            var obj = treeObj(resData[j]);
                            chiArr[i].children.push(obj);
                            resData.splice(j, 1);
                            j--;
                        }
                    }
                    run(chiArr[i].children);
                }
            }
        }
        return tree;
    }
            //排序
            var arr = data.data;
            var compare = function (obj1, obj2) {
                var val1 = obj1.sort;
                var val2 = obj2.sort;
                if ( val1 < val2 ) {
                    return -1;
                } else if (val1 > val2) {
                    return 1;
                } else {
                    return 0;
                }
            }
            data = arr.sort(compare);
    // 属性配置信息
    var attributes = {
        id: 'id',
        parentId: 'parentId',
    };
    var treeData = toTreeData(data, attributes);
    //侧面菜单传值并循环
    $.ajax({
                url:getRootPath_web() + "/config/select",
                type:'get',
                dataType:'json',
                success:function(data) {
                    if( data.code == 200){
                        var str = '';
                        var str1 = '';
                        $("#title").text(data.data.project_name);
                        document.title = data.data.project_name;
                        $("#title").attr("dataid",data.data.id);
                        //var showlist = $("<ul class='layui-nav-child'></ul>");
                        showall(treeData,1);
                        //循环递归显示数据数据
                        function showall(menu_list,parent) {
                            // pid="+id+";
                            // var ad
                            // if( pid == ad){
                            //     ad = das
                            // }
                            $.each(menu_list, function(index,val) {

                                if ( val.id == data.data.menu_bar1_id ) {
                                    srt= '';
                                    //循环人员列表
                                    if ( val.children.length > 0 ) {
                                        str += "<li class='layui-nav-item' >"
                                        str += "<i class='layui-icon' style='float: left;margin: 0 5px;'>" + val.icon + "</i>"
                                        str += "<a href='javascript:;'  style='float: left;padding: 0;'><sapn style='margin-right: 20px;'>" + val.title +"</a>"
                                        str += "<ul  class='layui-nav-child'>"
                                        for( var i = 0 ; i < val.children.length;i++){
                                            str += "<li class='site_active' data-title="+ val.children[i].title +"   data-url="+ val.children[i].href +" data-id="+ val.children[i].id +"  >"
                                            str += "<a  style='padding: 0 10px;overflow: hidden'>"
                                            str += "<i class='layui-icon' style='float: left;margin-right: 5px;'>" + val.children[i].icon + "</i>"
                                            str += "<sapn  style='padding-right: 5px;float: left;' >" + val.children[i].title +"</sapn>"
                                            str += "</a>"
                                            str += "</li>";
                                        }
                                        str +=  "</ul >"
                                        str += "</li>";
                                    } else {
                                        str += "<li class='layui-nav-item site_active' data-title="+ val.title +"  data-url="+ val.href +" data-id="+ val.id +"  >"
                                        str += "<i class='layui-icon' style='float: left;margin: 0 5px;'>" + val.icon + "</i>"
                                        str +=  "<a style='float: left;padding: 0;'><sapn>" + val.title+"</sapn></a>"
                                        str += "</li>";
                                    }
                                    $("#leftNav").append(str);
                                    str =''
                                }
                                if ( val.id == data.data.menu_bar2_id ) {
                                    str = '';
                                    //循环人员列表
                                    if ( val.children.length > 0 ) {
                                        str += "<li class='layui-nav-item' >"
                                        str += "<i class='layui-icon' style='float: left;margin: 0 5px;'>" + val.icon + "</i>"
                                        str += "<a href='javascript:;'  style='float: left;padding: 0;'><sapn style='margin-right: 20px;'>" + val.title +"</a>"
                                        str += "<ul class='layui-nav-child'>"
                                        for( var i = 0 ; i < val.children.length;i++){
                                            str += "<li class='site_active' data-title="+ val.children[i].title +"   data-url="+ val.children[i].href +" data-id="+ val.children[i].id +"  >"
                                            str += "<a  style='padding: 0 10px;overflow: hidden'>"
                                            str += "<i class='layui-icon' style='float: left;margin-right: 5px;'>" + val.children[i].icon + "</i>"
                                            str += "<sapn  style='padding-right: 5px;float: left;' >" + val.children[i].title +"</sapn>"
                                            str += "</a>"
                                            str += "</li>";
                                        }
                                        str +=  "</ul>"
                                        str += "</li>";
                                    } else {
                                        str += "<li class='layui-nav-item site_active' data-title="+ val.title +"  data-url="+ val.href +" data-id="+ val.id +"  >"
                                        str += "<i class='layui-icon' style='float: left;margin: 0 5px;'>" + val.icon + "</i>"
                                        str +=  "<a style='float: left;padding: 0;'><sapn>" + val.title+"</sapn></a>"
                                        str += "</li>";
                                    }
                                    $("#leftNav").append(str);
                                    str = '';
                                }
                                //初始化动态元素，一些动态生成的元素如果不设置初始化，将不会有默认的动态效果
                                element.render();
                                $("#leftNav li").hover(function () {
                                    var chliLay = $(this).children("a").children(".layui-nav-more");
                                    chliLay.addClass("layui-nav-mored");
                                    $(this).children("ul").addClass("layui-show")
                                },function () {
                                    var chliLay = $(this).children("a").children(".layui-nav-more");
                                    chliLay.removeClass("layui-nav-mored");
                                    $(this).children("ul").removeClass("layui-show")
                                })
                                // if ( val.id == data.data.menu_bar2_id ) {
                                //     //循环人员列表
                                //     if (val.children.length > 0) {
                                //         var li = $("<li></li>");
                                //         var li_two = $("<li></li>");
                                //         li.append(
                                //             "<li class='layui-nav-item'>"
                                //             + "<i class='layui-icon' style='float: left;margin: 0 5px;'>" + val.icon + "</i>"
                                //             + "<a >" + val.title + "</a>"
                                //             + "</li>"
                                //         ).append("<ul></ul>").appendTo(parent);
                                //         //递归显示
                                //         showall(val.children, $(li).children().eq(1));
                                //     } else {
                                //         $("<li></li>").append("<li class='layui-nav-item'>"
                                //             + "<i class='layui-icon' style='float: left;margin: 0 5px;'>" + val.icon + "</i>"
                                //             + "<a >" + val.title + "</a>"
                                //             + "</li>").appendTo(parent);
                                //     }
                                // }
                            });
                            // showall(menu_list.children,id)
                        };

                    }else{
                        layer.msg("查询失败");
                    }

                    console.log( data )
                },
                error : function() {
                    layer.msg("服务器异常");
                }
            });
    //设置navbar
    navbar.set({
        spreadOne: true,
        elem: '#admin-navbar-side',
        cached: true,
        data:treeData
        // url: 'data/root.json'
    });
    //渲染navbar
    navbar.render();
    //监听点击事件
    navbar.on('click(side)', function (data) {
        tab.tabAdd(data.field);
    });
}
})
//关闭当前所有弹窗
$('body').delegate('.close', 'click', function(e){
    e.stopPropagation();
    layer.closeAll()
});
//主题颜色的下拉框被切换的事件
$('.skin_yes').on('click', function(){
    var selectVal = $("input[name='skin']:checked").val();
    if( selectVal == '0'){
        // 存储
        localStorage.setItem("css_style", "2");
        document.getElementById('index_css').href = 'style/index.css';
        window.location.reload();
    }else{
        // 存储
        localStorage.setItem("css_style", "1");
        document.getElementById('index_css').href = 'style/index_one.css';
        window.location.reload();
    }

});
//		    $(".layui-tab-title li").hover(function(){
//		    	$(this).children().css({
//		    		"color":"#222!important";
//		    	})
//		    },function(){
//		    	$(this).children().css({
//		    		"color":"#222!important";
//		    	})
//		    })
var style = localStorage.getItem("css_style");
if( style ==  "1" ){
    document.getElementById('index_css').href = 'style/index_one.css';
    $("#radio_skin input").eq(1).attr("checked",true);
    form.render();
}else{
    document.getElementById('index_css').href = 'style/index.css';
    $("#radio_skin input").eq(1).attr("checked",false);
    form.render();
}
var active = {
    //在这里给active绑定几项事件，后面可通过active调用这些事件
    tabAdd : function (url, id, name) {
        //新增一个Tab项 传入三个参数，分别对应其标题，tab页面的地址，还有一个规定的id，是标签中data-id的属性值
        //关于tabAdd的方法所传入的参数可看layui的开发文档中基础方法部分
        element.tabAdd('demo', {
            title: name,
            content: '<iframe data-frameid="' + id + '" scrolling="auto" frameborder="0" src="' + url + '" style="width:100%;height:99%;"></iframe>',
            id: id //规定好的id
        })
        element.tabAdd('demoul', {
            title: name,
            content: '<li class="layui-this" layid="' + id + '"><cite></cite></li>',
            id: id //规定好的id
        })
        //CustomRightClick(id); //给tab绑定右击事件
        FrameWH();  //计算ifram层的大小
    },
    tabChange: function (id) {
        //切换到指定Tab项
        element.tabChange('demo', id); //根据传入的id传入到指定的tab项
    },
    tabDelete: function (id) {
        element.tabDelete("demo", id);//删除
    }
    ,tabDeleteAll: function (ids) {//删除所有
        $.each(ids, function (i,item) {
            element.tabDelete("demo", item); //ids是一个数组，里面存放了多个id，调用tabDelete方法分别删除
        })
    }
};
function FrameWH() {
    var h = $(window).height();
    $("iframe").css("width",(w-$("#left_ul_one").width())+"px");
    $("iframe").css("height",(h-103)+"px");
}
// 配置tab实践在下面无法获取到菜单元素
$('body').delegate(".site_active",  "click",function () {
    var dataid = $(this);
    //这时会判断右侧.layui-tab-title属性下的有lay-id属性的li的数目，即已经打开的tab项数目
    if ($(".layui-tab-title li[lay-id]").length <= 0) {
        //如果比零小，则直接打开新的tab项
        active.tabAdd(dataid.attr("data-url"), dataid.attr("data-id"), dataid.attr("data-title"));
    } else {
        //否则判断该tab项是否以及存在
        var isData = false; //初始化一个标志，为false说明未打开该tab项 为true则说明已有
        $.each($(".layui-tab-title li[lay-id]"), function () {
            //如果点击左侧菜单栏所传入的id 在右侧tab项中的lay-id属性可以找到，则说明该tab项已经打开
            if ($(this).attr("lay-id") == dataid.attr("data-id")) {
                isData = true;
            }
        })
        if (isData == false) {
            //标志为false 新增一个tab项
            active.tabAdd(dataid.attr("data-url"), dataid.attr("data-id"), dataid.attr("data-title"));
        }
    }
    //最后不管是否新增tab，最后都转到要打开的选项页面上
    active.tabChange(dataid.attr("data-id"));
    var pop = 0;
    var length;
    $(".title_ul li").each(function(){
        length = $(this).width()+6;
        pop += $(this).width()+6;
    });
    var nav = $(".title_ul").width();
    $("#num").val( pop/nav );
    if( ( pop - length ) > nav){
        $("#ring_bth").parent().show();
        $("#no_bth").parent().show();
    }
});
$("#no_bth").click(function () {
    var idPush = [];
    $(".title_ul li").each(function () {
        var the = $(this);
        if( the.children(i).css("display") != "none"){
            idPush.push(  the.attr("lay-id") );
        }
    });
    active.tabDeleteAll(idPush);
    $(".title_ul").css({"left":"0px"});
    $("#no_bth").parent().hide();
    $("#left_bth").parent().hide();
    $("#ring_bth").parent().hide();
});
$("#left_bth").on('click',function(){
//	      	var pop = 0;
//		    var nav = $(".title_ul").width();
//		    var val = $("#num").val();
//	        if( val > 1 ){
//	        	if( val == 1 ){
//		        	$(".title_ul").css("left","-"+( val - 1 )*nav+"px" );
//	        		$("#num").val( val );
//	        	}else{
//		        	$(".title_ul").css("left","-"+ ( val - 1 ) *nav+"px" );
//	        		$("#num").val( val - 1 );
//	        	}
//	        }else{
//	        	$(".title_ul").css("left","0px" );
//	        }
    var f = $(".title_ul");
    var i = $(".title_ul");
    var t = f[0].style.left, e = parseInt(t.substr(0, t.indexOf("px")));
    0 !== e && ( e = (e += i.width() ) > 0 ? 0 : e,
        f.animate({
            left: e + "px"
        }))
    if( e < 0 ){
        $("#ring_bth").parent().show();
        $("#no_bth").parent().show();
    }

})
$("#ring_bth").on('click',function(){
//      	var pop = 0;
//      	var nav = $(".title_ul").width();
//      	var val = $("#num").val();
//	        if( val > 1 ){
//	        	$(".title_ul").css("left","-"+val*nav+"px" );
//	        }
//	        var pop = 0;
//	        $(".title_ul li").each(function(){
//	        	pop += $(this).width()+6;
//	        });
//	       	$("#num").val( pop/nav );
    var f = $(".title_ul");
    var i = $(".title_ul");
    var t = f[0].style.left
        , e = parseInt( t.substr(0, t.indexOf("px")))
        , n = i.width()
        , a = -18;
    if (f.children("li").each(function() {
        var t = $(this).width();
        a += t + 48
    }),
    n < a && e - n > -a) {
        parseInt(a / n);
        e = e - n >= 0 ? 0 : e - n,
            f.animate({
                left: e + "px"
            })
    }
    if( e < 0 ){
        $("#left_bth").parent().show();
    }
})

//设置皮肤编辑
$('body').delegate('.skin', 'click', function(e){
    e.stopPropagation();
    layer.open({
        type: 1,
        title:"更换皮肤",
        area: ['380px', '180px'],
        content: $("#form_bnt")
    })
});
$(".closeBox li").on('click',function () {
    //右键菜单中的选项被点击之后，判断type的类型，决定关闭所有还是关闭当前。
    if ($(this).attr("data-type") == "closethis") {
        //如果关闭当前，即根据显示右键菜单时所绑定的id，执行tabDelete
        active.tabDelete($(this).attr("data-id"))
    } else if ($(this).attr("data-type") == "closeall") {
        var tabtitle = $(".layui-tab-title li");
        var ids = new Array();
        $.each(tabtitle, function (i) {
            ids[i] = $(this).attr("lay-id");
        })
        //如果关闭所有 ，即将所有的lay-id放进数组，执行tabDeleteAll
        active.tabDeleteAll(ids);
    }
    $('.closeBox').hide(); //最后再隐藏右键菜单
})
function CustomRightClick(id) {
    //取消右键  closeBox属性开始是隐藏的 ，当右击的时候显示，左击的时候隐藏
    $('.layui-tab-title li').on('contextmenu', function () { return false; })
    $('.layui-tab-title,.layui-tab-title li').click(function () {
        $('.closeBox').hide();
    });
    //桌面点击右击
    $('.layui-tab-title li').on('contextmenu', function (e) {
        var popupmenu = $(".closeBox");
        popupmenu.find("li").attr("data-id",id); //在右键菜单中的标签绑定id属性

        //判断右侧菜单的位置
        l = ($(document).width() - e.clientX) < popupmenu.width() ? (e.clientX - popupmenu.width()) : e.clientX;
        t = ($(document).height() - e.clientY) < popupmenu.height() ? (e.clientY - popupmenu.height()) : e.clientY;
        popupmenu.css({ left: l, top: t }).show(); //进行绝对定位
        //alert("右键菜单")
        return false;
    });
}
setTimeout(function () {
    $("#admin-navbar-side ul > li").eq(0).click();
    $(".title_ul > li").eq(1).children().hide();
    $("#admin-navbar-side1 > ul > li").each(function(){
        $(this).parent().attr("parentid",$(this).attr("parentid"));
    });
    $("#admin-navbar-side2 > ul > li").each(function(){
        $(this).parent().attr("parentid",$(this).attr("parentid"));
    });
},500);

})


 					