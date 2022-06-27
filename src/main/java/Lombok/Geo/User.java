package Lombok.Geo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private String surname;
    private Integer age;
    private  String phoneNumber;
    private  Address address;
    private  Company company;
}
