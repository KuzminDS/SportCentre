package com.ssu.Kuzmin.SportCentre.service;

import com.ssu.Kuzmin.SportCentre.dao.GroupDao;
import com.ssu.Kuzmin.SportCentre.entity.Client;
import com.ssu.Kuzmin.SportCentre.entity.Group;

import java.util.List;

public class GroupService extends Service<Group> {
    public GroupService() {
        super(Group.class);
    }
}
