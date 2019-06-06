<!DOCTYPE html>
<html lang="zh">
<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>${objectDes}</title>
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
                        <li class="active">
                            ${objectDes}
                        </li>
                    </ul>
                </div>
                <div id="page-wraper">
                    <div class="row-fluid">
                        <!--主要编写的页面位置-->
                        <div class="span12">
                            <div class="widget blue">
                                <div class="widget-body">
                                    <div class="form-inline" id="searchForm">
                                        <div class="form-group">
                                            <input type="hidden" name="pageCount" id="pageCountParam" />
                                            <div class="pull-right">
                                                <a href="/${objectVariableName}/add" class="btn btn-primary" type="button">添加</a>
                                            </div>
                                        </div>
                                    </div>
                                    <table class="table table-striped table-bordered table-advance table-hover">
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
                                    <div class="pagination pagination-centered">
                                        <ul id="pageModel">

                                        </ul>
                                        <select id="pageCount" class="input-mini" style="float: right;">
                                            <option value="10" selected="selected">10</option>
                                            <option value="25">25</option>
                                            <option value="50">50</option>
                                            <option value="100">100</option>
                                            <option value="1000">1000</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
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
            <a class="btn btn-primary del  edit" title="修改">修改</a>
            <a class="btn btn-primary del  delete" title="删除">删除</a>
        </td>
    </tr>
</table>
${r'<#include "'}../common/footer.html${r'">'}
${r'<#include "'}../common/include_js.html${r'">'}
<script type="text/javascript" src="/static/js/${objectVariableName}/index.js"></script>
</body>
</html>
