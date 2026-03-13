package co.istad.pisoth.fswd_sbapp.service;

import co.istad.pisoth.fswd_sbapp.domain.Category;
import co.istad.pisoth.fswd_sbapp.dto.CreateProductRequest;
import co.istad.pisoth.fswd_sbapp.dto.ProductResponse;
import co.istad.pisoth.fswd_sbapp.repository.CategoryRepository;
import co.istad.pisoth.fswd_sbapp.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository,
                              CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }


    @Override
    public ProductResponse createNew(CreateProductRequest createProductRequest) {
        // TODO
        // TODO: Validate Section
        // 1. Validate category id

        Category existingCategory = categoryRepository
                .findById(createProductRequest.categoryId())
                .orElseThrow(()-> new RuntimeException("Category ID don't exist!"));

        log.info("existing category: {}", existingCategory.getId());

        return null;
    }
}
