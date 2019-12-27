<html xmlns:th="http://www.thymeleaf.org"/>
<#include "../footer.ftl">
<#include "../header.ftl">
<head>
    <title>Тип | Изменить</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="/css/styles.css" rel="stylesheet">
</head>
<body>
<@menu/>
<div class="form-style-2">
    <form method="post" action="/type/edit/${type.id}">
        <div class="field">
            <label for="name">
                Имя
            </label>
            <input class="input-field" name="name" id="name" value="${type.name}">
        </div>
        <input type="submit" value="Добавить">
    </form>
</div>
<@footer/>
</body>