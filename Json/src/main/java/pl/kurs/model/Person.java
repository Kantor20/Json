package pl.kurs.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private Boolean isMarried;
    private List<String> hobbies;
    private List<Kid> kids;


}
