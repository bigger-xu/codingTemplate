<!DOCTYPE html>
<html lang="zh">
<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>${objectDes}</title>
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
                                <li class="breadcrumb-item">
                                    <strong>${objectDes}</strong>
                                </li>
                            </ol>
                        </div>
                        <div class="ibox-content">
                            <div class="row">
                                <div class="col-sm-11 m-b-xs">
                                </div>
                                <div class="col-sm-1">
                                    <button type="button" class="btn btn-sm btn-primary" onclick="window.location.href='/${objectVariableName}/add'">添加</button>
                                </div>
                            </div>
                            <div class="table-responsive">
                                <table class="table table-striped">
                                    <thead>
                                    <tr>
                                        <th>序号</th>
                                        <#list columnList as column>
                                            <#if column.columnsDesc?exists && column.attrVariableName?exists>
                                        <th>${column.columnsDesc}</th>
                                            </#if>
                                        </#list>
                                        <th><i class=" icon-edit"></i> 操作</th>
                                    </tr>
                                    </thead>
                                    <tbody id="itemsPanel">

                                    </tbody>
                                </table>
                                <div>
                                    <ul id="pageModel" class="pagination pagination-block">

                                    </ul>
                                    <div style="float: right;">
                                        <span>每页展示条数:</span>
                                        <select id="pageCount" class="input-mini" >
                                            <option value="10">10</option>
                                            <option value="25" selected="selected">25</option>
                                            <option value="50">50</option>
                                            <option value="100">100</option>
                                        </select>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>

            </div>
        </div>
        ${r'<#include "'}../common/footer.html${r'">'}
    </div>
</div>
<!--模型-->
<table style="display: none;">
    <tr id="skillModel">
        <td key="num"></td>
        <#list columnList as column>
            <#if column.columnsDesc?exists && column.attrVariableName?exists>
        <td key="${column.attrVariableName}" <#if column.objectType?exists && column.objectType=="Date">formatDate="yyyy-MM-dd hh:mm:ss"</#if>></td>
            </#if>
        </#list>
        <td style="width: 20%">
            <input type="hidden" key="id">
            <button class="btn btn-sm btn-primary edit" title="修改">修改</button>
            <button class="btn btn-sm btn-default delete" title="删除">删除</button>
        </td>
    </tr>
</table>
${r'<#include "'}../common/include_js.html${r'">'}
<script type="text/javascript" src="/static/js/${objectVariableName}/index.js"></script>
</body>
</html>
