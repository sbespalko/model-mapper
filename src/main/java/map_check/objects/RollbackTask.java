package map_check.objects;

import java.util.List;
import map_check.tdo.RollbackTaskDto;

public class RollbackTask extends Task<RollbackTaskDto, RollbackTask> {
  private List<String> params;
  private String oldVersion;

  @Override
  public String toString() {
    return "RollbackTask{" +
        "params=" + params +
        ", oldVersion='" + oldVersion + '\'' +
        super.toString() +
        "} ";
  }

  @Override
  public RollbackTaskDto fillTo(RollbackTaskDto taskDto) {
    RollbackTaskDto dto =  super.fillTo(taskDto);
    dto.setParams(params);
    dto.setOldVersion(oldVersion);
    return dto;
  }

  @Override
  public RollbackTask fillFrom(RollbackTaskDto dto) {
    super.fillFrom(dto);
    params = dto.getParams();
    oldVersion = dto.getOldVersion();
    return this;
  }
}
