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