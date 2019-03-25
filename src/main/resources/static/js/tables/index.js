/**
 * @description
 * @author Zhang Yongei
 * @date 2019-03-22
 * @version 1.0
 */
$checkGoodsMap = new Map();
$(function(){
    loadPage(1);
});
function loadPage(page){
    layer.load(1, {shade: [0.5,'#000']});
    var dataBaseId = $("#dataBaseId").val();
    $("#itemsPanel").skillAjax({
        url: "/tables/page",//提交连接
        model:$("#skillModel"),
        pageModel:$("#pageModel"),
        data: {"dbId": dataBaseId,"pageSize":$("#pageCount").val()},
        pageNum: page,
        callback: function(result){
            layer.closeAll('loading');
            var num = result.startIndex;
            if(result != null && result.code != 500 && result.rows.length > 0) {
                $("#itemsPanel tr").each(function () {
                    // 渲染状态
                    $(this).find("[key=num]").append(num);
                    num ++ ;
                });
            }else{
                $("#itemsPanel").html("<tr><td style='text-align: center' colspan='7'>暂无数据</td>></tr>")
            }
        }//回调方法
    });
}
// 选择每页显示多少条
$("#pageCount").change(function(){
    $("#pageCountParam").val($(this).val());
    loadPage();
});
$(document).on("click", ".create-e", function () {
    var id = $(this).parent().parent().find("[key=id]").val();
    layer.load(1, {shade: [0.5,'#000']});
    $.ajax({
        data: {"id":id},//提交的数据
        url: "/tables/createColumn",//提交连接
        type: 'post',
        dataType: 'json',
        success: function (result) {
            layer.closeAll('loading');
            if (result.code == 0) {
                layer.msg("生成成功");
            }else {
                layer.msg(result.msg);
            }
        }//回调方法
    });
});
$(document).on("click", ".list-e", function () {
    var id = $(this).parent().parent().find("[key=id]").val();
    window.location.href = "/column?tablesId=" + id;
});
$(document).on("click", ".download-e", function () {
    var id = $(this).parent().parent().find("[key=id]").val();
    window.location.href="/tables/downLoad?id=" + id;
});
function batchDown(){
    var ids = $("#itemsPanel .checkbox:checked").checkboxVal();
    if(ids == null || ids == "" || ids == undefined){
        layer.msg("请选择要下载的表");
        return;
    }
    window.location.href="/tables/batchDownLoad?ids=" + ids;
}
//全选
function checkAll(obj) {
    if ($(obj).is(":checked")) {
        $("#itemsPanel .checkbox").prop("checked", true);
    } else {
        $("#itemsPanel .checkbox").removeAttr("checked");
    }
}