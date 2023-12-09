package org.wecancodeit.gamelibrary.Models;

public class PublisherDto {
    private long id;
    private String name;
    private String title;

    
    public PublisherDto(long id, String name) {
        this.id = id;
        this.name = name;
    }
    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    
}
