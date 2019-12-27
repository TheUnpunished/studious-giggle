<html xmlns:th="http://www.thymeleaf.org"/>
<#include "../footer.ftl">
<#include "../header.ftl">
<head>
    <title>Товары | Добавить</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="/css/styles.css" rel="stylesheet">
</head>
<body>
    <@menu/>
        <div class="form-style-2">
            <form method="post" action="/product/add">
                <div class="field">
                    <label for="name">
                        Имя
                    </label>
                    <input type="text" name="name" id="name" class="input-field">
                </div>
                <div class="field">
                    <label for="price">
                        Цена
                    </label>
                    <input type="number" name="price" id="price" class="input-field" step=".01" min="0.01">
                </div>
                <div class="field">
                    <label for="count">
                        Количество
                    </label>
                    <input type="number" name="count" id="count" class="input-field" min="1">
                </div>
                <div class="field">
                    <label for="shop.id">
                        Адрес магазина
                    </label>
                    <select name="shop.id" id="shop.id" class="input-field">
                        <#list shop_list as shop>
                            <option value="${shop.id}" id="${shop.id}" name="${shop.name}">
                                ${shop.address}
                            </option>
                        </#list>
                    </select>
                </div>
                <div class="field">
                    <label for="supplier.id">
                        Поставщик
                    </label>
                    <select name="supplier.id" id="supplier.id" class="input-field">
                        <#list supplier_list as supplier>
                            <option value="${supplier.id}" id="${supplier.id}" name="${supplier.name}">
                                ${supplier.name}
                            </option>
                        </#list>
                    </select>
                </div>
                <div class="field">
                    <label for="type.id">
                        Разновидность
                    </label>
                    <select name="type.id" id="type.id" class="input-field">
                        <#list type_list as type>
                            <option value="${type.id}" id="${type.id}" name="${type.name}">
                                ${type.name}
                            </option>
                        </#list>
                    </select>
                </div>
                <input type="submit" value="Добавить">
            </form>
        </div>
    <@footer/>
</body>