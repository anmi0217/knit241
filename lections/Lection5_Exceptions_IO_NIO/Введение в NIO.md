
---

#### Основные концепции NIO

Java NIO (New Input/Output) была впервые введена в Java 7 в пакете `java.nio`. NIO обеспечивает более гибкий и эффективный способ работы с данными благодаря таким концепциям, как **каналы** и **буферы**, которые заменяют потоки в традиционной модели IO.

Основные особенности NIO:

- **Каналы (Channels)**: В отличие от потоков, которые ориентированы на односторонний ввод или вывод, каналы являются двусторонними и могут поддерживать как чтение, так и запись. Это позволяет эффективно использовать ресурсы и управлять асинхронными операциями.
  
- **Буферы (Buffers)**: В NIO все данные проходят через буферы, которые позволяют накапливать данные для оптимизации чтения и записи. Буферы обеспечивают высокую производительность за счет минимизации обращений к операционной системе.

---

### Отличия NIO от стандартного IO

В отличие от стандартного IO, где чтение и запись данных происходит через потоки, NIO использует:

1. **Каналы (Channels)** — обеспечивают более быстрый и гибкий доступ к данным.
2. **Буферы (Buffers)** — временные хранилища данных, которые позволяют минимизировать количество операций ввода-вывода, улучшая производительность.

В стандартном IO потоков данные считываются и записываются без промежуточного накопления, а в NIO данные сохраняются в буфере и обрабатываются частями.

---

### Работа с `Path` и `Files` API

Одним из главных нововведений NIO является API для работы с файлами и каталогами через классы `Path` и `Files`.

1. **Класс `Path`**:  
   Этот класс представляет путь к файлу или папке. Он заменяет `File` из стандартного IO и является более удобным и гибким способом для работы с файловой системой.

   Пример создания пути:
   ```java
   import java.nio.file.Path;
   import java.nio.file.Paths;

   public class PathExample {
       public static void main(String[] args) {
           Path path = Paths.get("example.txt");
           System.out.println("Путь к файлу: " + path.toAbsolutePath());
       }
   }
   ```

2. **Класс `Files`**:  
   Класс `Files` содержит статические методы для выполнения основных операций с файлами и папками: создания, копирования, удаления, чтения и записи.

   - **Создание файла или папки**:
     ```java
     import java.nio.file.Files;
     import java.nio.file.Path;
     import java.nio.file.Paths;
     import java.io.IOException;

     public class FileOperationsExample {
         public static void main(String[] args) {
             Path filePath = Paths.get("newfile.txt");
             try {
                 Files.createFile(filePath);
                 System.out.println("Файл создан: " + filePath);
             } catch (IOException e) {
                 System.out.println("Ошибка при создании файла: " + e.getMessage());
             }
         }
     }
     ```

   - **Копирование файла**:
     ```java
     Path source = Paths.get("source.txt");
     Path destination = Paths.get("destination.txt");
     Files.copy(source, destination);
     ```

   - **Удаление файла**:
     ```java
     Files.delete(Paths.get("fileToDelete.txt"));
     ```

   - **Чтение и запись файлов с помощью `Files`**:  
     Класс `Files` также поддерживает удобные методы для чтения и записи текстовых данных.

     ```java
     // Запись текста в файл
     Path path = Paths.get("example.txt");
     Files.write(path, "Привет, мир!".getBytes());

     // Чтение текста из файла
     byte[] bytes = Files.readAllBytes(path);
     String content = new String(bytes);
     System.out.println(content);
     ```

---

### Channels и Buffers

Каналы и буферы — это основа NIO, обеспечивающая высокую производительность и гибкость при работе с большими объемами данных.

1. **Буферы (Buffers)**  
   Буфер — это контейнер, который хранит данные и управляет их позицией. Каждый буфер имеет три ключевых свойства:
   - **Position**: текущая позиция, указывающая, куда будут помещены данные при записи или откуда будут считываться при чтении.
   - **Limit**: максимальная позиция, до которой можно читать или записывать данные.
   - **Capacity**: общая емкость буфера.

   Пример работы с буфером:
   ```java
   import java.nio.ByteBuffer;

   public class BufferExample {
       public static void main(String[] args) {
           ByteBuffer buffer = ByteBuffer.allocate(10);
           for (int i = 0; i < buffer.capacity(); i++) {
               buffer.put((byte) i);
           }

           buffer.flip(); // Переключаем буфер из режима записи в режим чтения

           while (buffer.hasRemaining()) {
               System.out.println(buffer.get());
           }
       }
   }
   ```

