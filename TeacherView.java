public class TeacherView {
  public void displayTeacherDetails(Teacher teacher) {
      System.out.println("Name: " + teacher.getName());
      System.out.println("Age: " + teacher.getAge());
      System.out.println("Subject: " + teacher.getSubject());
  }
}

// Разделение ответственности (Separation of Concerns): Представление данных выделено в отдельный класс.
