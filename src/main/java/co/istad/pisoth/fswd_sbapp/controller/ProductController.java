package co.istad.pisoth.fswd_sbapp.controller;

import co.istad.pisoth.fswd_sbapp.dto.CreateProductRequest;
import co.istad.pisoth.fswd_sbapp.dto.ProductResponse;
import co.istad.pisoth.fswd_sbapp.dto.UpdateProductRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.net.CacheRequest;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@Slf4j
public class ProductController {
    @GetMapping
    public List<ProductResponse> getAllProduct(
            @RequestParam(required = false, defaultValue = "0") int pageNumber,
            @RequestParam(required = false, defaultValue = "20") int pageSize
    ){
        log.info("pageNumber: {}, pageSize: {}",pageNumber, pageSize);
        return List.of();
    }

    @PostMapping
    public void createNewProduct(@RequestBody CreateProductRequest createProductRequest){
        log.info("createNewProduct: {}", createProductRequest);
    }

    @PutMapping("/{code}")
    public ProductResponse updateProductByCode(@PathVariable String code,
                                               @RequestBody UpdateProductRequest updateProductRequest){
        log.info("updateProductByCode: {}, with new data: {}", code, updateProductRequest);
        return null;
    }

    @PatchMapping("/{code}")
    public ProductResponse updateProductPartiallyByCode(@PathVariable String code,
                                                        @RequestBody UpdateProductRequest updateProductRequest){
        log.info("updateProductPartiallyByCode: {}, with new data: {}", code, updateProductRequest);
        return null;
    }

    @DeleteMapping("/{code}")
    public void deleteProductByCode(@PathVariable String code){
        log.info("deleteProductByCode: {}",code);
    }

}
