package co.istad.pisoth.fswd_sbapp.repository;

import co.istad.pisoth.fswd_sbapp.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
    Page<Product> findByIsAvailableTrue(Pageable pageable);
}
