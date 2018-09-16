package map_check.model_mapper.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class LongAndLocalDateTime {

  public static LocalDateTime convert(Long source) {
    return source == null ? null
        : LocalDateTime.ofInstant(Instant.ofEpochMilli(source), ZoneId.of("Europe/Moscow"));
  }

  public static Long convert(LocalDateTime source) {
    return source == null ? null
        : source.atZone(ZoneId.of("Europe/Moscow")).toInstant().toEpochMilli();
  }
}
