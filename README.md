# Проект с автотестами для мобильного приложения Wikipedia

## :gear: Стек технологий:
| IDEA | Java | Selenide | Selenoid | Allure Report | Gradle | Junit5 | GitHub | Jenkins | Rest-Assured | Appium | Browserstack |
|:--------:|:-------------:|:---------:|:-------:|:----:|:------:|:----:|:----:|:------:|:------:|:--------:|:--------:|
| <img src="images/Intelij_IDEA.svg" width="40" height="40"> | <img src="images/JAVA.svg" width="40" height="40"> | <img src="images/Selenide.svg" width="40" height="40"> | <img src="images/Selenoid.svg" width="40" height="40"> | <img src="images/Allure_Report.svg" width="40" height="40"> | <img src="images/Gradle.svg" width="40" height="40"> | <img src="images/Junit5.svg" width="40" height="40"> | <img src="images/GitHub.svg" width="40" height="40"> | <img src="images/Jenkins.svg" width="40" height="40"> | <img src="images/Rest-Assured.svg" width="40" height="40"> | <img src="images/Appium.svg" width="40" height="40"> | <img src="images/Browserstack.svg" width="40" height="40"> |
___

## :heavy_check_mark: Тестируемая функциональность
- Получение данных всех пользователей
- Получение данных пользователя по id
- Получение данных пользователя по id (Пользователь не найден)
- Создание нового пользователя
- Изменение данных пользователя
- Удаление пользователя
- Успешная регистрация пользователя
- Неуспешная регистрация пользователя
- Успешная авторизация пользователя
- Неуспешная авторизация пользователя

## :pushpin: В качестве CI системы использован Jenkins
### [Проект](https://jenkins.autotests.cloud/job/08-levikss-browserstack/)

![alt "Jenkins"](./images/Jenkins.png "Jenkins")

## :arrow_forward: Запуск тестов

Для запуска тестов необходим файл credential.properties
```bash
browserStackUser=<значение User с Browserstack>
browserStackKey=<значение Key с Browserstack>
browserStackAppURL=bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c // для Samsung Galaxy S9
selenoidUser=<значение User с selenoid.autotests.cloud>
selenoidPass=<значение Pass с selenoid.autotests.cloud>
```
Для запуска тестов на реальном устройстве необходимо выполнить следующую команду:
```bash
gradle clean local
```
Для запуска тестов в selenoid необходимо выполнить следующую команду:

```bash
gradle clean selenoid
```
Для запуска тестов на сервисе browserstack необходимо выполнить следующую команду:

```bash
gradle clean browserstack
```

## :bar_chart: Генерация отчета происходит в Allure Report

Для генерации отчета необходимо выполнить следующую команду:

```bash
allure serve build/allure-results
```

![alt "Allure Report"](./images/Allure_report1.png "Allure Report")

К каждому тесту прикладываются:
- Скриншоты
- Исходники страницы
- Видео

![alt "Allure Report"](./images/Allure_report2.png "Allure Report")

## :movie_camera: Видео с прохождением теста на поиск в мобильном приложении Wikipedia

![alt "Video"](./images/Video.gif "Video") 
