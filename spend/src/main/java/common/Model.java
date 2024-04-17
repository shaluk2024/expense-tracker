package common;


import jakarta.persistence.*;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import java.io.Serializable;


@MappedSuperclass
public abstract class Model implements Serializable {

    @Id
    @Column(name = "id", updatable = false)
    @Generated(GenerationTime.INSERT)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    /**
     * Gets the unique identifier of the entity.
     *
     * @return The unique identifier of the entity.
     */
    public Long getId() {
        return id;
    }
}
