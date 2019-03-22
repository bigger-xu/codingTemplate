/**
 * @author Zhang Yongei
 * @date 2019-03-21
 * @version 1.0
 */
$(function(){
    loadPage(1);
});
function loadPage(page){
    layer.load(1, {shade: [0.5,'#000']});
    var state = $("#state").val();
    var type = $("#type").val();
    $("#itemsPanel").skillAjax({
        url: "/connect/page",//提交连接
        model:$("#skillModel"),
        pageModel:$("#pageModel"),
        data: {"type": type,"state": state,"pageCount":$("#pageCount").val()},
        pageNum: page,
        callback: function(result){
            layer.closeAll('loading');
            var num = result.startIndex;
            if(result != null && result.code != 500 && result.rows.length > 0) {
                $("#itemsPanel tr").each(function () {
                    // 渲染状态
                    $(this).find("[key=num]").append(num);
                    num ++ ;
                    //为详情按钮赋值
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

