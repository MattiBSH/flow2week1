/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;


public class PersonStyleDTO {
   private String name;
   private String styleName;
   private int year;

    public PersonStyleDTO() {
    }

    public PersonStyleDTO(String name, String styleName, int year) {
        this.name = name;
        this.styleName = styleName;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStyleName() {
        return styleName;
    }

    public void setStyleName(String styleName) {
        this.styleName = styleName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
   
   
}
