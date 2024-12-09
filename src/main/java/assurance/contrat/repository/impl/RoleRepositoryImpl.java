package assurance.contrat.repository.impl;

import assurance.contrat.model.entities.Role;
import assurance.contrat.repository.RoleRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class RoleRepositoryImpl implements RoleRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Role> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Role.class, id));
    }

    @Override
    public void save(Role role) {
        entityManager.persist(role);
    }
    @Override
    public int count(){
            Long count = entityManager.createQuery("SELECT COUNT(r) FROM Role r", Long.class)
                    .getSingleResult();
            return count.intValue();
        }

}
