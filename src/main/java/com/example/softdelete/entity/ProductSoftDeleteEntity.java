package com.example.softdelete.entity;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Where;

@Table(name = "product")
@Entity(name = "product")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = SoftDeleteEntity.SOFT_DELETED_CLAUSE)
public class ProductSoftDeleteEntity extends SoftDeleteEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false, length = 500)
	private String name;

	@Column(name = "price", nullable = false)
	private BigDecimal price;

	@Column(name = "description", nullable = false, length = 1000)
	private String description;

}
