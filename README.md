# TrainScheduleTelegramBot
___
Данные предоставлены сервисом [Яндекс.Расписания](http://rasp.yandex.ru/)
___
`TrainScheduleTelegramBot` предоставляет информацию о расписании электричек по Москве и Московской области (в стадии разработки).

<img src="https://github.com/Aleisder/TrainScheduleTelegramBot/assets/104721960/3fe6f0b2-f1e7-454e-b16c-4abdea754937" width="300">


___
# Стек
- [Spring Boot](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web)
- [Telegram API](https://mvnrepository.com/artifact/org.telegram/telegrambots-spring-boot-starter)
- [MongoDB](https://mvnrepository.com/artifact/org.springframework.data/spring-data-mongodb)
- [Gson](https://mvnrepository.com/artifact/com.google.code.gson/gson)
___
# Запуск
Для запуска бота на своей локальной машине нужно заполнить файл `application.properties` следующим образом:
```properties
telegram.bot-name=[имя вашего бота]
telegram.token=[токен вашего бота]
telegram.url=https://api.telegram.org/
telegram.webhook=[адрес вашего вебхука]
mongo.url=[строка соединения с вашей БД Mongo]
yandex.token=[токен для доступа к API Яндекс]
```

Зарегистрировать кабинет разработчика и получить токен можно [здесь][1].

В качестве адреса для вебхука можно воспользоваться [ngrok][2].

Подключение бота реализовано как с помощью `SpringWebhookBot`, так и через `TelegramLongPollingBot`.
___
[1]: https://developer.tech.yandex.ru/services
[2]: https://dashboard.ngrok.com/get-started/setup
[3]: https://yandex.st/rasp/media/apicc/copyright_horiz_yellow.html
