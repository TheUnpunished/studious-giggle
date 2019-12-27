<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org"/>
<#include "../footer.ftl">
<#include "../header.ftl">
<head>
    <title>Работники</title>
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
            Фамилия
        </th>
        <th>
            Контакт
        </th>
        <th>
            Адрес магазина
        </th>
        <th>

        </th>
        <th>

        </th>
    </tr>
    <#list worker_list as worker>
        <tr>
            <td>
                ${worker.name}
            </td>
            <td>
                ${worker.secName}
            </td>
            <td>
                ${worker.phone}
            </td>
            <td>
                ${worker.shop.address}
            </td>
            <td>
                <a href="/worker/edit/${worker.id}">
                    Изменить
                </a>
            </td>
            <td>
                <a href="/worker/delete/${worker.id}">
                    Удалить
                </a>
            </td>
        </tr>
    </#list>
</table>
<a href="/worker/add" style="display:inline-block; padding: 5pt 10pt">
    Добавить
</a>
<a href="/worker/fromfile/`" style="display:inline-block; padding: 5pt 10pt">
    Из файла
</a>
<a href="/worker/tofile/" style="display:inline-block; padding: 5pt 10pt">
    В файл
</a>
<@footer/>
</body>
