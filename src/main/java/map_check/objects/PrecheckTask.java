package map_check.objects;

import java.util.List;
import map_check.tdo.PrecheckTaskDto;

public class PrecheckTask extends Task<PrecheckTaskDto, PrecheckTask> {
  private List<String> params;

  @Override
  public String toString() {
    return "PrecheckTask{" +
        "params=" + params +
        super.toString() +
        "} ";
  }

  @Override
  public PrecheckTaskDto fillTo(PrecheckTaskDto taskDto) {
    PrecheckTaskDto dto = super.fillTo(taskDto);
    dto.setParams(params);
    return dto;
  }

  @Override
  public PrecheckTask fillFrom(PrecheckTaskDto dto) {
    super.fillFrom(dto);
    params = dto.getParams();
    return this;
  }
}
