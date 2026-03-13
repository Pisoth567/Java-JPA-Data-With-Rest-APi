package co.istad.pisoth.fswd_sbapp.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Currency;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String address;

    @Column(nullable = false)
    private String orderedBy;

    @Column(nullable = false)
    private Instant orderedAt;

    @Column(nullable = false)
    private Boolean isDeleted;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetail;
}
