Тестовое задание

Создать сервис, который обращается к сервису курсов валют, и отображает gif:
• если курс по отношению к USD за сегодня стал выше вчерашнего, то отдаем рандомную отсюда https://giphy.com/search/rich
• если ниже - отсюда https://giphy.com/search/broke
Ссылки
• REST API курсов валют - https://docs.openexchangerates.org/
• REST API гифок - https://developers.giphy.com/docs/api#quick-start-guide
Must Have
• Сервис на Spring Boot 2 + Java / Kotlin
• Запросы приходят на HTTP endpoint (должен быть написан в соответствии с rest conventions), туда передается код валюты по отношению с которой сравнивается USD
• Для взаимодействия с внешними сервисами используется Feign
• Все параметры (валюта по отношению к которой смотрится курс, адреса внешних сервисов и т.д.) вынесены в настройки
• На сервис написаны тесты (для мока внешних сервисов можно использовать @mockbean или WireMock)
• Для сборки должен использоваться Gradle
• Результатом выполнения должен быть репо на GitHub с инструкцией по запуску
Nice to Have
• Сборка и запуск Docker контейнера с этим сервисом
    
Запуск:

1. Склонировать репозиторий, выполнив команду:
git clone https://github.com/AAZaykov/RandomGifService.git
    далее запустить как обычное Spring boot приложение

2. Перейти в корневую папку проекта и собрать проект:

./gradlew build

далее запустить:
./gradlew bootRun

3. Собрать докер-образ:

docker build -t randomgifservice .

Запустить контейнер с созданным образом:

docker run -p 8080:8080 randomgifservice

4. Oбраз с DockerHub

docker pull aazaykov/randomgifservice

Endpoints

/result

Пример
http://localhost:8080/result

Для изменения валюты, курс которой сравнивается с курсом USD, в файле application.properties изменить параметр currency на желаемый

