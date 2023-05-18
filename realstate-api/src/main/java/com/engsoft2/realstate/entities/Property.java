package com.engsoft2.realstate.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "property")
public class Property {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "imageUrl")
    private String imageUrl;
    @Column(name = "type")
    private String type;
    @Column(name = "saleMode")
    private String saleMode;
    @Column(name = "address")
    private String address;
    @Column(name = "size")
    private float size;
    @Column(name = "contactInfo")
    private String contactInfo;
    @Column(name = "price")
    private float price;
    @Column(name = "bathroomCount")
    private int bathroomCount;
    @Column(name = "roomCount")
    private int roomCount;
    @Column(name = "parkingCount")
    private int parkingCount;
    @Column(name = "isActive")
    private boolean isActive;
    @Column(name = "isCommercial")
    private boolean isCommercial;

    public Property() {
    }

    public Property(int id, String name, String description, String imageUrl, String type, String saleMode, String address,
                    float size, String contactInfo, float price, int bathroomCount, int roomCount, int parkingCount, boolean isActive, boolean isCommercial) {
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

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
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
}
