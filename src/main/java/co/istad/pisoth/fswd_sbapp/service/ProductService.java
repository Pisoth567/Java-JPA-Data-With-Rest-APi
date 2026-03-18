package co.istad.pisoth.fswd_sbapp.service;

import co.istad.pisoth.fswd_sbapp.dto.CreateProductRequest;
import co.istad.pisoth.fswd_sbapp.dto.IsAvailableRequest;
import co.istad.pisoth.fswd_sbapp.dto.ProductResponse;
import co.istad.pisoth.fswd_sbapp.dto.UpdateProductRequest;
import org.springframework.data.domain.Page;

public interface ProductService {

    ProductResponse updateIsAvailableByCode(String code, IsAvailableRequest isAvailableRequest);

    ProductResponse updateProductPartiallyByCode(String code, UpdateProductRequest updateProductRequest);

    void deleteProductByCode(String code);

    Page<ProductResponse> getAllProducts(int pageNumber, int pageSize);

    ProductResponse createNew(CreateProductRequest createProductRequest);
}
