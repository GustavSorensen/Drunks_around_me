package dk.au.mad21fall.group6.drunksaroundme.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity
public class Person implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int uid;

    @SerializedName("Gender")
    @Expose
    private String gender;

    @SerializedName("Weight")
    @Expose
    private int weight;

    @SerializedName("Name")
    @Expose
    private String name;


    public Person(String name, String gender,int weight){
        this.name = name;
        this.gender = gender;
        this.weight = weight;
    }

    public void setGender(String _gender){
        this.gender = _gender;
    }
    public void  setName(String _name){
        this.name = _name;
    }
    public void setWeight(int _weight){
        this.weight= _weight;
    }

    public String getGender(){
        return this.gender;
    }
    public String getName(){
        return this.name;
    }
    public int getWeight(){
        return this.weight;
    }

    public int getUid(){return uid; }

    public void setUid(int id) {this.uid = id; }
}
