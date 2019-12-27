package ru.kpfu.icmit.Yakovlev.pharmancy.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SqlForm {
    private String sql;
}
