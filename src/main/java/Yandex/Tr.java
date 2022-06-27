package Yandex;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tr {
    private String text;
    private String pos;
    private Syn[] syn;
    private Syn[] mean;
    private Ex[] ex;
}
