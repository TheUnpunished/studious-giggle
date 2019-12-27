<html xmlns:th="http://www.thymeleaf.org"/>
<#include "footer.ftl">
<#include "header.ftl">
<head>
    <title>ОШИБКА!</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="/css/styles.css" rel="stylesheet">
</head>
<body>
<@menu/>
    <div align="center">
        <a class="form-style-2-heading" style="padding: 10pt">
            ОШИБКА
        </a>
        <br>
        <a>
            <#if message??>
                ${message}
            </#if>
        </a>
    </div>
<@footer/>
</body>