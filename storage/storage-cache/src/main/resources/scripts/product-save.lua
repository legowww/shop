if redis.call('ZCARD', KEYS[1]) > 5 then
    return redis.call('ZPOPMAX', KEYS[1])
end
