package org.wecancodeit.gamelibrary.Models;

public class BoardGameDto {

    private long id = 0;
    private long publisherId;
    private String name;
    private String description;
    private String imageUrl;
    private String title;

    

    public BoardGameDto(long id,long publisherId, String name, String description, String imageUrl) {
        this.id = id;
        this.publisherId = publisherId;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public long getPublisherId() {
        return publisherId;
    }

    @Override
    public String toString() {
        return "BoardGameDto [id=" + id + ", publisherId=" + publisherId + ", name=" + name + ", description="
                + description + ", imageUrl=" + imageUrl + ", title=" + title + "]";
    }

}
