package com.ecm.storagecache.storagecache.global;

import com.ecm.coredomain.domain.product.ProductCacheDao;
import com.ecm.coredomain.domain.product.ProductPreview;
import com.ecm.storagecache.storagecache.global.DataAccessHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ProductCacheDaoImpl implements ProductCacheDao {

    private final RedisTemplate<String, Object> redisTemplate;

    @Override
    public List<ProductPreview> readLowPriceProducts(
            Long productGroupId,
            Integer size
    ) {
        return redisTemplate.opsForZSet().
                rangeWithScores(String.valueOf(productGroupId), 0, size)
                .stream()
                .map(tuple -> DataAccessHandler.deserialize((String) tuple.getValue(), ProductPreview.class))
                .toList();
    }

    @Override
    public void save(
            Long productGroupId,
            ProductPreview productPreview
    ) {
        //TODO: modify using lua script
        redisTemplate.opsForZSet()
                .add(convertStringProductGroupId(productGroupId), DataAccessHandler.serialize(productPreview), productPreview.price());

        int cnt = redisTemplate.opsForZSet()
                .zCard(convertStringProductGroupId(productGroupId))
                .intValue();

        if (cnt == 6) {
            redisTemplate.opsForZSet()
                    .popMax(convertStringProductGroupId(productGroupId));
        }
    }

    private String convertStringProductGroupId(
            Long productGroupId
    ) {
        return String.valueOf(productGroupId);
    }
}
