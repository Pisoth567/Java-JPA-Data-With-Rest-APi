package co.istad.pisoth.fswd_sbapp.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    private String code;

    @Column(name = "name", nullable = false, unique = true, length = 50)
    private String name;

    @Column(nullable = false)
    private BigDecimal price;

    @ManyToOne
    private Category category;

    @Column(nullable = false)
    private Integer qty;

    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetail;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private Boolean isAvailable;
}
