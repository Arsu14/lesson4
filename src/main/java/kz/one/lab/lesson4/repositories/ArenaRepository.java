package kz.one.lab.lesson4.repositories;

import kz.one.lab.lesson4.entity.Arena;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArenaRepository extends JpaRepository<Arena, Long> {
}
