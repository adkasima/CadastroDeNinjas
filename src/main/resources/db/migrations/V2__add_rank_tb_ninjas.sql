-- V2: Migration para adicionar a coluna rank na tb_ninjas

ALTER TABLE tb_ninjas
ADD COLUMN rank VARCHAR(255);