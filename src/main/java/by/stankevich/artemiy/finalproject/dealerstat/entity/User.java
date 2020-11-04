package by.stankevich.artemiy.finalproject.dealerstat.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "first_name",length = 32, nullable = false)
    @Size(min = 3, max = 32)
    private String firstName;

    @Column(name = "last_name", length = 32, nullable = false)
    @Size(min = 3, max = 32)
    private String lastName;

    @Column(name = "password", length = 128, nullable = false)
    @NotNull
    private String password;

    @Column(name = "emal", length = 128, unique = true, nullable = false)
    @Email(message = "email address should be correctly", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private String email;

    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Column(name = "status",nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;


}
