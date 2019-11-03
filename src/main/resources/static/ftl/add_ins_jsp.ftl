<!DOCTYPE html>
<html lang="zh">
<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>${objectDes}-添加</title>
    ${r'<#include "'}../common/include_css.html${r'">'}
</head>
<body class="pace-done fixed-sidebar">
<div id="wrapper">
    <!--左侧菜单-->
    ${r'<#include "'}../common/menu.html${r'">'}
    <div id="page-wrapper" class="gray-bg">
        <!--头部-->
        ${r'<#include "'}../common/header.html${r'">'}
        <div class="wrapper wrapper-content animated fadeInRight">
            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox ">
                        <div class="ibox-title">
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item">
                                    <a href="javascript:;">${objectDes}</a>
                                </li>
                                <li class="breadcrumb-item active">
                                    <strong>添加</strong>
                                </li>
                            </ol>
                        </div>
                        <div class="ibox-content">
                            <form id="dataForm"  onSubmit="return false">
                                <#list columnList as column>
                                <div class="form-group  row">
                                    <label class="col-sm-2 col-form-label">${column.columnsDesc!}</label>
                                    <div class="col-sm-6">
                                        <input type="text" name="${column.attrVariableName}" value="" placeholder="请输入${column.columnsDesc!}" autocomplete="off" class="form-control required" />
                                    </div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                </#list>
                                <div class="form-group row">
                                    <div class="col-sm-12 col-sm-offset-6 btn-center-al">
                                        <button class="btn btn-white btn-sm" onclick="window.history.back(-1)" type="button">取消</button>
                                        <button class="btn btn-primary btn-sm" onclick="saveOrUpdate()" type="button">提交</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        ${r'<#include "'}../common/footer.html${r'">'}
    </div>
</div>
${r'<#include "'}../common/include_js.html${r'">'}
<script src="/static/js/${objectVariableName}/add.js"></script>
</body>
</html>


