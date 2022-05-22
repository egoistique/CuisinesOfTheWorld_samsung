package com.samsung.repository;

import com.samsung.domain.Country;
import com.samsung.repository.CountryRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Класс AuthorDaoJPA")
@DataJpaTest
class AuthorDaoJPATest {

    public static final int EXISTING_AUTHOR_COUNT = 3;
    public static final int EXISTING_ID1 = 1;
    public static final String EXISTING_NAME1 = "Россия";
    public static final int EXISTING_ID2 = 2;
    public static final int EXISTING_ID3 = 3;
    public static final String EXISTING_NAME2 = "Италия";
    public static final String EXISTING_NAME3 = "Франция";

    @Autowired
    private CountryRepository dao;

    @PersistenceContext
    private EntityManager entityManager;

    @DisplayName("должен добавлять автора")
    @Test
    void shouldInsertAuthor() {

        Country expectedAuthor = Country.builder()
                .id(4)
                .name("Ivan")
                .build();

        dao.save(expectedAuthor);
        Country actualAuthor = dao.getById(4);

        assertThat(actualAuthor).isEqualTo(expectedAuthor);
    }

    @DisplayName("должен обновлять автора")
    @Test
    void shouldUpdateAuthor() {
        Country expectedAuthor1 = Country.builder()
                .id(EXISTING_ID1)
                .name("Ivan")
                .build();

        dao.save(expectedAuthor1);
        Country actualAuthor = dao.getById(EXISTING_ID1);

        assertThat(actualAuthor).isEqualTo(expectedAuthor1);
    }

    @DisplayName("должен возвращать всех авторов")
    @Test
    void shouldGetAllAuthors() {

        Country expectedAuthor1 = Country.builder()
                .id(EXISTING_ID1)
                .name(EXISTING_NAME1)
                .build();
        Country expectedAuthor2 = Country.builder()
                .id(EXISTING_ID2)
                .name(EXISTING_NAME2)
                .build();
        Country expectedAuthor3 = Country.builder()
                .id(EXISTING_ID3)
                .name(EXISTING_NAME3)
                .build();

        assertThat(dao.findAll().size()).isEqualTo(EXISTING_AUTHOR_COUNT);
        assertThat(dao.findAll())
                .containsExactlyInAnyOrder(expectedAuthor1, expectedAuthor2, expectedAuthor3);
    }

    @DisplayName("должен возвращать автора по id")
    @Test
    void shouldGetAuthorById() {

        Country expectedAuthor = Country.builder()
                .id(EXISTING_ID1)
                .name(EXISTING_NAME1)
                .build();

        Country actualAuthor = dao.getById(EXISTING_ID1);

        assertThat(actualAuthor).isEqualTo(expectedAuthor);
    }

    @DisplayName("должен возвращать автора по имени")
    @Test
    void shouldGetAuthorByName() {

        Country expectedAuthor = Country.builder()
                .id(EXISTING_ID1)
                .name(EXISTING_NAME1)
                .build();

        Country actualAuthor = dao.findByName(EXISTING_NAME1);

        assertThat(actualAuthor).isEqualTo(expectedAuthor);
    }

    @DisplayName("должен удалять автора по id")
    @Test
    void shouldDeleteAuthorById() {

        int sizeBefore = dao.findAll().size();

        dao.deleteById(EXISTING_ID1);
        entityManager.flush();

        int sizeAfter = dao.findAll().size();
        assertThat(sizeBefore - sizeAfter).isEqualTo(1);
    }
}
