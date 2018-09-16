package map_check.tdo;

import java.util.List;

public class UpdateTaskDto extends TaskDto {
  private List<String> params;
  private String oldVersion;
  private String newVersion;

  public List<String> getParams() {
    return params;
  }

  public void setParams(List<String> params) {
    this.params = params;
  }

  public String getOldVersion() {
    return oldVersion;
  }

  public void setOldVersion(String oldVersion) {
    this.oldVersion = oldVersion;
  }

  public String getNewVersion() {
    return newVersion;
  }

  public void setNewVersion(String newVersion) {
    this.newVersion = newVersion;
  }

  @Override
  public String toString() {
    return "UpdateTaskDto{" +
        "params=" + params +
        "} " + super.toString();
  }
}
