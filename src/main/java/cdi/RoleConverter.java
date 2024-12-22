package cdi;

//package com.example.converter;

//import com.example.entity.Role;
import entity.Role;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

@FacesConverter("roleConverter")
public class RoleConverter implements Converter<Role> {

    @Override
    public Role getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.trim().isEmpty()) {
            return null;
        }
        // Convert the submitted string value to a Role object
        Role role = new Role();
        role.setRid(Integer.parseInt(value)); // Assuming Role has a method setRid()
        return role;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Role value) {
        if (value == null) {
            return "";
        }
        return String.valueOf(value.getRid()); // Convert Role to its ID string
    }
}
