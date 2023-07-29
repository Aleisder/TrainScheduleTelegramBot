# TrainScheduleTelegramBot
___
Данные предоставлены сервисом [Яндекс.Расписания](http://rasp.yandex.ru/)
___
`TrainScheduleTelegramBot` предоставляет информацию о расписании электричек по Москве и Московской области (в стадии разработки).
___
Для запуска бота на своей локальной машине нужно заполнить файл `application.properties` следующим образом:
```properties
telegram.bot-name=[имя вашего бота]
telegram.token=[токен вашего бота]
telegram.url=https://api.telegram.org/
telegram.webhook=[адрес вашего вебхука]

yandex.token=[токен для доступа к API Яндекс]
```

Зарегистрировать кабинет разработчика и получить токен можно [здесь][1].

В качестве адреса для вебхука можно воспользоваться [ngrok][2].
___
[1]: https://developer.tech.yandex.ru/services
[2]: https://dashboard.ngrok.com/get-started/setup
[3]: https://yandex.st/rasp/media/apicc/copyright_horiz_yellow.html
