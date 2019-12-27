<html xmlns:th="http://www.thymeleaf.org"/>
<#include "../footer.ftl">
<#include "../header.ftl">
<head>
    <title>Работники | Изменить</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="/css/styles.css" rel="stylesheet">
</head>
<body>
<@menu/>
<div class="form-style-2">
    <form method="post" action="/worker/edit/${worker.id}">
        <div class="field">
            <label for="name">
                Имя
            </label>
            <input type="text" class="input-field" name="name" id="name" value="${worker.name}">
        </div>
        <div class="field">
            <label for="secName">
                Фамилия
            </label>
            <input type="text" class="input-field" name="secName" id="secName" value="${worker.secName}">
        </div>
        <div class="field">
            <label for="phone">
                Контакт
            </label>
            <input type="text" class="input-field" name="phone" id="phone" value="${worker.phone}">
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
        <input type="submit" value="Добавить">
    </form>
</div>
<@footer/>
</body>