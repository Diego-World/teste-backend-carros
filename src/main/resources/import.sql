INSERT INTO tb_marca (nome_marca) VALUES ('Subaru');
INSERT INTO tb_marca (nome_marca) VALUES ('Mercedes-Benz');
INSERT INTO tb_marca (nome_marca) VALUES ('Chevrolet');
INSERT INTO tb_marca (nome_marca) VALUES ('Toyota');
INSERT INTO tb_marca (nome_marca) VALUES ('Honda');
INSERT INTO tb_marca (nome_marca) VALUES ('Nissan');

INSERT INTO TB_MODELO (modelo_id,marca_id, nome, valor_fipe) VALUES (1,4, 'Toyota Supra', 120000.00);
INSERT INTO TB_MODELO (modelo_id,marca_id, nome, valor_fipe) VALUES (2,4, 'Toyota Corolla', 50000.00);
INSERT INTO TB_MODELO (modelo_id,marca_id, nome, valor_fipe) VALUES (3,4, 'Toyota Etios', 60000.00);
INSERT INTO TB_MODELO (modelo_id,marca_id, nome, valor_fipe) VALUES (4,2, 'Mercedes-GLA', 150000.00);
INSERT INTO TB_MODELO (modelo_id,marca_id, nome, valor_fipe) VALUES (5,2, 'Mercedes-CLA', 100000.00);

--INSERT INTO tb_carro (time_stamp_cadastro, modelo_id, ano, combustivel, num_portas, cor) VALUES ('2023-10-13', 1, '2023', 'FLEX', 4, 'VERMELHO');

INSERT INTO tb_carro (ano, combustivel, cor, num_portas, time_stamp_cadastro, modelo_id) VALUES ('2023','FLEX', 4, '2023-10-13', 1, 'VERMELHO');
