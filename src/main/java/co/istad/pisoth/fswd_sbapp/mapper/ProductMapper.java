package co.istad.pisoth.fswd_sbapp.mapper;

import co.istad.pisoth.fswd_sbapp.domain.Product;
import co.istad.pisoth.fswd_sbapp.dto.CreateProductRequest;
import co.istad.pisoth.fswd_sbapp.dto.IsAvailableRequest;
import co.istad.pisoth.fswd_sbapp.dto.ProductResponse;
import co.istad.pisoth.fswd_sbapp.dto.UpdateProductRequest;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface ProductMapper {

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void isAvailableRequestToProduct(
			IsAvailableRequest isAvailableRequest,
			@MappingTarget Product product
	);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateProductRequestToProductPartially(
            UpdateProductRequest updateProductRequest,
            @MappingTarget Product product
    );

    ProductResponse productToProductResponse(Product product);
    Product createProductRequestToProduct(
            CreateProductRequest createProductRequest
    );
}