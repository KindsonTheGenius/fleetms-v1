package com.kindsonthegenius.fleetapp.security.services;

import com.kindsonthegenius.fleetapp.models.User;
import com.kindsonthegenius.fleetapp.repositories.UserRepository;
import com.kindsonthegenius.fleetapp.security.models.Role;
import com.kindsonthegenius.fleetapp.security.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class RoleService {
    
    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
    private UserRepository userRepository;

    public List<Role> getRoles(){
        return roleRepository.findAll();
    }

    public void save(Role client) {
        roleRepository.save(client);
    }

    public Role findById(int id) {
        return roleRepository.findById(id).orElse(null);
    }

    public void delete(Integer id) {
        roleRepository.deleteById(id);
    }

    public void assignRole(Integer userId, Integer roleId){
        User user = userRepository.findById(userId).orElse(null);
        Role role = roleRepository.findById(roleId).orElse(null);
        Set<Role> userRoles = user.getRoles();
        userRoles.add(role);
        user.setRoles(userRoles);
        userRepository.save(user);
    }

    public void unassignRole(Integer userId, Integer roleId){
        User user = userRepository.findById(userId).orElse(null);
        Set<Role> userRoles = user.getRoles();
        userRoles.removeIf(x -> x.getId() == roleId);
        user.setRoles(userRoles);
        userRepository.save(user);
    }

    public Set<Role> getUserRoles(User user){
        return user.getRoles();
    }


    public List<Role> getUserNotRoles(User user){
        return roleRepository.getUserNotRoles(user.getId());
    }

}
