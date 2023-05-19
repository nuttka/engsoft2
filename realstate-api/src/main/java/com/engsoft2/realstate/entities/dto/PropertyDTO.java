package com.engsoft2.realstate.entities.dto;

import com.engsoft2.realstate.entities.Property;

public class PropertyDTO {
    private int id;
    private String name;
    private String description;
    private String imageUrl;
    private String type;
    private String saleMode;
    private String address;
    private double size;
    private String contactInfo;
    private double price;
    private int bathroomCount;
    private int roomCount;
    private int parkingCount;
    private boolean isActive;
    private boolean isCommercial;
    private int userId;

    public PropertyDTO() {
    }

    public PropertyDTO(int id, String name, String description, String imageUrl, String type, String saleMode, String address,
                       double size, String contactInfo, double price, int bathroomCount, int roomCount, int parkingCount, boolean isActive, boolean isCommercial, int userId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.type = type;
        this.saleMode = saleMode;
        this.address = address;
        this.size = size;
        this.contactInfo = contactInfo;
        this.price = price;
        this.bathroomCount = bathroomCount;
        this.roomCount = roomCount;
        this.parkingCount = parkingCount;
        this.isActive = isActive;
        this.isCommercial = isCommercial;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSaleMode() {
        return saleMode;
    }

    public void setSaleMode(String saleMode) {
        this.saleMode = saleMode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getBathroomCount() {
        return bathroomCount;
    }

    public void setBathroomCount(int bathroomCount) {
        this.bathroomCount = bathroomCount;
    }

    public int getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(int roomCount) {
        this.roomCount = roomCount;
    }

    public int getParkingCount() {
        return parkingCount;
    }

    public void setParkingCount(int parkingCount) {
        this.parkingCount = parkingCount;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isCommercial() {
        return isCommercial;
    }

    public void setCommercial(boolean commercial) {
        isCommercial = commercial;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Property toProperty() {
        Property property = new Property();
        property.setId(this.id);
        property.setName(this.name);
        property.setDescription(this.description);
        property.setImageUrl(this.imageUrl);
        property.setType(this.type);
        property.setSaleMode(this.saleMode);
        property.setAddress(this.address);
        property.setSize(this.size);
        property.setContactInfo(this.contactInfo);
        property.setPrice(this.price);
        property.setBathroomCount(this.bathroomCount);
        property.setRoomCount(this.roomCount);
        property.setParkingCount(this.parkingCount);
        property.setActive(this.isActive);
        property.setCommercial(this.isCommercial);

        return property;
    }
}
