package tech.angular.emplyeemanager.model;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serial;
import java.io.Serializable;
/**
 * @autor Juan David Morantes Vergara
 */
@Entity
@Getter
@Setter
public class Employee implements Serializable  {
    @Serial
    private static final long serialVersionUID = -253429843111930606L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false, updatable = false)
    private Long id;
    @NotBlank(message = "Name cannot be empty or null")
    private String name;
    @NotBlank(message = "Email cannot be empty or null")
    private String email;
    @NotBlank(message = "jobTitle cannot be empty or null")
    private String jobTitle;
    private String phone;
    private String imageUrl;
    @Column(nullable=false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String employeCode;

    @Override
    public String toString(){
        return "Employee{" +
                "id="+ id +
                ", name='"+name+'\'' +
                ", email='"+email+'\'' +
                ", jobTitle='"+jobTitle+'\'' +
                ", phone='"+phone+'\'' +
                ", imageUrl='"+imageUrl+'\'' +
                '}';
    }
}


