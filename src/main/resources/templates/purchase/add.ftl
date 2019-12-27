<html xmlns:th="http://www.thymeleaf.org"/>
<#include "../footer.ftl">
<#include "../header.ftl">
<head>
    <title>Покупки | Добавить</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="/css/styles.css" rel="stylesheet">
</head>
<body>
<@menu/>
<div class="form-style-2">
    <form method="post" action="/purchase/add">
        <div class="field">
            <label for="product.id">
                Товар
            </label>
            <select id="product.id" name="product.id" class="input-field">
                <#list product_list as product>
                    <option name="${product.name}" id="${product.id}" value="${product.id}">
                        ${product.name} по адресу: ${product.shop.address}
                    </option>
                </#list>
            </select>
        </div>
        <div class="field">
            <label for="price">
                Цена
            </label>
            <input type="number" name="totalPrice" id="totalPrice" class="input-field" min="0.01" step=".01">
        </div>
        <div class="field">
            <label for="count">
                Количество
            </label>
            <input type="number" name="count" id="count" class="input-field" min="1">
        </div>
        <div class="field">
            <label for="date">
                Дата покупки
            </label>
            <input type="date" name="date" id="date" class="input-field">
        </div>
        <input type="submit" value="Добавить">
    </form>
</div>
<@footer/>
</body>