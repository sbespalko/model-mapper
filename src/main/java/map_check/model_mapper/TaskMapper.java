package map_check.model_mapper;

import map_check.model_mapper.util.LongAndLocalDateTime;
import map_check.objects.Task;
import map_check.tdo.TaskDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper extends Mapper<TaskDto, Task> {

  private final LongAndLocalDateTime longAndLocalDateTime;

  @Autowired
  public TaskMapper(LongAndLocalDateTime longAndLocalDateTime, ModelMapper modelMapper) {
    super(modelMapper);
    this.longAndLocalDateTime = longAndLocalDateTime;
    //getModelMapper().createTypeMap(Task.class, TaskDto.class).
    //getModelMapper().addMappings(new TaskDtoMap());
  }

  @Override
  public Class<TaskDto> getSourceClass() {
    return TaskDto.class;
  }

  @Override
  public Class<Task> getDestinationClass() {
    return Task.class;
  }


  /*  public class TaskDtoMap extends PropertyMap<TaskDto, Task> {

      protected void configure() {
        map().setTime(longToLocalDateTime.convert(source.getTime()));
      }
    }*/
}
