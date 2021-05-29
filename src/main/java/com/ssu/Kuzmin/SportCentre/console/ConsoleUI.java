package com.ssu.Kuzmin.SportCentre.console;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssu.Kuzmin.SportCentre.entity.*;
import com.ssu.Kuzmin.SportCentre.service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI {
    private final UserService userService;

    private boolean isAuthorized;

    public ConsoleUI() {
        userService = new UserService();
    }

    public void start() {
        isAuthorized = false;
        tryAuthorize();

        while (isAuthorized) {
            openMainMenu();
            if (!isAuthorized) {
                tryAuthorize();
            }
        }

    }

    private void tryAuthorize() {
        do {
            isAuthorized = authorize();
        } while (!isAuthorized);
    }

    private boolean authorize() {
        String[] actions = new String[] { "Login", "Sign up", "Close application" };
        String action = ConsoleHelper.getOptionFromMenu("Authorization", actions);

        try {
            switch (action) {
                case "Login":
                    return userService.authorize(getUserCredentials());
                case "Sign up":
                    return userService.registrate(getUserCredentials());
                case "Close application":
                    System.exit(0);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    private User getUserCredentials() throws Exception {
        User user = new User();
        Scanner in = new Scanner(System.in);

        System.out.println("Login: ");
        user.setLogin(in.nextLine());
        if (user.getLogin().isEmpty())
            throw new Exception("Login cannot be empty");

        System.out.println("Password: ");
        user.setPassword(in.nextLine());
        if (user.getPassword().isEmpty())
            throw new Exception("Password cannot be empty");

        return user;
    }

    private void openMainMenu() {
        String[] options = new String[] { "Clients", "Trainers", "Groups", "Gyms", "Lessons", "Subscriptions", "Sign out" };
        String option = ConsoleHelper.getOptionFromMenu("Main menu", options);

        String[] actions = new String[] { "Get all list", "Get by id", "Add", "Update", "Delete", "Back to menu" };
        String action = ConsoleHelper.getOptionFromMenu("Actions", actions);

        switch (option) {
            case "Clients":
                performEntityAction(Client.class, action);
                break;
            case "Trainers":
                performEntityAction(Trainer.class, action);
                break;
            case "Groups":
                performEntityAction(Group.class, action);
                break;
            case "Gyms":
                performEntityAction(Gym.class, action);
                break;
            case "Lessons":
                performEntityAction(Lesson.class, action);
                break;
            case "Subscriptions":
                performEntityAction(Subscription.class, action);
                break;
            case "Sign out":
                isAuthorized = false;
                break;
        }
    }

    private <T> void performEntityAction(Class<T> type, String action) {
        try {
            Service<T> service = new Service<>(type);

            switch (action) {
                case "Get all list":
                    performGetAll(service);
                    break;
                case "Get by id":
                    performGetById(service);
                    break;
                case "Add":
                    performAction(type, Action.Add);
                    break;
                case "Update":
                    performAction(type, Action.Update);
                    break;
                case "Delete":
                    performDelete(service);
                    break;
                case "Back to menu":
                    openMainMenu();
                    break;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private <T> void performGetAll(Service<T> service) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<T> list = service.getAll();
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);

        System.out.println("Whole entity list: ");
        System.out.println(json);
        openMainMenu();
    }

    private <T> void performGetById(Service<T> service) throws Exception {
        int id = ConsoleHelper.enterPositiveIntValue("Enter Id: ");

        ObjectMapper mapper = new ObjectMapper();
        T entity = service.getById(id);
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(entity);

        System.out.println(String.format("Entity with id = %s: ", id));
        System.out.println(json);
        openMainMenu();
    }

    private <T> void performDelete(Service<T> service) throws Exception {
        int id = ConsoleHelper.enterPositiveIntValue("Enter Id: ");

        if (ConsoleHelper.getConfirmationMessageResult()) {
            service.delete(id);
            System.out.println(String.format("Entity with id = %s was successfully deleted", id));
        }
        openMainMenu();
    }

    private <T> void performAction(Class<T> type, Action action) throws Exception {
        if (type == Client.class) {
            performClientAction(action);
        } else if (type == Group.class) {
            performGroupAction(action);
        } else if (type == Gym.class) {
            performGymAction(action);
        } else if (type == Lesson.class) {
            performLessonAction(action);
        } else if (type == Subscription.class) {
            performSubscriptionAction(action);
        } else if (type == Trainer.class) {
            performTrainerAction(action);
        } else {
            throw new Exception("Unknown type was received");
        }
    }

    private void performClientAction(Action action) throws Exception {
        ClientService clientService = new ClientService();
        SubscriptionService subscriptionService = new SubscriptionService();
        GroupService groupService = new GroupService();

        Client client = new Client();

        if (action == Action.Update)
            client.setId(ConsoleHelper.enterPositiveIntValue("Enter client id: "));

        client.setLastName(ConsoleHelper.enterString("Enter client last name: "));
        client.setFirstName(ConsoleHelper.enterString("Enter client first name: "));
        client.setAge(ConsoleHelper.enterPositiveIntValue("Enter client age: "));

        Subscription subscription = subscriptionService.getById(ConsoleHelper.enterPositiveIntValue("Enter subscription id: "));
        client.setSubscription(subscription);

        client.setPurchaseDate(ConsoleHelper.enterDate("Enter date of subscription buying: "));

        List<Group> groups = new ArrayList<>();
        int groupsNum = ConsoleHelper.enterPositiveIntValue("Enter number of client groups: ");
        for (int i = 1; i <= groupsNum; i++) {
            Group group = groupService.getById(ConsoleHelper.enterPositiveIntValue(String.format("Enter id of group%s: ", i)));
            groups.add(group);
        }
        client.setGroups(groups);

        if (action == Action.Add)
            clientService.add(client);
        else if (action == Action.Update)
            clientService.update(client);
    }

    private void performGroupAction(Action action) throws Exception {
        GroupService groupService = new GroupService();
        ClientService clientService = new ClientService();

        Group group = new Group();

        if (action == Action.Update)
            group.setId(ConsoleHelper.enterPositiveIntValue("Enter group id: "));

        group.setName(ConsoleHelper.enterString("Enter group name: "));

        List<Client> clients = new ArrayList<>();
        int clientsNum = ConsoleHelper.enterPositiveIntValue("Enter number of clients in group: ");
        for (int i = 1; i <= clientsNum; i++) {
            Client client = clientService.getById(ConsoleHelper.enterPositiveIntValue(String.format("Enter id of client%s: ", i)));
            clients.add(client);
        }
        group.setClients(clients);

        if (action == Action.Add)
            groupService.add(group);
        else if (action == Action.Update)
            groupService.update(group);
    }

    private void performGymAction(Action action) throws Exception {
        GymService gymService = new GymService();
        LessonService lessonService = new LessonService();

        Gym gym = new Gym();

        if (action == Action.Update)
            gym.setId(ConsoleHelper.enterPositiveIntValue("Enter gym id: "));

        gym.setName(ConsoleHelper.enterString("Enter gym name: "));
        gym.setBeginning(ConsoleHelper.enterTime("Enter time of gym beginning : "));
        gym.setDuration(ConsoleHelper.enterPositiveIntValue("Enter gym work duration: "));

        List<Lesson> lessons = new ArrayList<>();
        int lessonsNum = ConsoleHelper.enterPositiveIntValue("Enter number of lessons in gym: ");
        for (int i = 1; i <= lessonsNum; i++) {
            Lesson lesson = lessonService.getById(ConsoleHelper.enterPositiveIntValue(String.format("Enter id of lesson%s: ", i)));
            lessons.add(lesson);
        }
        gym.setLessons(lessons);

        if (action == Action.Add)
            gymService.add(gym);
        else if (action == Action.Update)
            gymService.update(gym);
    }

    private void performLessonAction(Action action) throws Exception {
        GymService gymService = new GymService();
        GroupService groupService = new GroupService();
        TrainerService trainerService = new TrainerService();
        LessonService lessonService = new LessonService();

        Lesson lesson = new Lesson();

        if (action == Action.Update)
            lesson.setId(ConsoleHelper.enterPositiveIntValue("Enter gym id: "));

        lesson.setBeginning(ConsoleHelper.enterTime("Enter time of lesson beginning : "));
        lesson.setDuration(ConsoleHelper.enterPositiveIntValue("Enter lesson duration: "));

        Group group = groupService.getById(ConsoleHelper.enterPositiveIntValue("Enter id of group: "));
        lesson.setGroup(group);

        Gym gym = gymService.getById(ConsoleHelper.enterPositiveIntValue("Enter id of gym: "));
        lesson.setGym(gym);

        Trainer trainer = trainerService.getById(ConsoleHelper.enterPositiveIntValue("Enter id of trainer: "));
        lesson.setTrainer(trainer);

        if (action == Action.Add)
            lessonService.add(lesson);
        else if (action == Action.Update)
            lessonService.update(lesson);
    }

    private void performSubscriptionAction(Action action) {
        SubscriptionService subscriptionService = new SubscriptionService();

        Subscription subscription = new Subscription();

        if (action == Action.Update)
            subscription.setId(ConsoleHelper.enterPositiveIntValue("Enter subscription id: "));

        subscription.setName(ConsoleHelper.enterString("Enter subscription name: "));
        subscription.setValidity(ConsoleHelper.enterPositiveIntValue("Enter subscription validity: "));
        subscription.setPrice(ConsoleHelper.enterPositiveIntValue("Enter subscription price: "));

        if (action == Action.Add)
            subscriptionService.add(subscription);
        else if (action == Action.Update)
            subscriptionService.update(subscription);
    }

    private void performTrainerAction(Action action) {
        TrainerService trainerService = new TrainerService();

        Trainer trainer = new Trainer();

        if (action == Action.Update)
            trainer.setId(ConsoleHelper.enterPositiveIntValue("Enter trainer id: "));

        trainer.setLastName(ConsoleHelper.enterString("Enter trainer last name: "));
        trainer.setFirstName(ConsoleHelper.enterString("Enter trainer first name: "));
        trainer.setAge(ConsoleHelper.enterPositiveIntValue("Enter trainer age: "));
        trainer.setSalary(ConsoleHelper.enterPositiveIntValue("Enter trainer salary: "));

        if (action == Action.Add)
            trainerService.add(trainer);
        else if (action == Action.Update)
            trainerService.update(trainer);
    }
}
