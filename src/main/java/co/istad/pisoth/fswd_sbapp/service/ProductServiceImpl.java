package co.istad.pisoth.fswd_sbapp.service;

import co.istad.pisoth.fswd_sbapp.domain.Category;
import co.istad.pisoth.fswd_sbapp.domain.Product;
import co.istad.pisoth.fswd_sbapp.dto.CreateProductRequest;
import co.istad.pisoth.fswd_sbapp.dto.IsAvailableRequest;
import co.istad.pisoth.fswd_sbapp.dto.ProductResponse;
import co.istad.pisoth.fswd_sbapp.dto.UpdateProductRequest;
import co.istad.pisoth.fswd_sbapp.mapper.ProductMapper;
import co.istad.pisoth.fswd_sbapp.repository.CategoryRepository;
import co.istad.pisoth.fswd_sbapp.repository.ProductRepository;
import co.istad.pisoth.fswd_sbapp.util.DataGenerateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository,
                              CategoryRepository categoryRepository,
                              ProductMapper productMapper){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductResponse updateIsAvailableByCode(String code, IsAvailableRequest isAvailableRequest) {
        log.info("updateIsAvailableByCode: {} and Status: {}", code, isAvailableRequest);

        // 1. validate
        Product product = productRepository.findById(code)
                .orElseThrow(()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Product code not found"
                ));
        productMapper.isAvailableRequestToProduct(isAvailableRequest, product);

        productRepository.save(product);

        return productMapper.productToProductResponse(product);
    }

    @Override
    public ProductResponse updateProductPartiallyByCode(String code, UpdateProductRequest updateProductRequest) {
        log.info("updateProductPartiallyByCode: {} and new data: {}", code, updateProductRequest);
        // 1. validate
        Product product = productRepository.findById(code)
                .orElseThrow(()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Product code not found"
                ));

        // 2. write partially update logic
        productMapper.updateProductRequestToProductPartially(updateProductRequest, product);

        product = productRepository.save(product);
        return productMapper.productToProductResponse(product);
    }

    @Override
    public void deleteProductByCode(String code) {
        log.info("deleteProductByCode: {}", code);

        // 1. validate
        Product product = productRepository.findById(code)
                .orElseThrow(()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Product code not found"
                ));

        productRepository.delete(product);
    }

    @Override
    public Page<ProductResponse> getAllProducts(int pageNumber, int pageSize) {
        log.info("getAllProduct with pageNumber: {}, pageSize: {}", pageNumber,pageSize);

        // 1. setup page request
        Pageable pageable = PageRequest.of(pageNumber, pageSize);

        // 2. Find data from database with page request
        Page<Product> productResponsePage = productRepository.findAll(pageable);

        return productResponsePage.map(productMapper::productToProductResponse);
    }

    @Override
    public ProductResponse createNew(CreateProductRequest createProductRequest) {
        // TODO
        // TODO: Validate Section
        // 1. Validate category id

        Category existingCategory = categoryRepository
                .findById(createProductRequest.categoryId())
                .orElseThrow(()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Category ID don't exist!"));

        log.info("existing category: {}", existingCategory.getId());

        // 2. Transfer dto (request) to entity
        // TODO: By your self
//        Product product = new Product();
//        product.setName(createProductRequest.name());
//        product.setQty(createProductRequest.qty());
//        product.setQty(createProductRequest.qty());
//        product.setPrice(createProductRequest.price());
//        product.setDescription(createProductRequest.description());

        //TODO: using library
        Product product = productMapper.createProductRequestToProduct(createProductRequest);

        product.setCategory(existingCategory);
        product.setCode(DataGenerateUtil.generateProductCode());
        product.setIsAvailable(true);

        // 3. Save entity into database using repository
        product = productRepository.save(product);

        // 4. Transfer entity to dto (response)
        // TODO: when you build with your self
//        return ProductResponse.builder()
//                .code(product.getCode())
//                .name(product.getName())
//                .qty(product.getQty())
//                .price(product.getPrice())
//                .description(product.getDescription())
//                .isAvailable(product.getIsAvailable())
//                .build();

        // TODO: using library
        return productMapper.productToProductResponse(product);
    }
}