2. **Каналы (Channels)**  
   Каналы представляют собой двусторонние потоки, позволяющие чтение и запись данных одновременно. Основные типы каналов:
   - **FileChannel**: используется для работы с файлами.
   - **SocketChannel**: используется для работы с сетевыми сокетами.

   Пример работы с `FileChannel`:
   ```java
   import java.io.RandomAccessFile;
   import java.nio.ByteBuffer;
   import java.nio.channels.FileChannel;
   import java.io.IOException;

   public class FileChannelExample {
       public static void main(String[] args) {
           try (RandomAccessFile file = new RandomAccessFile("example.txt", "rw");
                FileChannel channel = file.getChannel()) {

               // Запись данных в файл
               ByteBuffer buffer = ByteBuffer.allocate(48);
               buffer.put("Запись через FileChannel".getBytes());
               buffer.flip(); // Переключаем буфер в режим чтения
               channel.write(buffer);

               // Чтение данных из файла
               buffer.clear(); // Очищаем буфер для чтения данных
               channel.position(0); // Перемещаем позицию канала в начало файла
               channel.read(buffer);
               buffer.flip();

               while (buffer.hasRemaining()) {
                   System.out.print((char) buffer.get());
               }
           } catch (IOException e) {
               System.out.println("Ошибка при работе с каналом: " + e.getMessage());
           }
       }
   }
   ```

   В этом примере:
   - Сначала мы записываем данные в файл через `FileChannel`.
   - Затем перемещаем позицию канала в начало файла, очищаем буфер и читаем данные из файла.

---

1. **Java NIO** была введена для улучшения производительности ввода/вывода за счет использования **каналов** и **буферов**.
2. **Path и Files API** позволяют легко работать с файлами и папками, предоставляя удобные методы для создания, копирования, удаления и чтения/записи данных.
3. **Буферы** помогают временно хранить данные, оптимизируя операции ввода/вывода.
4. **Каналы**, такие как `FileChannel`, обеспечивают двусторонний доступ к файлам, позволяя читать и записывать данные одновременно.

Метод `Files.walkFileTree()` в Java используется для рекурсивного обхода файловой системы, начиная с определенного пути. Этот метод работает в сочетании с интерфейсом `FileVisitor`, который позволяет определить действия, которые будут выполняться при посещении каждого файла и каталога. Этот подход особенно полезен для сложных операций, таких как рекурсивное удаление, копирование, поиск и другие задачи, которые требуют обхода всех файлов и каталогов в дереве.

### Основные элементы `Files.walkFileTree`

- **`Files.walkFileTree(Path start, FileVisitor<? super Path> visitor)`** — метод для обхода дерева файлов, начиная с пути `start`.
- **`FileVisitor`** — интерфейс, который необходимо реализовать для определения действий при посещении файлов и каталогов. Он содержит следующие методы:
  - `preVisitDirectory(Path dir, BasicFileAttributes attrs)` — вызывается перед тем, как зайти в каталог.
  - `visitFile(Path file, BasicFileAttributes attrs)` — вызывается при посещении каждого файла.
  - `visitFileFailed(Path file, IOException exc)` — вызывается при ошибке доступа к файлу.
  - `postVisitDirectory(Path dir, IOException exc)` — вызывается после посещения всех файлов и подкаталогов в текущем каталоге.

### Пример использования `Files.walkFileTree`

Допустим, мы хотим обойти директорию и вывести все файлы и папки. Создадим класс, реализующий интерфейс `FileVisitor` и передадим его в метод `Files.walkFileTree`.

