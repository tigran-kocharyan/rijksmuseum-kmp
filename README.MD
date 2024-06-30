# Kotlin Multiplatform приложение для Android и iOS
### [Школа мобильной разработки | Яндекс](https://yandex.ru/yaintern/schools/mobile)

## Технологии
- [Compose Multiplatform](https://github.com/JetBrains/compose-multiplatform) — UI
- [Ktor](https://github.com/ktorio/ktor) — работа с сетью
- [Voyager](https://github.com/adrielcafe/voyager) — навигация
- [Koin](https://github.com/InsertKoinIO/koin) — dependency injection
- [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) — многопоточность
- [Coil](https://github.com/coil-kt/coil) — загрузка изображений

Данные для отображения взяты из [Rijksmuseum API](https://data.rijksmuseum.nl/object-metadata/api/)

---

## Полезные ссылки
- [Гайд](https://www.jetbrains.com/help/kotlin-multiplatform-dev/multiplatform-setup.html) для настройки KMP окружения, обязательно к прочтению
- Набор доступных [библиотек](https://github.com/terrakok/kmp-awesome?tab=readme-ov-file) для KMP разработки
- [Wizard](https://terrakok.github.io/Compose-Multiplatform-Wizard/) для создания настроенного проекта с подключенными библиотеками на выбор

---

## Before running!
 - check your system with [KDoctor](https://github.com/Kotlin/kdoctor)
 - install JDK 17 or higher on your machine
 - add `local.properties` file to the project root and set a path to Android SDK there

### Android
To run the application on android device/emulator:  
 - open project in Android Studio and run imported android run configuration

To build the application bundle:
 - run `./gradlew :androidApp:assembleDebug`
 - find `.apk` file in `androidApp/build/outputs/apk/debug/androidApp-debug.apk`

### iOS
To run the application on iPhone device/simulator:
 - Open `iosApp/iosApp.xcproject` in Xcode and run standard configuration
 - Or use [Kotlin Multiplatform Mobile plugin](https://plugins.jetbrains.com/plugin/14936-kotlin-multiplatform-mobile) for Android Studio
