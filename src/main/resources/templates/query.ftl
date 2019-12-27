<html xmlns:th="http://www.thymeleaf.org"/>
<#include "footer.ftl">
<#include "header.ftl">
<head>
    <title>Запросник</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="/css/styles.css" rel="stylesheet">
</head>
<body>
<@menu/>
<div class="form-style-2">
    <form method="post" action="/query">
        <div class="field">
            <label for="sql">
                Запрос
            </label>
            <input class="input-field" name="sql" id="sql">
        </div>
        <input type="submit" value="Выполнить">
    </form>
    <#if resultList??>
        <pre class="queryResult">
            <#list resultList as resultString>
                ${resultString}
            </#list>
        </pre>
    </#if>
</div>
<@footer/>
</body>