public class TeacherService {
  private Teacher teacher;

  public void saveTeacher(Teacher teacher) {
      this.teacher = teacher;
  }

  public Teacher getTeacher() {
      return teacher;
  }
}

// Принцип единственной ответственности (SRP): Сервис отвечает только за бизнес-логику. Код соответствует этому принципу и не требует изменений.