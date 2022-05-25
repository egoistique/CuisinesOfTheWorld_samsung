package com.samsung.repository;

import com.samsung.domain.Country;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Класс CountryDaoJPA")
@DataJpaTest
class CountryRepositoryTest {

    public static final int EXISTING_COUNTRY_COUNT = 3;
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
    void shouldInsertCountry() {

        Country expectedCountry = Country.builder()
                .id(4)
                .name("Ivan")
                .build();

        dao.save(expectedCountry);
        Country actualCountry = dao.getById(4);

        assertThat(actualCountry).isEqualTo(expectedCountry);
    }

    @DisplayName("должен обновлять автора")
    @Test
    void shouldUpdateCountry() {
        Country expectedCountry1 = Country.builder()
                .id(EXISTING_ID1)
                .name("Ivan")
                .build();

        dao.save(expectedCountry1);
        Country actualCountry = dao.getById(EXISTING_ID1);

        assertThat(actualCountry).isEqualTo(expectedCountry1);
    }

    @DisplayName("должен возвращать всех авторов")
    @Test
    void shouldGetAllCountrys() {

        Country expectedCountry1 = Country.builder()
                .id(EXISTING_ID1)
                .name(EXISTING_NAME1)
                .build();
        Country expectedCountry2 = Country.builder()
                .id(EXISTING_ID2)
                .name(EXISTING_NAME2)
                .build();
        Country expectedCountry3 = Country.builder()
                .id(EXISTING_ID3)
                .name(EXISTING_NAME3)
                .build();

        assertThat(dao.findAll().size()).isEqualTo(EXISTING_COUNTRY_COUNT);
        assertThat(dao.findAll())
                .containsExactlyInAnyOrder(expectedCountry1, expectedCountry2, expectedCountry3);
    }

    @DisplayName("должен возвращать автора по id")
    @Test
    void shouldGetCountryById() {

        Country expectedCountry = Country.builder()
                .id(EXISTING_ID1)
                .name(EXISTING_NAME1)
                .build();

        Country actualCountry = dao.getById(EXISTING_ID1);

        assertThat(actualCountry).isEqualTo(expectedCountry);
    }

    @DisplayName("должен возвращать автора по имени")
    @Test
    void shouldGetCountryByName() {

        Country expectedCountry = Country.builder()
                .id(EXISTING_ID1)
                .name(EXISTING_NAME1)
                .build();

        Country actualCountry = dao.findByName(EXISTING_NAME1);

        assertThat(actualCountry).isEqualTo(expectedCountry);
    }

    @DisplayName("должен удалять автора по id")
    @Test
    void shouldDeleteCountryById() {

        int sizeBefore = dao.findAll().size();

        dao.deleteById(EXISTING_ID1);
        entityManager.flush();

        int sizeAfter = dao.findAll().size();
        assertThat(sizeBefore - sizeAfter).isEqualTo(1);
    }
}
