package assurance.contrat.config;


import assurance.contrat.model.entities.Role;
import assurance.contrat.model.enums.RoleType;
import assurance.contrat.repository.RoleRepository;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.ArrayList;

@Singleton
public class RoleInitializer {

    @Inject
    private RoleRepository roleRepository;

    @Inject
    private PlatformTransactionManager transactionManager;

    @PostConstruct
    public void initializeRoles() {
        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());

        try {
            if (roleRepository.count() == 0) {
                roleRepository.save(new Role(null, RoleType.ROLE_USER, new ArrayList<>()));
                roleRepository.save(new Role(null, RoleType.ROLE_ADMIN, new ArrayList<>()));
                System.out.println("Roles initialized successfully.");
            }
            transactionManager.commit(status);
        } catch (Exception e) {
            transactionManager.rollback(status);
            e.printStackTrace();
        }
    }
}
