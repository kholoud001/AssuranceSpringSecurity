package assurance.contrat.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    @NotEmpty(message = "Name is required")
    private String name;

    @Column
    @NotEmpty(message = "Address is required")
    private String address;

    @Column
    @NotEmpty(message = "Phone number is required")
    private String phone;

    @Column(nullable = false, unique = true)
    @Email(message = "Invalid email format")
    @NotEmpty(message = "Email is required")
    private String email;

    @Column(nullable = false)
    @NotEmpty(message = "Password is required")
    private String password;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Insurance> insurances;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "role_id")
    private Role role;



}
