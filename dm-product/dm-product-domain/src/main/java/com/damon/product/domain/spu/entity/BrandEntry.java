package com.damon.product.domain.spu.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * 商品品牌表
 * @author Damon S.
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "dm_spu_brand")
public class BrandEntry {
    @Id
    @NonNull
    @Column private Long        brandId;
    @Column private String      name;
    @Column private String      code;
    @Column private Long        createdBy;
    @Column private Long        updatedBy;
    @Column private Timestamp   createdAt;
    @Column private Timestamp   updatedAt;
}
