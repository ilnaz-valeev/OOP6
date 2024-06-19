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

// Принцип единственной ответственности (SRP): Контроллер не должен заниматься отображением данных. Логика отображения перенесена в TeacherView.
// Внедрение зависимостей (Dependency Injection): Внедрение зависимости TeacherService и TeacherView через конструктор позволяет легко заменять их при тестировании.