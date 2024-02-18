package com.homedecor.rest.service;

import com.homedecor.rest.common.exceptions.CustomDataIntegrityViolationException;
import com.homedecor.rest.common.exceptions.RecordNotFoundException;
import com.homedecor.rest.common.messages.BaseResponse;
import com.homedecor.rest.common.messages.CustomMessage;
import com.homedecor.rest.dto.*;
import com.homedecor.rest.entity.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductMasterServiceImpl implements ProductMasterService {
    @Autowired
    com.homedecor.rest.repo.ProductMasterDao ProductMasterDao;

    @Autowired
    com.homedecor.rest.repo.UserDao userDao;

    @Override
    public List<ProductMasterDto> getAllProduct() {
        return ProductMasterDao.findAllProducts().stream().map(this::copyEntityToDto).collect(Collectors.toList());
    }

    @Override
    public ProductMasterDto findByProductId(Long id) {
        if (ProductMasterDao.existsById(id)) {
            ProductMaster ProductMaster = ProductMasterDao.findById(id);
            return copyEntityToDto(ProductMaster);
        } else {
            throw new RecordNotFoundException(CustomMessage.DOESNOT_EXIT + id);
        }
    }

    @Override
    public BaseResponse deleteProductById(Long id) {
        if (ProductMasterDao.existsById(id)) {
            ProductMasterDao.deleteById(id);
        } else {
            throw new RecordNotFoundException(CustomMessage.NO_RECOURD_FOUND + id);
        }
        return new BaseResponse(CustomMessage.USER_DELETE_SUCCESS_MESSAGE);
    }

    @Override
    public BaseResponse createOrUpdateProduct(ProductMasterDto productMasterDto) {
        try {
            ProductMaster ProductMaster = copyDtoToEntity(productMasterDto);
            ProductMasterDao.save(ProductMaster);
        } catch (DataIntegrityViolationException ex) {
            throw new CustomDataIntegrityViolationException(ex.getCause().getCause().getMessage());
        }
        return new BaseResponse(CustomMessage.PRODUCT_SAVE_SUCCESS_MESSAGE);
    }

    @Override
    public List<ProductMasterDto> getProductByUserId(Long userId) {
       return ProductMasterDao.findByuserId(userId).stream().map(this::copyEntityToDto).collect(Collectors.toList());
    }

    @Override
    public Wishlist saveWishlist(WishlistDto wishlistDto) {
        Wishlist wishlist = new Wishlist();

        User user = new User ();
        user.setUserId(wishlistDto.getUserId());
        ProductMaster product = new ProductMaster();
        product.setProductId(wishlistDto.getProductId());
        wishlist.setUserId(user);
        wishlist.setProductMaster(product);

        return ProductMasterDao.saveWishlist(wishlist);
    }

    @Override
    public List<WishlistProductDTO> getWishlistProductsByUserId(Long userId) {
        List<Wishlist> wishlistItems = ProductMasterDao.findByUserId_UserId(userId);
        List<WishlistProductDTO> wishlistProducts = new ArrayList<>();

        for (Wishlist wishlistItem : wishlistItems) {
            WishlistProductDTO wishlistProductDTO = new WishlistProductDTO();
            wishlistProductDTO.setWishlistId(wishlistItem.getWishlistId());
            ProductMaster productMaster= wishlistItem.getProductMaster();
            ProductMasterDto productMasterDto = copyEntityToDto(productMaster);
            productMasterDto.setProductName(productMaster.getProductName());
            wishlistProductDTO.setProduct(productMasterDto);
            wishlistProducts.add(wishlistProductDTO);
        }

        return wishlistProducts;
    }

    @Override
    public void deleteWishlistByProductId(Long productId) {
        ProductMasterDao.deleteByProductMaster_ProductId(productId);
    }

    @Override
    public void addToCart(CartRequestDto cartRequest) {
        Cart cartItem = new Cart();
        cartItem.setCartQuantity(cartRequest.getQuantity());
        ProductMaster productMaster = new ProductMaster();
        productMaster.setProductId(cartRequest.getProductId());
        cartItem.setProductMaster(productMaster);
        User user = userDao.findByUserId(cartRequest.getUserId());
        cartItem.setUserId(user);
        ProductMasterDao.saveCart(cartItem);
    }

    @Override
    public void updateCartItem(CartRequestDto cartRequest) {
        Cart existingCartItem = ProductMasterDao.findByCartId(cartRequest.getCartId()).get();
        existingCartItem.setCartQuantity(cartRequest.getQuantity());
//        ProductMaster productMaster = new ProductMaster();
//        productMaster.setProductId(cartRequest.getProductId());
//        existingCartItem.setProductMaster(productMaster);
//        User user = new User();
//        user.setUserId(cartRequest.getUserId());
//        existingCartItem.setUserId(user);
        ProductMasterDao.saveCart(existingCartItem);

    }

    @Override
    public void deleteCartItem(Long cartId) {
        ProductMasterDao.deleteCartById(cartId);
    }

    @Override
    public List<CartItemResponseDto> getUserCart(Long userId) {
        List<Cart> cartItems = ProductMasterDao.findCartByUserId(userId);
        List<CartItemResponseDto> cartItemResponses = new ArrayList<>();
        for (Cart cartItem : cartItems) {
            CartItemResponseDto cartItemResponse = new CartItemResponseDto();
            cartItemResponse.setCartId(cartItem.getCartId());
            cartItemResponse.setQuantity(cartItem.getCartQuantity());
            ProductMaster productMaster = cartItem.getProductMaster();
            cartItemResponse.setProductMasterDto(copyEntityToDto(productMaster));
            cartItemResponses.add(cartItemResponse);
        }
        return cartItemResponses;
    }


    private ProductMasterDto copyEntityToDto(ProductMaster productMaster) {
        ProductMasterDto ProductMasterDto = new ProductMasterDto();
        BeanUtils.copyProperties(productMaster, ProductMasterDto);

        if (productMaster.getCategory() != null) {
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setCategoryId(productMaster.getCategory().getCategoryId());
            categoryDto.setCategoryName(productMaster.getCategory().getCategoryName());
            ProductMasterDto.setCategoryDto(categoryDto);
        }
        if (productMaster.getBrand() != null) {
            BrandDto brandDto = new BrandDto();
            brandDto.setBrandId(productMaster.getBrand().getBrandId());
            brandDto.setBrandName(productMaster.getBrand().getBrandName());
            ProductMasterDto.setBrandDto(brandDto);
        }
        if (productMaster.getUserId() != null) {
            UserDto userDto = new UserDto();
            userDto.setUserId(productMaster.getUserId().getUserId());
            userDto.setUserName(productMaster.getUserId().getUserName());
            ProductMasterDto.setUserId(userDto);
        }


        return ProductMasterDto;
    }

    private ProductMaster copyDtoToEntity(ProductMasterDto productMasterDto) {
        ProductMaster productMaster = new ProductMaster();
        BeanUtils.copyProperties(productMasterDto, productMaster);
        if (productMasterDto.getCategoryDto() != null) {
            Category category = new Category();
            category.setCategoryId(productMasterDto.getCategoryDto().getCategoryId());
            productMaster.setCategory(category);
        }
        if (productMasterDto.getBrandDto() != null) {
            Brand brand = new Brand();
            brand.setBrandId(productMasterDto.getBrandDto().getBrandId());
            productMaster.setBrand(brand);
        }
        if (productMasterDto.getUserId() != null) {
            User user = new User();
            user.setUserId(productMasterDto.getUserId().getUserId());
            productMaster.setUserId(user);
        }

        return productMaster;
    }

}
