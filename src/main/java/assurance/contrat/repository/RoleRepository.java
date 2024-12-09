package assurance.contrat.repository;

import assurance.contrat.model.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface RoleRepository  {

    Optional<Role> findById(Long id);

    void save(Role role);

    int count();
}
