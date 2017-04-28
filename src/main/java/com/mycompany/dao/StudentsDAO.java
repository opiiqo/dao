/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author W208412665
 */
@Component
public class StudentsDAO {

    // Injected database connection:
    @PersistenceContext
    private EntityManager em;

    // Stores a new guest:
    @Transactional
    public void persist(Students students) {
        em.persist(students);
    }

    // Retrieves all the guests:
    public List<Students> getAllGuests() {
        TypedQuery<Students> query = em.createQuery(
                "SELECT s FROM Students s ORDER BY s.id", Students.class);
        return query.getResultList();
    }
}
