layui.config({
    base: '../cms/js/',
    version: new Date().getTime()
}).use(['table', 'jquery', 'navbar', 'tab', "form"], function () {
    var table = layui.table;
    var $ = layui.jquery;
    var h = $(window).height();
    var w = $(window).width();
    var form = layui.form;
    // 进入用户管理 加载全部用户
    render();

    // 渲染点击部门后的用户表格
    function render() {
        var url = getRootPath_web() + "MsgPolicy/selectByCondition";
        //列表
        var app = table.render({
            elem: '#idTest'
            , url: url //数据接口
            , width: w - 10
            , page: true //开启分页
            , request: {pageName: 'currentPage', limitName: 'pageSize'}
            , skin: "nob"
            , cols: [[ //表头
                {field: 'domain', title: '运营商名称', templet: '#domainStatus'}
                , {field: 'lacName', title: '运营商基站名称'}
                , {field: 'lac', title: '运营商基站编号'}
                , {field: 'flowRate', title: '基站流速(条/秒)'}
                , {field: 'createTime', title: '创建时间', templet: '<div>{{ tier(d.createTime) }}</div>'}
                , {field: 'updateTime', title: '修改时间', templet: '<div>{{ tier(d.createTime) }}</div>'}
                , {title: '操作', toolbar: '#barDemo', align: "center", width: 160}
            ]]
        });
        $(".layui-table-body").css({
            "max-height": h - 130 + "px"
        });
    }

    $("#left_ul").css({
        "height": h - 60 + "px"
    });
    $(".layui-table-body").css({
        "max-height": h - 130 + "px"
    });
    // 新增短信发送流量策略
    var body = $('body');
    body.delegate('.add_uer', 'click', function (e) {
        e.stopPropagation();
        layer.open({
            type: 1,
            title: "新增短信流量发送策略",
            area: ['490px', '500px'],
            btn: ['确定', '取消'],
            content: $("#form_bnt"),
            yes: function () {
                var select = $("#domain").select();
                var domain = select.val();
                if (domain == null || domain === "") {
                    layer.msg('请选择基站运营商');
                    return false
                }
                var lacName = $("#lacName").val();
                if (lacName == null || lacName == "" || lacName == undefined) {
                    layer.msg('请输入基站名称！');
                    return false
                }
                var lac = $("#lac").val();
                if (lac == null || lac == "" || lac == undefined) {
                    layer.msg('请输入基站编号！');
                    return false
                }
                var flowRate = $("#flowRate").val();
                if (flowRate == null || flowRate == "" || flowRate == undefined) {
                    layer.msg('请输入短信流速（条/s）！');
                    return false
                }
                var data = {
                    domain: domain,
                    lacName: lacName,
                    lac: lac,
                    flowRate: flowRate
                };
                $.ajax({
                    url: getRootPath_web() + "MsgPolicy/save/",
                    type: "POST",
                    dataType: "json",
                    contentType: 'application/json;charset=UTF-8',
                    data: JSON.stringify(data),
                    success: function (data) {
                        if (data.code === "0") {
                            clear();
                            layer.msg(data.msg);
                            setTimeout(function () {
                                $(".layui-laypage-btn").click();
                                location.reload();
                            }, 1000);
                        } else {
                            layer.msg(data.msg);
                        }
                    }
                });
            },
            btn2: function () {
                clear();
            }
            , end: function () {
                clear();
            }
        })
    });
    // 编辑按钮 用于查修改
    table.on('tool(demo)', function (obj) {
        var data = obj.data;
        if (obj.event === 'compile') {
            var id = data.id;
            $.ajax({
                url: getRootPath_web() + "MsgPolicy/select/" + id,
                type: "GET",
                dataType: "json",
                contentType: 'application/json;charset=UTF-8',
                data: {},
                success: function (data) {
                    if (data.code === "0") {
                        var policy = data.data;
                        $("#lacName").val(policy.lacName);
                        var $lac = $("#lac");
                        $lac.val(policy.lac);
                        $lac.attr("disabled", true);
                        var $domain = $("#domain option");
                        $domain.prop('selected', false);
                        $domain.eq(policy.domain).prop("selected", true);
                        $("#flowRate").val(policy.flowRate);
                        form.render();
                    } else {
                        layer.msg('加载数据失败');
                    }

                }
            });
            // 弹出编辑弹框
            layer.open({
                type: 1,
                title: "编辑策略",
                area: ['490px', '500px'],
                btn: ['确定', '取消'],
                content: $("#form_bnt"),
                yes: function () {
                    var select = $("#domain").select();
                    var domain = select.val();
                    if (domain == null || domain === "") {
                        layer.msg('请选择基站运营商');
                        return false
                    }
                    var lacName = $("#lacName").val();
                    if (lacName == null || lacName == "" || lacName == undefined) {
                        layer.msg('请输入基站名称！');
                        return false
                    }
                    var flowRate = $("#flowRate").val();
                    if (flowRate == null || flowRate == "" || flowRate == undefined) {
                        layer.msg('请输入短信流速（条/s）！');
                        return false
                    }
                    var data = {
                        id: id,
                        domain: domain,
                        lacName: lacName,
                        flowRate: flowRate
                    };
                    // 更新基站操作 发送请求
                    $.ajax({
                        url: getRootPath_web() + "MsgPolicy/update/",
                        type: "POST",
                        dataType: "json",
                        contentType: 'application/json;charset=UTF-8',
                        data: JSON.stringify(data),
                        success: function (data) {
                            if (data.code === "0") {
                                clear();// 清空表单数据
                                layer.msg(data.msg);
                                setTimeout(function () {
                                    $(".layui-laypage-btn").click();
                                    location.reload();
                                }, 1000);
                            } else {
                                layer.msg(data.msg);
                            }
                        }
                    });
                },
                btn2: function () {
                    clear();
                },
                end: function () {
                    clear();
                }
            })
            //   删除操作
        } else if (obj.event === 'delete') {
            layer.confirm('确定要删除该基站策略吗？', function (index) {
                $.ajax({
                    url: getRootPath_web() + "MsgPolicy/delete/" + data.id,
                    type: "DELETE",
                    dataType: "json",
                    contentType: 'application/json;charset=UTF-8',
                    data: {},
                    success: function (data) {
                        if (data.code === "0") {
                            layer.msg(data.msg);
                            setTimeout(function () {
                                $(".layui-laypage-btn").click();
                                location.reload();
                            }, 1000);
                        } else {
                            layer.msg(data.msg);
                            layer.close(index);
                        }
                    }
                });
            });
        }
    });

    // 提交表单后 清空表单
    function clear() {
        $("#lacName").val("");
        $("#lac").val("");
        $("#flowRate").val("");
    }

    //监听点击事件 左侧导航点击请求数据
    var $body = $('body');
    $body.delegate('.site_active_two', 'click', function (e) {
        e.stopPropagation();
        render($(this).attr("id"));
        $(this).parents("#left_ul").find(".site_active_two").children().removeClass("click_blue");
        $(this).children().addClass("click_blue");
    });
});

