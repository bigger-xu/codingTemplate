<!DOCTYPE html>
<html lang="zh">
<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>${objectDes}-添加</title>
    ${r'<#include "'}../common/include_css.html${r'">'}
</head>
<body class="fixed-top">
<!--头部-->
${r'<#include "'}../common/header.html${r'">'}
<!--主体部分-->
<div id="container" class="row-fluid">
    <!--左侧菜单-->
    ${r'<#include "'}../common/menu.html${r'">'}
    <!--右侧主体-->
    <div id="main-content">
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span12">
                    <h4 class="page-title"></h4>
                    <ul class="breadcrumb">
                        <li>
                            <span>首页</span>
                            <span class="divider">/</span>
                        </li>
                        <li>
                            <span>${objectDes}</span>
                            <span class="divider">/</span>
                        </li>
                        <li>
                            <span>${objectDes}</span>
                            <span class="divider">/</span>
                        </li>
                        <li class="active">
                            修改
                        </li>
                    </ul>
                </div>
                <div id="page-wraper">
                    <div class="row-fluid">
                        <!--主要编写的页面位置-->
                        <div class="span12">
                            <div class="widget blue">
                                <div class="widget-body">
                                    <form id="dataForm"  onSubmit="return false" class="form-horizontal">
                                        <input type="hidden" name="id" value="${r"${"}${objectVariableName}.id${r"}"}">
                                        <#list columnList as column>
                                            <#if column.objectType?exists && column.objectType =="Date">
                                        <div class="control-group">
                                            <label class="control-label"><font style="color: #FF0000;">*</font>${column.columnsDesc!}</label>
                                            <div class="controls">
                                                <input type="text" name="${column.attrVariableName}" value="${r'${'}(${objectVariableName}.${column.attrVariableName}?string('yyyy-MM-dd hh:mm:ss'))!${r'}'}" placeholder="请输入${column.columnsDesc}" autocomplete="off" class="input-xxlarge required" />
                                            </div>
                                        </div>
                                            <#else>
                                        <div class="control-group">
                                            <label class="control-label"><font style="color: #FF0000;">*</font>${column.columnsDesc!}</label>
                                            <div class="controls">
                                                <input type="text" name="${column.attrVariableName}" value="${r'${'}${objectVariableName}.${column.attrVariableName}!${r'}'}" placeholder="请输入${column.columnsDesc}" autocomplete="off" class="input-xxlarge required" />
                                            </div>
                                        </div>
                                            </#if>
                                        </#list>
                                        <div class="form-actions">
                                            <button type="submit" class="btn btn-primary" onclick="saveOrUpdate()"><i class="icon-ok"></i> 提交</button>
                                            <button type="button" class="btn" onclick="window.history.back(-1)"><i class="icon-remove"></i>取消</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
${r'<#include "'}../common/footer.html${r'">'}
${r'<#include "'}../common/include_js.html${r'">'}
<script src="/static/js/${objectVariableName}/add.js"></script>
</body>
</html>


