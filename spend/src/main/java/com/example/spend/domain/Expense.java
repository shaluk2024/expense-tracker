package com.example.spend.domain;

import jakarta.persistence.*;

import javax.validation.constraints.*;
import java.io.Serial;
import java.math.BigDecimal;
import java.time.LocalDate;
//import java.util.Date;

@Entity
@Table(name = "expense")
public class Expense {
    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "id", nullable = false, updatable = false)
    @Id
    //@Generated(GenerationTime.INSERT)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 20, name = "amount", nullable = false, updatable = false)
    @NotNull
    private BigDecimal amount;

    @Column(length = 20, name = "date", nullable = false, updatable = false)
    @NotNull
    private LocalDate date;

    @Column(length = 20, name = "description", nullable = false, updatable = false)
    @NotBlank
    @NotEmpty
    @NotNull
    @Size(max = 100
            , message = "Description can not be less than {min} characters and not more than {max} characters."
            , min = 3)
    private String description;

    Expense(){
        super();
    }

    public Expense(final BigDecimal amount, final LocalDate date, final String description) {
        this();
        setAmount(amount);
        setDate(date);
        setDescription(description);

    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(final BigDecimal amount) {
        if(amount == null){
            throw new NullPointerException("Amount can not be null");
        }
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(final LocalDate date) {
        if(date == null){
            throw new NullPointerException("Date can not be null");
        }
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        if(description == null){
            throw new NullPointerException("Description can not be null");
        }
        this.description = description;
    }
}
