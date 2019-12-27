<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org"/>
<#include "../footer.ftl">
<#include "../header.ftl">
<head>
    <title>Товары</title>
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
                Тип
            </th>
            <th>
                Цена
            </th>
            <th>
                Количество
            </th>
            <th>
                Магазин
            </th>
            <th>
                Поставщик
            </th>
            <th>

            </th>
            <th>

            </th>
        </tr>
        <#if product_list??>
            <#list product_list as product>
                <tr>
                    <td>
                        ${product.name}
                    </td>
                    <td>
                        ${product.type.name}
                    </td>
                    <td>
                        ${product.price}
                    </td>
                    <td>
                        ${product.count}
                    </td>
                    <td>
                        ${product.shop.name}
                    </td>
                    <td>
                        ${product.supplier.name}
                    </td>
                    <td>
                        <a href="/product/edit/${product.id}">
                            Изменить
                        </a>
                    </td>
                    <td>
                        <a href="/product/delete/${product.id}">
                            Удалить
                        </a>
                    </td>
                </tr>
            </#list>
        </#if>
    </table>
    <a href="/product/add" style="display:inline-block; padding: 5pt 10pt">
        Добавить
    </a>
    <a href="/product/fromfile/" style="display:inline-block; padding: 5pt 10pt">
        Из файла
    </a>
    <a href="/product/tofile/" style="display:inline-block; padding: 5pt 10pt">
        В файл
    </a>
    <@footer/>
</body>