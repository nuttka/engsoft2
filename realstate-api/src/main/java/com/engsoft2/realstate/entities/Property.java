package com.engsoft2.realstate.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
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
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "type")
    private String type;
    @Column(name = "sale_mode")
    private String saleMode;
    @Column(name = "address")
    private String address;
    @Column(name = "size")
    private double size;
    @Column(name = "contact_info")
    private String contactInfo;
    @Column(name = "price")
    private double price;
    @Column(name = "bathroom_count")
    private int bathroomCount;
    @Column(name = "room_count")
    private int roomCount;
    @Column(name = "parking_count")
    private int parkingCount;
    @Column(name = "is_active")
    private boolean isActive;
    @Column(name = "is_commercial")
    private boolean isCommercial;
    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    public Property() {
    }

    public Property(int id, String name, String description, String imageUrl, String type, String saleMode, String address,
                    double size, String contactInfo, double price, int bathroomCount, int roomCount, int parkingCount, boolean isActive, boolean isCommercial, User user) {
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
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
