package map_check.manual;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import map_check.objects.PrecheckTask;
import map_check.objects.RollbackTask;
import map_check.objects.UpdateTask;
import map_check.tdo.PrecheckTaskDto;
import map_check.tdo.RollbackTaskDto;
import map_check.tdo.UpdateTaskDto;

public class TaskConverter {

  private static final Map<Class<?>, Function<?, ?>> convertionMap = convertionMap();

  private static Map<Class<?>, Function<?, ?>> convertionMap() {
    Map<Class<?>, Function<?, ?>> map = new HashMap<>();
    map.put(UpdateTask.class, task -> ((UpdateTask) task).fillTo(new UpdateTaskDto()));
    map.put(PrecheckTask.class, task -> ((PrecheckTask) task).fillTo(new PrecheckTaskDto()));
    map.put(RollbackTask.class, task -> ((RollbackTask) task).fillTo(new RollbackTaskDto()));

    map.put(UpdateTaskDto.class, dto -> new UpdateTask().fillFrom((UpdateTaskDto) dto));
    map.put(PrecheckTaskDto.class, dto -> new PrecheckTask().fillFrom((PrecheckTaskDto) dto));
    map.put(RollbackTaskDto.class, dto -> new RollbackTask().fillFrom((RollbackTaskDto) dto));
    return map;
  }

  public static <S, D> D convert(S source) {
    if (source == null) {
      return null;
    }
    Function<S, D> func = (Function<S, D>) convertionMap().get(source.getClass());
    if (func != null) {
      return func.apply(source);
    }
    throw new IllegalArgumentException("Not Registered class: " + source.getClass());
  }

  public static <S, D> List<D> converts(List<S> sources) {
    if (sources == null) {
      return null;
    }
    List<D> destinations = new ArrayList<>(sources.size());
    for (S source : sources) {
      destinations.add(TaskConverter.convert(source));
    }
    return destinations;
  }
}
