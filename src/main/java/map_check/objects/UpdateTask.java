package map_check.objects;

import java.util.List;
import map_check.tdo.UpdateTaskDto;

public class UpdateTask extends Task<UpdateTaskDto, UpdateTask> {

  private List<String> params;
  private String oldVersion;
  private String newVersion;

  @Override
  public String toString() {
    return "UpdateTask{" +
        "params=" + params +
        ", oldVersion='" + oldVersion + '\'' +
        ", newVersion='" + newVersion + '\'' +
        super.toString() +
        "} ";
  }

  @Override
  public UpdateTask fillFrom(UpdateTaskDto dto) {
    super.fillFrom(dto);
    params = dto.getParams();
    oldVersion = dto.getOldVersion();
    newVersion = dto.getNewVersion();
    return this;
  }

  @Override
  public UpdateTaskDto fillTo(UpdateTaskDto taskDto) {
    UpdateTaskDto exportDto = super.fillTo(taskDto);
    exportDto.setParams(params);
    exportDto.setOldVersion(oldVersion);
    exportDto.setNewVersion(newVersion);
    return exportDto;
  }
}
