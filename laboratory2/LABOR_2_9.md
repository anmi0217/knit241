# **Лабораторная работа часть 2 № 9** Задача 22

## **Тема:** Создание REST API для отображения координат, времени и временных зон городов мира

8 баллов
---

## **Цель работы**

Закрепить навыки создания REST-приложения на Spring Boot:
- Работа с чтением данных из файла
- Создание сервисного слоя
- Работа с датами, часовыми поясами
- Создание контроллеров
- Тестирование API через Postman или curl

---

## **Ход работы**

### **Шаг 1. Подготовка проекта**

1. Использовать проект с прошлого задания или создать новый аналогичным способом.
2. В папке `src/main/resources` создать файл `cities.csv` со следующей структурой:

```
City,Country,Latitude,Longitude,Timezone
Moscow,Russia,55.7558,37.6176,Europe/Moscow
New York,USA,40.7128,-74.0060,America/New_York
Tokyo,Japan,35.6895,139.6917,Asia/Tokyo
Paris,France,48.8566,2.3522,Europe/Paris
Sydney,Australia,-33.8688,151.2093,Australia/Sydney
```

---

### **Шаг 2. Модель данных**

Создайте новый класс:

```java
package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityInfo {
    private String city;
    private String country;
    private double latitude;
    private double longitude;
    private String timezone;
    private String localTime;  // текущее местное время
    private String utcTime;    // текущее UTC время в формате UFC (ISO 8601)
}
```

---

### **Шаг 3. Сервис для загрузки данных**

Создайте сервис для чтения файла и расчёта времени:

```java
package com.example.demo.service;

import com.example.demo.model.CityInfo;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class CityService {

    private final List<CityInfo> cities = new ArrayList<>();

    @PostConstruct
    public void init() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                getClass().getClassLoader().getResourceAsStream("cities.csv"), StandardCharsets.UTF_8))) {
            String line;
            reader.readLine(); // пропустить заголовок
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    cities.add(new CityInfo(
                            parts[0],
                            parts[1],
                            Double.parseDouble(parts[2]),
                            Double.parseDouble(parts[3]),
                            parts[4],
                            null, // временно, заполним позже
                            null
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<CityInfo> getAllCities() {
        return enrichCitiesWithTime(cities);
    }

    public CityInfo getCityByName(String name) {
        return cities.stream()
                .filter(c -> c.getCity().equalsIgnoreCase(name))
                .map(this::enrichCityWithTime)
                .findFirst()
                .orElse(null);
    }

    private List<CityInfo> enrichCitiesWithTime(List<CityInfo> cityList) {
        List<CityInfo> updated = new ArrayList<>();
        for (CityInfo city : cityList) {
            updated.add(enrichCityWithTime(city));
        }
        return updated;
    }

    private CityInfo enrichCityWithTime(CityInfo city) {
        try {
            ZonedDateTime now = ZonedDateTime.now(ZoneId.of(city.getTimezone()));
            city.setLocalTime(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            city.setUtcTime(Instant.now().toString()); // UFC-формат (ISO 8601, UTC)
        } catch (Exception e) {
            city.setLocalTime("Unknown");
            city.setUtcTime("Unknown");
        }
        return city;
    }
}
```

---

### **Шаг 4. Создание REST-контроллера**

```java
package com.example.demo.controller;

import com.example.demo.model.CityInfo;
import com.example.demo.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @GetMapping
    public List<CityInfo> getAllCities() {
        return cityService.getAllCities();
    }

    @GetMapping("/{name}")
    public CityInfo getCityByName(@PathVariable String name) {
        return cityService.getCityByName(name);
    }
}
```

---

### **Шаг 5. Тестирование через Postman или curl**

**Примеры запросов:**

- Все города:
```http
GET http://localhost:8080/api/cities
```

- Один город по имени:
```http
GET http://localhost:8080/api/cities/Moscow
```

**Пример ответа для одного города:**

```json
{
  "city": "Moscow",
  "country": "Russia",
  "latitude": 55.7558,
  "longitude": 37.6176,
  "timezone": "Europe/Moscow",
  "localTime": "2025-04-25 22:40:13",
  "utcTime": "2025-04-25T18:40:13Z"
}
```

---

## **Дополнительное задание (по желанию)** +2 балла за (1 и 2) и +4 балла за 3 

1. Добавить возможность искать города по стране или по временной зоне.
2. Отдельный эндпоинт `/api/cities/time/{name}` который будет возвращать только текущее местное и UFC-время города.
3. Вывести дополнительное поле timeDescription (+4 балла) 
```
{
  "city": "Moscow",
  "country": "Russia",
  "latitude": 55.7558,
  "longitude": 37.6176,
  "timezone": "Europe/Moscow",
  "localTime": "2025-04-25 22:40:13",
  "utcTime": "2025-04-25T19:40:13Z",
  "timeDescription": "Moscow: 22:40 (+3 UTC)"
}

```

---

## **Примечание**

Для расширения базы данных можно скачать актуальные данные:
- [Simplemaps World Cities CSV](https://simplemaps.com/data/world-cities) — компактная база для практики.
- [GeoNames Cities](https://www.geonames.org/export/) — большая база для продвинутой работы.