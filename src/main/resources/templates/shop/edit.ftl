<html xmlns:th="http://www.thymeleaf.org"/>
<#include "../footer.ftl">
<#include "../header.ftl">
<head>
    <title>Магазины | Изменить</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="/css/styles.css" rel="stylesheet">
</head>
<body>
<@menu/>
<div class="form-style-2">
    <form method="post" action="/shop/edit/${shop.id}">
        <div class="field">
            <label for="name">
                Имя
            </label>
            <input class="input-field" name="name" id="name" value="${shop.name}">
        </div>
        <div class="field">
            <label for="address">
                Адрес
            </label>
            <input class="input-field" name="address" id="address" value="${shop.address}">
        </div>
        <div class="field">
            <label for="phone">
                Контакт
            </label>
            <input class="input-field" name="phone" id="phone" value="${shop.phone}">
        </div>
        <input type="submit" value="Изменить">
    </form>
</div>
<@footer/>
</body>