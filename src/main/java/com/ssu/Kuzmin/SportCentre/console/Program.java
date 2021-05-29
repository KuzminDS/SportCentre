package com.ssu.Kuzmin.SportCentre.console;

import com.ssu.Kuzmin.SportCentre.entity.Client;
import com.ssu.Kuzmin.SportCentre.entity.User;
import com.ssu.Kuzmin.SportCentre.utils.HibernateSessionFactoryUtil;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.JoinTable;
import javax.persistence.Persistence;
import java.util.Arrays;

public class Program {
    public static void main(String[] args) {
        ConsoleUI consoleUI = new ConsoleUI();
        consoleUI.start();
    }
}
