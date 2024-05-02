package com.example.spend.domain;

import jakarta.persistence.*;

import javax.validation.constraints.*;

import com.example.spend.common.StringUtil;

import java.io.Serial;
import java.math.BigDecimal;
//import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "expense")
public class Expense {
    @Serial
    private static final long serialVersionUID = 1L;

    @Column( name = "amount", nullable = false, updatable = false)
    @NotNull
    private BigDecimal amount;

    @Column(name = "currency", nullable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    @NotNull
    private Currency currency;

    @Column( name = "date", nullable = false, updatable = false)
    @NotNull
    private Date date;

    @Column(length = 20, name = "description", nullable = false, updatable = false)
    @NotBlank
    @NotEmpty
    @NotNull
    @Size(max = 100
            , message = "Description can not be less than {min} characters and not more than {max} characters."
            , min = 3)
    private String description;

    @Column(name = "id", nullable = false, updatable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    Expense(){
        super();
    }

    public Expense(final String description, final Date date, final BigDecimal amount, final Currency currency) {
        this();
        setDescription(description);
        setDate(date);
        setAmount(amount);
        setCurrency(currency);
        

    }

    public BigDecimal getAmount() {
        return amount;
    }

    void setAmount(final BigDecimal amount) {
        if(amount == null){
            throw new NullPointerException("Amount can not be null");
        }
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    void setDate(final Date date) {
        if(date == null){
            throw new NullPointerException("Date can not be null");
        }
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    void setDescription(final String description) {
        if(StringUtil.isBlank(description)){
            throw new NullPointerException("Description can not be null");
        }
        this.description = description;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        if(currency == null){
            throw new NullPointerException("Currency can not be null");
        }
        this.currency = currency;
    }

    
}
