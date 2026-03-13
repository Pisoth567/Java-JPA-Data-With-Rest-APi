package co.istad.pisoth.fswd_sbapp.repository;

import co.istad.pisoth.fswd_sbapp.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}