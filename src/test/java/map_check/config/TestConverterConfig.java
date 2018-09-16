package map_check.config;

import map_check.manual.TaskConverter;
import map_check.model_mapper.Mapper;
import map_check.model_mapper.TaskMapper;
import map_check.model_mapper.util.LongAndLocalDateTime;
import map_check.objects.Task;
import map_check.tdo.TaskDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConverterConfig {

  @Bean
  public ModelMapper modelMapper() {
    ModelMapper mapper = new ModelMapper();
    mapper.getConfiguration().setFieldMatchingEnabled(true)
        .setFieldAccessLevel(AccessLevel.PRIVATE);
    return mapper;
  }

  @Bean
  public LongAndLocalDateTime longToLocalDateTime() {
    return new LongAndLocalDateTime();
  }

  @Bean
  @Autowired
  public Mapper<TaskDto, Task> taskMapper(LongAndLocalDateTime longAndLocalDateTime, ModelMapper modelMapper) {
    return new TaskMapper(longAndLocalDateTime, modelMapper);
  }

  @Bean
  public TaskConverter taskConverter() {
    return new TaskConverter();
  }


}
