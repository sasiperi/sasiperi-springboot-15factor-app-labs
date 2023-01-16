package com.sasiperi.demo.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
//@EqualsAndHashCode
@ToString
@JsonInclude(Include.NON_EMPTY)
public class Customer extends AbstractTimestampEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//JSR 380 validations
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", unique = true, nullable = false)
	private long customerId;
	
	@Column(name = "first_name", nullable = false, length = 25)
	@Size(min = 4, max = 10, message = "First name must be 4 to 10 charecters!")
	private String firstName;
	
	@Column(name = "last_name", nullable = false, length = 25)
	private String lastName;
	
	@NotNull
	@Column(name = "ssn", nullable = false, length = 9)
	private Integer ssn;
	
	@Column(name = "age", nullable = true, length = 25)
	@Min(value = 18, message = "Age should not be less than 18")
    @Max(value = 150, message = "Age should not be greater than 150")
	private Integer age;
	
}
