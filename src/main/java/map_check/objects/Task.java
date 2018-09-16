package map_check.objects;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import map_check.manual.TaskConverter;
import map_check.model_mapper.util.LongAndLocalDateTime;
import map_check.tdo.TaskDto;

public abstract class Task<D extends TaskDto, T extends Task> {

  private long id;
  private String name;
  private LocalDateTime time;
  private List<Task> preTasks;

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public List<Task> getPreTasks() {
    if (preTasks == null) {
      preTasks = Collections.emptyList();
    }
    return preTasks;
  }

  public LocalDateTime getTime() {
    return time;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Task task = (Task) o;

    return id == task.id;
  }

  @Override
  public int hashCode() {
    return (int) (id ^ (id >>> 32));
  }

  @Override
  public String toString() {
    return ", id=" + id +
        ", name='" + name + '\'' +
        ", time=" + time +
        ", preTasks=" + preTasks;
  }

  public D fillTo(D taskDto) {
    taskDto.setId(id);
    taskDto.setName(name);
    taskDto.setTime(LongAndLocalDateTime.convert(time));
    taskDto.setPreTasks(TaskConverter.converts(preTasks));
    return taskDto;
  }

  public T fillFrom(D dto) {
    id = dto.getId();
    name = dto.getName();
    preTasks = TaskConverter.converts(dto.getPreTasks());
    time = LongAndLocalDateTime.convert(dto.getTime());
    return (T) this;
  }
}
