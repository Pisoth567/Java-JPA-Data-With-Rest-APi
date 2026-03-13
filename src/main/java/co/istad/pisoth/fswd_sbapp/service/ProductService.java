package co.istad.pisoth.fswd_sbapp.service;

import co.istad.pisoth.fswd_sbapp.dto.CreateProductRequest;
import co.istad.pisoth.fswd_sbapp.dto.ProductResponse;

public interface ProductService {
    ProductResponse createNew(CreateProductRequest createProductRequest);
}
