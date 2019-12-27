<html xmlns:th="http://www.thymeleaf.org"/>
<#include "footer.ftl">
<#include "header.ftl">
<head>
    <title>Запрос выполнен!</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="/css/styles.css" rel="stylesheet">
</head>
<@menu/>
<body>
    <div align="center">
        <a class="form-style-2-heading" style="padding: 10pt">
            Операция выполнена успешно
        </a>
        </br>
        <#if entityName??>
            <a href="/${entityName}/">
                Вернуться
            </a>
            <#else>
                <a href="/product/">
                    Вернуться
                </a>
        </#if>
    </div>
<@footer/>
</body>