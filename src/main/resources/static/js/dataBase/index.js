/**
 * @description
 * @author Zhang Yongei
 * @date 2019-03-22
 * @version 1.0
 */
$(function(){
    loadPage(1);
});
function loadPage(page){
    layer.load(1, {shade: [0.5,'#000']});
    var connectId = $("#connectId").val();
    $("#itemsPanel").skillAjax({
        url: "/dataBase/page",//提交连接
        model:$("#skillModel"),
        pageModel:$("#pageModel"),
        data: {"connectId": connectId,"pageSize":$("#pageCount").val()},
        pageNum: page,
        callback: function(result){
            layer.closeAll('loading');
            var num = result.startIndex;
            if(result != null && result.code != 500 && result.rows.length > 0) {
                $("#itemsPanel tr").each(function () {
                    // 渲染状态
                    var prefixFlag = $(this).find("[key=prefixFlag]").html();
                    if (prefixFlag == 0) {
                        $(this).find("[key=state]").html("否");
                    } else if (prefixFlag == 1) {
                        $(this).find("[key=state]").html("是");
                    }

                    $(this).find("[key=num]").append(num);
                    num ++ ;
                    //为修改按钮赋值
                    var id = $(this).find("[key=id]").val();
                    $(this).find(".edit-e").attr("href","/connect/add?id="+id);
                });
            }else{
                $("#itemsPanel").html("<tr><td style='text-align: center' colspan='6'>暂无数据</td>></tr>")
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
        url: "/dataBase/createTables",//提交连接
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
    window.location.href = "/tables?dataBaseId=" + id;
});