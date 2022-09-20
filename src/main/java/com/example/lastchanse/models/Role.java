package com.example.lastchanse.models;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {



   USER,ADMIN,PERPOD,BLOCED;
   @Override
   public String getAuthority() {
      return name();
   }
}
