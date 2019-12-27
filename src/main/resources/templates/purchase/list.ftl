<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org"/>
<#include "../footer.ftl">
<#include "../header.ftl">
<head>
    <title>Покупки</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="/css/styles.css" rel="stylesheet">
</head>
<body>
<@menu/>
<table style="padding: 10pt">
    <tr>
        <th>
            Товар
        </th>
        <th>
            Количество
        </th>
        <th>
            Цена
        </th>
        <th>
            Дата
        </th>
        <th>

        </th>
        <th>

        </th>
    </tr>
    <#list purchase_list as purchase>
        <tr>
            <td>
                ${purchase.product.name}
            </td>
            <td>
                ${purchase.count}
            </td>
            <td>
                ${purchase.totalPrice}
            </td>
            <td>
                ${purchase.date}
            </td>
            <td>
                <a href="/purchase/edit/${purchase.id}">
                    Изменить
                </a>
            </td>
            <td>
                <a href="/purchase/delete/${purchase.id}">
                    Удалить
                </a>
            </td>
        </tr>
    </#list>
</table>
<a href="/purchase/add" style="display:inline-block; padding: 5pt 10pt">
    Добавить
</a>
<a href="/purchase/fromfile/" style="display:inline-block; padding: 5pt 10pt">
    Из файла
</a>
<a href="/purchase/tofile/" style="display:inline-block; padding: 5pt 10pt">
    В файл
</a>
<@footer/>
</body>