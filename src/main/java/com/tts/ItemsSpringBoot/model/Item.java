package com.tts.ItemsSpringBoot.model;

import javax.persistence.*;

@Entity
public class Item {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    @SequenceGenerator(
            name="item_sequence",
            sequenceName = "item_generator",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "item_sequence"
    )
    private long id;
    @Column(nullable = false,unique = true)
    private String name;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Item(){

    }
    public Item(String name,String type){
        this.name=name;
        this.type=type;
    }
    public  long getId(){
        return  this.id;
    }


    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

