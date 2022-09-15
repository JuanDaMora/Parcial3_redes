package tech.angular.emplyeemanager.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import java.io.Serial;
import java.io.Serializable;

/**
 * @autor Juan David Morantes Vergara
 */
@NoArgsConstructor
@Getter
@Setter
public class EmployeeDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 218817058933170079L;
    private Long id;
    private String name;
    private String email;
    private String jobTitle;
    private String phone;
    private String imageUrl;
    private String employeCode;
}
