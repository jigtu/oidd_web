/**
 * Created by Administrator on 2018/6/15.
 */
layui.config({
    base: '../js/',
    version: new Date().getTime()
}).use(['table', 'jquery', "form"], function () {
    var table = layui.table, $ = layui.jquery;
    var h = $(window).height();
    var w = $(window).width();
    var form = layui.form;
    var userName;
    //取出用户信息列入用户名
    var arrStr = document.cookie.split("; ");
    for (var i = 0; i < arrStr.length; i++) {
        var temp = arrStr[i].split("=");
        if( temp[0] == "username"){
            userName = temp[1]
        }
    };
    $.ajax({
        url:getRootPath_web() + "/config/select",
        type:'get',
        dataType:'json',
        // data:{
        //     username:userName
        // },
        // contentType: 'application/json;charset=UTF-8',
        success:function(data) {
            if( data.code == 200){
                $("#items_name").val(data.data.project_name);
                $("#items_name").attr("dataid",data.data.id);
                $("#dataTables-organization_wrapperO tr").each(function () {
                    var the = $(this);
                    if ( the.hasClass("header") == false ){
                        the.children("td").eq(1).children("sapn").each(function () {
                            var theI = $(this);
                            if( theI.attr("data") == data.data.menu_bar1_id ){
                                $("#system").val(theI.text() );
                            }
                        });
                    }
                });
                $("#dataTables-organization_wrapperW tr").each(function () {
                    var the = $(this);
                    if ( the.hasClass("header") == false ){
                        the.children("td").eq(1).children("sapn").each(function () {
                            var theI = $(this);
                            if( theI.attr("data") == data.data.menu_bar2_id ){
                                $("#systemT").val(theI.text() );
                            }
                        });
                    }
                });
                $("#system").attr("dataid",data.data.menu_bar1_id);
                $("#systemT").attr("dataid",data.data.menu_bar2_id);
                $("#items_url").val(data.data.page_directory);
            }else{
                layer.msg("查询失败");
            }
        },
        error : function() {
            layer.msg("服务器异常");
        }
    });
    //form.on('submit(demo1)', function(data){
    $(".yes_btn").on("click",function () {
        // 获取表单数据
        var data = {
            id : $("#items_name").attr("dataid"),
            project_name : $("#items_name").val(),
            menu_bar1_id : $("#system").attr("dataid"),
            menu_bar2_id : $("#systemT").attr("dataid"),
            page_directory : $("#items_url").val(),
        };
        $.ajax({
            url:getRootPath_web() + "/config/update",
            data:JSON.stringify(data),
            type:'post',
            dataType:'json',
            contentType: 'application/json;charset=UTF-8',
            success:function(result) {
                if( result.code == 200 ){
                    layer.msg(result.desc, {icon: 1},{
                        time: 2000 //20s后自动关闭
                    });
                    setTimeout(function(){
                        parent.location.reload();
                    },2000);
                }else{
                    layer.msg(result.desc, {icon: 2},{
                        time: 2000 //20s后自动关闭
                    })
                }
            },
            error : function() {
                layer.msg("服务器异常");
            }
        });
    });
});