```java
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class FileTreeWalkerExample {
    public static void main(String[] args) {
        Path startPath = Paths.get("myDirectory"); // начальная директория для обхода

        try {
            Files.walkFileTree(startPath, new SimpleFileVisitor());
        } catch (IOException e) {
            System.out.println("Ошибка при обходе дерева файлов: " + e.getMessage());
        }
    }

    // Реализация FileVisitor для обхода файловой системы
    private static class SimpleFileVisitor implements FileVisitor<Path> {
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
            System.out.println("Каталог: " + dir.toString());
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
            System.out.println("Файл: " + file.toString());
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) {
            System.out.println("Ошибка доступа к файлу: " + file.toString());
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
            System.out.println("Завершение каталога: " + dir.toString());
            return FileVisitResult.CONTINUE;
        }
    }
}
```

### Описание работы кода

1. **`Files.walkFileTree(startPath, visitor)`** — запускает рекурсивный обход дерева файлов, начиная с директории `myDirectory`.
2. **`preVisitDirectory`** — вызывается перед входом в каждый каталог, здесь мы просто печатаем его имя.
3. **`visitFile`** — вызывается при посещении каждого файла, мы выводим путь к файлу.
4. **`visitFileFailed`** — вызывается при ошибке доступа к файлу, например, если файл заблокирован.
5. **`postVisitDirectory`** — вызывается после того, как каталог и его содержимое были обработаны.

### Управление обходом с помощью `FileVisitResult`

`FileVisitResult` — это перечисление, которое управляет процессом обхода:

- **`FileVisitResult.CONTINUE`** — продолжает обход.
- **`FileVisitResult.TERMINATE`** — завершает обход немедленно.
- **`FileVisitResult.SKIP_SUBTREE`** — пропускает текущий каталог и его содержимое.
- **`FileVisitResult.SKIP_SIBLINGS`** — пропускает оставшиеся файлы и каталоги на текущем уровне.

Пример пропуска определенного подкаталога:
```java
@Override
public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
    if (dir.getFileName().toString().equals("skipThisDirectory")) {
        return FileVisitResult.SKIP_SUBTREE;
    }
    System.out.println("Каталог: " + dir.toString());
    return FileVisitResult.CONTINUE;
}
```

### Пример рекурсивного удаления файлов и каталогов

С помощью `Files.walkFileTree` можно легко реализовать рекурсивное удаление содержимого каталога.

```java
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class DeleteDirectoryExample {
    public static void main(String[] args) {
        Path directoryToDelete = Paths.get("directoryToDelete");

        try {
            Files.walkFileTree(directoryToDelete, new DeleteFileVisitor());
            System.out.println("Каталог и его содержимое удалены.");
        } catch (IOException e) {
            System.out.println("Ошибка при удалении каталога: " + e.getMessage());
        }
    }

    private static class DeleteFileVisitor implements FileVisitor<Path> {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            Files.delete(file);
            System.out.println("Удален файл: " + file.toString());
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            Files.delete(dir);
            System.out.println("Удален каталог: " + dir.toString());
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            System.out.println("Не удалось удалить файл: " + file.toString());
            return FileVisitResult.CONTINUE;
        }
    }
}
```

### Описание работы кода

- **`visitFile`** — удаляет каждый файл в каталоге.
- **`postVisitDirectory`** — удаляет каталог после того, как его содержимое было обработано.
- **`visitFileFailed`** — сообщает об ошибке, если не удалось удалить файл, и продолжает обход.

### Пример поиска файлов с определенным расширением

Предположим, нужно найти все `.txt` файлы в каталоге и его подкаталогах.

```java
@Override
public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
    if (file.toString().endsWith(".txt")) {
        System.out.println("Найден файл: " + file.toString());
    }
    return FileVisitResult.CONTINUE;
}
```

### Заключение

`Files.walkFileTree` и интерфейс `FileVisitor` предоставляют гибкий и мощный способ обхода файловой системы. Они позволяют выполнять такие задачи, как:

- Рекурсивное удаление, копирование и перемещение файлов и каталогов.
- Поиск файлов с определенными характеристиками.
- Управление поведением обхода с помощью `FileVisitResult`.

Эти методы полезны для работы с файловыми структурами любой сложности и позволяют управлять обходом на каждом этапе.