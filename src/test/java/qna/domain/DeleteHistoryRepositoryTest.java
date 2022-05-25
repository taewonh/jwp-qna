package qna.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class DeleteHistoryRepositoryTest {

    @Autowired
    private DeleteHistoryRepository deleteHistoryRepository;

    @Autowired
    private UserRepository userRepository;

    @DisplayName("삭제내역을 저장한다.")
    @Test
    void save() {
        //given
        User user = userRepository.save(UserTest.JAVAJIGI);
        final DeleteHistory deleteHistory = DeleteHistory.ofQuestion(1L, user, null);
        final DeleteHistory expected = deleteHistoryRepository.save(deleteHistory);

        //when
        final List<DeleteHistory> actual = deleteHistoryRepository.findAll();

        //then
        assertAll(
                () -> assertThat(actual).hasSize(1),
                () -> assertThat(actual.get(0)).isSameAs(expected)
        );
    }
}
