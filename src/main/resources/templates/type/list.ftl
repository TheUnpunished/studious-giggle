<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org"/>
<#include "../footer.ftl">
<#include "../header.ftl">
<head>
    <title>Разновидности</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="/css/styles.css" rel="stylesheet">
</head>
</head>
<body>
<@menu/>
<table style="padding: 10pt">
    <tr>
        <th>
            Имя
        </th>
        <th>
            Количество позиций
        </th>
        <th>

        </th>
        <th>

        </th>
    </tr>
    <#list type_list as type>
        <tr>
            <td>
                ${type.name}
            </td>
            <td>
                ${type.count}
            </td>
            <td>
                <a href="/type/edit/${type.id}">
                    Изменить
                </a>
            </td>
            <td>
                <a href="/type/delete/${type.id}">
                    Удалить
                </a>
            </td>
        </tr>
    </#list>
</table>
<a href="/type/add" style="display:inline-block; padding: 5pt 10pt">
    Добавить
</a>
<a href="/type/fromfile/" style="display:inline-block; padding: 5pt 10pt">
    Из файла
</a>
<a href="/type/tofile/" style="display:inline-block; padding: 5pt 10pt">
    В файл
</a>
<@footer/>
</body>
