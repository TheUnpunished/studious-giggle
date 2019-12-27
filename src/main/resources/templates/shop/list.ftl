<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org"/>
<#include "../footer.ftl">
<#include "../header.ftl">
<head>
    <title>Магазины</title>
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
            Адрес
        </th>
        <th>
            Количество позиций
        </th>
        <th>
            Контакт
        </th>
        <th>

        </th>
        <th>

        </th>
    </tr>
    <#list shop_list as shop>
        <tr>
            <td>
                ${shop.name}
            </td>
            <td>
                ${shop.address}
            </td>
            <td>
                ${shop.count}
            </td>
            <td>
                ${shop.phone}
            </td>
            <td>
                <a href="/shop/edit/${shop.id}">
                    Изменить
                </a>
            </td>
            <td>
                <a href="/shop/delete/${shop.id}">
                    Удалить
                </a>
            </td>
        </tr>
    </#list>
</table>
<a href="/shop/add" style="display:inline-block; padding: 5pt 10pt">
    Добавить
</a>
<a href="/shop/fromfile/" style="display:inline-block; padding: 5pt 10pt">
    Из файла
</a>
<a href="/shop/tofile/" style="display:inline-block; padding: 5pt 10pt">
    В файл
</a>
<@footer/>
</body>