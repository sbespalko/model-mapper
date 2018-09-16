package map_check.manual;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import map_check.config.TestConverterConfig;
import map_check.objects.PrecheckTask;
import map_check.objects.RollbackTask;
import map_check.objects.Task;
import map_check.objects.UpdateTask;
import map_check.tdo.PrecheckTaskDto;
import map_check.tdo.RollbackTaskDto;
import map_check.tdo.TaskDto;
import map_check.tdo.UpdateTaskDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(TestConverterConfig.class)
class TaskConverterTest {

  private static final Logger log = LogManager.getLogger();
  private TaskDto taskDto;
  private Set<TaskDto> preTasks;


  @BeforeEach
  void beforeEach() {
    TaskDto preTaskDto1 = precheckTaskDto(10, "preTask1", 0L, null);
    TaskDto preTaskDto2 = rollbackTaskDto(11, "preTask2", 0L, null);
    taskDto = updateTaskDto(1, "Test taskDto", 10L, Lists.newArrayList(preTaskDto1, preTaskDto2));
  }

  @Test
  void taskDtoToTask() {
    Task result = TaskConverter.convert(taskDto);
    log.debug(result);

    assertThat(result.getId()).isEqualTo(1);
    assertThat(result.getClass()).isEqualTo(UpdateTask.class);
  }

  private <T extends TaskDto> T taskDto(T dto, long id, String name, Long time,
      List<TaskDto> preTasks) {
    dto.setId(id);
    dto.setName(name);
    dto.setTime(time);
    dto.setPreTasks(preTasks);
    return dto;
  }

  private UpdateTaskDto updateTaskDto(long id, String name, Long time, List<TaskDto> preTasks) {
    UpdateTaskDto dto = taskDto(new UpdateTaskDto(), id, name, time, preTasks);
    dto.setParams(Arrays.asList("-f update"));
    dto.setOldVersion("v10");
    dto.setNewVersion("v11");
    return dto;
  }

  private RollbackTaskDto rollbackTaskDto(long id, String name, Long time, List<TaskDto> preTasks) {
    RollbackTaskDto dto = taskDto(new RollbackTaskDto(), id, name, time, preTasks);
    dto.setParams(Arrays.asList("-f rollback"));
    dto.setOldVersion("v09");
    return dto;
  }

  private PrecheckTaskDto precheckTaskDto(long id, String name, Long time, List<TaskDto> preTasks) {
    PrecheckTaskDto dto = taskDto(new PrecheckTaskDto(), id, name, time, preTasks);
    dto.setParams(Arrays.asList("-f rollback"));
    return dto;
  }

}