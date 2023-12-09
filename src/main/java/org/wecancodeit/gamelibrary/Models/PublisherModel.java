package org.wecancodeit.gamelibrary.Models;

import java.util.Collection;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "T_Publisher")
public class PublisherModel {

    @Id
    @GeneratedValue
    private long id;

  
    @Size(max = 100, min = 5)
    @Column(length = 100, unique = true)
    private String name;

    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<BoardGameModel> games;

    protected PublisherModel() {
    }

    public PublisherModel(@Size(max = 100, min = 5) String name) {
        this.name = name;
    }

    public PublisherModel(@Size(max = 100, min = 5) String name, long id) {
        this.name = name;
        this.id = id;
    }
 

    public Collection<BoardGameModel> getGames() {
        return games;
    }

    public long getId() {
        return id;
    }

    
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PublisherModel other = (PublisherModel) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "PublisherMode [id=" + id + ", name=" + name + "]";
    }
}
