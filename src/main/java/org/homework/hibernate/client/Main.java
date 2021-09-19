package org.homework.hibernate.client;

import org.homework.hibernate.controller.hw4.CommandImpl;

public class Main {

    public static void main(String[] args) {

        new CommandImpl().start();

//        SessionsOpenClose sessionsOpenClose = SessionsOpenClose.getInstance();
//
//        CrudRepositoryHibernateImpl<Developer, Long> crudRepositoryHibernate = new CrudRepositoryHibernateImpl<>(Developer.class);
//        CrudRepository<Developer, Long> developerLongCrudRepository = RepositoryFactory.of(Developer.class);
//
////        List<Developer> developerList = crudRepositoryHibernate.findAll();
////        System.out.println(developerList);
//        Developer developer = Developer.builder()
//                .id(1L)
//                .name("Иван")
//                .age(25L)
//                .gender("Male")
//                .email("ivan@ua")
//                .salary(5500L)
//                .build();
////        sessionsOpenClose.createSession().save(developer);
//        System.out.println(developer);
//        developerLongCrudRepository.save(developer);
    }
//    private static <T> List<T> loadAllData(Class<T> type, Session session) {
////        CriteriaBuilder builder = session.getCriteriaBuilder();
////        CriteriaQuery<T> criteria = builder.createQuery(type);
////        criteria.from(type);
////        List<T> data = session.createQuery(criteria).getResultList();
////        session.close();
//        return data;
//    }
}
////        new CommandImpl().start();
////        Session session = HibernateSessionFactory.getSessionFactory().openSession();
////session.getTransaction();
//        System.out.println("Hibernate tutorial");
//        CrudRepository<Company, Long> companyLongCrudRepository = RepositoryFactory.of(Company.class);
//        CrudRepository<Developer, Long> developerLongCrudRepository = RepositoryFactory.of(Developer.class);
//        CrudRepository<Project, Long> projectLongCrudRepository = RepositoryFactory.of(Project.class);
//        CrudRepository<Customer, Long> customerLongCrudRepository = RepositoryFactory.of(Customer.class);
//        CrudRepository<Skill, Long> skillLongCrudRepository = RepositoryFactory.of(Skill.class);
////        Company company = companyLongCrudRepository.findById(2L).get();
////        Developer developer = developerLongCrudRepository.findById(2L).get();
////        Project project=projectLongCrudRepository.findById(2L).get();
////        Customer customer = customerLongCrudRepository.findById(2L).get();
////        Skill skill = skillLongCrudRepository.findById(2L).get();
////        System.out.println(company);
////        System.out.println(developer);
////        System.out.println(project);
////        System.out.println(customer);
////        System.out.println(skill);
////        skill.setActivities("Java");
////        skillLongCrudRepository.update(skill);
////        skillLongCrudRepository.save(skill);
////        skillLongCrudRepository.findById(2L);
////        skillLongCrudRepository.deleteById(2L);
////        session.update(skill);
////        session.getTransaction().commit();
////        Skill skill = Skill.builder()
////                .activities("java")
////                .level("JUNIOR").build();
////skillLongCrudRepository.save(skill);
//        Set<Developer> developerSet = new HashSet<>();
//        Set<Project> projectSet = new HashSet<>();
//        Set<Skill> skills = new HashSet<>();
//Skill skill = Skill.builder().activities("Java").level("Junior")
//        .build();
//skills.add(skill);
//
//Company company = Company.builder()
//                .city("NY")
//                .name("Apple")
//                .developers(developerSet)
//                .projects(projectSet)
//                .build();
//        companyLongCrudRepository.save(company);
//
//        Customer customer1 = Customer.builder()
//                .city("LA")
//                .budget(1000000L)
//                .name("Bank")
//                .projects(projectSet)
//                .build();
//        customerLongCrudRepository.save(customer1);
//        Project project1 = Project.builder()
//                .cost(550000L)
//                .name("Mac")
//                .developers(developerSet)
//                .customer(customer1)
//                .build();
//        projectLongCrudRepository.save(project1);
//        Project project2 = Project.builder()
//                .name("Iphone")
//                .cost(600000L)
//                .company(company)
//                .developers(developerSet)
//                .customer(customer1)
//                .company(company)
//                .build();
//        projectLongCrudRepository.save(project2);
////
//        projectSet.add(project1);
//        projectSet.add(project2);
//
//        Developer developer1 = Developer.builder()
//                .id(3L)
//                .salary(2000L)
//                .name("IDev")
//                .gender("Male")
//                .email("sksksk@jdjd")
//                .age(25L)
////                .numberPhone(333333L)
////                .company(company)
////                .projects(projectSet)
//                .skills(skills)
//                .build();
//        developerLongCrudRepository.save(developer1);
//
//        Developer developer2 = Developer.builder()
//                .id(1L)
//                .salary(20L)
//                .name("IDev2")
//                .gender("Male")
//                .email("sksksk2@jdjd")
//                .age(35L)
////                .numberPhone(55555L)
////                .company(company)
////                .projects(projectSet)
//                .skills(skills)
//                .build();
//        developerLongCrudRepository.save(developer2);
//        developerSet.add(developer1);
//        developerSet.add(developer2);
////        Company company1 = companyLongCrudRepository.findById(2L).get();
////company1.setName("KiKi");
////company1.setCity("Rjsjs");
////companyLongCrudRepository.save(company1);
////session.update("name", company);
////         session.update(updateCompany(5L, "Hiuy", "HY-LA"));
////         companyLongCrudRepository.update(updateCompany(5L,"Hiuy","HY-LA"));
////        companyLongCrudRepository.save(updateCompany(5L, "Hiuy", "HY-LA"));
////        System.out.println(save);
////        companyLongCrudRepository.deleteById(8L);
//
//        //   Long comId = companyLongCrudRepository.update(updateCompany());
//
//        //  System.out.println(companyLongCrudRepository.findById(comId));
////        Company company = createCompany();
//
////        companyLongCrudRepository.deleteById(4L);
////        companyLongCrudRepository.close();
////        session.close();
////        customerLongCrudRepository.deleteById(1L);
////        companyLongCrudRepository.deleteById(1L);
////        skillLongCrudRepository.deleteById(1L);
////        developerLongCrudRepository.deleteById(1L);
////        projectLongCrudRepository.deleteById(1L);
////        Optional<Customer> byId1 = customerLongCrudRepository.findById(2L);
////        Optional<Company> byId2=companyLongCrudRepository.findById(2L);
////        Optional<Skill> byId3=skillLongCrudRepository.findById(2L);
////        Optional<Developer> byId4=developerLongCrudRepository.findById(2L);
////        Optional<Project> byId5=projectLongCrudRepository.findById(2L);
////        Customer customer = byId1.get();
////        Company company = byId2.get();
////        Skill skill = byId3.get();
////        Developer developer = byId4.get();
////        Project project = byId5.get();
////        System.out.println(skill);
////        System.out.println(company);
////        System.out.println(customer);
////        System.out.println(project);
////        System.out.println(developer);
//
//    }
//
//    private static Company createCompany() {
//        Set<Developer> developerSet = new HashSet<>();
//        Set<Project> projectSet = new HashSet<>();
//        Company company = Company.builder()
//                .city("NY")
//                .name("Apple")
//                .developers(developerSet)
//                .projects(projectSet)
//                .build();
//
//
//        Developer developer1 = Developer.builder()
//                .salary(2000L)
//                .name("IDev")
//                .gender("Male")
//                .email("sksksk@jdjd")
//                .age(25L)
////                .numberPhone(333333L)
////                .company(company)
//                .projects(projectSet)
//                .build();
//        Developer developer2 = Developer.builder()
//                .salary(20L)
//                .name("IDev2")
//                .gender("Male")
//                .email("sksksk2@jdjd")
//                .age(35L)
////                .numberPhone(55555L)
////                .company(company)
//                .projects(projectSet)
//                .build();
//        developerSet.add(developer1);
//        developerSet.add(developer2);
//
//        Customer customer = Customer.builder()
//                .city("LA")
//                .budget(1000000L)
//                .name("Bank")
//                .projects(projectSet)
//                .build();
//
//        Project project1 = Project.builder()
//                .cost(550000L)
//                .name("Mac")
//                .company(company)
//                .developers(developerSet)
//                .customer(customer)
//                .company(company)
//                .build();
//        Project project2 = Project.builder()
//                .name("Iphone")
//                .cost(600000L)
//                .company(company)
//                .developers(developerSet)
//                .customer(customer)
//                .company(company)
//                .build();
//        projectSet.add(project1);
//        projectSet.add(project2);
//
//        return company;
//    }
//
//    private static Company updateCompany(Long id, String name, String city) {
//        Session session = HibernateSessionFactory.getSessionFactory().openSession();
//
//        Set<Developer> developerSet = new HashSet<>();
//        Set<Project> projectSet = new HashSet<>();
//
//        Company company1 = session.get(Company.class, id);
//
////        System.out.println(company1);
//
//
//        Customer customer1 = Customer.builder()
//                .city("LA")
//                .budget(1000000L)
//                .name("Bank")
//                .projects(projectSet)
//                .build();
//        Developer developer1 = Developer.builder()
//                .salary(2000L)
//                .name("IDev")
//                .gender("Male")
//                .email("sksksk@jdjd")
//                .age(25L)
////                .numberPhone(333333L)
////                .company(company1)
//                .projects(projectSet)
//                .build();
//        Developer developer2 = Developer.builder()
//                .salary(20L)
//                .name("IDev2")
//                .gender("Male")
//                .email("sksksk2@jdjd")
//                .age(35L)
////                .numberPhone(55555L)
////                .company(company1)
//                .projects(projectSet)
//                .build();
//        developerSet.add(developer1);
//        developerSet.add(developer2);
//
//        Project project1 = Project.builder()
//                .cost(550000L)
//                .name("Mac")
//                .company(company1)
//                .developers(developerSet)
//                .customer(customer1)
//                .company(company1)
//                .build();
//        Project project2 = Project.builder()
//                .name("Iphone")
//                .cost(600000L)
//                .company(company1)
//                .developers(developerSet)
//                .customer(customer1)
//                .company(company1)
//                .build();
//        projectSet.add(project1);
//        projectSet.add(project2);
//
//        company1.setName(name);
//        company1.setCity(city);
//        company1.setDevelopers(developerSet);
//        company1.setProjects(projectSet);
//
////        session.getTransaction().commit();
//        session.close();
//        return company1;
//
//    }
////        Session session = HibernateSessionFactory.getSessionFactory().openSession();
////        session.beginTransaction();
////        List<Developer> developerList = loadAllData(Developer.class, session);
////        Developer developer = new DeveloperBuilder()
////                .id()
////                .age(25L)
////                .email("www@ppp")
////                .gender("Male")
////                .numberPhone("093872722")
////                .name("Names")
////                .salary(23456L)
////                .build();
////        Skill skill = new Skill();
////        skill.setActivities("java");
////        skill.setLevel("middle");
////        skill.setDevelopers();
//
////        List<Project> projectList = loadAllData(Project.class, session);
////        List<Customer> customerList = loadAllData(Customer.class, session);
////        List<Skill> skillList = loadAllData(Skill.class, session);
////        List<Company> companyList = loadAllData(Company.class, session);
//
//    //JpaCriteriaDelete<Developer> criteriaDelete = session.getCriteriaBuilder().createCriteriaDelete(Developer.class);
////        System.out.println("--------------------------------------------------------------------------------------");
////        System.out.println(developerList);
////        System.out.println("--------------------------------------------------------------------------------------");
////        System.out.println(projectList);
////        System.out.println("--------------------------------------------------------------------------------------");
////        System.out.println(customerList);
////        System.out.println("--------------------------------------------------------------------------------------");
////        System.out.println(skillList);
////        System.out.println("--------------------------------------------------------------------------------------");
////        System.out.println(companyList);
////        System.out.println("--------------------------------------------------------------------------------------");
////        System.out.println("/////////////////ALL/ALL//ALL/ALL//ALL/ALL//ALL/ALL//ALL/ALL//ALL/ALL//ALL/ALL//ALL/ALL/");
//
////        System.out.println("/////////////////BYID/BYID//BYID/BYID//BYID/BYID//BYID/BYID//BYID/BYID//BYID/BYID//BYID/BYID/");
////        System.out.println(developerList.get(0));
////        System.out.println(projectList.get(0));
////        System.out.println(companyList.get(0));
////        System.out.println(customerList.get(0));
////        System.out.println(skillList.get(0));
////        System.out.println("/////////////////BYID/BYID//BYID/BYID//BYID/BYID//BYID/BYID//BYID/BYID//BYID/BYID//BYID/BYID/");
////        System.out.println("/////////////////DELETE/DELETE/DELETE/DELETE/DELETE/DELETE/DELETE/DELETE/DELETE/DELETE/DELETE/DELETE/");
////developerList.remove(11);
//    //  session.delete(session.get(Developer.class, 12));
////        session.delete(session.get(Company.class, 1));
////        session.getTransaction().commit();
////        session.close();
//
////        List<Project> projectList = loadAllData(Project.class, session);
////        List<Company> companyList = loadAllData(Company.class, session);
////        List<Customer> customerList = loadAllData(Customer.class, session);
////        List<Skill> skillList = loadAllData(Skill.class, session);
////        List<Developer> developerList = loadAllData(Developer.class, session);
////        JpaCriteriaDelete<Developer> criteriaDelete = session.getCriteriaBuilder().createCriteriaDelete(Developer.class);
////        session.delete(session.get(Developer.class, 12));
////        System.out.println(developerList);
////        System.out.println(projectList);
////        System.out.println(companyList);
////        System.out.println(customerList);
////        System.out.println(skillList);
//
////session.createQuery(query.select(query.from(Developer.class)).where(id=));
////        Developer remove = developerList.remove(11);
////        System.out.println(remove);
////        System.out.println("________________________________________________________________");
////        List<Developer> developers = new ArrayList<>();
////        for (int i = 0; i < developerList.size(); i++) {
////            Developer developer = developerList.get(i);
//////            Set<Skill> skills = developer.getSkills();
////            List<Skill> skillsList = new ArrayList<>(developer.getSkills());
////            for (int j = 0; j < skillsList.size(); j++) {
////                Skill skill = skillsList.get(j);
////                String activities = skill.getActivities();
////                if (activities.equalsIgnoreCase("js")){
////                    System.out.println(developer.getSkills());
////                    developers.add(developer);
////                }
////            }
////        }
////        System.out.println(developers);
//
////        List<Developer> developers = new ArrayList<>();
////        Set<Skill> skills = developers.get(2).getSkills();
////            List<Skill> skillsList = new ArrayList<>(developers.get(2).getSkills());
////        System.out.println(skillsList.get(0));
////        for (int i = 0; i <developerList.size(); i++) {
////            Developer developer = developerList.get(i);
////            System.out.println(developer.getId());
////            System.out.println(developer.getSkills());
////            //            Set<Skill> skills = developer.getSkills();
////            List<Skill> skillsList = new ArrayList<>(developer.getSkills());
////
////            for (Skill skill : skillsList) {
////                String level = skill.getLevel();
////                System.out.println(level);
////                if (level.equalsIgnoreCase("middle")) {
//////                    System.out.println(developer.getSkills());
////                    developers.add(developer);
////                }
////            }
////        }
////
////        System.out.println(developers);
////
////        System.out.println("________________________________________________________________");
////        Company company = session.get(Company.class, 1L);
////        System.out.println(company);
////        Set<Project> projects = company.getProjects();
////        System.out.println(projects);
////        System.out.println("________________________________________________________________");
////
////        Customer customer = session.get(Customer.class, 4L);
////        System.out.println(customer);
////        Set<Project> projects2 = customer.getProjects();
////        System.out.println(projects2);
////        System.out.println("________________________________________________________________");
////        Project project = session.get(Project.class, 1L);
////        Set<Developer> developers = project.getDevelopers();
////        System.out.println(project);
////        List<Developer> developerList = developers.stream().collect(Collectors.toList());
////        System.out.println(developerList);
////        Long totalSalaries = 0L;
////        for (int i = 0; i < developerList.size(); i++) {
////            Long salary = developerList.get(i).getSalary();
////            totalSalaries = totalSalaries + salary;
////        }
////        System.out.println(totalSalaries);
////        System.out.println("________________________________________________________________");
////        Skill skill = session.get(Skill.class, 11L);
////        Set<Developer> developers1 = skill.getDevelopers();
////        System.out.println(skill);
////        System.out.println(developers1);
////        System.out.println("________________________________________________________________");
////        Developer developer = session.get(Developer.class, 1L);
////        Set<Project> projects3 = developer.getProjects();
////        System.out.println(developer);
////        System.out.println(projects3);
////        System.out.println("________________________________________________________________");
////        Set<Skill> skills = developer.getSkills();
////        System.out.println(skills);
////        Set<Customer> customers = project.getCustomers();
////        Set<Project> projects = project.getProjects();
////        Set<Developer> developers = project.getDevelopers();
//
////        System.out.println(customers);
////        System.out.println(projects);
////        System.out.println(developers);
//
////        Customer customer = session.get(Customer.class, 1L);
////        System.out.println(customer);
////
////        Skill skill = session.get(Skill.class, 1L);
////        System.out.println(skill);
//
////        Project project = session.get(Project.class, 1L);
////        System.out.println(project);
////
////        Developer developer = session.get(Developer.class, 1L);
////        System.out.println(developer);
////        Project project = developer.getProject();
////        System.out.println(project);
//
////        System.out.println("________________________________________________________________");
////
////        System.out.println("________________________________________________________________");
//
////        System.out.println("*****************************************************************************");
/////// GET ALL
////        System.out.println(companyList);
////
////        System.out.println(developerList);
////
////        System.out.println(projectList);
//////
////        System.out.println(customerList);
//////
////        System.out.println(skillList);
////////  GET BY ID
////        System.out.println(" BY ID ");
//
////        System.out.println(companyList.get(0));
////
////        System.out.println(developerList.get(0));
////
////        System.out.println(projectList.get(0));
////
////        System.out.println(customerList.get(0));
////
////        System.out.println(skillList.get(0));
//
//
////
////        Session session1 = HibernateSessionFactory.getSessionFactory().openSession();
////        session1.beginTransaction();
//
////        Company company = session1.get(Company.class, 4);
////        session1.remove(company);
////
////        session1.getTransaction().commit();
////        session1.close();
////
////        Session session2 = HibernateSessionFactory.getSessionFactory().openSession();
////        session2.beginTransaction();
////////JPQL vs HQL vs SQL  - чтобы не писать SQL запросы
////        List<Project> loadAllData1 = findAllWithJpql2(Project.class, session2);
////        System.out.println(loadAllData1);
////
////        List<Company> loadAllData = findAllWithJpql(Company.class, session2);
////        System.out.println(loadAllData);
////
////        session2.getTransaction().commit();
////        session2.close();
//
//    //
////    private static <T> List<T> findAllWithJpql(Class<T> type, Session session) {
////        return session.createQuery("SELECT d FROM Developer d", type).getResultList();
////    }
////
////    private static <T> List<T> findAllWithJpql2(Class<T> type, Session session) {
////        return session.createQuery("SELECT p FROM Project p", type).getResultList();
////    }
//

//
//}
