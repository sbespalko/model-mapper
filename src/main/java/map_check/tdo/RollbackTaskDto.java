package map_check.tdo;

import java.util.List;

public class RollbackTaskDto extends TaskDto {
  private List<String> params;
  private String oldVersion;

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

  @Override
  public String toString() {
    return "RollbackTaskDto{" +
        "params=" + params +
        ", oldVersion='" + oldVersion + '\'' +
        "} " + super.toString();
  }
}
