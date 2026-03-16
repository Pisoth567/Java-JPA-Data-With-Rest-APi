package co.istad.pisoth.fswd_sbapp.mapper;

import co.istad.pisoth.fswd_sbapp.domain.Product;
import co.istad.pisoth.fswd_sbapp.dto.CreateProductRequest;
import co.istad.pisoth.fswd_sbapp.dto.ProductResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductResponse productToProductResponse(Product product);
    Product createProductRequestToProduct(
            CreateProductRequest createProductRequest
    );
}
