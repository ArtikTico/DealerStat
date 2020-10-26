package by.stankevich.artemiy.finalproject.dealerstat.entity;


import by.stankevich.artemiy.finalproject.dealerstat.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.OffsetDateTime;
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

    @Column(name = "first_name",length = 128)
    private String firstName;

    @Column(name = "last_name", length = 128)
    private String lastName;

    @Column(name = "password", length = 128)
    private String password;

    @Column(name = "emal", length = 128, unique = true, nullable = false)
    private String email;

    @Column(name = "created_at")
    private OffsetDateTime createdAt;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;
}
