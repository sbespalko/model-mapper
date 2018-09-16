package map_check.tdo;

import java.util.List;

public abstract class TaskDto {
  private long id;
  private String name;
  private long time;
  private List<TaskDto> preTasks;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<TaskDto> getPreTasks() {
    return preTasks;
  }

  public void setPreTasks(List<TaskDto> preTasks) {
    this.preTasks = preTasks;
  }

  public long getTime() {
    return time;
  }

  public void setTime(long time) {
    this.time = time;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    TaskDto taskDto = (TaskDto) o;

    return id == taskDto.id;
  }

  @Override
  public int hashCode() {
    return (int) (id ^ (id >>> 32));
  }

  @Override
  public String toString() {
    return "TaskDto{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", time=" + time +
        ", preTasks=" + preTasks +
        '}';
  }
}
