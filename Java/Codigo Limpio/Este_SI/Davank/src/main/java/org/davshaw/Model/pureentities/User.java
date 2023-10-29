package org.davshaw.Model.pureentities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString

@Entity
@Table(name = "User")
public class User
{

    @Id
    @Column(name = "dni")
    private Integer dni;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "middleName")
    private String middleName;

    @Column(name = "firstLastName")
    private String firstLastName;

    @Column(name = "middleLastName")
    private String middleLastName;

    @Column(name = "password")
    private String password;

    public String getFullName() {
        StringBuilder fullName = new StringBuilder();
    
        if (this.firstName != null && !this.firstName.isEmpty()) {
            fullName.append(this.firstName);
        }
    
        if (this.middleName != null && !this.middleName.isEmpty()) {
            if (fullName.length() > 0) {
                fullName.append(" ");
            }
            fullName.append(this.middleName);
        }
    
        if (this.firstLastName != null && !this.firstLastName.isEmpty()) {
            if (fullName.length() > 0) {
                fullName.append(" ");
            }
            fullName.append(this.firstLastName);
        }
    
        if (this.middleLastName != null && !this.middleLastName.isEmpty()) {
            if (fullName.length() > 0) {
                fullName.append(" ");
            }
            fullName.append(this.middleLastName);
        }
    
        return fullName.toString();
    }
    
}
