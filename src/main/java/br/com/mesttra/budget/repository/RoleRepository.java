package br.com.mesttra.budget.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mesttra.budget.entity.Role;
import br.com.mesttra.budget.enums.ERole;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByName(ERole name);

}
