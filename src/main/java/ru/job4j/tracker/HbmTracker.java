package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;
import java.util.function.Function;

public class HbmTracker implements Store, AutoCloseable {
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    private <T> T execute(Function<Session, T> command) {
        Session session = sf.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            T result = command.apply(session);
            transaction.commit();
            return result;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public Item add(Item item) {
        return execute(session -> {
            session.save(item);
            return item;
        });
    }

    @Override
    public boolean replace(int id, Item item) {
        Integer updatedCount = execute(session -> {
            Query query = session.createQuery("UPDATE Item SET name = :name WHERE id = :id");
            query.setParameter("name", item.getName());
            query.setParameter("id", id);
            return query.executeUpdate();
        });
        return updatedCount > 0;
    }

    @Override
    public void delete(int id) {
        execute(session -> {
            Query query = session.createQuery("DELETE Item WHERE id = :id");
            query.setParameter("id", id);
            return query.executeUpdate();
        });
    }

    @Override
    public List<Item> findAll() {
        return execute(session -> {
            Query<Item> query = session.createQuery("FROM Item ORDER BY id", Item.class);
            return query.list();
        });
    }

    @Override
    public List<Item> findByName(String key) {
        return execute(session -> {
            Query<Item> query = session.createQuery(
                    "FROM Item WHERE name LIKE :name ORDER BY id", Item.class
            );
            query.setParameter("name", "%" + key + "%");
            return query.list();
        });
    }

    @Override
    public Item findById(int id) {
        return execute(session -> {
            Query<Item> query = session.createQuery("FROM Item WHERE id = :id", Item.class);
            query.setParameter("id", id);
            return query.uniqueResult();
        });
    }

    @Override
    public void close() {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}