<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Розклад автобусів</title>
        <style>
            body . {
                margin-left: 50px;
            }
            table tr {
                margin-bottom: 10px;
            }
            table tr td {
                text-align: center;
                margin-right: 10px;
                margin-left: 10px;
            }
            img {
                height: 50%;
                width: 50%;
            }
        </style>
    </head>
    <body>
        <h1>Сервіс розкладів автобусів</h1>
        <h2>Номери автобусів</h2>
        <ol>
            <li>Вінниця-Львів</li>
            <li>Вінниця-Київ</li>
            <li>Одеса-Житомир</li>
            <li>Львів-Одеса</li>
            <li>Херсон-Луцьк</li>
        </ol>
        <h2>Години прибуття автобусів</h2>
        <table border="2">
            <tr>
                <td>Номер автобусу</td>
                <td>Прибуття</td>
                <td>Відправлення</td>
            </tr>
            <tr>
                <td>1</td>
                <td>12:00, 20:00</td>
                <td>13:00, 21:00</td>
            </tr>
            <tr>
                <td>2</td>
                <td>7:00, 13:30</td>
                <td>7:30, 14:30</td>
            </tr>
            <tr>
                <td>3</td>
                <td>15:00, 16:00</td>
                <td>15:30, 16:45</td>
            </tr>
            <tr>
                <td>4</td>
                <td>11:00, 11:30</td>
                <td>19:00, 20:00</td>
            </tr>
            <tr>
                <td>5</td>
                <td>5:00, 7:00</td>
                <td>14:00, 15:15</td>
            </tr>
        </table>
        <h2>Карта маршрутів</h2>
        <img src="map.PNG" alt="Карта України">
        <h2>Відео-огляд</h2>
        <iframe width="560" height="315" src="https://www.youtube.com/embed/YBKyftyt8bs"
                title="YouTube video player" frameborder="0"
                allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope;
                picture-in-picture; web-share" allowfullscreen></iframe>
    </body>
</html>
