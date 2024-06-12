# Оригинальный код и рефакторинг

## Teacher.java
### Оригинальный код:
`````
 public class Teacher {
    private String name;
    private int age;
    private String subject;

    public Teacher(String name, int age, String subject) {
        this.name = name;
        this.age = age;
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void displayTeacherDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Subject: " + subject);
    }
} 
`````
### Рефакторинг:
`````
 public class Teacher {
    private String name;
    private int age;
    private String subject;

    public Teacher(String name, int age, String subject) {
        this.name = name;
        this.age = age;
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
`````
### Применённые принципы:
Принцип единственной ответственности (SRP): Метод displayTeacherDetails нарушал SRP, так как вывод информации не является обязанностью модели Teacher. Метод был удален.

## TeacherController.java
### Оригинальный код:
`````
public class TeacherController {
    private TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    public void addTeacher(String name, int age, String subject) {
        Teacher teacher = new Teacher(name, age, subject);
        teacherService.saveTeacher(teacher);
    }

    public void showTeacherDetails() {
        Teacher teacher = teacherService.getTeacher();
        teacher.displayTeacherDetails();
    }
}
`````
### Рефакторинг:
`````
public class TeacherController {
    private TeacherService teacherService;
    private TeacherView teacherView;

    public TeacherController(TeacherService teacherService, TeacherView teacherView) {
        this.teacherService = teacherService;
        this.teacherView = teacherView;
    }

    public void addTeacher(String name, int age, String subject) {
        Teacher teacher = new Teacher(name, age, subject);
        teacherService.saveTeacher(teacher);
    }

    public void showTeacherDetails() {
        Teacher teacher = teacherService.getTeacher();
        teacherView.displayTeacherDetails(teacher);
    }
}
`````
### Применённые принципы:
Принцип единственной ответственности (SRP): Контроллер не должен заниматься отображением данных. Логика отображения перенесена в TeacherView.
Внедрение зависимостей (Dependency Injection): Внедрение зависимости TeacherService и TeacherView через конструктор позволяет легко заменять их при тестировании.

## TeacherService.java
### Оригинальный код:
`````
public class TeacherService {
    private Teacher teacher;

    public void saveTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Teacher getTeacher() {
        return teacher;
    }
}
`````
### Применённые принципы:
Принцип единственной ответственности (SRP): Сервис отвечает только за бизнес-логику. Код соответствует этому принципу и не требует изменений.

## TeacherView.java
### Оригинальный код:
`````
public class TeacherView {
    public void displayTeacherDetails(Teacher teacher) {
        System.out.println("Name: " + teacher.getName());
        System.out.println("Age: " + teacher.getAge());
        System.out.println("Subject: " + teacher.getSubject());
    }
}
`````
### Применённые принципы:
Разделение ответственности (Separation of Concerns): Представление данных выделено в отдельный класс.
Теперь весь код после рефакторинга:

## Teacher.java
`````
public class Teacher {
    private String name;
    private int age;
    private String subject;

    public Teacher(String name, int age, String subject) {
        this.name = name;
        this.age = age;
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
`````
## TeacherController.java
`````
public class TeacherController {
    private TeacherService teacherService;
    private TeacherView teacherView;

    public TeacherController(TeacherService teacherService, TeacherView teacherView) {
        this.teacherService = teacherService;
        this.teacherView = teacherView;
    }

    public void addTeacher(String name, int age, String subject) {
        Teacher teacher = new Teacher(name, age, subject);
        teacherService.saveTeacher(teacher);
    }

    public void showTeacherDetails() {
        Teacher teacher = teacherService.getTeacher();
        teacherView.displayTeacherDetails(teacher);
    }
}
`````
## TeacherService.java
`````
public class TeacherService {
    private Teacher teacher;

    public void saveTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Teacher getTeacher() {
        return teacher;
    }
}
`````
## TeacherView.java
`````
public class TeacherView {
    public void displayTeacherDetails(Teacher teacher) {
        System.out.println("Name: " + teacher.getName());
        System.out.println("Age: " + teacher.getAge());
        System.out.println("Subject: " + teacher.getSubject());
    }
}
`````

## В ходе рефакторинга были применены следующие принципы:

Принцип единственной ответственности (SRP): Обязанности разделены между классами.

Разделение ответственности (Separation of Concerns): Обособление представления данных в отдельный класс.

Внедрение зависимостей (Dependency Injection): Обеспечение легкости тестирования и гибкости кода.