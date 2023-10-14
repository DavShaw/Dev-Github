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
        if (this.middleName != null || !this.firstName.equalsIgnoreCase("")) {
            return String.format("%s %s %s %s", this.firstName, this.middleName, this.firstLastName, this.middleLastName);
        }
        return String.format("%s %s %s", this.firstName, this.firstLastName, this.middleLastName);
    }
}
