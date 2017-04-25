<#assign ctx="${(rca.contextPath)!''}">

<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta charset="utf-8"/>
    <meta name="description" content="项目测试,后门"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>

    <title>未命名 | 项目测试</title>

    <link rel="shortcut icon" href="${ctx}/static/app/images/favicon.ico" type="image/x-icon">

    <link rel="stylesheet" href="${ctx}/static/app/css/app.css"/>

    <script src="${ctx}/static/app/js/jquery.min.js"></script>
    <script>var ctx = '${ctx}';</script>
</head>
<body>

<#include "navbar.ftl">

<div class="sim-page"></div>

<#include "footer.ftl">

<script src="${ctx}/static/app/js/simpage.js"></script>
<script src="${ctx}/static/app/js/app.js"></script>
</body>
</html>