INSERT INTO product_groups(id, name, created_at, updated_at) VALUES (1, '노스페이스 1996 눕시', now(), now());
INSERT INTO product_groups(id, name, created_at, updated_at) VALUES (2, '노스페이스 1992 눕시', now(), now());
INSERT INTO product_groups(id, name, created_at, updated_at) VALUES (3, '노스페이스 힘다운', now(), now());
INSERT INTO product_groups(id, name, created_at, updated_at) VALUES (4, '로지텍 G304', now(), now());
INSERT INTO product_groups(id, name, created_at, updated_at) VALUES (5, '한성키보드 GK888B', now(), now());

INSERT INTO products(id, shop_id, product_group_id, release_price, price, discount_rate, stock, description, model_number, name, created_at, updated_at)
VALUES (1, 1, 1, 360000, 360000, 0, 15, '설명', 'TNF1', '노스페이스 남성 1996 눕시 점퍼', now(), now());
INSERT INTO products(id, shop_id, product_group_id, release_price, price, discount_rate, stock, description, model_number, name, created_at, updated_at)
VALUES (2, 2, 1, 362000, 362000, 0, 10, '설명', 'TNF1', '노스페이스 1996 패딩', now(), now());
INSERT INTO products(id, shop_id, product_group_id, release_price, price, discount_rate, stock, description, model_number, name, created_at, updated_at)
VALUES (3, 3, 1, 365000, 365000, 0, 20, '설명', 'TNF1', '[노스페이스] 남성 1996 눕시', now(), now());
INSERT INTO products(id, shop_id, product_group_id, release_price, price, discount_rate, stock, description, model_number, name, created_at, updated_at)
VALUES (4, 4, 1, 365000, 365000, 0, 30, '설명', 'TNF1', '노스페이스 남성 1996 눕시 점퍼', now(), now());
INSERT INTO products(id, shop_id, product_group_id, release_price, price, discount_rate, stock, description, model_number, name, created_at, updated_at)
VALUES (5, 5, 1, 385000, 385000, 0, 100, '설명', 'TNF1', '노스페이스 1996 자켓 패딩', now(), now());
INSERT INTO products(id, shop_id, product_group_id, release_price, price, discount_rate, stock, description, model_number, name, created_at, updated_at)
VALUES (6, 6, 1, 350000, 350000, 0, 100, '설명', 'TNF1', '[노스페이스] 1996 눕시', now(), now());

INSERT INTO products(id, shop_id, product_group_id, release_price, price, discount_rate, stock, description, model_number, name, created_at, updated_at)
VALUES (7, 4, 2, 265000, 265000, 0, 30, '설명', 'TNF2', '노스페이스 1992', now(), now());
INSERT INTO products(id, shop_id, product_group_id, release_price, price, discount_rate, stock, description, model_number, name, created_at, updated_at)
VALUES (8, 5, 2, 285000, 285000, 0, 100, '설명', 'TNF2', '노스페이스 1992 자켓 패딩', now(), now());
INSERT INTO products(id, shop_id, product_group_id, release_price, price, discount_rate, stock, description, model_number, name, created_at, updated_at)
VALUES (9, 6, 3, 800000, 750000, 0, 100, '설명', 'TNF3', '[노스페이스] 힘다운 자켓', now(), now());

INSERT INTO shops(id, user_id, name, created_at, updated_at) VALUES (1, 1, '판매업체A', now(), now());
INSERT INTO shops(id, user_id, name, created_at, updated_at) VALUES (2, 2, '판매업체B', now(), now());
INSERT INTO shops(id, user_id, name, created_at, updated_at) VALUES (3, 3, '판매업체C', now(), now());
INSERT INTO shops(id, user_id, name, created_at, updated_at) VALUES (4, 4, '판매업체D', now(), now());
INSERT INTO shops(id, user_id, name, created_at, updated_at) VALUES (5, 5, '판매업체E', now(), now());
INSERT INTO shops(id, user_id, name, created_at, updated_at) VALUES (6, 6, '판매업체F', now(), now());
