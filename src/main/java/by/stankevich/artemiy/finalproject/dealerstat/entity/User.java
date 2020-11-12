package by.stankevich.artemiy.finalproject.dealerstat.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User extends AuditModel {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @NotNull
    @Column(name = "first_name")
    @Size(min = 3, max = 32)
    private String firstName;

    @Column(name = "last_name")
    @Size(min = 3, max = 32)
    @NotNull
    private String lastName;

    @Size(min = 5, max = 100)
    @NotNull
    private String password;

    @Column(name = "email", unique = true)
    @Size(max = 50)
    @NotNull
    @Email(message = "email address should be correctly", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private String email;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    private boolean status;

    private double avgRating;

}
