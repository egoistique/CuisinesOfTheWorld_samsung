//package com.sasmsung.repository;
//
//import com.samsung.App;
//import com.samsung.domain.Country;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//
//@DisplayName("Класс CountryRepositoryJPA")
//@DataJpaTest
////@SpringBootTest(classes = App.class)
//class CountryRepositoryTest {
//
//    public static final int EXISTING_AUTHOR_COUNT = 3;
//    public static final int EXISTING_ID1 = 1;
//    public static final String EXISTING_NAME1 = "Сергей Лукьяненко";
//    public static final int EXISTING_ID2 = 2;
//    public static final int EXISTING_ID3 = 3;
//    public static final String EXISTING_NAME2 = "Александр Сергеевич Грибоедов";
//    public static final String EXISTING_NAME3 = "Гарри Гаррисон";
//
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Autowired
//    private CountryRepository countryRepository;
//
//    @DisplayName("должен добавлять страну")
//    @Test
//    void shouldInsertCountry() {
//
//        Country expectedCountry = Country.builder()
//                .id(4)
//                .name("Франция")
//                .build();
//
//        countryRepository.save(expectedCountry);
//        Country actualCountry = countryRepository.getById(4);
//
//        assertThat(actualCountry).isEqualTo(expectedCountry);
//    }
//
//    @DisplayName("должен обновлять автора")
//    @Test
//    void shouldUpdateAuthor() {
//        Country expectedCountry1 = Country.builder()
//                .id(EXISTING_ID1)
//                .name("Ivan")
//                .build();
//
//        countryRepository.save(expectedCountry1);
//        Country actualCountry = countryRepository.getById(EXISTING_ID1);
//
//        assertThat(actualCountry).isEqualTo(expectedCountry1);
//    }
//
//    @DisplayName("должен возвращать всех авторов")
//    @Test
//    void shouldGetAllAuthors() {
//
//        Country expectedAuthor1 = Country.builder()
//                .id(EXISTING_ID1)
//                .name(EXISTING_NAME1)
//                .build();
//        Country expectedAuthor2 = Country.builder()
//                .id(EXISTING_ID2)
//                .name(EXISTING_NAME2)
//                .build();
//        Country expectedAuthor3 = Country.builder()
//                .id(EXISTING_ID3)
//                .name(EXISTING_NAME3)
//                .build();
//
//        assertThat(countryRepository.findAll().size()).isEqualTo(EXISTING_AUTHOR_COUNT);
//        assertThat(countryRepository.findAll())
//                .containsExactlyInAnyOrder(expectedAuthor1, expectedAuthor2, expectedAuthor3);
//    }
//
//    @DisplayName("должен возвращать автора по id")
//    @Test
//    void shouldGetAuthorById() {
//
//        Country expectedAuthor = Country.builder()
//                .id(EXISTING_ID1)
//                .name(EXISTING_NAME1)
//                .build();
//
//        Country actualAuthor = countryRepository.getById(EXISTING_ID1);
//
//        assertThat(actualAuthor).isEqualTo(expectedAuthor);
//    }
//
//    @DisplayName("должен возвращать автора по имени")
//    @Test
//    void shouldGetAuthorByName() {
//
//        Country expectedAuthor = Country.builder()
//                .id(EXISTING_ID1)
//                .name(EXISTING_NAME1)
//                .build();
//
//        Country actualAuthor = countryRepository.findByName(EXISTING_NAME1);
//
//        assertThat(actualAuthor).isEqualTo(expectedAuthor);
//    }
//
//    @DisplayName("должен удалять автора по id")
//    @Test
//    void shouldDeleteAuthorById() {
//
//        int sizeBefore = countryRepository.findAll().size();
//
//        countryRepository.deleteById(EXISTING_ID1);
//        entityManager.flush();
//
//        int sizeAfter = countryRepository.findAll().size();
//        assertThat(sizeBefore - sizeAfter).isEqualTo(1);
//    }
//}
