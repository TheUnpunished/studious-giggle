<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<#include "../footer.ftl">
<#include "../header.ftl">
<head>
    <title>Поставщики</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="/css/styles.css" rel="stylesheet">
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
            Контакт
        </th>
        <th>
            Адрес
        </th>
        <th>

        </th>
        <th>

        </th>
    </tr>
    <#list supplier_list as supplier>
        <tr>
            <td>
                ${supplier.name}
            </td>
            <td>
                ${supplier.count}
            </td>
            <td>
                ${supplier.phone}
            </td>
            <td>
                ${supplier.address}
            </td>
            <td>
                <a href="/supplier/edit/${supplier.id}">
                    Изменить
                </a>
            </td>
            <td>
                <a href="/supplier/delete/${supplier.id}">
                    Удалить
                </a>
            </td>
        </tr>
    </#list>
</table>
<a href="/supplier/add" style="display:inline-block; padding: 5pt 10pt">
    Добавить
</a>
<a href="/supplier/fromfile/" style="display:inline-block; padding: 5pt 10pt">
    Из файла
</a>
<a href="/supplier/tofile/" style="display:inline-block; padding: 5pt 10pt">
    В файл
</a>
<@footer/>
</body>