package org.markandey.springsecuritydemo.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@Entity
public class StudentClass {

    @Id
    private int Student_id;
    private String name;
    private String skill;

}
