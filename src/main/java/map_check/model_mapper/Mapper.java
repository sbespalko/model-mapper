package map_check.model_mapper;

import java.lang.reflect.Type;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class Mapper<S, D> {

  private final ModelMapper modelMapper;

  @Autowired
  public Mapper(ModelMapper modelMapper) {
    this.modelMapper = modelMapper;
  }


  public ModelMapper getModelMapper() {
    return modelMapper;
  }

  public abstract Class<S> getSourceClass();
  public abstract Class<D> getDestinationClass();

  public S toDto(D task) {
    return getModelMapper().map(task, (Type) getSourceClass());
  }

  public D fromDto(S taskDto) {
    return getModelMapper().map(taskDto, (Type) getDestinationClass());
  }
}
