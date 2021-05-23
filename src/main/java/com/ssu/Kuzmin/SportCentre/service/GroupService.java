package com.ssu.Kuzmin.SportCentre.service;

import com.ssu.Kuzmin.SportCentre.dao.GroupDao;
import com.ssu.Kuzmin.SportCentre.entity.Client;
import com.ssu.Kuzmin.SportCentre.entity.Group;

import java.util.List;

public class GroupService {

    private final GroupDao groupDao;

    public GroupService(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    public Group getById(int id) throws Exception {
        return groupDao.getById(id);
    }

    public List<Group> getAll() {
        return groupDao.getAll();
    }

    public void add(Group group) {
        groupDao.add(group);
    }

    public void update(Group group) {
        groupDao.update(group);
    }

    public void delete(Group group) {
        groupDao.delete(group);
    }
}
