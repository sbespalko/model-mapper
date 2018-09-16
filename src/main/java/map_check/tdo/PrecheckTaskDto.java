package map_check.tdo;

import java.util.List;

public class PrecheckTaskDto extends TaskDto{
  private List<String> params;

  public List<String> getParams() {
    return params;
  }

  public void setParams(List<String> params) {
    this.params = params;
  }

  @Override
  public String toString() {
    return "PrecheckTask{" +
        "params=" + params +
        "} " + super.toString();
  }
}
