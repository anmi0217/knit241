## 🔹 5. Фильтрация HTTP-запросов

---

### 🔍 Что такое `Filter`

**`javax.servlet.Filter`** (или `jakarta.servlet.Filter` с Java EE 9+) — это механизм перехвата HTTP-запросов и ответов. Он работает **до** и **после** обработки контроллером.

Используется для:

- Логирования (`logging`)
- Аутентификации (`auth`)
- Измерения времени выполнения
- Модификации запросов/ответов (например, заголовков)
- Обезвреживания вредоносных входных данных

---

### 📦 Жизненный цикл фильтра

1. Клиент отправляет HTTP-запрос.
2. Запрос проходит через цепочку фильтров.
3. Только потом попадает в контроллер.
4. После контроллера — фильтр может обработать ответ.

---

### ✅ Реализация логирующего фильтра

```java
package org.knit.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        long start = System.currentTimeMillis();
        System.out.println("Запрос: " + req.getMethod() + " " + req.getRequestURI());

        chain.doFilter(request, response);

        long duration = System.currentTimeMillis() - start;
        System.out.println("Время обработки запроса: " + duration + " мс");
    }
}
```

---

### 🛠 Настройка вручную (если нужно)

Если ты хочешь указать порядок и URL-шаблоны:

```java
@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean<LoggingFilter> logFilter() {
        FilterRegistrationBean<LoggingFilter> reg = new FilterRegistrationBean<>();
        reg.setFilter(new LoggingFilter());
        reg.addUrlPatterns("/api/*"); // только на /api/...
        reg.setOrder(1); // порядок выполнения (меньше = выше приоритет)
        return reg;
    }
}
```

---

### 📋 Что можно логировать:

- Метод (`GET`, `POST`)
- URI (`/api/login`)
- IP-адрес клиента
- Время выполнения
- Статус ответа (с помощью `HttpServletResponseWrapper` — если нужно)

---
