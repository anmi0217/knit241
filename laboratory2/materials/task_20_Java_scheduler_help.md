### ✅ Интерфейс `ClipboardService`
```java
package clipboard;

public interface ClipboardService {
    void copyToClipboard(String content);
    void clearClipboard();
}
```

---

### ✅ Реализация `SystemClipboardService`

```java
package clipboard;

import java.awt.*;
import java.awt.datatransfer.*;
import org.springframework.stereotype.Service;

@Service
public class SystemClipboardService implements ClipboardService {

    private String lastCopied;

    @Override
    public void copyToClipboard(String content) {
        StringSelection selection = new StringSelection(content);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, null);
        lastCopied = content;
    }

    @Override
    public void clearClipboard() {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        try {
            String current = (String) clipboard.getData(DataFlavor.stringFlavor);
            if (current != null && current.equals(lastCopied)) {
                clipboard.setContents(new StringSelection(""), null);
                lastCopied = null;
                System.out.println("Буфер обмена очищен.");
            } else {
                System.out.println("Буфер обмена был изменён вручную — не очищаем.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

---

### 🔁 Использование с планировщиком
Пример интеграции:

```java
@Service
public class ClipboardCleaner {

    private final ClipboardService clipboardService;

    public ClipboardCleaner(ClipboardService clipboardService) {
        this.clipboardService = clipboardService;
    }

    public void scheduleClipboardClear(long delayMillis) {
        Executors.newSingleThreadScheduledExecutor()
                 .schedule(clipboardService::clearClipboard, delayMillis, TimeUnit.MILLISECONDS);
    }
}
```

---

### 📌 Пример вызова
```java
clipboardService.copyToClipboard("MySecret123!");
clipboardCleaner.scheduleClipboardClear(30_000); // очистить через 30 секунд
```

---
